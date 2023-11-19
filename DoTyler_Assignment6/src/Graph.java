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
 * Graph Class
 * @author Tyler Do
 * */
public class Graph implements GraphInterface<Town, Road> {
	private Set<Town> towns;
	private ArrayList<LinkedList<Road>> roads;
	private Set<Town> closed;
	
	/**
	 * Default Constructor
	 * */
	public Graph() {
		towns = new HashSet<Town>();
		roads = new ArrayList<LinkedList<Road>>();
	}
	
	@Override
	 /**
     * Returns an edge connecting source vertex to target vertex if such
     * vertices and such edge exist in this graph. Otherwise returns
     * null. If any of the specified vertices is null
     * returns null
     *
     * In undirected graphs, the returned edge may have its source and target
     * vertices in the opposite order.
     *
     * @param sourceVertex source vertex of the edge.
     * @param destinationVertex target vertex of the edge.
     *
     * @return an edge connecting source vertex to target vertex.
     */
    public Road getEdge(Town sourceVertex, Town destinationVertex) {
    	if (sourceVertex == null || destinationVertex == null) {
    		return null;
    	}
    	if (!towns.contains(sourceVertex) || !towns.contains(destinationVertex)) {
    		return null;
    	}
    	for (LinkedList<Road> roadLL : roads) {
    		for (Road road : roadLL) {
    			if (road.contains(sourceVertex) && road.contains(destinationVertex)) {
    				return road;
    			}
    		}
    	}
    	return null;
    }


	@Override
    /**
     * Creates a new edge in this graph, going from the source vertex to the
     * target vertex, and returns the created edge. 
     * 
     * The source and target vertices must already be contained in this
     * graph. If they are not found in graph IllegalArgumentException is
     * thrown.
     *
     *
     * @param sourceVertex source vertex of the edge.
     * @param destinationVertex target vertex of the edge.
     * @param weight weight of the edge
     * @param description description for edge
     *
     * @return The newly created edge if added to the graph, otherwise null.
     *
     * @throws IllegalArgumentException if source or target vertices are not
     * found in the graph.
     * @throws NullPointerException if any of the specified vertices is null.
     */
    public Road addEdge(Town sourceVertex, Town destinationVertex, int weight, String description) throws IllegalArgumentException, NullPointerException{
    	if (sourceVertex == null || destinationVertex == null) {
    		throw new NullPointerException();
    	}
    	else if (!towns.contains(sourceVertex) || !towns.contains(destinationVertex)) {
    		throw new IllegalArgumentException();
    	}
		else {
			Road road = new Road(sourceVertex, destinationVertex, weight, description);
			int index = -1;
				for (int i = 0; i < roads.size(); i++) {
					LinkedList<Road> roadLL = roads.get(i);
					if (roadLL != null && roadLL.getFirst().getSource().equals(sourceVertex)) {
						index = i;
						break;
					}
				}
			if (index == -1) {
				LinkedList<Road> roadLL = new LinkedList<Road>();
				roads.add(roadLL);
				roadLL.add(road);
			}
			else {
				roads.get(index).add(road);
			}
			return road;
		}
    }

	@Override
    /**
     * Adds the specified vertex to this graph if not already present. More
     * formally, adds the specified vertex, v, to this graph if
     * this graph contains no vertex u such that
     * u.equals(v). If this graph already contains such vertex, the call
     * leaves this graph unchanged and returns false. In combination
     * with the restriction on constructors, this ensures that graphs never
     * contain duplicate vertices.
     *
     * @param v vertex to be added to this graph.
     *
     * @return true if this graph did not already contain the specified
     * vertex.
     *
     * @throws NullPointerException if the specified vertex is null.
     */
    public boolean addVertex(Town v) throws NullPointerException {
		if (v == null) {
    		throw new NullPointerException();
    	}
		for (Town town : towns) {
			if (town.equals(v)) {
				return false;
			}
		}
		towns.add(v);
		return true;
	}

