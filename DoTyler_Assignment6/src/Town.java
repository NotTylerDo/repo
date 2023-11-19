/* Class: CMSC204
 * Instructor: Huseyin Aygun
 * Description: Create a program with classes to population a graph with towns and roads and can also 
 * find the path with the shortest distance between towns
 * Due: 11/20/23
 * Platform/Compiler: Eclipse
 * I pledge that I have completed the programming assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code to any student.
 * Tyler Do
 * */
import java.util.*;

/**
 * Town Class
 * @author Tyler Do
 * */
public class Town implements Comparable<Town>{
	private String townName;
	private ArrayList<Town> adjTowns; 
	private int weight;
	private Town backPathTown;
	
	/**
	 * Constructor 
	 * @param name the name 
	 * */
	public Town(String name){
		townName = name;
		adjTowns = new ArrayList<>();
		weight = 0;
		backPathTown = null;
	}
	
	/**
	 * Copy constructor
	 * @param templateTown the town to copy 
	 * */
	public Town(Town templateTown){
		townName = templateTown.townName;
		weight = templateTown.weight;
		backPathTown = templateTown.backPathTown;
		if (templateTown.adjTowns != null) {
		adjTowns = new ArrayList<Town>(templateTown.adjTowns);
		}
		else {
			adjTowns = new ArrayList<>();
		}
	}
	
	/**
	 * Sets the town's backPath 
	 * @param backPath the backPath to assign backPath to
	 * */
	public void setBackPath(Town backPath) {
		this.backPathTown = backPath;
	}
	
	/**
	 * Returns the town's backPath
	 * @return backPathTown the backPath town of the town
	 * */
	public Town getBackPath() {
		return backPathTown;
	}
	
	/**
	 * Sets the towns weight
	 * @param weight the weight 
	 * */
	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	/**
	 * Returns the towns weight
	 * @return weight the weight
	 * */
	public int getWeight() {
		return weight;
	}
	
	/**
	 * Returns the towns name
	 * @return townName the town's name
	 * */
	public String getName() {
		return townName;
	}
	
	@Override
	/**
	 * Compare to method
	 * @param o the town to compare to
	 * @return 0 if names are equal, a positive or negative number if names are not equal
	 * */
	public int compareTo(Town o) {
		if (this.townName.compareTo(o.townName) == 0) {
			return 0;
		}
		else if (this.townName.compareTo(o.townName) == 1) {
			return 1;
		}
		else 
			return -1;
	}
	
	@Override
	/**
	 * To string method
	 * @return the town's name
	 * */
	public String toString() {
		String str = "";
		str += townName;
		if (adjTowns != null && adjTowns.size() != 0) {
			str += "\nAdjacent Towns:";
			for (Town town: adjTowns) {
				String adjTownName = town.getName();
				str += "\t" + adjTownName;
			}
		}
		return str;
	}
	
	@Override
	/**
	 * Returns the hashcode for the name of the town
	 * @return the hashCode for the name of the town
	 * */
	public int hashCode() {
		return townName.hashCode();
		
	}
	

	@Override
	/**
	 * Returns whether the town names are equal
	 * @param obj the town obj to test the equality of
	 * @return whether the town names are equal
	 * */
	public boolean equals(Object obj){
		if (obj == null || obj.getClass() != this.getClass()) {
			return false;
		}
		
		if (townName.equals(((Town)obj).townName) ) {
		
				return true;
		}
		else 
			return false;
	} 
}
