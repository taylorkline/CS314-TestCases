/**
 * A tester for a7 - recursion
 * @author Joshua Guenther
 */


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class RecursiveTester1{
    public static void main(String[] args) {
        Recursive r = new Recursive();
        studentTests(r);

    }
    
    // pre: r != null
    // post: run student test
    private static void studentTests(Recursive r) {
        // CS314 students put your tests here
    	studentBinaryConversionTester(r);
    	studentReverseStringTester(r);
    	studentNextIsDoubleTester(r);
    	studentListMnemonicTester(r);
    	studentSudokoSolutionTester(r);
    	studentCanFlowOffMapTester(r);
    	studentMinDifferenceTester(r);
    }


    private static void studentBinaryConversionTester(Recursive r){
    	String actualBinary = r.getBinary(0);
        String expectedBinary = "0";
        if( actualBinary.equals(expectedBinary) )
            System.out.println( "Test 1 passed. get binary.");
        else
            System.out.println( "Test 1 failed. get binary. expected: " + expectedBinary + ", actual: " + actualBinary);
        
        actualBinary = r.getBinary(16);
        expectedBinary = "10000";
        if( actualBinary.equals(expectedBinary) )
            System.out.println( "Test 2 passed. get binary.");
        else
            System.out.println( "Test 2 failed. get binary. expected: " + expectedBinary + ", actual: " + actualBinary);
        
        actualBinary = r.getBinary(203);
        expectedBinary = "11001011";
        if( actualBinary.equals(expectedBinary) )
            System.out.println( "Test 3 passed. get binary.");
        else
            System.out.println( "Test 3 failed. get binary. expected: " + expectedBinary + ", actual: " + actualBinary);
        
        actualBinary = r.getBinary(1000);
        expectedBinary = "1111101000";
        if( actualBinary.equals(expectedBinary) )
            System.out.println( "Test 4 passed. get binary.");
        else
            System.out.println( "Test 4 failed. get binary. expected: " + expectedBinary + ", actual: " + actualBinary);
        
        actualBinary = r.getBinary(1024);
        expectedBinary = "10000000000";
        if( actualBinary.equals(expectedBinary) )
            System.out.println( "Test 5 passed. get binary.");
        else
            System.out.println( "Test 5 failed. get binary. expected: " + expectedBinary + ", actual: " + actualBinary);
        
        /*
        //Perform tests on a wide range of positive integer values
        int passed = 0;
        int numTests = 100000000; //Integer.MAX_VALUE //Warn - can be slow due to string concatenations of larger numbers
        for(int i = 0; i < numTests; i++){
        	actualBinary = r.getBinary(i);
            expectedBinary = Integer.toBinaryString(i);
            
            if(actualBinary.equals(expectedBinary)){
            	passed++;
            }
            else{
                System.out.println( "Test "+i+" failed. get binary. Decimal integer: "+i+" expected Binary: " + expectedBinary + ", actual Binary: " + actualBinary);
            }
        }
        	System.out.println("Passed "+passed+"/"+numTests+" binary tests");
		*/
    }
    
    private static void studentReverseStringTester(Recursive r){
    	String actualRev = r.revString("");
        String expectedRev = "";
        if( actualRev.equals(expectedRev) )
            System.out.println( "Test 1 passed. reverse string.");
        else
            System.out.println( "Test 1 failed. reverse string. expected: " + expectedRev + ", actual: " + actualRev);
    	
    	actualRev = r.revString("suoicodilaipxe citsiligarf alac repus");
        expectedRev = "super cala fragilistic expialidocious";
        if( actualRev.equals(expectedRev) )
            System.out.println( "Test 2 passed. reverse string.");
        else
            System.out.println( "Test 2 failed. reverse string. expected: " + expectedRev + ", actual: " + actualRev);
        
        actualRev = r.revString("stressed");
        expectedRev = "desserts";
        if( actualRev.equals(expectedRev) )
            System.out.println( "Test 3 passed. reverse string.");
        else
            System.out.println( "Test 3 failed. reverse string. expected: " + expectedRev + ", actual: " + actualRev);
        
        actualRev = r.revString("rewarder");
        expectedRev = "redrawer";
        if( actualRev.equals(expectedRev) )
            System.out.println( "Test 4 passed. reverse string.");
        else
            System.out.println( "Test 4 failed. reverse string. expected: " + expectedRev + ", actual: " + actualRev);
        
        actualRev = r.revString("dioramas");
        expectedRev = "samaroid";
        if( actualRev.equals(expectedRev) )
            System.out.println( "Test 5 passed. reverse string.");
        else
            System.out.println( "Test 5 failed. reverse string. expected: " + expectedRev + ", actual: " + actualRev);
    }

    private static void studentNextIsDoubleTester(Recursive r){
    	//Piazza question @356 states that me must preserve the initial array
    	
    	int[] numsForDouble = {0, 0, 0, 0, 0, 1, 5, 10, 20, 40};
    	int[] copy = Arrays.copyOf(numsForDouble, numsForDouble.length);
        int actualDouble = r.nextIsDouble(numsForDouble);
        int expectedDouble = 7;
        if(actualDouble == expectedDouble)
            System.out.println( "Test 1 passed. next is double.");
        else
            System.out.println( "Test 1 failed. next is double. expected: " + expectedDouble + ", actual: " + actualDouble);
        if(!Arrays.equals(copy, numsForDouble)){
        	System.out.println("BAD: Test altered array!!!");
        }
        
        numsForDouble = new int[1];
    	copy = Arrays.copyOf(numsForDouble, numsForDouble.length);
        actualDouble = r.nextIsDouble(numsForDouble);
        expectedDouble = 0;
        if(actualDouble == expectedDouble)
            System.out.println( "Test 2 passed. next is double.");
        else
            System.out.println( "Test 2 failed. next is double. expected: " + expectedDouble + ", actual: " + actualDouble);
        if(!Arrays.equals(copy, numsForDouble)){
        	System.out.println("BAD: Test altered array!!!");
        }
        
        numsForDouble = new int[0];
    	copy = Arrays.copyOf(numsForDouble, numsForDouble.length);
        actualDouble = r.nextIsDouble(numsForDouble);
        expectedDouble = 0;
        if(actualDouble == expectedDouble)
            System.out.println( "Test 3 passed. next is double.");
        else
            System.out.println( "Test 3 failed. next is double. expected: " + expectedDouble + ", actual: " + actualDouble);
        if(!Arrays.equals(copy, numsForDouble)){
        	System.out.println("BAD: Test altered array!!!");
        }
        
        numsForDouble = new int[]{1, 5, 2, -1, -5, -1, 2, 5, 1};
    	copy = Arrays.copyOf(numsForDouble, numsForDouble.length);
        actualDouble = r.nextIsDouble(numsForDouble);
        expectedDouble = 0;
        if(actualDouble == expectedDouble)
            System.out.println( "Test 4 passed. next is double.");
        else
            System.out.println( "Test 4 failed. next is double. expected: " + expectedDouble + ", actual: " + actualDouble);
        if(!Arrays.equals(copy, numsForDouble)){
        	System.out.println("BAD: Test altered array!!!");
        }
        
        numsForDouble = new int[100];
        numsForDouble[0] = 25;
        for(int i = 1; i < numsForDouble.length; i++){
        	numsForDouble[i] = 2*numsForDouble[i-1];
        }
    	copy = Arrays.copyOf(numsForDouble, numsForDouble.length);
        actualDouble = r.nextIsDouble(numsForDouble);
        expectedDouble = 99;
        if(actualDouble == expectedDouble)
            System.out.println( "Test 5 passed. next is double.");
        else
            System.out.println( "Test 5 failed. next is double. expected: " + expectedDouble + ", actual: " + actualDouble);
        if(!Arrays.equals(copy, numsForDouble)){
        	System.out.println("BAD: Test altered array!!!");
        }
        
    }
    
    private static void studentListMnemonicTester(Recursive r){
    	ArrayList<String> mnemonics = r.listMnemonics("1");
        ArrayList<String> expected = new ArrayList<String>();
        expected.add("1");
        if( mnemonics.equals(expected))
            System.out.println( "Test 1 passed. Phone mnemonics.");
        else
            System.out.println( "Test 1 failed. Phone mnemonics.");
    
        mnemonics = r.listMnemonics("010");
        Collections.sort(mnemonics);
        expected.clear();
        expected.add("010");
        Collections.sort(expected);
        if( mnemonics.equals(expected))
            System.out.println( "Test 2 passed. Phone mnemonics.");
        else
            System.out.println( "Test 2 failed. Phone mnemonics.");
        
        mnemonics = r.listMnemonics("906");
        Collections.sort(mnemonics);
        expected.clear();
        expected.add("W0M");
        expected.add("W0N");
        expected.add("W0O");
        expected.add("X0M");
        expected.add("X0N");
        expected.add("X0O");
        expected.add("Y0M");
        expected.add("Y0N");
        expected.add("Y0O");
        expected.add("Z0M");
        expected.add("Z0N");
        expected.add("Z0O");
        Collections.sort(expected);
        if( mnemonics.equals(expected))
            System.out.println( "Test 3 passed. Phone mnemonics.");
        else
            System.out.println( "Test 3 failed. Phone mnemonics.");
 
        mnemonics = r.listMnemonics("123456");
        Collections.sort(mnemonics);
        expected.clear();
        /* Values generated with http://www.number2word.com/index.php?number=&omit= 
         * and formatted by a program I made that accepts its output
         */
        expected.add("1ADGJM");
        expected.add("1ADGJN");
        expected.add("1ADGJO");
        expected.add("1ADGKM");
        expected.add("1ADGKN");
        expected.add("1ADGKO");
        expected.add("1ADGLM");
        expected.add("1ADGLN");
        expected.add("1ADGLO");
        expected.add("1ADHJM");
        expected.add("1ADHJN");
        expected.add("1ADHJO");
        expected.add("1ADHKM");
        expected.add("1ADHKN");
        expected.add("1ADHKO");
        expected.add("1ADHLM");
        expected.add("1ADHLN");
        expected.add("1ADHLO");
        expected.add("1ADIJM");
        expected.add("1ADIJN");
        expected.add("1ADIJO");
        expected.add("1ADIKM");
        expected.add("1ADIKN");
        expected.add("1ADIKO");
        expected.add("1ADILM");
        expected.add("1ADILN");
        expected.add("1ADILO");
        expected.add("1AEGJM");
        expected.add("1AEGJN");
        expected.add("1AEGJO");
        expected.add("1AEGKM");
        expected.add("1AEGKN");
        expected.add("1AEGKO");
        expected.add("1AEGLM");
        expected.add("1AEGLN");
        expected.add("1AEGLO");
        expected.add("1AEHJM");
        expected.add("1AEHJN");
        expected.add("1AEHJO");
        expected.add("1AEHKM");
        expected.add("1AEHKN");
        expected.add("1AEHKO");
        expected.add("1AEHLM");
        expected.add("1AEHLN");
        expected.add("1AEHLO");
        expected.add("1AEIJM");
        expected.add("1AEIJN");
        expected.add("1AEIJO");
        expected.add("1AEIKM");
        expected.add("1AEIKN");
        expected.add("1AEIKO");
        expected.add("1AEILM");
        expected.add("1AEILN");
        expected.add("1AEILO");
        expected.add("1AFGJM");
        expected.add("1AFGJN");
        expected.add("1AFGJO");
        expected.add("1AFGKM");
        expected.add("1AFGKN");
        expected.add("1AFGKO");
        expected.add("1AFGLM");
        expected.add("1AFGLN");
        expected.add("1AFGLO");
        expected.add("1AFHJM");
        expected.add("1AFHJN");
        expected.add("1AFHJO");
        expected.add("1AFHKM");
        expected.add("1AFHKN");
        expected.add("1AFHKO");
        expected.add("1AFHLM");
        expected.add("1AFHLN");
        expected.add("1AFHLO");
        expected.add("1AFIJM");
        expected.add("1AFIJN");
        expected.add("1AFIJO");
        expected.add("1AFIKM");
        expected.add("1AFIKN");
        expected.add("1AFIKO");
        expected.add("1AFILM");
        expected.add("1AFILN");
        expected.add("1AFILO");
        expected.add("1BDGJM");
        expected.add("1BDGJN");
        expected.add("1BDGJO");
        expected.add("1BDGKM");
        expected.add("1BDGKN");
        expected.add("1BDGKO");
        expected.add("1BDGLM");
        expected.add("1BDGLN");
        expected.add("1BDGLO");
        expected.add("1BDHJM");
        expected.add("1BDHJN");
        expected.add("1BDHJO");
        expected.add("1BDHKM");
        expected.add("1BDHKN");
        expected.add("1BDHKO");
        expected.add("1BDHLM");
        expected.add("1BDHLN");
        expected.add("1BDHLO");
        expected.add("1BDIJM");
        expected.add("1BDIJN");
        expected.add("1BDIJO");
        expected.add("1BDIKM");
        expected.add("1BDIKN");
        expected.add("1BDIKO");
        expected.add("1BDILM");
        expected.add("1BDILN");
        expected.add("1BDILO");
        expected.add("1BEGJM");
        expected.add("1BEGJN");
        expected.add("1BEGJO");
        expected.add("1BEGKM");
        expected.add("1BEGKN");
        expected.add("1BEGKO");
        expected.add("1BEGLM");
        expected.add("1BEGLN");
        expected.add("1BEGLO");
        expected.add("1BEHJM");
        expected.add("1BEHJN");
        expected.add("1BEHJO");
        expected.add("1BEHKM");
        expected.add("1BEHKN");
        expected.add("1BEHKO");
        expected.add("1BEHLM");
        expected.add("1BEHLN");
        expected.add("1BEHLO");
        expected.add("1BEIJM");
        expected.add("1BEIJN");
        expected.add("1BEIJO");
        expected.add("1BEIKM");
        expected.add("1BEIKN");
        expected.add("1BEIKO");
        expected.add("1BEILM");
        expected.add("1BEILN");
        expected.add("1BEILO");
        expected.add("1BFGJM");
        expected.add("1BFGJN");
        expected.add("1BFGJO");
        expected.add("1BFGKM");
        expected.add("1BFGKN");
        expected.add("1BFGKO");
        expected.add("1BFGLM");
        expected.add("1BFGLN");
        expected.add("1BFGLO");
        expected.add("1BFHJM");
        expected.add("1BFHJN");
        expected.add("1BFHJO");
        expected.add("1BFHKM");
        expected.add("1BFHKN");
        expected.add("1BFHKO");
        expected.add("1BFHLM");
        expected.add("1BFHLN");
        expected.add("1BFHLO");
        expected.add("1BFIJM");
        expected.add("1BFIJN");
        expected.add("1BFIJO");
        expected.add("1BFIKM");
        expected.add("1BFIKN");
        expected.add("1BFIKO");
        expected.add("1BFILM");
        expected.add("1BFILN");
        expected.add("1BFILO");
        expected.add("1CDGJM");
        expected.add("1CDGJN");
        expected.add("1CDGJO");
        expected.add("1CDGKM");
        expected.add("1CDGKN");
        expected.add("1CDGKO");
        expected.add("1CDGLM");
        expected.add("1CDGLN");
        expected.add("1CDGLO");
        expected.add("1CDHJM");
        expected.add("1CDHJN");
        expected.add("1CDHJO");
        expected.add("1CDHKM");
        expected.add("1CDHKN");
        expected.add("1CDHKO");
        expected.add("1CDHLM");
        expected.add("1CDHLN");
        expected.add("1CDHLO");
        expected.add("1CDIJM");
        expected.add("1CDIJN");
        expected.add("1CDIJO");
        expected.add("1CDIKM");
        expected.add("1CDIKN");
        expected.add("1CDIKO");
        expected.add("1CDILM");
        expected.add("1CDILN");
        expected.add("1CDILO");
        expected.add("1CEGJM");
        expected.add("1CEGJN");
        expected.add("1CEGJO");
        expected.add("1CEGKM");
        expected.add("1CEGKN");
        expected.add("1CEGKO");
        expected.add("1CEGLM");
        expected.add("1CEGLN");
        expected.add("1CEGLO");
        expected.add("1CEHJM");
        expected.add("1CEHJN");
        expected.add("1CEHJO");
        expected.add("1CEHKM");
        expected.add("1CEHKN");
        expected.add("1CEHKO");
        expected.add("1CEHLM");
        expected.add("1CEHLN");
        expected.add("1CEHLO");
        expected.add("1CEIJM");
        expected.add("1CEIJN");
        expected.add("1CEIJO");
        expected.add("1CEIKM");
        expected.add("1CEIKN");
        expected.add("1CEIKO");
        expected.add("1CEILM");
        expected.add("1CEILN");
        expected.add("1CEILO");
        expected.add("1CFGJM");
        expected.add("1CFGJN");
        expected.add("1CFGJO");
        expected.add("1CFGKM");
        expected.add("1CFGKN");
        expected.add("1CFGKO");
        expected.add("1CFGLM");
        expected.add("1CFGLN");
        expected.add("1CFGLO");
        expected.add("1CFHJM");
        expected.add("1CFHJN");
        expected.add("1CFHJO");
        expected.add("1CFHKM");
        expected.add("1CFHKN");
        expected.add("1CFHKO");
        expected.add("1CFHLM");
        expected.add("1CFHLN");
        expected.add("1CFHLO");
        expected.add("1CFIJM");
        expected.add("1CFIJN");
        expected.add("1CFIJO");
        expected.add("1CFIKM");
        expected.add("1CFIKN");
        expected.add("1CFIKO");
        expected.add("1CFILM");
        expected.add("1CFILN");
        expected.add("1CFILO");
        Collections.sort(expected);
        if( mnemonics.equals(expected))
            System.out.println( "Test 4 passed. Phone mnemonics.");
        else
            System.out.println( "Test 4 failed. Phone mnemonics.");
        
    }
    
    private static void studentSudokoSolutionTester(Recursive r){
    	
    	String puzzle = "800000000003600000070090200050007000000045700000100030001000068008500010090000400";
        int[][] board = stringToBoard(puzzle);
        int[][] result = r.getSudokoSolution(board);
        String actualBoard = boardToString(result);
        String expectedBoard = "812753649943682175675491283154237896369845721287169534521974368438526917796318452";
        if(actualBoard.equals(expectedBoard))
            System.out.println( "Test 1 passed. sudoko solver.");
        else {
            System.out.println("Test 1 failed. sudoku solver:");
            System.out.println("Expected board:");
            printBoard(stringToBoard(expectedBoard));
            System.out.println();
            System.out.println("Actual board:");
            printBoard(result);
        }
        
        puzzle = "100007090030020008009600500005300900010080002600004000300000010041000007007000300";
        board = stringToBoard(puzzle);
        result = r.getSudokoSolution(board);
        actualBoard = boardToString(result);
        expectedBoard = "162857493534129678789643521475312986913586742628794135356478219241935867897261354";
        if(actualBoard.equals(expectedBoard))
            System.out.println( "Test 2 passed. sudoko solver.");
        else {
            System.out.println("Test 2 failed. sudoku solver:");
            System.out.println("Expected board:");
            printBoard(stringToBoard(expectedBoard));
            System.out.println();
            System.out.println("Actual board:");
            printBoard(result);
        }
        puzzle = "002800000030060007100000040600090000050600009000057060000300100070006008400000020";
        board = stringToBoard(puzzle);
        result = r.getSudokoSolution(board);
        actualBoard = boardToString(result);
        expectedBoard = "742835691539461287186972543618293754257684319394157862825349176971526438463718925";
        if(actualBoard.equals(expectedBoard))
            System.out.println( "Test 3 passed. sudoko solver.");
        else {
            System.out.println("Test 3 failed. sudoku solver:");
            System.out.println("Expected board:");
            printBoard(stringToBoard(expectedBoard));
            System.out.println();
            System.out.println("Actual board:");
            printBoard(result);
        }
        
    }
    
    private static void studentCanFlowOffMapTester(Recursive r){
    	int[][] world = {{5,5,5,5},
                		 {0,1,2,5},
                		 {5,5,3,5},
                		 {5,4,5,5}};

        if( r.canFlowOffMap(world, 1, 3))
            System.out.println( "Test 1 passed. can flow off map.");
        else
            System.out.println( "Test 1 failed. can flow off map.");
        
        if(r.canFlowOffMap(world, 3, 3))
            System.out.println( "Test 2 passed. can flow off map.");
        else
            System.out.println( "Test 2 failed. can flow off map.");
        
         world = new int[][]{{100, 100, 100, 100, 100, 100, 100},
        		 		     {100,  99,  98,  97,  96,  95, 100},
        		 		     {100,  88,  89,  90,  91,  92, 100},
        		 		     {100, 100, 100,  85,  84,  83, 100},
        		 		     {100,  78,  79,  80,  81,  82, 100},
        		 		     {100,  77,  76,  75,  74,  73,   0},
        		 		     {100, 100, 100, 100, 100, 100, 100},};

         if(r.canFlowOffMap(world, 1, 1))
             System.out.println( "Test 3 passed. can flow off map.");
         else
             System.out.println( "Test 3 failed. can flow off map.");
         
         if(!r.canFlowOffMap(world, 2, 1))
             System.out.println( "Test 4 passed. can't flow off map.");
         else
             System.out.println( "Test 4 failed. can't flow off map.");
    }
    
    private static void studentMinDifferenceTester(Recursive r){
    	int[] abilities = {1, 2, 3, 4};
        if(r.minDifference(2, abilities) == 0) //1+4 and 3+2
            System.out.println( "Test 1 passed. min difference.");
        else
            System.out.println( "Test 1 failed. min difference.");
        if(r.minDifference(4, abilities) == 3) //4, 3, 2, and 1
            System.out.println( "Test 2 passed. min difference.");
        else
            System.out.println( "Test 2 failed. min difference.");
        
        abilities = new int[]{-5, -1, 0, 1, 5};
        if(r.minDifference(2, abilities) == 0) //5-5+0 and 1-1
            System.out.println( "Test 3 passed. min difference.");
        else
            System.out.println( "Test 3 failed. min difference.");
        if(r.minDifference(3, abilities) == 0) //5-5, 1-1, 0
            System.out.println( "Test 4 passed. min difference.");
        else
            System.out.println( "Test 4 failed. min difference.");
        
        abilities = new int[]{-15, -8, 1, 10 ,15, 20};
        if(r.minDifference(2, abilities) == 1) //20-15-8+15 and 10+1
            System.out.println( "Test 5 passed. min difference.");
        else
            System.out.println( "Test 5 failed. min difference.");
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