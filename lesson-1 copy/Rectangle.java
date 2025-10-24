
// Created by: D. Jeffrey
// Created on: Sep 2025
// This program determines letter grade and honour roll status

import java.util.Scanner;

public class Grade {
    public static void main(String[] args) {
        // Prints letter grade and honour roll status
        Scanner input = new Scanner(System.in);

        System.out.print("Enter your Grade: ");
        int percentMark = input.nextInt();

        if (percentMark > 100 || percentMark < 0) {
            System.out.print("Invalid input\n");
        } else {
            if (percentMark >= 80) {
                System.out.print("You got an A!\n");
                if (percentMark >= 90) {
                    System.out.print("You made it onto the Golden Honour Roll!!\n");
                } else {
                    System.out.print("You made it onto the Honour Roll!!\n");
                }
            } else if (percentMark >= 70) {
                System.out.print("You got a B!\n");
            } else if (percentMark >= 60) {
                System.out.print("You got a C!\n");
            } else if (percentMark >= 50) {
                System.out.print("You got a D!\n");
            } else {
                System.out.print("You got an F!\n");
            }
        }
        System.out.print("\nDone.\n");
        input.close();
    }
}
