/*  
 * Tester for CS314 A6 - LinkedList
 * @author Keith Gibson
 * Note: there is a chance that you might fail some of the tests 
 * due to the preconditions throwing different exceptions. 
 * To fix this, change the specified test to have a reference to 
 * the type of exception you threw for that method.
 */


import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Arrays;

public class LinkedListTester4 {
	private static int testNum = 0;
	private static int testsPassed = 0;
	private static final boolean DEBUG = true;

	public static void main(String[] args) {
            
		//CS314 students. Add your tests here:

		//test 1-3
		String[] empty = {};
		basicAddGetToStringTests(empty, null);
		emptyGet();
		
		//test 4-5
		String[] oneElem = {"a"};
		basicAddGetToStringTests(oneElem, null);

		//test 6-7
		String[] someEmptyStrings = {"", "a", ""};
		basicAddGetToStringTests(someEmptyStrings, null);

		//test 8-9
		String[] containsNulls = {"a", null, ""};
		basicAddGetToStringTests(containsNulls, new IllegalArgumentException());

		//test 10-11
		String[] randomStrings = buildRandomStringArray(500, 2);
		basicAddGetToStringTests(randomStrings, null);

		//test 11-13
		sizeTest(empty);
		sizeTest(oneElem);
		sizeTest(randomStrings);

		//test 14-25
		getStressTests();

		//test 26-32
		insertTest(someEmptyStrings, 2, "newItem", null);
		insertTest(oneElem, 0, "b", null);
		insertTest(oneElem, 1, "b", null);
		insertTest(empty, 0, "test", null);
		insertTest(empty, 1, "test", new IllegalArgumentException());
		insertTest(empty, 0, null, new IllegalArgumentException());
		insertTest(oneElem, 2, "b", new IllegalArgumentException());

		//test 33-37
		setTest(someEmptyStrings, 1, "b", null);
		setTest(oneElem, 0, "b", null);
		setTest(empty, 0, "c", new IllegalArgumentException());
		setTest(someEmptyStrings, someEmptyStrings.length, "foo", new IllegalArgumentException());
		setTest(someEmptyStrings, 0, null, new IllegalArgumentException());

		//tests 38-47
		removeTests();

		//tests 48-53
		String[] ascending = {"a", "b", "c", "d", "e", "f", "g"};
		subListTest(ascending, 0, 2, null);
		subListTest(empty, 0, 0, null);
		subListTest(randomStrings, randomStrings.length, randomStrings.length, null);
		subListTest(empty, 0, 1, new IllegalArgumentException());
		subListTest(empty, 1, 0, new IllegalArgumentException());
		subListTest(ascending, 2, 1, new IllegalArgumentException());

		//tests 54-60
		String[] someRepeats = {"a", "a", "b", "c", "b", "a"};  
		indexOfTest(someRepeats, "a", 0, null);
		indexOfTest(someRepeats, "b", 2, null);
		indexOfTest(someRepeats, "d", -1, null);
		indexOfTest(someRepeats, null, -2, new IllegalArgumentException());
		indexOfTest(empty, "a",-1, null);
		indexOfTest(oneElem, "a", 0, null);
		indexOfTest(oneElem, "97", -1, null);

		//tests 60-73
		indexOfPosTest(someRepeats, "a", 1 ,1, null);
		indexOfPosTest(someRepeats, "a", 2 ,5, null);
		indexOfPosTest(someRepeats, "b", 2 ,2, null);
		indexOfPosTest(someRepeats, "b", 3 ,4, null);
		indexOfPosTest(someRepeats, "c", 2 ,3, null);
		indexOfPosTest(someRepeats, "c", 3 ,3, null);
		indexOfPosTest(someRepeats, "c", 4 ,-1, null);
		indexOfPosTest(someRepeats, null, 2 ,3, new IllegalArgumentException());
		indexOfPosTest(someRepeats, "a", -1 ,-2, new IllegalArgumentException());
		indexOfPosTest(someRepeats, "a", someRepeats.length ,-2, new IllegalArgumentException());
		indexOfPosTest(empty, "a", 0, -2, new IllegalArgumentException());
		indexOfPosTest(oneElem, "a", oneElem.length, -2, new IllegalArgumentException());
		indexOfPosTest(oneElem, "a", oneElem.length - 1, 0, null);

		//tests 74-76
		makeEmptyBasicTest(empty);
		makeEmptyBasicTest(oneElem);
		makeEmptyBasicTest(randomStrings);
		
		//test 77-79 (each is one long, extensive test on the iterator with multiple ways to fail)
		iteratorExtensiveTest(ascending);
		iteratorExtensiveTest(empty);
		iteratorExtensiveTest(oneElem);
		

		//tests 80-86
		removeRangeTest(empty, 0, 0, new IllegalArgumentException());
		removeRangeTest(ascending, 0, 0, null);
		removeRangeTest(oneElem, 0, 1, null);
		removeRangeTest(ascending, 0, 3, null);
		removeRangeTest(ascending, 5, 6, null);
		removeRangeTest(ascending, 2, 5, null);
		removeRangeTest(randomStrings, 0, randomStrings.length, null);

		//tests 87-90
		addFirstTest(someEmptyStrings, "newFirst", null);
		addFirstTest(empty, "newFirst", null);
		addFirstTest(oneElem, "newFirst", null);
		addFirstTest(ascending, null, new IllegalArgumentException());
		
		//tests 91-94
		addLastTest(empty, "newLast", null);
		addLastTest(oneElem, "newLast", null);
		addLastTest(ascending, "newLast", null);
		addLastTest(ascending, null, new IllegalArgumentException());

		//tests 95-97
		removeFirstTest(oneElem, null);
		removeFirstTest(ascending, null);
		removeFirstTest(empty, new NoSuchElementException());
		
		//tests 98-100
		removeLastTest(oneElem, null);
		removeLastTest(ascending, null);
		removeLastTest(empty, new NoSuchElementException());
		
		//tests 101-112
		Integer[] integers = {1, 2, 3, 4, 5};
		Integer[] integersEmpty = {};
		String[] numberStrings = {"1", "2", "3", "4", "5"};
		equalsListToListTest(numberStrings, integers, false);
		equalsListToListTest(empty, integersEmpty, true);
		equalsListToListTest(oneElem, oneElem, true);
		equalsListToNonListsTest(empty);
		equalsListToNonListsTest(oneElem);
		equalsListToNonListsTest(ascending);
		
		

		System.out.println();
		System.out.println("Passed " + testsPassed + "/" + testNum);
	}
	
