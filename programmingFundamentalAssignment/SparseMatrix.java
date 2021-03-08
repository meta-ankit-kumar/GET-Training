package programmingFundamentalAssignment;

import java.util.Scanner;

public class SparseMatrix {
	private int row, column;
	private int length;
	final private int MAX = 100;//Maximum number of rows that can be inserted
	int matrix[][] = new int[MAX][3];
	//Constructor to initialize rows, columns and length
	public SparseMatrix(int r, int c){
		this.row = r;
		this.column = c;
		this.length = 0;
	}
	/**
	 * Insert value in Sparse Matrix
	 * @param r Row Number
	 * @param c Column Number
	 * @param value Value to be added
	 */
	public void insertValue(int r, int c, int value){
		if(this.length > this.MAX){
			throw new ArrayIndexOutOfBoundsException("Maximum Limit Reached");
		}
		this.matrix[length][0] = r;
		this.matrix[length][1] = c;
		this.matrix[length][2] = value;
		length += 1;//Increasing the length by 1
	}
	/**
	 * Method to print Sparse Matrix. Only Non-zero elements are printed
	 */
	public void printMatrix(){
		System.out.println("Non- Zero Matrix contents are following:");
		System.out.println("Row Column Value");
		for(int i=0; i<length; i++)
			System.out.println(matrix[i][0] + " " + matrix[i][1] + " " + matrix[i][2]);
		System.out.println();
	}
	
