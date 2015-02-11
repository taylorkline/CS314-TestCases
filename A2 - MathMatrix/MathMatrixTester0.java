import java.util.Random;
/**
 * A class to run tests on the MathMatrix class
 * @author Mike Scott
 */
public class MathMatrixTester0{
    /**
     * main method that runs simple test on the MathMatrix class
     *
     * @param args not used
     */
    public static void main(String[] args) {
       int[][] data1 = { {1, 2, 3},
                       {2, 3, 4}};
        int[][] data2 = { {2, 1, 1},
                       {2, 3, 1}};
        int[][] e1;

        //test 1, specify size and values constructor
        MathMatrix mat1 = new MathMatrix(2, 3, -1);
        e1 = new int[][] {{-1, -1, -1}, {-1, -1, -1}};
        printTestResult( get2DArray(mat1), e1, 1, "Constructor with size and initial val specified.");

        //tests 2 and 3, int[][] constructor, deep copy
        mat1 = new MathMatrix( data1 );
        data1[0][0] = 2;
        // alter data1. mat1 should be unchanged if deep copy made
        e1 = new int[][] { {2, 2, 3}, {2, 3, 4} };
        printTestResult( data1, e1, 2, "constructor with one parameter of type int[][]");
        // data1 altered. mat1 should be unchanged if deep copy made
        e1 = new int[][] { {1, 2, 3}, {2, 3, 4} };
        printTestResult( get2DArray(mat1), e1, 3, "constructor with one parameter of type int[][]. Testing deep copy made.");

        //tests 4 - 6, addition
        data1[0][0] = 1;
        mat1 = new MathMatrix(data1);
        MathMatrix mat2 = new MathMatrix(data2);
        MathMatrix mat3 = mat1.add(mat2);
        e1 = new int[][] { {1, 2, 3}, {2, 3, 4} };
        printTestResult( get2DArray(mat1), e1, 4, "add method. Testing mat1 unchanged.");
        e1 = new int[][] { {2, 1, 1}, {2, 3, 1} };
        printTestResult( get2DArray(mat2), e1, 5, "add method. Testing mat2 unchanged.");
        e1 = new int[][] { {3, 3, 4}, {4, 6, 5} };
        printTestResult( get2DArray(mat3), e1, 6, "add method. Testing mat3 correct result.");

        //test 7, multiplication
        data2 = new int[][] { {1, 2}, {3, 1}, {2, 1} };
        mat2 = new MathMatrix(data2);
        mat1 = new MathMatrix(data1);
        mat3 = mat2.multiply(mat1);
        e1 = new int[][] { {5, 8, 11}, {5, 9, 13}, {4, 7, 10} };
        printTestResult( get2DArray(mat3), e1, 7, "multiply method");

        //test 8, toString()
        data1 = new int[][] {{10, 100, 101, -1000},
                          {1000, 10, 55, 4},
                          {1, -1, 4, 0}};
        mat1 = new MathMatrix(data1);
        String expected = "|    10   100   101 -1000|\n|  1000    10    55     4|\n|     1    -1     4     0|\n";
        if( mat1.toString().equals( expected ) )
            System.out.println("passed test 8, toString method.");
        else
            System.out.println("failed test 8, toString method.");
        
        //test 9, upperTriangular
        data1 = new int[][] {{1, 2, 3, 0}, {0, 3, 2, 3}, {0, 0, 4, -1}, {0, 0, 0, 12}};
        mat1 = new MathMatrix(data1);
        if( mat1.isUpperTriangular())
            System.out.println("Passed test 9, upperTriangular method.");
        else
            System.out.println("Failed test 9, upperTriangular method.");
        
        //test 10, upperTriangular
        data1 = new int[][] {{1, 2, 3, 0}, {0, 3, 2, 3}, {0, 0, 4, -1}, {1, 2, 3, 4}};
        mat1 = new MathMatrix(data1);
        if( !mat1.isUpperTriangular())
            System.out.println("Passed test 10, upperTriangular method.");
        else
            System.out.println("Failed test 10, upperTriangular method.");   
        
        // test 11 - 14, mutliply stress test (possible to get Answer by Accident)
        Random randNumGen = new Random(6201919);
        final int MAGIC_SUM = -1190513360;
        final int ROWS1 = 1000;
        final int COLS1 = 500;
        final int ROWS2 = 500;
        final int COLS2 = 750;
        final int LIMIT = 1000;
        mat1 = createMat(randNumGen, ROWS1, COLS1, LIMIT);
        mat2 = createMat(randNumGen, ROWS2, COLS2, LIMIT);
        mat3 = mat1.multiply(mat2);

        if(mat3.numRows() == ROWS1)
            System.out.println("Passed test 11, multiply stess test numRows.");
        else
            System.out.println("Failed test 11, multiply stess test numRows");
        
        if(mat3.numCols() == COLS2)
            System.out.println("Passed test 12, multiply stess test numCols.");
        else
            System.out.println("Failed test 12, multiply stess test numCols");
        
        if(sumVals(mat3) == MAGIC_SUM)
            System.out.println("Passed test 13, stress test, sum of values in result.");
        else
            System.out.println("Failed test 13, stress test, sum of values in result.");
        
        final int MAGIC_STRING_LENGTH = 6753000;
        if(mat3.toString().length() == MAGIC_STRING_LENGTH)
            System.out.println("Passed test 14, stress test, length of toString result.");
        else
            System.out.println("Failed test 14, stress test, length of toString result.");
        
        // CS314 Students. When ready delete the above tests 
        // and add your 24 tests here.
        

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
    
    // create a matrix with random values
    // pre: rows > 0, cols > 0, randNumGen != null
    private static MathMatrix createMat(Random randNumGen, int rows,
            int cols, final int LIMIT) {
        
        if(randNumGen == null)
            throw new IllegalArgumentException("randomNumGen variable may no be null");
        else if(rows <= 0 || cols <= 0)
            throw new IllegalArgumentException("rows and columns must be greater than 0. " +
              "rows: " + rows + ", cols: " + cols);
        
        int[][] temp = new int[rows][cols];
        final int SUB = LIMIT / 4;
        for(int r = 0; r < rows; r++)
            for(int c = 0; c < cols; c++)
                temp[r][c] = randNumGen.nextInt(LIMIT) - SUB;
        
        return new MathMatrix(temp);
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
                : "Violation of precondition: get2DArray";

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
