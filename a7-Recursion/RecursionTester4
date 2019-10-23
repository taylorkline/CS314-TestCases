/**
 * A tester for a7-Recursive
 * @author Musab Abdullah
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class RecursiveTester4 {

	// run the tests
	public static void main(String[] args) {
		studentTests();
	}

	// pre: r != null
	// post: run student test
	private static void studentTests() {
		// CS314 students put your tests here

		// test 1: getBinary
		String expected = "1111111111111111111111111111111";
		String actual = Recursive.getBinary(Integer.MAX_VALUE);
		printDebugStuff(expected.equals(actual), "binary");

		// test 2: getBinary
		expected = "-1111111111111111111111111111111";
		actual = Recursive.getBinary(Integer.MIN_VALUE + 1);
		printDebugStuff(expected.equals(actual), "binary");

		// test 3: reverseString
		expected = "";
		actual = Recursive.revString("");
		printDebugStuff(expected.equals(actual), "reverseString");

		// test 4: reverseString
		expected = "ysae siht hurB";
		actual = Recursive.revString("Bruh this easy");
		printDebugStuff(expected.equals(actual), "reverseString");

		// test 5: nextIsDouble
		int expectedInt = 1;
		int[] data = { 1, 2, 5, 11 };
		int actualInt = Recursive.nextIsDouble(data);
		printDebugStuff(expectedInt == actualInt, "nextIsDouble");

		// test 6: nextIsDouble
		expectedInt = 0;
		data = new int[] {};
		actualInt = Recursive.nextIsDouble(data);
		printDebugStuff(expectedInt == actualInt, "nextIsDouble");

		// test 7: recursiveMnemonics
		HashSet<String> expectedWords = new HashSet<>();
		String[] words = { "J1", "K1", "L1" };
		for (String w : words)
			expectedWords.add(w);
		HashSet<String> actualWords = new HashSet<>(Recursive.listMnemonics("51"));
		printDebugStuff(expectedWords.equals(actualWords), "recursiveMnemonics");

		// test 8: recursiveMnemonics
		expectedWords.clear();
		words = new String[] { "AD", "AE", "AF", "BD", "BE", "BF", "CD", "CE", "CF" };
		for (String w : words)
			expectedWords.add(w);
		actualWords = new HashSet<>(Recursive.listMnemonics("23"));
		printDebugStuff(expectedWords.equals(actualWords), "recursiveMnemonics");

		// test 9 and 10: canFlowOffMap
		int[][] map = { { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 } };
		printDebugStuff(!Recursive.canFlowOffMap(map, 1, 1), "canFlowOffMap");

		map = new int[][] { { 10, 10, 10, 10, 10 }, { 0, 1, 2, 5, 10 }, { 10, 4, 3, 2, 10 }, { 10, 5, 6, 10, 10 },
				{ 10, 10, 10, 10, 10 } };
		printDebugStuff(Recursive.canFlowOffMap(map, 3, 2), "canFlowOffMap");

		// test 11: minDifference
		int[] abilities = { 1, 2, 3, 4, 5 };
		boolean passed = Recursive.minDifference(3, abilities) == 0;
		printDebugStuff(passed, "minDifference");

		// test 12: minDifference
		abilities = new int[] { -30, 10, 10, 20, 20 };
		passed = Recursive.minDifference(2, abilities) == 10;
		printDebugStuff(passed, "minDifference");

		// test 13: canEscapeMaze
		String rawMaze = "$SGYY*G$GG$G";
		char[][] maze = makeMaze(rawMaze, 3);
		passed = Recursive.canEscapeMaze(maze) == 0;
		printDebugStuff(passed, "canEscapeMaze");

		// test 13: canEscapeMaze
		rawMaze = "S$$$$E";
		maze = makeMaze(rawMaze, 1);
		passed = Recursive.canEscapeMaze(maze) == 2;
		printDebugStuff(passed, "canEscapeMaze");
	}

	private static void printDebugStuff(boolean passed, String test) {
		if (passed) {
			System.out.println(test + " test PASSED");
		} else {
			System.out.println(test + " test FAILED");
		}
	}

}
