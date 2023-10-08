/*
 * Class: CMSC204
 * Instructor: Huseyin Aygun
 * Description: Create a program that writes a generic double linked list class with an iterator, 
 * and a generic sorted double linked list class with an iterator that inherits from the generic double linked list class
 * Due: 10/9/23
 * Platform/Compiler: Eclipse
 * I pledge that I have completed the programming assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code to any student.
 * Tyler Do
 * */
import java.util.Comparator;
import java.util.ListIterator;
/**
 * SortedDoubleLinkedList Class
 * @author Tyler Do
 * */
public class SortedDoubleLinkedList<T> extends BasicDoubleLinkedList<T>   {

	private Comparator<T> comparator;
	
	/**
	 * Creates an empty list that is associated with the specified comparator
	 * @param compareableObject the comparator with an associated object
	 * */
	public SortedDoubleLinkedList(Comparator<T> compareableObject) {
		comparator = compareableObject;
	}
	
	/** 
	 * Inserts the specified element at the correct position in the sorted list
	 *@param data the data to be inserted into a node and inserted into the sorted list
	 * */
	public void add(T data) {
		Node node = new Node(data);
		if (head == null) {
					head = node;
					tail = node;	
		}
		else if (comparator.compare(head.data, node.data) > 0) {		
			node.prev = null;
			node.next = head;	
			head.prev = node;
			head = node;
				}
		else if (comparator.compare(tail.data, node.data) <=0) { 	
			node.prev = tail;
			node.next = null;
			tail.next = node;
			tail = node;	
		}
		else {
			
			Node current = new Node();
			current = head;
			while (current != null && comparator.compare(node.data, current.data) >= 0 ) {
				current = current.next;
			}
			current = current.prev;
			node.next = current.next;
			current.next.prev = node;
			node.prev = current;
			current.next = node;
		}
		size++;
	}
		
	
	@Override
	/**
	 * This operation is invalid for a sorted list
	 * @throws UnsupportedOperationException
	 * */
	public void addToEnd(T data) throws UnsupportedOperationException {
		throw new UnsupportedOperationException("Invalid operation for sorted list");
	}
	
	@Override
	/**
	 * This operation is invalid for a sorted list
	 * @throws UnsupportedOperationException
	 * */
	public void addToFront(T data) throws UnsupportedOperationException {
		throw new UnsupportedOperationException("Invalid operation for sorted list");
	}
	
	
	@Override
	/**
	 * Implements the iterator by calling the super class iterator method
	 * @return the iterator from the super method
	 * */
	public ListIterator<T> iterator(){
		return super.iterator();
	}
	
	@Override
	/**
	 * Implements the remove operation by calling the super class remove method
	 * @return the data removed from the super class remove method
	 * */
	public Node remove(T data, Comparator<T> comparator){
		// comparator in parameter is the one in remove() not the private one
		return super.remove(data, comparator);
	}
}
