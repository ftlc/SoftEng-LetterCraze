package Player.Entities;

public class Star{
	int oneStar;
	int twoStar;
	int threeStar;
	
	/**
	 * Star Constructor - create object that stores star thresholds
	 * @param one Threshold for one star
	 * @param two Threshold for two stars
	 * @param three Threshold for three stars
	 */
	public Star(int one, int two, int three){
		this.oneStar = one;
		this.twoStar = two;
		this.threeStar = three;
	}
	/**
	 * Calculate stars currently earned on level based off of thresholds
	 * @param score Current score
	 * @return number of stars currently earned
	 */
	public int calculateStars(int score){
		if(score >= threeStar)
			return 3;
		else if (score >= twoStar)
			return 2;
		else if (score >= oneStar)
			return 1;
		else
			return 0;
	}
	
	// Getters //
	
	/**
	 * Get threshold for one star
	 * @return Integer representing score necessary to achieve one star on level
	 */
	public int getOneStar() { return oneStar; }
	/**
	 * Get threshold for two stars
	 * @return Integer representing score necessary to achieve two stars on level
	 */
	public int getTwoStar() { return twoStar; }
	/**
	 * Get threshold for three stars
	 * @return Integer representing score necessary to achieve three stars on level
	 */
	public int getThreeStar() { return threeStar; }
	
	/**
	 * Set threshold for One star
	 * @param x Integer for first threshold
	 */
	public void setOneStar(int x) { oneStar = x; };
	/**
	 * Set threshold for Two stars
	 * @param x Integer for second threshold
	 */
	public void setTwoStar(int x) { twoStar = x; };
	/**
	 * Set threshold for Three stars
	 * @param x Integer for third threshold
	 */
	public void setThreeStar(int x) { threeStar = x; };
}

