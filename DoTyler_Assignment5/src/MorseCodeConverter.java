/* Class: CMSC204
 * Instructor: Huseyin Aygun
 * Description: Create a program with the classes to create a Morse Code Converter Utility
 * Due: 11/6/23
 * Platform/Compiler: Eclipse
 * I pledge that I have completed the programming assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code to any student.
 * Tyler Do
 * */

import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
/**
 * MorseCodeConverter Class
 * @author Tyler Do
 * */
public class MorseCodeConverter {

	private static MorseCodeTree tree = new MorseCodeTree();
	
	/**
	 * Default constructor
	 * */
	public MorseCodeConverter() {
	}
	
	/**
	 * Return a string with all the data in the tree in LNR order with a space
	 * in between them
	 * @return str the string with all the data in the tree
	 * */
	public static String printTree() {
		String str = "";
		ArrayList<String> list = new ArrayList<String>(tree.toArrayList());
		for(int i = 0; i < list.size(); i++) {
			str += list.get(i);
			if (i < list.size() - 1) {
				str += " ";
			}
		}
		return str;
	}
	
	/**
	 * Converts Morse code into English
	 * @param code the morse code to be converted to english
	 * @return str the morse code in english
	 * */
	public static String convertToEnglish(String code) {
		String str = "";
		String[] splitWord = code.split("/");
		String[] splitLetters;
		for (int i = 0; i < splitWord.length; i++) {
			splitLetters = splitWord[i].split(" ");
			for (String toCode: splitLetters) {
				str += tree.fetch(toCode);
			}
			if (i < splitWord.length - 1) {
				str += " ";
			}
		}
		return str;
	}
	
	/**
	 * Converts a file of Morse Code into english. Each letter is 
	 * delimited by a space ' '
	 * @param codeFile the file to convert into english
	 * @return str the morse code in english
	 * @throws FileNotFoundException
	 * */
	public static String convertToEnglish(File codeFile) throws FileNotFoundException {
		try {
			String str = "";
			Scanner fileReader = new Scanner(codeFile);
			while (fileReader.hasNextLine()) {
				str += fileReader.nextLine();
			}
			fileReader.close();
			return convertToEnglish(str);
		}
		catch(FileNotFoundException e) {
			return "File not found";
		}
		
	}
}
