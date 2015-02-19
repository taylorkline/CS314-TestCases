import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/* CodeCamp.java - CS314 Assignment 1 - Tester class
 * @author unkown author on pastebin
 * Link: http://pastebin.com/SLs3fbgn
 */

public class CodeCampTester2{
  
  public static void main(String[] args){
    int testNum = 1; // Test number
    
    // Hamming Distance Test 1
    int[] list1 = {5, 6, -1, 2, 9, -5, 2, 0, -10};
    int[] list2 = {1, 6, -1, 2, 8, -5, 2, -2, -10};
    int correct = 3;
    int result = CodeCamp.hammingDistance(list1, list2);
    System.out.println("Test " + testNum + " hamming distance: expected value: " +
                       correct + ", actual value: " + result);
    if(correct == result)
      System.out.println(" passed test " + testNum + ", hamming distance");
    else
      System.out.println(" ***** FAILED ***** test " + testNum + ", hamming distance");
    
    // Hamming Distance Test 2
    testNum++;
    list1 = new int[]{-2, -3, -1, 4, 9, 0, 7, 100, -100};
    list2 = new int[]{-2, -4, -1, 0, 7, 0, 7, -99, 87};
    correct = 5;
    result = CodeCamp.hammingDistance(list1, list2);
    System.out.println("\nTest " + testNum + " hamming distance: expected value: " +
                       correct + ", actual value: " + result);
    if(correct == result)
      System.out.println(" passed test " + testNum + ", hamming distance");
    else
      System.out.println(" ***** FAILED ***** test " + testNum + ", hamming distance");
    
    // isPermutation Test 3
    testNum++;
    list1 = new int[]{1, 1, 3, 3, 3, 6, 7, 9};
    list2 = new int[]{9, 1, 3, 1, 6, 3, 7, 3};
    boolean correctBool = true;
    boolean resultBool = CodeCamp.isPermutation(list1, list2);
    System.out.println("\nTest " + testNum + " isPermutation: expected value: "
                         + correctBool + ", actual value: " + resultBool);
    if (correctBool == resultBool)
      System.out.println(" passed test " + testNum + ", isPermutation");
    else
      System.out.println(" ***** FAILED ***** test " + testNum + ", isPermutation");
    
    // isPermutation Test 4
    testNum++;
    list1 = new int[]{5, 5, 3, 2, 2, 0, -1, 4};
    list2 = new int[]{0, 2, 3, 5, -1, 4, 2};
    correctBool = false;
    resultBool = CodeCamp.isPermutation(list1, list2);
    System.out.println("\nTest " + testNum + " isPermutation: expected value: "
                         + correctBool + ", actual value: " + resultBool);
    if (correctBool == resultBool)
      System.out.println(" passed test " + testNum + ", isPermutation");
    else
      System.out.println(" ***** FAILED ***** test " + testNum + ", isPermutation");
    
    // mostVowels Test 5
    testNum++;
    String[] stringList = {"aaeeiioouu", "eiouaeiobcldielfk", "Hello There", null};
    correct = 0;
    result = CodeCamp.mostVowels(stringList);
    System.out.println("\nTest " + testNum + " mostVowels: expected result: "
                         + correct + ", actual result: " + result);
    if(correct == result)
      System.out.println(" passed test " + testNum + ", mostVowels");
    else
      System.out.println(" ***** FAILED ***** test " + testNum + ", mostVowels");
    
    // mostVowels Test 6
    testNum++;
    stringList = new String[]{null, null, "aaeo", "aeo","aaa","aeio"};
    correct = 2;
    result = CodeCamp.mostVowels(stringList);
    System.out.println("\nTest " + testNum + " mostVowels: expected result: "
                         + correct + ", actual result: " + result);
    if(correct == result)
      System.out.println(" passed test " + testNum + ", mostVowels");
    else
      System.out.println(" ***** FAILED ***** test " + testNum + ", mostVowels");
    
    // sharedBirthdays Test 7
    testNum++;
    int numPairs = CodeCamp.sharedBirthdays(10, 1);
    int correctPairs = 45;
    System.out.println("\nTest " + testNum + " shared birthdays: expected: " +
                       correctPairs + ", actual: " + numPairs);
    if(numPairs == correctPairs)
      System.out.println(" passed test " + testNum + ", shared birthdays");
    else
      System.out.println(" ***** FAILED ***** test " + testNum + ", shared birthdays. " +
                         "Expected pairs to be " + correctPairs + ". Value returned: " + numPairs);
    
    // sharedBirthdays Test 8
    testNum++;
    numPairs = CodeCamp.sharedBirthdays(1000, 5);
    System.out.println("\nTest " + testNum + " shared birthdays: expected: " +
                       "number greater than 0, actual: " + numPairs);
    if(numPairs > 0)
      System.out.println(" passed test " + testNum + ", shared birthdays");
    else
      System.out.println(" ***** FAILED ***** test " + testNum + ", shared birthdays. " +
                         "Expected pairs to be greater than 0. Value returned: " + numPairs);
    
    // queensAreSafe Test 9
    testNum++;
    char[][] chessBoard = {
      {'.', '.', 'q', '.'},
      {'q', '.', '.', '.'},
      {'.', '.', '.', 'q'},
      {'.', 'q', '.', '.'}};
    correctBool = true;
    resultBool = CodeCamp.queensAreSafe(chessBoard);
    System.out.println("\nTest " + testNum + " queensAreSafe: expected value: "
                         + correctBool + ", actual value: " + resultBool);
    if (correctBool == resultBool)
      System.out.println(" passed test " + testNum + ", queensAreSafe");
    else
      System.out.println(" ***** FAILED ***** test " + testNum + ", queensAreSafe");
    
    // queensAreSafe Test 10
    testNum++;
    chessBoard = new char[][]{
      {'.', '.', '.', 'q', '.'},
      {'q', '.', '.', '.', '.'},
      {'.', '.', '.', '.', 'q'},
      {'.', '.', 'q', '.', '.'},
      {'.', 'q', '.', '.', '.'}};
    correctBool = false;
    resultBool = CodeCamp.queensAreSafe(chessBoard);
    System.out.println("\nTest " + testNum + " queensAreSafe: expected value: "
                         + correctBool + ", actual value: " + resultBool);
    if (correctBool == resultBool)
      System.out.println(" passed test " + testNum + ", queensAreSafe");
    else
      System.out.println(" ***** FAILED ***** test " + testNum + ", queensAreSafe");
    
    // valueOfMostValuablePlot Test 11
    testNum++;
    int[][] cityBlocks = {
      {-1, -2, -7, -29, -1},
      {0, -3, -6, -4, 0},
      {-7, -90, -4, -34, -89},
      {-1, -3, -2, -2, -10},
      {-10, -34, -36, -5, -6},
      {-15, -1, 1, -3, 0}};
    
    correct = 1;
    result = CodeCamp.getValueOfMostValuablePlot(cityBlocks);
    System.out.println("\nTest " + testNum + " getValueOfMostValuablePlot: expected value: "
                         + correct + ", actual value: " + result);
    if(correct == result)
      System.out.println(" passed test " + testNum + ", getValueOfMostValuablePlot");
    else
      System.out.println(" ***** FAILED ***** test " + testNum + ", getValueOfMostValuablePlot");
    
    // valueOfMostValuablePlot Test 12
    testNum++;
    cityBlocks = new int[][]{{9, 6, 3},
      {6, 4, 2},
      {3, 2, 1}};
    correct = 36;
    result = CodeCamp.getValueOfMostValuablePlot(cityBlocks);
    System.out.println("\nTest " + testNum + " getValueOfMostValuablePlot: expected value: "
                         + correct + ", actual value: " + result);
    if(correct == result)
      System.out.println(" passed test " + testNum + ", getValueOfMostValuablePlot");
    else
      System.out.println(" ***** FAILED ***** test " + testNum + ", getValueOfMostValuablePlot");
  } // end of main method

// pre: list != null
private static int[] intListToArray(List<Integer> list) {
  if(list == null)
    throw new IllegalArgumentException("list parameter may not be null.");
  int[] result = new int[list.size()];
  int arrayIndex = 0;
  for(int x : list) {
    result[arrayIndex++] = x;
  }
  return result;
}
}