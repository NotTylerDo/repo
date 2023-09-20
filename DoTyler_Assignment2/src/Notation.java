/**
 * Notation Class
 * @author Tyler Do
 * */
public class Notation {

	private static MyQueue<String> queue;
	private static MyStack<String> stack;
	
	/**
	 * Default constructor
	 * */
	public Notation() {
	}
	
	/**
	 * Evaluates a postfix expression from a string to a double
	 * @param postfixExpr The postfix expression that will be evaluated
	 * @return the double value of the string at the top of the stack, will be the final value
	 * @throws InvalidNotationFormatException
	 * */
	public static double evaluatePostfixExpression(String postfixExpr) throws InvalidNotationFormatException {
		stack = new MyStack<String>(postfixExpr.length());
		try {
			for (int i = 0; i < postfixExpr.length(); i++) {
				char c = postfixExpr.charAt(i);
				if (c == ' ')
					continue;
				else if (Character.isDigit(c)) {
					stack.push(String.valueOf(c));
				}
				else if (c == '+' || c == '-' || c == '*' || c == '/') {
					double secondNum = Double.valueOf(stack.pop());
					double firstNum = Double.valueOf(stack.pop());
					if (c == '+') {
						String value = String.valueOf(firstNum + secondNum);
						stack.push(value);
					}
					else if(c == '-') {
						String value = String.valueOf(firstNum - secondNum);
						stack.push(value);
					}
					else if(c == '*') {
						String value = String.valueOf(firstNum * secondNum);
						stack.push(value);
					}
					else if(c == '/') {
						String value = String.valueOf(firstNum / secondNum);
						stack.push(value);
					}
					
				}
				else 
					throw new InvalidNotationFormatException();
			}
		
			if (stack.size() == 1) {
				return Double.valueOf(stack.top());
			}
			else
				throw new InvalidNotationFormatException();
		}
		catch(Exception e) {
			throw new InvalidNotationFormatException();
		}
		
		
	}
	
	/**
	 * Convert the postfix expression to the infix expression
	 * @param postfix the string value of the postfix expression
	 * @return the string value of the stack of the converted infix expression
	 * @throws InvalidNotationFormatException
	 * */
	public static String convertPostfixToInfix(String postfix) throws InvalidNotationFormatException {
		stack = new MyStack<String>(postfix.length());
		for (int i = 0; i < postfix.length(); i++) {
			char c = postfix.charAt(i);
			if (c == ' ')
				continue;
			else if (Character.isDigit(c)) {
				try {
					stack.push(String.valueOf(c));
				}
				catch(Exception e) {
				}
			}
			
			else if (c == '+' || c == '-' || c == '*' || c == '/') {
				try {
					// stack pops right to left so thats why secondNum is the first pop and firstNum is the second pop
					String secondNum = stack.pop();
					String firstNum = stack.pop();
					String str = "(";
					str += firstNum + String.valueOf(c) + secondNum + ")";
					stack.push(str);
				
				}
				catch(Exception e) {
				}
			}
			else
				throw new InvalidNotationFormatException();
		}
		if (stack.size() == 1) {
			return stack.toString();
		}
		else
			throw new InvalidNotationFormatException();
		
	}
	
	/**
	 * Convert the infix expression to the postfix expression
	 * @param infix the string value of the infix expression
	 * @return the string value of the stack of the converted postfix expression
	 * @throws InvalidNotationFormatException
	 * */
	public static String convertInfixToPostfix(String infix) throws InvalidNotationFormatException {
		queue = new MyQueue<String>(infix.length());
		stack = new MyStack<String>(infix.length());
		
		for (int i = 0; i < infix.length(); i++) {
			char c = infix.charAt(i);
			if(c == ' ')
				continue;
			else if (Character.isDigit(c)) {
				try {
					queue.enqueue(String.valueOf(c));
				}
				catch(Exception e) {
				}
			}
			else if (c == '(') {
				try {
					stack.push(String.valueOf(c));
				}
				catch(Exception e) {
				}
			}
			else if (c == '+' || c == '-' || c == '*' || c == '/') {
				try {
					int precedenceAtTop = 0;
					int precedenceNextCharacter = 0;
					while(precedenceAtTop >= precedenceNextCharacter && !stack.isEmpty()) {
						// Finds the precedence of the operator at the top of the stack
						if (stack.top().equals("+") ||  stack.top().equals("-"))
							precedenceAtTop = 0;
						else if (stack.top().equals("*") || stack.top().equals("/"))
							precedenceAtTop = 1;
						else if (stack.top().equals("("))
							precedenceAtTop = -1;
						
						// Finds the precedence  of the operator at the next character
						if (String.valueOf(c).equals("+") ||  String.valueOf(c).equals("-"))
							precedenceNextCharacter = 0;
						else if (String.valueOf(c).equals("*") || String.valueOf(c).equals("/"))
							precedenceNextCharacter = 1;
					
						
						
						if (precedenceAtTop >= precedenceNextCharacter) {
							queue.enqueue(stack.pop());
						}
						
							
								
					}
					
					stack.push(String.valueOf(c));
				}
				catch(Exception e) {
					
				}
				
			}
			else if (c == ')') {
				try {
					boolean status = false;
					while(!status && !stack.isEmpty()) {
						if (stack.top().equals("(")) {
							stack.pop();
							status = true;
						}
						else
							queue.enqueue(String.valueOf(stack.pop()));
					}
					if (!status) {
						throw new InvalidNotationFormatException();
					}
				}
				catch(Exception e) {
					throw new InvalidNotationFormatException();
				}
			}
			else 
				throw new InvalidNotationFormatException();
		}
	
		while(!stack.isEmpty()) {
			try {
				queue.enqueue(String.valueOf(stack.pop()));
			}
			catch(Exception e) {
			}
		}
		String str = queue.toString();
		return str;
	}

}
