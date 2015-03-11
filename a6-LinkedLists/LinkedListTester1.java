/**
 * A tester for a6-LinkedList
 * @author Joshua Guenther
 */

import java.util.Iterator;

public class LinkedListTester1{

    public static void main(String[] args) {
    	//Note: the "failed" test output is not very helpful
    	basics(); 			//add/get/size
    	addFirstLast();		//addFirst/addLast
    	remove(); 			//remove element/size/removeFirst/removeLast
    	insertIndexOf();	//insert element/insert position/indexOf element/indexOf startPos
    	subList();			//getSubList/removeRange
    	toStringTest(); 	//toString
    	iteratorTest();		//iterator's hasNext/next/remove
    	miscTester(); 		//makeEmpty/equals
    	
    }
    
    private static void basics(){
    	System.out.println("---BASIC TESTS---");
    	int testNum = 0;
    	Object[] actual;
    	Object[] expected = {0};
    	LinkedList<Integer> list  = new LinkedList<Integer>();
    	//populate with values 0 - 9
    	for(int i = 0; i < 10; i++){
    		list.add(i);
    		if(i == 0){
    			//Check adding first element
    			actual = new Object[]{i};
    			printTest("Basic add initial element", testNum+1, actual[0].equals(expected[0]), actual[0], expected[0]);
    		}
    	} 
    	//Ensure post conditions of add method
    	int oldSize = list.size();
		list.add(10);
		int newSize = list.size();
		actual = new Object[]{newSize, list.get(newSize-1)};
    	expected = new Object[]{oldSize+1, 10};
		printTest("Basic add post-condition 1", testNum+2, actual[0].equals(expected[0]), actual[0], expected[0]);
		printTest("Basic add post-condition 2", testNum+3, actual[1].equals(expected[1]), actual[1], expected[1]);
    	
    	//Check values of 3 indices
    	//State of list prior: [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
    	actual = new Object[]{list.get(0), list.get(5), list.get(list.size()-1)};
    	expected = new Object[]{0, 5, 10};
    	printTest("Basic get index 0", testNum+4, actual[0].equals(expected[0]), actual[0], expected[0]);
    	printTest("Basic get index 5", testNum+5, actual[1].equals(expected[1]), actual[1], expected[1]);
    	printTest("basic get index size()-1", testNum+6, actual[2].equals(expected[2]), actual[2], expected[2]);	
    	
    	list.set(0, 21); list.set(7, 21); list.set(list.size()-1, 21);
    	actual = new Object[]{list.get(0), list.get(7), list.get(10)};
    	expected = new Object[]{21};
    	printTest("Basic set index 0", testNum+7, actual[0].equals(expected[0]), actual[0], expected[0]);
    	printTest("Basic set index 7", testNum+8, actual[1].equals(expected[0]), actual[1], expected[0]);
    	printTest("Basic set index size()-1", testNum+9, actual[2].equals(expected[0]), actual[2], expected[0]);
    	
    }
    
    private static void addFirstLast(){
    	System.out.println("---ADDFIRST & ADDLAST TESTS---");
    	int testNum = 0;
    	LinkedList<Number> list  = new LinkedList<Number>();
    	
    	list.addFirst(new Byte((byte) 0));
    	Object[] expected = new Object[]{(byte)0};
    	Object[] actual = new Object[]{list.get(0)};
    	boolean result = expected[0].equals(actual[0]);
    	printTest("AddFirst - basic", testNum+1, result, actual[0], expected[0]);
    	
    	list.addFirst(new Float( 10.1f));
    	expected = new Object[]{10.1f};
    	actual = new Object[]{list.get(0)};
    	result = expected[0].equals(actual[0]);
    	printTest("AddFirst - basic", testNum+2, result, actual[0], expected[0]);
    	
    	int oldSize = list.size();
    	list.addFirst(new Double(22.2));
    	expected = new Object[]{22.2, oldSize+1};
    	actual = new Object[]{list.get(0), list.size()};
    	result = expected[0].equals(actual[0]) && expected[1].equals(actual[1]);
    	printTest("AddFirst - postcondition", testNum+3, result, actual[0], expected[0]);
    	
    	list.addLast(new Short((short)98));
    	expected = new Object[]{(short)98};
    	actual = new Object[]{list.get(list.size()-1)};
    	result = expected[0].equals(actual[0]);
    	printTest("AddLast - basic", testNum+4, result, actual[0], expected[0]);
    	
    	list.addLast(new Integer(11));
    	expected = new Object[]{11};
    	actual = new Object[]{list.get(list.size()-1)};
    	result = expected[0].equals(actual[0]);
    	printTest("AddLast - basic", testNum+5, result, actual[0], expected[0]);
    	
    	oldSize = list.size();
    	list.addLast(new Long(120000000));
    	expected = new Object[]{(long)120000000, oldSize+1};
    	actual = new Object[]{list.get(list.size()-1), list.size()};
    	result = expected[0].equals(actual[0]) && expected[1].equals(actual[1]);
    	printTest("AddLast - postcondition", testNum+6, result, actual[0], expected[0]);

    	
    	
    	
    }
    