	private static void equalsListToNonListsTest(String[] testStrings) {
		testNum(" Testing equals method against null(relies on add)");
		LinkedList<String> list1 = addAllToList(testStrings);
		boolean shouldBeFalse = list1.equals(null);
		testResult(!shouldBeFalse, "equals test against null");
		
		testNum(" Testing equals method against empty array (relies on list from previous test)");
		String[] empty = {};
		shouldBeFalse = list1.equals(empty);
		testResult(!shouldBeFalse, "equals test against array");
		
		testNum(" Testing equals method against ArrayList (relies on list from previous test)");
		ArrayList<String> arList = new ArrayList<>(Arrays.asList(testStrings));
		shouldBeFalse = list1.equals(arList);
		testResult(!shouldBeFalse, "equals test against ArrayList");		
		
	}
	
	private static void equalsListToListTest(String[] testStrings, Object[] testObjects, boolean expected) {
		testNum(" Testing equals method between two ILists (relies on add)");
		LinkedList<String> list1 = addAllToList(testStrings);
		LinkedList<Object> list2 = new LinkedList<>();
		for (Object obj : testObjects){
			list2.add(obj);
		}
		boolean actual = list1.equals(list2);
		testResult(actual == expected, "equals test");
	}
	
	private static void removeLastTest(String[] testStrings, Exception expectedException) {
		try {
			testNum(" Testing removeLast method (relies on add and size");
			LinkedList<String> list = addAllToList(testStrings);
			String removed = list.removeLast();
			testResult(removed.equals(testStrings[testStrings.length - 1]) && list.size() == testStrings.length -1,
					"removeLast test, confirming: "
					+ "\n\t 1: removed elem .equals last elem in testStrings"
					+ "\n\t 2: list.size() == testStrings.length - 1");
		} catch (Exception e) {
			if (expectedException != null && (e.getClass().equals(expectedException.getClass()) 
					|| e.getClass().equals(IllegalArgumentException.class)
					|| e.getClass().equals(IllegalStateException.class))){
				testsPassed++;
				System.out.println("Caught an expected exception (NoSuchElement, IllegalState, IllegalArgument) " + e);
			} else {
				System.out.println("!!!!!Caught unexpected exception!!!!! "
						+ "\n\tExpected exception: " + (expectedException == null ? null : expectedException.getClass())
						+ "\n\t  Actual exception: " + e);
				for (StackTraceElement elem : e.getStackTrace()) {
					System.out.println(elem);
				}
			}
		}
	}

