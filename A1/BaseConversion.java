import acm.program.*;

public class BaseConversion extends ConsoleProgram {
	// This code below is taken from ECSE202, Winter 2021, Assignment 1
	// Run method:
	// Print greeting and instructions.
	public void run() {
		println("Base conversion program; converts +ve integers to a target base.");
		println("Enter number to be converted and target base on separate lines following the prompts.");
		println("A blank entry for either input terminates the program.");
		// Main program loop: read input, check for exit, convert, print result.
		while (true) {
			String input = readLine("Number > "); // Read input and check for break.
			if (input.equals(""))
				break;
			int number = String2Int(input); // Convert to integer
			if (number < 0) {
				println("Error! " + input + " does not correspond to a positive integer.");
			} else {
				input = readLine("Target base > "); // Now do the same for the base value
				if (input.equals(""))
					break;
				int base = String2Int(input); // Convert to integer
				if (base < 2 || base > 16) { // Range error
					println("The base must be between 2 and 16 inclusive.");
				} else {
					String result = baseConv(number, base); // Convert and print result
					println(number + " expressed in base " + base + " is " + result);
				}
			}
		}
		// Termination of program
		println("Program terminated.");
	}

	// String2Int method:
	// This method helps convert String to Integer
	public int String2Int(String input) {

		String foo = input;
		int length = foo.length();// returns the length of the string
		int sum = 0;// initialize. It represents the result of string to integer
		int power_of_ten = 1;// initialize. It represents the power of ten and converts string to integer
		// the loop: get character, convert, check if valid, add to sum
		for (int i = length - 1; i >= 0; i--) {
			char myChar = foo.charAt(i); // get the character at this position
			int charToInt = myChar - '0'; // covert from char to integer
			if (charToInt < 0 || charToInt > 9) {// range is [0,9]
				return -1;
			}
			sum = sum + charToInt * power_of_ten; // add the integer to sum
			power_of_ten = power_of_ten * 10; // multiply power_of_ten by ten
		}
		return sum;

	}

	// baseConv method:
	// This method helps do the base conversion
	public String baseConv(int number, int base) {
		if (number == 0) {// check if number equals to zero.
			return "0";
		}
		int digit = 0;// initialize
		String string = "";// initialize
		String LUT = "0123456789ABCDEF";// define the LUT string
		// the loop: get digits, convert to reverse order
		while (number > 0) {
			// base conversion.
			// the first iteration we get the least significant.
			// the last iteration we get the most significant.
			digit = number % base;
			number = number / base;// get a new number and do the same to get the next digit
			string = LUT.charAt(digit) + string;// convert the string to reverse order
		}
		return string;
	}
}
