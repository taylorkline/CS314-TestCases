/**
 * A tester for a6-LinkedList
 * @author Taylor Kline
 */

import java.util.ArrayList;
import java.util.Iterator;

public class LinkedListTester3 {
   private static final String FAILED_TEST = "******FAILED******";
   private static final String PASSED_TEST = "passed";
   private static final String DIVIDER = " | ";
   private static final String TEST_FORMATTING = "%-5s%-2d%-3s%-60s%-3s%-10s";

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
      LinkedList<Character> charList1 = new LinkedList<>();
      LinkedList<String> stringList1 = new LinkedList<>();
      LinkedList<String> stringList2 = new LinkedList<>();
      ArrayList<String> tmpStringList1 = new ArrayList<>();
      Iterator<String> stringListIterator;

      //test variables
      int testNum;
      String testingWhat;
      String testResults;

      testNum = 1;
      testingWhat = "equals method - Character and String list, empty";
      expectedBool = true;
      actualBool = charList1.equals(stringList1);
      testResults = (actualBool == expectedBool) ? PASSED_TEST : FAILED_TEST;
      System.out.println(formattedTestResults(testNum, testingWhat, testResults));

      stringList1.add("s");
      charList1.add('s');
      testNum = 2;
      testingWhat = "equals method - Character and String list, same elements";
      expectedBool = false;
      actualBool = charList1.equals(stringList1);
      testResults = (actualBool == expectedBool) ? PASSED_TEST : FAILED_TEST;
      System.out.println(formattedTestResults(testNum, testingWhat, testResults));

      testNum = 3;
      testingWhat = "size - 1 element";
      expectedInt = 1;
      actualInt = stringList1.size();
      testResults = (expectedInt == actualInt) ? PASSED_TEST : FAILED_TEST;
      System.out.println(formattedTestResults(testNum, testingWhat, testResults));

      testNum = 4;
      testingWhat = "size - 1 element";
      expectedInt = 1;
      actualInt = charList1.size();
      testResults = (expectedInt == actualInt) ? PASSED_TEST : FAILED_TEST;
      System.out.println(formattedTestResults(testNum, testingWhat, testResults));

      stringList2.add("S");
      testNum = 5;
      testingWhat = "equals method - String and String list, different elements";
      expectedBool = false;
      actualBool = stringList2.equals(stringList1);
      testResults = (actualBool == expectedBool) ? PASSED_TEST : FAILED_TEST;
      System.out.println(formattedTestResults(testNum, testingWhat, testResults));

      stringList2.makeEmpty();
      testNum = 6;
      testingWhat = "size - after makeEmpty()";
      expectedInt = 0;
      actualInt = stringList2.size();
      testResults = (expectedInt == actualInt) ? PASSED_TEST : FAILED_TEST;
      System.out.println(formattedTestResults(testNum, testingWhat, testResults));

      stringList2.add("s");
      testNum = 7;
      testingWhat = "equals method - String and String list, same elements";
      expectedBool = true;
      actualBool = stringList2.equals(stringList1);
      testResults = (actualBool == expectedBool) ? PASSED_TEST : FAILED_TEST;
      System.out.println(formattedTestResults(testNum, testingWhat, testResults));

      stringList1.addFirst("S");
      stringList1.addLast("Z");
      testNum = 8;
      testingWhat = "addFirst and addLast";
      expectedString = "[S, s, Z]";
      actualString = stringList1.toString();
      testResults = (expectedString.equals(actualString)) ? PASSED_TEST : FAILED_TEST;
      System.out.println(formattedTestResults(testNum, testingWhat, testResults));

      stringList1.set(0, "W");
      stringList1.set(2, "X");
      testNum = 9;
      testingWhat = "set";
      expectedString = "[W, s, X]";
      actualString = stringList1.toString();
      testResults = (expectedString.equals(actualString)) ? PASSED_TEST : FAILED_TEST;
      System.out.println(formattedTestResults(testNum, testingWhat, testResults));

      stringList1.set(0, "W");
      stringList1.set(2, "X");
      testNum = 10;
      testingWhat = "set";
      expectedString = "[W, s, X]";
      actualString = stringList1.toString();
      testResults = (expectedString.equals(actualString)) ? PASSED_TEST : FAILED_TEST;
      System.out.println(formattedTestResults(testNum, testingWhat, testResults));

      stringList2 = (LinkedList<String>) stringList1.getSubList(0, 0);
      testNum = 11;
      testingWhat = "getSubList - same start, stop";
      expectedString = "[]";
      actualString = stringList2.toString();
      testResults = (expectedString.equals(actualString)) ? PASSED_TEST : FAILED_TEST;
      System.out.println(formattedTestResults(testNum, testingWhat, testResults));

