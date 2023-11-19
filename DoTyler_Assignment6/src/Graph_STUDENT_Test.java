import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Graph_STUDENT_Test
 * @author Tyler Do
 * */
public class Graph_STUDENT_Test {
	private GraphInterface<Town,Road> graph;
	private Town[] town;

	@Before
	public void setUp() throws Exception {
		 graph = new Graph();
		 town = new Town[9];
		  
		  for (int i = 0; i < 9; i++) {
			  town[i] = new Town("Town_" + i);
			  graph.addVertex(town[i]);
		  }
		  graph.addEdge(town[0], town[1], 4, "Road_1");
		  graph.addEdge(town[0], town[7], 8, "Road_2");
		  graph.addEdge(town[1], town[2], 8, "Road_3");
		  graph.addEdge(town[7], town[8], 7, "Road_4");
		  graph.addEdge(town[7], town[6], 1, "Road_5");
		  graph.addEdge(town[1], town[7], 11, "Road_6");
		  graph.addEdge(town[6], town[5], 2, "Road_7");
		  graph.addEdge(town[6], town[8], 6, "Road_8");
		  graph.addEdge(town[2], town[8], 2, "Road_9");
		  graph.addEdge(town[2], town[5], 4, "Road_10");
		  graph.addEdge(town[2], town[3], 7, "Road_11");
		  graph.addEdge(town[3], town[5], 14, "Road_12");
		  graph.addEdge(town[3], town[4], 9, "Road_13");
		  graph.addEdge(town[5], town[4], 10, "Road_14");
		  
	}

	@After
	public void tearDown() throws Exception {
		graph = null;
	}

	@Test
	public void testGetEdge() {
		assertEquals(new Road(town[5], town[4],10, "Road_14"), graph.getEdge(town[5], town[4]));
		assertEquals(new Road(town[0], town[7],8, "Road_2"), graph.getEdge(town[0], town[7]));
	}

	@Test
	public void testAddEdge() {
		assertEquals(false, graph.containsEdge(town[0], town[5]));
		graph.addEdge(town[0], town[5], 5, "Road_15");
		assertEquals(true, graph.containsEdge(town[0], town[5]));
	}

	@Test
	public void testAddVertex() {
		Town newTown = new Town("Town_9");
		assertEquals(false, graph.containsVertex(newTown));
		graph.addVertex(newTown);
		assertEquals(true, graph.containsVertex(newTown));
	}

	@Test
	public void testContainsEdge() {
		assertEquals(true, graph.containsEdge(town[2], town[5]));
		assertEquals(false, graph.containsEdge(town[8], town[5]));
	}

	@Test
	public void testContainsVertex() {
		assertEquals(true, graph.containsVertex(new Town("Town_2")));
		assertEquals(false, graph.containsVertex(new Town("Town_15")));
	}

	@Test
	public void testEdgeSet() {
		Set<Road> roads = graph.edgeSet();
		ArrayList<String> roadArrayList = new ArrayList<String>();
		for(Road road : roads)
			roadArrayList.add(road.getName());
		Collections.sort(roadArrayList);
		assertEquals("Road_1", roadArrayList.get(0));
		assertEquals("Road_10", roadArrayList.get(1));
		assertEquals("Road_11", roadArrayList.get(2));
		assertEquals("Road_12", roadArrayList.get(3));
		assertEquals("Road_3", roadArrayList.get(7));
		assertEquals("Road_9", roadArrayList.get(13));
	}

	@Test
	public void testEdgesOf() {
		Set<Road> roads = graph.edgesOf(town[1]);
		ArrayList<String> roadArrayList = new ArrayList<String>();
		for(Road road : roads)
			roadArrayList.add(road.getName());
		Collections.sort(roadArrayList);
		assertEquals("Road_1", roadArrayList.get(0));
		assertEquals("Road_3", roadArrayList.get(1));
		assertEquals("Road_6", roadArrayList.get(2));
	}
	
