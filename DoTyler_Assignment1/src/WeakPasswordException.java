/*
 * WeakPasswordException Class
 * @author Tyler Do
 * */
public class WeakPasswordException extends Exception {
	/**
	 * Default constructor that displays message in case of this exception
	 * */
	public WeakPasswordException() {
		super("The password is OK but weak - it contains fewer than 10 characters");
	}
}
