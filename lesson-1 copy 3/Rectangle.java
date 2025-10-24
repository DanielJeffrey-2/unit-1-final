/*
 * This program determines the time for microwaving items
 *
 * @author  D. Jeffrey
 * @version 1.0
 * @since   2025-10-16
 */

import java.util.Scanner;

public class Microwave {
    public static void main(String[] args) {
        // this function calculates time for microwaving

        // create Scanner object for user input
        Scanner input = new Scanner(System.in);

        // input
        System.out.print("Choose your food: Sub (0), Pizza (1), Soup(2): ");
        String food = input.nextLine();

        System.out.print("Chose the amount of items to be heated (1, 2, or 3): ");
        String amountOfFood = input.nextLine();

        try {
            int foodAsNumber = Integer.parseInt(food);
            int amountInt = Integer.parseInt(amountOfFood);
            int[] baseTimes = { 60, 45, 105 }; // creates list of base heating times
            if (foodAsNumber == 0 || foodAsNumber == 1 || foodAsNumber == 2) {
                if (amountInt == 1 || amountInt == 2 || amountInt == 3) {
                    double time = (baseTimes[foodAsNumber] + (baseTimes[foodAsNumber] / 2.0 * (amountInt - 1)));
                    int totalSeconds = (int) time;
                    int minutes = totalSeconds / 60;
                    int seconds = totalSeconds % 60;
                    System.out.printf("\nIt takes you %d minute(s) and %d second(s) to heat your food!", minutes,
                            seconds);
                } else {
                    System.out.printf("\nPlease enter proper values");
                }
            } else {
                System.out.printf("\nPlease enter proper values");
            }

        } catch (NumberFormatException e) {
            System.out.printf("The error was: %s.%n", e.getMessage());
        } finally {
            System.out.println("\n\nDone.");
        }

        input.close();
    }
}
