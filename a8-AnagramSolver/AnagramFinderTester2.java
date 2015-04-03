/*
 * @author:  Jared Jones
 * Modified some the original tests to work without a no argument constructor
 */
public class AnagramFinderTester2{
  
  
  public static void main(String[] args){
    
    int testNum = 1;
    
    //test 1 constructor and toString
    String testDescrip = "Testing constructor and toString() on constructor with word given.";
    String testWord = "big brown bear";
    LetterInventory testerInventory = new LetterInventory(testWord);
    String expectedString = "abbbeginorrw";
    showResults(testerInventory.toString(), expectedString, testDescrip, testNum);
    testNum++;
    
    //test 2 constructor and isEmpty();
    testDescrip = "Testing constructor and isEmpty() on default constructor";
    boolean expectedBool = false;
    showResults(testerInventory.isEmpty(), expectedBool, testDescrip, testNum);
    testNum++;
    
    //test 3 constructor and isEmpty()
    
    testerInventory = new LetterInventory("");
    expectedBool = true;
    showResults(testerInventory.isEmpty(), expectedBool, testDescrip, testNum);
    testNum++;
    
    //test 4 test get()
    testDescrip = "Testing get() method";
    testWord = "jared writes great tests";
    testerInventory = new LetterInventory(testWord);
    char getTestChar = 'a';
    int expectedInt = 2;
    showResults(testerInventory.get(getTestChar), expectedInt, testDescrip, testNum);
    testNum++;
    
    //test 5 test get()
    getTestChar = 'z';
    expectedInt = 0;
    showResults(testerInventory.get(getTestChar), expectedInt, testDescrip, testNum);
    testNum++;
    
    //test 6 test size()
    testDescrip = "Testing size() method";
    expectedInt = 21;
    showResults(testerInventory.size(), expectedInt, testDescrip, testNum);
    testNum++;
    
    //test 7 test size()
    testWord = "live long and prosper";
    testerInventory = new LetterInventory(testWord);
    expectedInt = 18;
    showResults(testerInventory.size(), expectedInt, testDescrip, testNum);
    testNum++;
    
    //test 8 test isEmpty()
    testDescrip = "Testing isEmpty()";
    expectedBool = false;
    showResults(testerInventory.isEmpty(), expectedBool, testDescrip, testNum);
    testNum++;
    
    //test 9 test toString()
    testDescrip = "Testing toString()";
    expectedString = "adeegillnnoopprrsv";
    showResults(testerInventory.toString(), expectedString, testDescrip, testNum);
    testNum++;
    
    //test 10 test toString()
    testWord = "batcode";
    testerInventory = new LetterInventory(testWord);
    expectedString = "abcdeot";
    showResults(testerInventory.toString(), expectedString, testDescrip, testNum);
    testNum++;
    
    //test 11 test toString()
    testerInventory = new LetterInventory("");
    expectedString = "";
    showResults(testerInventory.toString(), expectedString, testDescrip, testNum);
    testNum++;
    
    //test 12 test add()
    testDescrip = "Testing add() method (relies on equal()";
    LetterInventory testerAdd = new LetterInventory("recursion");
    LetterInventory expectedLInv = new LetterInventory("recursion");
    showResults(testerInventory.add(testerAdd), expectedLInv, testDescrip, testNum);
    testNum++;
    
    //test 13 test add()
    testerAdd = testerAdd.add(new LetterInventory("recursion"));
    expectedLInv = new LetterInventory("recursion recursion");
    showResults(testerAdd, expectedLInv, testDescrip, testNum);
    testNum++;
    
    //test 14 test subtract()
    testDescrip = "Testing subtract() (relies on equals())";
    testerInventory = new LetterInventory("apples and bananas");
    expectedLInv = new LetterInventory("applesbananas");
    showResults(testerInventory.subtract(new LetterInventory("and")), expectedLInv, testDescrip, testNum);
    testNum++;
    
    //test 15 test subtract()
    testerInventory = new LetterInventory("the Joker");
    expectedLInv = new LetterInventory("joker");
    showResults(testerInventory.subtract(new LetterInventory("the")), expectedLInv, testDescrip, testNum);
    testNum++;
    
    //test 16 test add() and subtract()
    testDescrip = "Testing add() and subtract() (relies on equals())";
    testerInventory = new LetterInventory("Batman and NightWing");
    expectedLInv = new LetterInventory("Batman and Robin");
    testerInventory = testerInventory.subtract(new LetterInventory("nightwing"));
    testerInventory = testerInventory.add(new LetterInventory("RobIn"));
    showResults(testerInventory, expectedLInv, testDescrip, testNum);
    testNum++;
    
    //test 17 equals()
    testDescrip = "Testing equals() method";
    testerInventory = new LetterInventory("");
    expectedLInv = new LetterInventory("");
    showResults(testerInventory, expectedLInv, testDescrip, testNum);
    testNum++;
    
    //test 18 test equals()
    testerInventory = new LetterInventory("I pity the fool");
    expectedLInv = new LetterInventory("i PITY the Fool");
    showResults(testerInventory, expectedLInv, testDescrip, testNum);
    testNum++;
    
  }
  
  public static void showResults(Object actual, Object expected, String testDescrip, int testNum){
    StringBuilder result = new StringBuilder();
    result.append("Test num: " + testNum);
    result.append("\n" + testDescrip);
    result.append("\n...............");
    if(actual.equals(expected)){
      result.append("\nActual: " + actual + "\nExpected: " + expected + "\nTest Passed - Congrats baby :D");
    }else{
      result.append("\nActual: " + actual + "\nExpected: " + expected + "\nTest Failed - Sorry baby :(");
    }
    result.append("\n");
    
    System.out.println(result);
  }
  
  
  
}