    private static void remove(){
    	System.out.println("---REMOVE & SIZE TESTS---");
    	int testNum = 0;
    	LinkedList<String> list  = new LinkedList<String>();
    	//populate with Strings: "0", "01", "012", ..., "0123456789"
    	String numbers = "";
    	for(int i = 0; i < 10; i++){
    		numbers += i;
    		list.add(numbers);
    	} 
    	
		Object[] actual = {list.size()}; Object[] expected = {10};
		printTest("Checking intial size", testNum+1, actual[0].equals(expected[0]), actual[0], expected[0]);
		String element = "0123456789";
		list.remove(element);
		actual = new String[]{list.toString()}; expected = new String[]{"[0, 01, 012, 0123, 01234, 012345, 0123456, 01234567, 012345678]"};
		boolean result = ((String)actual[0]).compareTo((String)expected[0]) == 0;
		printTest("Removed \""+element+"\"", testNum+2, result, actual[0], expected[0]);  //check same output of toString
		
		actual = new Object[]{list.size()}; 
		expected = new Object[]{9};
		printTest("Size after removing 1 element", testNum+3, actual[0].equals(expected[0]), actual[0], expected[0]);
		boolean found = list.remove("0123456789");
		actual = new String[]{list.toString()}; expected = new String[]{"[0, 01, 012, 0123, 01234, 012345, 0123456, 01234567, 012345678]"};
		result = ((String)actual[0]).compareTo((String)expected[0]) == 0 && !found;
		printTest("Tried removing element not in list - return false?", testNum+4, result, actual[0], expected[0]);
	
		element = "0";
		found = list.remove(element);
		actual = new String[]{list.toString()}; expected = new String[]{"[01, 012, 0123, 01234, 012345, 0123456, 01234567, 012345678]"};
		result = ((String)actual[0]).compareTo((String)expected[0]) == 0 & found;
		printTest("Removing \""+element+"\" - return true?", testNum+5, result, actual[0], expected[0]);  //check same output of toString
		actual = new Object[]{list.size()}; 
		expected = new Object[]{8};
		printTest("Removing \""+element+"\" - size changed", testNum+6, actual[0] == expected[0], actual[0], expected[0]);
		
    	list.removeFirst();
    	actual = new Object[]{list.get(0)};
    	expected = new Object[]{"012", "01"};
    	result = (!actual[0].equals(expected[1]) && actual[0].equals(expected[0]));
    	printTest("RemoveFirst basic check", testNum+7, result, actual, expected);
    	
    	String firstElement = list.removeFirst();
    	actual = new Object[]{firstElement};
    	expected = new Object[]{"012"};
    	result = (actual[0].equals(expected[0]));
    	printTest("RemoveFirst returned element", testNum+8, result, actual, expected);
    	
    	expected = new Object[]{list.size()-1};
    	list.removeFirst();
    	actual = new Object[]{list.size()};
    	result = (actual[0].equals(expected[0]));
    	printTest("RemoveFirst size", testNum+9, result, actual, expected);
    	
    	list.removeLast();
    	actual = new Object[]{list.get(list.size()-1)};
    	expected = new Object[]{"012345678", "01234567"};
    	result = (!actual[0].equals(expected[0]) && actual[0].equals(expected[1]));
    	printTest("RemoveLast basic check", testNum+10, result, actual, expected);

    	String lastElement = list.removeLast();
    	actual = new Object[]{list.get(list.size()-1)};
    	expected = new Object[]{"01234567"};
    	result = (!actual[0].equals(expected[0]));
    	printTest("RemoveLast returned element", testNum+11, result, actual, expected);

    	expected = new Object[]{list.size()-1};
    	list.removeLast();
    	actual = new Object[]{list.size()};
    	result = (actual[0].equals(expected[0]));
    	printTest("RemoveLast size", testNum+12, result, actual, expected);
    	
    	expected = new Object[]{list.size()-1};
    	list.remove(list.size()-1);
    	actual = new Object[]{list.size()};
    	result = (actual[0].equals(expected[0]));
    	printTest("Remove index size", testNum+13, result, actual, expected);
    	
    	expected = new Object[]{list.size()-1};
    	list.remove(0);
    	actual = new Object[]{list.size()};
    	result = (actual[0].equals(expected[0]));
    	printTest("Remove element from list of size 1", testNum+14, result, actual, expected);
    	
    	//New List!!!!
    	LinkedList<Boolean> list2 = new LinkedList<Boolean>();
    	for(int i = 0; i < 100; i++){
    		list2.add(i % 2 == 0);
    	} 
    	
    	expected = new Object[]{list2.size()-1};
    	list2.remove(50);
    	actual = new Object[]{list2.size()};
    	result = (actual[0].equals(expected[0]));
    	printTest("Remove element from middle", testNum+15, result, actual, expected);
    	
    }
    
