//Description: This program prompts the user to input information and perform various actions
//based on their decision with the given menu. This class will use recursive methods to perform
//different calculations for each menu option.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.text.DecimalFormat;

public class Recursion {

	// create a main menu that prompts a user for information and performs various actions based on the user's input
	public static void main(String[] args) {
		// menu
		try {
			// create a BufferedReader to read user input
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			// loop until the user quits the program
			while (true) {
				// print the menu
				printMenu();
				// create character variable that reads user's choice of action
				char userChoice = Character.toUpperCase(br.readLine().charAt(0));

				// create switch method to perform action based on user's choice
				switch(userChoice) {

					// if user chooses A, ask for two double values and calculate the sum of all elements in the array
					case 'A':
					System.out.print("Enter numbers (0 to finish): ");
					double[] arr = parseDoubles(br);
					double sum = sumArray(arr);
					DecimalFormat df = new DecimalFormat("0.#######");
					System.out.printf("Sum of elements in array: %s\n", df.format(sum));
					break;

					// if user chooses B, ask for two integer values and calculate the sum of all inclusive values
					case 'B':
					System.out.print("Enter the first number: ");
					int num1 = readInteger(br);
					System.out.print("Enter the second number: ");
					int num2 = readInteger(br);
					System.out.printf("The sum of all integers between %d and %d is: %d", num1, num2, sumIntegers(num1, num2));
					break;

					// if user chooses C, ask for an integer and calculate the prime factorization
					case 'C':
					System.out.print("Enter an integer to factorize: ");
					int x = readInteger(br);
					System.out.printf("The prime factorization of %d is: %s", x, primeFactorization(x));
					break;

					// if user chooses D, ask for a string and substring, then remove all occurrences of the substring in the string
					case 'D':
					System.out.print("Please enter string: ");
					String str = br.readLine();
					System.out.print("Please enter substring to remove: ");
					String substr = br.readLine();
					System.out.printf("String after substring removal: %s\n", removeSubstring(str, substr));
					break;

					// if user chooses E, program quits
					case 'E':
					System.exit(0);
					break;

					// or returns a string if user inputs a value that is not between A and E
					default : 
					System.out.println("Invalid choice. Please choose a char between A and E.");
					break;
				}
			}
		// create catch method to handle any exceptions thrown
		} catch (IOException ex) {
			System.out.println("IO Exception.");
		}
	}

	// A: recursive method that calculates the sum of all elements in an array of
	// doubles and returns the sum
	public static double sumArray(double[] arr) {
		return sumReturn(arr, 0);
	}
	// recursive method that adds all elements in an array from the given index
	private static double sumReturn(double[] arr, int index) {
		if (index == arr.length) {
			return 0;
		}
		return arr[index] + sumReturn(arr, index + 1);
	}
	// B: recursive method that calculates the sum of all integers between two
	// numbers (including the two numbers) and returns the sum
	public static int sumIntegers(int num1, int num2) {
		if (num1 > num2) {
			return sumIntegers(num2, num1);
		}
		if (num1 == num2) {
			return num1;
		}
		return num1 + sumIntegers(num1 + 1, num2);
	}

	// C: recursive method that calculates the prime factorization of an integer and returns a string as a result
	public static String primeFactorization(int x) {
		return factorReturn(x, 2);
	}

	// recursive method that finds the prime factors by dividing the next quotient
	// until the quotient is 1
	private static String factorReturn(int x, int factor) {
		if (x < 2) {
			return "";
		}
		if (x == factor) {
			return Integer.toString(x);
		}
		if (x % factor == 0) {
			return factor + "x" + factorReturn(x / factor, factor);
		} else {
		return factorReturn(x, factor + 1);
		}
	}
	// D: recursive method that removes all occurrences of a specified substring in a string and returns the result string
	public static String removeSubstring(String str, String substr) {
		if (str == null || substr == null) {
			return str;
		}	
		int index = str.indexOf(substr);
		if (index == -1) {
			return str;
		}
		String newStr = str.substring(0, index) + str.substring(index + substr.length());
		return removeSubstring(newStr, substr);
	}

	// ----------------------------------------------------------------------------------------

	// utility method for parsing doubles from standard input that returns an array of doubles
	public static double[] parseDoubles(BufferedReader reader) {
		String line = "";
		ArrayList<Double> container = new ArrayList<>();
		try {
			line = reader.readLine();
			double num = Double.parseDouble(line);

			while (num != 0) {
				container.add(num);
				line = reader.readLine();
				num = Double.parseDouble(line);
			}

		} catch (IOException ex) {
			System.out.println("IO Exception.");
		} catch (NumberFormatException e) {
			System.out.println("Invalid input, return to main menu.");
		}

		double[] result = new double[container.size()];
		for (int i = 0; i < container.size(); i++) {
			result[i] = container.get(i);
		}
		return result;
	}

	// utility method for parsing integers from standard input (only positive integers allowed)
    public static int readInteger(BufferedReader reader) throws IOException {
        int number = 0;
        try {
            String line = reader.readLine();
            number = Integer.parseInt(line);
        } catch (IOException e) {
            System.out.println("Error reading input. Please try again.");
            number = readInteger(reader);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please try again.");
            number = readInteger(reader);
        }
        if (number <0) {
        	System.out.println("Invalid input. Only positive integers allowed. Please try again.");
        	number = readInteger(reader);
        }
        return number;
    }

	// utility method for printing the menu
	public static void printMenu() {
		System.out.print("\nWhat would you like to do?\n\n");
		System.out.print("A: Calculate the sum of all elements in an array of doubles\n");
		System.out.print("B: Calculate the sum of all integers between two numbers (including the two numbers)\n");
		System.out.print("C: Calculate the prime factorization of an integer\n");
		System.out.print("D: Remove all occurrences of a specified substring in a string\n");
		System.out.print("E: Quit\n\n");
	}
}
