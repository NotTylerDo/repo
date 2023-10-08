

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;




public class BasicDoubleLinkedListStudentTest {

	BasicDoubleLinkedList<Double> linkedDouble;
	
	DoubleComparator comparatorD;
	

	@Before
	public void setUp() throws Exception {
		
		linkedDouble = new BasicDoubleLinkedList<Double>();
		linkedDouble.addToEnd(7.0);
		linkedDouble.addToEnd(10.0);
		linkedDouble.addToEnd(9.0);
		comparatorD = new DoubleComparator();
		


		ArrayList<Double> fill = new ArrayList<>();
		fill.add(7.0);
		fill.add(9.0);
		fill.add(10.0);
	
	}

	@After
	public void tearDown() throws Exception {
		
		linkedDouble = null;
		
		comparatorD = null;
	}

	@Test
	public void testGetSize() {
		
		assertEquals(3,linkedDouble.getSize());
		
	}
	
	@Test
	public void testAddToEnd() {
		assertEquals(9.0, linkedDouble.getLast(), 0.01);
		linkedDouble.addToEnd(10.0);
		assertEquals(10.0, linkedDouble.getLast(), 0.01);
	}
	
	@Test
	public void testAddToFront() {
		assertEquals(7.0, linkedDouble.getFirst(), 0.01);
		linkedDouble.addToFront(5.0);
		assertEquals(5.0, linkedDouble.getFirst(), 0.01);
	}
	
	@Test
	public void testGetFirst() {
		assertEquals(7.0, linkedDouble.getFirst(), 0.01);
		linkedDouble.addToFront(-10.0);
		assertEquals(-10.0, linkedDouble.getFirst(), 0.01);
		
	}

	@Test
	public void testGetLast() {
		assertEquals(9.0, linkedDouble.getLast(), 0.01);
		linkedDouble.addToEnd(7.7);
		assertEquals(7.7, linkedDouble.getLast(), 0.01);
	}
	
	@Test
	public void testToArrayList()
	{
	
		ArrayList<Double> fill = new ArrayList<>();
		fill.add(7.0);
		fill.add(9.0);
		fill.add(10.0);
		
		assertEquals(7.0,fill.get(0), 0.01);
		assertEquals(9.0,fill.get(1), 0.01);
		assertEquals(10.0,fill.get(2), 0.01);
		
		
	}
	
	@Test
	public void testIteratorSuccessfulNext() {
	
		
		
		linkedDouble.addToFront(12.0);
		linkedDouble.addToEnd(4.0);
		ListIterator<Double> iterator = linkedDouble.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals(12.0, iterator.next(),0.01);
		assertEquals(7.0, iterator.next(),0.01);
		assertEquals(10.0, iterator.next(),0.01);
		assertEquals(true, iterator.hasNext());
		assertEquals(9.0, iterator.next(), 0.01);

		
		
	}
	
	@Test
	public void testIteratorSuccessfulPrevious() {
		
		linkedDouble.addToFront(12.0);
		linkedDouble.addToEnd(4.0);
		ListIterator<Double> iterator = linkedDouble.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals(12.0, iterator.next(),0.01);
		assertEquals(7.0, iterator.next(),0.01);
		assertEquals(10.0, iterator.next(),0.01);
		assertEquals(true, iterator.hasNext());
		assertEquals(9.0, iterator.next(), 0.01);
		assertEquals(true, iterator.hasPrevious());
		assertEquals(9.0, iterator.previous(),0.01);
		assertEquals(10.0, iterator.previous(),0.01);
		assertEquals(7.0, iterator.previous(),0.01);
		assertEquals(12.0, iterator.previous(),0.01);

		
		
	}
	
	@Test
	public void testIteratorNoSuchElementExceptionNext() {
		
		
		ListIterator<Double> iterator = linkedDouble.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals(7.0, iterator.next(),0.01);
		assertEquals(10.0, iterator.next(),0.01);
		assertEquals(9.0, iterator.next(),0.01);
		assertEquals(false, iterator.hasNext());
		
		
		
		try{
			//no more elements in list
			iterator.next();
			assertTrue("Did not throw a NoSuchElementException",false);
		}
		catch (NoSuchElementException e)
		{
			assertTrue("Successfully threw a NoSuchElementException",true);
		}
		catch (Exception e)
		{
			assertTrue("Threw an exception other than the NoSuchElementException", false);
		}
		
	}
	
