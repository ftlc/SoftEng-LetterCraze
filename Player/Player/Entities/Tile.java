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
		int sum  = 26;
		Random r = new Random();
		double randomValue = 0 + (100 - 0) * r.nextDouble();
		
		double prev = 0;
		for(int m = 0; m<sum ; m++){
			sw  = 0;
			double next	= prev + ll.get(m);
			
			ll2.add(next);
			prev = next;
			if(m == 25){
				sw  = 1;
			}
		}
	    int k = sum;
	    if(sw == 1){
	    for(k = sum -1 ; k>0 ; k--){
	    	if(randomValue  <= ll2.get(k) & randomValue >ll2.get(k-1)){
	    		return_letter = hm1.get(k);
	    	}
	    }
	    }
	

	
		return return_letter;

	      
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
