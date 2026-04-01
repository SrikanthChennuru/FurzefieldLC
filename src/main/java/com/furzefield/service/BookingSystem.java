package com.furzefield.service;

import com.furzefield.model.Booking;
import com.furzefield.model.Lesson;
import com.furzefield.model.Member;

import java.util.ArrayList;
import java.util.List;

public class BookingSystem
{
    private List<Member> members;
    private List<Lesson> lessons;
    private List<Booking> bookings;
    private int bookingCounter;

    public BookingSystem()
    {
        this.members = new ArrayList<>();
        this.lessons = new ArrayList<>();
        this.bookingCounter = 1;
    }

    public void initialiseTimetable()
    {

    }

    public void initialiseMembers()
    {

    }

    private String generateBookingId()
    {
        return "B" + String.format("%03d",bookingCounter++);
    }

    public boolean bookLesson(String memberId, String lessonId)
    {
        return false;
    }

    public boolean changeBooking(String bookingId, String newLessonId)
    {
        return false;
    }

    public boolean cancelBooking(String bookingId)
    {
        return false;
    }

    public boolean attendLesson(String bookingId, String review, int rating)
    {
        return false;
    }

    public List<Lesson> getLessonsByDay(String day)
    {
        return new ArrayList<>();
    }

    public List<Lesson> getLessonsByExerciseType(String exerciseType)
    {
        return new ArrayList<>();
    }

    public List<Member> getMembers() {
        return members;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public List<Lesson> getLessons() {
        return lessons;
    }

    public Member findMemberById(String memberId){
        return members.stream()
                .filter(m -> m.getMemberId().equals(memberId))
                .findFirst().orElse(null);
    }

    public Lesson findLessonById(String lessonId){
        return lessons.stream()
                .filter(l -> l.getLessonId().equals(lessonId))
                .findFirst().orElse(null);
    }

    public Booking findBookingById(String bookingId){
        return bookings.stream()
                .filter(b -> b.getBookingId().equals(bookingId))
                .findFirst().orElse(null);
    }
}
