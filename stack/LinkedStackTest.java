
public class LinkedStackTest {
	
	static boolean printTable = true;
	
	public static void main(String[] args) {
		for(String exp : infixExp) {
			displayResult(exp);
		}
	}
	
	/**
	 *  Step 1: Start
		Step 2: Read the infix expression
		Step 3: Scan every character of infix expression,
			If scanned character is
			3.1 ( , then  push it on the stack
			3.2 operand (whether a digit or a character) , add it to postfix.
			3.3 ) , then
				a. Repeatedly pop from stack and add it to postfix until  ( .
				b. Discard the ( . That is, remove the ( from stack and do not add it to postfix
			3.4 operator, then
				a. Repeatedly pop from stack and add each operator (popped from the stack) to postfix which has the same precedence or a higher precedence
				b. Push the operator to the stack
		Step 4: Repeatedly pop from the stack and add it to postfix until the stack is empty
		Step 5: Stop
	 * @param infix
	 * @return
	 */
	public static String convertToPostfix(String infix) {
		if (infix == null || infix.length() == 0) {
			throw new IllegalStateException("infix is null or empty!");
        }
		//for printing
		if(printTable) {
			printHeader();
		}
		StringBuilder postfix = new StringBuilder();
		LinkedStack<Character> operatorStack = new LinkedStack<Character>(); 
		//scan character from infix
		for(char c : infix.toCharArray()) {
			int i = 0;  //for printing
			if(c == ' ') {
            	continue;
            }
			//if it's an operand, add it to postfix
			if (Character.isLetterOrDigit(c)) { 
				postfix.append(c);  
			} else if (c=='(') { 
				//push ( on the stack 
				operatorStack.push(c);  
			} else if (c==')') { 
				//repeatedly pop from stack and add it to postfix until  ( .
				while (operatorStack.peek() != '(') {
					postfix.append(operatorStack.pop());
					//for printing
					if(printTable) {
						printRow( i==0 ? String.valueOf(c) : "", postfix.toString(), operatorStack);
						i++;
					}
				}  
				operatorStack.pop();        //remove '(' from stack and do not add it to postfix 
			} else {
				//repeatedly pop from stack and add each operator (popped from the stack) to postfix which has the same precedence or a higher precedence
				while (!operatorStack.isEmpty() && operatorStack.peek() != '(' && precedence(operatorStack.peek()) >= precedence(c)) { 
					postfix.append(operatorStack.pop());
					//for printing
					if(printTable) {
						printRow( i==0 ? String.valueOf(c) : "", postfix.toString(), operatorStack);
						i++;
					}
				}
				//push the operator to the stack
				operatorStack.push(c);  
			}
			//for printing
			if(printTable) {
				printRow( i==0 ? String.valueOf(c) : "", postfix.toString(), operatorStack);
			}
		}
		//repeatedly pop from the stack and add it to postfix until the stack is empty
		while (!operatorStack.isEmpty()) {
			postfix.append(operatorStack.pop());
			//for printing
			if(printTable && !operatorStack.isEmpty()) {
				printRow("", postfix.toString(), operatorStack);
			}
		}
		//for printing
		if(printTable) {
			printRow("", postfix.toString(), operatorStack);
		}
		return postfix.toString();  
	}  
	
	/**
	 * return precedence of a given operator, higher value => higher precedence
	 * @param c
	 * @return
	 */
    private static int precedence(char c) {
        switch (c) {
	        case '+': case '-':
	            return 1;
	        case '*': case '/':
	            return 2;
	        case '^':
	            return 3;
        }
        return -1;
    }
    
    /**test data**/
    private static final String[] infixExp = {
    		"a * b / (c-a) + d * e", "a/b*(c+(d-e))"
//    		"a * b / (c-a) + d * e", "a/b*(c+(d-e))", "(a+b)/(c−d)", "a/(b−c)*d", "a−(b/(c−d)*e+f)^g", "(a−b*c)/(d*e^f*g+h)"
    };
    
    /**tools for printing calculation result table*/
    
    private static void displayResult(String infix) {
    	String converted = convertToPostfix(infix);
    	System.out.println("");
		System.out.println(infix + " => " + converted);
		System.out.println("------------------------------------------------------------------");
	}
    
    //for printing
    private static void printRow(String symbol, String postfix, LinkedStack<Character> stack) {
    	//String[] row = {symbol, "|", postfix, "|", stack.toString()};
    	System.out.format("%-10s%-5s%-15s%-5s%-15s%n", symbol, "|", postfix, "|", stack.toString());
    }
    
    //for printing
    private static void printHeader() {
    	//String[] row = {"Symbol", "|", "Postfix", "|", "Stack"};
    	System.out.format("%-10s%-5s%-15s%-5s%-15s%n", "Symbol", "|", "Postfix", "|", "Stack");
    }
   
}
