package Playlist_generator;

public class Track {
	
	public String name;
	public int length;
	public double ranking;
	
	public Track(String name, int length, double ranking) {
		
		this.name = name;
		this.length = length;
		this.ranking = ranking;
	}
	
	public int getlength() {
		return length;
	}
	
	public double getRanking() {
		return ranking;
	}
	
	public String stars(double ranking) {
		String rankingSymbols = "";
		
		double remainder = ranking % 1;
		double numberOfStars = ranking - remainder;
		
		for(int i = 0; i < numberOfStars; i++) {
			rankingSymbols += "*";
		}
		
		if(remainder >= 0.75) {
			rankingSymbols += "*";
		}
		
		else if(remainder >= 0.25 && remainder < 0.75) {
			rankingSymbols += ".";
		}
		
		return rankingSymbols;
	}
	
	public String toString() {
		int seconds = length%60;
		int minutes = length - seconds;
		
		String zero = "";
		if(seconds < 10) {
			zero = "0";
		}
		
		return name+" ["+minutes+":"+zero+seconds+"] ("+stars(ranking)+")";	}
}