	private static void removeFirstTest(String[] testStrings, Exception expectedException) {
		try {
			testNum(" Testing removeFirst method (relies on add and size");
			LinkedList<String> list = addAllToList(testStrings);
			String removed = list.removeFirst();
			testResult(removed.equals(testStrings[0]) && list.size() == testStrings.length -1,
					"removeFirst test, confirming: "
					+ "\n\t 1: removed elem .equals first elem in testStrings"
					+ "\n\t 2: list.size() == testStrings.length - 1");
		} catch (Exception e) {
			if (expectedException != null && (e.getClass().equals(expectedException.getClass()) 
					|| e.getClass().equals(IllegalArgumentException.class)
					|| e.getClass().equals(IllegalStateException.class))){
				testsPassed++;
				System.out.println("Caught an expected exception (NoSuchElement, IllegalState, IllegalArgument) " + e);
			} else {
				System.out.println("!!!!!Caught unexpected exception!!!!! "
						+ "\n\tExpected exception: " + (expectedException == null ? null : expectedException.getClass())
						+ "\n\t  Actual exception: " + e);
				for (StackTraceElement elem : e.getStackTrace()) {
					System.out.println(elem);
				}
			}
		}
	}
	
	private static void addLastTest(String[] testStrings, String newLast, Exception expectedException) {
		try {
			testNum(" Testing addLast method (relies on add, get, and size)");
			LinkedList<String> list = addAllToList(testStrings);
			int oldSize = list.size();
			if (DEBUG) {
				System.out.println(list);
			}
			list.addLast(newLast);
			if (DEBUG) {
				System.out.println(list);
			}
			testResult(list.get(list.size() - 1).equals(newLast) && list.size() == ++oldSize, 
					"addLast test, confirming: "
					+ "\n\t 1: list's last elem .equals passed newLast"
					+ "\n\t 2: list.size() == oldSize + 1");
		} catch (Exception e) {
			checkException(expectedException, e);
		}
	}

	private static void addFirstTest(String[] testStrings, String newFirst, Exception expectedException) {
		try {
			testNum(" Testing addFirst method (relies on add, get, and size)");
			LinkedList<String> list = addAllToList(testStrings);
			int oldSize = list.size();
			if (DEBUG) {
				System.out.println(list);
			}
			list.addFirst(newFirst);
			if (DEBUG) {
				System.out.println(list);
			}
			testResult(list.get(0).equals(newFirst) && list.size() == ++oldSize, "addFirst test, confirming: "
					+ "\n\t 1: list's first elem .equals passed newFirst"
					+ "\n\t 2: list.size() == oldSize + 1");
		} catch (Exception e) {
			checkException(expectedException, e);
		}
	}

