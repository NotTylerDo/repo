import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MorseCodeConverter_STUDENT_TEST {

	@Test
	public void testConvertMorseStringToEnglishString() {	
		
		String converter1 = MorseCodeConverter.convertToEnglish("- -.-- .-.. . .-. / -.. --- / -.-. .-. . .- - . -.. / - .... .. ...");
		assertEquals("tyler do created this", converter1);
		String converter2 = MorseCodeConverter.convertToEnglish(".--- --- ...- .. .- .-.. / ..-. --- -..- . ... / --.- ..- .. -.-. -.- .-.. -.-- / --.. .. --. --.. .- --. --. . -.. / - .... .-. --- ..- --. .... / -- ..- .-. -.- -.-- / .--. .- - .... .-- .- -.-- ... / -... . .-- .. .-.. -.. . .-. .. -. --. .-.. -.-- / . -..- .--. .-.. --- .-. .. -. --. / --.- ..- .- .. -. - / ...- .. .-.. .-.. .- --. . ... / .... .- ...- .. -. --. / .- / .--- --- .-.. .-.. -.-- / - .. -- . / .-- .... .. .-.. . / . -..- -.-. .... .- -. --. .. -. --. / ...- .. . .-- ... / --- -. / - .... . / .--. . .-. .--. .-.. . -..- .. -. --. / .-.. .- -... -.-- .-. .. -. - .... / --- ..-. / - .... . / ... -.- -.-- / .- -. -.. / - .... . / -... ..- --.. --.. .. -. --. / -- .- .-. -.- . - / ..-. --- .-. / --.- ..- .- .-.. .. - -.-- / --. --- --- -.. ... / .--- ..- ... - / -. . -..- - / - --- / - .... . / .- --.. ..- .-. . / --.- ..- .- -.--");
		assertEquals("jovial foxes quickly zigzagged through murky pathways bewilderingly exploring quaint villages having a jolly time while exchanging views on the perplexing labyrinth of the sky and the buzzing market for quality goods just next to the azure quay", converter2);

	}
	@Test
	public void testConvertMorseFileToEnglishString() {	
		File file1 = new File("src/LoveLooksNot.txt"); 
		File file2 = new File("src/howDoIloveThee.txt");
		File file3 = new File("src/DaisyDaisy.txt");
		File file4 = new File("src/Daisy.txt");
		
		try {
			assertEquals("love looks not with the eyes but with the mind", MorseCodeConverter.convertToEnglish(file1));
		} catch (FileNotFoundException e) {
			assertTrue("An unwanted exception was caught", false);
		}
		try {
			assertEquals("how do i love thee let me count the ways", MorseCodeConverter.convertToEnglish(file2));
		} catch (FileNotFoundException e) {
			assertTrue("An unwanted exception was caught", false);
		}
		try {
			assertEquals("im half crazy all for the love of you", MorseCodeConverter.convertToEnglish(file3));
		} catch (FileNotFoundException e) {
			assertTrue("An unwanted exception was caught", false);
		}
		try {
			assertEquals("give me your answer do", MorseCodeConverter.convertToEnglish(file4));
		} catch (FileNotFoundException e) {
			assertTrue("An unwanted exception was caught", false);
		}
		try {
			File file5 = new File("src/NotHere.txt");
			MorseCodeConverter.convertToEnglish(file5);
		} catch (FileNotFoundException e) {
			assertTrue("An unwanted exception was caught", true);
		}
	} 

}
