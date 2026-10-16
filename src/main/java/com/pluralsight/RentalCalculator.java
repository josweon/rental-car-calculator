package com.pluralsight;

import java.util.*;

public class RentalCalculator {

    final static double baseRentalPrice = 29.99;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String pickupDate = getDate(scanner);
        int rentalDuration = getDuration(scanner);
        double tagPrice = addTollTag(scanner);
        double gpsPrice = addGPS(scanner);
//        int driverAge = getAge(scanner);

        double rentalPrice = baseRentalPrice * rentalDuration;
        double optionalCost = tagPrice + gpsPrice;
        displayReceipt(pickupDate, rentalDuration, rentalPrice, optionalCost, driverAge);

    }

    public static String getDate(Scanner scanner) {
        System.out.print("pickup date? ");
        String date = scanner.nextLine();
        return date;
    }

    public static int getDuration(Scanner scanner) {
        System.out.print("number of days? ");
        int duration = scanner.nextInt();
        scanner.nextLine();
        return duration;
    }

    public static float addTollTag(Scanner scanner) {
        System.out.print("electronic toll tag at $3.95/day (yes/no)? ");
        String response = scanner.nextLine();

        float addOnTag = switch (response) {
            case "yes" -> 3.95f;
            case "no" -> 0;
            default -> 0;
        };
        return addOnTag;
    }

    public static float addGPS(Scanner scanner) {
        System.out.print("GPS at $2.95/day (yes/no) ");
        String response = scanner.nextLine();

        float addOnGPS = switch (response) {
            case "yes" -> 2.95f;
            case "no" -> 0;
            default -> 0;
        };
        return addOnGPS;
    }

    public static double getAge(Scanner scanner) {
        System.out.print("your age? ");
        String input = scanner.nextLine();
        int age = Integer.parseInt(input);

        double surcharge;
        if (age < 25) {
            surcharge = 0.3;
        }
    }

    public static void displayReceipt(String pickUpDate, int rentalDuration,
                                      double rentalPrice, double optionalCost, int driverAge) {
        // Implement as a receipt
        System.out.printf("The basic car rental is $%.2f, which starts on %s.", baseRentalPrice, pickUpDate);
        System.out.printf("You'll have the rental for %d days which totals to $%.2f\n", rentalDuration, rentalPrice);
        System.out.printf("Total optional price is $%.2f\n", optionalCost);
        System.out.print(driverAge);
//        if
//        System.out.printf("You opted for ");
    }



}
