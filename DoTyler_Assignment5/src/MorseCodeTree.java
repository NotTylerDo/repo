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
/**
 * MorseCodeTree Class
 * @author Tyler Do
 * */
public class MorseCodeTree implements LinkedConverterTreeInterface<String> {
	private TreeNode<String> root;
	
	/**
	 * Default constructor that calls buildTree method
	 * */
	public MorseCodeTree() {
		root = null;
		buildTree();
	}
	
	@Override
	/**
	 * Returns a reference to the root
	 * @return reference to root
	 */
	public TreeNode<String> getRoot(){
		return root;
	}
	
	@Override
	/**
	 * sets the root of the Tree
	 * @param newNode a TreeNode<T> that will be the new root
	 */
	public void setRoot(TreeNode<String> newNode) {
		root = newNode;
	}
	
	
	@Override
	/**
	 * Adds result to the correct position in the tree based on the code
	 * This method will call the recursive method addNode
	 * 
	 * @param code the code for the new node to be added
	 * @param result the letter to add into the tree
	 */
	 
	 public void insert(String code, String result) {
		 if (root != null) {
			 addNode(root, code, result);
		 }
		 else
			 root = new TreeNode<String>(result);
	 }
	 
	@Override
	/**
	 * This is a recursive method that adds element to the correct position 
	 * in the tree based on the code.
	 * 
	 * @param root the root of the tree for this particular recursive instance of addNode
	 * @param code the code for this particular recursive instance of addNode
	 * @param letter the data of the new TreeNode to be added
	 */
	public void addNode(TreeNode<String> root, String code, String letter) {
		if (code.length() == 1) {
			if (code.equals(".")) {
				root.leftChild = new TreeNode<String>(letter);
			}
			else if (code.equals("-")) {
				root.rightChild = new TreeNode<String>(letter);
			}
		}
		// code's length is longer than 1
		else {
			if (code.charAt(0) == '.') {
				root = root.leftChild;
			}
			else if (code.charAt(0) == '-') {
				root = root.rightChild;
			}
			code = code.substring(1);
			addNode(root, code, letter);
		}
	}
	
	@Override
	/**
	 * Fetch the data in the tree based on the code
	 * This method will call the recursive method fetchNode
	 * 
	 * @param code the code that describes the traversals within the tree
	 * @return the result that corresponds to the code
	 */
	public String fetch(String code) {
		return fetchNode(root, code);
	}
	
	@Override
	/**
	 * This is the recursive method that fetches the data of the TreeNode
	 * that corresponds with the code
	 * 
	 * @param root the root of the tree for this particular recursive instance of addNode
	 * @param code the code for this particular recursive instance of fetchNode
	 * @return the data corresponding to the code
	 */
	public String fetchNode(TreeNode<String> root, String code) {
		String decryption = "";
		if (root!= null) {
			if (code.length() == 1) {
				if (code.equals(".")) {
					decryption += root.leftChild.getData();
				}
				else if (code.equals("-")) {
					decryption += root.rightChild.getData();
				}
			}
			// Code is longer than 1 character
			else if (code.length() > 1) {
				if (code.charAt(0) == '.') {
					root = root.leftChild;
				}
				else if (code.charAt(0) == '-') {
					root = root.rightChild;
				}
				code = code.substring(1);
				decryption += fetchNode(root, code);
			}
		}
		return decryption;
	}
	
	@Override
	/**
	 * This operation is not supported for a LinkedConverterTree
	 * @param data data of node to be deleted
	 * @return reference to the current tree
	 * @throws UnsupportedOperationException
	 */
	public LinkedConverterTreeInterface<String> delete(String data) throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}
		
	
	@Override
	/**
	 * This operation is not supported for a LinkedConverterTree
	 * @return reference to the current tree
	 * @throws UnsupportedOperationException
	 */
	public LinkedConverterTreeInterface<String> update() throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}
		
	@Override
	/**
	 * This method builds the LinkedConverterTree by inserting TreeNodes<T>
	 * into their proper locations
	 * 
	 */
	public void buildTree() {
		// Level 0
		insert(" ", "");
		
		// Level 1
		insert(".","e"); insert("-","t");
		
		// Level 2
		insert("..","i"); insert(".-","a"); insert("-.","n"); insert("--","m"); 
		
		// Level 3
		insert("...","s"); insert("..-","u"); insert(".-.","r"); insert(".--","w"); 
		insert("-..","d"); insert("-.-","k"); insert("--.","g"); insert("---","o"); 
		// Level 4
		insert("....","h"); insert("...-","v"); insert("..-.","f"); insert(".-..","l");
		insert(".--.","p"); insert(".---","j"); insert("-...","b"); insert("-..-","x");
		insert("-.-.","c"); insert("-.--","y"); insert("--..","z"); insert("--.-","q");
	}
	

	@Override
	/**
	 * Returns an ArrayList of the items in the linked converter Tree in LNR (Inorder) Traversal order
	 * Used for testing to make sure tree is built correctly
	 * @return an ArrayList of the items in the linked Tree
	 */
	public ArrayList<String> toArrayList(){
		ArrayList<String> list = new ArrayList<String>();
		LNRoutputTraversal(root, list);
		return list;
	}
	
	@Override
	/**
	 * The recursive method to put the contents of the linked converter tree in an ArrayList<T> 
	 * LNR (Inorder)
	 * @param root the root of the tree for this particular recursive instance
	 * @param list the ArrayList that will hold the contents of the tree in LNR order
	 */
	public void LNRoutputTraversal(TreeNode<String> root, ArrayList<String> list) {
		if (root != null) {
		if (root.leftChild != null) {
			LNRoutputTraversal(root.leftChild, list);
		}		
		list.add(root.getData());
		if (root.rightChild != null) {
			LNRoutputTraversal(root.rightChild, list);
			}
		}		
	}
}