      stringList2 = (LinkedList<String>) stringList1.getSubList(0, 3);
      testNum = 12;
      testingWhat = "getSubList - entire list";
      expectedString = "[W, s, X]";
      actualString = stringList2.toString();
      testResults = (expectedString.equals(actualString)) ? PASSED_TEST : FAILED_TEST;
      System.out.println(formattedTestResults(testNum, testingWhat, testResults));

      stringList2 = (LinkedList<String>) stringList1.getSubList(2, 3);
      testNum = 13;
      testingWhat = "getSubList - last element in list";
      expectedString = "[X]";
      actualString = stringList2.toString();
      testResults = (expectedString.equals(actualString)) ? PASSED_TEST : FAILED_TEST;
      System.out.println(formattedTestResults(testNum, testingWhat, testResults));

      stringList2.makeEmpty();

      for (String s : stringList2) {
         tmpStringList1.add(s);
      }
      testNum = 14;
      testingWhat = "iterator - implicit iteration over empty list";
      expectedString = "[]";
      actualString = tmpStringList1.toString();
      testResults = (expectedString.equals(actualString)) ? PASSED_TEST : FAILED_TEST;
      System.out.println(formattedTestResults(testNum, testingWhat, testResults));

      for (String s : stringList1) {
         tmpStringList1.add(s);
      }
      testNum = 15;
      testingWhat = "iterator - implicit iteration over full list";
      expectedString = "[W, s, X]";
      actualString = tmpStringList1.toString();
      testResults = (expectedString.equals(actualString)) ? PASSED_TEST : FAILED_TEST;
      System.out.println(formattedTestResults(testNum, testingWhat, testResults));

      tmpStringList1.clear();
      for (int i = stringList1.size() - 1; i >= 0; i--) {
         tmpStringList1.add(stringList1.get(i));
      }
      testNum = 16;
      testingWhat = "get()";
      expectedString = "[X, s, W]";
      actualString = tmpStringList1.toString();
      testResults = (expectedString.equals(actualString)) ? PASSED_TEST : FAILED_TEST;
      System.out.println(formattedTestResults(testNum, testingWhat, testResults));

      stringListIterator = stringList1.iterator();
      stringListIterator.next();
      stringListIterator.remove();
      testNum = 17;
      testingWhat = "iterator remove";
      expectedString = "[s, X]";
      actualString = stringList1.toString();
      testResults = (expectedString.equals(actualString)) ? PASSED_TEST : FAILED_TEST;
      System.out.println(formattedTestResults(testNum, testingWhat, testResults));

      testNum = 18;
      testingWhat = "size() after iterator remove";
      expectedInt = 2;
      actualInt = stringList1.size();
      testResults = (expectedInt == actualInt) ? PASSED_TEST : FAILED_TEST;
      System.out.println(formattedTestResults(testNum, testingWhat, testResults));

      stringListIterator.next();
      stringListIterator.remove();
      stringListIterator.next();
      stringListIterator.remove();
      testNum = 19;
      testingWhat = "iterator remove to empty";
      expectedString = "[]";
      actualString = stringList1.toString();
      testResults = (expectedString.equals(actualString)) ? PASSED_TEST : FAILED_TEST;
      System.out.println(formattedTestResults(testNum, testingWhat, testResults));

      testNum = 20;
      testingWhat = "size() after iterator remove all elements";
      expectedInt = 0;
      actualInt = stringList1.size();
      testResults = (expectedInt == actualInt) ? PASSED_TEST : FAILED_TEST;
      System.out.println(formattedTestResults(testNum, testingWhat, testResults));

      stringList1.add("X");
      stringList1.add("w");
      stringList1.addLast("Q");
      testNum = 21;
      testingWhat = "indexOf an item";
      expectedInt = 0;
      actualInt = stringList1.indexOf("X");
      testResults = (expectedInt == actualInt) ? PASSED_TEST : FAILED_TEST;
      System.out.println(formattedTestResults(testNum, testingWhat, testResults));

      testNum = 22;
      testingWhat = "indexOf an item";
      expectedInt = 2;
      actualInt = stringList1.indexOf("Q");
      testResults = (expectedInt == actualInt) ? PASSED_TEST : FAILED_TEST;
      System.out.println(formattedTestResults(testNum, testingWhat, testResults));

      testNum = 23;
      testingWhat = "indexOf an item in a range that does contain it";
      expectedInt = 1;
      actualInt = stringList1.indexOf("w", 1);
      testResults = (expectedInt == actualInt) ? PASSED_TEST : FAILED_TEST;
      System.out.println(formattedTestResults(testNum, testingWhat, testResults));

      testNum = 24;
      testingWhat = "indexOf an item in a range that doesn't contain it";
      expectedInt = -1;
      actualInt = stringList1.indexOf("w", 2);
      testResults = (expectedInt == actualInt) ? PASSED_TEST : FAILED_TEST;
      System.out.println(formattedTestResults(testNum, testingWhat, testResults));

