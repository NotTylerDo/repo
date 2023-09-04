/*
 * NoSpecialCharacterException Class
 * @author Tyler Do
 * */
public class NoSpecialCharacterException extends Exception {
	/**
	 * Default constructor that displays message in case of this exception
	 * */
	public NoSpecialCharacterException() {
		super("The password must contain at least one special character");
	}
}