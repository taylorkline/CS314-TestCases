/**
 * A class to run tests on the MathMatrix class
 * @author Joshua Guenther
 * Github Account: Yosh17
 */
public class MathMatrixTester1{
  /**
   * main method that runs simple test on the MathMatrix class
   * @param args not used
   */
  public static void main(String[] args) {
    //Block 1 of Tests
    int[][] data3 = new int[500][500];
    int[][] data4;
    for(int r = 0; r < data3[0].length; r++){
      for(int c = r; c < data3.length; c++){
        data3[r][c] = 1;}}
    MathMatrix mats1 = new MathMatrix(data3);
    //Test 1, upperTriangular Method (1)
    if(mats1.isUpperTriangular())
      System.out.println("Passed test 1, upperTriangular Method. ");
    else
      System.out.println("Failed test 1, upperTriangular Method."); 
    //Test 2, upperTriangular (2) and getTranspose (1) Method
    mats1 = mats1.getTranspose(); //if it is upperTraingular, then through transposing the matrix it won't be
    if(!mats1.isUpperTriangular())
      System.out.println("Passed test 2, upperTriangular and getTranspose Method.");
    else
      System.out.println("Failed test 2, upperTriangular and getTranspose Method."); 
    //Test 3, toString length (1)
    if(mats1.toString().length() ==  predictStringLength(1, data3))
      System.out.println("Passed test 3, length of toString result.");
    else
      System.out.println("Failed test 3, length of toString result.");
    //Test 4, numRows Method (1)
    if(mats1.numRows() == 500){
      System.out.println("Passed test 4, numRows Method.");}
    else{
      System.out.println("Failed test 4, numRows Method.");}
    //Test 5, NumCols Method (1)
    if(mats1.numCols() == 500){
      System.out.println("Passed test 5, numCols Method");}
    else{
      System.out.println("Failed test 5, numCols Method.");}
    
    //Block 2 of Tests
    data3 = new int[][]{{1, 2, 3},
      {4, 5, 6},
      {7, 8, 9}};
    data4 = new int[][]{{2, 1, 0},
      {-1, -2, -3},
      {-4, -5, -6}};
    mats1 = new MathMatrix(data3);
    MathMatrix mats2;
    MathMatrix mats3;
    MathMatrix mats4;
    //Test 6, getVal Method (1)
    if(mats1.getVal(2, 2) ==  9)
      System.out.println("Passed test 6, getVal Method");
    else
      System.out.println("Failed test 6, getVal Method");
    //Test 7, add Method (1)
    int[][] e1 = new int[][]{{3, 3, 3},
      {3, 3, 3},
      {3, 3, 3}};
    mats2 = new MathMatrix(data4);
    mats3 = mats1.add(mats2);
    printTestResult(get2DArray(mats3), e1, 7, "add Method");
    //Test 8, scale Method (1)
    e1 = new int[][]{{5187, 5187, 5187},
      {5187, 5187, 5187},
      {5187, 5187, 5187}};
    mats3.scale(1729);
    printTestResult(get2DArray(mats3), e1, 8, "scale Method");
    //Test 9, changeElement Method (1)
    mats3.changeElement(1, 1, 3);
    e1 = new int[][]{{5187, 5187, 5187},
      {5187, 3, 5187},
      {5187, 5187, 5187}};
    printTestResult(get2DArray(mats3), e1, 9, "changeElement Method");
    //Test 10, equals Method (1)
    mats4 = new MathMatrix(e1);
    if(mats4.equals(mats3)){
      System.out.println("Passed test 10, equals Method.");}
    else{
      System.out.println("Failed test 10, equals Method.");}
    //Test 11, multiply Method (1)
    mats2 = new MathMatrix(mats3.numCols(), 2, 0);
    e1 = new int[][]{{0, 0},
      {0, 0},
      {0, 0}};
    mats1 = mats3.multiply(mats2);
    printTestResult(get2DArray(mats1), e1, 11, "multiply Method");
    //Test 12, subtract Method (1)
    data3 = new int[][]{{7, 23},
      {2, -9},
      {54, 17}};
    mats3 = new MathMatrix(data3);
    mats2 = mats1.subtract(mats3);
    e1 = new int[][]{{-7, -23},
      {-2, 9},
      {-54, -17}};
    printTestResult(get2DArray(mats2), e1, 12, "subtract Method");
    
    //Block 3 of Tests
    data3 = new int[][]{{1111111, 2222222, 3333333, 4444444, 5555555, 6666666, 7777777, 8888888, 9999999},
      {2222222, 3333333, 4444444, 5555555, 6666666, 7777777, 8888888, 9999999,       0},
      {3333333, 4444444, 5555555, 6666666, 7777777, 8888888, 9999999,       0,       0},
      {4444444, 5555555, 6666666, 7777777, 8888888, 9999999,       0,       0,       0},
      {5555555, 6666666, 7777777, 8888888, 9999999,       0,       0,       0,       0},
      {6666666, 7777777, 8888888, 9999999,       0,       0,       0,       0,       0},
      {7777777, 8888888, 9999999,       0,       0,       0,       0,       0,       0},
      {8888888, 9999999,       0,       0,       0,       0,       0,       0,       0},
      {9999999,       0,       0,       0,       0,       0,       0,       0,       0}};
    //Test 13, numRows Method (2)
    mats1 = new MathMatrix(data3);
    if(mats1.numRows() == 9){
      System.out.println("Passed test 13, numRows Method.");}
    else{
      System.out.println("Failed test 13, numRows Method.");}
    //Test 14, numCols Method (3)
    if(mats1.numCols() == 9){
      System.out.println("Passed test 14, numCols Method");}
    else{
      System.out.println("Failed test 14, numCols Method.");}
    //Test 15, toString length (2)
    if(mats1.toString().length() ==  predictStringLength(7, data3)){
      System.out.println("Passed test 15, length of toString result.");}
    else{
      System.out.println("Failed test 15, length of toString result.");}
    //Test 16, scale Method (2)
    e1 = new int[][]{{-1111111, -2222222, -3333333, -4444444, -5555555, -6666666, -7777777, -8888888, -9999999},
      {-2222222, -3333333, -4444444, -5555555, -6666666, -7777777, -8888888, -9999999,        0},
      {-3333333, -4444444, -5555555, -6666666, -7777777, -8888888, -9999999,        0,        0},
      {-4444444, -5555555, -6666666, -7777777, -8888888, -9999999,        0,        0,        0},
      {-5555555, -6666666, -7777777, -8888888, -9999999,        0,        0,        0,        0},
      {-6666666, -7777777, -8888888, -9999999,        0,        0,        0,        0,        0},
      {-7777777, -8888888, -9999999,        0,        0,        0,        0,        0,        0},
      {-8888888, -9999999,        0,        0,        0,        0,        0,        0,        0},
      {-9999999,        0,        0,        0,        0,        0,        0,        0,        0}};
    mats1.scale(-1);
    printTestResult(get2DArray(mats1), e1, 16, "scale Method");
    //Test 17, upperTriangular Method (3)
    if(!mats1.isUpperTriangular()){
      System.out.println("Passed test 17, upperTriangular Method.");}
    else{
      System.out.println("Failed test 17, upperTriangular Method.");}
    //Test 18, upperTriangular (4) and getTranspose (2) Method
    mats2 = mats1.getTranspose(); 
    if(!mats2.isUpperTriangular()){
      System.out.println("Passed test 18, upperTriangular and getTranspose method.");}
    else{
      System.out.println("Failed test 18, upperTriangular and getTranspose method.");}
    //Test 19, equals Method (2)
    if(mats2.equals(mats1)){
      System.out.println("Passed test 19, equals Method.");}
    else{
      System.out.println("Failed test 19, equals Method.");}
    //Test 20, add Method (2)
    data4 = new int[9][9];
    for(int r = 0 ; r < data4.length; r++){
      for(int c = 0; c < data4[0].length; c++){
        data4[r][c] = 9999999;
      }
    }
    int[][] e2 = new int[][]{{8888888, 7777777, 6666666, 5555555, 4444444, 3333333, 2222222, 1111111,       0},
      {7777777, 6666666, 5555555, 4444444, 3333333, 2222222, 1111111,       0, 9999999},
      {6666666, 5555555, 4444444, 3333333, 2222222, 1111111,       0, 9999999, 9999999},
      {5555555, 4444444, 3333333, 2222222, 1111111,       0, 9999999, 9999999, 9999999},
      {4444444, 3333333, 2222222, 1111111,       0, 9999999, 9999999, 9999999, 9999999},
      {3333333, 2222222, 1111111,       0, 9999999, 9999999, 9999999, 9999999, 9999999},
      {2222222, 1111111,       0, 9999999, 9999999, 9999999, 9999999, 9999999, 9999999},
      {1111111,       0, 9999999, 9999999, 9999999, 9999999, 9999999, 9999999, 9999999},
      {      0, 9999999, 9999999, 9999999, 9999999, 9999999, 9999999, 9999999, 9999999}};
    mats2 = new MathMatrix(data4);
    mats3 = mats1.add(mats2);
    printTestResult(get2DArray(mats3), e2, 20, "add Method");
    //Test 21, subtract Method (2)
    mats1 = mats3.subtract(mats2);
    printTestResult(get2DArray(mats1), e1, 21, "subtract Method");
    //Test 22, getVal Method (2)
    if(mats1.getVal(8, 8) ==  0)
      System.out.println("Passed test 22, getVal Method");
    else
      System.out.println("Failed test 22, getVal Method");
    //Test 23, changeElement method (2)
    mats1.changeElement(8, 8, 7);
    e1 = new int[][]{{-1111111, -2222222, -3333333, -4444444, -5555555, -6666666, -7777777, -8888888, -9999999},
      {-2222222, -3333333, -4444444, -5555555, -6666666, -7777777, -8888888, -9999999,        0},
      {-3333333, -4444444, -5555555, -6666666, -7777777, -8888888, -9999999,        0,        0},
      {-4444444, -5555555, -6666666, -7777777, -8888888, -9999999,        0,        0,        0},
      {-5555555, -6666666, -7777777, -8888888, -9999999,        0,        0,        0,        0},
      {-6666666, -7777777, -8888888, -9999999,        0,        0,        0,        0,        0},
      {-7777777, -8888888, -9999999,        0,        0,        0,        0,        0,        0},
      {-8888888, -9999999,        0,        0,        0,        0,        0,        0,        0},
      {-9999999,        0,        0,        0,        0,        0,        0,        0,        7}};
    printTestResult(get2DArray(mats1), e1, 23, "changeElement Method");
    //Test 24, multiply Method (2)
    mats2 = new MathMatrix(new int[9][20]);
    mats3 = mats1.multiply(mats2);
    printTestResult(get2DArray(mats3), new int[9][20], 24, "multiply Method");
    
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
  
  /**
   * Calculate the size of what the output of your toString
   * @param largestNumDigits Max number of digits found in a number of the 2D array
   * @param row number of rows of the 2D array
   * @param col number of columns in the 2D array
   */
  private static int predictStringLength(int largestNumDigits, int row, int col){
    int spacing = largestNumDigits+1;
    int stringLength = (spacing * col + 2 + "\n".length())*row;
    return stringLength;
  }
  
  /**
   * Calculate the size of what the output of your toString
   * @param largestNumDigits Max number of digits found in a number of the 2D array
   * @param data 2D array that is being output to the console
   */
  private static int predictStringLength(int largestNumDigits, int[][] data){
    return predictStringLength(largestNumDigits, data.length, data[0].length);
  }
  
}

