package com.furzefield.model;

public class Booking {

    private String bookingId;
    private Member member;
    private Lesson lesson;
    private BookingStatus status;
    private String review;
    private int rating;

    public Booking(String bookingId, Member member, Lesson lesson) {
        this.bookingId = bookingId;
        this.member = member;
        this.lesson = lesson;
        this.status = BookingStatus.BOOKED;
        this.review = null;
        this.rating = 0;
    }

    public String getBookingId() {
        return bookingId;
    }

    public Member getMember() {
        return member;
    }

    public Lesson getLesson() {
        return lesson;
    }

    public BookingStatus getStatus() {
        return status;
    }

    public String getReview() {
        return review;
    }

    public int getRating() {
        return rating;
    }

    public void setStatus(BookingStatus status) {
        this.status = status;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public String toString(){
        return String.format("[%s] %s → %s (%s)",
                bookingId,member.getName(),
                lesson.getExcerciseType(),status);
    }
}
