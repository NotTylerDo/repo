/*
 * Class: CMSC204
 * Instructor: Huseyin Aygun
 * Description:
 * Due:
 * Platform/Compiler: Eclipse
 * I pledge that I have completed the programming assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code to any student.
 * Tyler Do
 * */

/**
 * PasswordCheckerUtility class
 * @author Tyler Do
 * */
import java.util.ArrayList;

public class PasswordCheckerUtility extends java.lang.Object {
	
	/**
	 * Default constructor
	 * */
	public PasswordCheckerUtility() {
	}
	
	/**
	 * Compare equality of two passwords
	 * @param password The password
	 * @param passwordConfirm The confirmation of the password
	 * @throws UnmatchedException
	 * */
	public static void comparePasswords(String password, String passwordConfirm) throws UnmatchedException {
		if (!password.equals(passwordConfirm));
			throw new UnmatchedException();
	}
	
	/**
	 * Compare equality of two passwords
	 * @param password The password
	 * @param passwordConfirm The confirmation of the password
	 * @return status Whether or not the passwords are the same
	 * */
	public static boolean comparePasswordsWithReturn(String password, String passwordConfirm) {
		boolean status;
		if (password.equals(passwordConfirm))
			status = true;
		else
			status = false;
		return status;
			
	}
	
	/**
	 * Checks the password length requirement
	 * @param password The password
	 * @return true if password is of valid length, else throws exception
	 * @throws LengthException
	 * */
	public static boolean isValidLength(String password) throws LengthException {
		if (password.length()>=6)
			return true;
		else {
			throw new LengthException();
		}	
	}
	
	/**
	 * Checks the password uppercase requirement
	 * @param password The password
	 * @return true if password fulfills uppercase requirement, else throws exception
	 * @throws NoUpperAlphaException
	 * */
	public static boolean hasUpperAlpha(String password) throws NoUpperAlphaException{
		String password2 = new String(password);
		if (!password.equals(password2.toLowerCase()))
			return true;
		else
			throw new NoUpperAlphaException();
	}
	
	/**
	 * Checks the password lowercase requirement
	 * @param password The password
	 * @return true if password fulfills lowercase requirement, else throws exception
	 * @throws NoLowerAlphaException
	 * */
	public static boolean hasLowerAlpha(String password) throws NoLowerAlphaException{
		String password2 = new String(password);
		if (!password.equals(password2.toUpperCase()))
			return true;
		else 
			throw new NoLowerAlphaException();
	}
	
	/**
	 * Checks the password digit requirement
	 * @param password The password
	 * @return status true if the password fulfills digit requirement, else throws exception
	 * @throws NoDigitException
	 * */
	public static boolean hasDigit(String password) throws NoDigitException {
		boolean status = false;
		for (int i = 0; i < password.length(); i++) {
			if (Character.isDigit(password.charAt(i)))
				status = true;

		}
		if (status == true)
			return status;
		else
			throw new NoDigitException();
	}
	
	/**
	 * Checks the password Special character requirement
	 * @param password The password
	 * @return status True if the password fulfills special character requirement, else throws exception
	 * @throws NoSpecialCharacterException
	 * */
	public static boolean hasSpecialChar(String password) throws NoSpecialCharacterException {
		boolean status = false;
		for (int i = 0; i < password.length(); i++) {
			if(!Character.isLetterOrDigit(password.charAt(i)))
				status = true;
		}
		if (status == true)
			return status;
		else 
			throw new NoSpecialCharacterException();
	}
	
	/**
	 * Checks the password sequence requirement
	 * @param password The password
	 * @return status True if password fulfills sequence requirement, else throws exception
	 * @throws InvalidSequenceException
	 * */
	public static boolean NoSameCharInSequence(String password) throws InvalidSequenceException {
		boolean status = true;
		for (int i = 0; i < password.length() - 1; i++) {
			if (password.charAt(i) == password.charAt(i+1))
				throw new InvalidSequenceException();
		}
		return status;
	}
	
	/**
	 * Checks if password is valid by following all the rules
	 * @param password The password
	 * @return status True if the password is valid, else throws specific exception
	 * @throws LengthException
	 * @throws NoUpperAlphaException
	 * @throws NoLowerAlphaException
	 * @throws NoDigitException
	 * @throws NoSpecialCharacterException
	 * @throws InvalidSequenceException
	 * */
	public static boolean isValidPassword(String password) throws LengthException, NoUpperAlphaException,
																NoLowerAlphaException, NoDigitException,
																NoSpecialCharacterException, InvalidSequenceException{
		boolean status = true;
		try {
			if (isValidLength(password))
				if (hasUpperAlpha(password))
					if(hasLowerAlpha(password))
						if(hasDigit(password))
							if(hasSpecialChar(password))
								if(NoSameCharInSequence(password));
			return status;		
		}
		catch(LengthException e){
			throw new LengthException();
		}
		catch(NoUpperAlphaException e){
			throw new NoUpperAlphaException();
		}
		catch(NoLowerAlphaException e){
			throw new NoLowerAlphaException();
		}
		catch(NoDigitException e){
			throw new NoDigitException();
		}
		catch(NoSpecialCharacterException e){
			throw new NoSpecialCharacterException();
		}
		catch(InvalidSequenceException e){
			throw new InvalidSequenceException();
		}
	}
	
	/**
	 * Checks if password contains 6 to 9 characters
	 * @param password The password
	 * @return true if password is between 6 to 9 characters, false otherwise
	 * */
	public static boolean hasBetweenSixAndNineChars(String password) {
		if (password.length() >= 6 && password.length() <= 9)
			return true;
		else 
			return false;
	}
	
	/**
	 * Checks if password is valid and the length is not between 6 to 9 characters
	 * @returns false if password is valid and is not between 6 to 9 characters
	 * @throws WeakPasswordException
	 * */
	public static boolean isWeakPassword(String password) throws WeakPasswordException, LengthException, NoUpperAlphaException,
																NoLowerAlphaException, NoDigitException,
																NoSpecialCharacterException, InvalidSequenceException {
		if (isValidPassword(password) == true && hasBetweenSixAndNineChars(password) == false)
			return false;
		else 
			throw new WeakPasswordException();
	}
	
	/**
	 * Display list of invalid passwords with their status
	 * @param passwords ArrayList of passwords
	 * @return invalidPasswords ArrayList of all the invalid passwords
	 * */
	public static ArrayList<String> getInvalidPasswords(ArrayList<String> passwords){
		ArrayList<String> invalidPasswords = new ArrayList<String>();
		for (int i = 0; i<passwords.size(); i++) {
			try{
				if (isValidPassword(passwords.get(i))) {
				}
			}
			catch(Exception e) {
				invalidPasswords.add(passwords.get(i) + " " + e.getMessage());			
			}
		}
		return invalidPasswords;
	}
}
	
	
	
	
	