import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Town_STUDENT_Test Class
 * @author Tyler Do
 * */
class Town_STUDENT_Test {
	
	private Town town1, town2, town3, town4;

	@BeforeEach
	void setUp() throws Exception {
		town1 = new Town("Town 1");
		town2 = new Town("Town 2");
		town3 = new Town("Town 3");
		town4 = new Town(town3);
	}

	@AfterEach
	void tearDown() throws Exception {
		town1 = town2 = town3 = town4 = null;
	}

	@Test
	void testGetName() {
		assertEquals("Town 1", town1.getName());
		assertEquals("Town 2", town2.getName());
		assertEquals("Town 3", town3.getName());
		assertEquals("Town 3", town4.getName());
	}
	
	@Test
	void testCompareTo() {
		assertFalse(town1.compareTo(town2) == 0);
		assertTrue(town1.compareTo(town1) == 0);
		assertTrue(town3.compareTo(town4) == 0);
	}
	
	@Test
	void testEquals() {
		assertTrue(town1.equals(town1));
		assertFalse(town1.equals(town2));
		assertTrue(town3.equals(town4));
	}
	
	@Test
	void testHashCode() {
		assertTrue(town1.hashCode() == town1.hashCode());
		assertFalse(town2.hashCode() == town3.hashCode());
		assertTrue(town3.hashCode() == town4.hashCode());
	}
	
	@Test
	void testToString() {
		assertEquals("Town 1", town1.toString());
		assertEquals("Town 2", town2.toString());
		assertEquals("Town 3", town3.toString());
		assertEquals("Town 3", town4.toString());
	}

}
