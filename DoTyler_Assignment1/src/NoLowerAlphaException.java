/*
 * NoLowerAlphaException Class
 * @author Tyler Do
 * */
public class NoLowerAlphaException extends Exception {
	/**
	 * Default constructor that displays message in case of this exception
	 * */
	public NoLowerAlphaException() {
		super("The password must contain at least one lowercase alphabetic character");		
	}
}