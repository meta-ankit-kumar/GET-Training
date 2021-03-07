package recursion;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import recursion.*;
public class LcmHcfTesting {
	@Rule
    public ExpectedException thrown = ExpectedException.none();
	
	// To test LCM of different positive numbers
	@Test
	public void testLcm() {
		int input1[] = {1, 2, 8, 3, 1021};
		int input2[] = {2, 6, 9, 4, 91};
		int actuals[] = new int[input1.length];
		for(int i=0; i<actuals.length; i++)
			actuals[i] = LcmHcf.lcmCalculate(input1[i], input2[i]);
		int expecteds[] = {2, 6, 72, 12, 92911};
		assertArrayEquals(expecteds, actuals);
	}
	
	//function to test LCM when first number is zero
	@Test
	public void testZeroLcm(){
		thrown.expect(IllegalStateException.class);
		//Expected message
		thrown.expectMessage("A and B should be positive");
		int a = 0;
		int b = 4;
		LcmHcf.lcmCalculate(a, b);
	}
	
	//function to test LCM when second number is zero
	@Test
	public void testZero2Lcm(){
		thrown.expect(IllegalStateException.class);
		//Expected message
		thrown.expectMessage("A and B should be positive");
		int a = 4;
		int b = 0;
		LcmHcf.lcmCalculate(a, b);
	}
	
	//function to test LCM against negative
	@Test
	public void testNegativeLcm(){
		thrown.expect(IllegalStateException.class);
		//Expected message
		thrown.expectMessage("A and B should be positive");
		int a = -3;
		int b = 4;
		LcmHcf.lcmCalculate(a, b);
	}
	
	// Function to test HCF when both numbers are zero
	@Test
	public void testUndefinedHcf(){
		thrown.expect(IllegalStateException.class);
		//Expected message
		thrown.expectMessage("HCF(0,0) is not defined");
		int a = 0;
		int b = 0;
		LcmHcf.hcfCalculate(a, b);
	}
	
	// Function to test HCF when either one of two number is negative
	@Test
	public void testNegativeHcf(){
		thrown.expect(IllegalStateException.class);
		//Expected message
		thrown.expectMessage("Both Number should be positive");
		int a = -1;
		int b = 4;
		LcmHcf.hcfCalculate(a, b);
	}
	// Function to test HCF of different numbers
	@Test
	public void testHcf(){
		int input1[] = {4, 10, 6, 3, 1021, 2022};
		int input2[] = {2, 6, 9, 4, 91, 90};
		int actuals[] = new int[input1.length];
		for(int i=0; i<actuals.length; i++)
			actuals[i] = LcmHcf.hcfCalculate(input1[i], input2[i]);
		int expecteds[] = {2, 2, 3, 1, 1, 6};
		assertArrayEquals(expecteds, actuals);
	}
}
