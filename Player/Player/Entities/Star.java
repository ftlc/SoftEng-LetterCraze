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
	public int calculateStars(){
	int stars =	getOneStar() + getTwoStar() + getThreeStar();
		return stars;
	}
	
	// Getters //
	public int getOneStar() { return oneStar; }
	public int getTwoStar() { return twoStar; }
	public int getThreeStar() { return threeStar; }
}

