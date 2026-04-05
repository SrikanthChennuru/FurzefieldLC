package com.furzefield;

import com.furzefield.model.*;
import com.furzefield.service.BookingSystem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BookingSystemTest {

    private BookingSystem bookingSystem;

    @BeforeEach
    void setUp() {
        bookingSystem = new BookingSystem();
        bookingSystem.initialiseTimetable();
        bookingSystem.initialiseMembers();
    }

    // Test 1: Successful booking
    // A valid member booking a lesson with available space
    // should return a SUCCESS message and increase the booked count

    @Test
    void testBookLesson_SuccessfulBooking() {
        String result = bookingSystem.bookLesson("M001", "L001");

        assertTrue(result.startsWith("SUCCESS"),
        "Expected SUCCESS but got : " + result);

        Lesson lesson = bookingSystem.findLessonById("L001");
        assertEquals(1, lesson.getBookedCount(),
                "Booked count should be 1 after one booking");

    }

    // Test 2: Duplicate booking is prevented
    // The same member booking the same lesson twice
    // Should be rejected with an ERROR message
    @Test
    void testBookLesson_DuplicateBookingPrevented() {
        // First booking should succeed
        bookingSystem.bookLesson("M001", "L001");

        // Second booking for same member and lesson should fail
        String result = bookingSystem.bookLesson("M001", "L001");

        assertTrue(result.startsWith("ERROR"),
                "Expected ERROR for duplicate booking but got: " + result);
    }

    // Test 3: Capacity constraint is enforced
    // Booking a lesson that already has 4 members
    // should be rejected with an ERROR message

    @Test
    void testBookLesson_CapacityViolationPrevented() {

        bookingSystem.bookLesson("M001", "L001");
        bookingSystem.bookLesson("M002", "L001");
        bookingSystem.bookLesson("M003", "L001");
        bookingSystem.bookLesson("M004", "L001");

        // 5th member tries to book - should fail
        String result = bookingSystem.bookLesson("M005", "L001");

        assertTrue(result.startsWith("ERROR"),
                "Expected ERROR when lesson is full but got: " + result);

        Lesson lesson = bookingSystem.findLessonById("L001");
        assertEquals(4, lesson.getBookedCount(),
                "Booked count should remain at 4 after failed booking");
    }

    // ── Test 4: Cancelling a booking releases the place ───────────────
    // After cancelling a booking the lesson's booked count
    // should decrease by 1 and the booking status should be CANCELLED

    @Test
    void testCancelBooking_ReleasesPlace() {
        // Book a lesson first
        bookingSystem.bookLesson("M001", "L001");
        Lesson lesson = bookingSystem.findLessonById("L001");
        assertEquals(1, lesson.getBookedCount(),
                "Booked count should be 1 before cancellation");

        // Cancel the booking
        String result = bookingSystem.cancelBooking("B001");

        assertTrue(result.startsWith("SUCCESS"),
                "Expected SUCCESS for valid cancellation but got: " + result);

        assertEquals(0, lesson.getBookedCount(),
                "Booked count should be 0 after cancellation");

        Booking booking = bookingSystem.findBookingById("B001");
        assertEquals(BookingStatus.CANCELLED, booking.getStatus(),
                "Booking status should be CANCELLED");
    }

    // ── Test 5: Monthly report only counts attended bookings ──────────
    // A member who booked but did not attend
    // should NOT be counted in the monthly lesson report

    @Test
    void testAttendLesson_OnlyAttendedCountedInReport() {
        // Book two lessons
        bookingSystem.bookLesson("M001", "L001");
        bookingSystem.bookLesson("M002", "L001");

        // Only M001 attends
        bookingSystem.attendLesson("B001", "Great class!", 5);

        // Count attended bookings for L001
        long attendedCount = bookingSystem.getBookings().stream()
                .filter(b -> b.getLesson().getLessonId().equals("L001"))
                .filter(b -> b.getStatus() == BookingStatus.ATTENDED)
                .count();

        assertEquals(1, attendedCount,
                "Only 1 member attended — booked-only members should not be counted");

        // Verify the attending member has correct rating
        Booking attendedBooking = bookingSystem.findBookingById("B001");
        assertEquals(5, attendedBooking.getRating(),
                "Rating should be 5 as submitted");
        assertEquals(BookingStatus.ATTENDED, attendedBooking.getStatus(),
                "Status should be ATTENDED");

        // Verify the non-attending member is still BOOKED
        Booking notAttendedBooking = bookingSystem.findBookingById("B002");
        assertEquals(BookingStatus.BOOKED, notAttendedBooking.getStatus(),
                "Status should still be BOOKED for member who did not attend");
    }


}
