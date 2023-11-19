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
 * Road Class
 * @author Tyler Do
 * */
public class Road implements Comparable<Road>{
	private Town town1, town2;
	private int weight;
	private String name;
	
	/**
	 * Constructor 
	 * @param source the source Town
	 * @param destination the destination Town
	 * @param degrees the weight of the road
	 * @param name the name of the road
	 * */
	public Road(Town source, Town destination, int degrees, String name) {
		town1 = source;
		town2 = destination;
		weight = degrees;
		this.name = name;
	}
	
	/**
	 * Constructor with the weight preset at 1
	 * @param source the source Town
	 * @param destination the destination Town
	 * @param name the name of the road
	 * */
	public Road(Town source, Town destination, String name) {
		town1 = source;
		town2 = destination;
		this.name = name;
		weight = 1;
	}
	
	/**
	 * Returns true only if the edge contains the given town
	 * @param town the town to check if road contains it
	 * @return whether the edge is connected to the given vertex
	 * */
	public boolean contains(Town town){
		if(town.equals(town1) || town.equals(town2)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * Sets the weight of the road
	 * @param weight the weight to be assigned to the weight
	 * */
	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	/**
	 * Gets the name of the road
	 * @return name the name of the road
	 * */
	public String getName() {
		return name;
	}
	
	/**
	 * Gets the name of the destination town 
	 * @return town2 the name of the destination town
	 * */
	public Town getDestination() {
		return town2;
	}
	
	/**
	 * Gets the name of the source town 
	 * @return town1 the name of the source town
	 * */
	public Town getSource() {
		return town1;
	}
	
	/**
	 * Gets the weight of the road 
	 * @return weight the weight of the road
	 * */
	public int getWeight() {
		return weight;
	}
	
	
	@Override
	/**
	 * To string method
	 * @return str the string of the road information
	 * */
	public String toString() {
		String str = "";
		str += name + " connects " + town1.getName() + " and " + town2.getName();
		return str;
	}
	
	@Override
	/**
	 * Compares the road the the given road
	 * @param o the road to be compared to
	 * @return 0 if the road names are the same, a positive or negative number if 
	 * 			the roads are not the same
	 * */
	public int compareTo(Road o) {
		if (this.name.compareTo(o.name) == 0) {
			return 0;
		}
		else if (this.name.compareTo(o.name) == 1) {
			return 1;
		}
		else 
			return -1;
	}
	
	@Override
	/**
	 * Return true if each of the ends of the road r is the same as the ends of this road. Undirected Graph
	 * @param r the object to test the equality of
	 * @return whether the road object is equal to this road
	 * */
	public boolean equals(Object r) {
		if (r == null || r.getClass() != this.getClass()) {
			return false;
		}
		if (((Road)r).name.equals(name) && (((Road)r).town1.equals(town1) || ((Road)r).town1.equals(town2))
				&& (((Road)r).town2.equals(town1) || ((Road)r).town2.equals(town2))) {
			return true;
		}
		else 
			return false;
	}
	
	
	@Override
	/**
	 * Return the hashCode value of the road based on the name
	 * @return the hashCode value of the road based on the name
	 * */
	public int hashCode() {
		return name.hashCode();
	}
}