    private static void insertIndexOf(){ //insert element/insert position/indexOf element/indexOf startPos
    	System.out.println("---INSERT AND INDEXOF TESTS---");
    	int testNum = 0;
    	LinkedList<Boolean> list = new LinkedList<Boolean>();
    	for(int i = 0; i < 12; i++){
    		list.add(true);
    	} 
    	int oldSize = list.size();
    	list.insert(0, false);
    	Object[] actual = new Object[]{list.size(), list.get(0)};
    	Object[] expected = new Object[]{oldSize+1, false};
    	boolean result =  actual[0].equals(expected[0]) &&  actual[1].equals(expected[1]);
    	printTest("Insert post condition - front", testNum+1, result, actual, expected);
    	
    	oldSize = list.size();
    	list.insert(list.size(), false);
    	actual = new Object[]{list.size(), list.get(list.size()-1)};
    	expected = new Object[]{oldSize+1, false};
    	result =  actual[0].equals(expected[0]) &&  actual[1].equals(expected[1]);
    	printTest("Insert post condition - end", testNum+2, result, actual, expected);
    	
    	expected = new Object[]{list.get(0)};
    	list.insert(1, false);
    	actual = new Object[]{list.get(0)};
    	result = actual[0].equals(expected[0]);
    	printTest("Insert proper shifting - element before position", testNum+3, result, actual, expected);
    	
    	expected = new Object[]{list.get(1)};
    	list.insert(1, false);
    	actual = new Object[]{list.get(2)};
    	result = actual[0].equals(expected[0]);
    	printTest("Insert proper shifting - element after position", testNum+4, result, actual, expected);
    	
    	actual = new Object[]{list.indexOf(false)};
    	expected = new Object[]{0};
    	result = actual[0].equals(expected[0]);
    	printTest("IndexOf - \"false\" from beginning", testNum+5, result, actual, expected);
    	
    	actual = new Object[]{list.indexOf(true)};
    	expected = new Object[]{3};
    	result = actual[0].equals(expected[0]);
    	printTest("IndexOf - \"true\" from beginning", testNum+6, result, actual, expected);
    	
    	actual = new Object[]{list.indexOf(false, 3)};
    	expected = new Object[]{15};
    	result = actual[0].equals(expected[0]);
    	printTest("IndexOf - \"true\" from midway", testNum+7, result, actual, expected);
    }
    
    private static void subList(){
    	System.out.println("---GETSUBLIST AND REMOVERANGE TESTS---");
    	int testNum = 0;
    	LinkedList<Boolean> list = new LinkedList<Boolean>();
    	for(int i = 0; i < 100; i++){
    		list.add(i % 2 == 0);
    	} 
    	int oldSize = list.size();
    	list.removeRange(0, 15);
    	Object[] actual = new Object[]{list.size()};
    	Object[] expected = new Object[]{oldSize-(15-0)};
    	boolean result = (actual[0].equals(expected[0]));
    	printTest("Remove range post condition - front", testNum+1, result, actual, expected);
    	
    	oldSize = list.size();
    	list.removeRange(50, 85);
    	actual = new Object[]{oldSize-(85-50)};
    	expected = new Object[]{50};
    	result = (actual[0].equals(expected[0]));
    	printTest("Remove range post condition - end", testNum+2, result, actual, expected);
    	
    	expected = new Object[]{list.size()-(list.size()-50)};
    	list.removeRange(0, 0);
    	actual = new Object[]{50};
    	result = (actual[0].equals(expected[0]));
    	printTest("Remove range of size 0", testNum+3, result, actual, expected);
    	
    	list.removeRange(5, 50);
    	actual = new Object[]{list.toString()};
    	expected = new Object[]{"[false, true, false, true, false]"};
    	result = (actual[0].equals(expected[0]));
    	printTest("ToString output after removing", testNum+4, result, actual, expected);

    	IList<Boolean> temp = list.getSubList(0, 0);
    	actual = new Object[]{temp.size()};
    	expected = new Object[]{0};
    	result = (actual[0].equals(expected[0]));
    	printTest("GetSubList of size 0", testNum+5, result, actual, expected);
    	
    	temp = list.getSubList(0,2);
    	actual = new Object[]{temp.size()};
    	expected = new Object[]{2-0};
    	result = (actual[0].equals(expected[0]));
    	printTest("GetSubList post condition - front", testNum+2, result, actual, expected);
    	
    	temp = list.getSubList(1,4);
    	actual = new Object[]{temp.size()};
    	expected = new Object[]{4-1};
    	result = (actual[0].equals(expected[0]));
    	printTest("GetSubList post condition - end", testNum+2, result, actual, expected);
    }
    
