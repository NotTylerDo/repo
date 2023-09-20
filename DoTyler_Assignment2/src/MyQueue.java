/**
 * MyQueue Class
 * @author Tyler Do
 * */
import java.util.ArrayList;

public class MyQueue<T> implements QueueInterface<T>  {
	
	private int size = 5;
	private ArrayList<T> queue;
	
	/** provide two constructors 
	 * 1. takes an int as the size of the queue
	 * 2. default constructor - uses a default as the size of the queue
	 * @param size The size of the queue
	 */
	public MyQueue(int size) {
		this.size = size;
		queue = new ArrayList<T>(this.size);
	}
	
	public MyQueue() {
		queue = new ArrayList<T>(size);
	}

	/**
	 * Determines if Queue is empty
	 * @return true if Queue is empty, false if not
	 */
	@Override
	public boolean isEmpty() {
		boolean status = false;
		if (size() == 0)
			status = true;
		return status;
	}

	/**
	 * Determines of the Queue is Full
	 * @return true if Queue is full, false if not
	 */
	@Override
	public boolean isFull() {
		boolean status = false;
		if (size() == size)
			status = true;
		return status;
	}
	
	/**
	 * Deletes and returns the element at the front of the Queue
	 * @return the element at the front of the Queue
	 * @throws QueueUnderflowException if queue is empty
	 */
	@Override
	public T dequeue() throws QueueUnderflowException{
		T element;
		if (isEmpty() == true)
			throw new QueueUnderflowException();
		element = queue.get(0);
		queue.remove(0);
		return element;
	}

	/**
	 * Returns number of elements in the Queue
	 * @return the number of elements in the Queue
	 */
	@Override
	public int size() {
		int size = 0;
		for (T element : queue) {
			if (element != null)
				size++;
		}
		return size;
	}
	
	/**
	 * Adds an element to the end of the Queue
	 * @param e the element to add to the end of the Queue
	 * @return true if the add was successful
	 * @throws QueueOverflowException if queue is full
	 */
	@Override
	public boolean enqueue(T e) throws QueueOverflowException{
		if(isFull())
			throw new QueueOverflowException();
		
		queue.add(e);	
		return true;
		
		
	}
	
	
	/**
	 * Returns the string representation of the elements in the Queue, 
	 * the beginning of the string is the front of the queue
	 * @return string representation of the Queue with elements
	 */
	@Override
	public String toString() {
		String str = "";
		for (int i = 0; i < size(); i++) {
			str += queue.get(i);
		}
		return str;
	}
	
	/**
	 * Returns the string representation of the elements in the Queue, the beginning of the string is the front of the queue
	 * Place the delimiter between all elements of the Queue
	 * @return string representation of the Queue with elements separated with the delimiter
	 */
	@Override
	public String toString(String delimiter) {
		String str = "";
		for (int i = 0; i < queue.size(); i++) {
			str += queue.get(i);
			if(i < size() - 1)
				str += delimiter;
		}
		return str;
	}
	
	 /**
	  * Fills the Queue with the elements of the ArrayList, First element in the ArrayList
	  * is the first element in the Queue
	  * YOU MUST MAKE A COPY OF LIST AND ADD THOSE ELEMENTS TO THE QUEUE, if you use the
	  * list reference within your Queue, you will be allowing direct access to the data of
	  * your Queue causing a possible security breech.
	  * @param list elements to be added to the Queue
	  * @throws QueueOverflowException if queue is full
	  */
	@Override
	public void fill(ArrayList<T> list)  {
		for(int i = 0; i < list.size(); i++) {
			try{
				enqueue(list.get(i));
			}
			catch(Exception e) {
			}
			
		}
	}
	

}
