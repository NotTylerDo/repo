/*
 * LengthException Class
 * @author Tyler Do
 * */
public class LengthException extends Exception{
	/**
	 * Default constructor that displays message in case of this exception
	 * */
	public LengthException() {
		super("The password must be at least 6 characters long");	
	}
}