      stringList1.insert(0, "z");
      stringList1.insert(3, "M");
      stringList1.insert(5, "P");
      testNum = 25;
      testingWhat = "several inserts";
      expectedString = "[z, X, w, M, Q, P]";
      actualString = stringList1.toString();
      testResults = (expectedString.equals(actualString)) ? PASSED_TEST : FAILED_TEST;
      System.out.println(formattedTestResults(testNum, testingWhat, testResults));

      testNum = 26;
      testingWhat = "size() after inserts";
      expectedInt = 6;
      actualInt = stringList1.size();
      testResults = (expectedInt == actualInt) ? PASSED_TEST : FAILED_TEST;
      System.out.println(formattedTestResults(testNum, testingWhat, testResults));

      stringList1.add("\\m\\{o\\p");
      testNum = 27;
      testingWhat = "remove(\"\\m\\{o\\p\")";
      expectedBool = true;
      actualBool = stringList1.remove("\\m\\{o\\p");
      expectedString = "[z, X, w, M, Q, P]";
      actualString = stringList1.toString();
      testResults = (expectedString.equals(actualString) && expectedBool == actualBool)
         ? PASSED_TEST : FAILED_TEST;
      System.out.println(formattedTestResults(testNum, testingWhat, testResults));

      testNum = 28;
      testingWhat = "remove(\"P\")";
      expectedBool = true;
      actualBool = stringList1.remove("P");
      expectedString = "[z, X, w, M, Q]";
      actualString = stringList1.toString();
      testResults = (expectedString.equals(actualString) && expectedBool == actualBool)
         ? PASSED_TEST : FAILED_TEST;
      System.out.println(formattedTestResults(testNum, testingWhat, testResults));

      stringList2.makeEmpty();
      stringList2.add(stringList1.remove(4));
      stringList2.add(stringList1.remove(2));
      stringList2.add(stringList1.removeFirst());
      stringList2.add(stringList1.removeLast());

      testNum = 29;
      testingWhat = "removeFirst, removeLast, remove(pos)";
      expectedString = "[Q, w, z, M]";
      actualString = stringList2.toString();
      testResults = (expectedString.equals(actualString)) ? PASSED_TEST : FAILED_TEST;
      System.out.println(formattedTestResults(testNum, testingWhat, testResults));

      stringList2.removeRange(0, 0);
      testNum = 30;
      testingWhat = "removeRange(start, stop)";
      expectedString = "[Q, w, z, M]";
      actualString = stringList2.toString();
      testResults = (expectedString.equals(actualString)) ? PASSED_TEST : FAILED_TEST;
      System.out.println(formattedTestResults(testNum, testingWhat, testResults));

      stringList2.removeRange(0, stringList2.size());
      testNum = 31;
      testingWhat = "removeRange(start, stop)";
      expectedString = "[]";
      actualString = stringList2.toString();
      testResults = (expectedString.equals(actualString)) ? PASSED_TEST : FAILED_TEST;
      System.out.println(formattedTestResults(testNum, testingWhat, testResults));

      testNum = 32;
      testingWhat = "size() after removes";
      expectedInt = 1;
      actualInt = stringList1.size();
      testResults = (expectedInt == actualInt) ? PASSED_TEST : FAILED_TEST;
      System.out.println(formattedTestResults(testNum, testingWhat, testResults));

      testNum = 33;
      testingWhat = "size() after removes";
      expectedInt = 0;
      actualInt = stringList2.size();
      testResults = (expectedInt == actualInt) ? PASSED_TEST : FAILED_TEST;
      System.out.println(formattedTestResults(testNum, testingWhat, testResults));

      charList1.add('Q');
      charList1.add('P');
      charList1.add('m');
      charList1.set(charList1.size() - 1, 'n');
      testNum = 34;
      testingWhat = "set";
      expectedString = "[s, Q, P, n]";
      actualString = charList1.toString();
      testResults = (expectedString.equals(actualString)) ? PASSED_TEST : FAILED_TEST;
      System.out.println(formattedTestResults(testNum, testingWhat, testResults));

      charList1.set(0, 'W');
      testNum = 35;
      testingWhat = "set";
      expectedString = "[W, Q, P, n]";
      actualString = charList1.toString();
      testResults = (expectedString.equals(actualString)) ? PASSED_TEST : FAILED_TEST;
      System.out.println(formattedTestResults(testNum, testingWhat, testResults));
   }

   private static String formattedTestResults(int testNum, String testingWhat, String testResults) {
      return String.format(TEST_FORMATTING, "Test ", testNum, DIVIDER, testingWhat, DIVIDER, testResults);
   }
}