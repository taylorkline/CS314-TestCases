/**
 * Tester for Binary Search Tree.
 * @author Taylor Kline
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Random;

public class BSTTester2 {
   private static final String FAILED_TEST = "******FAILED******";
   private static final String PASSED_TEST = "passed";
   private static final String DIVIDER = " | ";
   private static final String TEST_FORMATTING = "%-5s%-2d%-3s%-62s%-3s%-10s";

   public static void main(String[] args) {
      System.out.println("Hello!\n");

      runTests();
   }

   private static void runTests() {
      System.out.println("\n\tTesting BinarySearchTree.");
      boolean expectedBool;
      boolean actualBool;
      int expectedInt;
      int actualInt;
      String actualString;
      String expectedString;
      Random rand = new Random();
      BinarySearchTree<Integer> bst1 = new BinarySearchTree<>();
      BinarySearchTree<Double> bst2 = new BinarySearchTree<>();
      ArrayList<Double> doubleList;

      //test variables
      int testNum;
      String testingWhat;
      String testResults;

      testNum = 0;
      testingWhat = "empty constructor OK - indirect test through size()";
      expectedInt = 0;
      actualInt = bst1.size();
      testResults = (expectedInt == actualInt) ? PASSED_TEST : FAILED_TEST;
      System.out.println(formattedTestResults(testNum, testingWhat, testResults));

      testNum = 1;
      testingWhat = "empty constructor OK - indirect test through height()";
      expectedInt = -1;
      actualInt = bst1.height();
      testResults = (expectedInt == actualInt) ? PASSED_TEST : FAILED_TEST;
      System.out.println(formattedTestResults(testNum, testingWhat, testResults));

      testNum = 99;
      testingWhat = "getAll on empty tree";
      expectedString = "[]";
      actualString = bst1.getAll().toString();
      testResults = (actualString.equals(expectedString)) ? PASSED_TEST : FAILED_TEST;
      System.out.println(formattedTestResults(testNum, testingWhat, testResults));

      bst1.add(10);

      testNum = 2;
      testingWhat = "direct test of size() - indirect of add()";
      expectedInt = 1;
      actualInt = bst1.size();
      testResults = (expectedInt == actualInt) ? PASSED_TEST : FAILED_TEST;
      System.out.println(formattedTestResults(testNum, testingWhat, testResults));

      testNum = 3;
      testingWhat = "direct test of height() - indirect of add()";
      expectedInt = 0;
      actualInt = bst1.height();
      testResults = (expectedInt == actualInt) ? PASSED_TEST : FAILED_TEST;
      System.out.println(formattedTestResults(testNum, testingWhat, testResults));

      testNum = 98;
      testingWhat = "getAll on tree with only root";
      expectedString = "[10]";
      actualString = bst1.getAll().toString();
      testResults = (actualString.equals(expectedString)) ? PASSED_TEST : FAILED_TEST;
      System.out.println(formattedTestResults(testNum, testingWhat, testResults));

      bst1.add(5);

      testNum = 4;
      testingWhat = "direct test of size() - indirect of add()";
      expectedInt = 2;
      actualInt = bst1.size();
      testResults = (expectedInt == actualInt) ? PASSED_TEST : FAILED_TEST;
      System.out.println(formattedTestResults(testNum, testingWhat, testResults));

      testNum = 5;
      testingWhat = "direct test of height() - indirect of add()";
      expectedInt = 1;
      actualInt = bst1.height();
      testResults = (expectedInt == actualInt) ? PASSED_TEST : FAILED_TEST;
      System.out.println(formattedTestResults(testNum, testingWhat, testResults));

      testNum = 97;
      testingWhat = "getAll on tree with two values";
      expectedString = "[5, 10]";
      actualString = bst1.getAll().toString();
      testResults = (actualString.equals(expectedString)) ? PASSED_TEST : FAILED_TEST;
      System.out.println(formattedTestResults(testNum, testingWhat, testResults));

      bst1.add(10);

      testNum = 6;
      testingWhat = "direct test of size() - indirect of add()";
      expectedInt = 2;
      actualInt = bst1.size();
      testResults = (expectedInt == actualInt) ? PASSED_TEST : FAILED_TEST;
      System.out.println(formattedTestResults(testNum, testingWhat, testResults));

      testNum = 7;
      testingWhat = "direct test of height() - indirect of add()";
      expectedInt = 1;
      actualInt = bst1.height();
      testResults = (expectedInt == actualInt) ? PASSED_TEST : FAILED_TEST;
      System.out.println(formattedTestResults(testNum, testingWhat, testResults));

      bst1.iterativeAdd(1);
      bst1.iterativeAdd(10);

      testNum = 8;
      testingWhat = "direct test of size() - indirect of iteravieAdd()";
      expectedInt = 3;
      actualInt = bst1.size();
      testResults = (expectedInt == actualInt) ? PASSED_TEST : FAILED_TEST;
      System.out.println(formattedTestResults(testNum, testingWhat, testResults));

      testNum = 9;
      testingWhat = "direct test of height() - indirect of iterativeAdd()";
      expectedInt = 2;
      actualInt = bst1.height();
      testResults = (expectedInt == actualInt) ? PASSED_TEST : FAILED_TEST;
      System.out.println(formattedTestResults(testNum, testingWhat, testResults));

      testNum = 96;
      testingWhat = "getAll on tree with three values";
      expectedString = "[1, 5, 10]";
      actualString = bst1.getAll().toString();
      testResults = (actualString.equals(expectedString)) ? PASSED_TEST : FAILED_TEST;
      System.out.println(formattedTestResults(testNum, testingWhat, testResults));

      bst1.add(11);

      testNum = 10;
      testingWhat = "direct test of size() - indirect of add()";
      expectedInt = 4;
      actualInt = bst1.size();
      testResults = (expectedInt == actualInt) ? PASSED_TEST : FAILED_TEST;
      System.out.println(formattedTestResults(testNum, testingWhat, testResults));

      testNum = 11;
      testingWhat = "direct test of height() - indirect of add()";
      expectedInt = 2;
      actualInt = bst1.height();
      testResults = (expectedInt == actualInt) ? PASSED_TEST : FAILED_TEST;
      System.out.println(formattedTestResults(testNum, testingWhat, testResults));

      testNum = 95;
      testingWhat = "getAll on tree with four values";
      expectedString = "[1, 5, 10, 11]";
      actualString = bst1.getAll().toString();
      testResults = (actualString.equals(expectedString)) ? PASSED_TEST : FAILED_TEST;
      System.out.println(formattedTestResults(testNum, testingWhat, testResults));

      bst1.add(2);

      testNum = 12;
      testingWhat = "direct test of size() - indirect of add()";
      expectedInt = 5;
      actualInt = bst1.size();
      testResults = (expectedInt == actualInt) ? PASSED_TEST : FAILED_TEST;
      System.out.println(formattedTestResults(testNum, testingWhat, testResults));

      testNum = 13;
      testingWhat = "direct test of height() - indirect of add()";
      expectedInt = 3;
      actualInt = bst1.height();
      testResults = (expectedInt == actualInt) ? PASSED_TEST : FAILED_TEST;
      System.out.println(formattedTestResults(testNum, testingWhat, testResults));

      testNum = 95;
      testingWhat = "getAll on tree with five values";
      expectedString = "[1, 2, 5, 10, 11]";
      actualString = bst1.getAll().toString();
      testResults = (actualString.equals(expectedString)) ? PASSED_TEST : FAILED_TEST;
      System.out.println(formattedTestResults(testNum, testingWhat, testResults));

      bst1.add(32);
      bst1.add(35);
      bst1.add(34);
      bst1.add(26);
      bst1.add(23);
      bst1.add(25);
      bst1.add(4);
      bst1.add(3);

      testNum = 14;
      testingWhat = "direct test of size() - indirect of add()";
      expectedInt = 13;
      actualInt = bst1.size();
      testResults = (expectedInt == actualInt) ? PASSED_TEST : FAILED_TEST;
      System.out.println(formattedTestResults(testNum, testingWhat, testResults));

      testNum = 15;
      testingWhat = "direct test of height() - indirect of add()";
      expectedInt = 5;
      actualInt = bst1.height();
      testResults = (expectedInt == actualInt) ? PASSED_TEST : FAILED_TEST;
      System.out.println(formattedTestResults(testNum, testingWhat, testResults));

      testNum = 94;
      testingWhat = "getAll on tree with many values";
      expectedString = "[1, 2, 3, 4, 5, 10, 11, 23, 25, 26, 32, 34, 35]";
      actualString = bst1.getAll().toString();
      testResults = (actualString.equals(expectedString)) ? PASSED_TEST : FAILED_TEST;
      System.out.println(formattedTestResults(testNum, testingWhat, testResults));

      /*
      bst1.printTree();
      System.out.println(bst1.getAll());
      */

      System.out.println("\n\tGenerating an ArrayList of random doubles.");
      doubleList = getRandomList(5000);

      System.out.println("\tGenerating a tree from ArrayList.");
      for (double d : doubleList) {
         bst2.iterativeAdd(d);
      }

      Collections.sort(doubleList);

      testNum = 50;
      testingWhat = "direct test of size() - indirect of iterativeAdd()";
      expectedInt = doubleList.size();
      actualInt = bst2.size();
      testResults = (expectedInt == actualInt) ? PASSED_TEST : FAILED_TEST;
      System.out.println(formattedTestResults(testNum, testingWhat, testResults));

      testNum = 51;
      testingWhat = "getAll on tree with many doubles";
      testResults = (doubleList.equals(bst2.getAll())) ? PASSED_TEST : FAILED_TEST;
      System.out.println(formattedTestResults(testNum, testingWhat, testResults));

      testNum = 52;
      testingWhat = "get kth";
      expectedInt = 1;
      actualInt = bst1.get(0);
      testResults = (expectedInt == actualInt) ? PASSED_TEST : FAILED_TEST;
      System.out.println(formattedTestResults(testNum, testingWhat, testResults));

      testNum = 53;
      testingWhat = "get kth";
      expectedInt = 4;
      actualInt = bst1.get(3);
      testResults = (expectedInt == actualInt) ? PASSED_TEST : FAILED_TEST;
      System.out.println(formattedTestResults(testNum, testingWhat, testResults));

      testNum = 54;
      testingWhat = "get kth";
      expectedInt = 35;
      actualInt = bst1.get(bst1.size() - 1);
      testResults = (expectedInt == actualInt) ? PASSED_TEST : FAILED_TEST;
      System.out.println(formattedTestResults(testNum, testingWhat, testResults));

      testNum = 55;
      testingWhat = "get kth over whole tree";
      boolean passed = true;
      for (int i = 0; i < doubleList.size() && passed; i++) {
         passed = (bst2.get(i).equals(doubleList.get(i)));
      }
      testResults = (passed) ? PASSED_TEST : FAILED_TEST;
      System.out.println(formattedTestResults(testNum, testingWhat, testResults));

      testNum = 56;
      testingWhat = "basic isPresent test";
      expectedBool = true;
      actualBool = bst1.isPresent(23);
      testResults = (expectedBool == actualBool) ? PASSED_TEST : FAILED_TEST;
      System.out.println(formattedTestResults(testNum, testingWhat, testResults));

      testNum = 57;
      testingWhat = "basic isPresent test when not present";
      expectedBool = false;
      actualBool = bst1.isPresent(24);
      testResults = (expectedBool == actualBool) ? PASSED_TEST : FAILED_TEST;
      System.out.println(formattedTestResults(testNum, testingWhat, testResults));

      testNum = 58;
      testingWhat = "isPresent over whole tree";
      passed = true;
      for (int i = 0; i < doubleList.size() && passed; i++) {
         passed = bst2.isPresent(doubleList.get(i));
      }
      testResults = (passed) ? PASSED_TEST : FAILED_TEST;
      System.out.println(formattedTestResults(testNum, testingWhat, testResults));

      testNum = 59;
      testingWhat = "min";
      expectedInt = 1;
      actualInt = bst1.min();
      testResults = (expectedInt == actualInt) ? PASSED_TEST : FAILED_TEST;
      System.out.println(formattedTestResults(testNum, testingWhat, testResults));

      testNum = 60;
      testingWhat = "max";
      expectedInt = 35;
      actualInt = bst1.max();
      testResults = (expectedInt == actualInt) ? PASSED_TEST : FAILED_TEST;
      System.out.println(formattedTestResults(testNum, testingWhat, testResults));

      testNum = 59;
      testingWhat = "min";
      testResults = bst2.min().equals(doubleList.get(0)) ? PASSED_TEST : FAILED_TEST;
      System.out.println(formattedTestResults(testNum, testingWhat, testResults));

      testNum = 60;
      testingWhat = "max";
      testResults = bst2.max().equals(doubleList.get(doubleList.size() - 1)) ? PASSED_TEST : FAILED_TEST;
      System.out.println(formattedTestResults(testNum, testingWhat, testResults));

      testNum = 77;
      testingWhat = "numNodesAtDepth()";
      expectedInt = 1;
      actualInt = bst1.numNodesAtDepth(0);
      testResults = (expectedInt == actualInt) ? PASSED_TEST : FAILED_TEST;
      System.out.println(formattedTestResults(testNum, testingWhat, testResults));

      testNum = 78;
      testingWhat = "numNodesAtDepth()";
      expectedInt = 2;
      actualInt = bst1.numNodesAtDepth(1);
      testResults = (expectedInt == actualInt) ? PASSED_TEST : FAILED_TEST;
      System.out.println(formattedTestResults(testNum, testingWhat, testResults));

      testNum = 79;
      testingWhat = "numNodesAtDepth()";
      expectedInt = 0;
      actualInt = bst1.numNodesAtDepth(-1);
      testResults = (expectedInt == actualInt) ? PASSED_TEST : FAILED_TEST;
      System.out.println(formattedTestResults(testNum, testingWhat, testResults));

      testNum = 61;
      testingWhat = "test of remove() boolean return";
      expectedBool = true;
      actualBool = bst1.remove(11);
      testResults = (expectedBool == actualBool) ? PASSED_TEST : FAILED_TEST;
      System.out.println(formattedTestResults(testNum, testingWhat, testResults));

      testNum = 40;
      testingWhat = "proper sizes after remove";
      testResults = (bst1.size() == bst1.getAll().size()) ? PASSED_TEST : FAILED_TEST;
      System.out.println(formattedTestResults(testNum, testingWhat, testResults));

      testNum = 62;
      testingWhat = "test of remove() boolean return";
      expectedBool = true;
      actualBool = bst1.remove(32);
      testResults = (expectedBool == actualBool) ? PASSED_TEST : FAILED_TEST;
      System.out.println(formattedTestResults(testNum, testingWhat, testResults));

      testNum = 39;
      testingWhat = "proper sizes after remove";
      testResults = (bst1.size() == bst1.getAll().size()) ? PASSED_TEST : FAILED_TEST;
      System.out.println(formattedTestResults(testNum, testingWhat, testResults));

      testNum = 63;
      testingWhat = "test of remove() boolean return";
      expectedBool = false;
      actualBool = bst1.remove(32);
      testResults = (expectedBool == actualBool) ? PASSED_TEST : FAILED_TEST;
      System.out.println(formattedTestResults(testNum, testingWhat, testResults));

      testNum = 85;
      testingWhat = "getAllLessThan(5)";
      expectedString = "[1, 2, 3, 4]";
      actualString = bst1.getAllLessThan(5).toString();
      testResults = (actualString.equals(expectedString)) ? PASSED_TEST : FAILED_TEST;
      System.out.println(formattedTestResults(testNum, testingWhat, testResults));

      testNum = 86;
      testingWhat = "getAllLessThan(300)";
      expectedString = bst1.getAll().toString();
      actualString = bst1.getAllLessThan(300).toString();
      testResults = (actualString.equals(expectedString)) ? PASSED_TEST : FAILED_TEST;
      System.out.println(formattedTestResults(testNum, testingWhat, testResults));

      testNum = 88;
      testingWhat = "getAllGreaterThan(5)";
      expectedString = "[10, 23, 25, 26, 34, 35]";
      actualString = bst1.getAllGreaterThan(5).toString();
      testResults = (actualString.equals(expectedString)) ? PASSED_TEST : FAILED_TEST;
      System.out.println(formattedTestResults(testNum, testingWhat, testResults));

      testNum = 89;
      testingWhat = "getAllLessThan(-1)";
      expectedString = bst1.getAll().toString();
      actualString = bst1.getAllGreaterThan(-1).toString();
      testResults = (actualString.equals(expectedString)) ? PASSED_TEST : FAILED_TEST;
      System.out.println(formattedTestResults(testNum, testingWhat, testResults));

      testNum = 38;
      testingWhat = "proper sizes after remove";
      testResults = (bst1.size() == bst1.getAll().size()) ? PASSED_TEST : FAILED_TEST;
      System.out.println(formattedTestResults(testNum, testingWhat, testResults));

      testNum = 86;
      testingWhat = "getAllLessThan() at totally random values";
      passed = true;
      for (int i = 0; i < 50 && passed; i++) {
         int index = rand.nextInt(doubleList.size());
         double val = doubleList.get(index);
         passed = (bst2.getAllLessThan(val).equals(doubleList.subList(0, index)));
      }
      testResults = (passed) ? PASSED_TEST : FAILED_TEST;
      System.out.println(formattedTestResults(testNum, testingWhat, testResults));

      testNum = 82;
      testingWhat = "getAllGreaterThan() at totally random values";
      passed = true;
      for (int i = 0; i < 50 && passed; i++) {
         int index = rand.nextInt(doubleList.size());
         double val = doubleList.get(index);
         passed = (bst2.getAllGreaterThan(val).equals(doubleList.subList(index + 1, doubleList.size())));
      }
      testResults = (passed) ? PASSED_TEST : FAILED_TEST;
      System.out.println(formattedTestResults(testNum, testingWhat, testResults));

      testNum = 64;
      testingWhat = "random remove() over tree";
      passed = true;
      for (int i = 0; i < 500 && passed; i++) {
         int index = rand.nextInt(doubleList.size());
         double removeVal = doubleList.remove(index);
         //System.out.println("Removing the following value from bst2: " + removeVal);
         passed = bst2.remove(removeVal);
      }
      testResults = (passed) ? PASSED_TEST : FAILED_TEST;
      System.out.println(formattedTestResults(testNum, testingWhat, testResults));

      testNum = 65;
      testingWhat = "isPresent over whole tree after random remove()";
      passed = true;
      for (int i = 0; i < bst2.size() && passed; i++) {
         passed = bst2.isPresent(doubleList.get(i));
      }
      testResults = (passed) ? PASSED_TEST : FAILED_TEST;
      System.out.println(formattedTestResults(testNum, testingWhat, testResults));

      testNum = 66;
      testingWhat = "getAll on tree after random remove()";
      testResults = (doubleList.equals(bst2.getAll())) ? PASSED_TEST : FAILED_TEST;
      System.out.println(formattedTestResults(testNum, testingWhat, testResults));
   }

   private static ArrayList<Double> getRandomList(int maxVals) {
      ArrayList<Double> list = new ArrayList<>();
      Random rand = new Random();

      while (list.size() < maxVals) {
         list.add(rand.nextDouble() * 1000);
      }

      return list;
   }

   private static String formattedTestResults(int testNum, String testingWhat, String testResults) {
      return String.format(TEST_FORMATTING, "Test ", testNum, DIVIDER, testingWhat, DIVIDER, testResults);
   }
}
