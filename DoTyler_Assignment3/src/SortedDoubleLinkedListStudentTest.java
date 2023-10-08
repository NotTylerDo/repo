


import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;



public class SortedDoubleLinkedListStudentTest {
	
	SortedDoubleLinkedList<Double> sortedLinkedDouble;
	DoubleComparator comparatorD;

	
	@Before
	public void setUp() throws Exception {
		
		comparatorD = new DoubleComparator();
		sortedLinkedDouble = new SortedDoubleLinkedList<Double>(comparatorD);
		
	
	}

	@After
	public void tearDown() throws Exception {
		comparatorD = null;
		sortedLinkedDouble = null;
	}

	@Test
	public void testAddToEnd() {
		try {
			sortedLinkedDouble.addToEnd(12.0);
			assertTrue("Did not throw an UnsupportedOperationException", false);
		}
		catch (UnsupportedOperationException e)
		{
			assertTrue("Successfully threw an UnsupportedOperationException", true);
		}
		catch (Exception e)
		{
			assertTrue("Threw an exception other than the UnsupportedOperationException", false);
		}
	}

	@Test
	public void testAddToFront() {
		try {
			sortedLinkedDouble.addToFront(-15.0);
			assertTrue("Did not throw an UnsupportedOperationException", false);
		}
		catch (UnsupportedOperationException e)
		{
			assertTrue("Successfully threw an UnsupportedOperationException", true);
		}
		catch (Exception e)
		{
			assertTrue("Threw an exception other than the UnsupportedOperationException", false);
		}
	}

	@Test
	public void testIteratorSuccessfulNext() {
	
		
		sortedLinkedDouble.add(1.0);
		sortedLinkedDouble.add(21.0);
		sortedLinkedDouble.add(2.0);
		sortedLinkedDouble.add(1.0);
		sortedLinkedDouble.add(7.0);
		ListIterator<Double> iterator = sortedLinkedDouble.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals(1.0, iterator.next(),0.01);
		assertEquals(1.0, iterator.next(),0.01);
		assertEquals(2.0, iterator.next(),0.01);
		assertEquals(true, iterator.hasNext());
		
	}

	@Test
	public void testIteratorSuccessfulDoubleNext() {
		sortedLinkedDouble.add((Double)11.0);
		sortedLinkedDouble.add((Double)15.0);
		sortedLinkedDouble.add((Double)10.0);
		sortedLinkedDouble.add((Double)1.5);
		ListIterator<Double> iterator = sortedLinkedDouble.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals((Double)1.5, iterator.next());
		assertEquals((Double)10.0, iterator.next());
		assertEquals((Double)11.0, iterator.next());
		assertEquals(true, iterator.hasNext());	
		assertEquals((Double)15.0, iterator.next());
		}
	
	
	@Test
	public void testIteratorSuccessfulDoublePrevious() {
		sortedLinkedDouble.add((Double)18.0);
		sortedLinkedDouble.add((Double)1.0);
		sortedLinkedDouble.add((Double)1.0);
		sortedLinkedDouble.add((Double)16.0);
		ListIterator<Double> iterator = sortedLinkedDouble.iterator();
		assertEquals((Double)1.0, iterator.next());
		assertEquals((Double)1.0, iterator.next());
		assertEquals((Double)16.0, iterator.next());
		assertEquals(true, iterator.hasPrevious());
		assertEquals((Double)16.0, iterator.previous());
		assertEquals(true, iterator.hasPrevious());
	}
	
	@Test
	public void testIteratorNoSuchElementException() {
		sortedLinkedDouble.add((Double)18.0);
		sortedLinkedDouble.add((Double)1.0);
		sortedLinkedDouble.add((Double)1.0);
		sortedLinkedDouble.add((Double)16.0);
		
		ListIterator<Double> iterator = sortedLinkedDouble.iterator();
		
		assertEquals(true, iterator.hasNext());
		assertEquals(1.0, iterator.next(),0.01);
		assertEquals(1.0, iterator.next(),0.01);
		assertEquals(16.0, iterator.next(),0.01);
		assertEquals(true, iterator.hasNext());
		assertEquals(18.0, iterator.next(),0.01);
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
	public void testAddDouble() {
		sortedLinkedDouble.add(10.0);
		sortedLinkedDouble.add(11.0);
		sortedLinkedDouble.add(5.0);
		assertEquals(5.0, sortedLinkedDouble.getFirst(),0.01);
		assertEquals(11.0, sortedLinkedDouble.getLast(),0.01);
		sortedLinkedDouble.add(100.0);
		sortedLinkedDouble.add(1.0);
		assertEquals(1.0, sortedLinkedDouble.getFirst(),0.01);
		assertEquals(100.0, sortedLinkedDouble.getLast(),0.01);
		assertEquals(100.0, sortedLinkedDouble.retrieveLastElement(),0.01);
		assertEquals(11.0, sortedLinkedDouble.getLast(),0.01);
	
	}

	@Test
	public void testRemoveFirstDouble() {
		sortedLinkedDouble.add(10.0);
		sortedLinkedDouble.add(11.0);
		sortedLinkedDouble.add(5.0);
		assertEquals(5.0, sortedLinkedDouble.getFirst(),0.01);
		assertEquals(11.0, sortedLinkedDouble.getLast(),0.01);
		sortedLinkedDouble.add(0.0);
		assertEquals(0.0, sortedLinkedDouble.getFirst(),0.01);
		sortedLinkedDouble.remove(0.0, comparatorD);
		assertEquals(5.0, sortedLinkedDouble.getFirst(),0.01);
	}
	
	@Test
	public void testRemoveEndDouble() {
		sortedLinkedDouble.add(10.0);
		sortedLinkedDouble.add(11.0);
		sortedLinkedDouble.add(5.0);
		assertEquals(5.0, sortedLinkedDouble.getFirst(),0.01);
		assertEquals(11.0, sortedLinkedDouble.getLast(),0.01);
		sortedLinkedDouble.add(19.0);
		assertEquals(19.0, sortedLinkedDouble.getLast(),0.01);
		sortedLinkedDouble.remove(19.0, comparatorD);
		assertEquals(11.0, sortedLinkedDouble.getLast(),0.01);
		
	}

	@Test
	public void testRemoveMiddleDouble() {
		sortedLinkedDouble.add(10.0);
		sortedLinkedDouble.add(11.0);
		sortedLinkedDouble.add(5.0);
		assertEquals(5.0, sortedLinkedDouble.getFirst(),0.01);
		assertEquals(11.0, sortedLinkedDouble.getLast(),0.01);
		sortedLinkedDouble.add(7.0);
		sortedLinkedDouble.add(1.0);
		assertEquals(1.0, sortedLinkedDouble.getFirst(),0.01);
		assertEquals(11.0, sortedLinkedDouble.getLast(),0.01);
		assertEquals(5, sortedLinkedDouble.getSize());
		sortedLinkedDouble.remove(10.0, comparatorD);
		assertEquals(1.0, sortedLinkedDouble.getFirst(),0.01);
		assertEquals(11.0, sortedLinkedDouble.getLast(),0.01);
		assertEquals(4, sortedLinkedDouble.getSize());
		
		
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
