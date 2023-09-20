/**
 * MyStack Class
 * @author Tyler Do
 * */
import java.util.ArrayList;

public class MyStack<T> implements StackInterface<T> {

	private int size = 5;
	private ArrayList<T> stack;
	/**
	 * Provide two constructors
	 * 1. takes in an int as the size of the stack
	 * 2. default constructor - uses default as the size of the stack
	 * @param size The size of the stack
	 */
	public MyStack(int size) {
		this.size = size;
		stack = new ArrayList<T>(this.size);
	}
	
	public MyStack() {
		stack = new ArrayList<T>(size);
	}
	
	/**
	 * Determines if Stack is empty
	 * @return true if Stack is empty, false if not
	 */
	@Override
	public boolean isEmpty() {
		boolean status = false;
		if (size() == 0)
			status = true;
		return status;
	}

	/**
	 * Determines if Stack is full
	 * @return true if Stack is full, false if not
	 */
	@Override
	public boolean isFull() {
		boolean status = false;
		if (size() == size)
			status = true;
		return status;
	}
	

	/**
	 * Deletes and returns the element at the top of the Stack
	 * @return the element at the top of the Stack
	 * @throws StackUnderflowException if stack is empty
	 */
	@Override
	public T pop() throws StackUnderflowException{
		T topElement;
		if (isEmpty())
			throw new StackUnderflowException();
		topElement = stack.get(size() - 1);
		stack.remove(size() - 1);
		return topElement;	
	}
	
	/**
	 * Returns the element at the top of the Stack, does not pop it off the Stack
	 * @return the element at the top of the Stack
	 * @throws StackUnderflowException if stack is empty
	 */
	@Override
	public T top() throws StackUnderflowException{
		T topElement;
		if (isEmpty())
			throw new StackUnderflowException();
		topElement = stack.get(size() - 1);
		return topElement;	
	}

	/**
	 * Number of elements in the Stack
	 * @return the number of elements in the Stack
	 */
	@Override
	public int size() {
		int size = 0;
		for (T element : stack) {
			if (element != null)
				size++;
		}
		return size;
	}
	
	/**
	 * Adds an element to the top of the Stack
	 * @param e the element to add to the top of the Stack
	 * @return true if the add was successful, false if not
	 * @throws StackOverflowException if stack is full
	 */
	@Override
	public boolean push(T e) throws StackOverflowException {

		if (isFull()) {
			throw new StackOverflowException();
		}
		stack.add(e);
		return true;
	}
	
	/**
	 * Returns the elements of the Stack in a string from bottom to top, the beginning 
	 * of the String is the bottom of the stack
	 * @return an string which represent the Objects in the Stack from bottom to top
	 */
	@Override
	public String toString() {
		String str = "";
		for (int i = 0; i < size(); i++) {
			str += stack.get(i);
		}
		return str;
	}
	
	/**
	 * Returns the string representation of the elements in the Stack, the beginning of the 
	 * string is the bottom of the stack
	 * Place the delimiter between all elements of the Stack
	 * @return string representation of the Stack from bottom to top with elements 
	 * separated with the delimiter
	 */
	@Override
	public String toString(String delimiter) {
		String str = "";
		for (int i = 0; i < stack.size(); i++) {
			str += stack.get(i);
			if(i < size() - 1)
				str += delimiter;
		}
		return str;
	}
	
	 /**
	  * Fills the Stack with the elements of the ArrayList, First element in the ArrayList
	  * is the first bottom element of the Stack
	  * YOU MUST MAKE A COPY OF LIST AND ADD THOSE ELEMENTS TO THE STACK, if you use the
	  * list reference within your Stack, you will be allowing direct access to the data of
	  * your Stack causing a possible security breech.
	  * @param list elements to be added to the Stack from bottom to top
	  * @throws StackOverflowException if stack gets full
	  */
	@Override
	public void fill(ArrayList<T> list) {
		for(int i = 0; i < list.size(); i++) {
			try{
				push(list.get(i));
			}
			catch(Exception e) {
			}
			
		}
	}
}
