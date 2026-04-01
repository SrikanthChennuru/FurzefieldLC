package com.furzefield.model;

import java.util.ArrayList;
import java.util.List;

public class Member {

    private String memberId;
    private String name;
    private String email;
    private List<Booking> bookings;

    public Member(String memberId, String name, String email) {
        this.memberId = memberId;
        this.name = name;
        this.email = email;
        this.bookings = new ArrayList<>();
    }

    public String getMemberId() {
        return memberId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void addBooking(Booking booking)
    {
        bookings.add(booking);
    }

    public void removeBooking(Booking booking)
    {
        bookings.remove(booking);
    }

    @Override
    public String toString()
    {
        return "[" + memberId +"]" + name;
    }
}
