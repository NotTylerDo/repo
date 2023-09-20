/**
 * StackUnderflowException Class
 * @author Tyler Do
 * */
public class StackUnderflowException extends Exception {
	/**
	 * Default constructor that displays message in case of this exception
	 * */
	public StackUnderflowException() {
		super("Error: Top or pop method was called on an empty stack");
	}
}
