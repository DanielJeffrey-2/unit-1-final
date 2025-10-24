/*
 * This program converts a dollar amount between $0.01 and $99.99
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
     * This function gets cost and payment of items, returns change
     *
     * @param args No args will be used
     */
    public static int getChange() {
        // variables
        float change;
        int changeAsInt;

        // input
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the cost of your items: ");
        float cost = scanner.nextFloat();
        System.out.print("Amount of payment: ");
        float payment = scanner.nextFloat();

        // calculates change in cents, converts to int
        change = payment - cost;
        System.out.printf("Your change: $%.2f%n", change);
        changeAsInt = (int) (change * 100);

        scanner.close();

        return changeAsInt;
    }

    /**
     * This function determines what currencies are needed
     *
     */
    public static Map<String, Integer> currencyCalculator(int change) {
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
        * amountOfCurrency to Hashmap
        */
        for (int i = 0; i < currencyValues.length; i++) {
            int amountOfCurrency = change / currencyValues[i];

            if (amountOfCurrency >= 1) {
                money.put(currencyTypes[i], amountOfCurrency);
                change -= currencyValues[i] * amountOfCurrency;
            }
        }

        return money;
    }

    /**
     * This function prints out the amount of each currency type needed
     * Uses parameter money Hashmap, returns none
     */
    public static void moneyOutput(Map<String, Integer> money) {
        // process
        // gives set containing all keys in money LinkedHashMap, loops through
        for (String key : money.keySet()) {
            if (money.get(key) > 1) {
                System.out.println(" " + money.get(key) + " " + key + "s");
            } else {
                System.out.println(" " + money.get(key) + " " + key);
            }
        }
    }

    /**
     * The starting main() function.
     *
     * @param args No args will be used
     */
    public static void main(final String[] args) {
        // variables
        int change = getChange();
        Map<String, Integer> money = currencyCalculator(change);
        moneyOutput(money);



        System.out.println("\nDone.");
    }
}
