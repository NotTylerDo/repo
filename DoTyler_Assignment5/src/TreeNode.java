/* Class: CMSC204
 * Instructor: Huseyin Aygun
 * Description: Create a program with the classes to create a Morse Code Converter Utility
 * Due: 11/6/23
 * Platform/Compiler: Eclipse
 * I pledge that I have completed the programming assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code to any student.
 * Tyler Do
 * */
/**
 * TreeNode Class
 * @author Tyler Do
 * */
public class TreeNode<T> {
	protected T data;
	protected TreeNode<T> leftChild;
	protected TreeNode<T> rightChild;
	
	/**
	 * Create a new TreeNode with left and right child set to null 
	 * and data set to the dataNode
	 * @param dataNode the data node to set the data to
	 * */
	public TreeNode(T dataNode) {
		leftChild = rightChild = null;
		data = dataNode;
	}
	
	/**
	 * Used for making deep copies
	 * @param node the node to make a deep copy of
	 * */
	public TreeNode(TreeNode<T> node) {
		this.data = node.data;
		this.leftChild = node.leftChild;
		this.rightChild = node.rightChild;
	}
	
	/**
	 * Return the data within this TreeNode
	 * @return data the data within the TreeNode
	 * */
	public T getData() {
		return data;
	}
	
	

}
