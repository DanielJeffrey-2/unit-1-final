// Created by: D. Jeffrey
// Created on: Oct 2025
// This program determines average of 5 integer inputs

import java.util.Scanner;
import java.util.Arrays;

public class Average {
    public static void main(String[] args) {
        // Gets 5 integer inputs, calculates average, prints
        Scanner input = new Scanner(System.in);
        float sum = 0;
        int[] integers = new int[5]; // new int sets array length

        for (int i = 0; i < 5; i++) {
            System.out.print("Enter an integer: ");
            int newInteger = input.nextInt();
            integers[i] = newInteger;
            sum += newInteger;
        }
        float average = sum / 5;
        System.out.println("The average of the integers is: " + average);
        System.out.println(Arrays.toString(integers));

        System.out.print("\nDone.\n");
        input.close();
    }
}
