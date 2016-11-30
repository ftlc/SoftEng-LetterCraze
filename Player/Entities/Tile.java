package Entities;

public class Tile{
	String letter;
	int value;
	int xCoord;
	int yCoord;
	
	public Tile(String l, int v, int x, int y){
		this.letter = l;
		this.value = v;
		this.xCoord = x;
		this.yCoord = y;
	}
	// Generate Random Letters //
	public String generateLetter(){
		String returnStr = "0";
		Random random = new Random();
		int num = random.nextInt(26) + 65;
		if(num == 81)
			returnStr = "Qu";
		else
			returnStr = Character.toString((char)num);
		return returnStr;
	}
}
