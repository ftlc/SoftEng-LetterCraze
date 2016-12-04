package Player.Entities;

import java.util.Random;
import java.util.HashMap;
import java.util.Iterator;

import java.util.Set;

public class Tile{
	String letter;
	Random random;
	int value;
	int xCoord;
	int yCoord;
	
	public Tile(int x, int y){
		this.xCoord = x;
		this.yCoord = y;
		
		this.random = new Random();
		this.letter = generateLetter();
		this.value = -1;
	}
	public Tile(int x, int y, String letter){
		this.xCoord = x;
		this.yCoord = y;
		
		this.random = new Random();
		this.letter = letter;
		this.value = -1;
	}
	// Generate Random Letters //
	public String generateLetter(){
		HashMap<Double, String> hm = new HashMap<Double, String>();
		hm.put(8.167, "a");
		hm.put(1.492, "b");
		hm.put(2.782, "c");
		hm.put(4.253, "d");
		hm.put(12.702, "e");
		hm.put(2.228, "f");
		hm.put(2.015, "g");
		hm.put(6.094, "h");
		hm.put(6.966, "i");
		hm.put(0.153, "j");
		hm.put(0.772, "k");
		hm.put(4.025, "l");
		hm.put(2.406, "m");
		hm.put(6.749, "n");
		hm.put(7.507, "o");
		hm.put(1.929, "p");
		hm.put(0.095, "qu");
		hm.put(5.987, "r");
		hm.put(6.327, "s");
		hm.put(9.056, "t");
		hm.put(2.758, "u");
		hm.put(0.978, "v");
		hm.put(2.360, "w");
		hm.put(0.150, "x");
		hm.put(1.974, "y");
		hm.put(0.074, "z");
		
	     Set<Double> set = hm.keySet();
	    
	      double sum = 0;
	      Iterator<Double> iterator = set.iterator();
	      while(iterator.hasNext()){
	        Double element = (Double)iterator.next();
	        sum  = sum + element;
	      }
		
	 	  Random rand = new Random(); 
	 	  //give back a value between 0 and sum
	      int value = rand.nextInt((int) (sum  + 1));
	      
	      Set<Double> set1 = hm.keySet();
	    
	      Iterator<Double> iterator1 = set1.iterator();
	      int i = 0;
	      while(iterator.hasNext()){
	    	 
	    	  Double element1 = (Double)iterator1.next();
	    	  if(value < element1){
	    		  //returns a letter
	    	    return hm.get(i);
	    	  }
	    	  value-= element1;
	    	  i++;
	      }
	      //should never get here
		return hm.get(i);
	      
	    	}

	
	// Getters //
	public String getLetter(){ return letter; }
	public int getValue() { return value; }
	public int getXCoord() { return xCoord; }
	public int getYCoord() { return yCoord; }
	
	// Setters //generateLetter()
	public void setXCoord(int x) { xCoord = x; }
	public void setYCoord(int y) { yCoord = y; }
}
