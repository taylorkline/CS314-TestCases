import java.util.Arrays;
/**
 * A class to run tests on the MathMatrix class
 * @author Keith Gibson
 * Note: requires methods and/or imports not in the default Tester class
 */
public class MathMatrixTester3{
  /**
   * main method that runs simple test on the MathMatrix class
   *
   * @param args not used
   */
  public static void main(String[] args) {
    int n = 10;
    int[][] compArray = new int[n][n];
    for (int r = 0; r < compArray.length; r++){
      Arrays.fill(compArray[r], 10);
    }
    MathMatrix m1 = new MathMatrix(n, n, n);
    MathMatrix m2 = new MathMatrix(compArray);
    
    //Test 1, .equals, two MathMatrix made with different constructors, same values
    int testNum = 1;
    String testSummary = " :: .equals, two MathMatrix made with different constructors, same values";
    boolean expectBool = true;
    boolean actualBool = m1.equals(m2);
    String result =  (actualBool == expectBool) ? " passed" : " failed. Expected: " + expectBool + " Actual: " + actualBool;
    System.out.println("Test " + testNum + result + testSummary);
    testNum++;
    
    //Test 2, .equals, MathMatrix compared to an array with identical values
    testSummary = " :: .equals, MathMatrix compared to an array with identical values";
    expectBool = false;
    actualBool = m1.equals(compArray);
    result =  (actualBool == expectBool) ? " passed" : " failed. Expected: " + expectBool + " Actual: " + actualBool;
    System.out.println("Test " + testNum + result + testSummary);
    testNum++;
    
    //Test 3, .toString, correctly outputs a single element MathMatrix
    testSummary = " :: .toString, correctly outputs a single element MathMatrix";
    m1 = new MathMatrix(1, 1, 0);
    String expectString = "| 0|\n";
    result =  (expectString.equals(m1.toString())) ? " passed" : " failed.\n Expected: \n" + expectString + "\n Actual: \n" + m1.toString();
    System.out.println("Test " + testNum + result + testSummary);
    testNum++;
    
    //Test 4, .toString, correctly handles equal negative and positive spacing
    testSummary = " :: .toString, correctly handles equal negative and positive spacing";
    compArray = new int [2][2];
    compArray[0][0] = 1;
    compArray[1][1] = -1;
    m1 = new MathMatrix(compArray);
    expectString = "|  1  0|\n|  0 -1|\n";
    result =  (expectString.equals(m1.toString())) ? " passed" : " failed.\n Expected: \n" + expectString + "\n Actual: \n" + m1.toString();
    System.out.println("Test " + testNum + result + testSummary);
    testNum++;
    
    //Test 5, .numRows
    testSummary = " :: .numRows, straightforward check on numRows";
    int expectInt = 2;
    result =  (expectInt == m1.numRows()) ? " passed" : " failed. Expected: " + expectInt + " Actual: " + m1.numRows();
    System.out.println("Test " + testNum + result + testSummary);
    testNum++;
    
    //Test 6, .numCols
    testSummary = " :: .numCols, straightforward check on numRows";
    result =  (expectInt == m1.numCols()) ? " passed" : " failed. Expected: " + expectInt + " Actual: " + m1.numCols();
    System.out.println("Test " + testNum + result + testSummary);
    testNum++;
    
    //Test 7, .numRows
    testSummary = " :: .numRows, straightforward check on numRows";
    expectInt = n;
    m1 = new MathMatrix(n,2*n,n);
    result =  (expectInt == m1.numRows()) ? " passed" : " failed. Expected: " + expectInt + " Actual: " + m1.numRows();
    System.out.println("Test " + testNum + result + testSummary);
    testNum++;
    
    //Test 8, .numCols
    testSummary = " :: .numCols, straightforward check on numRows";
    expectInt = 2*n;
    result =  (expectInt == m1.numCols()) ? " passed" : " failed. Expected: " + expectInt + " Actual: " + m1.numCols();
    System.out.println("Test " + testNum + result + testSummary);
    testNum++;
    
    //Test 9, .getVal, return the value at 1,1
    testSummary = " :: .getVal, return the value at 1,1; should equal -1";
    m1 = new MathMatrix(compArray);
    result =  (m1.getVal(1, 1) == compArray[1][1]) ? " passed" : " failed. Expected: " + compArray[1][1] + " Actual: " + m1.getVal(1, 1);
    System.out.println("Test " + testNum + result + testSummary);
    testNum++;
    
    //test 10, .getVal, asks for out-of-bounds value; should return an exception other than ArrayIndexOutOfBoundsException
    //Note: it should throw the exception of your getVal method!
    testSummary = " :: .getVal, asks for out-of-bounds value; assumes exception used is not ArrayIndexOutOfBoundsException";
    try {
      m1.getVal(0,m1.numCols());
      result = " failed. Expected: exception for parameter issue or ArrayIndexOutOfBoundsException. o.O How did you even get here?";
      System.out.println("Test " + testNum + result + testSummary);
      testNum++;
    } catch (Exception e) {
      result =  (e instanceof ArrayIndexOutOfBoundsException) ? " failed. Expected: exception other than ArrayIndexOutOfBoundsException Actual: " + e : " passed" ;
      System.out.println("Test " + testNum + result + testSummary);
      testNum++;
    }
    
    //test 11, .changeElement, change the value at 1,1 of the MathMatrix
    testSummary = " :: .changeElement, changes the value at 1,1 of the MathMatrix; no change to original array. relies on getVal";
    m1 = new MathMatrix(compArray);
    m1.changeElement(1, 1, 100);
    result =  (m1.getVal(1,1) == compArray[1][1]) ? " failed. Expected: !" + compArray[1][1] + " Actual: " + m1.getVal(1, 1) : " passed" ;
    System.out.println("Test " + testNum + result + testSummary);
    testNum++;
    
    //test 12, .changeElement, asks for out-of-bounds value; should return an exception other than ArrayIndexOutOfBoundsException
    //Note: it should throw the exception of your ChangeElements method!
    testSummary = " :: .changeElement, asks for out-of-bounds value; assumes exception used is not ArrayIndexOutOfBoundsException";
    try {
      m1.changeElement(m1.numRows(),0, 100);
      result = " failed. Expected: exception for parameter issue or ArrayIndexOutOfBoundsException. o.O How did you even get here?";
      System.out.println("Test " + testNum + result + testSummary);
      testNum++;
    } catch (Exception e) {
      result =  (e instanceof ArrayIndexOutOfBoundsException) ? " failed. Expected: exception other than ArrayIndexOutOfBoundsException Actual: " + e : " passed" ;
      System.out.println("Test " + testNum + result + testSummary);
      testNum++;
    }
    
    //test 13, .scale,
    testSummary = " :: .scale, doubles all m2 values from 10 to 20";
    compArray = new int[n][n];
    for (int r = 0; r < compArray.length; r++){
      Arrays.fill(compArray[r], 20);
    }
    m2.scale(2);
    int [][] m2Array = get2DArray(m2);
    result = Arrays.deepEquals(compArray, m2Array) ? " passed" : "failed. Expected values: " + Arrays.deepToString(compArray) + " Actual: " + Arrays.deepToString(m2Array);
    System.out.println("Test " + testNum + result + testSummary);
    testNum++;
    
    //test 14, .scale
    testSummary = " :: .scale, doubles all m2 values from 10 to 20";
    m1 = new MathMatrix(m2Array);
    m2.scale(0);
    int[][] m1Array = get2DArray(m1);
    m2Array = get2DArray(m2);
    compArray = new int[m2.numRows()][m2.numCols()];
    result = (!Arrays.deepEquals(m1Array, m2Array) && Arrays.deepEquals(m2Array, compArray)) ? " passed" : "failed. Either m1 was affected by m2.scale(0), or m2.scale(0) did not set all values to 0";
    System.out.println("Test " + testNum + result + testSummary);
    testNum++;     
    
    //test 15, .isUpperTriangular, 1x1 matrix
    testSummary = " :: .isUpperTriangular, checks 1x1 matrix";
    m1 = new MathMatrix(1, 1, 1);
    expectBool = true;
    actualBool = m1.isUpperTriangular();
    result =  (actualBool == expectBool) ? " passed" : " failed. Expected: " + expectBool + " Actual: " + actualBool;
    System.out.println("Test " + testNum + result + testSummary);
    testNum++;     
    
    //test 16, .isUpperTriangular, 3x3 matrix, bottom left == -1
    testSummary = " :: .isUpperTriangular, checks 3x3 matrix, bottom left == -1";
    m1 = new MathMatrix(3, 3, 0);
    m1.changeElement(2, 0, -1);
    expectBool = false;
    actualBool = m1.isUpperTriangular();
    result =  (actualBool == expectBool) ? " passed" : " failed. Expected: " + expectBool + " Actual: " + actualBool;
    System.out.println("Test " + testNum + result + testSummary);
    testNum++;     
    
    // test 17, .getTranspose, don't alter original MathMatrix, 
    testSummary = " :: .getTranspose, don't alter original MathMatrix. move -1 from bottom left to top right";
    compArray = get2DArray(m1);
    m2 = m1.getTranspose();
    m1Array = get2DArray(m1);
    m2Array = get2DArray(m2);
    int[][] testArray= {{0, 0, -1},{0, 0, 0}, {0, 0, 0}};
    if (Arrays.deepEquals(compArray, m1Array)){
      result =  (Arrays.deepEquals(m2Array, testArray)) ? " passed" : " failed. Expected: " + Arrays.deepToString(testArray) + " Actual: " + Arrays.deepToString(m2Array);
    } else {
      result = "failed. Transpose modified original MathMatrix";
    }
    System.out.println("Test " + testNum + result + testSummary);
    testNum++;
    
    // test 18, .getTranspose, 1x10
    testSummary = " :: .getTranspose, 1x10 of 0s to 10x1 of 0s";
    m1 = new MathMatrix(1,10,0);
    m2 = m1.getTranspose();
    expectBool = true;
    actualBool = m2.numRows() == 10 && m2.numCols() == 1 && sumVals(m2) == 0;
    result =  (actualBool == expectBool) ? " passed" : " failed. Expected: " + expectBool + " Actual: " + actualBool;
    System.out.println("Test " + testNum + result + testSummary);
    testNum++;     
    
    // test 19, .add, add 1x10 to 10x1, parameter check
    //Note: it should throw the exception of your add method!
    testSummary = " :: .add, 1x10 with 10x1; assumes exception used is not ArrayIndexOutOfBoundsException";
    try {
      m1.add(m2);
      result = " failed. Expected: exception for parameter issue or ArrayIndexOutOfBoundsException. o.O How did you even get here?";
      System.out.println("Test " + testNum + result + testSummary);
      testNum++;
    } catch (Exception e) {
      result =  (e instanceof ArrayIndexOutOfBoundsException) ? " failed. Expected: exception other than ArrayIndexOutOfBoundsException Actual: " + e : " passed" ;
      System.out.println("Test " + testNum + result + testSummary);
      testNum++;
    }
    
    // test 20, .subtract, subtract 1x10 from 10x1, parameter check
    //Note: it should throw the exception of your subtract method!
    testSummary = " :: .subtract, 1x10 with 10x1; assumes exception used is not ArrayIndexOutOfBoundsException";
    try {
      m1.subtract(m2);
      result = " failed. Expected: exception for parameter issue or ArrayIndexOutOfBoundsException. o.O How did you even get here?";
      System.out.println("Test " + testNum + result + testSummary);
      testNum++;
    } catch (Exception e) {
      result =  (e instanceof ArrayIndexOutOfBoundsException) ? " failed. Expected: exception other than ArrayIndexOutOfBoundsException Actual: " + e : " passed" ;
      System.out.println("Test " + testNum + result + testSummary);
      testNum++;
    }
    
    //test 21, .subtract, assumes scale works correctly
    testSummary = " :: .subtract, subtracts a matrix from itself and compares against .scale(0) (assumes scale works correctly)";
    m1 = new MathMatrix(n,2*n,n);
    m2 = m1.subtract(m1);
    m1.scale(0);
    m1Array = get2DArray(m1);
    m2Array = get2DArray(m2);
    expectBool = true;
    actualBool = Arrays.deepEquals(m1Array, m2Array);
    result =  (actualBool == expectBool) ? " passed" : " failed. Expected: " + expectBool + " Actual: " + actualBool;
    System.out.println("Test " + testNum + result + testSummary);
    testNum++;
    
    //test 22, .add, assumes scale works correctly
    testSummary = " :: .add, adds matrix to itself and compares against .scale(2) (assumes scale works correctly)";
    m1 = new MathMatrix(n,2*n,n);
    m2 = m1.add(m1);
    m1.scale(2);
    m1Array = get2DArray(m1);
    m2Array = get2DArray(m2);
    expectBool = true;
    actualBool = Arrays.deepEquals(m1Array, m2Array);
    result =  (actualBool == expectBool) ? " passed" : " failed. Expected: " + expectBool + " Actual: " + actualBool;
    System.out.println("Test " + testNum + result + testSummary);
    testNum++;
    
    
    //test 23, .multiply,
    //Note: it should throw the exception of your multiply method!
    testSummary = " :: .multiply, tests precondition check";
    try {
      m1.multiply(m2);
      result = " failed. Expected: exception for parameter issue or ArrayIndexOutOfBoundsException. o.O How did you even get here?";
      System.out.println("Test " + testNum + result + testSummary);
      testNum++;
    } catch (Exception e) {
      result =  (e instanceof ArrayIndexOutOfBoundsException) ? " failed. Expected: exception other than ArrayIndexOutOfBoundsException Actual: " + e : " passed" ;
      System.out.println("Test " + testNum + result + testSummary);
      testNum++;
    }
    
    //test 24, .multiply
    testSummary = " :: .multiply, 10x20 with 20x10, confirms that left-to-right gets 10x10 matrix, and right-to-left gets a 20x20";
    m2 = m2.getTranspose();
    MathMatrix m3 = m1.multiply(m2);
    MathMatrix m4 = m2.multiply(m1);
    int[][] m3Array = get2DArray(m3);
    int[][] m4Array = get2DArray(m4);
    expectBool = true;
    actualBool = isSquare(m3Array) && isSquare(m4Array) && m3Array.length == 10 && m4Array.length == 20;
    result =  (actualBool == expectBool) ? " passed" : " failed. Expected: " + expectBool + " Actual: " + actualBool;
    System.out.println("Test " + testNum + result + testSummary);
    testNum++;
    
  }
  
