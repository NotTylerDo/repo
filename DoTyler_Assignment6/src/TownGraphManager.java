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
import java.io.File;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

/**
 * TownGraphManager Class
 * @author Tyler Do
 * */
public class TownGraphManager implements TownGraphManagerInterface{
	private Graph graphManager;
	
	/**
	 * Default constructor
	 * */
	public TownGraphManager() {
		graphManager = new Graph();
	}
	@Override
	/**
	 * Adds a road with 2 towns and a road name
	 * @param town1 name of town 1 (lastname, firstname)
	 * @param town2 name of town 2 (lastname, firstname)
	 * @param roadName name of road
	 * @return true if the road was added successfully
	 */
	public boolean addRoad(String town1, String town2, int weight, String roadName) {
		Town town3 = getTown(town1);
		Town town4 = getTown(town2);
		
		graphManager.addEdge(town3, town4, weight, roadName);
		return graphManager.containsEdge(town3, town4);
		
	}
	
	@Override
	/**
	 * Returns the name of the road that both towns are connected through
	 * @param town1 name of town 1 (lastname, firstname)
	 * @param town2 name of town 2 (lastname, firstname)
	 * @return name of road if town 1 and town2 are in the same road, returns null if not
	 */
	public String getRoad(String town1, String town2) {
		Town town3 = getTown(town1);
		Town town4 = getTown(town2);
		if (!graphManager.containsEdge(town3, town4)) {
			return null;
		}
		return graphManager.getEdge(town3, town4).getName();
	}
	
	@Override
	/**
	 * Adds a town to the graph
	 * @param v the town's name  (lastname, firstname)
	 * @return true if the town was successfully added, false if not
	 */
	public boolean addTown(String v) {
		Town town = new Town(v);
		graphManager.addVertex(town);
		return graphManager.containsVertex(town);
	}
	
	@Override
	/**
	 * Gets a town with a given name
	 * @param name the town's name 
	 * @return the Town specified by the name, or null if town does not exist
	 */
	public Town getTown(String name) {
		for (Town town : graphManager.vertexSet()) {
			if(town.getName().equals(name)) {
				return town;
			}
		}
		return null; 
		
		
	}
	
	@Override
	/**
	 * Determines if a town is already in the graph
	 * @param v the town's name 
	 * @return true if the town is in the graph, false if not
	 */
	public boolean containsTown(String v) {
		Town town = getTown(v);
		if (graphManager.containsVertex(town)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	@Override
	/**
	 * Determines if a road is in the graph
	 * @param town1 name of town 1 (lastname, firstname)
	 * @param town2 name of town 2 (lastname, firstname)
	 * @return true if the road is in the graph, false if not
	 */
	public boolean containsRoadConnection(String town1, String town2) {
		Town town3 = getTown(town1);
		Town town4 = getTown(town2);
		if(graphManager.containsEdge(town3, town4)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	@Override
	/**
	 * Creates an arraylist of all road titles in sorted order by road name
	 * @return an arraylist of all road titles in sorted order by road name
	 */
	public ArrayList<String> allRoads(){
		ArrayList<String> strList = new ArrayList<String>();
		Set<Road> set = new HashSet<Road>();
		set = graphManager.edgeSet();
		
		for (Road road : set) {
			strList.add(road.getName());
		}
		
		Collections.sort(strList);
	
		return strList;
		
	}
	
	@Override
	/**
	 * Deletes a road from the graph
	 * @param town1 name of town 1 (lastname, firstname)
	 * @param town2 name of town 2 (lastname, firstname)
	 * @param roadName the road name
	 * @return true if the road was successfully deleted, false if not
	 */
	public boolean deleteRoadConnection(String town1, String town2, String road) {
		Town town3 = getTown(town1);
		Town town4 = getTown(town2);
		Road road2 = graphManager.getEdge(town3, town4);
		
		graphManager.removeEdge(town3, town4, road2.getWeight(), road);
		if (!graphManager.containsEdge(town3, town4)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	@Override
	/**
	 * Deletes a town from the graph
	 * @param v name of town (lastname, firstname)
	 * @return true if the town was successfully deleted, false if not
	 */
	public boolean deleteTown(String v) {
		Town town = getTown(v);
		graphManager.removeVertex(town);
		return !graphManager.containsVertex(town);
	}

	@Override
	/**
	 * Creates an arraylist of all towns in alphabetical order (last name, first name)
	 * @return an arraylist of all towns in alphabetical order (last name, first name)
	 */
	public ArrayList<String> allTowns(){

		ArrayList<String> strList = new ArrayList<String>();
		
		Set<Town> set = new HashSet<Town>();
		set = graphManager.vertexSet();
		
		for (Town town : set) {
			strList.add(town.getName());
		}
		
		
		Collections.sort(strList);
		return strList;

	}
	
	@Override
	/**
	 * Returns the shortest path from town 1 to town 2
	 * @param town1 name of town 1 (lastname, firstname)
	 * @param town2 name of town 2 (lastname, firstname)
	 * @return an Arraylist of roads connecting the two towns together, null if the
	 * towns have no path to connect them.
	 */
	public ArrayList<String> getPath(String town1, String town2) throws NullPointerException{
		ArrayList<String> path = new ArrayList<String>();
		
		Town town3 = getTown(town1);
		Town town4 = getTown(town2);
		try {
			if (!graphManager.containsVertex(town3) || !graphManager.containsVertex(town4)
					|| graphManager.edgesOf(town4).size() == 0 || graphManager.edgesOf(town3).size() == 0) {
				return path;
			}
			path = graphManager.shortestPath(town3, town4);
			if (path.size() <= 0) {
				return null;
			}
			else {
				return path;
			} 
		}
		catch(NullPointerException e) {
			throw new NullPointerException("There is no path");
		}
			
		
	}
	
	/**
	 * Reads from a file and adds to a graph
	 * @param file the file to read from
	 * @throws FileNotFoundException
	 * */
	public void populateTownGraph(File file) throws FileNotFoundException{
		try {
			Town town1, town2;
			
			int weight;
			String str = "";
			String[] split;
			Scanner fileReader = new Scanner(file);
			while (fileReader.hasNextLine()) {
				str = fileReader.nextLine();
				split = str.split(",");
				String split2 = split[1];
				String [] split3 = split2.split(";");
				town1 = new Town(split3[1]);
				town2 = new Town(split3[2]);
				weight = Integer.valueOf(split3[0]);
				graphManager.addVertex(town1);
				graphManager.addVertex(town2);
				graphManager.addEdge(town1, town2, weight, split[0]);
			}
			fileReader.close();
			
		}
		catch(FileNotFoundException e) {
			throw new FileNotFoundException();
		}
		
	}
}