	// method to check a sparse matrix is symmetrical or not
	//Time complexity O(n) where n is the length of the sparse matrix
    public static boolean isSymmetric(SparseMatrix s1){
    	if(s1.row!=s1.column){
    		return false;
    	}
    	else{
    		// call transpose method to find transpose of the matrix
    		SparseMatrix transpose = s1.getTranspose();
    		int i = 0;
    		while(i<s1.length){
    			if(s1.matrix[i][0]==transpose.matrix[i][0]
    					&& s1.matrix[i][1]==transpose.matrix[i][1] 
    							&& s1.matrix[i][2]==transpose.matrix[i][2]){
    				if(i==s1.length-1){
    					return true;
    				}
    				i++;
    			}else{
    				return false;
    			}
    		}
		}
    	return false;
    }
    /**
     * This method finds the transpose of the given sparse matrix
     * Time Complexity O(n) where n is the length of matrix
     * @return SparseMatrix which we get by transposing the given matrix
     */
    public SparseMatrix getTranspose() {
        SparseMatrix transposeSparse = new SparseMatrix(column, row);
        transposeSparse.length = length;
        int count[] = new int[column + 1];
        for (int i = 1; i <= column; i++)
            count[i] = 0;
        for (int i = 0; i < length; i++)
            count[matrix[i][1]]++;
        int[] index = new int[column + 1];
        index[1] = 0;
        for (int i = 2; i <= column; i++)
            index[i] = index[i - 1] + count[i - 1];
        for (int i = 0; i < length; i++) {
            int rpos = index[matrix[i][1]]++;
            transposeSparse.matrix[rpos][0] = matrix[i][1];
            transposeSparse.matrix[rpos][1] = matrix[i][0];
            transposeSparse.matrix[rpos][2] = matrix[i][2];
        }
        return transposeSparse;
    }
    /**
     * Perform Addition of two sparse matrices
     * Complexity O(n) where n is the number of non-zero elements in sparse matrix
     * @param s2 Second Sparse Matrix that is going to be added with 1st sparse matrix
     * @return Returns the Sparse matrix which contains addition of both matrices.
     * @return Raise exception if addition is not possible
     */
    public SparseMatrix add(SparseMatrix s2) {
        if (row != s2.row || column != s2.column) {
            throw new IllegalStateException("Addition is not possible because Row and Column Numbers are differeing");
        } else {
            int i = 0, j = 0;
            // Construct an empty Sparse Matrix object which will contain addition of two Sparse Matrices
            SparseMatrix addedSparseMatrix = new SparseMatrix(row, column);
            while (i < length && j < s2.length) {
            	//If [row1, column1] > [row1, column1] then copy that [row1,column1] to sparse matrix 
                if (matrix[i][0] > s2.matrix[j][0]
                        || (matrix[i][0] == s2.matrix[j][0] && matrix[i][1] > s2.matrix[j][1])) {
                    addedSparseMatrix.insertValue(s2.matrix[j][0], s2.matrix[j][1], s2.matrix[j][2]);
                    j++;
                }
                //If above condition is false then copy the contents of 2nd matrix to sparse matrix
                else if (matrix[i][0] < s2.matrix[j][0]
                        || (matrix[i][0] == s2.matrix[j][0] && matrix[i][1] < s2.matrix[j][1])) {
                    addedSparseMatrix.insertValue(matrix[i][0], matrix[i][1], matrix[i][2]);
                    i++;
                } else {
                    int sum = matrix[i][2] + s2.matrix[j][2];
                    if (sum != 0)
                        addedSparseMatrix.insertValue(matrix[i][0], matrix[i][1], sum);
                    i++;
                    j++;
                }
            }
            // If elements are that are to be added, are remaining in 1st Sparse Matrix then that will be added to final Sparse Matrix
            while (i < length)
                addedSparseMatrix.insertValue(matrix[i][0], matrix[i][1], matrix[i++][2]);
         // If elements are that are to be added, are remaining in 2nd Sparse Matrix then that will be added to final Sparse Matrix
            while (j < s2.length)
                addedSparseMatrix.insertValue(s2.matrix[j][0], s2.matrix[j][1], s2.matrix[j++][2]);
            return addedSparseMatrix;
        }
    }
    /**
     * Perform Multiplication of two sparse matrices
     * Multiplication has a time complexity of O(x*n + y*m), 
     * where (x, m) is number of columns and terms in the second matrix;
     * and (y, n) is number of rows and terms in the first matrix.
     * @param s2 Second Sparse Matrix that is going to be multiplied with 1st sparse matrix
     * @return Returns the Sparse matrix which contains multiplication of both matrices.
     * @return Raise exception if multiplication is not possible
     */
    public SparseMatrix multiply(SparseMatrix s2) {
        if (column != s2.row) {
            throw new IllegalStateException("Multiplication is not possible." + "Invalid dimensions (Number of Columns of first matrix should be equal to Number of Rows of second matrix");
        }
        s2 = s2.getTranspose();
        int i, j;
        SparseMatrix result = new SparseMatrix(row, s2.row);
        for (i = 0; i < length;) {
            int r = matrix[i][0];
            for (j = 0; j < s2.length;) {
                int c = s2.matrix[j][0];
                int trackS1 = i;
                int trackS2 = j;
                int sum = 0;
                while (trackS1 < length && matrix[trackS1][0] == r && trackS2 < s2.length && s2.matrix[trackS2][0] == c) {
                    if (matrix[trackS1][1] < s2.matrix[trackS2][1])
                        trackS1++;
                    else if (matrix[trackS1][1] > s2.matrix[trackS2][1])
                        trackS2++;
                    else
                        sum += matrix[trackS1++][2] * s2.matrix[trackS2++][2];
                }
                if (sum != 0)
                    result.insertValue(r, c, sum);
                while (j < s2.length && s2.matrix[j][0] == c)
                    j++;
            }
            while (i < length && matrix[i][0] == r)
                i++;
        }
        return result;
    }
    /**
     * Utility function to compare two sparse matrices
     * @param s1 This matrix is going to be compared with original sparse matrix
     * @return Return true if they are equal otherwise false
     */
    public boolean compareSparseMatrix(SparseMatrix s1){
    	for(int i=0; i<this.length; i++){
    		if(s1.matrix[i][0] != matrix[i][0] || s1.matrix[i][1] != matrix[i][1] || s1.matrix[i][2] != matrix[i][2])
    			return false;
    	}
    	return true;
    }
    public static void main(String[] args){
    	System.out.println("Assume 1 based indexing");
    	System.out.println("Please select from the following options: "
    			+ "\n1.To get transpose of the matrix"
    			+ "\n2.To check whether it is a symmetrical matrix"
    			+ "\n3.Add two matrices"
    			+ "\n4.Multiply two matrices"
    			+ "\n5.Exit");
    	System.out.println("Please enter your choice");
    	int choice;
    	Scanner sc = new Scanner(System.in);
    	choice = sc.nextInt();
    	if(choice >= 1 && choice <= 4){
    		System.out.println("Please enter number of rows for sparse matrix");
    		int r = sc.nextInt();
    		System.out.println("Please enter number of columns for sparse matrix");
    		int c = sc.nextInt();
    		SparseMatrix m1 = new SparseMatrix(r, c);
    		int nonZero;
    		System.out.println("Please enter number of non zero elements");
    		nonZero = sc.nextInt();
    		System.out.println("Enter elements of sparse matrix."
    				+ "\n First enter row number"
    				+ "\n Then column number"
    				+ "\n Then Value");
    		for(int i=0; i < nonZero; i++)
    			m1.insertValue(sc.nextInt(), sc.nextInt(), sc.nextInt());
    		m1.printMatrix();
    		switch (choice) {
			case 1:
				SparseMatrix transpose = m1.getTranspose();
				System.out.println("Transposed matrix is:");
				transpose.printMatrix();
				break;
			case 2:
				if(isSymmetric(m1))
					System.out.println("Symmetric");
				else
					System.out.println("Non Symmetric");
				break;
			case 3:
				System.out.println("Please enter number of rows for sparse matrix");
	    		int r2 = sc.nextInt();
	    		System.out.println("Please enter number of columns for sparse matrix");
	    		int c2 = sc.nextInt();
	    		SparseMatrix m2 = new SparseMatrix(r2, c2);
	    		int nonZero2;
	    		System.out.println("Please enter number of non zero elements");
	    		nonZero2 = sc.nextInt();
	    		System.out.println("Enter elements of sparse matrix."
	    				+ "\n First enter row number"
	    				+ "\n Then column number"
	    				+ "\n Then Value");
	    		for(int i=0; i < nonZero2; i++)
	    			m2.insertValue(sc.nextInt(), sc.nextInt(), sc.nextInt());
	    		m2.printMatrix();
	    		SparseMatrix result1 = m1.add(m2);
	    		System.out.println("Sparse matrix after addition is:");
	    		result1.printMatrix();
	    		break;
			case 4:
				System.out.println("Please enter number of rows for sparse matrix");
	    		int r3 = sc.nextInt();
	    		System.out.println("Please enter number of columns for sparse matrix");
	    		int c3 = sc.nextInt();
	    		SparseMatrix m3 = new SparseMatrix(r3, c3);
	    		int nonZero3;
	    		System.out.println("Please enter number of non zero elements");
	    		nonZero3 = sc.nextInt();
	    		System.out.println("Enter elements of sparse matrix."
	    				+ "\n First enter row number"
	    				+ "\n Then column number"
	    				+ "\n Then Value");
	    		for(int i=0; i < nonZero3; i++)
	    			m3.insertValue(sc.nextInt(), sc.nextInt(), sc.nextInt());
	    		m3.printMatrix();
	    		SparseMatrix result3 = m1.multiply(m3);
	    		System.out.println("Sparse matrix after multiplication is:");
	    		result3.printMatrix();
	    		break;
			default:
				System.out.println("Please enter the correct choice");
				break;
			}
    	}
    	else if(choice != 5)
    		System.out.println("Please enter the correct choice");
    	sc.close();
    }
}
