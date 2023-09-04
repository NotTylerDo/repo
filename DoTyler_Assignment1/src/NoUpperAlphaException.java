/*
 * NoUpperAlphaException Class
 * @author Tyler Do
 * */
public class NoUpperAlphaException extends Exception {
	/**
	 * Default constructor that displays message in case of this exception
	 * */
	public NoUpperAlphaException() {
		super("The password must contain at least one uppercase alphabetic character");
	}
}