	private static void removeRangeTest(String[] testStrings, int start, int stop, Exception expectedException) {
		try {
			testNum(" Testing removeRange method (relies on add and toString)");
			LinkedList<String> list = addAllToList(testStrings);
			ArrayList<String> arList = new ArrayList<>();
			for (int i = 0; i < start; i++) {
				arList.add(testStrings[i]);
			}
			for (int i = stop; i < testStrings.length; i++) {
				arList.add(testStrings[i]);
			}
			list.removeRange(start, stop);
			testResult(list.toString().equals(arList.toString()), "removeRange test, using toString "
					+ "from our LinkedList and the java standard ArrayList");
		} catch (Exception e) {
			checkException(expectedException, e);
		}
	}

	/*
	 * this code is hideous, but functional. too tired to clean up...
	 */
	private static void iteratorExtensiveTest(String[] testStrings) {
		testNum(" Testing the iterator (relies on add)");
		LinkedList<String>list = addAllToList(testStrings);
		Iterator<String> it = list.iterator();
		boolean passed = true;
		// try calling remove first; check that this throws an IllegalStateException. 
		try {
			it.remove();
			passed = false;
			System.out.println("Fail Reason: shouldn't be able to call remove before calling next");
		} catch (Exception f){
			passed = f.getClass().equals(IllegalStateException.class);
		}
		// fail if wrong or no exception is thrown
		if (!passed) {
			System.out.println("Fail Reason: per documentation, remove "
					+ "should throw IllegalStateException if called before next");
		}
		// if passed above, then test hasNext and next.
		else {
			int index = 0;
			while (it.hasNext() && passed){
				passed = it.next().equals(testStrings[index]);
				index++;
			}
			// confirmed that each element next retrieved matched the corresponding testStrings element
			if (passed) {
				//hasNext == false, so test next again for exception
				try {
					it.next();
					passed = false;
					System.out.println("Fail Reason: shouldn't be able to call next when hasNext is false");
				} catch (Exception e) {
					passed = e.getClass().equals(NoSuchElementException.class);
				}
				// fail if wrong or no exception thrown
				if (!passed)
					System.out.println("Fail Reason: per documentation, next "
							+ "should throw NoSuchElementException if called when hasNext is false");
				else {
					if (list.size() != 0) {
						it.remove();
						// try sequential remove
						try {
							it.remove();
							passed = false;
							System.out.println("Fail Reason: shouldn't be able to call remove twice in a row");
						} catch (Exception g) {
							passed = g.getClass().equals(IllegalStateException.class);
						}
						// fail if wrong or no exception thrown
						if (!passed) {
							System.out.println("Fail Reason: per documentation, remove "
									+ "should throw IllegalStateException if called sequentially");
						} 
						else {
							// did the list size change?
							passed = list.size() == (testStrings.length - 1);
						}
						if (!passed) {
							System.out.println("Fail Reason: the list size should decrement when it.remove is called");
						}
						else if (list.size() != 0)
							passed = list.get(list.size() - 1).equals(testStrings[testStrings.length - 2]);
					}
				}    				
				
			}
		}
		testResult(passed, "iterator test; test confirms:"
				+ "\n\t 1: iterator created with list.iterator method call"
				+ "\n\t 2: the iterator correctly went over the elements of the "
				+ "list, per testString element matching"
				+ "\n\t 3: remove call correctly removed most recent next"
				+ "\n\t 4: all exceptions correctly thrown");
	}    

	private static void makeEmptyBasicTest(String[] testStrings) {
		testNum(" Testing makeEmpty method (relies on add and size)");
		LinkedList<String> list = addAllToList(testStrings);
		list.makeEmpty();
		testResult(list.size() == 0, "makeEmpty test, list.size() == 0");
	}

	private static void indexOfPosTest(String[] testStrings, String toFind, int pos,  int expectedIndex, Exception expectedException) {
		try {
			testNum(" Testing indexOf(obj, pos) method; (relies on add)");
			LinkedList<String> list = addAllToList(testStrings);
			int actualIndex = list.indexOf(toFind, pos);
			if (toFind == null) {
				throw new NullPointerException("per documentation, the item to find cannot be null");
			}
			testResult(actualIndex == expectedIndex, "indexOf(obj) test, "
					+ "Expected index: " + expectedIndex
					+ "  Actual index: " + actualIndex);
		} catch (Exception e) {
			checkException(expectedException, e);
		}
	}

