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
	
	/**
	 * Constructor for generating Level off of config file
	 * 
	 * @param path String representing path to file containing level configuration
	 * @param num Level number
	 * @return New level generated to specifications of config file
	 */

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
	
	
	
	/**
	 * Determine level type - pass off rest of level initiation to correct logic type
	 * 
	 * @param path Path to file to be read in
	 * @return true if read in successful
	 */
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
	
	/**
	 * Determine whether or not a string is a valid word
	 * 
	 * @param s String to be checked
	 * @return boolean representing whether s is a valid word
	 */
	public boolean hasWord(String s) {
		return this.dictionary.hasWord(s);
	}
	
	/**
	 * Save High Score to file if necessary
	 * 
	 * @return boolean representing whether or not high score was overwritten
	 */
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
	
	/**
	 * Reconstruct level based on config file
	 * 
	 * @return void
	 */
	public void reconstruct(){
		moves = new ArrayList<Move>();
		readLevel(path);
	}
	
	/**
	 * Add selected word to selected words data structure
	 * 
	 * @param w Word to be added
	 * @return void
	 */
	public void addWord(Word w){
		this.selectedWords.add(w);
	}
	
	/**
	 * Add a tile to the word currently being selected
	 * @param t Tile to be added
	 * @return void
	 */
	public void addCurrTile(Tile t){
		this.currSelectedWord.add(t);
	}
	
	/**
	 * Play word that has been selected
	 * @return boolean representing whether or not word was a valid move
	 */
	public boolean playWord(){
		return logic.playWord();
	}

	
	// Getters and Setters //
	/**
	 * Get Board
	 * @return Board corresponding to level
	 */
	public Board getBoard() { return board; }
	/**
	 * Get Star
	 * @return Star corresponding to level
	 */
	public Star getStar() { return star; }
	/**
	 * Get Score
	 * @return Current level score
	 */
	public int getScore() { return score; }
	/**
	 * Get High Score
	 * @return Highest number of stars scored on this level
	 */
	public int getHighScore() { return highScore; }
	/**
	 * Get Game Logic for Level
	 * @return Logic corresponding to Level
	 */
	public Logic getLogic() { return logic; }
	/**
	 * Get Dictionary
	 * @return Dictionary corresponding to Level 
	 */
	public Dictionary getDictionary() { return dictionary; }
	/**
	 * Get Third Box Text
	 * @return String that should go into third box in Level Area
	 */
	public String getThirdBox() { return logic.getThirdBox(); }
	/**
	 * Get Currently Selected Word
	 * @return ArrayList of Tiles that are currently being selected
	 */
	public ArrayList<Tile> getCurrSelectedWord() { return currSelectedWord; }
	/**
	 * Get Last Selected Word
	 * @return ArrayList of Tiles that were last selected
	 */
	public ArrayList<Tile> getLastSelectedWord() { return lastSelectedWord; }
	/**
	 * Get Selecting Word
	 * @return boolean representing whether or not a word is currently being selected
	 */
	public boolean getSelectingWord() { return selectingWord; }
	/**
	 * Get Level Number
	 * @return Number of level
	 */
	public int getLevelNum() { return num; }
	/**
	 * Get Last Selected Position
	 * @return Position of tile that was last selected
	 */
	public Position getLastSelectedPosition() { return lastSelectedPosition; }
	/**
	 * Get Selected Words
	 * @return ArrayList containing all words that have been selected in this level
	 */
	public ArrayList<Word> getSelectedWords() { return selectedWords; }
	/**
	 * Get Moves
	 * @return ArrayList of moves that have been made in this level
	 */
	public ArrayList<Move> getMoves(){ return moves; }
	
	/**
	 * Add Move to data structure tracking all moves made in a level
	 * @param m Move to be added
	 * @return void
	 */
	public void addMove(Move m){
		moves.add(m);
	}
	
	/**
	 * Undo most recently made move
	 * @return boolean representing whether or not move has been undone
	 */
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
	
	/**
	 * Set Selected Words ArrayList
	 * @param w ArrayList of words to set selectedWords to
	 */
	public void setSelectedWords(ArrayList<Word> w){
		selectedWords = w;
	}
	/**
	 * Set Dictionary for Level
	 * @param d Dictionary to set Level Dictionary to
	 */
	public void setDictionary(Dictionary d){
		this.dictionary = d;
	}
	/**
	 * Set Star for Level
	 * @param s Star object to set Level Star to
	 */
	public void setStar(Star s){
		this.star = s;
	}
	/**
	 * Set Board for Level
	 * @param b Board to set Level Board to
	 */
	public void setBoard(Board b){
		this.board = b;
	}
	/**
	 * Set High Score for Level
	 * @param s Integer to set High Score to
	 */
	public void setHighScore(int s){
		this.highScore = s;
	}
	/**
	 * Set Whether or not a word is currently being selected
	 * @param b Boolean representing whether or not word is currently being selected
	 */
	public void setSelectingWord(boolean b) {
		this.selectingWord = b;
	}
	/**
	 * Set Currently Selected Word
	 * @param t ArrayList of Tiles to set Currently Selected Word to
	 */
	public void setCurrSelectedWord(ArrayList<Tile> t) {
		this.currSelectedWord = t;
	}
	/**
	 * Set Last Selected Word
	 * @param t ArrayList of Tiles to set Last Selected Word to
	 */
	public void setLastSelectedWord(ArrayList<Tile> t) {
		this.lastSelectedWord = t;
	}
	/**
	 * Set Last Selected Position
	 * @param p Position object to set position of tile last selected to
	 */
	public void setLastSelectedPosition(Position p){
		this.lastSelectedPosition = p;
	}
	/**
	 * Set Score
	 * @param score Integer to set current level score to
	 */
	public void setScore(int score){
		this.score = score;
	}
	/**
	 * Add amount to current level score
	 * @param score Integer representing amount to add on
	 */
	public void addScore(int score){
		this.score += score;
	}
}
