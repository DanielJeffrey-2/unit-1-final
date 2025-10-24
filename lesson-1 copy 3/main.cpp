// Copyright (c) 2025 St. Mother Teresa HS All rights reserved.

// Created by: D. Jeffrey
// Created on: Oct 2025
// This program determines the time for microwaving items

#include <iostream>
#include <string>
using std::cout;
using std::cin;

int main() {
    // this function calculates time for microwaving
    std::string food;
    std::string amountOfFood;

    cout << "Choose your food: Sub (0), Pizza (1), Soup(2): ";
    cin >> food;

    cout << "Chose the amount of items to be heated (1, 2, or 3): ";
    cin >> amountOfFood;

    try {
        int foodAsNumber = stoi(food);
        int amountInt = stoi(amountOfFood);
        int baseTimes[3] = {60, 45, 105};
        if (foodAsNumber == 0 || foodAsNumber == 1 || foodAsNumber == 2) {
            if (amountInt == 1 || amountInt == 2 || amountInt == 3) {
                double time = (baseTimes[foodAsNumber] +
                    (baseTimes[foodAsNumber] / 2.0 * (amountInt - 1)));
                int totalSeconds = static_cast<int>(time);
                int minutes = totalSeconds / 60;
                int seconds = totalSeconds % 60;
                cout << "\nIt takes you " << minutes << " minute(s) and "
                << seconds << " second(s) to heat your food!";
            } else {
                cout << "\nPlease enter proper values.";
            }
        } else {
            cout << "\nPlease enter proper values.";
        }
    }
    catch (const std::invalid_argument &err) {
        std::cout << "The error was: " << err.what() << "." << std::endl;
    }

    cout << "\n\nDone.\n";
    }
