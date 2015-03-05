/**
 * A tester for EvilHangman
 * @author Taylor Kline
 */

import java.util.*;
public class SimpleHangmanTester {
   private static final String FAILED_TEST = "******FAILED******";
   private static final String PASSED_TEST = "passed";
   private static final String DIVIDER = " | ";
   private static final String TEST_FORMATTING = "%-5s%-2d%-3s%-70s%-3s%-10s";

   public static void main(String[] args) {
      System.out.println("Hello!\n");

      testHardDifficulty();

      testMediumDifficulty();

      testEasyDifficulty();
   }

   private static void testEasyDifficulty() {
      System.out.println("\nTesting easy difficulty.");

      //testing variables
      HangmanManager hm;
      int wordLength;
      int numGuesses;
      HangmanDifficulty hDiff;
      List<String> dictionary = new ArrayList<>();
      String expectedString;
      String actualString;
      boolean expectedBool;
      boolean actualBool;
      int expectedInt;
      int actualInt;

      //variables for test results
      String testingWhat;
      String testResults;
      int testNum;

      //initiate the testing environment for HangmanManager
      dictionary.add("beer");
      dictionary.add("buzz");
      dictionary.add("bare");
      dictionary.add("bake");
      dictionary.add("bell");
      dictionary.add("belt");
      dictionary.add("able");
      dictionary.add("aber");
      hm = new HangmanManager(dictionary);
      hDiff = HangmanDifficulty.MEDIUM;
      wordLength = 8;
      numGuesses = 18;
      hm.prepForRound(wordLength, numGuesses, hDiff);

      System.out.println("\nTesting prepForRound resets all variables");
      hDiff = HangmanDifficulty.EASY;
      wordLength = 4;
      numGuesses = 20;
      hm.prepForRound(wordLength, numGuesses, hDiff);

      testNum = 1;
      testingWhat = "Initial value of getGuessesLeft()";
      expectedInt = numGuesses;
      actualInt = hm.getGuessesLeft();
      testResults = (expectedInt == actualInt) ? PASSED_TEST : FAILED_TEST;
      System.out.println(formattedTestResults(testNum, testingWhat, testResults));

      testNum = 2;
      testingWhat = "Initial pattern from getPattern()";
      expectedString = "----";
      actualString = hm.getPattern();
      testResults = (actualString.equals(expectedString)) ? PASSED_TEST : FAILED_TEST;
      System.out.println(formattedTestResults(testNum, testingWhat, testResults));

      testNum = 3;
      testingWhat = "Initial String from getGuessesMade()";
      expectedString = "[]";
      actualString = hm.getGuessesMade();
      testResults = (actualString.equals(expectedString)) ? PASSED_TEST : FAILED_TEST;
      System.out.println(formattedTestResults(testNum, testingWhat, testResults));

      testNum = 4;
      testingWhat = "numWords(4)";
      expectedInt = 8;
      actualInt = hm.numWords(4);
      testResults = (expectedInt == actualInt) ? PASSED_TEST : FAILED_TEST;
      System.out.println(formattedTestResults(testNum, testingWhat, testResults));

      testNum = 5;
      testingWhat = "Initial result of numWordsCurrent()";
      expectedInt = 8;
      actualInt = hm.numWordsCurrent();
      testResults = (expectedInt == actualInt) ? PASSED_TEST : FAILED_TEST;
      System.out.println(formattedTestResults(testNum, testingWhat, testResults));

      char[] badGuesses = new char[]{'c'};

      System.out.println("\nMaking " + badGuesses.length + " bad guesses");
      for (char eachGuess : badGuesses) {
         hm.makeGuess(eachGuess);
      }

      System.out.println("Making a good guess, should get the easier pattern");
      hm.makeGuess('b');

      testNum = 6;
      testingWhat = "value of getGuessesLeft()";
      expectedInt = numGuesses - badGuesses.length;
      actualInt = hm.getGuessesLeft();
      testResults = (expectedInt == actualInt) ? PASSED_TEST : FAILED_TEST;
      System.out.println(formattedTestResults(testNum, testingWhat, testResults));

      testNum = 7;
      testingWhat = "New pattern from getPattern()";
      expectedString = "-b--";
      actualString = hm.getPattern();
      testResults = (actualString.equals(expectedString)) ? PASSED_TEST : FAILED_TEST;
      System.out.println(formattedTestResults(testNum, testingWhat, testResults));

      testNum = 8;
      testingWhat = "New result of numWordsCurrent()";
      expectedInt = 2;
      actualInt = hm.numWordsCurrent();
      testResults = (expectedInt == actualInt) ? PASSED_TEST : FAILED_TEST;
      System.out.println(formattedTestResults(testNum, testingWhat, testResults));

      badGuesses = new char[]{'y', 't', 'u'};

      System.out.println("\nMaking " + badGuesses.length + " bad guesses");
      for (char eachGuess : badGuesses) {
         hm.makeGuess(eachGuess);
      }

      System.out.println("Making a good guess, there is only the 'hard' pattern");
      hm.makeGuess('a');

      testNum = 9;
      testingWhat = "New pattern from getPattern()";
      expectedString = "ab--";
      actualString = hm.getPattern();
      testResults = (actualString.equals(expectedString)) ? PASSED_TEST : FAILED_TEST;
      System.out.println(formattedTestResults(testNum, testingWhat, testResults));

      testNum = 10;
      testingWhat = "New result of numWordsCurrent()";
      expectedInt = 2;
      actualInt = hm.numWordsCurrent();
      testResults = (expectedInt == actualInt) ? PASSED_TEST : FAILED_TEST;
      System.out.println(formattedTestResults(testNum, testingWhat, testResults));
   }