	private static void indexOfTest(String[] testStrings, String toFind, int expectedIndex, Exception expectedException) {
		try {
			testNum(" Testing indecOf(obj) method; (relies on add)");
			LinkedList<String> list = addAllToList(testStrings);
			int actualIndex = list.indexOf(toFind);
			if (toFind == null) {
				throw new NullPointerException("per documentation, the item to find cannot be null");
			}
			testResult(actualIndex == expectedIndex, "indexOf(obj) test, "
					+ "Expected index: " + expectedIndex
					+ "  Actual index: " + actualIndex);
		} catch (Exception e) {
			checkException(expectedException, e);
		}
	}


	private static void subListTest(String[] testStrings, int start, int stop, Exception expectedException) {
		try {
			testNum(" Testing subList method (relies on add and toString)");
			LinkedList<String> list = addAllToList(testStrings);
			ArrayList<String> arList = new ArrayList<String>(Arrays.asList(testStrings));
			IList<String> subList = list.getSubList(start, stop);
			List<String> subArList = arList.subList(start, stop);
			testResult(subList.toString().equals(subArList.toString()), "subList test, "
					+ "via toString comparison to java standard ArrayList toString");
		} catch (Exception e) {
			checkException(expectedException, e);
		}

	}

	private static void removeTests() {
		String[] ascending = {"a", "b", "c", "d", "e"};
		String[] randomStrings = buildRandomStringArray(100, 2);
		removePosTest(ascending, 0, null); //remove first 
		removePosTest(randomStrings, 50, null); //remove middle
		removePosTest(randomStrings, randomStrings.length - 1, null); //remove last
		removePosTest(ascending, -1, new IllegalArgumentException()); //illegal arg(remove elem before first)
		removePosTest(randomStrings, randomStrings.length, new IllegalArgumentException()); //illegal arg (remove elem after last)
		removeAllTest(ascending, null); //remove all in random fashion
		removeAllTest(randomStrings, null); //remove all in random fashion
		removeObjTest(ascending, "e", true, null);
		removeObjTest(ascending, "f", false, null);
		removeObjTest(ascending, null, false, new IllegalArgumentException());

	}

	private static void removeObjTest(String[] testStrings, 
			String toRemove, boolean expectedBool, Exception expectedException) {
		try {
			testNum(" Testing remove(obj) method; (relies on add and get)");
			LinkedList<String> list = addAllToList(testStrings);
			ArrayList<String> arList = new ArrayList<>(Arrays.asList(testStrings));
			boolean removeBool = list.remove(toRemove);
			arList.remove(toRemove);
			testResult(list.toString().equals(arList.toString())
					&& removeBool == expectedBool, "remove(obj) test, confirming: "
							+ "\n\t 1: updated list's toString matches java standard ArrayList.remove's toString"
							+ "\n\t 2: the actual boolean matched the expected; result: " 
							+ removeBool + "==" + expectedBool );

		} catch (Exception e) {
			checkException(expectedException, e);
		}

	}

	private static void removeAllTest(String[] testStrings, Exception expectedException) {
		try {
			Random r = new Random();
			testNum(" Testing remove(pos) method; (relies on add and size)");
			LinkedList<String> list = addAllToList(testStrings);
			for (int i = 0; i < testStrings.length; i++) {
				list.remove(r.nextInt(list.size()));
				if (DEBUG) {
					System.out.println(list);
				}
			}
			testResult( list.size() == 0,"remove(pos) test, removing a random element of list "
					+ "until testStrings.length elements have been removed, so list.size() == 0"
					+ " should be true");

		} catch (Exception e) {
			checkException(expectedException, e);
		}
	}

