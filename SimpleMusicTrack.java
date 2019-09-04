/*
 *   @author Frank He
 *   @version 2/12/18
 */

package osu.cse2123;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class SimpleMusicTrack implements PlayListTrack {
	private String track;
	private String artist;
	private String album;

	
	//Initialize empty variables
	public SimpleMusicTrack() {
		track = "";
		artist = "";
		album = "";
	}

	
	//Return track name 
	public String getName() {
		return track;
	}
	
	//Set track name 
	public void setName(String name) {
		track = name;
	}

	
	//Return artist name
	public String getArtist() {
		return artist;
	}

	//Set artist name
	public void setArtist(String artist) {
		this.artist = artist;
	}

	//Return album name
	public String getAlbum() {
		return album;
	}

	//Set album name
	public void setAlbum(String album) {
		this.album = album;
	}

	
	//Return true if file has nextline and assign values to variables 
	public boolean getNextTrack(Scanner infile) {
		boolean answer = true;
		try{
			while(infile.hasNext()) {
				track = infile.nextLine();
				artist = infile.nextLine();
				album = infile.nextLine();
				break;
		}
			return answer;
		}
		catch(Exception e) {
			answer = false;	
			return answer;
		}
	}
	
	//Return true if the artist name and track name is the same 
	public boolean equals(SimpleMusicTrack i) {
		boolean result = false;
		if(i instanceof SimpleMusicTrack) {
			SimpleMusicTrack t1 = (SimpleMusicTrack)i;
			if(this.track.equals(t1.getName())&&this.artist.equals(t1.getArtist())&&this.album.equals(t1.getAlbum())) {
				result = true;
			}
		}
		return result;
	}
	
	//Return string combining artist name and track name
	public String toString() {
		String answer = "'"+artist+" / "+track;
		return answer;
		}
}
