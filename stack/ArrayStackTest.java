
public class ArrayStackTest {

	static boolean printTable = true;
	
	public static void main(String[] args) {
		System.out.println("a=2, b=3, c=4, d=5, e=6");
		System.out.println("=========================\n");
		for(int i = 0; i < postfixExp.length; i++) {
			displayResult(postfixExp[i], exp[i]);
		}
		
	}
	
	public static int evaluatePostfix(String postfix) {
		if (postfix == null || postfix.length() == 0) {
			throw new IllegalStateException("postfix is null or empty!");
        }
		String value1 = "";
		String value2 = "";
		String value = "";
		ResizeableArrayStack<Integer> stack = new ResizeableArrayStack<Integer>();
		for(int i = 0; i < postfix.length(); i++) {
            char c = postfix.charAt(i);
            if(c == ' ') {
            	continue;
            }
            // If the scanned character is an operand
            // (number here),extract the number
            // Push it to the stack.
            if(Character.isDigit(c)) {
            	//extract the characters and store it in num
            	int operand = c - '0';
                stack.push(operand);
            }
             
            // If the scanned character is an operator, pop two
            // elements from stack apply the operator
            else {
                int operand1 = stack.pop();
                int operand2 = stack.pop();
                
                switch(c) {
                    case '+':
	                    stack.push(operand2+operand1);
	                    break;
                    case '-':
	                    stack.push(operand2- operand1);
	                    break;
                    case '/':
	                    stack.push(operand2/operand1);
	                    break;
                    case '*':
	                    stack.push(operand2*operand1);
	                    break;
                    case '^':
	                    stack.push((int)Math.pow(operand2,operand1));
	                    break;
                    default: 
                    	break;    
                }
                
                //print row
                if(printTable) {
	                value = String.valueOf(stack.peek());
	                value1 = String.valueOf(operand1); 
	                value2 = String.valueOf(operand2);
                }
            }
            if(printTable)
            	printRow(c, value1, value2, value, stack);
		}
        return stack.pop();
	}
	
	/**test data**/
	
	static final int a=2, b=3, c=4, d=5, e=6;
	
	static final String[] exp = {
			"ab*ca-/de*+",
			"ae+bd−/", 
//			"abc*d*−", 
//			"abc−/d*", 
//			"ebca^*+d−"
	}; 
	static final String[] postfixExp = {
			new StringBuilder().append(a).append(b).append("*").append(c).append(a).append("-").append("/").append(d).append(e).append("*").append("+").toString(),
			new StringBuilder().append(a).append(e).append("+").append(b).append(d).append("-").append("/").toString(),
//			new StringBuilder().append(a).append(b).append(c).append("*").append(d).append("*").append("-").toString(),
//			new StringBuilder().append(a).append(b).append(c).append("-").append("/").append(d).append("*").toString(),
//			new StringBuilder().append(e).append(b).append(c).append(a).append("^").append("*").append("+").append(d).append("-").toString()
	};

	/**tools for printing calculation result table*/
	
	public static void displayResult(String postfix, String exp) {
		System.out.println(exp + " => " + postfix);
		if(printTable) {
	    	System.out.format("%15s%15s%15s%15s%15s%n", "Symbol", "Operand1", "Operand2", "Value", "Stack");
		}
    	System.out.println("evaluatePostfix: " + evaluatePostfix(postfix));
		System.out.println("----------------------------------");
	}
	
	//for printing
	public static <T> void printRow(char symbol, String operand1, String operand2, String value, ResizeableArrayStack<T> stack) {
    	System.out.format("%15s%15s%15s%15s%15s%n", String.valueOf(symbol), operand1, operand2, value, stack.toString());
    }


}
