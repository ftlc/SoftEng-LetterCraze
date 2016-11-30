package Player.Entities;

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
	// Generate Random Letters //
	public String generateLetter(){
		String returnStr = "0";
		int num = random.nextInt(26) + 65;
		if(num == 81)
			returnStr = "Qu";
		else
			returnStr = Character.toString((char)num);
		return returnStr;
	}
	
	// Getters //
	public String getLetter(){ return letter; }
	public int getValue() { return value; }
	public int getXCoord() { return xCoord; }
	public int getYCoord() { return yCoord; }
	
	// Setters //
	public void setXCoord(int x) { xCoord = x; }
	public void setYCoord(int y) { yCoord = y; }
}
