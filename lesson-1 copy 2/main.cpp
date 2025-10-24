// Copyright (c) 2025 St. Mother Teresa HS All rights reserved.

// Created by: D. Jeffrey
// Created on: Oct 2025
// This program determines average of 5 integer inputs

#include <iostream>
using std::cout;
using std::cin;

int main() {
    // Gets 5 integer inputs, calculates average, prints
    float sum = 0;
    int integers[5];
    int newInteger = 0;

    for (int i = 0; i < 5; i++) {
        cout << "Enter an integer: ";
        cin >> newInteger;
        integers[i] = newInteger;
        sum += newInteger;
    }
    float average = sum / 5;
    cout << "The average of the integers is: " << average << "\n";
    for (int i = 0; i < 5; i++) {
        cout << integers[i] << " ";
    }

    cout << "\n\nDone.\n";
    }
