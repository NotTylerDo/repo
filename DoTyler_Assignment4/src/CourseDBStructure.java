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
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * CourseDBStructure class
 * @author Tyler Do
 * */
public class CourseDBStructure implements CourseDBStructureInterface {
	protected int hashSize;
	protected LinkedList<CourseDBElement>[] hash;
	protected final double loadFactor = 1.5;

	
	/**
	 * Constructor that takes in an integer n and determines the size of the hash Table by 
	 * finding a 4k + 3 prime number just greater than n/loading factor
	 * @param estimatedN the integer n that is the estimated number of courses
	 * */
	public CourseDBStructure(int estimatedN){
		boolean primeStatus = false;
		int prime = (int)(estimatedN/loadFactor);
		int x = 1;
		int realPrime = 4 * x + 3;
		while(prime != realPrime) {
			while(realPrime < prime || !isPrime(realPrime)) {
				x++;
				realPrime = 4 * x + 3;
			}
			prime++;	
		}
	
		while (!primeStatus) {
			if ((double)((prime - 3) / 4 ) - (int)((prime - 3) / 4 ) != 0 ) {
				primeStatus = false;
				prime++;
			}
			else 
				primeStatus = true;
		}
		hashSize = prime;
		hash = new LinkedList[hashSize];
	}

	/**
	 * Testing constructor used only for testing
	 * @param testing
	 * @param estimatedN
	 * */
	public CourseDBStructure(String testing, int estimatedN){
		hashSize = estimatedN;
		hash = new LinkedList[hashSize];
	}
	
	/**
	 * Finds if the number is a prime number
	 * @param num the number to see if it is a prime number
	 * @return status whether or not the number is a prime number
	 * */
	public boolean isPrime(int num) {
		boolean status = true;
		for (int i = 2; i < (num - 1); i++) {
			if (num % i == 0){
				status = false;
			}
		}
		return status;
	}
	
	
	@Override
	/** 
	* Adds a CourseDBElement object to the CourseDBStructure using the hashcode
	* of the CourseDatabaseElemen object's crn value.
	* If the CourseDatabaseElement already exists, exit quietly
	*  
	* @param element the CourseDBElement to be added to CourseDBStructure
	*/
	public void add(CourseDBElement element) {
		int hashCode = String.valueOf(element.crn).hashCode();
		int hashCodeIndex = hashCode % hashSize;
		// Creates a linked list if it does not exist
		if (hash[hashCodeIndex] == null) {
			LinkedList<CourseDBElement> bucket = new LinkedList<>();
			hash[hashCodeIndex] = bucket;	
		}
		// Exits quietly if the element already exists. BUT now change it to the updated version
		for (int i = 0; i < hash[hashCodeIndex].size(); i++) {
			if (hash[hashCodeIndex].contains(element) || hash[hashCodeIndex].get(i).crn == element.crn) {
				hash[hashCodeIndex].get(i).courseID = element.courseID;
				hash[hashCodeIndex].get(i).numOfCredits = element.numOfCredits;
				hash[hashCodeIndex].get(i).instructorName = element.instructorName;
				hash[hashCodeIndex].get(i).roomNum = element.roomNum;
				return;
			}
		}
		hash[hashCodeIndex].add(element);
	}
	
	@Override
	/**
	 * Find a courseDatabaseElement based on the key (crn) of the
	 * courseDatabaseElement If the CourseDatabaseElement is found return it If not,
	 * throw an IOException
	 * 
	 * @param crn crn (key) whose associated courseDatabaseElement is to be returned
	 * @return a CourseDBElement whose crn is mapped to the key
	 * @throws IOException if key is not found
	 */
	public CourseDBElement get(int crn) throws IOException{
		int hashCode = String.valueOf(crn).hashCode();
		int hashCodeIndex = hashCode % hashSize;
		// If it is empty, which means that it does not exist.
		if (hash[hashCodeIndex] == null) {
			throw new IOException("CDE does not exist");
		}
		
		for(CourseDBElement element: hash[hashCodeIndex]) {
			if (element.crn == crn) {	
				// Course has been found and it matches
				return element;
			}
		}
		// Has gone through the bucket and course does not exist
		throw new IOException("CDE does not exist");
	
		
		
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
		
		for(LinkedList<CourseDBElement> hashElement: hash) {
			if (hashElement != null) {
				for (CourseDBElement bucketElement: hashElement) {
					list.add(bucketElement + "\n");
				}
			}
		}
		return list;
	}
	
	@Override
	/**
	* Returns the size of the ConcordanceDataStructure (number of indexes in the array)
	*/
	public int getTableSize() {
		// Not asking for the amount of element, but the initial size of the hashTable
		return hashSize;
	}

}
