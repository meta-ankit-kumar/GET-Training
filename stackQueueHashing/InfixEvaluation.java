package stackQueueHashing;
import java.util.Stack;

/**
 * Class which evaluates the infix expression
 * @author ankit.kumar_metacube
 */
public class InfixEvaluation {
	
	
	 /**
	  * Checks whether a token is operator or not
	  * @param operator
	  * @return -> true if operator else false
	  */
	 public boolean isOperator(String operator) {
		 if(operator.equals("||") 
				 || operator.equals("&&") 
				 || operator.equals("==") 
				 || operator.equals("!=")
				 || operator.equals("<")
				 || operator.equals(">")
				 || operator.equals("<=")
				 || operator.equals(">=")
				 || operator.equals("+")
				 || operator.equals("-")
				 || operator.equals("*")
				 || operator.equals("/")
				 || operator.equals("%")
				 || operator.equals("^")
				 || operator.equals("!"))
			 return true;
		 else
			 return false;
	}
	 
	/**
	 * Performs the required operation between operand num1 and num2 using the operator op
	 * @param num1 First number
	 * @param num2 Second number
	 * @param op Operator
	 * @return result of the operation
	 */
	public Double performOperation(Double num1 , Double num2, String op){
		//System.out.println(num1 + " " + num2);
		switch (op) {
		case "||" : if ( (num1 != 0 && num1 != 1) || ( num2 != 1 && num2 != 0) )
						throw new IllegalStateException("Invalid numbers");
					if (num1 == 1 || num2 == 1)
						return 1.;
					return 0.;
			
	 	case "&&" :	if ( (num1 != 0 && num1 != 1) || ( num2 != 1 && num2 != 0) )
	 					throw new IllegalStateException("Invalid numbers");
	 				if (num1 == 1 && num2 == 1)
	 						return 1.;
	 				return 0.;
	 	
	 	case "==" : if(num1 == num2)
	 					return 1.0;
	 				return 0.0;
	 				
	 	case "!=" : if(num1 != num2)
						return 1.0;
					return 0.0;
					
	 	case "<"  : if(num1 < num2)
	 					return 1.0;
	 				return 0.0;
	 				
	 	case ">"  : if(num1 > num2)
						return 1.0;
					return 0.0;
       case "<=" : if(num1 <= num2)
						return 1.0;
					return 0.0;
       case ">=" : if(num1 >= num2)
						return 1.0;
					return 0.0;
       	
		case "+"  : return (num1 + num2);
		
		case "-"  : return (num1 - num2); 
		
		case "*"  : return (num1 * num2); 
		
		case "/"  : if(num2 == 0)
						throw new IllegalStateException("Second number must not be zero. Division not possible when the second number is zero");
					return (num1 / num2);
					
		case "%"  : if(num2 == 0)
						throw new IllegalStateException("Second number must not be zero. Modulo operation not possible when the second number is zero");
					return (num1 % num2);
					
		case "^"  : return Math.pow(num1, num2);
       
		case "!"  : if ( (num1 != 0 || num1 != 1) )
						throw new AssertionError("Invalid numbers");
					if (num1 == 0)
						return 1.;
					return 1.;
					
		default : throw new IllegalStateException("Invalid choice");
		}
	}
	/**
	 * Determines the precedence of a particular operator using java rules
	 * @param op operator whose precedence is going to be determined
	 * @return integer number indicating precedence higher number means higher precedence and vice-versa
	 */
	public int getPrecedence(String operator) {
		if(operator.equals("||"))
			return 1;
		else if(operator.equals("&&"))
			return 2;
		else if(operator.equals("==") || operator.equals("!="))
			return 3;
		else if(operator.equals("<") || operator.equals(">") || operator.equals("<=") || operator.equals(">="))
			return 4;
		else if(operator.equals("+") || operator.equals("-"))
			return 5;
		else if(operator.equals("*") || operator.equals("/") || operator.equals("%"))
			return 6;
		else if(operator.equals("^"))
			return 7;
		else if(operator.equals("!"))
			return 8;
		else
			return 0;// '(' has the highest precedence
	 }
		
	/**
	 * Converts infix expression into postfix expression
	 * @param infix Infix expression
	 * @return postfix expression
	 * @throws Exception In case the infix expression is incorrect
	 */
	public String infixTOPostfix(String infix){
		Stack<String> stack = new Stack<String>(); 
		if(infix.length() == 0)
	            throw new AssertionError("Invalid Input!");
		 
		 String[] tokens = infix.trim().split(" ");
		 String postfix = "";
		 
		 for (String token : tokens) {
			 if (isNumber(token)){
	             postfix += token + " ";
	         }
			 else if("(".equals(token)){
				 stack.push(token);
	         }
	         else if(")".equals(token)) {
	        	 while(!("(".equals(stack.peek()))){
	        		 postfix += (stack.pop() + " ");
	             }
	             stack.pop();
	         }
	         else if(isOperator(token)){
	        	 if(stack.isEmpty() || "(".equals(stack.peek()) || getPrecedence(token) > getPrecedence(stack.peek())){
	        		 stack.push(token);
	        	 }
	             else{
	                 while(!stack.isEmpty() && !("(".equals(stack.peek())) && getPrecedence(token) <= getPrecedence(stack.peek())){
	                	 postfix += stack.pop() +" ";
	                 }
	                 stack.push(token);
	             }
	         }
	         
		 }
	     while(!stack.isEmpty()){
	            postfix += stack.pop() + " ";
	     }
	   
	     return postfix.trim();
	}
	/**
	 * checks whether a token is number or not
	 * @param token
	 * @return true if token is number else false
	 */	public boolean isNumber(String token){
		char[] tokenArray = token.toCharArray();
		for (int index = 0 ; index < token.length(); index++){
			if (tokenArray[index] >= '0' && tokenArray[index] <= '9')
				continue;
			else
				return false;
		}
		return true;
	}
	
	/**
	 * method to evaluate postfix expression
	 * @param postfix
	 * @return -> result of evaluation
	 */
	 public Double evaluatePostfix(String postfix) {
			Stack<Double> operands = new Stack<Double>();
			String[] tokens = postfix.split(" ");
			for (String token : tokens) {
				if(isNumber(token)) { 
					operands.push(Double.parseDouble(token));
				}
				else{
					Double num2 = operands.pop();
					Double num1 = operands.pop();
					operands.push(performOperation(num1, num2 , token));
				}
				
			}
			return operands.pop();
		}
		
   
	/**
	 * method to evaluate infix expression by converting it into postfix expression
	 * @param infix
	 * @return -> result of evaluation
	 * @throws Exception 
	 */
    public Double evaluateInfixExpression(String infix){
		String postfix = infixTOPostfix(infix);
		return evaluatePostfix(postfix);
	}
	
    public static void main(String[] args){
       	InfixEvaluation i = new InfixEvaluation();
       	System.out.println(i.evaluateInfixExpression("1 + ( 3 * ( 4 / 2 ) ) - ( 4 / 2 ) + ( 2 ^ 3 ) "));
       	System.out.println(i.evaluateInfixExpression(" 1 || 1"));
       }
}
