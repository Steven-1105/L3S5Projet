import java.util.Scanner;

import univers.Race;
import univers.PlayerCharacter;
/**
 * A class to test character creation and experience gain for the game.
 */
public class Test {
	// Create a Object Scanner for keyboard input of user
	private static Scanner scanner = new Scanner(System.in);// create a Scanner object for input
	
	/**
     * The main method to run the character creation and experience gain test.
     *
     * @param args The command-line arguments (unused).
     */
	public static void main(String[] args) {
		// Ask the user to enter the name of the hero
		System.out.println("Please enter your character's name: ");
		String name = scanner.nextLine();
	
		//Selection of race
		Race race = chooseRace();
	
		//Creating a Character
		PlayerCharacter player = new PlayerCharacter(name,race);
		
		
		//ToString method
		System.out.println("Character created : \n" + player.toString());
		
		//Simulated character experience value increases until upgraded to level 10
		System.out.println("The character is being upgraded...");
		player.gainExperience(5400); // Assuming enough experience is given to get the character to at least level 10
	}
	
	// Method about the selection of race
	/**
     * A method to allow the user to choose a character's race.
     *
     * @return The selected character's race.
     */
	private static Race chooseRace() {
		Race race = null;
	    int choiceOfRace;
	
	    do {
	    	System.out.println("Please enter your character's race (1: ORC, 2: HUMAN, 3: ELF): ");
	    	choiceOfRace = scanner.nextInt();
	    	scanner.nextLine(); // Clear the newline left-over
	
	    	switch (choiceOfRace){
	    		case 1:
	    			race = Race.ORC;
	    			break;
    			case 2:
    				race = Race.HUMAN;
    				break;
    			case 3:
    				race = Race.ELF;
    				break;
    			default:
    				System.out.println("An invalid choice was entered, please try again.");
    				race = null; // Set to null to continue the loop
    		}
    	} while (race == null); // Continue looping until a valid race is selected
	    
	    return race;
	}
}