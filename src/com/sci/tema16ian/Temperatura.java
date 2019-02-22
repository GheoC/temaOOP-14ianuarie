/*
Converts body temperature, measured in Fahrenheit degrees and outputs it in Celsius degrees,
with the following message: "Your body temperature in Celsius degrees is tempCelsius", where
tempCelsius is respectively the Celsius degrees.
In addition if the measured temperature in Celsius is higher than 37 degrees, the program should warn the
user that they are ill, with the following message "You are ill!". ( use the method created before)

method convertTemp() converts temperature from Fahrenheit to Celsius

@author Gheo Coanta
 */

package com.sci.tema16ian;

import java.util.Scanner;

public class Temperatura {

    public static double convertTemp(double fahr) {
        return ((fahr - 32) * 5 / 9);
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Introdu temperatura in grade Fahrenheit: ");
        double tempF = input.nextDouble();
        //  System.out.println(tempF);

        double tempCelsius = convertTemp(tempF);

        System.out.println("Your body temperature in Celsius degrees is: " + tempCelsius);

        if (tempCelsius > 37) {
            System.out.println("You are ill!");
        }
    }
}
