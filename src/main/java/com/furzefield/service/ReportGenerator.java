package com.furzefield.service;

import com.furzefield.model.Lesson;

public class ReportGenerator {

    private BookingSystem bookingSystem;

    public ReportGenerator(BookingSystem bookingSystem){
        this.bookingSystem = bookingSystem;
    }

    // Monthly lesson report:
    // Number of attended members + average rating per lesson
    public void printMonthlyLessonReport(int monthNumber){
        System.out.println("Monthly Lesson Report - Month: " + monthNumber);
    }

    // Champion exercise type report;
    // total income per exercise type, highlight highest
    public void printChampionReport(int monthNumber){
        System.out.println("Champion Report - Month: " + monthNumber);
    }

    //average rating for a spacific lesson
    public double calculateAverageRating(Lesson lesson){
        return 0.0;
    }

    //total income for an exercise type in a given month
    public double calculateIncomeByType(String exerciseType, int monthNumer){
        return 0.0;
    }
}
