/*
 * This program converts a dollar amount between $0.01 and $999.99
 * into change
 * 
 * @author  D. Jeffrey
 * @version 1.0
 * @since   2025-10-20
 */

/**
 * This is the Change game program
 */

import java.util.Scanner;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public final class Change {

    /**
     * Prevent instantiation.
     * Throw an exception IllegalStateException.
     * if this is ever called
     *
     * @throws IllegalStateException if this is ever called
     *
     */
    private Change() {
        throw new IllegalStateException("Cannot be instantiated");
    }

    /**
     * This function prints out the amount of each currency type needed
     * Uses parameter money Hashmap, returns none
     */
    public static void moneyOutput(Map<String, Integer> money) {
        // process
        // gives set containing all keys in money LinkedHashMap, loops through
        for (String key : money.keySet()) {

            /* prints amount of each currency followed by the type of currency,
            * accounting for multiples
            */
            if (money.get(key) > 1) {
                System.out.println(" " + money.get(key) + " " + key + "s");
            } else {
                System.out.println(" " + money.get(key) + " " + key);
            }
        }
    }

    /**
     * This function determines what currencies are needed
     * Uses int change as parameter, returns none
     */
    public static void currencyCalculator(int change) {
        // variables
        String[] currencyTypes = {
            "$100 bill",
            "$50 bill",
            "$20 bill",
            "$10 bill",
            "$5 bill",
            "Toonie",
            "Loonie",
            "Quarter",
            "Dime",
            "Nickel",
        };

        int currencyValues[] = {
            10000, 5000, 2000, 1000, 500, 200, 100, 25, 10, 5
        };

        // creates LinkedHashMap called money, really just a dictionary
        LinkedHashMap<String, Integer> money = new LinkedHashMap<>();

        // process
        /* loops through currencyValues, checks if change is divisible by
        * different currencies, if yes then appends currencyType and
        * amountOfCurrency to Hashmap and subtracts that currency
        * from the change
        */
        for (int i = 0; i < currencyValues.length; i++) {
            int amountOfCurrency = change / currencyValues[i];

            if (amountOfCurrency >= 1) {
                money.put(currencyTypes[i], amountOfCurrency);
                change -= currencyValues[i] * amountOfCurrency;
            }
        }
        // calls output function using linkedhashmap as an argument
        moneyOutput(money);
    }

    /**
     * This function gets cost and payment of items, returns change
     *
     * @param args No args will be used
     */
    public static void getChange() {
        // variables
        float change;
        int changeAsInt;

        // create Scanner object for user input
        Scanner scanner = new Scanner(System.in);

        // input
        System.out.print("Enter the cost of your items: ");
        String costAsString = scanner.nextLine();
        System.out.print("Amount of payment: ");
        String paymentAsString = scanner.nextLine();

        // process
        try {
            float cost = Float.parseFloat(costAsString);
            float payment = Float.parseFloat(paymentAsString);

            // calculates change in cents, converts to int
            change = payment - cost;
            System.out.printf("Your change: $%.2f%n", change);
            changeAsInt = (int) (change * 100);

            if (changeAsInt == 0) {
                System.out.printf("You get no change.");
            } else if (changeAsInt > 99999) {
                System.out.printf("There is not enough change in the register, tough luck!");
            } else if (changeAsInt < 0) {
                System.out.printf("Nice try, bucko.");

            } else {
                System.out.printf("Your change: $%.2f%n", change);
                Map<String, Integer> money = currencyCalculator(changeAsInt);
            }
        } catch (NumberFormatException e) {
            System.out.printf("The error was: %s.%n", e.getMessage());
        } finally {
            System.out.println("\nDone.");
        }
        scanner.close();
    }

    /**
     * The starting main() function.
     *
     * @param args No args will be used
     */
    public static void main(final String[] args) {
        // variables
        int change = getChange();
    }
}
