package recursion;

public class LcmHcf {
	/**
	 * Calculates HCF using of two numbers using Euclid’s algorithm 
	 * @param a First Number
	 * @param b Second Number
	 * @return HCF of two numbers
	 */
	static int hcfCalculate(int a, int b){
		if( a==0 && b==0)
			throw new IllegalStateException("HCF(0,0) is not defined");
		if(a < 0 || b < 0)
			throw new IllegalStateException("Both Number should be positive");
        if (a == 0)
            return b; 
        return hcfCalculate(b % a, a); 
    }
	/**
	 * Calculates LCM by calculating HCF of two numbers
	 * @param a First Number
	 * @param b Second Number
	 * @return LCM of two numbers
	 */
	static int lcmCalculate(int a, int b){
		if(a <= 0 || b <= 0)
			throw new IllegalStateException("A and B should be positive");
        return (a / hcfCalculate(a, b)) * b;
    }
	
}
