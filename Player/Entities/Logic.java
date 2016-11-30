package Entities;

public class Logic{

	Word selectedWord;
	int score;
	
	public Logic(Word selectedWord, int score){
		this.score = score;
		this.selectedWord = selectedWord;
	}
	public Word selectWord(Tile[] tiles){
		return null;
	}
	public boolean gameOver(){
		return false;
	}
	public boolean validWord(){
		return false;
	}
	public boolean resetBoard(){
		return false;
	}
	public boolean updateScore(int changeInScore){
		return false;
	}
	public boolean undoMove(){
		return false;
	}
}