  // method that sums elements of mat, may overflow int!
  // pre: mat != null
  private static int sumVals(MathMatrix mat) {
    if(mat == null)
      throw new IllegalArgumentException("mat may not be null");
    
    int result = 0;
    final int ROWS =  mat.numRows();
    final int COLS = mat.numCols();
    for(int r = 0; r < ROWS; r++)
      for(int c = 0; c < COLS; c++) 
      result += mat.getVal(r, c); // likely to overflow, but can still do simple check
    return result;
  }
  
  // pre: m != null, m is at least 1 by 1 in size
  private static int[][] get2DArray(MathMatrix m) {
    //check precondition
    assert ( m != null ) && ( m.numRows() > 0 ) && ( m.numCols()> 0 )
    : "Violation of precondition: get2DArray";
    
    int[][] result = new int[m.numRows()][m.numCols()];
    for(int r = 0; r < result.length; r++)
    {   for(int c = 0; c < result[0].length; c++)
      {   result[r][c] = m.getVal(r,c);
    }
    }
    return result;
  }
  
  // method to ensure mat is rectangular
  // pre: mat != null, mat is at least 1 by 1
  private static boolean rectangularMatrix( int[][] mat ) {
    if(mat == null || mat.length == 0 || mat[0].length == 0)
      throw new IllegalArgumentException("Violation of precondition: "
                                           + " Parameter mat may not be null" 
                                           + " and must be at least 1 by 1");
    return MathMatrix.rectangularMatrix(mat);
  }
  
  private static boolean isSquare(int[][] mat) {
    boolean result = rectangularMatrix(mat);
    if (result){
      result = mat.length == mat[0].length;
    }
    return result;
  }
}
