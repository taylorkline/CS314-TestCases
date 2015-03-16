/**
 * A tester for a7 - recursion
 * @author Mike Scott
 * Note: I have organized the tests by the method they are testing
 * so that you can run tests on a single method if you want.
 */


import java.util.ArrayList;
import java.util.Collections;

public class RecursiveTester0{
    public static void main(String[] args) {
        Recursive r = new Recursive();
        binaryConversionTester(r);
        reverseStringTester(r);
        nextIsDoubleTester(r);
        listMnemonicTester(r);
        canFlowOffMapTester(r);
        minDifferenceTester(r);
        sudokoSolutionTester(r);

        //try the Sierpinski triangle, uncomment when ready
        //r.drawTriangles(400, 100, 360);
        //
        //try the Sierpinski Carpet, uncomment when ready
        //r.drawCarpet(729, 4);

        //also try this
        //r.drawCarpet(729, 1);

        studentTests(r);

    }

 
    private static void binaryConversionTester(Recursive r){
    	String actualBinary = r.getBinary(13);
        String expectedBinary = "1101";
        if( actualBinary.equals(expectedBinary) )
            System.out.println( "Test 1 passed. get binary.");
        else
            System.out.println( "Test 1 failed. get binary. expected: " + expectedBinary + ", actual: " + actualBinary);


        actualBinary = r.getBinary(0);
        expectedBinary = "0";
        if( actualBinary.equals(expectedBinary) )
            System.out.println( "Test 1.1 passed. get binary.");
        else
            System.out.println( "Test 1.1 failed. get binary. expected: " + expectedBinary + ", actual: " + actualBinary);

        actualBinary = r.getBinary(1);
        expectedBinary = "1";
        if( actualBinary.equals(expectedBinary) )
            System.out.println( "Test 1.2 passed. get binary.");
        else
            System.out.println( "Test 1.2 failed. get binary. expected: " + expectedBinary + ", actual: " + actualBinary);


        actualBinary = r.getBinary(64);
        expectedBinary = "1000000";
        if( actualBinary.equals(expectedBinary) )
            System.out.println( "Test 2 passed. get binary");
        else
            System.out.println( "Test 2 failed. get binary. expected: " + expectedBinary + ", actual: " + actualBinary);
    }
    
    
    private static void reverseStringTester(Recursive r){
    	String actualRev = r.revString("target");
        String expectedRev = "tegrat";
        if( actualRev.equals(expectedRev) )
            System.out.println( "Test 3 passed. reverse string.");
        else
            System.out.println( "Test 3 failed. reverse string. expected: " + expectedRev + ", actual: " + actualRev);


        actualRev = r.revString("Calvin and Hobbes");
        expectedRev = "sebboH dna nivlaC";
        if( actualRev.equals(expectedRev) )
            System.out.println( "Test 4 passed. reverse string.");
        else
            System.out.println( "Test 4 failed. reverse string. expected: " + expectedRev + ", actual: " + actualRev);
    }
    
    private static void nextIsDoubleTester(Recursive r){
    	int[] numsForDouble = {1, 2, 4, 8, 16, 32, 64, 128, 256};
        int actualDouble = r.nextIsDouble(numsForDouble);
        int expectedDouble = 8;
        if(actualDouble == expectedDouble)
            System.out.println( "Test 5 passed. next is double.");
        else
            System.out.println( "Test 5 failed. next is double. expected: " + expectedDouble + ", actual: " + actualDouble);


        numsForDouble = new int[]{1, 3, 4, 2, 32, 8, 128, -5, 6};
        actualDouble = r.nextIsDouble(numsForDouble);
        expectedDouble = 0;
        if(actualDouble == expectedDouble)
            System.out.println( "Test 6 passed. next is double.");
        else
            System.out.println( "Test 6 failed. next is double. expected: " + expectedDouble + ", actual: " + actualDouble);


        numsForDouble = new int[]{1, 0, 0, -5, -10, 32, 64, 128, 2, 9, 18};
        actualDouble = r.nextIsDouble(numsForDouble);
        expectedDouble = 5;
        if(actualDouble == expectedDouble)
            System.out.println( "Test 7 passed. next is double.");
        else
            System.out.println( "Test 7 failed. next is double. expected: " + expectedDouble + ", actual: " + actualDouble);	
    }
    
