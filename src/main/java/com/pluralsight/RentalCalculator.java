package com.pluralsight;

import java.util.*;

public class RentalCalculator {

    final static double baseRentalPrice = 29.99;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String pickupDate = getDate(scanner);
        int rentalDuration = getDuration(scanner);
        boolean tagPrice = addTollTag(scanner);
        boolean gpsPrice = addGPS(scanner);
        double surcharge = getSurcharge(scanner);

        System.out.println("---");

        displayReceipt(
                pickupDate,
                rentalDuration,
                gpsPrice,
                tagPrice,
                surcharge
        );
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

    public static boolean addTollTag(Scanner scanner) {
        System.out.print("electronic toll tag at $3.95/day (yes/no)? ");
        String input = scanner.nextLine();

        boolean hasAddOn = false;
        if (input.equals("yes")) {
            hasAddOn = true;
        } else if (input.equals("no")) {
            hasAddOn = false;
        }
        return hasAddOn;
    }

    public static boolean addGPS(Scanner scanner) {
        System.out.print("GPS at $2.95/day (yes/no) ");
        String response = scanner.nextLine();

        boolean hasAddOn = false;
        if (response.equals("yes")) {
            hasAddOn = true;
        } else if (response.equals("no")) {
            hasAddOn = false;
        }
        return hasAddOn;
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

    public static void displayReceipt(
            String pickUpDate,
            int rentalDuration,
            boolean hasGPS,
            boolean tollTag,
            double surcharge
    ) {

        double rentalPrice = baseRentalPrice * rentalDuration;
        System.out.printf("The basic car rental is $%.2f, which starts on %s.\n", baseRentalPrice, pickUpDate);
        System.out.printf("You'll have the rental for %d days which totals to $%.2f.\n", rentalDuration, rentalPrice);

        double optionalCost;
        if (hasGPS && tollTag) {
            optionalCost = (3.95 + 2.95) * rentalDuration;
            System.out.printf("You opted to add the electronic toll tag and the GPS which comes out to $%.2f.\n", optionalCost);
        } else if (tollTag) {
            optionalCost = 3.95 * rentalDuration;
            System.out.printf("You opted to add the electronic toll tag which adds $%.2f to your total.\n", optionalCost);
        } else if (hasGPS) {
            optionalCost = 2.95 * rentalDuration;
            System.out.printf("You opted to add on GPS which adds $%.2f to your total\n", optionalCost);
        } else {
            System.out.print("You have no add ons.\n");
            optionalCost = 0;
        }

        double subTotal = optionalCost + rentalPrice;
        double surchargeCost = subTotal + (subTotal * surcharge);

        if (surcharge > 0) {
            System.out.print("There is a 30% surcharge on the basic car rental for drivers under 25.\n" );
        } else {
            System.out.print("There is no surcharge on the basic rental price for drivers over 25.\n");
        }

        System.out.println("All taxes have already been incorporated into the fees shown.");
        System.out.println("---");

        double totalPrice = rentalPrice + surchargeCost + optionalCost;
        System.out.printf("Your grand total is $%.2f\n", totalPrice);
    }
}
