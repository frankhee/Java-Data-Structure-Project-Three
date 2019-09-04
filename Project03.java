/*
 * @Author Frank He
 * @Version 2/14/18
 */
package osu.cse2123;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Project03 {

	public static void main(String[] args) {
		
		//Prompt user for file name
		Scanner in = new Scanner(System.in);
		System.out.print("Enter database filename: ");
		String fileName = in.nextLine();
		
		//Issue try statement
		try {
			File newFile = new File(fileName);
			Scanner fileScan = new Scanner(newFile);
			SimplePlayList finalReport = new SimplePlayList();
			
			//Use while loop to check file
			while (fileScan.hasNext()) {
				SimpleMusicTrack n = new SimpleMusicTrack();
				n.setName(fileScan.nextLine());
				n.setArtist(fileScan.nextLine());
				n.setAlbum(fileScan.nextLine());
				finalReport.addTrack(n);
			}
			
			//Print out initial statement
			System.out.println("Currently playing: No Song Playing");
			System.out.println("Next track to play: " + finalReport.peekAtNextTrack().getName());
			System.out.println("[P]lay next track");
			System.out.println("[A]dd a new track");
			System.out.println("[Q]uit");
			System.out.print(">");
			char choice = in.next().charAt(0);
			System.out.println();
			
			//Use if statements to check user input
			if(!finalReport.isEmpty()) {
				
				//Check to see if user wants to quit
				while (choice!=('q') && choice!=('Q')) {
					
					//Check to see if user want to play next track
					if (choice == ('p') || choice == ('P')) {
						System.out.println("Currently playing: " + finalReport.getNextTrack().getName());
						if(finalReport.getNextTrack()==null) {
							System.out.println("Next track to play: Play list is empty");
							System.out.println("[P]lay next track");
							System.out.println("[A]dd a new track");
							System.out.println("[Q]uit");
							System.out.print(">");
							choice = in.next().charAt(0);
							System.out.println();
							break;
					}
						else {
							System.out.println("Next track to play: " + finalReport.peekAtNextTrack().getName());
							System.out.println("[P]lay next track");
							System.out.println("[A]dd a new track");
							System.out.println("[Q]uit");
							System.out.print(">");
							choice = in.next().charAt(0);
							System.out.println();
						}
						}
					 
					
					//Check to see if user wants to add new track
					else if (choice == ('a') || choice == ('A')) {
						in.nextLine();
						System.out.print("Track name: ");
						String trackName = in.nextLine();
						
						System.out.print("Artist name: ");
						String artistName = in.nextLine();
												
						System.out.print("Album name: ");
						String albumName = in.nextLine();
						System.out.println();

						System.out.println("New track: " + trackName);
						System.out.println("Artist: " + artistName);
						System.out.println("Album: " + albumName);
						System.out.print("Are you sure you want to add this track [y/n] ?");
						char answer = in.next().charAt(0);
						
						
						//Add track if user put yes
						if (answer == ('Y') || answer == ('y')) {
							SimpleMusicTrack n = new SimpleMusicTrack();
							n.setName(trackName);
							n.setArtist(artistName);
							n.setAlbum(albumName);
							finalReport.addTrack(n);
							System.out.println();
							System.out.println("Currently playing: " + finalReport.getNextTrack().getName());
							System.out.println("Next track to play: " + finalReport.peekAtNextTrack().getName());
							System.out.println("[P]lay next track");
							System.out.println("[A]dd a new track");
							System.out.println("[Q]uit");
							System.out.print(">");
							choice = in.next().charAt(0);
							System.out.println();
						}
						else {
							System.out.println();
							System.out.println("Currently playing: " + finalReport.getNextTrack().getName());
							System.out.println("Next track to play: " + finalReport.peekAtNextTrack().getName());
							System.out.println("[P]lay next track");
							System.out.println("[A]dd a new track");
							System.out.println("[Q]uit");
							System.out.print(">");
							choice = in.next().charAt(0);
							System.out.println();
						}
					}
				}
				
				//Print out final summary of playlist
				System.out.println("Track remaining in play list");
				System.out.println("------------------------------------------------------------");
				
				int n = 1;
				while(!finalReport.isEmpty()) {
					SimpleMusicTrack o = (SimpleMusicTrack) finalReport.getNextTrack();
					System.out.println(n+" - " + o.getName()+" / "+ o.getArtist()+ " / "+o.getAlbum());
					n++;
				}
		}
			else {
				System.out.println("Play list is empty – no more tracks");
			}
		}
			
		//Catch any IOExceptions and print out error statement
		catch (IOException e) {
				System.out.println("ERROR");
		}
	}

}
