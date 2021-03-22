package stackQueueHashing;

import static org.junit.Assert.*;

import java.beans.Expression;
import java.util.EmptyStackException;

import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class InfixEvaluationJunitTesting {
	@Rule
    public ExpectedException thrown = ExpectedException.none();
	/**
	 * Test for the exception when user enters a invalid infix expression
	 */
	@Test
	public void testException() {
		thrown.expect(EmptyStackException.class);
		//thrown.expectMessage("Incorrect infix expression");
		InfixEvaluation instance = new InfixEvaluation();
		String infixExpression = "( 1 + 2 ) )";
		Double x=instance.evaluateInfixExpression(infixExpression);
	}
	/**
	 * Test for a valid infix expression
	 */
	@SuppressWarnings("deprecation")
	@Test
	public void positiveValidTest(){
		InfixEvaluation instance = new InfixEvaluation();
		String infixExpression = "1 + ( 3 * ( 4 / 2 ) ) - ( 4 / 2 ) + ( 2 ^ 3 ) ";
		Double expected = 13.0;
		Double actual = instance.evaluateInfixExpression(infixExpression);
		assertEquals(expected, actual);
	}
	/**
	 * Another test for valid infix expression
	 */
	@Test
	public void positiveValidTest1(){
		InfixEvaluation instance = new InfixEvaluation();
		String infixExpression = "( 3 + 4 % 2 )";
		Double expected = 3.0;
		Double actual = instance.evaluateInfixExpression(infixExpression);
		assertEquals(expected, actual);
	}
	/**
	 * Testing the OR operator exception when the user sends the invalid infix expression
	 */
	@Test
	public void orOperatorExceptionTest(){
		thrown.expect(IllegalStateException.class);
		InfixEvaluation instance = new InfixEvaluation();
		String infixExpression = "( 2 || 1 )";
		Double actual = instance.evaluateInfixExpression(infixExpression);
	}
	/**
	 * Testing the OR operator for a valid infix expression (When the returned value is true)
	 */
	@Test
	public void orOperatorPositiveTest(){
		InfixEvaluation instance = new InfixEvaluation();
		String infixExpression = "( ( 4 % 2 ) || ( 1 % 4 ) )";
		Double expected = 1.0;
		Double actual = instance.evaluateInfixExpression(infixExpression);
		assertEquals(expected, actual);
	}
	/**
	 * Testing the OR operator for a valid infix expression (When the returned value is false)
	 */
	@Test
	public void orOperatorNegativeTest(){
		InfixEvaluation instance = new InfixEvaluation();
		String infixExpression = "( ( 4 % 2 ) || ( 6 - 2 * 3 ) )";
		Double expected = 0.0;
		Double actual = instance.evaluateInfixExpression(infixExpression);
		assertEquals(expected, actual);
	}
	/**
	 * Testing the > operator (When the value returned is true)
	 */
	@Test
	public void greaterThanOperatorPositiveTest(){
		InfixEvaluation instance = new InfixEvaluation();
		String infixExpression = "( ( 6 + 4 * 9 / 3 ) > ( 4 * 3 ) )";
		Double expected = 1.0;
		Double actual = instance.evaluateInfixExpression(infixExpression);
		assertEquals(expected, actual);
	}
	/**
	 * Testing the > operator (When the value returned is false)
	 */
	@Test
	public void greaterThanOperatorNegativeTest(){
		InfixEvaluation instance = new InfixEvaluation();
		String infixExpression = "( ( 6 + 4 * 9 / 3 ) > ( 4 * 3 ) )";
		Double expected = 1.0;
		Double actual = instance.evaluateInfixExpression(infixExpression);
		assertEquals(expected, actual);
	}
	/**
	 * Testing the >= operator (When the value returned is true)
	 */
	@Test
	public void greaterThanOrEqualsToPositiveTest(){
		InfixEvaluation instance = new InfixEvaluation();
		String infixExpression = "( ( 6 + 4 * 9 / 3 ) >= ( 9 * 2 ) )";
		Double expected = 1.0;
		Double actual = instance.evaluateInfixExpression(infixExpression);
		assertEquals(expected, actual);
	}
	/**
	 * Testing the >= operator (When the value returned is false)
	 */
	@Test
	public void greaterThanOrEqualsToNegativeTest(){
		InfixEvaluation instance = new InfixEvaluation();
		String infixExpression = "( ( 2 + 4 * 9 / 3 ) >= ( 9 * 2 ) )";
		Double expected = 0.0;
		Double actual = instance.evaluateInfixExpression(infixExpression);
		assertEquals(expected, actual);
	}
	/**
	 * Testing the AND operator when the user sends the invalid infix expression
	 */
	@Test
	public void andOperatorExceptionTest(){
		thrown.expect(IllegalStateException.class);
		InfixEvaluation instance = new InfixEvaluation();
		String infixExpression = "( 2 && 1 )";
		Double actual = instance.evaluateInfixExpression(infixExpression);
	}
	/**
	 * Testing the AND operator for a correct infix expression
	 */
	@Test
	public void andOperatorPositiveTest(){
		InfixEvaluation instance = new InfixEvaluation();
		String infixExpression = "( ( 4 % 2 + 1 ) || ( 1 % 4 ) )";
		Double expected = 1.0;
		Double actual = instance.evaluateInfixExpression(infixExpression);
		assertEquals(expected, actual);
	}
}
