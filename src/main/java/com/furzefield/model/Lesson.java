package com.furzefield.model;

public class Lesson
{
    private static final int MAX_CAPACITY =4;

    private String lessonId;
    private String excerciseType;
    private String day;
    private int weekNumber;
    private int monthNumber;
    private TimeSlot timeSlot;
    private double price;
    private int bookedCount;

    public Lesson(String lessonId, String excerciseType, String day, int weekNumber, int monthNumber, TimeSlot timeSlot, double price) {
        this.lessonId = lessonId;
        this.excerciseType = excerciseType;
        this.day = day;
        this.weekNumber = weekNumber;
        this.monthNumber = monthNumber;
        this.timeSlot = timeSlot;
        this.price = price;
        this.bookedCount = 0;
    }

    public String getLessonId() {
        return lessonId;
    }

    public String getExcerciseType() {
        return excerciseType;
    }

    public String getDay() {
        return day;
    }

    public int getWeekNumber() {
        return weekNumber;
    }

    public int getMonthNumber() {
        return monthNumber;
    }

    public TimeSlot getTimeSlot() {
        return timeSlot;
    }

    public double getPrice() {
        return price;
    }

    public int getBookedCount() {
        return bookedCount;
    }

    public boolean hasSpace()
    {
        return bookedCount < MAX_CAPACITY;
    }

    public void incrementBookedCount()
    {
        bookedCount++;
    }

    public void decrementBookedCount()
    {
        if (bookedCount > 0)
            bookedCount--;
    }

    public int getAvailableSpaces()
    {
        return MAX_CAPACITY - bookedCount;
    }

    @Override
    public String toString()
    {
        return String.format("[%s] %s | %s Week %d | %s | £%.2f | Spaces: %d/4",
                lessonId,excerciseType,day,weekNumber,timeSlot,price,getAvailableSpaces());
    }
}