	@Test
	public void testIteratorNoSuchElementExceptionPrevious() {
		linkedDouble.addToFront(12.0);
		linkedDouble.addToEnd(4.0);
		ListIterator<Double> iterator = linkedDouble.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals(12.0, iterator.next(),0.01);
		assertEquals(7.0, iterator.next(),0.01);
		assertEquals(10.0, iterator.next(),0.01);
		assertEquals(true, iterator.hasNext());
		assertEquals(9.0, iterator.next(), 0.01);
		assertEquals(true, iterator.hasPrevious());
		assertEquals(9.0, iterator.previous(),0.01);
		assertEquals(10.0, iterator.previous(),0.01);
		assertEquals(7.0, iterator.previous(),0.01);
		assertEquals(12.0, iterator.previous(),0.01);
		assertEquals(false, iterator.hasPrevious());
		
		
		
		try{
			//no more elements in list
			iterator.previous();
			assertTrue("Did not throw a NoSuchElementException",false);
		}
		catch (NoSuchElementException e)
		{
			assertTrue("Successfully threw a NoSuchElementException",true);
		}
		catch (Exception e)
		{
			assertTrue("Threw an exception other than the NoSuchElementException", false);
		}
		
	}
	
	@Test
	public void testIteratorUnsupportedOperationException() {
	
		

		ListIterator<Double> iterator = linkedDouble.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals(7.0, iterator.next(),0.01);
		assertEquals(10.0, iterator.next(),0.01);
		assertEquals(9.0, iterator.next(),0.01);
		assertEquals(false, iterator.hasNext());
		
		
		try{
			//remove is not supported for the iterator
			iterator.remove();
			assertTrue("Did not throw a UnsupportedOperationException",false);
		}
		catch (UnsupportedOperationException e)
		{
			assertTrue("Successfully threw a UnsupportedOperationException",true);
		}
		catch (Exception e)
		{
			assertTrue("Threw an exception other than the UnsupportedOperationException", false);
		}
		
	}
	
	@Test
	public void testRemove() {
		
		assertEquals(7.0, linkedDouble.getFirst(), 0.01);
		assertEquals(9.0, linkedDouble.getLast(), 0.01);
		linkedDouble.addToFront(0.0);
		assertEquals(0.0, linkedDouble.getFirst(), 0.01);
		linkedDouble.remove(0.0, comparatorD);
		linkedDouble.remove(9.0, comparatorD);
		assertEquals(7.0, linkedDouble.getFirst(), 0.01);
		assertEquals(10.0, linkedDouble.getLast(), 0.01);
		
		
		
		
	}

	@Test
	public void testRetrieveFirstElement() {
		
		assertEquals(7.0, linkedDouble.getFirst(), 0.01);
		linkedDouble.addToFront(6.0);
		assertEquals(6.0, linkedDouble.getFirst(), 0.01);
		assertEquals(6.0, linkedDouble.retrieveFirstElement(), 0.01);
		assertEquals(7.0, linkedDouble.getFirst(), 0.01);
		
		
	}

	@Test
	public void testRetrieveLastElement() {

		assertEquals(9.0, linkedDouble.getLast(), 0.01);
		linkedDouble.addToEnd(-11.0);
		assertEquals(-11.0, linkedDouble.getLast(), 0.01);
		assertEquals(-11.0, linkedDouble.retrieveLastElement(), 0.01);
		assertEquals(9.0, linkedDouble.getLast(), 0.01);
	}

	
	
	private class DoubleComparator implements Comparator<Double>
	{

		@Override
		public int compare(Double arg0, Double arg1) {
			// TODO Auto-generated method stub
			return arg0.compareTo(arg1);
		}
		
	}
	
}
