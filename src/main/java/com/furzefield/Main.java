package com.furzefield;


import com.furzefield.model.*;
import com.furzefield.service.BookingSystem;
import com.furzefield.service.ReportGenerator;

import java.util.List;
import java.util.Scanner;

public class Main {

    private static BookingSystem bookingSystem = new BookingSystem();
    private static ReportGenerator reportGenerator = new ReportGenerator(bookingSystem);
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){
        bookingSystem.initialiseTimetable();
        bookingSystem.initialiseMembers();

        System.out.println("Welcome to Furzefield Leisure Centre");

        boolean running = true;
        while (running){
            printMenu();
            String choice = scanner.nextLine().trim();
            switch (choice){
                case "1" -> bookLesson();
                case "2" -> changeBooking();
                case "3" -> cancelBooking();
                case "4" -> attendLesson();
                case "5" -> monthlyLessonReport();
                case "6" -> championReport();
                case "0" -> { running = false; System.out.println("Thank you for using FLC Booking System. Goodbye!");}
                default -> System.out.println("Invalid option. Please try again.");
            }

        }
        scanner.close();
    }

    private static void printMenu() {
        System.out.println("\n====== Main Menu ======");
        System.out.println("1. Book a group exercise lesson");
        System.out.println("2. Change a booking");
        System.out.println("3. Cancel a booking");
        System.out.println("4. Attend a lesson");
        System.out.println("5. Monthly lesson report");
        System.out.println("6. Monthly champion lesson type report");
        System.out.println("0. Exit");
        System.out.println("Enter your choice: ");
    }

    private static void bookLesson(){

        System.out.println("\n Book a Lesson ");

        // Show all members
        System.out.println("Registered Members:");
        for (Member m : bookingSystem.getMembers()) {
            System.out.println("  " + m);
        }

        // Get member ID
        System.out.print("Enter your Member ID: ");
        String memberId = scanner.nextLine().trim();

        // Choose timetable view
        System.out.println("\nHow would you like to view the timetable?");
        System.out.println("1. By day (Saturday / Sunday)");
        System.out.println("2. By exercise type");
        System.out.print("Enter choice: ");
        String viewChoice = scanner.nextLine().trim();

        List<Lesson> displayedLessons;

        if (viewChoice.equals("1")) {
            System.out.print("Enter day (Saturday / Sunday): ");
            String day = scanner.nextLine().trim();
            displayedLessons = bookingSystem.getLessonsByDay(day);
            if (displayedLessons.isEmpty()) {
                System.out.println("No lessons found for: " + day);
                return;
            }
            System.out.println("\nLessons on " + day + ":");

        } else if (viewChoice.equals("2")) {
            System.out.print("Enter exercise type (Yoga / Zumba / Aquacise / BoxFit / BodyBlitz): ");
            String type = scanner.nextLine().trim();
            displayedLessons = bookingSystem.getLessonsByExerciseType(type);
            if (displayedLessons.isEmpty()) {
                System.out.println("No lessons found for: " + type);
                return;
            }
            System.out.println("\nLessons for " + type + ":");

        } else {
            System.out.println("Invalid choice.");
            return;
        }

        // Display lessons
        for (Lesson l : displayedLessons) {
            System.out.println("  " + l);
        }

        // Get lesson ID
        System.out.print("\nEnter Lesson ID to book: ");
        String lessonId = scanner.nextLine().trim();

        // Book and show result
        String result = bookingSystem.bookLesson(memberId, lessonId);
        System.out.println(result);

    }

    private static void changeBooking(){

        System.out.println("\n Change a Booking ");

        // Show all active bookings
        printActiveBookings();

        System.out.print("Enter Booking ID to change: ");
        String bookingId = scanner.nextLine().trim();

        // Choose new lesson
        System.out.println("\nHow would you like to view the timetable?");
        System.out.println("1. By day (Saturday / Sunday)");
        System.out.println("2. By exercise type");
        System.out.print("Enter choice: ");
        String viewChoice = scanner.nextLine().trim();

        List<Lesson> displayedLessons;

        if (viewChoice.equals("1")) {
            System.out.print("Enter day (Saturday / Sunday): ");
            String day = scanner.nextLine().trim();
            displayedLessons = bookingSystem.getLessonsByDay(day);
            System.out.println("\nLessons on " + day + ":");
        } else if (viewChoice.equals("2")) {
            System.out.print("Enter exercise type: ");
            String type = scanner.nextLine().trim();
            displayedLessons = bookingSystem.getLessonsByExerciseType(type);
            System.out.println("\nLessons for " + type + ":");
        } else {
            System.out.println("Invalid choice.");
            return;
        }

        if (displayedLessons.isEmpty()) {
            System.out.println("No lessons found.");
            return;
        }

        for (Lesson l : displayedLessons) {
            System.out.println("  " + l);
        }

        System.out.print("\nEnter new Lesson ID: ");
        String newLessonId = scanner.nextLine().trim();

        String result = bookingSystem.changeBooking(bookingId, newLessonId);
        System.out.println(result);
    }

    private static void cancelBooking(){
        System.out.println("\n Cancel a Booking");
        printActiveBookings();

        System.out.println("Enter Booking ID to Cancel: ");
        String bookingId = scanner.nextLine().trim();

        String result = bookingSystem.cancelBooking(bookingId);
        System.out.println(result);
    }
    private static void attendLesson(){

        System.out.println("\n Attend a Lesson ");

        printActiveBookings();

        System.out.print("Enter Booking ID: ");
        String bookingId = scanner.nextLine().trim();

        System.out.print("Write your review: ");
        String review = scanner.nextLine().trim();

        int rating = 0;
        while (rating < 1 || rating > 5) {
            System.out.print("Enter your rating (1=Very Dissatisfied, 2=Dissatisfied, 3=Ok, 4=Satisfied, 5=Very Satisfied): ");
            try {
                rating = Integer.parseInt(scanner.nextLine().trim());
                if (rating < 1 || rating > 5) {
                    System.out.println("Please enter a number between 1 and 5.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }

        String result = bookingSystem.attendLesson(bookingId, review, rating);
        System.out.println(result);
    }

    private static void monthlyLessonReport(){

        System.out.println("\n Monthly Lesson report ");
        System.out.println("Enter month number (1 or 2) : ");
        try {
            int month = Integer.parseInt(scanner.nextLine().trim());
            reportGenerator.printMonthlyLessonReport(month);
        } catch (NumberFormatException e) {
            System.out.println("Invalid month number.");
        }
    }

    private static void championReport(){
        System.out.println("\n Monthly Champion Exercise Type Report ");
        System.out.print("Enter month number (1 or 2): ");
        try {
            int month = Integer.parseInt(scanner.nextLine().trim());
            reportGenerator.printChampionReport(month);
        } catch (NumberFormatException e) {
            System.out.println("Invalid month number.");
        }
    }

    private static void printActiveBookings() {
        System.out.println("\nCurrent Bookings:");
        boolean found = false;
        for (Booking b : bookingSystem.getBookings()) {
            if (b.getStatus() != BookingStatus.CANCELLED) {
                System.out.println("  " + b);
                found = true;
            }
        }
        if (!found) {
            System.out.println("  No active bookings found.");
        }
    }

}
