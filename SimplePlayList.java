/*
 * @Author Frank He
 * @Version 2/13/18
 */
package osu.cse2123;

import java.util.ArrayList;

public class SimplePlayList implements PlayList {
	private ArrayList<PlayListTrack>summaryTrack;
	private int i;
	public SimplePlayList() {
		summaryTrack = new ArrayList<PlayListTrack>();
		i = 0;
	}

	public PlayListTrack getNextTrack() {
		if(summaryTrack.isEmpty()) {
			return null;
		}
		else {
			return summaryTrack.remove(0);
		}
	}
	// Removes track from PlayList and returns it to the caller
            // Returns null if the PlayList is empty
	public PlayListTrack peekAtNextTrack() {
		
		if(summaryTrack.isEmpty()) {
			return null;
		}
		else {
		return summaryTrack.get(0);
		}
	}
	// Returns next entry to the caller, but leaves it in the list
	public void addTrack(PlayListTrack track) {
		summaryTrack.add(track);
	}
	// Adds this track to the playlist in the appropriate order
	public boolean isEmpty() {
		if(summaryTrack.isEmpty()) {
			return true;
		}
		else {
			return false;
		}
	}
	// Returns true if the playlist is empty
}


