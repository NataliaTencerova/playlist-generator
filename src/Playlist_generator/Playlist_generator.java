package Playlist_generator;

import java.util.Scanner;

public class Playlist_generator {
	
	static Scanner sc = new Scanner(System.in);
	public static Playlist newPlaylist(Scanner sc) {
		String name;
		int length;
		double ranking;
		
		int number = Integer.parseInt(sc.nextLine());
		Track tracks[] = new Track[number];
		
		for(int i=0; i<tracks.length; i++) {
			name = sc.nextLine();
			length = Integer.parseInt(sc.nextLine());
			ranking = Double.parseDouble(sc.nextLine());
			Track s = new Track(name, length, ranking);
			tracks[i] = s;
		}
		
		Playlist playlist = new Playlist(tracks);
		
		return playlist;
	}
	
	public static Playlist selectedTracks(double minimalRanking, int minimalLength, Playlist playlist) {
			
			Playlist a = playlist.filterRanking(minimalRanking);
			Playlist b = a.shuffle();
			Playlist finish = b.selectLength(minimalLength);
			
			return finish;		
		}
	
	public static void main (String[] args) {
		System.out.print("");
		
		Playlist playlist = newPlaylist(sc);
		
		double minimalRanking = Double.parseDouble(args[0]);
		int minimalLength = Integer.parseInt(args[1]);
		Playlist selected = selectedTracks(minimalRanking, minimalLength, playlist);
		
		if(minimalLength>selected.getTotalLength()) {
			System.out.println("WARNING! Playlist is too short.");
		}
		System.out.println();
		System.out.println(selected.toString());
	}
}