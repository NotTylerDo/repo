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

import java.util.ListIterator;
import java.util.Comparator;
import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 * BasicDoubleLinkedList Class
 * @author Tyler Do
 * */
public class BasicDoubleLinkedList<T> implements Iterable<T> {

	protected Node head;
	protected Node tail;
	protected int size;
	
	/**
	 * Constructor to set to initialize head, tail, and size to null, null, and 0
	 * */
	public BasicDoubleLinkedList() {
		head = null;
		tail = null;
		size = 0;
	}
	
	/**
	 * Returns the number of nodes in the list
	 * @return size the number of nodes in the list
	 * */
	public int getSize() {
		return size;
	}
	
	/**
	 * Adds an element to the end of the list and updates the size of the list
	 * @param data the element to be added
	 * */
	public void addToEnd(T data) {
		Node node = new Node(data);
		if (head == null && tail == null) {
			head = node;
			tail = node;
			head.prev = null;
			tail.next = null;
		}
		else {
			tail.next = node;
			node.prev = tail;
			tail = node;
			node.next = null;
		}
		size++;

	}
	
	/**
	 * Adds element to the front of the list and updates the size of the list
	 * @param data the element to be added
	 * */
	public void addToFront(T data) {
		Node node = new Node(data);
		if (head == null && tail == null) {
			head = node;
			tail = node;
			head.prev = null;
			tail.next = null;
		}
		else {
			head.prev = node;
			node.next = head;
			head = node;
			node.prev = null;
		}
		size++;
	}
	
	/**
	 * Returns but does not remove the first element of the list
	 * @return the first element of the list or null if empty
	 * */
	public T getFirst() {
		if (head == null && tail == null)
			return null;
		else {
			return head.data;
		}
	}
	
	/**
	 * Returns but does not remove the last element of the list
	 * @return the last element of the list or null if empty
	 * */
	public T getLast() {
		if (head == null && tail == null)
			return null;
		else {
			return tail.data;
		}
	}
	
	/**
	 * Returns the object of the DoubleLinkedListIterator
	 * @return the object of the DoubleLinkedListIterator
	 * */
	public ListIterator<T> iterator(){
		return new DoubleLinkedListIterator();
	}
	
	/**
	 * Remove the first instance of the target element from the list
	 * @param targetData the target data to be removed
	 * @param comparator the comparator object used to compare data 
	 * @return node that is remove or null if not there
	 * */
	public Node remove(T targetData, Comparator<T> comparator){
		Node node = head;
	
		while (node != null) {
			int comparatorValue = comparator.compare(node.data, targetData);
			if (comparatorValue == 0) {
				if(node == head) {
					head = node.next;
					node.next.prev = null;
				}
				else if (node == tail) {
					tail = node.prev;
					node.prev.next = null;
				}
				else {
					node.next.prev = node.prev;
					node.prev.next = node.next;
				}
				node.prev = null;
				node.next = null;
				size--;
				return node;
			}
			node = node.next;
		}
		return null;
	}
	
	/**
	 * Removes and return the first element of the list
	 * @return the first element of the list or null if the list is empty
	 * */
	public T retrieveFirstElement() {
		Node node = head;
		if (head == null && tail == null)
			return null;
		head = node.next;
		node.next.prev = null;
		node.next = null;
		node.prev = null;
		size--;
		return node.data;
	}
	
	/**
	 * Removes and returns the last element of the list
	 * @return the last element of the list or null if the list is empty
	 * */
	public T retrieveLastElement() {
		Node node = tail;
		if (head == null && tail == null)
			return null;
		tail = node.prev;
		node.prev.next = null;
		node.next = null;
		node.prev = null;
		size--;
		return node.data;
	}
	
	/**
	 * Returns an arrayList of the items
	 * @return arrayList the arraylist of the items 
	 * */
	public ArrayList<T> toArrayList(){
		ArrayList<T> arrayList = new ArrayList<>();
		Node node = head;
		while (node != null) {
			arrayList.add(node.data);
			node = node.next;
		}
		return arrayList;
	}
	
	/**
	 * A generic inner class Node
	 * */
	protected class Node extends Object{
		protected T data;
		protected Node prev;
		protected Node next;
		
		/**
		 * Default constructor that sets data, prev, and next to null
		 * */
		public Node() {
			data = null;
			prev = null;
			next = null;
		}
		
		/**
		 * Constructor that sets data to given dataNode and prev and next to null
		 * @param dataNode the data to be assigned to data
		 * */
		public Node(T dataNode) {
			data = dataNode;
			prev = null;
			next = null;
		}
	}
	
	/**
	 * A generic inner class named DoubleLinkedListIterator that implements java's 
	 * ListIterator interface
	 * */
	protected class DoubleLinkedListIterator implements ListIterator<T> {
		 Node currentPointer;
		 Node prevPointer;
		 
		/**
		 * Default constructor to initialize the current pointer to the head of the 
		 * BasicDoubleLinkedList
		 * */
		public DoubleLinkedListIterator() {
			currentPointer = head;
			prevPointer = null;
		}
		
		@Override
		/**
		 * Checks to see if there is an element after the pointer
		 * @return whether there is an element after the pointer
		 * */
		public boolean hasNext() {
			if (currentPointer == null)
				return false;
			else {
				return true;
			}
		}
	
		@Override
		/**
		 * Moves the current pointer to the next element 
		 * @return the data that the pointer is on 
		 * @throws NoSuchElementException
		 * */
		public T next() throws NoSuchElementException {
			if (hasNext()) {
				prevPointer = currentPointer;
				currentPointer = currentPointer.next;
				return prevPointer.data;
			}
			else {
				throw new NoSuchElementException();
			}
		}
		
		@Override 
		/**
		 * Checks to see if there is an element before the pointer
		 * @return whether there is an element before the pointer
		 * */
		public boolean hasPrevious() {
			if (prevPointer == null)
				return false;
			else 
				return true;
		}
		
		@Override
		/**
		 * Moves the current pointer to the previous element 
		 * @return the data that the pointer is on 
		 * @throws NoSuchElementException
		 * */
		public T previous() throws NoSuchElementException {
			if (hasPrevious()) {
				currentPointer = prevPointer;
				prevPointer = prevPointer.prev;
				return currentPointer.data;
			}
			else {
				throw new NoSuchElementException();	
			}
		}

		@Override
		/**
		 * This operation is invalid for a double linked list
		 * @throws UnsupportedOperationException
		 * */
		public void remove() throws UnsupportedOperationException {
			throw new UnsupportedOperationException("Invalid operation for basic list");
		}
		
		@Override
		/**
		 * This operation is invalid for a double linked
		 * list
		 * @throws UnsupportedOperationException
		 * */
		public void add(T arg0) throws UnsupportedOperationException {
			throw new UnsupportedOperationException("Invalid operation for basic list");
		}
		
		@Override
		/**
		 * This operation is invalid for a double linked list
		 * @throws UnsupportedOperationException
		 * */
		public int nextIndex() throws UnsupportedOperationException {
			throw new UnsupportedOperationException("Invalid operation for basic list");
		}
		
		@Override
		/**
		 * This operation is invalid for a double linked list
		 * @throws UnsupportedOperationException
		 * */
		public int previousIndex() throws UnsupportedOperationException {
			throw new UnsupportedOperationException("Invalid operation for basic list");
		}
		
		@Override
		/**
		 * This operation is invalid for a double linked list
		 * @throws UnsupportedOperationException
		 * */
		public void set(T arg0) throws UnsupportedOperationException {
			throw new UnsupportedOperationException("Invalid operation for basic list");
		}
		
		
	}
	
}
