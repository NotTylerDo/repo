/**
 * StackOverflowException Class
 * @author Tyler Do
 * */
public class StackOverflowException extends Exception {
	/**
	 * Default constructor that displays message in case of this exception
	 * */
	public StackOverflowException() {
		super("Error: Push method was called on a full stack");
	}
}