	private static void removePosTest(String[] testStrings, int pos, Exception expectedException) {
		try {
			testNum(" Testing remove(pos) method; (relies on add and size)");
			LinkedList<String> list = addAllToList(testStrings);
			String removed = list.remove(pos);
			if (DEBUG) {
				System.out.println("Removed the element at index " + pos);
				System.out.println(Arrays.toString(testStrings));
				System.out.println(list);
			}
			testResult( !(list.toString().equals(Arrays.toString(testStrings))) &&
					removed.equals(testStrings[pos]) && 
					list.size() == testStrings.length - 1, 
					"remove(pos) test, confirming: "
							+ "\n\t 1: list.toString() does not equal Arrays.toString(testStrings)"
							+ "\n\t 2: the returned item was the removed data"
							+ "\n\t 3: the size of the list was reduced by 1");

		} catch (Exception e) {
			checkException(expectedException, e);
		}
	}

	private static void setTest(String[] testStrings, int pos, String toSet, Exception expectedException) {
		try {
			testNum(" Testing set method (relies on add and get)");
			LinkedList<String> list = addAllToList(testStrings);
			String oldListItem = list.set(pos, toSet);
			String newItem = list.get(pos);
			testResult(newItem.equals(toSet) && oldListItem.equals(testStrings[pos]), "set test, "
					+ "confirming that set returned the old data and replaced it with the new data");
		} catch (Exception e) {
			checkException(expectedException, e);
		}
	}

	/*
	 * tests insert method
	 * 
	 * pre: 0 <= pos < testStrings.length
	 * pre: functioning get method (if get passes basicAddGetTests, should be fine)
	 */
	private static void insertTest(String[] testStrings, int pos, String toInsert, Exception expectedException) {
		try {
			testNum(" Testing insert method (relies on add and get)");
			LinkedList<String> list = addAllToList(testStrings);
			if (DEBUG) {
				System.out.println("inserting \"" + toInsert + "\" at position " + pos);
				System.out.println(list);
			}
			list.insert(pos, toInsert);
			if (DEBUG) {
				System.out.println(list);
			}
			testResult(list.get(pos).equals(toInsert), "insert test, using list.get(pos).equals(toInsert)");
		} catch (Exception e) {
			checkException(expectedException, e);
		}
	}

	/*
	 * tests get method using a large list.
	 * doubles the list size each run.
	 * 
	 * TODO: add stopwatch to time
	 */
	private static void getStressTests() {
		int wordLen = 8;
		int cap = 5000;
		String[] randomStrings = buildRandomStringArray(cap, wordLen);
		basicAddGetToStringTests(randomStrings, null); // 2 tests
		randomGets(randomStrings); // 1 test
		randomStrings = buildRandomStringArray(cap*2, wordLen);
		basicAddGetToStringTests(randomStrings, null); // 2 tests
		randomGets(randomStrings); // 1 test
		randomStrings = buildRandomStringArray(cap*4, wordLen);
		basicAddGetToStringTests(randomStrings, null);// 2 tests
		randomGets(randomStrings); // 1 test
		randomStrings = buildRandomStringArray(cap*8, wordLen);
		basicAddGetToStringTests(randomStrings, null);// 2 tests
		randomGets(randomStrings); // 1 test

	}

	/*
	 * tests the get method for randomly chosen get indices
	 * number of get calls == size of the array 
	 */
	private static void randomGets(String[] testStrings) {
		testNum(" Testing get at random indices (relies on add and size)");
		Random r = new Random();
		LinkedList<String> list = addAllToList(testStrings);
		boolean failedGet = false;
		for (int i = 0; i < testStrings.length; i ++) {
			//    		System.out.println(" i is : " + i);
			int getIndex = r.nextInt(list.size());
			if (!list.get(getIndex).equals(testStrings[getIndex])){
				failedGet = true;
			}
		}
		testResult(!failedGet, "get from random positions test, based on word to word String comparison");
	}

	
	private static void sizeTest(String[] testStrings) {
		testNum(" Testing size method (relies on add)");
		LinkedList<String> list = addAllToList(testStrings);
		testResult(list.size() == testStrings.length, "passed size test, list size matched array size");
	}

