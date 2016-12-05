package Player.Entities;

public class Star{
	int oneStar;
	int twoStar;
	int threeStar;
	public Star(int one, int two, int three){
		this.oneStar = one;
		this.twoStar = two;
		this.threeStar = three;
	}
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
	public int getOneStar() { return oneStar; }
	public int getTwoStar() { return twoStar; }
	public int getThreeStar() { return threeStar; }
}

