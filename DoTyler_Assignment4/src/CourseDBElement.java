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
/**
 * CourseDBElement Class
 * @author Tyler Do
 * */
public class CourseDBElement implements Comparable<CourseDBElement> {

	protected String courseID;
	protected int crn;
	protected int numOfCredits;
	protected String roomNum;
	protected String instructorName;
	
	/**
	 * Default constructor. Assigns all values 0 or null;
	 * */
	public CourseDBElement() {
		courseID = null;
		crn = 0;
		numOfCredits = 0;
		roomNum = null;
		instructorName = null;
	}
	
	/**
	 * Constructor that assigns values to fields
	 * @param courseID the course ID
	 * @param crn the course's CRN number
	 * @param numOfCredits the number of credits
	 * @param roomNum the room's number
	 * @param instructorName the name of the instructor
	 * */
	public CourseDBElement(String courseID, int crn, int numOfCredits, String roomNum, String instructorName) {
		this.courseID = courseID;
		this.crn = crn;
		this.numOfCredits = numOfCredits;
		this.roomNum = roomNum;
		this.instructorName = instructorName;
	}
	
	@Override
	/**
	 * Compares the course info by checking their crns
	 * @param courseInfo the CourseDBElement to be compared to
	 * @return int value depending on how the crns are compared
	 * */
	public int compareTo(CourseDBElement courseInfo) {
		if (crn == courseInfo.crn) 
			return 0;
		else if (crn > courseInfo.crn)
			return 1;
		else 
			return -1;
	}
	
	@Override
	/**
	 * Converts the course information into a string
	 * @return str the course information as a string
	 * */
	public String toString() {
		String str = "\nCourse:" + courseID + " CRN:" + crn +
				" Credits:" + numOfCredits + " Instructor:" + instructorName
				+ " Room:" + roomNum;
		return str;
	}
	
	/**
	 * Sets the course ID
	 * @param courseID courseID
	 * */
	public void setCourseID(String courseID) {
		this.courseID = courseID;
	}
	/**
	 * Sets the course crn
	 * @param crn course crn
	 * */
	public void setCRN(int crn) {
		this.crn = crn;
	}
	
	/**
	 * Sets the course's number of credits
	 * @param numOfCredits the number of credits for the course
	 * */
	public void setNumOfCredits(int numOfCredits) {
		this.numOfCredits = numOfCredits;
	}
	
	/**
	 * Sets the course's room number
	 * @param roomNum the room number
	 * */
	public void setRoomNum(String roomNum) {
		this.roomNum = roomNum;
	}
	
	/**
	 * Sets the course's instructor name
	 * @param instructorName the instructor's name
	 * */
	public void setInstructorName(String instructorName) {
		this.instructorName = instructorName;
	}
	
	/**
	 * returns the course ID
	 * @return courseID courseID
	 * */
	public String getID() {
		return courseID;
	}
	
	/**
	 * returns the course crn
	 * @return crn the course crn
	 * */
	public int getCRN() {
		return crn;
	}
	
	/**
	 * returns the course's number of credits
	 * @return numOfCredits the number of credits
	 * */
	public int getNumOfCredits() {
		return numOfCredits;
	}
	
	/**
	 * returns the course's room number
	 * @return roomNum the room number
	 * */
	public String getRoomNum() {
		return roomNum;
	}
	
	/**
	 * returns the course instructor name
	 * @return instructorName the instructor's name
	 * */
	public String getInstructorName() {
		return instructorName;
	}
	
	 

}
