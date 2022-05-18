import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RegexEx1Test {
	// all characters in string uppercase
	@Test
	void upperCaseTest() {
		String userChoice = "uppercase";
		String validate = "UPPERCASE";
		String expected = "You've entered a valid uppercase phrase!";
		String actual = RegexEx1.regexValidator(userChoice, validate);
		assertEquals(expected, actual);
	}
	// all characters in string are not uppercase - spaces
	@Test
	void upperCaseWithSpacesTest() {
		String userChoice = "uppercase";
		String validate = "THIS IS UPPERCASE";
		String expected = "Your phrase is not in upper case.";
		String actual = RegexEx1.regexValidator(userChoice, validate);
		assertEquals(expected, actual);
	}
	// no characters in string are uppercase
	@Test
	void notUpperCaseTest() {
		String userChoice = "uppercase";
		String validate = "lowercase";
		String expected = "Your phrase is not in upper case.";
		String actual = RegexEx1.regexValidator(userChoice, validate);
		assertEquals(expected, actual);
	}
	// check for a digit in the string
	@Test
	void digitTest() {
		String userChoice = "digit";
		String validate = "this is a 7";
		String expected = "You've entered a phrase with a valid digit!";
		String actual = RegexEx1.regexValidator(userChoice, validate);
		assertEquals(expected, actual);
	}
	// there's no digits in this string
	@Test
	void noDigitTest() {
		String userChoice = "digit";
		String validate = "this is a seven";
		String expected = "Your phrase does not contain a digit.";
		String actual = RegexEx1.regexValidator(userChoice, validate);
		assertEquals(expected, actual);
	}
	// phone number correctly formatted ###-###-####
	@Test
	void phoneNumberTest() {
		String userChoice = "phone";
		String validate = "800-867-5309";
		String expected = "You've entered a valid phone number!";
		String actual = RegexEx1.regexValidator(userChoice, validate);
		assertEquals(expected, actual);
	}
	// phone number incorrectly formatted
	@Test
	void badPhoneNumberTest() {
		String userChoice = "phone";
		String validate = "(800)867-5309";
		String expected = "Your phone number should be in ###-###-#### format.";
		String actual = RegexEx1.regexValidator(userChoice, validate);
		assertEquals(expected, actual);
	}
	// date correctly formatted
	@Test
	void dateTest() {
		String userChoice = "date";
		String validate = "09/03/1987";
		String expected = "You've entered a valid date!";
		String actual = RegexEx1.regexValidator(userChoice, validate);
		assertEquals(expected, actual);
	}
	// date incorrectly formatted
	@Test
	void badDateTest() {
		String userChoice = "date";
		String validate = "9/3/1987";
		String expected = "Your date should be in dd/mm/yyyy format.";
		String actual = RegexEx1.regexValidator(userChoice, validate);
		assertEquals(expected, actual);
	}
	// useless input
	@Test
	void wrongAnswersOnlyTest() {
		String userChoice = "no thanks";
		String validate = "your mom";
		String expected = "Nothing to see here.";
		String actual = RegexEx1.regexValidator(userChoice, validate);
		assertEquals(expected, actual);
	}
	
}
