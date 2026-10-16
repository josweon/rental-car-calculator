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

    public static float tollTag(Scanner scanner) {
        System.out.print("electronic toll tag addon (yes/no)? ");
        String response = scanner.nextLine();

        float addon = switch (response) {
            case "yes" -> 3.95f;
            case "no" -> 0;
            default -> 0;
        };
        return addon;

    }
}
