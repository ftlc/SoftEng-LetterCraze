package Entities;

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
		int numberStars = oneStar + twoStar + threeStar;
		
		return numberStars;
	}
}