    private static void toStringTest(){
    	System.out.println("---TOSTRING TEST---");
    	int testNum = 0;
    	LinkedList<Integer> list = new LinkedList<Integer>();
    	Object[] actual = new Object[]{list.toString()};
    	Object[] expected = new Object[]{"[]"};
    	boolean results = actual[0].equals(expected[0]);
    	printTest("empty list", testNum+1, results, actual, expected);
    	
    	for(int i = 0; i < 10; i++){
    		list.add(1);} 
    	//check output formatting to be same
    	//State of list prior: [1, 1, 1, 1, 1, 1, 1, 1, 1, 1]
    	actual = new Object[]{list.toString()};
    	expected = new Object[]{"[1, 1, 1, 1, 1, 1, 1, 1, 1, 1]"};
    	results = actual[0].equals(expected[0]);
    	printTest("Filled list", testNum+2, results, actual, expected);
    	
    	//check size of list
    	//State of list prior: [1, 1, 1, 1, 1, 1, 1, 1, 1, 1]
    	list.makeEmpty();
    	//State of list prior: []
    	for(int i = 0; i < 1000; i++){
    		list.add((int)(Math.floor(Math.random()*100)));} 
    	int actualI = list.toString().length();
    	int expectedI = 2+(2*999)+1000;
    	results = actual[0].equals(expected[0]);
    	printTest("Length check", testNum+3, results, actualI, expectedI);
    }
    
