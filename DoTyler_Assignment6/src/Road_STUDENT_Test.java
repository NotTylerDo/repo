import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Road_STUDENT_Test Class
 * @author Tyler Do
 * */
class Road_STUDENT_Test {
	private Road road1, road2, road3, road4;
	private Town town1, town2, town3, town4;
	
	@BeforeEach
	void setUp() throws Exception {
		town1 = new Town("Town 1");
		town2 = new Town("Town 2");
		town3 = new Town("Town 3");
		town4 = new Town(town3);
		road1 = new Road(town1, town2, 5, "Road 1");
		road2 = new Road(town2, town1, 5, "Road 1");
		road3 = new Road(town2, town4, 3, "Road 3");
		road4 = new Road(town3, town2, "Road 4");
	}

	@AfterEach
	void tearDown() throws Exception {
		town1 = town2 = town3 = town4 = null;
		road1 = road2 = road3 = road4 = null;
	}

	@Test
	void testGetName() {
		assertEquals("Road 1", road1.getName());
		assertEquals("Road 1", road2.getName());
		assertEquals("Road 3", road3.getName());
		assertEquals("Road 4", road4.getName());
	}
	
	@Test
	void testContains() {
		assertTrue(road1.contains(town1));
		assertTrue(road1.contains(town2));
		assertFalse(road1.contains(town3));
	}
	
	@Test
	void testEquals() {
		assertTrue(road1.equals(road2));
		assertFalse(road3.equals(road4));
	}
	
	@Test
	void testDestination() {
		assertEquals(town2, road1.getDestination());
		assertEquals(town1, road2.getDestination());
		assertEquals(town4, road3.getDestination());
		assertEquals(town2, road4.getDestination());
	}
	
	@Test
	void testCompareTo() {
		assertFalse(road2.compareTo(road4) == 0);
		assertFalse(road1.compareTo(road3) == 0);
		assertTrue(road1.compareTo(road2) == 0);
		assertTrue(road3.compareTo(road3) == 0);
	}
	
	@Test
	void testGetSource() {
		assertEquals(town1, road1.getSource());
		assertEquals(town2, road2.getSource());
		assertEquals(town2, road3.getSource());
		assertEquals(town3, road4.getSource());
	}
	
	@Test
	void testWeight() {
		assertEquals(5, road1.getWeight());
		assertEquals(5, road2.getWeight());
		assertEquals(3, road3.getWeight());
		assertEquals(1, road4.getWeight());
	}
	
	@Test
	void testToString() {
		assertEquals("Road 1 connects Town 1 and Town 2", road1.toString());
		assertEquals("Road 1 connects Town 2 and Town 1", road2.toString());
		assertEquals("Road 3 connects Town 2 and Town 3", road3.toString());
		assertEquals("Road 4 connects Town 3 and Town 2", road4.toString());
	}

}
