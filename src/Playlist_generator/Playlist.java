package Playlist_generator;

public class Playlist {
	Track[] tracks;
	
	public Playlist(Track[] tracks) {
		this.tracks = tracks;
	}
	
	public int getTotalLength() {
		int totalLength = 0;
		
		for(int i = 0; i < tracks.length; i++) {
			totalLength += tracks[i].length;
		}
		
		return totalLength;
	}
	
	public Playlist filterRanking(double minimalRanking) {
		int j = 0;
		
		for(int i = 0; i < tracks.length; i++) {
			if(minimalRanking <= tracks[i].ranking) {
				j++;
			}
		}
		
		Track ranking[] = new Track[j];
		
/*		j = 0;
		
		for(int i = 0; i < tracks.length; i++) {
			if(minimalRanking <= tracks[i].ranking) {
				j++;
			}
		}
*/
		
		Playlist playlistByRanking = new Playlist(ranking);
		
		return playlistByRanking;
	}
	
	public Playlist selectLength(int minimalLength) {
		int j = 0;
		int length = 0;
		
		for(int i = 0; i < tracks.length && length < minimalLength; i++) {
			length += tracks[i].length;
			j++;
		}
		
		Track byLength[] = new Track[j];
		
		for(int i = 0; i < j; i++) {
			byLength[i] = tracks[i];
		}
		
		Playlist playlistByLength = new Playlist(byLength);
		
		return playlistByLength;
	}
	
	public Playlist shuffle() {
		Track mix[] = new Track[tracks.length];
		
		for(int i = 0; i < tracks.length; i++) {
			mix[i] = tracks[i];
		}
		
		for(int i = 0; i < mix.length; i++) {
			Track s = mix[i];
			int mixIndex = (int)Math.round(Math.random()*(mix.length-1));
			mix[i] = mix[mixIndex];
			mix[mixIndex] = s;
		}
		
		Playlist mixedPlaylist = new Playlist(mix);
		
		return mixedPlaylist;
	}
	
	public String toString() {
		int totalLength = getTotalLength();
		int lengthMin = totalLength/60;
		int lengthSec = totalLength%60;
		String playlistInfo = "";
		for(int i=0; i<tracks.length; i++) {
			playlistInfo = playlistInfo + tracks[i].toString() + "\n";
		}
		String spref = "";
		if (lengthSec<10) {
			spref = "0";
		}
		return playlistInfo + "[" +lengthMin + ":" + spref + lengthSec + "]";
	}
}