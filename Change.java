/*
 * This program converts a dollar amount between $0.01 and $999.99
 * into change.
 *
 * @author  D. Jeffrey
 * @version 1.0
 * @since   2025-10-20
 */

import java.util.Scanner;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * This is the Change game program.
 */
public final class Change {
    /**
     * Creates list for currency values.
     */
    private static final int[] CURRENCYVALUES = {
            10000,
            5000,
            2000,
            1000,
            500,
            200,
            100,
            25,
            10,
            5,
    };

    /**
     * Creates maxchange to limit total change.
     */
    private static final int MAXCHANGE = 99999;

    /**
     * Creates number to multiply change by to get cents.
     */
    private static final int CENTSCONVERT = 100;

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
     * Uses parameter money Hashmap, returns none.
     *
     * @param money linkedHashMap for money
     */
    public static void moneyOutput(final Map<String, Integer> money) {
        // process
        // gives set containing all keys in money LinkedHashMap, loops through
        for (String key : money.keySet()) {

            /*
             * prints amount of each currency followed by the type of currency,
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
     * Uses int change as parameter, returns none.
     *
     * @param changeFinal change value as an integer
     */
    public static void currencyCalculator(final int changeFinal) {
        // variables
        int change = changeFinal;
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

        // creates LinkedHashMap called money, really just a dictionary
        LinkedHashMap<String, Integer> money = new LinkedHashMap<>();

        // process
        /*
         * loops through currencyValues, checks if change is divisible by
         * different currencies, if yes then appends currencyType and
         * amountOfCurrency to Hashmap and subtracts that currency
         * from the change
         */
        for (int currencyValue = 0; currencyValue < CURRENCYVALUES.length;
        currencyValue++) {
            int amountOfCurrency = change / CURRENCYVALUES[currencyValue];

            if (amountOfCurrency >= 1) {
                money.put(currencyTypes[currencyValue], amountOfCurrency);
                change -= CURRENCYVALUES[currencyValue] * amountOfCurrency;
            }
        }
        // calls output function using linkedhashmap as an argument
        moneyOutput(money);
    }

    /**
     * This function gets cost and payment of items, calls other function
     * to find necessary bills/coins.
     *
     */
    public static void getChange() {
        // variables
        float change;
        int changeAsInt;
        int costInt;
        int paymentInt;

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

            costInt = (int) Math.round(cost * CENTSCONVERT);
            paymentInt = (int) Math.round(payment * CENTSCONVERT);

            // calculates change in cents, converts to int
            change = payment - cost;
            changeAsInt = paymentInt - costInt;

            if (cost < 0 || payment < 0) {
                System.out.printf("Invalid cost/payment.\n");
            } else if (changeAsInt == 0) {
                System.out.printf("You get no change.");
            } else if (changeAsInt > MAXCHANGE) {
                System.out.printf("There is not enough change in the register"
                + ", tough luck!");
            } else if (changeAsInt < 0) {
                System.out.printf("Nice try, bucko.");
            } else {
                System.out.printf("Your change: $%.2f%n", change);
                currencyCalculator(changeAsInt);
            }
        } catch (NumberFormatException e) {
            System.out.printf("The error was: %s.%n", e.getMessage());
        } finally {
            System.out.println("\n\nDone.");
        }
        scanner.close();
    }

    /**
     * The starting main() function.
     *
     * @param args No args will be used
     */
    public static void main(final String[] args) {
        // calls getChange()
        getChange();
    }
}
