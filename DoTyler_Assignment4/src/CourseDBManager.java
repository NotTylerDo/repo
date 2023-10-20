/* Class: CMSC204
 * Instructor: Huseyin Aygun
 * Description: Create a program that creates a database of courses. It will read 
 * from a file of courses or allow the user to add one course at a time.
 * Due: 10/23/23
 * Platform/Compiler: Eclipse
 * I pledge that I have completed the programming assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code to any student.
 * Tyler Do
 * */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
/**
 * CourseDBManager class
 * @author Tyler Do
 * */
public class CourseDBManager implements CourseDBManagerInterface{

	CourseDBStructure cds = new CourseDBStructure(500);
	
	@Override
	/**
	 * Adds a course (CourseDBElement) with the given information
	 * to CourseDBStructure.
	 * @param id course id 
	 * @param crn course crn
	 * @param credits number of credits
	 * @param roomNum course room number
	 * @param instructor name of the instructor
	 */
	public void add(String id, int crn, int credits, String roomNum, String instructor) {
		CourseDBElement cde = new CourseDBElement(id, crn, credits, roomNum, instructor);
		cds.add(cde);
	}
	
	@Override
	/**
	 * finds  CourseDBElement based on the crn key
	 * @param crn course crn (key)
	 * @return a CourseDBElement object
	 * @throws IOException 
	 * 
	 */
	public CourseDBElement get(int crn) throws IOException  {
		return cds.get(crn);	
	}
		
	
	@Override
	/**
	 * Reads the information of courses from a test file and adds them
	 * to the CourseDBStructure data structure
	 * @param input input file 
	 * @throws FileNotFoundException if file does not exists
	 */
	public void readFile(File input) throws FileNotFoundException{
		try {
		Scanner fileReader = new Scanner(input);
		while (fileReader.hasNextLine()) {
			String str = fileReader.nextLine();
			String[] split = str.split(" ");
			
			String courseID = split[0];
			int crn = Integer.parseInt(split[1]);
			int numOfCredits = Integer.parseInt(split[2]);
			String roomNum = split[3];
			String instructorName = split[4];
			for (int i = 5; i < split.length; i++) {
				instructorName += " " + split[i];
			}
			CourseDBElement element = new CourseDBElement(courseID, crn, numOfCredits, roomNum, instructorName);
			cds.add(element);
		}
		fileReader.close();
		}
		catch(FileNotFoundException e) {
		}
	}
	
	@Override
	/**
	 * @return an array list of string representation of each course in 
	 * the data structure separated by a new line. 
	 * Refer to the following example:
	 * Course:CMSC500 CRN:39999 Credits:4 Instructor:Nobody InParticular Room:SC100
	 * Course:CMSC600 CRN:4000 Credits:4 Instructor:Somebody Room:SC200
	 */
	public ArrayList<String> showAll(){
		ArrayList<String> list = new ArrayList<>();
		for (LinkedList<CourseDBElement> hashTable: cds.hash) {
			if (hashTable != null) {
				for (CourseDBElement bucketElement: hashTable) {
					String str = "\nCourse:" + bucketElement.courseID + " CRN:" + bucketElement.crn +
							" Credits:" + bucketElement.numOfCredits + " Instructor:" + bucketElement.instructorName
							+ " Room:" + bucketElement.roomNum;
					list.add(str);
				}
			}
		}
		return list;
	}
}
