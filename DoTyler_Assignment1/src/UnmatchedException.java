/*
 * UnmatchedException Class
 * @author Tyler Do
 * */
public class UnmatchedException extends Exception{
	/**
	 * Default constructor that displays message in case of this exception
	 * */
	public UnmatchedException() {
		super("The passwords do not match");
	}
}