/**
 * A tester for a7-Recursive
 * @author Taylor Kline
 */

import java.util.ArrayList;
import java.util.Collections;

public class RecursiveTester3 {
   private static final String FAILED_TEST = "******FAILED******";
   private static final String PASSED_TEST = "passed";
   private static final String DIVIDER = " | ";
   private static final String TEST_FORMATTING = "%-5s%-2d%-3s%-62s%-3s%-10s";

   public static void main(String[] args) {
      System.out.println("Hello!\n");

      runTests();
   }

   private static void runTests() {
      boolean expectedBool;
      boolean actualBool;
      int expectedInt;
      int actualInt;
      String actualString;
      String expectedString;
      ArrayList<String> expectedStringArray = new ArrayList<>();
      ArrayList<String> actualStringArray = new ArrayList<>();
      Recursive r = new Recursive();
      int[][] board;
      int[][] result;
      int[] abilities;

      //test variables
      int testNum;
      String testingWhat;
      String testResults;

      testNum = 1;
      testingWhat = "problem 1 - conversion of 12 to binary";
      expectedString = "1100";
      actualString = r.getBinary(12);
      testResults = (expectedString.equals(actualString)) ? PASSED_TEST : FAILED_TEST;
      System.out.println(formattedTestResults(testNum, testingWhat, testResults));

      testNum = 2;
      testingWhat = "problem 1 - conversion of 127 to binary";
      expectedString = "1111111";
      actualString = r.getBinary(127);
      testResults = (expectedString.equals(actualString)) ? PASSED_TEST : FAILED_TEST;
      System.out.println(formattedTestResults(testNum, testingWhat, testResults));

      testNum = 3;
      testingWhat = "problem 1 - conversion of 16 to binary";
      expectedString = "10000";
      actualString = r.getBinary(16);
      testResults = (expectedString.equals(actualString)) ? PASSED_TEST : FAILED_TEST;
      System.out.println(formattedTestResults(testNum, testingWhat, testResults));

      testNum = 4;
      testingWhat = "problem 1 - conversion of 3 to binary";
      expectedString = "11";
      actualString = r.getBinary(3);
      testResults = (expectedString.equals(actualString)) ? PASSED_TEST : FAILED_TEST;
      System.out.println(formattedTestResults(testNum, testingWhat, testResults));

      testNum = 5;
      testingWhat = "problem 2 - reversing an empty string";
      expectedString = "";
      actualString = r.revString("");
      testResults = (expectedString.equals(actualString)) ? PASSED_TEST : FAILED_TEST;
      System.out.println(formattedTestResults(testNum, testingWhat, testResults));

      testNum = 6;
      testingWhat = "problem 2 - reversing 'eye'";
      expectedString = "eye";
      actualString = r.revString("eye");
      testResults = (expectedString.equals(actualString)) ? PASSED_TEST : FAILED_TEST;
      System.out.println(formattedTestResults(testNum, testingWhat, testResults));

      testNum = 7;
      testingWhat = "problem 2 - reversing 'racecar'";
      expectedString = "racecar";
      actualString = r.revString("racecar");
      testResults = (expectedString.equals(actualString)) ? PASSED_TEST : FAILED_TEST;
      System.out.println(formattedTestResults(testNum, testingWhat, testResults));

      testNum = 8;
      testingWhat = "problem 2 - reversing a word with a newline";
      expectedString = "hcnurc\nniatpac";
      actualString = r.revString("captain\ncrunch");
      testResults = (expectedString.equals(actualString)) ? PASSED_TEST : FAILED_TEST;
      System.out.println(formattedTestResults(testNum, testingWhat, testResults));

      testNum = 9;
      testingWhat = "problem 2 - reversing a tab and newline";
      expectedString = "\t\n";
      actualString = r.revString("\n\t");
      testResults = (expectedString.equals(actualString)) ? PASSED_TEST : FAILED_TEST;
      System.out.println(formattedTestResults(testNum, testingWhat, testResults));

      testNum = 10;
      testingWhat = "problem 2 - reversing 'pizza hut'";
      expectedString = "tuh azzip";
      actualString = r.revString("pizza hut");
      testResults = (expectedString.equals(actualString)) ? PASSED_TEST : FAILED_TEST;
      System.out.println(formattedTestResults(testNum, testingWhat, testResults));

      testNum = 11;
      testingWhat = "problem 3 - nextIsDouble []";
      expectedInt = 0;
      actualInt = r.nextIsDouble(new int[]{});
      testResults = (expectedInt == actualInt) ? PASSED_TEST : FAILED_TEST;
      System.out.println(formattedTestResults(testNum, testingWhat, testResults));

      testNum = 12;
      testingWhat = "problem 3 - nextIsDouble [1]";
      expectedInt = 0;
      actualInt = r.nextIsDouble(new int[]{1});
      testResults = (expectedInt == actualInt) ? PASSED_TEST : FAILED_TEST;
      System.out.println(formattedTestResults(testNum, testingWhat, testResults));

      testNum = 13;
      testingWhat = "problem 3 - nextIsDouble [1, 1]";
      expectedInt = 0;
      actualInt = r.nextIsDouble(new int[]{1, 1});
      testResults = (expectedInt == actualInt) ? PASSED_TEST : FAILED_TEST;
      System.out.println(formattedTestResults(testNum, testingWhat, testResults));

      testNum = 14;
      testingWhat = "problem 3 - nextIsDouble [1, 2]";
      expectedInt = 1;
      actualInt = r.nextIsDouble(new int[]{1, 2});
      testResults = (expectedInt == actualInt) ? PASSED_TEST : FAILED_TEST;
      System.out.println(formattedTestResults(testNum, testingWhat, testResults));

      testNum = 15;
      testingWhat = "problem 3 - nextIsDouble [1, 2, 4, -8]";
      expectedInt = 2;
      actualInt = r.nextIsDouble(new int[]{1, 2, 4, -8});
      testResults = (expectedInt == actualInt) ? PASSED_TEST : FAILED_TEST;
      System.out.println(formattedTestResults(testNum, testingWhat, testResults));

      testNum = 16;
      testingWhat = "problem 3 - nextIsDouble [1, 2, 4, 8]";
      expectedInt = 3;
      actualInt = r.nextIsDouble(new int[]{1, 2, 4, 8});
      testResults = (expectedInt == actualInt) ? PASSED_TEST : FAILED_TEST;
      System.out.println(formattedTestResults(testNum, testingWhat, testResults));

      testNum = 17;
      testingWhat = "problem 3 - nextIsDouble [2, 1, 4, 2, 8]";
      expectedInt = 0;
      actualInt = r.nextIsDouble(new int[]{2, 1, 4, 2, 8});
      testResults = (expectedInt == actualInt) ? PASSED_TEST : FAILED_TEST;
      System.out.println(formattedTestResults(testNum, testingWhat, testResults));

      testNum = 18;
      testingWhat = "problem 3 - nextIsDouble [-1, -2]";
      expectedInt = 1;
      actualInt = r.nextIsDouble(new int[]{-1, -2});
      testResults = (expectedInt == actualInt) ? PASSED_TEST : FAILED_TEST;
      System.out.println(formattedTestResults(testNum, testingWhat, testResults));

      testNum = 19;
      testingWhat = "problem 4 - mnemonics based on '6'";
      expectedStringArray.add("M");
      expectedStringArray.add("N");
      expectedStringArray.add("O");
      Collections.sort(expectedStringArray);
      actualStringArray = r.listMnemonics("6");
      Collections.sort(actualStringArray);
      testResults = (actualStringArray.equals(expectedStringArray)) ? PASSED_TEST : FAILED_TEST;
      System.out.println(formattedTestResults(testNum, testingWhat, testResults));

      testNum = 20;
      testingWhat = "problem 4 - mnemonics based on '601'";
      expectedStringArray.clear();
      expectedStringArray.add("M01");
      expectedStringArray.add("N01");
      expectedStringArray.add("O01");
      Collections.sort(expectedStringArray);
      actualStringArray = r.listMnemonics("601");
      Collections.sort(actualStringArray);
      testResults = (actualStringArray.equals(expectedStringArray)) ? PASSED_TEST : FAILED_TEST;
      System.out.println(formattedTestResults(testNum, testingWhat, testResults));

      testNum = 21;
      testingWhat = "problem 4 - mnemonics based on '6019'";
      expectedStringArray.clear();
      expectedStringArray.add("M01W");
      expectedStringArray.add("M01X");
      expectedStringArray.add("M01Y");
      expectedStringArray.add("M01Z");
      expectedStringArray.add("N01W");
      expectedStringArray.add("N01X");
      expectedStringArray.add("N01Y");
      expectedStringArray.add("N01Z");
      expectedStringArray.add("O01W");
      expectedStringArray.add("O01X");
      expectedStringArray.add("O01Y");
      expectedStringArray.add("O01Z");
      Collections.sort(expectedStringArray);
      actualStringArray = r.listMnemonics("6019");
      Collections.sort(actualStringArray);
      testResults = (actualStringArray.equals(expectedStringArray)) ? PASSED_TEST : FAILED_TEST;
      System.out.println(formattedTestResults(testNum, testingWhat, testResults));

      testNum = 22;
      testingWhat = "problem 4 - mnemonics based on ''";
      expectedStringArray.clear();
      expectedStringArray.add("");
      actualStringArray = r.listMnemonics("");
      testResults = (actualStringArray.equals(expectedStringArray)) ? PASSED_TEST : FAILED_TEST;
      System.out.println(formattedTestResults(testNum, testingWhat, testResults));

      testNum = 23;
      testingWhat = "problem 7 - sudoku solver";
      board = stringToBoard("000000000000030048015002900001000000050470060000000802390067500070003620560000004");
      result = r.getSudokoSolution(board);
      expectedString = "783694215926135748415782936831926457259478163647351892394267581178543629562819374";
      actualString = boardToString(result);
      testResults = (actualString.equals(expectedString)) ? PASSED_TEST : FAILED_TEST;
      System.out.println(formattedTestResults(testNum, testingWhat, testResults));
      
      testNum = 24;
      testingWhat = "problem 7 - sudoku solver - given already solved puzzle";
      board = stringToBoard("783694215926135748415782936831926457259478163647351892395267581178543629562819374");
      result = r.getSudokoSolution(board);
      expectedString = "783694215926135748415782936831926457259478163647351892395267581178543629562819374";
      actualString = boardToString(result);
      testResults = (actualString.equals(expectedString)) ? PASSED_TEST : FAILED_TEST;
      System.out.println(formattedTestResults(testNum, testingWhat, testResults));
      
      testNum = 25;
      testingWhat = "problem 7 - sudoku solver";
      board = stringToBoard("080206000000400300300001056500000901000900060000002000890070000060000730000000020");
      result = r.getSudokoSolution(board);
      expectedString = "985236147216457398374891256528643971137985462649712583892374615461528739753169824";
      actualString = boardToString(result);
      testResults = (actualString.equals(expectedString)) ? PASSED_TEST : FAILED_TEST;
      System.out.println(formattedTestResults(testNum, testingWhat, testResults));

      /*
      System.out.println("board: ");
      printBoard(board);
      System.out.println("solved board from Recursive: ");
      printBoard(stringToBoard(actualString));
      System.out.println("expected solution: ");
      printBoard(stringToBoard(expectedString));
      */

      testNum = 26;
      testingWhat = "problem 8 - canFlowOffMap left side";
      board = new int[][]{
         {999, 999, 998, 999},
         {999, 999, 999, 999},
         {998, 999, 999, 997},
         {999, 999, 999, 999}
      };
      expectedBool = true;
      actualBool = r.canFlowOffMap(board, 2, 1);
      testResults = (actualBool == expectedBool) ? PASSED_TEST : FAILED_TEST;
      System.out.println(formattedTestResults(testNum, testingWhat, testResults));

      testNum = 27;
      testingWhat = "problem 8 - canFlowOffMap left diagonal (should be false)";
      expectedBool = false;
      actualBool = r.canFlowOffMap(board, 1, 1);
      testResults = (actualBool == expectedBool) ? PASSED_TEST : FAILED_TEST;
      System.out.println(formattedTestResults(testNum, testingWhat, testResults));

      testNum = 28;
      testingWhat = "problem 8 - canFlowOffMap upper";
      expectedBool = true;
      actualBool = r.canFlowOffMap(board, 1, 2);
      testResults = (actualBool == expectedBool) ? PASSED_TEST : FAILED_TEST;
      System.out.println(formattedTestResults(testNum, testingWhat, testResults));

      testNum = 29;
      testingWhat = "problem 8 - canFlowOffMap upper diagonal (should be false)";
      expectedBool = false;
      actualBool = r.canFlowOffMap(board, 1, 1);
      testResults = (actualBool == expectedBool) ? PASSED_TEST : FAILED_TEST;
      System.out.println(formattedTestResults(testNum, testingWhat, testResults));

      testNum = 30;
      testingWhat = "problem 8 - canFlowOffMap right";
      expectedBool = true;
      actualBool = r.canFlowOffMap(board, 2, 2);
      testResults = (actualBool == expectedBool) ? PASSED_TEST : FAILED_TEST;
      System.out.println(formattedTestResults(testNum, testingWhat, testResults));

      testNum = 31;
      testingWhat = "problem 8 - canFlowOffMap down";
      board = new int[][]{
         {999, 999, 998, 999},
         {999, 999, 999, 999},
         {999, 999, 999, 999},
         {999, 999, 998, 999}
      };
      expectedBool = true;
      actualBool = r.canFlowOffMap(board, 2, 2);
      testResults = (actualBool == expectedBool) ? PASSED_TEST : FAILED_TEST;
      System.out.println(formattedTestResults(testNum, testingWhat, testResults));

      testNum = 31;
      testingWhat = "problem 8 - canFlowOffMap down diagonal (should be false)";
      expectedBool = false;
      actualBool = r.canFlowOffMap(board, 2, 1);
      testResults = (actualBool == expectedBool) ? PASSED_TEST : FAILED_TEST;
      System.out.println(formattedTestResults(testNum, testingWhat, testResults));

      testNum = 32;
      testingWhat = "problem 9 - assigning teams with zero minDiff";
      abilities = new int[]{-2, 1, 2, -1};
      expectedInt = 0;
      actualInt = r.minDifference(2, abilities);
      testResults = (expectedInt == actualInt) ? PASSED_TEST : FAILED_TEST;
      System.out.println(formattedTestResults(testNum, testingWhat, testResults));

      testNum = 33;
      testingWhat = "problem 9 - assigning teams with positive, negative abilities";
      abilities = new int[]{-2, 1, 2, -1, -3};
      expectedInt = 1;
      actualInt = r.minDifference(2, abilities);
      testResults = (expectedInt == actualInt) ? PASSED_TEST : FAILED_TEST;
      System.out.println(formattedTestResults(testNum, testingWhat, testResults));

      testNum = 34;
      testingWhat = "problem 9 - assigning teams with all negative abilities";
      abilities = new int[]{-2, -1, -2, -1, -3};
      expectedInt = 1;
      actualInt = r.minDifference(2, abilities);
      testResults = (expectedInt == actualInt) ? PASSED_TEST : FAILED_TEST;
      System.out.println(formattedTestResults(testNum, testingWhat, testResults));

      testNum = 35;
      testingWhat = "problem 9 - assigning teams with all zeros for abilities";
      abilities = new int[]{0, 0, 0, 0, 0, 0, 0};
      expectedInt = 0;
      actualInt = r.minDifference(4, abilities);
      testResults = (expectedInt == actualInt) ? PASSED_TEST : FAILED_TEST;
      System.out.println(formattedTestResults(testNum, testingWhat, testResults));
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

   private static String formattedTestResults(int testNum, String testingWhat, String testResults) {
      return String.format(TEST_FORMATTING, "Test ", testNum, DIVIDER, testingWhat, DIVIDER, testResults);
   }

   private static void printBoard(int[][] board) {
      for (int r = 0; r < board.length; r++) {
         System.out.print("r" + r + ") ");
         for (int c = 0; c < board[r].length; c++) {
            System.out.print(board[r][c]);
            System.out.print("|");
         }
         System.out.println();
         System.out.print("    ");
         for (int c = 0; c < (board[r].length * 2); c++) {
            System.out.print("-");
         }
         System.out.println();
      }
   }
}