    private static void iteratorTest(){
    	System.out.println("---ITERATOR TESTS---");
    	int testNum = 0;
    	LinkedList<Integer> list = new LinkedList<Integer>();
    	
    	Iterator<Integer> linkedIterator = list.iterator();
    	Object[] actual = new Object[]{linkedIterator.hasNext()};
    	Object[] expected = new Object[]{false};
    	boolean results = (actual[0].equals(expected[0]));
    	printTest("Iterator - hasNext of empty list", testNum+1, results, actual, expected);
    	
    	for(int i = 0; i < 10; i++){
    		list.add(i);
    	}
    	linkedIterator = list.iterator();
    	actual = new Object[]{linkedIterator.hasNext()};
    	expected = new Object[]{true};
    	results = (actual[0].equals(expected[0]));
    	printTest("Iterator - initial hasNext of populated list", testNum+2, results, actual, expected);
    	
    	actual = new Object[]{linkedIterator.next()};
    	expected = new Object[]{0};
    	results = (actual[0].equals(expected[0]));
    	printTest("Iterator - initial next of populated list", testNum+3, results, actual, expected);
    	
    	expected = new Object[]{list.get(1)};
    	linkedIterator.remove();
    	actual = new Object[]{list.get(0)};
    	results = (actual[0].equals(expected[0]));
    	printTest("Iterator - remove first element", testNum+4, results, actual, expected);
    	int index = 0; 
    	while(index < list.size()){
    		linkedIterator.next();
    		if(index == 3){
    			expected = new Object[]{list.get(index+1)};
    	    	linkedIterator.remove();
    	    	actual = new Object[]{list.get(index)};
    	    	results = (actual[0].equals(expected[0]));
    	    	printTest("Iterator - remove intermediate element", testNum+5, results, actual, expected);
    		}
    		index++;
    	}
    	actual = new Object[]{linkedIterator.hasNext()};
    	expected = new Object[]{true};
    	results = (actual[0].equals(expected[0]));
    	printTest("Iterator - last true hasNext of populated list", testNum+6, results, actual, expected);
    	
    	actual = new Object[]{linkedIterator.next()};
    	expected = new Object[]{9};
    	results = (actual[0].equals(expected[0]));
    	printTest("Iterator - last next of populated list", testNum+7, results, actual, expected);
    	
    	actual = new Object[]{linkedIterator.hasNext()};
    	expected = new Object[]{false};
    	results = (actual[0].equals(expected[0]));
    	printTest("Iterator - passed last element with hasNext of populated list", testNum+8, results, actual, expected);
    	
    	expected = new Object[]{list.get(list.size()-1)};
    	linkedIterator.remove();
    	actual = new Object[]{list.get(list.size()-1)};
    	results = !(actual[0].equals(expected[0]));
    	printTest("Iterator - remove last element", testNum+9, results, actual, expected);
    	
    	
    }
    
    
    private static void miscTester(){
    	System.out.println("---MISCELLANEOUS TESTS---");
    	
    	LinkedList<Integer> list = new LinkedList<Integer>();
    	for(int i = 0; i < 10; i++){
    		list.add(i);} 
    	
    	//Make empty check! Test size, too hard to see if you actually prepared nodes for garbage collection
    	//State of list prior: [9, 1, 2, 3, 4, 5, 6, 7, 8, 9]
    	int testNum = 0;
    	long before = Runtime.getRuntime().freeMemory();	//Get amount of free memory within the heap in bytes.
    	list.makeEmpty();
    	Runtime.getRuntime().gc(); 							//Recommend garbage collection
    	long after = Runtime.getRuntime().freeMemory(); 	//Get amount of free memory within the heap in bytes.
    	Object[] expected = new Object[]{0};
    	Object[] actual = new Object[]{list.size()};
    	boolean results = (actual[0].equals(0));
    	printTest("MakeEmpty", testNum+1, results, actual, expected);
    	//Note: There is no way to ensure that the freed memory is from the nodes that were cleared
    	System.out.println("\tFree Heap memory - prior to makeEmpty: "+before+", after makeEmpty: "+after);
    	
    	
    	
    	
    	LinkedList<LinkedList<Integer>> list2 = new LinkedList<LinkedList<Integer>>();
    	int filler = 11;
    	for(int i = 0; i < 10; i++){
    		LinkedList<Integer> temp = new LinkedList<Integer>();
    		for(int ll = 0; ll < 50; ll++){
    			temp.add(filler);
    		}
    		list2.add(temp);
    	} 
    	expected = new Object[]{list2};
    	actual = new Object[]{list2};
    	results = (actual[0].equals(expected[0]));
    	printTest("Equal to itself", testNum+2, results, actual, expected);
    	
    	LinkedList<Character> list3 = new LinkedList<Character>();
    	for(int i = 0; i < 10; i++){
    		list3.add((char)i);
    	} 
    	LinkedList<Character> list4 = new LinkedList<Character>();
    	for(int i = 9; i >= 0; i--){
    		list4.add((char)i);
    	}
    	expected = new Object[]{list3};
    	actual = new Object[]{list4};
    	results = !(actual[0].equals(expected[0]));
    	printTest("Not same order = not equal", testNum+3, results, actual, expected);
    	
    	list3.makeEmpty();
    	expected = new Object[]{0};
    	actual = new Object[]{list.size()};
    	results = (actual[0].equals(0));
    	printTest("MakeEmpty", testNum+4, results, actual, expected);
    	
    	list4 = new LinkedList<Character>();
    	for(int i = 0; i < 9; i++){
    		list4.add((char)i);
    	} 
    	expected = new Object[]{list3};
    	actual = new Object[]{list4};
    	results = !(actual[0].equals(expected[0]));
    	printTest("Not same size = not equal", testNum+5, results, actual, expected);
    	
    	list3.makeEmpty();
    	expected = new Object[]{0};
    	actual = new Object[]{list.size()};
    	results = (actual[0].equals(0));
    	printTest("MakeEmpty", testNum+6, results, actual, expected);
    }

    private static void printTest(String testName, int testNum, boolean result, Object actual, Object expected){
    	StringBuilder sb = new StringBuilder();
    	sb.append("Test "); sb.append(testNum);
    	if(result){
    		sb.append(" Passed, "); 
    	}
    	else{
    		sb.append(" Failed, ");
    	}
    	sb.append(testName); 
    	if(!result){
    		sb.append("\n\tactual/expected pair(s)");
    		sb.append(" - ("); sb.append(actual); 
    		sb.append(", "); sb.append(expected); sb.append(") ");
    	}
    	System.out.println(sb);
    }
    
  
}