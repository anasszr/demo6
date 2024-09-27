package com.example.demo6;

import java.util.ArrayList;
import java.util.Collections;

/**
 * A simple library for calculating statistics.
 * It can find the mean, median, minimum, and maximum values in a list of numbers.
 */
public class SimpleStatisticalLibrary {

    /**
     * This method calculates the mean (average) of a list of numbers.
     * If you want, it can ignore numbers that are smaller than a given minimum value.
     *
     * @param numbers the list of numbers
     * @param min the smallest number to include
     * @param useMin if true, only numbers greater than or equal to min are included
     * @return the mean of the numbers in the list
     */
    public static double calculateMean(ArrayList<Double> numbers, double min, boolean useMin) {
        double total = 0;
        int count = 0;
        // Go through each number in the list
        for (double number : numbers) {
            // Only add the number if it's greater than or equal to min, or if we're not using min
            if (!useMin || number >= min) {
                total += number; // Add the number to the total
                count++; // Count how many numbers we've added
            }
        }
        // If no numbers were added, return 0 to avoid division by zero
        if (count == 0) {
            return 0;
        }
        return total / count; // Return the average (mean)
    }

    /**
     * This method finds the median (middle number) of a sorted list of numbers.
     * If the list has an even number of numbers, it returns the average of the two middle numbers.
     *
     * @param numbers the list of numbers
     * @return the median of the list
     */
    public static double calculateMedian(ArrayList<Double> numbers) {
        int size = numbers.size();
        // If there is an odd number of numbers, return the middle one
        if (size % 2 == 1) {
            return numbers.get(size / 2);
        } else {
            // If there is an even number of numbers, return the average of the two middle ones
            return (numbers.get(size / 2 - 1) + numbers.get(size / 2)) / 2;
        }
    }

    /**
     * This method finds the smallest number in a list.
     *
     * @param numbers the list of numbers
     * @return the smallest number
     */
    public static double findMinimum(ArrayList<Double> numbers) {
        double min = numbers.get(0); // Start by assuming the first number is the smallest
        // Go through the list to find the smallest number
        for (double number : numbers) {
            if (number < min) {
                min = number;
            }
        }
        return min; // Return the smallest number
    }

    /**
     * This method finds the biggest number in a list.
     *
     * @param numbers the list of numbers
     * @return the biggest number
     */
    public static double findMaximum(ArrayList<Double> numbers) {
        double max = numbers.get(0); // Start by assuming the first number is the biggest
        // Go through the list to find the biggest number
        for (double number : numbers) {
            if (number > max) {
                max = number;
            }
        }
        return max; // Return the biggest number
    }

    /**
     * This is the main method where we test the calculations.
     *
     * @param args command-line arguments (not used here)
     */
    public static void main(String[] args) {
        // Create a list of numbers to test with
        ArrayList<Double> data = new ArrayList<>();
        Collections.addAll(data, 25.5, 29.4, 36.7, 43.1, 57.9, 88.3, 99.9, 100.0);

        // Test each method and print the results
        System.out.println("Mean (with cutoff): " + calculateMean(data, 30, true));
        System.out.println("Median: " + calculateMedian(data));
        System.out.println("Minimum: " + findMinimum(data));
        System.out.println("Maximum: " + findMaximum(data));
    }
}
