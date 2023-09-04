/*
 * NoDigitException Class
 * @author Tyler Do
 * */
public class NoDigitException extends Exception {
	/**
	 * Default constructor that displays message in case of this exception
	 * */
	public NoDigitException() {
		super("The password must contain at least one digit");
	}
}