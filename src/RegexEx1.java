import java.util.Scanner;
import java.util.regex.Pattern;

public class RegexEx1 {
	static Scanner scnr = new Scanner(System.in);
	static String validate;
	static boolean wrongChoice = false;
	
	public static void main(String[] args) {
		
		
		System.out.println(
				"Would you like to validate an uppercase word, a phrase with at least one numerical digit, a phone number, or a date?");
		System.out.println("Enter uppercase, digit, phone, or date to confirm your choice:");
		String userChoice = scnr.nextLine().toLowerCase();
	
	
			userChoices(userChoice, validate);
			while (wrongChoice == true) {
				userChoices(userChoice, validate);
			}

	}

	public static String regexValidator(String userChoice, String validate) {

		String upperCaseReg = "[A-Z]*";
		String digitReg = ".*\\d.*";
		String dateReg = "\\d\\d\\/\\d\\d\\/\\d\\d\\d\\d";
		String phoneReg = "\\d\\d\\d\\-\\d\\d\\d\\-\\d\\d\\d\\d";
		String message = null;
		boolean match;

		switch (userChoice) {
		// works to check for all uppercase
		case "uppercase":
			match = Pattern.matches(upperCaseReg, validate);
			if (match == true) {
				message = "You've entered a valid uppercase phrase!";
			} else {
				message = "Your phrase is not in upper case.";
			}
			break;
		// works
		case "digit":
			match = Pattern.matches(digitReg, validate);
			if (match == true) {
				message = "You've entered a phrase with a valid digit!";
			} else {
				message = "Your phrase does not contain a digit.";
			}
			break;
		// works with ###-###-#### pattern
		case "phone":
			match = Pattern.matches(phoneReg, validate);
			if (match == true) {
				message = "You've entered a valid phone number!";
			} else {
				message = "Your phone number should be in ###-###-#### format.";
			}
			break;
		// works with ##/##/#### pattern
		case "date":
			match = Pattern.matches(dateReg, validate);
			if (match == true) {
				message = "You've entered a valid date!";
			} else {
				message = "Your date should be in dd/mm/yyyy format.";
			}
			break;
		default:
			message = "Nothing to see here.";
			break;
		}

	return message;
	}

	public static void runValidator(String userChoice, String validate) {
		validate = scnr.nextLine();
		System.out.println(regexValidator(userChoice, validate));
	}
	
	public static void userChoices(String userChoice, String validate) {
		if (userChoice.equals("uppercase")) {
			System.out.println("Please enter an UPPERCASE word:");
			runValidator(userChoice, validate);
		} else if (userChoice.equals("digit")) {
			System.out.println("Please enter a phrase with at least one numerical digit:");
			runValidator(userChoice, validate);
		} else if (userChoice.equals("phone")) {
			System.out.println("Please enter a phone number:");
			runValidator(userChoice, validate);
		} else if (userChoice.equals("date")) {
			System.out.println("Please enter a date in dd/mm/yyyy format:");
			runValidator(userChoice, validate);
		} else {
			System.out.println("No validation for you!");
			System.out.println("Please make a choice from the follwoing options (uppercase, digit, phone, date):");
			wrongChoice = true;
			userChoice = scnr.nextLine().toLowerCase();
			
		}
	}
}