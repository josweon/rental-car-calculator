package com.pluralsight;

import java.util.*;

public class rentalCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

    }

    public static String getDate(Scanner scanner) {
        System.out.print("pickup date? ");
        String date = scanner.nextLine();
        return date;
    }

    public static int getDuration(Scanner scanner) {
        System.out.print("number of days? ");
        return scanner.nextInt();
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

    public static int getInt(Scanner scanner) {
        System.out.print("your age? ");
        return scanner.nextInt();
    }


}
