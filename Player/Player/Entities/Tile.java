package Player.Entities;
import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import java.util.Random;


public class Tile{
	String letter;
	Random random;
	int value;
	int xCoord;
	int yCoord;
	
	/**
	 * Constructor for Tile. Pass it the tiles X and Y coordinate.
	 * The tile will randomly generate a letter for itself.
	 * 
	 * @param x
	 * @param y
	 */
	public Tile(int x, int y){
		this.xCoord = x;
		this.yCoord = y;
		
		this.random = new Random();
		this.letter = generateLetter();
		this.value = -1;
	}
	
	/**
	 * Constructor for Tile. Pass it the tiles X and Y coordinates,
	 * and also pass the tile its' letter value.
	 * 
	 * @param x
	 * @param y
	 * @param letter
	 */
	public Tile(int x, int y, String letter){
		this.xCoord = x;
		this.yCoord = y;
		
		this.random = new Random();
		this.letter = letter;
		this.value = -1;
	}
	
	/**
	 *
	 * @return random letter with appropriate weighting
	 */
	public String generateLetter(){
		HashMap<Integer, String> hm1 = new HashMap<Integer, String>();
		hm1.put(1, "a");
		hm1.put(2, "b");
		hm1.put(3, "c");
		hm1.put(4, "d");
		hm1.put(5, "e");
		hm1.put(6, "f");
		hm1.put(7, "g");
		hm1.put(8, "h");
		hm1.put(9, "i");
		hm1.put(10, "j");
		hm1.put(11, "k");
		hm1.put(12, "l");
		hm1.put(13, "m");
		hm1.put(14, "n");
		hm1.put(15, "o");
		hm1.put(16, "p");
		hm1.put(17, "qu");
		hm1.put(18, "r");
		hm1.put(19, "s");
		hm1.put(20, "t");
		hm1.put(21, "u");
		hm1.put(22, "v");
		hm1.put(23, "w");
		hm1.put(24, "x");
		hm1.put(25, "y");
		hm1.put(26, "z");
		
		LinkedList<Double> ll2 = new LinkedList<Double>();
		LinkedList<Double> ll = new LinkedList<Double>();
		ll.add(0.0);
		ll.add(8.167);
		ll.add(1.492);
		ll.add(2.782);
		ll.add(4.253);
		ll.add(12.702);
		ll.add(2.228);
		ll.add(2.015);
		ll.add(6.094);
		ll.add(6.966);
		ll.add(0.153);
		ll.add(0.772);
		ll.add(4.025);
		ll.add(2.406);
		ll.add(6.749);
		ll.add(7.507);
		ll.add(1.929);
		ll.add(0.095);
		ll.add(5.987);
		ll.add(6.327);
		ll.add(9.056);
		ll.add(2.758);
		ll.add(0.978);
		ll.add(2.360);
		ll.add(0.150);
		ll.add(1.974);
		ll.add(0.074);
		int sw = 0;
		String return_letter = null;
		int sum  = 27;
		Random r = new Random();
		double randomValue = 0 + (100 - 0) * r.nextDouble();
		
		double prev = 0;
		for(int m = 0; m<sum ; m++){
			sw  = 0;
			double next	= prev + ll.get(m);
			
			ll2.add(next);
			prev = next;
			if(m == 26){
				sw  = 1;
			}
		}
	   
	    if(sw == 1){
	    for(int k = 26 ; k>0 ; k--){
	    	if(randomValue  <= ll2.get(k) & randomValue >ll2.get(k-1)){
	    		return_letter = hm1.get(k);
	    		
	    	
	    	}
	    }
	    }
	
	    if(return_letter == null){
	    	return_letter = "e";
	    	System.out.println("error");
	    }
	   
	
		return return_letter;

	      
	}
	
	/**
	 * Resets the letter value of the Tile to ""
	 */
	public void resetLetter(){
		this.letter = "";
	}
	
	/**
	 * Sets the letter value of the Tile to the given string
	 * @param s
	 */
	public void setLetter(String s) {
		this.letter = s;
	}
	
	/**
	 * For debugging purposes.
	 */
	public String toString(){
		return this.letter;
	}

	/**
	 * 
	 * @return the letter contained within the tile
	 */
	public String getLetter(){ return letter; }
	
	/**
	 * 
	 * @return value of the tile
	 */
	public int getValue() { return value; }
	
	/**
	 * 
	 * @return the x-coordinate of the tile
	 */
	public int getXCoord() { return xCoord; }
	
	/**
	 * 
	 * @return the y-coordinate of the tile
	 */
	public int getYCoord() { return yCoord; }
	
	/**
	 * Set the x-coordinate of the tile
	 * @param x
	 */
	public void setXCoord(int x) { xCoord = x; }
	
	/**
	 * Set the y-coordinate of the tile
	 * @param y
	 */
	public void setYCoord(int y) { yCoord = y; }
}