    private static void listMnemonicTester(Recursive r){
    	 ArrayList<String> mnemonics = r.listMnemonics("1");
         ArrayList<String> expected = new ArrayList<String>();
         expected.add("1");
         if( mnemonics.equals(expected))
             System.out.println( "Test 8 passed. Phone mnemonics.");
         else
             System.out.println( "Test 8 failed. Phone mnemonics.");

         mnemonics = r.listMnemonics("22");
         Collections.sort(mnemonics);
         expected.clear();
         expected.add("AA");
         expected.add("AB");
         expected.add("AC");
         expected.add("BA");
         expected.add("BB");
         expected.add("BC");
         expected.add("CA");
         expected.add("CB");
         expected.add("CC");
         Collections.sort(expected);
         if( mnemonics.equals(expected))
             System.out.println( "Test 9 passed. Phone mnemonics.");
         else
             System.out.println( "Test 9 failed. Phone mnemonics.");

         mnemonics = r.listMnemonics("110010");
         expected.clear();
         expected.add("110010");
         if( mnemonics.equals(expected))
             System.out.println( "Test 10 passed. Phone mnemonics.");
         else
             System.out.println( "Test 10 failed. Phone mnemonics.");

    }
    
    private static void canFlowOffMapTester(Recursive r){
    	int[][] world = {{5,5,5,5,5,5},
                {5,5,5,5,5,5},
                {5,5,5,5,5,5},
                {5,5,4,4,5,5},
                {5,5,3,3,5,5},
                {5,5,2,2,5,5},
                {5,5,5,1,5,5},
                {5,5,5,-2,5,5}};

        if( r.canFlowOffMap(world,0,0))
            System.out.println( "Test 11 passed. can flow off map.");
        else
            System.out.println( "Test 11 failed. can flow off map.");

        if( !r.canFlowOffMap(world,1,1))
            System.out.println( "Test 12 passed. can flow off map.");
        else
            System.out.println( "Test 12 failed. can flow off map.");

        if( r.canFlowOffMap(world,3,3))
            System.out.println( "Test 13 passed. can flow off map.");
        else
            System.out.println( "Test 13 failed. can flow off map.");

        if( r.canFlowOffMap(world,1,5))
            System.out.println( "Test 14 passed. can flow off map.");
        else
            System.out.println( "Test 14 failed. can flow off map.");

        world = new int[][]
                          {{10, 10, 10, 10, 10, 10, 10},
                {10, 10, 10,  5, 10, 10, 10},
                {10, 10, 10,  6, 10, 10, 10},
                {10, 10, 10,  7, 10, 10, 10},
                {5,   6,  7,  8,  7,  6, 10},
                {10, 10, 10,  7, 10, 10, 10},
                {10, 10, 10,  6, 10, 10, 10},
                {10, 10, 10,  5, 10, 10, 10},
                {10, 10, 10, 10, 10, 10, 10},
                          };

        if( !r.canFlowOffMap(world,3,3))
            System.out.println( "Test 15 passed. can flow off map.");
        else
            System.out.println( "Test 15 failed. can flow off map.");

        if( r.canFlowOffMap(world,4,3))
            System.out.println( "Test 16 passed. can flow off map.");
        else
            System.out.println( "Test 16 failed. can flow off map.");
    }
    
    private static void minDifferenceTester(Recursive r){
    	int[] abilities = {1, 2, 3, 4, 5, 6, 7};
        if(r.minDifference(3, abilities) == 1)
            System.out.println( "Test 17 passed. min difference.");
        else
            System.out.println( "Test 17 failed. min difference.");

        if(r.minDifference(5, abilities) == 2)
            System.out.println( "Test 18 passed. min difference.");
        else
            System.out.println( "Test 18 failed. min difference.");

        if(r.minDifference(6, abilities) == 4)
            System.out.println( "Test 19 passed. min difference.");
        else
            System.out.println( "Test 19 failed. min difference.");

        abilities = new int[]{1, 12, 46, 60, 53, 86, 72, 79, 44, 7};
        if(r.minDifference(3, abilities) == 3)
            System.out.println( "Test 20 passed. min difference.");
        else
            System.out.println( "Test 20 failed. min difference.");

        if(r.minDifference(5, abilities) == 19)
            System.out.println( "Test 20 passed. min difference.");
        else
            System.out.println( "Test 20 failed. min difference.");


        abilities = new int[]{10, 10, 6, 6, 6};
        if(r.minDifference(2, abilities) == 2)
            System.out.println( "Test 21 passed. min difference.");
        else
            System.out.println( "Test 21 failed. min difference.");
    }
    
