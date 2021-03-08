package programmingFundamentalAssignment;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.rules.ExpectedException;

public class SparseMatrixJunitTesing {
	@Rule
    public ExpectedException thrown = ExpectedException.none();
	//testing transpose function of SparseMatrix
	@Test
	public void testTranspose() {
		int r = 3;
		int c = 3;
		SparseMatrix m = new SparseMatrix(r, c);
		m.insertValue(1, 2, 1);
		m.insertValue(3, 3, 2);
		SparseMatrix result = m.getTranspose();
		SparseMatrix n = new SparseMatrix(c, r);
		n.insertValue(2, 1, 1);
		n.insertValue(3, 3, 2);
		boolean condition = result.compareSparseMatrix(n);
		assertTrue(condition);
	}
	//testing transpose function of SparseMatrix
	@Test
	public void testTranspose1() {
			int r = 4;
			int c = 5;
			SparseMatrix m = new SparseMatrix(r, c);
			m.insertValue(1, 2, 1);
			m.insertValue(3, 3, 2);
			m.insertValue(3, 4, 1);
			SparseMatrix result = m.getTranspose();
			SparseMatrix n = new SparseMatrix(c, r);
			n.insertValue(2, 1, 1);
			n.insertValue(3, 3, 2);
			n.insertValue(4, 3, 1);
			boolean condition = result.compareSparseMatrix(n);
			assertTrue(condition);
		}
	//testing the SparseMatrix Positive(When returned value is True) Symmetric Method
	@Test
	public void testSymmetric() {
		int r = 3;
		int c = 3;
		SparseMatrix m = new SparseMatrix(r, c);
		m.insertValue(1, 1, 1);
		m.insertValue(2, 2, 2);
		m.insertValue(3,3,3);
		boolean condition = SparseMatrix.isSymmetric(m);
		assertTrue(condition);
	}
	//testing the Sparse Matrix Negative(When returned value is False) Symmetric Method
	@Test
	public void testSymmetric1() {
		int r = 3;
		int c = 3;
		SparseMatrix m = new SparseMatrix(r, c);
		m.insertValue(1, 2, 1);
		m.insertValue(2, 2, 2);
		m.insertValue(3,3,3);
		boolean condition = SparseMatrix.isSymmetric(m);
		assertFalse(condition);
	}
	//Function to test Addition of two sparse matrices when add method is throwing exception
	@Test
	public void testAdditionException(){
		thrown.expect(IllegalStateException.class);
		//Expecting a exception which contains the following message
		thrown.expectMessage("Addition is not possible because Row and Column Numbers are differeing");
		int r = 3;
		int c = 2;
		SparseMatrix m1 = new SparseMatrix(r, c);
		m1.insertValue(1, 1, 2);
		m1.insertValue(3, 1, 3);
		m1.insertValue(2, 1, 4);
		int r1 = 4;
		int c1 = 5;
		SparseMatrix m2 = new SparseMatrix(r1, c1);
		m2.insertValue(1, 1, 3);
		m2.insertValue(3, 4, 4);
		m1.add(m2);
	}
	// Function to test Addition of two sparse matrices
	@Test
	public void testAddition(){
		int r = 3;
		int c = 2;
		SparseMatrix m1 = new SparseMatrix(r, c);
		m1.insertValue(1, 1, 2);
		m1.insertValue(3, 1, 3);
		m1.insertValue(2, 1, 4);
		int r1 = 3;
		int c1 = 2;
		SparseMatrix m2 = new SparseMatrix(r1, c1);
		m2.insertValue(1, 1, 3);
		m2.insertValue(2, 2, 4);
		SparseMatrix expected = m1.add(m2);
		SparseMatrix actual = new SparseMatrix(r, c);
		actual.insertValue(1, 1, 5);
		actual.insertValue(2, 2, 4);
		actual.insertValue(3, 1, 3);
		actual.insertValue(2, 1, 4);
		boolean result = expected.compareSparseMatrix(actual);
		assertTrue(result);
	}
	//Function to check whether multiply function is throwing exception when a wrong input is provided
	@Test
	public void testMultiplicationException(){
		thrown.expect(IllegalStateException.class);
		//Expecting a exception which contains the following message
		thrown.expectMessage("Multiplication is not possible." + "Invalid dimensions (Number of Columns of first matrix should be equal to Number of Rows of second matrix");
		int r = 3;
		int c = 2;
		SparseMatrix m1 = new SparseMatrix(r, c);
		m1.insertValue(1, 1, 2);
		m1.insertValue(3, 1, 3);
		m1.insertValue(2, 1, 4);
		int r1 = 4;
		int c1 = 5;
		SparseMatrix m2 = new SparseMatrix(r1, c1);
		m2.insertValue(1, 1, 3);
		m2.insertValue(3, 4, 4);
		m1.multiply(m2);
	}
	//Function to check multiplication of two Sparse Matrices
	@Test
	public void testMultiplication(){
		int r = 3;
		int c = 2;
		SparseMatrix m1 = new SparseMatrix(r, c);
		m1.insertValue(1, 1, 2);
		m1.insertValue(2, 1, 4);
		m1.insertValue(3, 1, 3);
		int r1 = 2;
		int c1 = 3;
		SparseMatrix m2 = new SparseMatrix(r1, c1);
		m2.insertValue(1, 1, 3);
		m2.insertValue(2, 2, 4);
		SparseMatrix expected = m1.multiply(m2);
		SparseMatrix actual = new SparseMatrix(r, c);
		actual.insertValue(1, 1, 6);
		actual.insertValue(2, 1, 12);
		actual.insertValue(3, 1, 9);
		boolean result = expected.compareSparseMatrix(actual);
		assertTrue(result);
	}
}
