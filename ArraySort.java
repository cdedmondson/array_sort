/*****************************************
 *		file: ArraySort
 *		author: Cameron Edmondson
 *		class: CS 240 - Data Structures and Algorithms
 *
 *		assignment: 2
 *		date last modified: 4/28/2017
 *
 *		purpose: This program sorts an array of 1 million 
 *		randomly generated positive integers using 
 *		following 2 approaches
 *
 *		1) Stores randomly generated values in an array. Sorts 
 *		the array using Selection Sort
 *
 *		2) Stores each randomly generated value in a sorted 
 *		array. Finds the correct position to insert the new 
 *		value and shifts rest of the values down
 *
 *		Display total number of iterations used in both 
 *		approaches as the Output
 *				 
 *****************************************/

import java.util.Random;

// Begin class method
public class ArraySort {

	// Begin main method
	public static void main(String[] args) {

		// Declare variables
		int minValue, minIndex, temp;
		long count_1 = 0, count_2 = 0;

		// Create random object in memory
		Random random = new Random();

		// Create array in memory capable of holding 1 million integers
		int[] list = new int[1000000];

		// Populate array with random integers
		for (int i = 0; i < list.length; i++) {
			list[i] = random.nextInt(1000000) + 1;
		}

		// Iterate through first loop
		for (int i = 0; i < list.length; i++) {

			minValue = list[i];
			minIndex = i;

			// Iterate through second loop
			for (int j = i; j < list.length; j++) {

				// If value j is less than minValue swap minValue with j
				if (list[j] < minValue) {
					minValue = list[j];
					minIndex = j; // Set minIndex to j
				}
				count_1++; // Accumulate iterations
			}

			// If minValue is less than i swap value with temp variable
			if (minValue < list[i]) {
				temp = list[i];
				list[i] = list[minIndex];
				list[minIndex] = temp;
			}
		}

		// Print total iterations to console 
		System.out.println("Total iterations for unsorted list = " + count_1 + "\n");

		// Create new list copy old and expand by one
		int[] sortedList = new int[1000001];

		// Clone list 
		sortedList = list.clone();

		// Insert new integer at position 100
		sortedList[100] = 596;  

		// Iterate through sortedList 
		for (int i = 0; i < sortedList.length; i++) {

			// Iterate through entire sortedList comparing i and j values
			for (int j = i + 1; j < sortedList.length; j++) {

				// If i is greater than j swap values
				if (sortedList[i] > sortedList[j]) {
					temp = sortedList[i];

					sortedList[i] = sortedList[j];

					sortedList[j] = temp;
				}
				count_2++; // Accumulate iterations
			}
		}

		// Print total iterations to console 
		System.out.println("Total iterations for sorted list = " + count_2);
	}
}