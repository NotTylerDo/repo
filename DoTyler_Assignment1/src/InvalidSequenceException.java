/*
 * InvalidSequenceException Class
 * @author Tyler Do
 * */
public class InvalidSequenceException extends Exception {
	/**
	 * Default constructor that displays message in case of this exception
	 * */
	public InvalidSequenceException() {	
		super("The password cannot contain more than two of the same character in sequence");
	}
}