import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*  
 *@author: Joshua Guenther
 */
public class AnagramFinderTester1{

    public static void main(String[] args) {
    	
    	LetterInventory resultInventory;
    	int testNum = 1;
    	LetterInventory li = new LetterInventory("");
    	int expected = 0;
    	int actual = li.size();
    	if(expected == actual){
    		System.out.println("PASSED Test "+testNum+": empty inventory size check");
    	}
    	else{
    		System.out.println("FAILED Test "+testNum+": empty inventory size check");
    	}
    	
    	testNum++;
    	expected = 13;
    	li = new LetterInventory("Isabelle Scott");
    	actual = li.size();
    	if(expected == actual){
    		System.out.println("PASSED Test "+testNum+": populated inventory size check");
    	}
    	else{
    		System.out.println("FAILED Test "+testNum+": populated inventory size check");
    	}
    	
    	testNum++;
    	li = new LetterInventory("Isabelle Scott");
    	if(!li.isEmpty()){
    		System.out.println("PASSED Test "+testNum+": isEmpty on populated inventory");
    	}
    	else{
    		System.out.println("FAILED Test "+testNum+": isEmpty on populated inventory");
    	}
    	
    	testNum++;
    	li = new LetterInventory("");
    	if(li.isEmpty()){
    		System.out.println("PASSED Test "+testNum+": isEmpty on empty inventory");
    	}
    	else{
    		System.out.println("FAILED Test "+testNum+": isEmpty on empty inventory");
    	}
    	
    	testNum++;
    	li = new LetterInventory("aabbbaa"); //4 a and 3 b
    	resultInventory = li.subtract(new LetterInventory("abababa"));  //4 a and 3 b
    	if(resultInventory.isEmpty()){
    		System.out.println("PASSED Test "+testNum+": IsEmpty after subtraction made it empty");
    	}
    	else{
    		System.out.println("FAILED Test "+testNum+": IsEmpty after subtraction made it empty");
    	}
    	
    	
    	testNum++;
    	expected = 1;
    	li = new LetterInventory("Isabelle Scott");
    	actual = li.get('i');
    	if(expected == actual){
    		System.out.println("PASSED Test "+testNum+": constructor -> properly counted upper case characters");
    	}
    	else{
    		System.out.println("FAILED Test "+testNum+": constructor -> properly counted upper case characters");
    	}
    	
    	testNum++;
    	expected = 2;
    	li = new LetterInventory("Isabelle Scott");
    	actual = li.get('t');
    	if(expected == actual){
    		System.out.println("PASSED Test "+testNum+": constructor -> properly counted lower case characters");
    	}
    	else{
    		System.out.println("FAILED Test "+testNum+": consctructor -> properly counted lower case characters");
    	}
    	
    	testNum++;
    	expected = 15;
    	li = new LetterInventory("h1, h0w 4r3 y0u. 175 b33n 4 l0n6 d4y c0d1n6.");
    	actual = li.size();
    	if(expected == actual){
    		System.out.println("PASSED Test "+testNum+": constructor -> parsed letters not in English alphabet");
    	}
    	else{
    		System.out.println("FAILED Test "+testNum+": consctructor -> parsed letters not in English alphabet");
    	}
    	
    	testNum++;
    	expected = 31;
    	li = new LetterInventory("4 n316hb0urh00d 0n 4 57r337 c4ll3d pr1v37 dr1v3. 4n 0wl, 51771n6 0n 7h3 57r337 516n fl135 0ff 70 r3v34l 4 my573r10u5 4pp34r1n6 0ld m4n w4lk1n6 7hr0u6h 4 f0r357 n34r 7h3 57r337. h3 570p5 47 7h3 574r7 0f 7h3 57r337 4nd 74k35 0u7 4 m3ch4n1c4l d3v1c3 4nd z4p5 4ll 7h3 l16h7 0u7 0f 7h3 l4mpp0575. h3 pu75 4w4y 7h3 d3v1c3 4nd 4 c47 m30w5. 7h3 m4n, 4lbu5 dumbl3d0r3, l00k5 d0wn 47 7h3 c47, wh1ch 15 4 74bby 4nd 15 51771n6 0n 4 br1ck l3d63.dumbl3d0r3: 1 5h0uld h4v3 kn0wn 7h47 y0u w0uld b3 h3r3...pr0f3550r mc60n464ll.7h3 c47 m30w5, 5n1ff5 0u7 4nd 7h3 c4m3r4 p4n5 b4ck 70 4 w4ll. 7h3 c475 5h4d0w 15 533n pr06r3551n6 1n70 4 hum4n. 7h3r3 4r3 f007573p5 4nd m1n3rv4 mc60n464ll 15 r3v34l3d.mc60n464ll: 600d 3v3n1n6, pr0f3550r dumbl3d0r3. 4r3 7h3 rum0ur5 7ru3, 4lbu5?dumbl3d0r3: 1'm 4fr41d 50, pr0f3550r. 7h3 600d, 4nd 7h3 b4d.");
    	actual = li.get('d');
    	if(expected == actual){
    		System.out.println("PASSED Test "+testNum+": get 'i' from large inventory");
    	}
    	else{
    		System.out.println("FAILED Test "+testNum+": get 'i' from large inventory");
    	}
    	
    	testNum++;
    	expected = 31;
    	li = new LetterInventory("4 n316hb0urh00d 0n 4 57r337 c4ll3d pr1v37 dr1v3. 4n 0wl, 51771n6 0n 7h3 57r337 516n fl135 0ff 70 r3v34l 4 my573r10u5 4pp34r1n6 0ld m4n w4lk1n6 7hr0u6h 4 f0r357 n34r 7h3 57r337. h3 570p5 47 7h3 574r7 0f 7h3 57r337 4nd 74k35 0u7 4 m3ch4n1c4l d3v1c3 4nd z4p5 4ll 7h3 l16h7 0u7 0f 7h3 l4mpp0575. h3 pu75 4w4y 7h3 d3v1c3 4nd 4 c47 m30w5. 7h3 m4n, 4lbu5 dumbl3d0r3, l00k5 d0wn 47 7h3 c47, wh1ch 15 4 74bby 4nd 15 51771n6 0n 4 br1ck l3d63.dumbl3d0r3: 1 5h0uld h4v3 kn0wn 7h47 y0u w0uld b3 h3r3...pr0f3550r mc60n464ll.7h3 c47 m30w5, 5n1ff5 0u7 4nd 7h3 c4m3r4 p4n5 b4ck 70 4 w4ll. 7h3 c475 5h4d0w 15 533n pr06r3551n6 1n70 4 hum4n. 7h3r3 4r3 f007573p5 4nd m1n3rv4 mc60n464ll 15 r3v34l3d.mc60n464ll: 600d 3v3n1n6, pr0f3550r dumbl3d0r3. 4r3 7h3 rum0ur5 7ru3, 4lbu5?dumbl3d0r3: 1'm 4fr41d 50, pr0f3550r. 7h3 600d, 4nd 7h3 b4d.");
    	actual = li.get('D');
    	if(expected == actual){
    		System.out.println("PASSED Test "+testNum+": get returns same answer for upper case characters");
    	}
    	else{
    		System.out.println("FAILED Test "+testNum+": get returns same answer for upper case characters");
    	}
    	
    	
    	testNum++;
    	li = new LetterInventory("Isabelle Scott");
    	resultInventory = li.subtract(new LetterInventory("queen"));
    	if(resultInventory == null){
    		System.out.println("PASSED Test "+testNum+": subtract and get negative frequency");
    	}
    	else{
    		System.out.println("FAILED Test "+testNum+": subtract and get negative frequency");
    	}
    	
    	testNum++;
    	li = new LetterInventory("aabbbaa"); //4 a and 3 b
    	expected = 0;
    	resultInventory = li.subtract(new LetterInventory("abababa"));  //4 a and 3 b
    	actual = resultInventory.size();
    	if(expected == actual){
    		System.out.println("PASSED Test "+testNum+": subtract and get 0 frequencies");
    	}
    	else{
    		System.out.println("FAILED Test "+testNum+": subtract and get 0 frequencies");
    	}
    	
    	
    	testNum++;
    	li = new LetterInventory("aaabbbhrrsu");
    	resultInventory = li.subtract(new LetterInventory("abash")); 
    	LetterInventory expectedInventory = new LetterInventory("abbrru");
    	if(expectedInventory.equals(resultInventory) && expectedInventory.size() == resultInventory.size()){
    		System.out.println("PASSED Test "+testNum+": subtract yields proper size in new inventory");
    	}
    	else{
    		System.out.println("FAILED Test "+testNum+": subtract yields proper size in new inventory");
    	}

    	testNum++;
    	li = new LetterInventory("");
    	expected = 0;
    	resultInventory = li.add(new LetterInventory(""));
    	actual = resultInventory.size();
    	if(expected == actual){
    		System.out.println("PASSED Test "+testNum+": add two empty LetterInventories");
    	}
    	else{
    		System.out.println("FAILED Test "+testNum+":  add two empty LetterInventories");
    	}
    	
    	testNum++;
    	li = new LetterInventory("To beeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
    	expected = 153;
    	resultInventory = li.add(new LetterInventory("OR nOt tO Beeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee"));
    	actual = resultInventory.size();
    	if(expected == actual){
    		System.out.println("PASSED Test "+testNum+": add two full LetterInventories");
    	}
    	else{
    		System.out.println("FAILED Test "+testNum+":  add two full LetterInventories");
    	}
    	
    	testNum++;
    	li = new LetterInventory("To beeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
    	resultInventory = new LetterInventory("oT BEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE");
    	if(li.equals(resultInventory)){
    		System.out.println("PASSED Test "+testNum+": equals of two similar LetterInventories of varying lower and upper case characters");
    	}
    	else{
    		System.out.println("FAILED Test "+testNum+":  equals of two similar LetterInventories of varying lower and upper case characters");
    	}
    	
    	testNum++;
    	li = new LetterInventory("One Fish, Two Fish, Red Fish, Blue Fish.");
    	expected = 153;
    	resultInventory = new LetterInventory("Black fish, Blue fish, Old fish, New fish.");
    	if(!li.equals(resultInventory)){
    		System.out.println("PASSED Test "+testNum+": equals of two different LetterInventories");
    	}
    	else{
    		System.out.println("FAILED Test "+testNum+":  equals of two different LetterInventories");
    	}
    	
    	testNum++;
    	li = new LetterInventory("One Fish, Two Fish, Red Fish, Blue Fish.");
    	expected = 153;
    	if(li.toString().equals("bdeeeffffhhhhiiiilnoorsssstuw")){
    		System.out.println("PASSED Test "+testNum+": toString of LetterInventory");
    	}
    	else{
    		System.out.println("FAILED Test "+testNum+":  toString of LetterInventory");
    	}
    	
    	testNum++;
    	li = new LetterInventory("h1, h0w 4r3 y0u. 175 b33n 4 l0n6 d4y c0d1n6.");
    	expected = 153;
    	if(li.toString().equals("bcddhhlnnnruwyy")){
    		System.out.println("PASSED Test "+testNum+": toString of LetterInventory composed mostly of non-english characters");
    	}
    	else{
    		System.out.println("FAILED Test "+testNum+": toString of LetterInventory composed mostly of non-english characters");
    	}
    	
    	
    	
    	
    	
    	
    }
    
    
    
    
    
    
}