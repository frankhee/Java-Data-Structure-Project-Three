/*
 * @Author Frank He
 * @Version 2/13/18
 */
package osu.cse2123;

public interface PlayList {
	
	public PlayListTrack getNextTrack();
		// Removes track from PlayList and returns it to the caller
                // Returns null if the PlayList is empty
	public PlayListTrack peekAtNextTrack();
		// Returns next entry to the caller, but leaves it in the list
	public void addTrack(PlayListTrack track);
		// Adds this track to the playlist in the appropriate order
	public boolean isEmpty();
		// Returns true if the playlist is empty
}