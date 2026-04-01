package com.furzefield;

import com.furzefield.service.BookingSystem;
import com.furzefield.service.ReportGenerator;

import java.util.Scanner;

public class Main {

    private static BookingSystem bookingSystem = new BookingSystem();
    private static ReportGenerator reportGenerator = new ReportGenerator(bookingSystem);
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){
        bookingSystem.initialiseTimetable();
        bookingSystem.initialiseMembers();

        System.out.println("Welcome to Furzedield Leisure Cenre");

        boolean running = true;
        while (running){
            printMenu();
            String choice = scanner.nextLine().trim();
            switch (choice){
                case "1" -> bookLesson();
                case "2" -> changeOrCancelBooking();
                case "3" -> attendLesson();
                case "4" -> monthlyLessonReport();
                case "5" -> championReport();
                case "0" -> { running = false; System.out.println("Goodbye!");}
                default -> System.out.println("Invalid option. Please try again.");
            }

        }
        scanner.close();
    }

    private static void printMenu() {
        System.out.println("\n====== Main Menu ======");
        System.out.println("1. Book a group exercise lesson");
        System.out.println("2. Change / Cancel a booking");
        System.out.println("3. Attend a lesson");
        System.out.println("4. Monthly lesson report");
        System.out.println("5. Monthly champion lesson type report");
        System.out.println("0. Exit");
        System.out.println("Enter your choice: ");
    }

    private static void bookLesson(){
        System.out.println("[ Book a lesson - coming soon ]");
    }

    private static void changeOrCancelBooking(){
        System.out.println("[ Change/Cancel - coming soon ]");
    }

    private static void attendLesson(){
        System.out.println("[ Attend lesson - coming soon ]");
    }

    private static void monthlyLessonReport(){
        System.out.println("[ Monthly report - coming soon ]");
    }

    private static void championReport(){
        System.out.println("[ Champion report - coming soon ]");
    }

}