   private static void testMediumDifficulty() {
      System.out.println("\nTesting medium difficulty.");

      //testing variables
      HangmanManager hm;
      int wordLength;
      int numGuesses;
      HangmanDifficulty hDiff;
      List<String> dictionary = new ArrayList<>();
      String expectedString;
      String actualString;
      boolean expectedBool;
      boolean actualBool;
      int expectedInt;
      int actualInt;

      //variables for test results
      String testingWhat;
      String testResults;
      int testNum;

      //initiate the testing environment for HangmanManager
      dictionary.add("beer");
      dictionary.add("buzz");
      dictionary.add("bare");
      dictionary.add("bake");
      dictionary.add("bell");
      dictionary.add("belt");
      dictionary.add("able");
      dictionary.add("aber");
      hDiff = HangmanDifficulty.MEDIUM;
      wordLength = 4;
      numGuesses = 20;
      hm = new HangmanManager(dictionary);
      hm.prepForRound(wordLength, numGuesses, hDiff);

      char[] badGuesses = new char[]{'c', 'd', 'f', 'w', 'q', 'p', 'm'};

      System.out.println("\nMaking " + badGuesses.length + " bad guesses");
      for (char eachGuess : badGuesses) {
         hm.makeGuess(eachGuess);
      }

      System.out.println("Making a good guess, should get the easier pattern");
      hm.makeGuess('b');

      testNum = 1;
      testingWhat = "value of getGuessesLeft()";
      expectedInt = numGuesses - badGuesses.length;
      actualInt = hm.getGuessesLeft();
      testResults = (expectedInt == actualInt) ? PASSED_TEST : FAILED_TEST;
      System.out.println(formattedTestResults(testNum, testingWhat, testResults));

      testNum = 2;
      testingWhat = "New pattern from getPattern()";
      expectedString = "-b--";
      actualString = hm.getPattern();
      testResults = (actualString.equals(expectedString)) ? PASSED_TEST : FAILED_TEST;
      System.out.println(formattedTestResults(testNum, testingWhat, testResults));

      testNum = 3;
      testingWhat = "New result of numWordsCurrent()";
      expectedInt = 2;
      actualInt = hm.numWordsCurrent();
      testResults = (expectedInt == actualInt) ? PASSED_TEST : FAILED_TEST;
      System.out.println(formattedTestResults(testNum, testingWhat, testResults));

      badGuesses = new char[]{'y', 't', 'u'};

      System.out.println("\nMaking " + badGuesses.length + " bad guesses");
      for (char eachGuess : badGuesses) {
         hm.makeGuess(eachGuess);
      }

      System.out.println("Making a good guess, there is only the 'hard' pattern");
      hm.makeGuess('a');

      testNum = 4;
      testingWhat = "New pattern from getPattern()";
      expectedString = "ab--";
      actualString = hm.getPattern();
      testResults = (actualString.equals(expectedString)) ? PASSED_TEST : FAILED_TEST;
      System.out.println(formattedTestResults(testNum, testingWhat, testResults));

      testNum = 5;
      testingWhat = "New result of numWordsCurrent()";
      expectedInt = 2;
      actualInt = hm.numWordsCurrent();
      testResults = (expectedInt == actualInt) ? PASSED_TEST : FAILED_TEST;
      System.out.println(formattedTestResults(testNum, testingWhat, testResults));
   }

