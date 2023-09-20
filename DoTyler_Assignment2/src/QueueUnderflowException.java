/**
 * QueueUnderflowException Class
 * @author Tyler Do
 * */
public class QueueUnderflowException extends Exception{
	/**
	 * Default constructor that displays message in case of this exception
	 * */
	public QueueUnderflowException() {
		super("Error: Enqueue method was called on a full queue");
	}
}
