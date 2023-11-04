import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MorseCodeTree_STUDENT_TEST {
	private MorseCodeTree tree;
	@BeforeEach
	void setUp() throws Exception {
		tree = new MorseCodeTree();
	}

	@AfterEach
	void tearDown() throws Exception {
		tree = null;
	}

	@Test
	void testInsertAddFetchFetchNode() {
		// since buildTree() was called in constructor, all the nodes have been inserted and added already
		assertEquals("i",tree.fetch(".."));
		assertEquals("g",tree.fetch("--."));
		assertEquals("n",tree.fetch("-."));
		assertEquals("e",tree.fetch("."));
		assertEquals("a",tree.fetch(".-"));
		assertEquals("q",tree.fetch("--.-"));
		assertEquals("k",tree.fetch("-.-"));
	}
	
	
	@Test
	void testToArrayList() {
		ArrayList<String> list = new ArrayList<String>();
		list.add("h");list.add("s");list.add("v");list.add("i");list.add("f");list.add("u");list.add("e");list.add("l");
		list.add("r");list.add("a");list.add("p");list.add("w");list.add("j");list.add("");list.add("b");list.add("d");
		list.add("x");list.add("n");list.add("c");list.add("k");list.add("y");list.add("t");list.add("z");list.add("g");
		list.add("q");list.add("m");list.add("o");
		assertEquals(list, tree.toArrayList());
	}

}
