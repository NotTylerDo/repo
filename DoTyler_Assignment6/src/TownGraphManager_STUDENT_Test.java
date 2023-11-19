import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * TownGraphManager_STUDENT_Test Class
 * @author Tyler Do
 * */
public class TownGraphManager_STUDENT_Test {
	private TownGraphManagerInterface graph;
	private String[] town;
	  
	@Before
	public void setUp() throws Exception {
		  graph = new TownGraphManager();
		  town = new String[9];
		  
		  for (int i = 0; i < 9; i++) {
			  town[i] = "Town_" + i;
			  graph.addTown(town[i]);
		  }

		  graph.addRoad(town[0], town[1], 4, "Road_1");
		  graph.addRoad(town[0], town[7], 8, "Road_2");
		  graph.addRoad(town[1], town[2], 8, "Road_3");
		  graph.addRoad(town[7], town[8], 7, "Road_4");
		  graph.addRoad(town[7], town[6], 1, "Road_5");
		  graph.addRoad(town[1], town[7], 11, "Road_6");
		  graph.addRoad(town[6], town[5], 2, "Road_7");
		  graph.addRoad(town[6], town[8], 6, "Road_8");
		  graph.addRoad(town[2], town[8], 2, "Road_9");
		  graph.addRoad(town[2], town[5], 4, "Road_10");
		  graph.addRoad(town[2], town[3], 7, "Road_11");
		  graph.addRoad(town[3], town[5], 14, "Road_12");
		  graph.addRoad(town[3], town[4], 9, "Road_13");
		  graph.addRoad(town[5], town[4], 10, "Road_14");
	}

	@After
	public void tearDown() throws Exception {
		graph = null;
	}

	@Test
	public void testAddRoad() {
		ArrayList<String> roads = graph.allRoads();
		assertEquals("Road_1", roads.get(0));
		assertEquals("Road_10", roads.get(1));
		assertEquals("Road_11", roads.get(2));
		assertEquals("Road_12", roads.get(3));
		graph.addRoad(town[4], town[1], 1,"Road_15");
		roads = graph.allRoads();
		assertEquals("Road_1", roads.get(0));
		assertEquals("Road_10", roads.get(1));
		assertEquals("Road_11", roads.get(2));
		assertEquals("Road_12", roads.get(3));
		assertEquals("Road_15", roads.get(6));
		
	}

	@Test
	public void testGetRoad() {
		assertEquals("Road_7", graph.getRoad(town[6], town[5]));
		assertEquals("Road_11", graph.getRoad(town[3], town[2]));
	}

	@Test
	public void testAddTown() {
		assertEquals(false, graph.containsTown("Town_15"));
		graph.addTown("Town_15");
		assertEquals(true, graph.containsTown("Town_15"));
	}
	
	@Test
	public void testDisjointGraph() {
		assertEquals(false, graph.containsTown("Town_15"));
		graph.addTown("Town_1t");
		ArrayList<String> path = graph.getPath(town[0],"Town_15");
		assertFalse(path.size() > 0);
	}

	@Test
	public void testContainsTown() {
		assertEquals(true, graph.containsTown("Town_7"));
		assertEquals(false, graph.containsTown("Town_15"));
	}

	@Test
	public void testContainsRoadConnection() {
		assertEquals(true, graph.containsRoadConnection(town[1], town[7]));
		assertEquals(false, graph.containsRoadConnection(town[3], town[8]));
	}

	@Test
	public void testAllRoads() {
		ArrayList<String> roads = graph.allRoads();
		assertEquals("Road_1", roads.get(0));
		assertEquals("Road_10", roads.get(1));
		assertEquals("Road_11", roads.get(2));
		assertEquals("Road_6", roads.get(10));
		assertEquals("Road_7", roads.get(11));
	}

	@Test
	public void testDeleteRoadConnection() {
		assertEquals(true, graph.containsRoadConnection(town[0], town[1]));
		graph.deleteRoadConnection(town[0], town[1], "Road_1");
		assertEquals(false, graph.containsRoadConnection(town[0], town[1]));
	}

	@Test
	public void testDeleteTown() {
		assertEquals(true, graph.containsTown("Town_5"));
		graph.deleteTown(town[5]);
		assertEquals(false, graph.containsTown("Town_5"));
	}
	
	@Test
	public void testAllTowns() {
		ArrayList<String> roads = graph.allTowns();
		assertEquals("Town_0", roads.get(0));
		assertEquals("Town_1", roads.get(1));
		assertEquals("Town_2", roads.get(2));
		assertEquals("Town_6", roads.get(6));
		assertEquals("Town_5", roads.get(5));
	}

	@Test
	public void testGetPath() {
		ArrayList<String> path = graph.getPath(town[1],town[4]); 
		  assertNotNull(path);
		  assertTrue(path.size() > 0);
		  assertEquals("Town_1 via Road_3 to Town_2 8 mi",path.get(0).trim());
		  assertEquals("Town_2 via Road_10 to Town_5 4 mi",path.get(1).trim());
		  assertEquals("Town_5 via Road_14 to Town_4 10 mi",path.get(2).trim());

	}
	
	@Test
	public void testGetPathA() {
		ArrayList<String> path = graph.getPath(town[3],town[7]);
		  assertNotNull(path);
		  assertTrue(path.size() > 0);
		  assertEquals("Town_3 via Road_11 to Town_2 7 mi",path.get(0).trim());
		  assertEquals("Town_2 via Road_10 to Town_5 4 mi",path.get(1).trim());
		  assertEquals("Town_5 via Road_7 to Town_6 2 mi",path.get(2).trim());
		  assertEquals("Town_6 via Road_5 to Town_7 1 mi",path.get(3).trim());
	}
	
	@Test
	public void testGetPathB() {
		ArrayList<String> path = graph.getPath(town[0],town[8]);
		  assertNotNull(path);
		  assertTrue(path.size() > 0);
		  assertEquals("Town_0 via Road_1 to Town_1 4 mi",path.get(0).trim());
		  assertEquals("Town_1 via Road_3 to Town_2 8 mi",path.get(1).trim());
		  assertEquals("Town_2 via Road_9 to Town_8 2 mi",path.get(2).trim());
		 

	}

}