	@Override
    /**
     * Returns true if and only if this graph contains an edge going
     * from the source vertex to the target vertex. In undirected graphs the
     * same result is obtained when source and target are inverted. If any of
     * the specified vertices does not exist in the graph, or if is
     * null, returns false.
     *
     * @param sourceVertex source vertex of the edge.
     * @param destinationVertex target vertex of the edge.
     *
     * @return true if this graph contains the specified edge.
     */
    public boolean containsEdge(Town sourceVertex, Town destinationVertex) {
		if (towns.contains(sourceVertex) && towns.contains(destinationVertex)) {
			if (getEdge(sourceVertex, destinationVertex) != null) {
				return true;
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}
	}

	@Override
    /**
     * Returns true if this graph contains the specified vertex. More
     * formally, returns true if and only if this graph contains a
     * vertex u such that u.equals(v). If the
     * specified vertex is null returns false.
     *
     * @param v vertex whose presence in this graph is to be tested.
     *
     * @return true if this graph contains the specified vertex.
     */
    public boolean containsVertex(Town v) {
		if (v == null) {
			return false;
		}
		
		if (towns.contains(v)) {
			for (Town town : towns) {
				if (town.equals(v)) {
					return true;
				}
			}
			return false;
		}
		else {
			return false;
		}
	}

	@Override
    /**
     * Returns a set of the edges contained in this graph. The set is backed by
     * the graph, so changes to the graph are reflected in the set. If the graph
     * is modified while an iteration over the set is in progress, the results
     * of the iteration are undefined.
     *
     *
     * @return a set of the edges contained in this graph.
     */
    public Set<Road> edgeSet(){
		Set<Road> setOfRoads = new HashSet<Road>();
		for (LinkedList<Road> roadLL : roads) {
			if (roadLL != null) {
				for (Road road : roadLL) {
					if (road != null) {
						setOfRoads.add(road);
					}
				}
			}
		}
		return setOfRoads;
	}

	@Override
    /**
     * Returns a set of all edges touching the specified vertex (also
     * referred to as adjacent vertices). If no edges are
     * touching the specified vertex returns an empty set.
     *
     * @param vertex the vertex for which a set of touching edges is to be
     * returned.
     *
     * @return a set of all edges touching the specified vertex.
     *
     * @throws IllegalArgumentException if vertex is not found in the graph.
     * @throws NullPointerException if vertex is null.
     */
    public Set<Road> edgesOf(Town vertex) throws NullPointerException, IllegalArgumentException {
		Set<Road> setOfRoadsInThisTown = new HashSet<Road>();
		Set<Road> setOfRoads = new HashSet<Road>();
		try {
		if (vertex == null) {
    		throw new NullPointerException();
    	}
		if (!towns.contains(vertex)) {
    		throw new IllegalArgumentException();
    	}
		
		setOfRoads = edgeSet();
		for (Road road : setOfRoads) {
			if (road.contains(vertex)) {
				setOfRoadsInThisTown.add(road);
			}
		}
		}
		catch (NullPointerException e) {
			
		}
		catch (IllegalArgumentException e) {
			
		}
		
		return setOfRoadsInThisTown;
	}


	@Override
    /**
     * Removes an edge going from source vertex to target vertex, if such
     * vertices and such edge exist in this graph. 
     * 
     * If weight >- 1 it must be checked
     * If description != null, it must be checked 
     * 
     * Returns the edge if removed
     * or null otherwise.
     *
     * @param sourceVertex source vertex of the edge.
     * @param destinationVertex target vertex of the edge.
     * @param weight weight of the edge
     * @param description description of the edge
     *
     * @return The removed edge, or null if no edge removed.
     */
    public Road removeEdge(Town sourceVertex, Town destinationVertex, int weight, String description) {
		Iterator<LinkedList<Road>> iterator = roads.iterator();
		while (iterator.hasNext()) {
			LinkedList<Road> roadLL = iterator.next();
			Iterator<Road> roadIterator = roadLL.iterator();
			while (roadIterator.hasNext()) {
				Road road = roadIterator.next();
			if (road.getSource().equals(sourceVertex) && road.getDestination().equals(destinationVertex)
					|| road.getSource().equals(destinationVertex) && road.getDestination().equals(sourceVertex) ) {
				if (road.getWeight() == weight) {
					if (road.getName().equals(description)) {
						roadIterator.remove();
						return road;
					}
				}
			}
			}
			
			if (roadLL.isEmpty()) {
				iterator.remove();
			}
		}
		return null;
	}


	@Override
    /**
     * Removes the specified vertex from this graph including all its touching
     * edges if present. More formally, if the graph contains a vertex 
     * u such that u.equals(v), the call removes all edges
     * that touch u and then removes u itself. If no
     * such u is found, the call leaves the graph unchanged.
     * Returns true if the graph contained the specified vertex. (The
     * graph will not contain the specified vertex once the call returns).
     *
     * If the specified vertex is null returns false.
     *
     * @param v vertex to be removed from this graph, if present.
     *
     * @return true if the graph contained the specified vertex;
     * false otherwise.
     */
    public boolean removeVertex(Town v) {
		Set<Road> setOfRoadsInTown = new HashSet<Road>();
		
		if (v == null) {
			return false;
		}
		
		if (containsVertex(v)) {
			setOfRoadsInTown = edgesOf(v);
			if (setOfRoadsInTown != null) {
				for (Road road : setOfRoadsInTown) {
					removeEdge(road.getSource(), road.getDestination(), road.getWeight(), road.getName());	
				}
			}
			towns.remove(v);
			return true;
		}
		else {
			return false;
		}
	}

	@Override
    /**
     * Returns a set of the vertices contained in this graph. The set is backed
     * by the graph, so changes to the graph are reflected in the set. If the
     * graph is modified while an iteration over the set is in progress, the
     * results of the iteration are undefined.
     *
     *
     * @return a set view of the vertices contained in this graph.
     */
    public Set<Town> vertexSet(){
		Set<Town> setOfTowns = new HashSet<Town>();
		for (Town town : towns) {
			setOfTowns.add(town);
		}
		return setOfTowns;
	}
    
	@Override
    /**
     * Find the shortest path from the sourceVertex to the destinationVertex
     * call the dijkstraShortestPath with the sourceVertex
     * @param sourceVertex starting vertex
     * @param destinationVertex ending vertex
     * @return An arraylist of Strings that describe the path from sourceVertex
     * to destinationVertex
     * They will be in the format: startVertex "via" Edge "to" endVertex weight
	 * As an example: if finding path from Vertex_1 to Vertex_10, the ArrayList<String>
	 * would be in the following format(this is a hypothetical solution):
	 * Vertex_1 via Edge_2 to Vertex_3 4 (first string in ArrayList)
	 * Vertex_3 via Edge_5 to Vertex_8 2 (second string in ArrayList)
	 * Vertex_8 via Edge_9 to Vertex_10 2 (third string in ArrayList)
     */   
    public ArrayList<String> shortestPath(Town sourceVertex, Town destinationVertex){
		ArrayList<String> shortestPathTowns = new ArrayList<String>();
		dijkstraShortestPath(sourceVertex);
		String path;
		while (destinationVertex != null && !sourceVertex.equals(destinationVertex)&& destinationVertex.getBackPath() != null ) {
			Town town1 = destinationVertex.getBackPath();
			path = town1 + " via "; 
			path += getEdge(town1, destinationVertex).getName() + " to " + destinationVertex + " ";
			path += getEdge(town1, destinationVertex).getWeight() + " mi";
			shortestPathTowns.add(path);
			destinationVertex = town1;
		} 

		Collections.reverse(shortestPathTowns);
		return shortestPathTowns;	
	}
    
	@Override
    /**
     * Dijkstra's Shortest Path Method.  Internal structures are built which
     * hold the ability to retrieve the path, shortest distance from the
     * sourceVertex to all the other vertices in the graph, etc.
     * @param sourceVertex the vertex to find shortest path from
     * 
     */
    public void dijkstraShortestPath(Town sourceVertex) {
		Set<Town> open = new HashSet<Town>();
		closed = new HashSet<Town>();

		open = vertexSet();
		
		closed.add(sourceVertex);
		open.remove(sourceVertex); 
		sourceVertex.setWeight(0);
		while (!open.isEmpty() ) {
			int minWeight = Integer.MAX_VALUE;
			Town minAdjTown = null;
			for (Town town : closed) {
				for (Road road : edgesOf(town)) {
					Town adjTown;
					if (road.getSource().equals(town)) {
						adjTown = road.getDestination();
					}
					else {
						adjTown = road.getSource();
					}
					
					if (adjTown == null || !closed.contains(adjTown)) {
						int weight = town.getWeight() + road.getWeight();
						if (weight < minWeight) {
							minWeight = weight;
							minAdjTown = adjTown;
							adjTown.setBackPath(town);
						}	
					}
				}
			}
			if (minAdjTown != null) {
				minAdjTown.setWeight(minWeight);
				open.remove(minAdjTown);
				closed.add(minAdjTown);
			}
		} 
	} 
}

