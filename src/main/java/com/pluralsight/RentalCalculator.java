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
        double surcharge = getSurcharge(scanner);

        double optionalCost = tagPrice + gpsPrice;

        System.out.println("---");
        displayReceipt(pickupDate, rentalDuration, optionalCost, surcharge);

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

    public static float addTollTag(Scanner scanner) { // TODO: Add bool functionality
        System.out.print("electronic toll tag at $3.95/day (yes/no)? ");
        String response = scanner.nextLine();

        float addOnTag = switch (response) {
            case "yes" -> 3.95f;
            case "no" -> 0;
            default -> 0;
        };
        return addOnTag;
    }

    public static float addGPS(Scanner scanner) { // TODO: Add bool functionality
        System.out.print("GPS at $2.95/day (yes/no) ");
        String response = scanner.nextLine();

        float addOnGPS = switch (response) {
            case "yes" -> 2.95f;
            case "no" -> 0;
            default -> 0;
        };
        return addOnGPS;
    }

    public static double getSurcharge(Scanner scanner) {
        System.out.print("your age? ");
        String input = scanner.nextLine();
        int age = Integer.parseInt(input);

        double surcharge;
        if (age < 25) {
            surcharge = 0.3;
        } else {
            surcharge = 0;
        }

        return surcharge;
    }

    public static void displayReceipt(String pickUpDate, int rentalDuration,
                                      double optionalCost, double surcharge) {
        // TODO: Implement clean optional price functionality
        // TODO: Clean up display text

        double rentalPrice = baseRentalPrice * rentalDuration;
        System.out.printf("The basic car rental is $%.2f, which starts on %s.", baseRentalPrice, pickUpDate);
        System.out.printf("You'll have the rental for %d days which totals to $%.2f\n", rentalDuration, rentalPrice);
        System.out.printf("Total optional price is $%.2f\n", optionalCost);

        double surchargeCost = rentalPrice + (rentalPrice * surcharge);
        if (surchargeCost == rentalPrice) {
            System.out.print("There is no surcharge on the basic rental price for drivers over 25.\n");
        } else {
            System.out.print("There is a 30% surcharge on the basic car rental for drivers under 25.\n" );
        }

        System.out.println(" All taxes have already been incorporated into the fees shown.");

        double totalPrice = rentalPrice + surchargeCost + optionalCost;
        System.out.printf("Your grand total is $%.2f", totalPrice);

    }

}
