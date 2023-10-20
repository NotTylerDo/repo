

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * This is the test file for the CourseDBManager
 * which is implemented from the CourseDBManagerInterface
 * 
 */
public class CourseDBManager_STUDENT_Test {
	private CourseDBManagerInterface dataMgr = new CourseDBManager();

	/**
	 * Create an instance of CourseDBManager
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		dataMgr = new CourseDBManager();
	}

	/**
	 * Set dataMgr reference to null
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		dataMgr = null;
	}

	/**
	 * Test for the add method
	 */
	@Test
	public void testAddToDB() {
		try {
			dataMgr.add("MATH182",33355,3,"BE120","Johnny Depp");
		}
		catch(Exception e) {
			fail("This should not have caused an Exception");
		}
	}
	
	/**
	 * Test for the showAll method
	 */
	@Test
	public void testShowAll() {
	
		dataMgr.add("MATH182",33355,3,"BE120","Johnny Depp");
		dataMgr.add("MATH184",33354,2,"BE121","Amber Heard");
		dataMgr.add("BIOL130",11111,4,"SC250","Jesus Jr.");
		ArrayList<String> list = dataMgr.showAll();
		assertEquals(list.get(1),"\nCourse:MATH182 CRN:33355 Credits:3 Instructor:Johnny Depp Room:BE120");
	 	assertEquals(list.get(0),"\nCourse:MATH184 CRN:33354 Credits:2 Instructor:Amber Heard Room:BE121");
		assertEquals(list.get(2),"\nCourse:BIOL130 CRN:11111 Credits:4 Instructor:Jesus Jr. Room:SC250");
	}
	
	/**
	 * Test for the read method
	 */
	@Test
	public void testRead() {
		try {
			File inputFile = new File("Test1.txt");
			System.out.println("1");
			PrintWriter inFile = new PrintWriter(inputFile);
			System.out.println("2");
			inFile.println("MATH182 33355 3 BE120 Johnny Depp");
			System.out.println("3");
			inFile.print("MATH184 33354 2 BE121 Amber Heard");
			System.out.println("4");
			
			inFile.close();
			System.out.println("5");
			dataMgr.readFile(inputFile);
			System.out.println("6");
			
			System.out.println(dataMgr.get(33355));
			System.out.println(dataMgr.get(33355).getID());
			assertEquals("MATH182",dataMgr.get(33355).getID());
			System.out.println("7");
			assertEquals("MATH184",dataMgr.get(33354).getID());
			System.out.println("8");
			assertEquals("BE120",dataMgr.get(33355).getRoomNum());
			System.out.println("9");
		} catch (Exception e) {
			fail("Should not have thrown an exception");
			System.out.println("10");
		}
	}
}