	@Test
	public void testRemoveEdge() {
		assertEquals(true, graph.containsEdge(town[8], town[6]));
		graph.removeEdge(town[8], town[6], 6, "Road_8");
		assertEquals(false, graph.containsEdge(town[8], town[6]));
	}
	
	@Test
	public void testRemoveVertex() {
		assertEquals(true, graph.containsVertex(town[5]));
		graph.removeVertex(town[5]);
		assertEquals(false, graph.containsVertex(town[5]));
	}

	@Test
	public void testVertexSet() {
		Set<Town> roads = graph.vertexSet();
		assertEquals(true,roads.contains(town[0]));
		assertEquals(true, roads.contains(town[8]));
		assertEquals(true, roads.contains(town[1]));
		assertEquals(true, roads.contains(town[2]));
		assertEquals(true, roads.contains(town[3]));
	}

	 @Test
	  public void testTown_0ToTown_4() {
		  String beginTown = "Town_0", endTown = "Town_4";
		  Town beginIndex=null, endIndex=null;
		  Set<Town> towns = graph.vertexSet();
		  Iterator<Town> iterator = towns.iterator();
		  while(iterator.hasNext())
		  {    	
			  Town town = iterator.next();
			  if(town.getName().equals(beginTown))
				  beginIndex = town;
			  if(town.getName().equals(endTown))
				  endIndex = town;		
		  }
		  if(beginIndex != null && endIndex != null)
		  {

			  ArrayList<String> path = graph.shortestPath(beginIndex,endIndex);
			  assertNotNull(path);
			  assertTrue(path.size() > 0);
			  assertEquals("Town_0 via Road_2 to Town_7 8 mi",path.get(0).trim());
			  assertEquals("Town_7 via Road_5 to Town_6 1 mi",path.get(1).trim());
			  assertEquals("Town_6 via Road_7 to Town_5 2 mi",path.get(2).trim());
			  assertEquals("Town_5 via Road_14 to Town_4 10 mi",path.get(3).trim());
		  }
		  else
			  fail("Town names are not valid");

	  }
	  
	  
	  @Test
	  public void testTown2ToTown_8() {
		  String beginTown = "Town_2", endTown = "Town_8";
		  Town beginIndex=null, endIndex=null;
		  Set<Town> towns = graph.vertexSet();
		  Iterator<Town> iterator = towns.iterator();
		  System.out.println(0);
		  while(iterator.hasNext())
		  {    	
			  System.out.println(1);
			  Town town = iterator.next();
			  if(town.getName().equals(beginTown))
				  beginIndex = town;
			  if(town.getName().equals(endTown))
				  endIndex = town;		
		  }
		  if(beginIndex != null && endIndex != null)
		  {System.out.println(2);

			  ArrayList<String> path = graph.shortestPath(beginIndex,endIndex);
			  assertNotNull(path);
			  assertTrue(path.size() > 0);
			  assertEquals("Town_2 via Road_9 to Town_8 2 mi",path.get(0).trim());
			  
		  }
		  else
			  fail("Town names are not valid");

	  }
	  
	  @Test
	  public void testTown_1ToTown_5() {
		  String beginTown = "Town_1", endTown = "Town_5";
		  Town beginIndex=null, endIndex=null;
		  Set<Town> towns = graph.vertexSet();
		  Iterator<Town> iterator = towns.iterator();
		  while(iterator.hasNext())
		  {    	
			  Town town = iterator.next();
			  if(town.getName().equals(beginTown))
				  beginIndex = town;
			  if(town.getName().equals(endTown))
				  endIndex = town;		
		  }
		  if(beginIndex != null && endIndex != null)
		  {

			  ArrayList<String> path = graph.shortestPath(beginIndex,endIndex);
			  assertNotNull(path);
			  assertTrue(path.size() > 0);
			  assertEquals("Town_1 via Road_3 to Town_2 8 mi",path.get(0).trim());
			  assertEquals("Town_2 via Road_10 to Town_5 4 mi",path.get(1).trim());
			 
		  }
		  else
			  fail("Town names are not valid");

	  }
}