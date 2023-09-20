/**
 * QueueOverflowException Class
 * @author Tyler Do
 * */
public class QueueOverflowException extends Exception {
	/**
	 * Default constructor that displays message in case of this exception
	 * */
	public QueueOverflowException() {
		super("Error: Dequeue method was called on an empty queue");
	}
}