   private static void testHardDifficulty() {
      System.out.println("Testing hard difficulty.\n");

      //testing variables
      HangmanManager hm;
      int wordLength;
      int numGuesses;
      HangmanDifficulty hDiff;
      List<String> dictionary = new ArrayList<>();
      String expectedString;
      String actualString;
      boolean expectedBool;
      boolean actualBool;
      int expectedInt;
      int actualInt;

      //variables for test results
      String testingWhat;
      String testResults;
      int testNum;

      //initiate the testing environment for HangmanManager
      dictionary.add("beer");
      dictionary.add("buzz");
      dictionary.add("bare");
      dictionary.add("bake");
      dictionary.add("bell");
      dictionary.add("belt");
      dictionary.add("able");
      hDiff = HangmanDifficulty.HARD;
      wordLength = 4;
      numGuesses = 20;
      hm = new HangmanManager(dictionary);
      hm.prepForRound(wordLength, numGuesses, hDiff);

      testNum = 1;
      testingWhat = "Initial value of getGuessesLeft()";
      expectedInt = numGuesses;
      actualInt = hm.getGuessesLeft();
      testResults = (expectedInt == actualInt) ? PASSED_TEST : FAILED_TEST;
      System.out.println(formattedTestResults(testNum, testingWhat, testResults));

      testNum = 2;
      testingWhat = "Initial pattern from getPattern()";
      expectedString = "----";
      actualString = hm.getPattern();
      testResults = (actualString.equals(expectedString)) ? PASSED_TEST : FAILED_TEST;
      System.out.println(formattedTestResults(testNum, testingWhat, testResults));

      testNum = 3;
      testingWhat = "Initial String from getGuessesMade()";
      expectedString = "[]";
      actualString = hm.getGuessesMade();
      testResults = (actualString.equals(expectedString)) ? PASSED_TEST : FAILED_TEST;
      System.out.println(formattedTestResults(testNum, testingWhat, testResults));

      testNum = 4;
      testingWhat = "numWords(4)";
      expectedInt = 7;
      actualInt = hm.numWords(4);
      testResults = (expectedInt == actualInt) ? PASSED_TEST : FAILED_TEST;
      System.out.println(formattedTestResults(testNum, testingWhat, testResults));

      testNum = 5;
      testingWhat = "Initial result of numWordsCurrent()";
      expectedInt = 7;
      actualInt = hm.numWordsCurrent();
      testResults = (expectedInt == actualInt) ? PASSED_TEST : FAILED_TEST;
      System.out.println(formattedTestResults(testNum, testingWhat, testResults));

      //make a guess
      System.out.println("\nMaking a correct guess with clear winner.");
      hm.makeGuess('b');

      testNum = 6;
      testingWhat = "New value of getGuessesLeft() - shouldn't change after correct guess";
      expectedInt = numGuesses;
      actualInt = hm.getGuessesLeft();
      testResults = (expectedInt == actualInt) ? PASSED_TEST : FAILED_TEST;
      System.out.println(formattedTestResults(testNum, testingWhat, testResults));

      testNum = 7;
      testingWhat = "New pattern from getPattern()";
      expectedString = "b---";
      actualString = hm.getPattern();
      testResults = (actualString.equals(expectedString)) ? PASSED_TEST : FAILED_TEST;
      System.out.println(formattedTestResults(testNum, testingWhat, testResults));

      testNum = 8;
      testingWhat = "New String from getGuessesMade()";
      expectedString = "[b]";
      actualString = hm.getGuessesMade();
      testResults = (actualString.equals(expectedString)) ? PASSED_TEST : FAILED_TEST;
      System.out.println(formattedTestResults(testNum, testingWhat, testResults));

      testNum = 9;
      testingWhat = "New result of numWordsCurrent()";
      expectedInt = 6;
      actualInt = hm.numWordsCurrent();
      testResults = (expectedInt == actualInt) ? PASSED_TEST : FAILED_TEST;
      System.out.println(formattedTestResults(testNum, testingWhat, testResults));

      testNum = 10;
      testingWhat = "alreadyGuessed('b') is true";
      expectedBool = true;
      actualBool = hm.alreadyGuessed('b');
      testResults = (expectedBool == actualBool) ? PASSED_TEST : FAILED_TEST;
      System.out.println(formattedTestResults(testNum, testingWhat, testResults));

      //make another guess
      System.out.println("\nMaking an incorrect guess.");
      hm.makeGuess('c');

      testNum = 11;
      testingWhat = "getGuessesLeft()";
      expectedInt = numGuesses - 1;
      actualInt = hm.getGuessesLeft();
      testResults = (expectedInt == actualInt) ? PASSED_TEST : FAILED_TEST;
      System.out.println(formattedTestResults(testNum, testingWhat, testResults));

      testNum = 12;
      testingWhat = "New pattern from getPattern()";
      expectedString = "b---";
      actualString = hm.getPattern();
      testResults = (actualString.equals(expectedString)) ? PASSED_TEST : FAILED_TEST;
      System.out.println(formattedTestResults(testNum, testingWhat, testResults));

      testNum = 13;
      testingWhat = "New String from getGuessesMade()";
      expectedString = "[b, c]";
      actualString = hm.getGuessesMade();
      testResults = (actualString.equals(expectedString)) ? PASSED_TEST : FAILED_TEST;
      System.out.println(formattedTestResults(testNum, testingWhat, testResults));

      testNum = 14;
      testingWhat = "Same result of numWordsCurrent()";
      expectedInt = 6;
      actualInt = hm.numWordsCurrent();
      testResults = (expectedInt == actualInt) ? PASSED_TEST : FAILED_TEST;
      System.out.println(formattedTestResults(testNum, testingWhat, testResults));

      testNum = 15;
      testingWhat = "alreadyGuessed('a') is false";
      expectedBool = false;
      actualBool = hm.alreadyGuessed('a');
      testResults = (expectedBool == actualBool) ? PASSED_TEST : FAILED_TEST;
      System.out.println(formattedTestResults(testNum, testingWhat, testResults));

      //make a guess
      System.out.println("\nMaking a correct guess with tie in family with max elements - tie in revealing fewest chars - choice should be lowest ASCIIbetical order.");
      hm.makeGuess('e');

      testNum = 16;
      testingWhat = "New value of getGuessesLeft()";
      expectedInt = numGuesses - 1;
      actualInt = hm.getGuessesLeft();
      testResults = (expectedInt == actualInt) ? PASSED_TEST : FAILED_TEST;
      System.out.println(formattedTestResults(testNum, testingWhat, testResults));

      testNum = 17;
      testingWhat = "New pattern from getPattern()";
      expectedString = "b--e";
      actualString = hm.getPattern();
      testResults = (actualString.equals(expectedString)) ? PASSED_TEST : FAILED_TEST;
      System.out.println(formattedTestResults(testNum, testingWhat, testResults));

      testNum = 18;
      testingWhat = "New String from getGuessesMade()";
      expectedString = "[b, c, e]";
      actualString = hm.getGuessesMade();
      testResults = (actualString.equals(expectedString)) ? PASSED_TEST : FAILED_TEST;
      System.out.println(formattedTestResults(testNum, testingWhat, testResults));

      testNum = 19;
      testingWhat = "New result of numWordsCurrent()";
      expectedInt = 2;
      actualInt = hm.numWordsCurrent();
      testResults = (expectedInt == actualInt) ? PASSED_TEST : FAILED_TEST;
      System.out.println(formattedTestResults(testNum, testingWhat, testResults));

      //make a guess
      System.out.println("\nMaking a correct guess where all current words match guess");
      hm.makeGuess('a');

      testNum = 20;
      testingWhat = "New value of getGuessesLeft()";
      expectedInt = numGuesses - 1;
      actualInt = hm.getGuessesLeft();
      testResults = (expectedInt == actualInt) ? PASSED_TEST : FAILED_TEST;
      System.out.println(formattedTestResults(testNum, testingWhat, testResults));

      testNum = 21;
      testingWhat = "New pattern from getPattern()";
      expectedString = "ba-e";
      actualString = hm.getPattern();
      testResults = (actualString.equals(expectedString)) ? PASSED_TEST : FAILED_TEST;
      System.out.println(formattedTestResults(testNum, testingWhat, testResults));

      testNum = 22;
      testingWhat = "New String from getGuessesMade()";
      expectedString = "[a, b, c, e]";
      actualString = hm.getGuessesMade();
      testResults = (actualString.equals(expectedString)) ? PASSED_TEST : FAILED_TEST;
      System.out.println(formattedTestResults(testNum, testingWhat, testResults));

      testNum = 23;
      testingWhat = "New result of numWordsCurrent()";
      expectedInt = 2;
      actualInt = hm.numWordsCurrent();
      testResults = (expectedInt == actualInt) ? PASSED_TEST : FAILED_TEST;
      System.out.println(formattedTestResults(testNum, testingWhat, testResults));

      //make a guess
      System.out.println("\nMaking a correct guess with tie in maximum elements, tie breaker on one that reveals fewest elements.");
      hm.makeGuess('k');

      testNum = 24;
      testingWhat = "New value of getGuessesLeft()";
      expectedInt = numGuesses - 2;
      actualInt = hm.getGuessesLeft();
      testResults = (expectedInt == actualInt) ? PASSED_TEST : FAILED_TEST;
      System.out.println(formattedTestResults(testNum, testingWhat, testResults));

      testNum = 25;
      testingWhat = "New pattern from getPattern()";
      expectedString = "ba-e";
      actualString = hm.getPattern();
      testResults = (actualString.equals(expectedString)) ? PASSED_TEST : FAILED_TEST;
      System.out.println(formattedTestResults(testNum, testingWhat, testResults));

      testNum = 26;
      testingWhat = "New String from getGuessesMade()";
      expectedString = "[a, b, c, e, k]";
      actualString = hm.getGuessesMade();
      testResults = (actualString.equals(expectedString)) ? PASSED_TEST : FAILED_TEST;
      System.out.println(formattedTestResults(testNum, testingWhat, testResults));

      testNum = 27;
      testingWhat = "New result of numWordsCurrent()";
      expectedInt = 1;
      actualInt = hm.numWordsCurrent();
      testResults = (expectedInt == actualInt) ? PASSED_TEST : FAILED_TEST;
      System.out.println(formattedTestResults(testNum, testingWhat, testResults));

      //make a guess
      System.out.println("\nTime to win the game.");
      hm.makeGuess('r');

      testNum = 28;
      testingWhat = "New value of getGuessesLeft()";
      expectedInt = numGuesses - 2;
      actualInt = hm.getGuessesLeft();
      testResults = (expectedInt == actualInt) ? PASSED_TEST : FAILED_TEST;
      System.out.println(formattedTestResults(testNum, testingWhat, testResults));

      testNum = 29;
      testingWhat = "New pattern from getPattern()";
      expectedString = "bare";
      actualString = hm.getPattern();
      testResults = (actualString.equals(expectedString)) ? PASSED_TEST : FAILED_TEST;
      System.out.println(formattedTestResults(testNum, testingWhat, testResults));

      testNum = 30;
      testingWhat = "New String from getGuessesMade()";
      expectedString = "[a, b, c, e, k, r]";
      actualString = hm.getGuessesMade();
      testResults = (actualString.equals(expectedString)) ? PASSED_TEST : FAILED_TEST;
      System.out.println(formattedTestResults(testNum, testingWhat, testResults));

      testNum = 31;
      testingWhat = "New result of numWordsCurrent()";
      expectedInt = 1;
      actualInt = hm.numWordsCurrent();
      testResults = (expectedInt == actualInt) ? PASSED_TEST : FAILED_TEST;
      System.out.println(formattedTestResults(testNum, testingWhat, testResults));

      testNum = 32;
      testingWhat = "result of getSecretWord()";
      expectedString = "bare";
      actualString = hm.getSecretWord();
      testResults = (actualString.equals(expectedString)) ? PASSED_TEST : FAILED_TEST;
      System.out.println(formattedTestResults(testNum, testingWhat, testResults));
   }
      private static String formattedTestResults(int testNum, String testingWhat, String testResults) {
         return String.format(TEST_FORMATTING, "Test ", testNum, DIVIDER, testingWhat, DIVIDER, testResults);
      }
}