    private static void sudokoSolutionTester(Recursive r){
    	String puzzle1 = "530070000600195000098000060800060003400803001700020006060000280000419005000080079";
        int[][] board = stringToBoard(puzzle1);
        int[][] result = r.getSudokoSolution(board);
        String actualBoard = boardToString(result);
        String expectedBoard = "534678912672195348198342567859761423426853791713924856961537284287419635345286179";
        if(actualBoard.equals(expectedBoard))
            System.out.println( "Test 22 passed. sudoko solver.");
        else {
            System.out.println("Test 22 failed. sudoku solver:");
            System.out.println("Expected board:");
            printBoard(stringToBoard(expectedBoard));
            System.out.println();
            System.out.println("Actual board:");
            printBoard(result);
        }


        String puzzle2 = "370002060000000050008073900147000000009301200000000891005120600010000000080600043";
        board = stringToBoard(puzzle2);
        result = r.getSudokoSolution(board);
        actualBoard = boardToString(result);
        expectedBoard = "371592468294816357568473912147289536859361274623745891735124689416938725982657143";
        if(actualBoard.equals(expectedBoard))
            System.out.println( "Test 23 passed. sudoko solver.");
        else {
            System.out.println("Test 23 failed. sudoku solver:");
            System.out.println("Expected board:");
            printBoard(stringToBoard(expectedBoard));
            System.out.println();
            System.out.println("Actual board:");
            printBoard(result);
        }


        String puzzle3 = "000010300008003500500002001003000007106070403400000200200300004004900600007080000";
        assert puzzle3.length() == 81;
        board = stringToBoard(puzzle3);
        result = r.getSudokoSolution(board);
        actualBoard = boardToString(result);
        expectedBoard = "642715389718493526539862741823546917196278453475139268261357894384921675957684132";
        if(actualBoard.equals(expectedBoard))
            System.out.println( "Test 24 passed. sudoko solver.");
        else {
            System.out.println("Test 24 failed. sudoku solver:");
            System.out.println("Expected board:");
            printBoard(stringToBoard(expectedBoard));
            System.out.println();
            System.out.println("Actual board:");
            printBoard(result);
        }


        String puzzle4 = "080700500700008021000002009800100206690824015105009008500400000430200007009007080";
        assert puzzle4.length() == 81;
        board = stringToBoard(puzzle4);
        result = r.getSudokoSolution(board);
        actualBoard = boardToString(result);
        expectedBoard = "982716534754938621361542879843175296697824315125369748578493162436281957219657483";
        if(actualBoard.equals(expectedBoard))
            System.out.println( "Test 25 passed. sudoko solver.");
        else {
            System.out.println("Test 25 failed. sudoku solver:");
            System.out.println("Expected board:");
            printBoard(stringToBoard(expectedBoard));
            System.out.println();
            System.out.println("Actual board:");
            printBoard(result);
        }


        String puzzle5 = "000050400080102350400307086050000670100809002038000040590203004047906020003070000";
        assert puzzle5.length() == 81;
        board = stringToBoard(puzzle5);
        result = r.getSudokoSolution(board);
        actualBoard = boardToString(result);
        expectedBoard = "000050400080102350400307086050000670100809002038000040590203004047906020003070000";
        if(actualBoard.equals(expectedBoard))
            System.out.println( "Test 26 passed. sudoko solver.");
        else {
            System.out.println("Test 26 failed. sudoku solver:");
            System.out.println("Expected board:");
            printBoard(stringToBoard(expectedBoard));
            System.out.println();
            System.out.println("Actual board:");
            printBoard(result);
        }
    }
    
    
    
    // pre: r != null
    // post: run student test
    private static void studentTests(Recursive r) {
        // CS314 students put your tests here

    }

    private static String boardToString(int[][] board) {
        StringBuilder result = new StringBuilder(81);
        for(int r = 0; r < board.length; r++)
            for(int c = 0; c < board[r].length; c++)
                result.append(board[r][c]);
        return result.toString();
    }

    private static int[][] stringToBoard(String puzzle) {
        int[][] result = new int[Recursive.BOARD_SIZE][Recursive.BOARD_SIZE];
        int index = 0;
        for(int r = 0; r < result.length; r++)
            for(int c = 0; c < result.length; c++, index++)
                result[r][c] = puzzle.charAt(index) - '0';
        return result;
    }

    private static void printBoard(int[][] board) {
        for(int r = 0; r < board.length; r++) {
            for(int c = 0; c < board[r].length; c++) {
                System.out.print(board[r][c]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}