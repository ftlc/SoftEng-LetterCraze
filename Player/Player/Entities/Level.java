package Player.Entities;
import Player.Entities.Dictionary;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import Player.Entities.Board;
import Player.Entities.Star;
import Player.Entities.Word;

public class Level {
	final int TOTAL_NUM_TILES = 6;
	String path;
	Position lastSelectedPosition;
	int num;
	Board board;
	Star star;
	int score;
	int highScore;
	Logic logic;
	Dictionary dictionary;
	ArrayList<Tile> currSelectedWord;
	ArrayList<Tile> lastSelectedWord;
	ArrayList<Word> selectedWords;
	ArrayList<Move> moves;
	boolean selectingWord;

	public Level(String path, int num) {
		this.path = path;
		this.num = num;
		this.score = 0;
		this.star = new Star(0,0,0);
		this.selectingWord = false;
		this.currSelectedWord = new ArrayList<Tile>();
		this.lastSelectedWord = new ArrayList<Tile>();
		this.selectedWords = new ArrayList<Word>();
		this.moves = new ArrayList<Move>();
		readLevel(path);
	}
	
	
	
	// Determine Level Type from First Line //
	//              of File                //
	public boolean readLevel(String path) {
		String currLine = null; // Buffer for line being read 
		try {
			// Open File //
			BufferedReader br = new BufferedReader(new FileReader(path));
			while ((currLine = br.readLine()) != null) {
				currLine = currLine.trim();
				if (currLine.equals("P")) { // Puzzle Case 
					this.logic = new PuzzleLogic(this);
					this.dictionary = new Dictionary();
					br.close();
					return logic.readFile(path);
				} else if (currLine.equals("L")) { // Lightning Case
					this.logic = new LightningLogic(this);
					this.dictionary = new Dictionary();
					br.close();
					return logic.readFile(path);
				} else if (currLine.equals("T")) { // Theme Case
					this.logic = new ThemeLogic(this);
					br.close();
					return logic.readFile(path);
				}
			}

			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}
	
	public boolean hasWord(String s) {
		return this.dictionary.hasWord(s);
	}
	
	public boolean saveHighScore(){
		int numStars = star.calculateStars(score);
		if(numStars > highScore){
			this.highScore = numStars;
			logic.writeHighScore(numStars, path);
			return true;
		}
		else{
			return false;
		}
	}
	public void reconstruct(){
		readLevel(path);
	}
	
	public void addWord(Word w){
		this.selectedWords.add(w);
	}
	
	public void addCurrTile(Tile t){
		this.currSelectedWord.add(t);
	}
	
	public boolean playWord(){
		return logic.playWord();
	}

	
	// Getters and Setters //
	public Board getBoard() { return board; }
	public Star getStar() { return star; }
	public int getScore() { return score; }
	public int getHighScore() { return highScore; }
	public Logic getLogic() { return logic; }
	public Dictionary getDictionary() { return dictionary; }
	public String getThirdBox() { return logic.getThirdBox(); }
	public ArrayList<Tile> getCurrSelectedWord() { return currSelectedWord; }
	public ArrayList<Tile> getLastSelectedWord() { return lastSelectedWord; }
	public boolean getSelectingWord() { return selectingWord; }
	public int getLevelNum() { return num; }
	public Position getLastSelectedPosition() { return lastSelectedPosition; }
	public ArrayList<Word> getSelectedWords() { return selectedWords; }
	public ArrayList<Move> getMoves(){ return moves; }
	
	public void addMove(Move m){
		moves.add(m);
	}
	
	public boolean undoRecentMove(){
		boolean completed = false;
		
		int size = moves.size();

		if (size > 0) {
			size--;
			Move move = moves.get(size);
			moves.remove(move);

			completed = move.undo();
			logic.undoMove();
		}
		return completed;
	}
	
	public void setSelectedWords(ArrayList<Word> w){
		selectedWords = w;
	}
	
	public void setDictionary(Dictionary d){
		this.dictionary = d;
	}
	
	public void setStar(Star s){
		this.star = s;
	}
	
	public void setBoard(Board b){
		this.board = b;
	}
	
	public void setHighScore(int s){
		this.highScore = s;
	}
	
	public void setSelectingWord(boolean b) {
		this.selectingWord = b;
	}
	
	public void setCurrSelectedWord(ArrayList<Tile> t) {
		this.currSelectedWord = t;
	}
	
	public void setLastSelectedWord(ArrayList<Tile> t) {
		this.lastSelectedWord = t;
	}
	
	public void setLastSelectedPosition(Position p){
		this.lastSelectedPosition = p;
	}
	
	public void setScore(int score){
		this.score = score;
	}
	
	public void addScore(int score){
		this.score += score;
	}
}
