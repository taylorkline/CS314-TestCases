/*CodeCamp.java - CS314 Assignment 1 - Tester class
 * @author: Joshua Guenther
 * Github: Yosh17
 */

public class CodeCampTester1{
  
  public static void main(String[] args){
    final String newline = System.getProperty("line.separator");
    boolean expectedBool;
    boolean actualBool;
    
    //hammingDistance, Student Test 1
    int[] h1 = new int[750000];
    int[] h2 = new int[750000];
    h2[h2.length-1] = 7;
    int expected = 1;
    int actual = CodeCamp.hammingDistance(h1, h2);
    System.out.println(newline+"hamming distance, Student Test 1: expected value: "+expected+", actual value: "+actual);
    System.out.println(expected == actual ? "  passed test, hamming distance" : "   ***** FAILED ***** test, hamming distance");
    
    //hammingDistance, Student Test 2
    h1 = new int[25];
    h2 = new int[25];
    expected = 0;
    actual = CodeCamp.hammingDistance(h1, h2);
    System.out.println(newline+"hamming distance, Student Test 2: expected value: "+expected+", actual value: "+actual);
    System.out.println(expected == actual ? "  passed test, hamming distance" : "   ***** FAILED ***** test, hamming distance");
    
    //hammingDistance, Student Test 3
    int arraySize = (int)Math.floor(Math.random()*500000); 
    h1 = new int[arraySize];
    h2 = new int[arraySize];
    expected = 0;
    for(int i = 0; i < h1.length; i++){
      h1[i] = (int)Math.floor(Math.random()*2); //random 0 or 1
      h2[i] = (int)Math.floor(Math.random()*2); //random 0 or 1
      if(h1[i] != h2[i]){
        expected++;}}
    actual = CodeCamp.hammingDistance(h1, h2);
    System.out.println(newline+"hamming distance, Student Test 3: expected value: "+expected+", actual value: "+actual);
    System.out.println(expected == actual ? "  passed test, hamming distance" : "   ***** FAILED ***** test, hamming distance");
    
    //hammingDistance, Student Test 4
    h1 = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
    h2 = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
    expected = 0;
    actual = CodeCamp.hammingDistance(h1,h2);
    System.out.println(newline+"hamming distance, Student Test 4: expected value: "+expected+", actual value: "+actual);
    System.out.println(expected == actual ? "  passed test, hamming distance" : "   ***** FAILED ***** test, hamming distance");
    
    //hammingDistance, Student 2, Test 5
    h1 = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
    h2 = new int[]{2, 3, 4, 5, 5, 6, 9, 8};
    expected = 5;
    actual = CodeCamp.hammingDistance(h1, h2);
    System.out.println(newline+"hamming distance, Student Test 5: expected value: "+expected+", actual value: "+actual);
    System.out.println(expected == actual ? "  passed test, hamming distance" : "   ***** FAILED ***** test, hamming distance");
    
    //isPermutation, Student Test 1
    int[]a = new int[50];
    int[] b = new int[50];
    b[b.length-1] = 1;
    expectedBool = false;
    actualBool = CodeCamp.isPermutation(a, b);
    System.out.println(newline+"isPermutation, Student Test 1: expected value: "+expectedBool+", actual value: "+actualBool);
    System.out.println(expectedBool == actualBool ? "  passed test, isPermutation" : "   ***** FAILED ***** test, isPermutation");     
    
    //isPermutation, Student Test 2
    a = new int[50];
    b = new int[50];
    for(int i = 0; i < b.length; i++){
      b[i] = 1;}
    expectedBool = false;
    actualBool = CodeCamp.isPermutation(a, b);
    System.out.println(newline+"isPermutation, Student Test 2: expected value: "+expectedBool+", actual value: "+actualBool);
    System.out.println(expectedBool == actualBool ? "  passed test, isPermutation" : "   ***** FAILED ***** test, isPermutation");     
    
    //isPermutation, Student Test 3
    final int SIZE = 45;
    a = new int[SIZE];
    b = new int[SIZE];
    int[] sums = new int[2];
    for(int i = 0; i < SIZE; i++){
      a[i] = (int)Math.floor(Math.random()*2);
      b[i] = (int)Math.floor(Math.random()*2);
      sums[0] += a[i];
      sums[1] += b[i];}
    expectedBool = sums[0] == sums[1];
    actualBool = CodeCamp.isPermutation(a, b);
    System.out.println(newline+"isPermutation, Student Test 3: expected value: "+expectedBool+", actual value: "+actualBool);
    System.out.println(expectedBool == actualBool ? "  passed test, isPermutation" : "   ***** FAILED ***** test, isPermutation");     
    
    //isPermutation, Student Test 4
    a = new int[]{5, 5};
    b = new int[]{2, 1, 3};
    expectedBool = false;
    actualBool = CodeCamp.isPermutation(a, b);
    System.out.println(newline+"isPermutation, Student Test 4: expected value: "+expectedBool+", actual value: "+actualBool);
    System.out.println(expectedBool == actualBool ? "  passed test, isPermutation" : "   ***** FAILED ***** test, isPermutation");     
    
    //isPermutation, Student Test 5
    a = new int[]{1,1,1,1,1};
    b = new int[]{1,1,1,1,1};
    expectedBool = true;
    actualBool = CodeCamp.isPermutation(a, b);
    System.out.println(newline+"isPermutation, Student Test 5: expected value: "+expectedBool+", actual value: "+actualBool);
    System.out.println(expectedBool == actualBool ? "  passed test, isPermutation" : "   ***** FAILED ***** test, isPermutation");     
    
    //isPermutation, Student Test 6
    a = new int[]{10,30000000,500000,129219129,12111,3536};
    b = new int[]{30000000,500000,12111,3536,10,129219129};
    expectedBool = true;
    actualBool = CodeCamp.isPermutation(a, b);
    System.out.println(newline+"isPermutation, Student Test 6: expected value: "+expectedBool+", actual value: "+actualBool);
    System.out.println(expectedBool == actualBool ? "  passed test, isPermutation" : "   ***** FAILED ***** test, isPermutation");     
    
    //mostVowels, Student Test 1
    String[] sList = new String[]{"aaaaaaaaaa", "aaaaaaaaaaaaaaaa", null, null, "aaaaaaaaa"};
    int expectedResult = 1;
    int actualResult = CodeCamp.mostVowels(sList);
    System.out.println(newline+"mostVowels, Student Test 1: expected result: "+expectedResult+", actual result: "+actualResult);
    System.out.println(actualResult == expectedResult ? "  passed test, mostVowels" : "   ***** FAILED ***** test 20, mostVowels");
    
    //mostVowels, Student Test 2
    sList = new String[]{null, null, "ruuuuuun", "hide", "hide", "ruuuuuun"};
    expectedResult = 2;
    actualResult = CodeCamp.mostVowels(sList);
    System.out.println(newline+"mostVowels, Student Test 2: expected result: "+expectedResult+", actual result: "+actualResult);
    System.out.println(actualResult == expectedResult ? "  passed test, mostVowels" : "   ***** FAILED ***** test 20, mostVowels");
    
    //mostVowels, Student Test 3
    sList = new String[]{"beeeen", "beeeen", "beeeen", null};
    expectedResult = 0;
    actualResult = CodeCamp.mostVowels(sList);
    System.out.println(newline+"mostVowels, Student Test 3: expected result: "+expectedResult+", actual result: "+actualResult);
    System.out.println(actualResult == expectedResult ? "  passed test, mostVowels" : "   ***** FAILED ***** test 20, mostVowels");
    
    //mostVowels, Student Test 4
    sList = new String[]{null, "j", "w", "g"};
    expectedResult = 1;
    actualResult = CodeCamp.mostVowels(sList);
    System.out.println(newline+"mostVowels, Student Test 4: expected result: "+expectedResult+", actual result: "+actualResult);
    System.out.println(actualResult == expectedResult ? "  passed test, mostVowels" : "   ***** FAILED ***** test 20, mostVowels");
    
    //mostVowels, Student Test 5
    sList = new String[]{"red", "red", "green", "green", "Chartreuse", "Chartreuse"};
    expectedResult = 4;
    actualResult = CodeCamp.mostVowels(sList);
    System.out.println(newline+"mostVowels, Student Test 5: expected result: "+expectedResult+", actual result: "+actualResult);
    System.out.println(actualResult == expectedResult ? "  passed test, mostVowels" : "   ***** FAILED ***** test 20, mostVowels");
    
    //sharedBirthdays, Student Test 1
    expectedResult = 66430;
    actualResult = CodeCamp.sharedBirthdays(365, 1);
    System.out.println(newline+"sharedBirthdays, Student Test 1: expected result: "+expectedResult+", actual result: "+actualResult);
    System.out.println(actualResult == expectedResult ? "  passed test, shared birthdays" : "   ***** FAILED ***** test, shared birthdays");
    
    //sharedBirthdays, Student Test 2
    actualResult = CodeCamp.sharedBirthdays(444,333);
    System.out.println(newline+"sharedBirthdays, Student Test 2: expected result: a value of 1 or more, actual result: "+actualResult);
    System.out.println(actualResult > 0 ? "  passed test, shared birthdays" : "   ***** FAILED ***** test, shared birthdays");
    
    //sharedBirthdays, Student Test 3
    actualResult = CodeCamp.sharedBirthdays(730, 365);
    System.out.println(newline+"sharedBirthdays, Student Test 3: expected result: a value of 1 or more, actual result: "+actualResult);
    System.out.println(actualResult > 0 ? "  passed test, shared birthdays" : "   ***** FAILED ***** test, shared birthdays");
    
    //queensAreASafe, Student Test 1
    char[][] board = new char[][]{
      {'.', '.', '.'},
      {'.', '.', '.'},
      {'.', '.', '.'}};
    expectedBool = true;
    actualBool = CodeCamp.queensAreSafe(board);
    System.out.println(newline+"queensAreSafe, Student Test 1: expected value: "+expectedBool +", actual value: "+actualBool);
    System.out.println(expectedBool == actualBool ? "  passed test, queensAreSafe" : "   ***** FAILED ***** test, queensAreSafe");
    
    //queensAreASafe, Student Test 2
    board = new char[][]{
      {'q', '.', '.'},
      {'.', '.', '.'},
      {'q', '.', '.'}};
    expectedBool = false;
    actualBool = CodeCamp.queensAreSafe(board);
    System.out.println(newline+"queensAreSafe, Student Test 2: expected value: "+expectedBool +", actual value: "+actualBool);
    System.out.println(expectedBool == actualBool ? "  passed test, queensAreSafe" : "    ***** FAILED ***** test, queensAreSafe");
    
    //queensAreASafe, Student Test 3
    board = new char[][] {
      {'q', '.', 'q'},
      {'.', '.', '.'},
      {'.', '.', '.'}};
    expectedBool = false;
    actualBool = CodeCamp.queensAreSafe(board);
    System.out.println(newline+"queensAreSafe, Student Test 3: expected value: "+expectedBool +", actual value: "+actualBool);
    System.out.println(expectedBool == actualBool ? "  passed test, queensAreSafe" : "    ***** FAILED ***** test, queensAreSafe");
    
    //queensAreASafe, Student Test 4
    board = new char[][] {
      {'q', '.', '.'},
      {'.', 'q', '.'},
      {'.', '.', '.'}};
    expectedBool = false;
    actualBool = CodeCamp.queensAreSafe(board);
    System.out.println(newline+"queensAreSafe, Student Test 4: expected value: "+expectedBool +", actual value: "+actualBool);
    System.out.println(expectedBool == actualBool ? "  passed test, queensAreSafe" : "    ***** FAILED ***** test, queensAreSafe");
    
    //queensAreASafe, Student Test 5
    board = new char[][] {
      {'q', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
      {'.', '.', '.', '.', '.', '.', '.', '.', '.', 'q'},
      {'.', '.', '.', '.', '.', '.', 'q', '.', '.', '.'},
      {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
      {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
      {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
      {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
      {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
      {'.', 'q', '.', '.', '.', '.', '.', '.', '.', '.'},
      {'.', '.', '.', '.', '.', '.', '.', '.', 'q', '.'}};
    expectedBool = true;
    actualBool = CodeCamp.queensAreSafe(board);
    System.out.println(newline+"queensAreSafe, Student Test 5: expected value: "+expectedBool +", actual value: "+actualBool);
    System.out.println(expectedBool == actualBool ? "  passed test, queensAreSafe" : "    ***** FAILED ***** test, queensAreSafe");
    
    //queensAreASafe, Student Test 6
    board = new char[][] {{'.', '.', },
      {'.', 'q',}};
    expectedBool = true;
    actualBool = CodeCamp.queensAreSafe(board);
    actualBool = CodeCamp.queensAreSafe(board);
    System.out.println(newline+"queensAreSafe, Student Test 6: expected value: "+expectedBool +", actual value: "+actualBool);
    System.out.println(expectedBool == actualBool ? "  passed test, queensAreSafe" : "    ***** FAILED ***** test, queensAreSafe");
    
    //queensAreASafe, Student Test 7
    board = new char[][] {{'.', 'q', },
      {'.', '.',}};
    expectedBool = true;
    actualBool = CodeCamp.queensAreSafe(board);
    actualBool = CodeCamp.queensAreSafe(board);
    System.out.println(newline+"queensAreSafe, Student Test 7: expected value: "+expectedBool +", actual value: "+actualBool);
    System.out.println(expectedBool == actualBool ? "  passed test, queensAreSafe" : "    ***** FAILED ***** test, queensAreSafe");
    
    //queensAreASafe, Student Test 8
    board = new char[][] {{'q'}};
    expectedBool = true;
    actualBool = CodeCamp.queensAreSafe(board);
    System.out.println(newline+"queensAreSafe, Student Test 8: expected value: "+expectedBool +", actual value: "+actualBool);
    System.out.println(expectedBool == actualBool ? "  passed test, queensAreSafe" : "    ***** FAILED ***** test, queensAreSafe");
    
    //getValueOfMostValuablePlot, Student Test 1
    int[][] city = new int[][]{
      {0, -2, -7, 1, 20},
      {9, 2, -6, 0, 20},
      {-4, 1, -4, 0, 20},
      {-1, 8, 0, -2, 0},
      {-10, 1, 1, -5, 20},
      {-15, -1, 1, 5, 4}};
    expected = 84;
    actual = CodeCamp.getValueOfMostValuablePlot(city);
    System.out.println(newline+"getValueOfMostValuablePlot, Student Test 1: expected value: "+expected+", actual value: "+actual);
    System.out.println(expected == actual ? "  passed test, getValueOfMostValuablePlot" : "    ***** FAILED ***** test, getValueOfMostValuablePlot");
    
    //getValueOfMostValuablePlot, Student Test 2
    city = new int[][]{   
      {0, -2, -7, 1, 20},
      {1, 2, -6, 0, 0} };
    expected = 21;
    actual = CodeCamp.getValueOfMostValuablePlot(city);
    System.out.println(newline+"getValueOfMostValuablePlot, Student Test 2: expected value: "+expected+", actual value: "+actual);
    System.out.println(expected == actual ? "  passed test, getValueOfMostValuablePlot" : "    ***** FAILED ***** test, getValueOfMostValuablePlot");
    
    //getValueOfMostValuablePlot, Student Test 3
    city = new int[][]{ 
      {0, -2, -7, 1, 20},
      {-5, 100, 100, 0, -23},
      {-4, 100, -2, 0, -15},
      {-1, -5, 0, -2, 0},
      {-10, 1, 0, -5, -23},
      {-15, -1, -1000, -250, 399}};
    expected = 399;
    actual = CodeCamp.getValueOfMostValuablePlot(city);
    System.out.println(newline+"getValueOfMostValuablePlot, Student Test 3: expected value: "+expected+", actual value: "+actual);
    System.out.println(expected == actual ? "  passed test, getValueOfMostValuablePlot" : "    ***** FAILED ***** test, getValueOfMostValuablePlot");
    
    //getValueOfMostValuablePlot, Student Test 4
    city = new int[][]{{0, -2,},
      {-5, 100}};      
    expected = 100;
    actual = CodeCamp.getValueOfMostValuablePlot(city);
    System.out.println(newline+"getValueOfMostValuablePlot, Student Test 4: expected value: "+expected+", actual value: "+actual);
    System.out.println(expected == actual ? "  passed test, getValueOfMostValuablePlot" : "    ***** FAILED ***** test, getValueOfMostValuablePlot");
    
  } // end of main method
  
}