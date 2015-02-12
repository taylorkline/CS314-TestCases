/**
 * A class to run tests on the MathMatrix class
 * @author Taylor Kline
 * Github Account: jkdf2
 */
public class MathMatrixTester2{
  
  /**
   * main method that runs simple test on the MathMatrix class
   * @param args not used
   */
  public static void main(String[] args) {
    int small[][] = {{25}};
    int elevens[][] = {
      {-11, -11, -11, -11},
      {-11, -11, -11, -11}};
    int bigAndSmall[][] = {
      {500, 200, 100, 200},
      {200, 100, 200, 500},
      {1, 2, 3, 4},
      {500, 200, 100, 200}};
    
    //test 1, tests size and values constructor
    MathMatrix oneByOne = new MathMatrix(1, 1, 25);
    printTestResult( get2DArray(oneByOne), small, 1, "constructor with size and initial val specified");
    
    //test 2-3, tests size and values constructor
    MathMatrix allNegative = new MathMatrix(2, 4, -11);
    printTestResult( get2DArray(allNegative), elevens, 2, "constructor with size and initial val specified");
    if(sumVals(allNegative) == -88)
      System.out.println("Passed test 3, sum of values in matrix created by test 2.");
    else
      System.out.println("*****FAILED***** test 3, sum of values in matrix created by test 2.");
    
    //tests 4 and 5, int[][] constructor, deep copy
    //create data1 with same values as 'elevens'
    int data1[][] = {
      {-11, -11, -11, -11},
      {-11, -11, -11, -11}};
    allNegative = new MathMatrix(data1);
    // alter data1. allNegative should be unchanged if deep copy made
    data1[0][0] = 2;
    // data1 altered. allNegative should be unchanged if deep copy made
    printTestResult( get2DArray(allNegative), elevens, 4, "constructor with one parameter of type int[][]. Testing deep copy made.");
    
    //create data1 with same values as 'small'
    data1 = new int[][]{{25}};
    MathMatrix testMatrix1 = new MathMatrix(data1);
    // alter data1. testMatrix1 should be unchanged if deep copy made
    data1[0][0] = 2;
    // data1 altered. testMatrix1 should be unchanged if deep copy made
    printTestResult( get2DArray(testMatrix1), small, 5, "constructor with one parameter of type int[][]. Testing deep copy made.");
    
    //tests 6-11, addition
    testMatrix1 = new MathMatrix(data1);
    MathMatrix testMatrix2 = oneByOne.add(testMatrix1);
    int storageArray[][] = {{27}};
    printTestResult( get2DArray(testMatrix1), data1, 6, "add method. Testing testMatrix1 unchanged.");
    printTestResult( get2DArray(oneByOne), small, 7, "add method. Testing oneByOne unchanged.");
    printTestResult( get2DArray(testMatrix2), storageArray, 8, "add method. Testing testMatrix2 correct result.");
    
    data1 = new int[][]{
      {11, 11, 11, 11},
      {11, 11, 11, 11}};
    testMatrix1 = new MathMatrix(data1);
    testMatrix2 = allNegative.add(testMatrix1);
    storageArray = new int[][]{
      {0, 0, 0, 0},
      {0, 0, 0, 0}};
    printTestResult( get2DArray(testMatrix1), data1, 9, "add method. Testing testMatrix1 unchanged.");
    printTestResult( get2DArray(allNegative), elevens, 10, "add method. Testing allNegative unchanged.");
    printTestResult( get2DArray(testMatrix2), storageArray, 11, "add method. Testing testMatrix2 correct result.");
    
    //tests 12-17, multiplication
    data1 = new int[][]{
      {11, 11},
      {10, 0}};
    testMatrix1 = new MathMatrix(data1);
    testMatrix2 = testMatrix1.multiply(allNegative);
    storageArray = new int[][]{
      {-242, -242, -242, -242},
      {-110, -110, -110, -110}};
    printTestResult( get2DArray(testMatrix1), data1, 12, "multiply method. Testing testMatrix1 unchanged.");
    printTestResult( get2DArray(allNegative), elevens, 13, "multiply method. Testing allNegative unchanged.");
    printTestResult( get2DArray(testMatrix2), storageArray, 14, "multiply method. Testing testMatrix2 correct result.");
    
    data1 = new int[][]{{-10}};
    testMatrix1 = new MathMatrix(data1);
    testMatrix2 = testMatrix1.multiply(oneByOne);
    storageArray = new int[][]{{-250}};
    printTestResult( get2DArray(testMatrix1), data1, 15, "multiply method. Testing testMatrix1 unchanged.");
    printTestResult( get2DArray(oneByOne), small, 16, "multiply method. Testing oneByOne unchanged.");
    printTestResult( get2DArray(testMatrix2), storageArray, 17, "multiply method. Testing testMatrix2 correct result.");
    
    //test 18-19, toString()
    String expected = "| 25|\n";
    if (oneByOne.toString().equals(expected))
      System.out.println("passed test 18, toString method.");
    else
      System.out.println("*****FAILED****** test 18, toString method.");
    
    MathMatrix variedVals = new MathMatrix(bigAndSmall);
    expected = "| 500 200 100 200|\n| 200 100 200 500|\n|   1   2   3   4|\n| 500 200 100 200|\n";
    if (variedVals.toString().equals(expected))
      System.out.println("passed test 19, toString method.");
    else
      System.out.println("*****FAILED****** test 19, toString method.");
    
    //test 20-22, upperTriangular
    if(oneByOne.isUpperTriangular())
      System.out.println("Passed test 20, upperTriangular method.");
    else
      System.out.println("*****FAILED***** test 20, upperTriangular method.");
    
    if(!variedVals.isUpperTriangular())
      System.out.println("Passed test 21, upperTriangular method.");
    else
      System.out.println("*****FAILED***** test 21, upperTriangular method.");
    
    //manually make bigAndSmall upperTriangular
    bigAndSmall = new int[][]{
      {500, 200, 100, 200},
      {0, 100, 200, 500},
      {0, 0, 3, 4},
      {0, 0, 0, 200}};
    variedVals = new MathMatrix(bigAndSmall);
    if(variedVals.isUpperTriangular())
      System.out.println("Passed test 22, upperTriangular method.");
    else
      System.out.println("*****FAILED***** test 22, upperTriangular method.");
    //restore bigAndSmall and variedVals to previous values
    bigAndSmall = new int[][]{
      {500, 200, 100, 200},
      {200, 100, 200, 500},
      {1, 2, 3, 4},
      {500, 200, 100, 200}};
    
    //tests 23-24, changeElement
    variedVals.changeElement(1, 0, 200);
    variedVals.changeElement(2, 0, 1);
    variedVals.changeElement(2, 1, 2);
    variedVals.changeElement(3, 0, 500);
    variedVals.changeElement(3, 1, 200);
    variedVals.changeElement(3, 2, 100);
    printTestResult( get2DArray(variedVals), bigAndSmall, 23, "changeElement method. Testing variedVals correct result.");
    
    small[0][0] = 42;
    oneByOne.changeElement(0, 0, 42);
    printTestResult( get2DArray(oneByOne), small, 24, "changeElement method. Testing oneByOne correct result.");
    
    //tests 25-27, getTranspose
    testMatrix1 = oneByOne.getTranspose();
    printTestResult( get2DArray(testMatrix1), small, 25, "getTranspose method. Testing testMatrix1 correct result.");
    
    testMatrix1 = allNegative.getTranspose();
    printTestResult( get2DArray(allNegative), elevens, 26, "getTranspose method. Testing allNegative unchanged.");
    elevens = new int[][]{
      {-11, -11},
      {-11, -11},
      {-11, -11},
      {-11, -11}};
    printTestResult( get2DArray(testMatrix1), elevens, 27, "getTranspose method. Testing testMatrix1 correct result.");
    
    //tests 28-29, getVal
    storageArray = new int[][]{{oneByOne.getVal(0, 0)}};
    printTestResult(storageArray, small, 28, "getVal method. Testing storageArray contains correct result.");
    
    storageArray = new int[4][4];
    for (int r = 0; r < storageArray.length; r++) {
      for (int c = 0; c < storageArray[r].length; c++) {
        storageArray[r][c] = variedVals.getVal(r, c);
      }
    }
    printTestResult(storageArray, bigAndSmall, 29, "getVal method. Testing storageArray contains correct result.");
    
    //tests 30-31, numCols
    if(oneByOne.numCols() == 1)
      System.out.println("Passed test 30, numCols method.");
    else
      System.out.println("*****FAILED***** test 30, numCols method.");
    
    if(allNegative.numCols() == 4)
      System.out.println("Passed test 31, numCols method.");
    else
      System.out.println("*****FAILED***** test 31, numCols method.");
    
    //tests 32-33, numRows
    if(oneByOne.numRows() == 1)
      System.out.println("Passed test 32, numRows method.");
    else
      System.out.println("*****FAILED***** test 32, numRows method.");
    
    if(allNegative.numRows() == 2)
      System.out.println("Passed test 33, numRows method.");
    else
      System.out.println("*****FAILED***** test 33, numRows method.");
    
    //tests 34-35
    small[0][0] = 25;
    testMatrix1 = new MathMatrix(small);
    testMatrix1.scale(2);
    small[0][0] = 50;
    printTestResult(get2DArray(testMatrix1), small, 34, "scale method. Testing testMatrix1 contains correct result.");
    
    variedVals.scale(-10);
    bigAndSmall = new int[][]{
      {-5000, -2000, -1000, -2000},
      {-2000, -1000, -2000, -5000},
      {-10, -20, -30, -40},
      {-5000, -2000, -1000, -2000}};
    printTestResult(get2DArray(variedVals), bigAndSmall, 35, "scale method. Testing variedVals contains correct result.");
    
    //tests 36-41, subtraction
    data1 = new int[][]{{27}};
    testMatrix1 = new MathMatrix(data1);
    small[0][0] = 25;
    oneByOne = new MathMatrix(small);
    testMatrix2 = oneByOne.subtract(testMatrix1);
    storageArray = new int[][]{{-2}};
    printTestResult( get2DArray(testMatrix1), data1, 36, "subtract method. Testing testMatrix1 unchanged.");
    printTestResult( get2DArray(oneByOne), small, 37, "subtract method. Testing oneByOne unchanged.");
    printTestResult( get2DArray(testMatrix2), storageArray, 38, "subtract method. Testing testMatrix2 correct result.");
    
    data1 = new int[][]{
      {11, 11, 11, 11},
      {11, 11, 11, 11}};
    testMatrix1 = new MathMatrix(data1);
    elevens = new int[][]{
      {-11, -11, -11, -11},
      {-11, -11, -11, -11}};
    allNegative = new MathMatrix(elevens);
    testMatrix2 = allNegative.subtract(testMatrix1);
    storageArray = new int[][]{
      {-22, -22, -22, -22},
      {-22, -22, -22, -22}};
    printTestResult( get2DArray(testMatrix1), data1, 39, "subtract method. Testing testMatrix1 unchanged.");
    printTestResult( get2DArray(allNegative), elevens, 40, "subtract method. Testing allNegative unchanged.");
    printTestResult( get2DArray(testMatrix2), storageArray, 41, "subtract method. Testing testMatrix2 correct result.");
  }
  
  
  // method that sums elements of mat, may overflow int!
  // pre: mat != null
  private static int sumVals(MathMatrix mat) {
    if(mat == null)
      throw new IllegalArgumentException("Violation of sumVals precondition: mat may not be null");
    
    int result = 0;
    final int ROWS =  mat.numRows();
    final int COLS = mat.numCols();
    for(int r = 0; r < ROWS; r++)
      for(int c = 0; c < COLS; c++) 
      result += mat.getVal(r, c); // likely to overflow, but can still do simple check
    return result;
  }
  
  
  private static void printTestResult(int[][] data1, int[][] data2, int testNum, String testingWhat) {
    System.out.print( "Test number " + testNum + " tests the " + testingWhat +". The test ");
    String result = equals(data1, data2) ? "passed" : "failed";
    System.out.println( result );
  }
  
