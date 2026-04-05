package com.furzefield.service;

import com.furzefield.model.Booking;
import com.furzefield.model.BookingStatus;
import com.furzefield.model.Lesson;

import java.util.*;

public class ReportGenerator {

    private BookingSystem bookingSystem;

    public ReportGenerator(BookingSystem bookingSystem){
        this.bookingSystem = bookingSystem;
    }

    // Monthly lesson report:
    // Number of attended members + average rating per lesson
    public void printMonthlyLessonReport(int monthNumber){
        System.out.println("Monthly Lesson Report - Month: " + monthNumber);

        // Get all lessons for this month
        List<Lesson> monthLessons = new ArrayList<>();
        for (Lesson l : bookingSystem.getLessons()) {
            if (l.getMonthNumber() == monthNumber) {
                monthLessons.add(l);
            }
        }

        if (monthLessons.isEmpty()) {
            System.out.println("No lessons found for month" + monthNumber );
            return;
        }

        // Group lessons by week number for neat display
        int currentWeek = -1;
        for (Lesson lesson : monthLessons) {

            if (lesson.getWeekNumber() != currentWeek) {
                currentWeek = lesson.getWeekNumber();
                System.out.println("\n--- Week" + currentWeek + "---");
            }

            // Count attended bookings for this lesson
            int attendedCount = 0;
            double totalRating = 0;

            for (Booking b : bookingSystem.getBookings()) {
                boolean sameLesson = b.getLesson().getLessonId()
                        .equals(lesson.getLessonId());
                boolean attended = b.getStatus() == BookingStatus.ATTENDED;
                if (sameLesson && attended) {
                    attendedCount++;
                    totalRating += b.getRating();
                }
            }

            // Calculate average rating
            double avgRating = attendedCount > 0 ? totalRating / attendedCount : 0.0;

            // Print lesson row
            System.out.printf("  [%s] %-10s | %-9s | %-9s | Attended: %d/4 | Avg Rating: %.1f%n",
                    lesson.getLessonId(),
                    lesson.getExcerciseType(),
                    lesson.getDay(),
                    lesson.getTimeSlot(),
                    attendedCount,
                    avgRating);
        }

        System.out.println("\n===============================");
    }

    // Champion exercise type report;
    // total income per exercise type, highlight highest
    public void printChampionReport(int monthNumber){

        System.out.println("Champion Report - Month: " + monthNumber);

        // Get all exercise types in this month
        Set<String> exerciseTypes = new LinkedHashSet<>();
        for (Lesson l : bookingSystem.getLessons()) {
            if (l.getMonthNumber() == monthNumber) {
                exerciseTypes.add(l.getExcerciseType());
            }
        }

        if (exerciseTypes.isEmpty()) {
            System.out.println("No lessons found for month " + monthNumber + ".");
            return;
        }

        // Calculate income per exercise type
        Map<String, Double> incomeMap = new LinkedHashMap<>();
        for (String type : exerciseTypes) {
            double income = calculateIncomeByType(type, monthNumber);
            incomeMap.put(type, income);
        }

        // Find the champion (highest income)
        String champion = null;
        double highestIncome = -1;
        for (Map.Entry<String, Double> entry : incomeMap.entrySet()) {
            if (entry.getValue() > highestIncome) {
                highestIncome = entry.getValue();
                champion = entry.getKey();
            }
        }

        // Print income table
        System.out.println("\n  Exercise Type   | Total Income");
        System.out.println("*********************************************");
        for (Map.Entry<String, Double> entry : incomeMap.entrySet()) {
            String marker = entry.getKey().equals(champion) ? " ★ CHAMPION" : "";
            System.out.printf("  %-16s | £%8.2f%s%n",
                    entry.getKey(),
                    entry.getValue(),
                    marker);
        }

        System.out.println("=========================================");
        System.out.printf("%n   Champion: %s with £%.2f total income%n",
                champion, highestIncome);
        System.out.println("\n========================================");

    }

    //average rating for a spacific lesson
    public double calculateAverageRating(Lesson lesson){

        int count = 0;
        double total = 0;
        for (Booking b : bookingSystem.getBookings()) {
            boolean sameLesson = b.getLesson().getLessonId()
                    .equals(lesson.getLessonId());
            boolean attended = b.getStatus() == BookingStatus.ATTENDED;
            if (sameLesson && attended) {
                count++;
                total += b.getRating();
            }
        }
        return count > 0 ? total / count : 0.0;
    }

    //total income for an exercise type in a given month
    public double calculateIncomeByType(String exerciseType, int monthNumber) {
        double totalIncome = 0;
        for (Booking b : bookingSystem.getBookings()) {
            boolean sameType = b.getLesson().getExcerciseType()
                    .equalsIgnoreCase(exerciseType);
            boolean sameMonth = b.getLesson().getMonthNumber() == monthNumber;
            boolean attended = b.getStatus() == BookingStatus.ATTENDED;
            if (sameType && sameMonth && attended) {
                totalIncome += b.getLesson().getPrice();
            }
        }
        return totalIncome;
    }
}