	private static void emptyGet() {
		try {
			testNum(" Testing get on an empty list");
			LinkedList<String> list = new LinkedList<>();
			if (list.get(0) == null){
				System.out.println("!!!!!Failed!!!!! empty list get test; should have thrown an exception");
			}
		} catch (Exception e) {
			if (!(e instanceof NullPointerException)) {
				System.out.print("Thrown exception: " + e);
				System.out.println(" is not an instance of NullPointerException "
						+ "\n\t(assumes pass if exception is not NullPointer; confirm thrown exception is correct)");
				testsPassed++;
			} else {
				System.out.println("!!!!!Failed!!!!!");
				System.out.print("Thrown exception: " + e);
				System.out.println(" is an instance of NullPointerException "
						+ "\n\t(assumes failed if NullPointer thrown; "
						+ "if you chose to throw NullPointer in empty case, ignore fail or change throw)");
			}
		}
	}

	/*
	 * tests the add and get methods
	 * testing of add relies on the toString method
	 * testing of get is and element to element comparison 
	 *  between LinkedList and array used to construct the list 
	 */
	private static void basicAddGetToStringTests(String[] testStrings, Exception expectedException) {
		testNum(" Testing add and toString methods (codependent: add uses toString to test, toString relies on add to build list)");
		LinkedList<String> list = new LinkedList<String>();
		System.out.println("--Building a new LinkedList<String>, list, from testStrings : " 
				+ Arrays.toString(testStrings));
		try {

			for (int i = 0; i < testStrings.length; i++) {
				list.add(testStrings[i]);
			}
			testResult(list.toString().equals(Arrays.toString(testStrings)), 
					"basic add test, based on list.toString().equals(Arrays.toString(testStrings)");


			testNum(" Testing get methods (uses list from add/toString test)");
			boolean failedGet = false;
			for (int i = 0; i < testStrings.length; i++) {
				String word = list.get(i);
				if (!word.equals(testStrings[i])){
					failedGet = true;
					System.out.println("!!!!!Failed!!!!! comparison at index " + i + ": " + word + " vs. " + testStrings[i]);
				}

			}
			testResult(!failedGet, "basic get test, based on word by word String comparison");

		} catch (Exception e) {
			checkException(expectedException, e);
		}
	}

	/*
	 * method builds a String[] of length capacity, 
	 * filled with random character Strings of 
	 * random length (max length == maxWordLength)
	 */
	private static String[] buildRandomStringArray(int capacity, int maxWordLength) {
		Random r = new Random();
		String[] result = new String[capacity];
		for (int i = 0; i < result.length; i++) {
			int wordLen = r.nextInt(maxWordLength);
			StringBuilder sb = new StringBuilder();
			sb.append("");
			for (int ch = 0; ch < wordLen; ch++) {
				sb.append((char) (r.nextInt(95) + ' '));
			}
			result[i] = sb.toString();
		}
		return result;
	}

	private static LinkedList<String> addAllToList(String[] str) {
		LinkedList<String> result = new LinkedList<String>();
		for (String s : str) {
			result.add(s);
		}
		return result;
	}

	private static void testResult(boolean passCondition, String prompt) {
		if (passCondition) {
			System.out.print("Passed ");
			testsPassed++;
		} else {
			System.out.print("!!!!!Failed!!!!! ");
		}
		System.out.println(prompt);
	}

	private static void checkException(Exception expected, Exception actual) {
		if (expected != null && actual.getClass().equals(expected.getClass())){
			testsPassed++;
			System.out.println("Caught expected exception " + actual);
		} else {
			System.out.println("!!!!!Caught unexpected exception!!!!! "
					+ "\n\tExpected exception: " + (expected == null ? null : expected.getClass())
					+ "\n\t  Actual exception: " + actual);
			for (StackTraceElement elem : actual.getStackTrace()) {
				System.out.println(elem);
			}
		}
	}

	private static void testNum(String explanation){
		System.out.println("\nTest number: " + ++testNum );
		System.out.println(explanation);
	}
}