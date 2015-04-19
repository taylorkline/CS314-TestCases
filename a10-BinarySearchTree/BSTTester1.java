/**
 * Test class for binary search tree
 * @author: Joshua Guenther
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.TreeSet;

public class BSTTester1 {

 public static void main(String[] args) {
   studentAdd();
   studentRemove();
   studentIsPresent();
   studentSize();
   studentHeight();
   studenGetAll();
   studentMax();
   studentMin();
   studentIterativeAdd();
   studenGet();
   studenGetAllLessThan();
   studenGetAllGreaterThan();
   studentNumNodesAtDepth();
 }

 /* Test the add method
  * Can't add null values
  * Ensure duplicates are not allowed
  * Ensure size is updated
  * Ensure added in right position
  */
 private static void studentAdd(){
  System.out.println();

  //Work with semi-balanced binary search tree
  BinarySearchTree<Integer> bs = new BinarySearchTree<Integer>();
  boolean result = bs.add(25);
  printTester("add", 1.1, result, "adding a value not present in tree returns true");

  bs.add(10);
  bs.add(2);
  bs.add(11);
  bs.add(26);
  result = bs.size() == 5;
  printTester("add", 1.2, result, "successful adds increments size");

  result = bs.get(0).intValue() == 2
    && bs.get(1).intValue() == 10 
    && bs.get(2).intValue() == 11
    && bs.get(3).intValue() == 25
    && bs.get(4).intValue() == 26;
  printTester("add", 1.3, result, "added in sorted order");

  result = !bs.add(26);
  printTester("add", 1.4, result, "adding a value present in tree returns false");

  result = bs.size() == 5;
  printTester("add", 1.5, result, "adding duplicates doesn't increment size");

  //Work with worst case binary search tree (like LinkedList)
  bs = new BinarySearchTree<Integer>();
  bs.add(5);
  bs.add(10);
  bs.add(15);
  bs.add(20);
  bs.add(25);
  result = bs.size() == 5;
  printTester("add", 2.1, result, "successful add increments size");

  result = bs.get(0).intValue() == 5
    && bs.get(1).intValue() == 10 
    && bs.get(2).intValue() == 15
    && bs.get(3).intValue() == 20
    && bs.get(4).intValue() == 25;
  printTester("add", 2.2, result, "added in sorted order");

  result = !bs.add(25);
  printTester("add", 2.3, result, "adding a value present in tree returns false");

  result = bs.size() == 5;
  printTester("add", 2.4, result, "adding duplicates doesn't increment size");

  System.out.println();
 }

 /* Test the get method
  * Get on empty tree should throw an error
  * Get of 0 with on a tree with only one node is root
  */
 private static void studenGet(){
  System.out.println();

  //Work with semi-balanced binary search tree
  BinarySearchTree<Integer> bs = new BinarySearchTree<Integer>();
  bs.add(25);

  boolean result = bs.get(0) == 25;
  printTester("get", 1, result, "only 1 node in tree");

  bs.add(10);
  bs.add(2);
  bs.add(11);
  bs.add(26);

  result = bs.get(0) == bs.min();
  printTester("get", 2, result, "kth of 0 is the min");

  result = bs.get(3) == 25;
  printTester("get", 3, result, "successful on filled tree - root");

  result = bs.get(bs.size()-1) == bs.max();
  printTester("get", 4, result, "kth of size()-1 is max");

  //Work with worst case binary search tree (like LinkedList)
  bs = new BinarySearchTree<Integer>();
  bs.iterativeAdd(65);
  bs.iterativeAdd(66);
  bs.iterativeAdd(67);
  bs.iterativeAdd(68);
  bs.iterativeAdd(69);
  result = bs.get(0) == bs.min();
  printTester("get", 5, result, "kth of 0 is the min");

  result = bs.get(bs.size()-1) == bs.max();
  printTester("get", 6, result, "kth of size()-1 is max");

  //Work with Perfect Binary tree
  BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
  bst.add(8);
  bst.add(4);
  bst.add(12);
  bst.add(2);
  bst.add(6);
  bst.add(10);
  bst.add(14);
  bst.add(1);
  bst.add(3);
  bst.add(5);
  bst.add(7);
  bst.add(9);
  bst.add(11);
  bst.add(13);
  bst.add(15);

  result = bst.get(0) == 1;
  printTester("get", 7, result, "successful on filled tree - min");

  result = bst.get(7) == 8;
  printTester("get", 8, result, "successful on filled tree - root");

  result = bst.get(bst.size()-1) == 15;
  printTester("get", 9, result, "successful on filled tree - max");

  /*
  //Work with worst case binary search tree (like LinkedList) -- stress test
  //Recursive get solution will result in stack overflow as the height increases
  System.out.println("     Warning: Test 10.1 & 10.2 might take some time");
  bst  = new BinarySearchTree<Integer>();
  int height = 128000;
  for(int i = 0; i <= height; i++){
   bst.iterativeAdd(i); //recursive add also results in stack overflow 
  }
  result = bst.get(0) == 0;
  printTester("get", 10.1, result, "min of large linear like tree");

  result = bst.get(bst.size() - 1) == height;
  printTester("get", 10.2, result, "max of large linear like tree");
   */

  System.out.println();
 }

 /* Test the getAll method
  * Empty tree should return empty list
  * Items shou
  */
 private static void studenGetAll(){
  System.out.println();

  BinarySearchTree<Integer> bs = new BinarySearchTree<Integer>();
  List<Integer> list = bs.getAll();
  boolean result = list.size() == 0;
  printTester("getAll", 1, result, "empty tree returns empty list");

  //Work with semi-balanced binary search tree
  bs.add(25);
  bs.add(10);
  bs.add(2);
  bs.add(11);
  bs.add(26);
  list = bs.getAll();
  result = list.size() == bs.size();
  printTester("getAll", 2.1, result, "semi-balanced tree -> list is the same size as the tree");

  result = list.get(0).intValue() == 2
    && list.get(1).intValue() == 10
    && list.get(2).intValue() == 11
    && list.get(3).intValue() == 25
    && list.get(4).intValue() == 26;
  printTester("getAll", 2.2, result, "semi-balanced tree -> values of list in ascending order");

  //Work with worst case binary search tree (like LinkedList)
  bs = new BinarySearchTree<Integer>();
  bs.add(65);
  bs.add(66);
  bs.add(67);
  bs.add(68);
  bs.add(69);

  list = bs.getAll();
  result = list.size() == bs.size();
  printTester("getAll", 3.1, result, "all nodes greater than root -> list is the same size as the tree");

  result = list.get(0).intValue() == 65
    && list.get(1).intValue() == 66
    && list.get(2).intValue() == 67
    && list.get(3).intValue() == 68
    && list.get(4).intValue() == 69;
  printTester("getAll", 3.2, result, "all nodes greater than root -> values of list in ascending order");

  //Work with worst case binary search tree (like LinkedList)
  bs = new BinarySearchTree<Integer>();
  bs.add(69);
  bs.add(68);
  bs.add(67);
  bs.add(66);
  bs.add(65);

  list = bs.getAll();
  result = list.size() == bs.size();
  printTester("getAll", 4.1, result, "all nodes less than root -> list is the same size as the tree");

  result = list.get(0).intValue() == 65
    && list.get(1).intValue() == 66
    && list.get(2).intValue() == 67
    && list.get(3).intValue() == 68
    && list.get(4).intValue() == 69;
  printTester("getAll", 4.2, result, "all nodes less than root -> values of list in ascending order");

  //Work with Perfect Binary tree
  bs = new BinarySearchTree<Integer>();
  bs.add(8);
  bs.add(4);
  bs.add(12);
  bs.add(2);
  bs.add(6);
  bs.add(10);
  bs.add(14);
  bs.add(1);
  bs.add(3);
  bs.add(5);
  bs.add(7);
  bs.add(9);
  bs.add(11);
  bs.add(13);
  bs.add(15);

  list = bs.getAll();
  result = list.size() == bs.size();
  printTester("getAll", 5.1, result, "perfect tree -> list is the same size as the tree");

  ArrayList<Integer> expected = new ArrayList<Integer>();
  for(int i = 1; i < 16; i++){
   expected.add(i);
  }
  Collections.sort(expected);
  result = expected.equals(list);
  printTester("getAll", 5.2, result, "perfect tree -> list in ascending order");

  bs = new BinarySearchTree<Integer>();
  expected = new ArrayList<Integer>();
  Random rnd = new Random();
  for(int i = 1; i < 1000; i++){
   int val = rnd.nextInt();
   bs.iterativeAdd(val);
   expected.add(val);
  }
  Collections.sort(expected);
  list = bs.getAll();
  result = expected.equals(list);
  printTester("getAll", 6, result, "random values -> list in ascending order");

  /*
  //Work with worst case binary search tree (like LinkedList) -- stress test
  //Recursive getAll solution will result in stack overflow as the height increases
  System.out.println("     Warning: Test 7.1 & 7.2 might take some time");
  bs  = new BinarySearchTree<Integer>();
  expected = new ArrayList<Integer>();
  int height = 128000;
  for(int i = 0; i <= height; i++){
   bs.iterativeAdd(i); //recursive add also results in stack overflow 
   expected.add(i);
  }
  list = bs.getAll();
  result = list.size() == bs.size();
  printTester("getAll", 7.1, result, "large linear like tree -> list is the same size as the tree");

  Collections.sort(expected);
  result = list.equals(expected);
  printTester("getAll", 7.2, result, "large linear like tree -> list is the same size as the tree");
   */

  System.out.println();
 }

 //Test the getAllGreaterThan method
 private static void studenGetAllGreaterThan(){
  System.out.println();

  BinarySearchTree<Integer> bs = new BinarySearchTree<Integer>();
  List<Integer> list = bs.getAllLessThan(-10);
  boolean result = list.size() == 0;
  printTester("getAllGreaterThan", 1, result, "empty tree -> cempty list");

  //Work with semi-balanced binary search tree
  bs.add(25);
  bs.add(10);
  bs.add(2);
  bs.add(11);
  bs.add(26);
  list = bs.getAllGreaterThan(23);
  result = list.size() == 2;
  printTester("getAllGreaterThan", 2.1, result, "average tree -> correct size of list");

  result = list.get(0).intValue() == 25
    && list.get(1).intValue() == 26;
  printTester("getAllGreaterThan", 2.2, result, "average tree -> values in ascending order");

  list = bs.getAllGreaterThan(2);
  result = !list.contains(2);
  printTester("getAllGreaterThan", 3.1, result, "average tree -> list doesn't contain threshold");

  result = list.size() == 4;
  printTester("getAllGreaterThan", 3.2, result, "average tree -> correct size of list");

  result = list.get(0).intValue() == 10
    && list.get(1).intValue() == 11
    && list.get(2).intValue() == 25
    && list.get(3).intValue() == 26;
  printTester("getAllGreaterThan", 3.3, result, "average tree -> values in ascending order");

  /*
  //Work with worst case binary search tree (like LinkedList) -- stress test
  //Recursive getAllGreaterThan solution will result in stack overflow as the height increases
  System.out.println("     Warning: Test 4 might take some time");
  bs  = new BinarySearchTree<Integer>();
  ArrayList<Integer> expected = new ArrayList<Integer>();
  int height = 128000;
  int threshold = 100;
  for(int i = 0; i <= height; i++){
   bs.iterativeAdd(i); //recursive add also results in stack overflow 
   if(i > threshold){
    expected.add(i);
   }
  }
  list = bs.getAllGreaterThan(threshold);
  Collections.sort(expected);
  result = list.equals(expected);
  printTester("getAllGreaterThan", 4, result, "large linear like tree -> values in ascending order");
   */

  System.out.println();
 }

 /* Test the getAllLessThan method
  * empty list is returned when called on empty tree
  * Returned list contains the proper elements in ascending order
  * Returned list doesn't contain threshold value
  */
 private static void studenGetAllLessThan(){
  System.out.println();

  BinarySearchTree<Integer> bs = new BinarySearchTree<Integer>();
  List<Integer> list = bs.getAllLessThan(-10);
  boolean result = list.size() == 0;
  printTester("getAllLessThan", 1, result, "empty tree -> empty list");

  //Work with semi-balanced binary search tree
  bs.add(25);
  bs.add(10);
  bs.add(2);
  bs.add(11);
  bs.add(26);
  list = bs.getAllLessThan(5);
  result = list.size() == 1;
  printTester("getAllLessThan", 2.1, result, "average tree -> correct size of list");

  result = list.get(0).intValue() == 2;
  printTester("getAllLessThan", 2.2, result, "average tree -> values in ascending order");

  list = bs.getAllLessThan(26);
  result = !list.contains(26);
  printTester("getAllLessThan", 3.1, result, "average tree -> list doesn't contain threshold");

  result = list.size() == 4;
  printTester("getAllLessThan", 3.2, result, "average tree -> correct size of list");

  result = list.get(0).intValue() == 2
    && list.get(1).intValue() == 10
    && list.get(2).intValue() == 11
    && list.get(3).intValue() == 25;
  printTester("getAllLessThan", 3.3, result, "average tree -> values in ascending order");

  /*
  //Work with worst case binary search tree (like LinkedList) -- stress test
  //Recursive getAllLessThan solution will result in stack overflow as the height increases
  System.out.println("     Warning: Test 4 might take some time");
  bs  = new BinarySearchTree<Integer>();
  ArrayList<Integer> expected = new ArrayList<Integer>();
  int height = 128000;
  int threshold = 100;
  for(int i = 0; i <= height; i++){
   bs.iterativeAdd(i); //recursive add also results in stack overflow 
   if(i < height - threshold){
    expected.add(i);
   }
  }
  list = bs.getAllLessThan(height - threshold);
  Collections.sort(expected);
  result = list.equals(expected);
  printTester("getAllLessThan", 4, result, "large linear like tree -> values in ascending order");
   */

  System.out.println();
 }

 /* Test the height method
  * Height of empty tree is -1
  * Height of only root is 0
  * Height of worst case tree - linear
  * Height of full/complete binary tree = logN (n = # of nodes)
  */
 private static void studentHeight(){
  System.out.println();

  BinarySearchTree<String> bs = new BinarySearchTree<String>();
  boolean result = bs.height() == -1;
  printTester("height", 1, result, "Empty tree");

  bs.add("Jack Hammer");
  result = bs.height() == 0;
  printTester("height", 2, result, "tree with only root node");

  bs.add("Ferris Wheeler");
  bs.add("Chris P. Bacon");
  bs.add("Anna Graham");
  bs.add("Earl E. Bird");
  bs.add("Peg Legge");
  bs.add("Ted E. Baer");
  bs.add("Stanley Cupp");
  bs.add("Rocky Rhoades");
  result = bs.height() == 4;
  printTester("height", 3, result, "tree with multiple nodes");

  //Work with Perfect Binary tree
  BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
  bst.add(8);
  bst.add(4);
  bst.add(12);
  bst.add(2);
  bst.add(6);
  bst.add(10);
  bst.add(14);
  bst.add(1);
  bst.add(3);
  bst.add(5);
  bst.add(7);
  bst.add(9);
  bst.add(11);
  bst.add(13);
  bst.add(15);
  result = bst.height() == 3;
  printTester("height", 4, result, "perfect binary tree");

  /*
  //Work with worst case binary search tree (like LinkedList) -- stress test
  //Recursive height solution will result in stack overflow as the height increases
  System.out.println("     Warning: Test 5 might take some time");
  bst = new BinarySearchTree<Integer>();
  int height = 128000;
  for(int i = 0; i <= height; i++){
   bst.iterativeAdd(i); //recursive add also results in stack overflow 
  }
  result = bst.height() == height;
  printTester("height", 5, result, "height of large linear like tree");
   */

  System.out.println();
 }

 /* Test the isPresent method
  * Nothing present in empty tree
  * Present in non-empty tree
  * Not present in non-empty tree
  */
 private static void studentIsPresent(){
  System.out.println();

  BinarySearchTree<String> bs = new BinarySearchTree<String>();
  boolean result = !bs.isPresent("Canoodle");
  printTester("isPresent", 1, result, "Nothing present in empty tree");

  bs.add("Batrachomyomachy");
  bs.add("Callipygian");
  bs.add("Borborygm");
  bs.add("Troglodyte");
  bs.add("Sialoquent");
  bs.add("Anencephalous");

  result = bs.isPresent("Sialoquent");
  printTester("isPresent", 2, result, "Present in non-empty tree");

  result = !bs.isPresent("Canoodle");
  printTester("isPresent", 3, result, "Not present in non-empty tree");

  /*
  //Work with worst case binary search tree (like LinkedList) -- stress test
  //Recursive isPresent solution will result in stack overflow as the height increases
  System.out.println("     Warning: Test 4.1 & 4.2 might take some time");
  BinarySearchTree<Integer> bst  = new BinarySearchTree<Integer>();
  int height = 128000;
  for(int i = 0; i <= height; i++){
   bst.iterativeAdd(i); //recursive add also results in stack overflow 
  }
  result = bst.isPresent(0);
  printTester("isPresent", 4.1, result, "min of large linear like tree");

  result = bst.isPresent(height);
  printTester("isPresent", 4.2, result, "max of large linear like tree");
   */

  System.out.println();
 }

 /*Test the iterativeAdd method
  * Can't add null values
  * Ensure duplicates are not allowed
  * Ensure size is updated
  * Ensure added in right position
  */
 private static void studentIterativeAdd(){
  System.out.println();

  //Work with semi-balanced binary search tree
  BinarySearchTree<Character> bs = new BinarySearchTree<Character>();

  boolean result =  bs.iterativeAdd('Z'); //ASCII - 90
  printTester("iterativeAdd", 1.1, result, "adding a value not present in tree returns true");

  bs.iterativeAdd('B'); //ASCII - 66
  bs.iterativeAdd('L'); //ASCII - 76
  bs.iterativeAdd('k'); //ASCII - 107
  result = bs.size() == 4;
  printTester("iterativeAdd", 1.2, result, "successful add increments size");

  result = bs.get(0).charValue() == 'B' 
    && bs.get(1).charValue() == 'L' 
    && bs.get(2).charValue() == 'Z'
    && bs.get(3).charValue() == 'k';
  printTester("iterativeAdd", 1.3, result, "added in sorted order");


  result = !bs.iterativeAdd('k'); //ASCII - 107
  printTester("iterativeAdd", 1.4, result, "adding a value present in tree returns false");

  result = bs.size() == 4;
  printTester("iterativeAdd", 1.5, result, "adding duplicates doesn't increment size");

  //Work with worst case binary search tree (like LinkedList)
  bs = new BinarySearchTree<Character>();
  bs.iterativeAdd('A'); //ASCII - 65
  bs.iterativeAdd('B'); //ASCII - 66
  bs.iterativeAdd('C'); //ASCII - 67
  bs.iterativeAdd('D'); //ASCII - 68
  bs.iterativeAdd('E'); //ASCII - 69
  result = bs.size() == 5;
  printTester("iterativeAdd", 2.1, result, "successful add increments size");

  result = bs.get(0).charValue() == 'A' 
    && bs.get(1).charValue() == 'B' 
    && bs.get(2).charValue() == 'C' 
    && bs.get(3).charValue() == 'D' 
    && bs.get(4).charValue() == 'E';
  printTester("iterativeAdd", 2.2, result, "added in sorted order");

  bs.iterativeAdd('C'); //ASCII - 67
  result = bs.size() == 5;
  printTester("iterativeAdd", 2.3, result, "adding duplicates doesn't increment size");

  System.out.println();
 }

 /* Test the max method
  * Can't check max of empty tree
  * Ensure actual maximum value is found
  */
 private static void studentMax(){
  System.out.println();

  //Work with semi-balanced binary search tree
  BinarySearchTree<Integer> bs = new BinarySearchTree<Integer>();
  bs.add(43);
  bs.add(-100);
  bs.add(-500);
  boolean result = bs.max() == 43;
  printTester("max", 1, result, "max found of populated tree");

  boolean removed = bs.remove(43);
  result = removed && bs.max() == -100;
  printTester("max", 2, result, "new max found after removing previous max");

  //Work with worst case binary search tree (like LinkedList)
  bs = new BinarySearchTree<Integer>();
  bs.add(1);
  bs.add(100);
  bs.add(200);
  bs.add(-1);
  bs.add(-100);
  result = bs.max() == 200;
  printTester("max", 3, result, "max found");

  removed = bs.remove(200);
  result = removed && bs.max() == 100;
  printTester("max", 4, result, "new max found after removing previous max");

  //Work with randomly filled binary search tree
  bs = new BinarySearchTree<Integer>();
  Random r = new Random();
  for(int i = 0; i < 10000; i++){
   bs.add(r.nextInt());
  }
  bs.add(Integer.MAX_VALUE);
  result = bs.max() == Integer.MAX_VALUE;
  printTester("max", 5, result, "max found");

  bs = new BinarySearchTree<Integer>();
  bs.add(43);
  result = bs.max() == bs.min();
  printTester("max", 6, result, "max of tree with one node is min also");

  System.out.println();
 }

 /* Test the min method
  * Can't check min of empty tree
  * Ensure actual minimum value is found
  */
 private static void studentMin(){
  System.out.println();

  //Work with semi-balanced binary search tree
  BinarySearchTree<Integer> bs = new BinarySearchTree<Integer>();
  bs.add(43);
  bs.add(-100);
  bs.add(-500);
  boolean result = bs.min() == -500;
  printTester("min", 1, result, "min found");

  bs.remove(-500);
  result = bs.min() == -100;
  printTester("min", 2, result, "new min found after removing previous min");

  //Work with worst case binary search tree (like LinkedList)
  bs = new BinarySearchTree<Integer>();
  bs.add(1);
  bs.add(100);
  bs.add(200);
  bs.add(-1);
  bs.add(-100);
  result = bs.min() == -100;
  printTester("min", 3, result, "min found");

  bs.remove(-100);
  result = bs.min() == -1;
  printTester("min", 4, result, "new min found after removing previous min");

  //Work with randomly filled binary search tree
  bs = new BinarySearchTree<Integer>();
  Random r = new Random();
  for(int i = 0; i < 10000; i++){
   bs.add(r.nextInt());
  }
  bs.add(Integer.MIN_VALUE);
  result = bs.min() == Integer.MIN_VALUE;
  printTester("min", 5, result, "min found");

  System.out.println();
 }

 /* Test the numNodesAtDepth method
  * Depth that is greater than the trees actual depth
  * Depth on an empty tree
  * Depth of 0 on filled tree
  * Valid depth of filled tree
  */
 private static void studentNumNodesAtDepth(){
  System.out.println();

  BinarySearchTree<String> bs = new BinarySearchTree<String>();
  boolean result = bs.numNodesAtDepth(0) == 0;
  printTester("numNodesAtDepth", 1, result, "Depth on an empty tree");

  /** Tree formed:
      [Bridgekeeper is thrown over]
        Sir Bedevere: How do know so much about swallows?
    King Arthur: What do you mean? An African or European swallow?
      King Arthur: Well, you have to know these things when you're a king, you know.
  Bridgekeeper: What... is the air-speed velocity of an unladen swallow?
    Bridgekeeper: Huh? I... I don't know that.
   */
  bs.add("Bridgekeeper: What... is the air-speed velocity of an unladen swallow?");
  bs.add("King Arthur: What do you mean? An African or European swallow?");
  bs.add("Bridgekeeper: Huh? I... I don't know that.");
  bs.add("[Bridgekeeper is thrown over]");      
  bs.add("Sir Bedevere: How do know so much about swallows?");
  bs.add("King Arthur: Well, you have to know these things when you're a king, you know.");

  result = bs.numNodesAtDepth(0) == 1;
  printTester("numNodesAtDepth", 2, result, "Depth of 0 (root) on filled tree");

  result = bs.numNodesAtDepth(1) == 2;
  printTester("numNodesAtDepth", 3, result, "Valid depth of filled tree");

  result = bs.numNodesAtDepth(15) == 0;
  printTester("numNodesAtDepth", 4, result, "Depth that is greater than the trees actual depth");

  /*
  //Work with worst case binary search tree (like LinkedList) -- stress test
  //Recursive numNodesAtDepth solution will result in stack overflow as the height increases
  System.out.println("     Warning: Test 5 might take some time");
  BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
  int height = 128000;
  for(int i = 0; i <= height; i++){
   bst.iterativeAdd(i); //recursive add also results in stack overflow 
  }
  int depth = 0;
  result = true;
  while(depth < height-1 && result){
   int d = bst.numNodesAtDepth(depth);
   result = d == 1;
   if(!result){
    System.out.println("\tFailing Test 5 at depth "+depth+": only found "+d+" nodes");
   }
   depth += 100;
  }
  printTester("numNodesAtDepth", 5, result, "large linear like tree has 1 node at every depth");
   */


  System.out.println();
 }

 /* Test the remove method
  * Remove from empty tree
  * Remove value that is present in tree -> return true
  * Size decrements when value is removed
  * Don't remove value not present in tree -> return false
  * Size does not decrement when value is removed
  * After removing x times from a tree with x nodes, it should be empty
  */
 private static void studentRemove(){
  System.out.println();

  BinarySearchTree<Integer> bs = new BinarySearchTree<Integer>();
  boolean result = !bs.remove(1337);
  printTester("remove", 1.1, result, "empty tree returns false");

  result = bs.size() == 0;
  printTester("remove", 1.2, result, "didn't decrement size when removing non-present value");

  //Work with semi-balanced binary search tree
  bs.add(25);
  bs.add(10);
  bs.add(2);
  bs.add(11);
  bs.add(26);
  result = bs.remove(2) && !bs.isPresent(2);
  printTester("remove", 2.1, result, "remove a value present in tree returns true");

  result = bs.size() == 4;
  printTester("remove", 2.2, result, "successful decrement of size when removing present value");

  result = !bs.remove(1337);
  printTester("remove", 3.1, result, "remove a value not present in tree returns false");

  result = bs.size() == 4;
  printTester("remove", 3.2, result, "didn't decrement size when removing non-present value");

  //Work with worst case binary search tree (like LinkedList)
  bs = new BinarySearchTree<Integer>();
  for(int i = 0; i < 10000; i++){
   bs.add(i);
  }
  boolean removed = true;
  int num = 0; 
  while(num < 10000 && removed){
   removed = bs.remove(num);
   num++;
  }

  result = removed && bs.size() == 0;
  printTester("remove", 4, result, "remove all elements from tree makes it empty");

  System.out.println();
 }

 /* Test the size method
  * Empty tree -> size 0
  * Tree with only root node -> size 1
  * perfect tree has (2^(n+1)) nodes, where n is the height of the tree
  */
 private static void studentSize(){
  System.out.println();

  BinarySearchTree<String> bs = new BinarySearchTree<String>();
  boolean result = bs.size() == 0;
  printTester("size", 1, result, "empty tree");

  bs.add("I am a nobody, nobody is perfect, therefore I am perfect.");
  result = bs.size() == 1;
  printTester("size", 2, result, "tree with one node");

  bs.add("How do you make holy water? You boil the hell out of it.");
  bs.add("What did the fish say when he swam into the wall? -- Damn");
  bs.add("I wondered why the frisbee was getting bigger, and then it hit me.");
  bs.add("What do you call a bear with no teeth? -- A gummy bear!");
  result = bs.size() == 5;
  printTester("size", 3, result, "tree with multiple nodes");

  //Work with Perfect Binary tree
  BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
  bst.add(8);
  bst.add(4);
  bst.add(12);
  bst.add(2);
  bst.add(6);
  bst.add(10);
  bst.add(14);
  bst.add(1);
  bst.add(3);
  bst.add(5);
  bst.add(7);
  bst.add(9);
  bst.add(11);
  bst.add(13);
  bst.add(15);
  //Property of Perfect Binary Trees: Perfect Binary trees have (2^(n+1)) nodes, where n is the height of the tree
  result = bst.size() == Math.pow(2, bst.height()+1)-1; 
  printTester("size", 4, result, "perfect binary tree: size = (2^(n+1)) nodes, where n is the height of the tree");

  System.out.println();
 }

 private static void printTester(String method, double testNum, boolean resultOfTest, String description){
  StringBuilder bs = new StringBuilder();
  if(resultOfTest){
   bs.append("Passed ");
  }
  else{
   bs.append("Failed ");
  }
  bs.append(method);
  bs.append(" ");
  bs.append("Test ");
  if(testNum % 1 == 0.0){ //integer number
   bs.append((int)testNum);
  }
  else{ //decimal number
   bs.append(String.format("%2.1f", testNum));
  }
  bs.append(": ");
  bs.append(description);
  System.out.println(bs);
 }
 
}