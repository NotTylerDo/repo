/*
 * Class: CMSC204
 * Instructor: Huseyin Aygun
 * Description:
 * Due:
 * Platform/Compiler: Eclipse
 * I pledge that I have completed the programming assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code to any student.
 * Tyler Do
 * 
 * PasswordCheckerUtility class
 * @author Tyler Do
 * */
import java.util.ArrayList;

public class PasswordCheckerUtility extends java.lang.Object {
	
	/**
	 * 
	 * */
	public PasswordCheckerUtility() {}
	
	/**
	 * 
	 * */
	public static void comparePasswords(String password, String passwordConfirm) throws UnmatchedException {
		if (!password.equals(passwordConfirm));
			throw new UnmatchedException();
	}
	
	/**
	 * 
	 * */
	public static boolean comparePasswordsWithReturn(String password, String passwordConfirm) {
		boolean status;
		if (password.equals(passwordConfirm))
			status = true;
		else
			status = false;
		return status;
			
	}
	
	public static boolean isValidLength(String password) throws LengthException {
		if (password.length()>=6)
			return true;
		else {
			throw new LengthException();
		}	
	}
	
	public static boolean hasUpperAlpha(String password) throws NoUpperAlphaException{
		String password2 = new String(password);
		if (!password.equals(password2.toLowerCase()))
			return true;
		else
			throw new NoUpperAlphaException();
	}
	
	public static boolean hasLowerAlpha(String password) throws NoLowerAlphaException{
		String password2 = new String(password);
		if (!password.equals(password2.toUpperCase()))
			return true;
		else 
			throw new NoLowerAlphaException();
	}
	
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
	
	public static boolean NoSameCharInSequence(String password) throws InvalidSequenceException {
		boolean status = true;
		for (int i = 0; i < password.length() - 1; i++) {
			if (password.charAt(i) == password.charAt(i+1))
				throw new InvalidSequenceException();
		}
		return status;
	}
	
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
	
	public static boolean hasBetweenSixAndNineChars(String password) {
		if (password.length() >= 6 && password.length() <= 9)
			return true;
		else 
			return false;
	}
	
	public static boolean isWeakPassword(String password) throws WeakPasswordException, LengthException, NoUpperAlphaException,
																NoLowerAlphaException, NoDigitException,
																NoSpecialCharacterException, InvalidSequenceException {
		if (isValidPassword(password) == true && hasBetweenSixAndNineChars(password) == false)
			return false;
		else 
			throw new WeakPasswordException();
	}
	
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
	
	
	
	
	