  // pre: m != null, m is at least 1 by 1 in size
  private static int[][] get2DArray(MathMatrix m) {
    //check precondition
    assert ( m != null ) && ( m.numRows() > 0 ) && ( m.numCols()> 0 )
    : "Violation of get2DArray precondition: Rows: "+m.numRows()+" Columns: "+m.numCols();
    int[][] result = new int[m.numRows()][m.numCols()];
    for(int r = 0; r < result.length; r++)
    {   for(int c = 0; c < result[0].length; c++)
      {   result[r][c] = m.getVal(r,c);
    }
    }
    return result;
  }
  
  // pre: data1 != null, data2 != null, data1 and data2 are at least 1 by 1 matrices
  //      data1 and data2 are rectangular matrices
  // post: return true if data1 and data2 are the same size and all elements are
  //      the same
  private static boolean equals(int[][] data1, int[][] data2) {
    //check precondition
    if( ( data1 == null ) || ( data1.length == 0 )
         || ( data1[0].length == 0 ) || !rectangularMatrix(data1)
         ||  ( data2 == null ) || ( data2.length == 0 )
         || ( data2[0].length == 0 ) || !rectangularMatrix(data2))
      throw new IllegalArgumentException( "Violation of precondition: equals check on 2d arrays of ints");
    
    boolean result = (data1.length == data2.length) && (data1[0].length == data2[0].length);
    int row = 0;
    while( result && row < data1.length ) {
      int col = 0;
      while( result && col < data1[0].length ) {
        result = (data1[row][col] == data2[row][col]);
        col++;
      }
      row++;
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
}