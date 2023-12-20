package univers;
import java.util.Scanner;

public class PlayerCharacter extends PersonnageDeBase {
	  //Attributs
	  protected int experience;
	  protected int currentLevel; //currentlevel
	  protected Profession profession = null; // No profession at the beginning
	  protected static Scanner scanner = new Scanner(System.in); // create a Scanner object for input

	  //Constructeurs
	  public PlayerCharacter (String name, Race race) {
	    super(name, 100, 100, 20, 10, 5, race);
	    this.experience = 0;
	    this.currentLevel = 1;
	  }

	  
	  //***************** methods about character's experience and selection of profession after level 10 *****************
	  //experience needed to level up       
	  public int getExperienceNeededToLevelUp(){
		  // Assuming it takes 100 experience points multiplied by the current level to level up
		  return 100 * currentLevel;
	  }
	  
	  
	  //Method of experience gain and leveling up
	  public void gainExperience(int exp) {
	        this.experience += exp; //exp is the total experience gained

	        // Call the level up method if experience threshold is reached
	        while (this.experience >= getExperienceNeededToLevelUp()) {
	            levelUp();
	        }
	        // Print the current state of the character
	        System.out.println("---------------------------------------------------- Current character stats: "
	        		+ "----------------------------------------------------");
	        System.out.println(this.toString());
	        
	        // Check if the character can choose his profession after lever 10
	        if (this.currentLevel >= 10 && this.profession == null) {
	            selectProfession();
	        }
	  }
	  
	  
	  //Method of choosing a profession for a player
	  private void selectProfession() {
		  	System.out.println("------------------------------------------------------------------------");
	        System.out.println("|Congratulations on reaching level 10! You can now choose a profession.|");
	        System.out.println("------------------------------------------------------------------------");

	        int choice = 0;
	        while (choice < 1 || choice > 5) {
	            System.out.println("Please select a profession:");
	            System.out.println("1. Archer");
	            System.out.println("2. Berserker");
	            System.out.println("3. Magic Shooter");
	            System.out.println("4. NecroMancer");
	            System.out.println("5. Paladin");
	            System.out.print("Please enter choices (1-5):");

	            choice = scanner.nextInt();
	            scanner.nextLine(); // Read newline characters

	            switch (choice) {
	                case 1:
	                    this.profession = new Prof_Archer();
	                    System.out.println("You are now an Archer!");
	                    break;
	                case 2:
	                    this.profession = new Prof_Berserker();
	                    System.out.println("You are now a Berserker!");
	                    break;
	                case 3:
	                    this.profession = new Prof_MagicShooter();
	                    System.out.println("You are now a Magic Shooter!");
	                    break;
	                case 4:
	                    this.profession = new Prof_NecroMancer();
	                    System.out.println("You are now a NecroMancer!");
	                    break;
	                case 5:
	                    this.profession = new Prof_Paladin();
	                    System.out.println("You are now a Paladin!");
	                    break;
	                default:
	                    System.out.println("Invalid entry, please re-enter.");
	                    choice = 0; // Reset the selection so that the loop continues
	                    break;
	            }
	        }
	  }
	  
	  
	  private void levelUp() {
	        this.currentLevel++;
	        this.experience -= getExperienceNeededToLevelUp(); // Subtract the threshold

	        //Increase stats upon leveling up
	        //LEVEL UP change of HP/MP/ATTACK/DEFENSE/SPEED
	        changeHP(10 * (currentLevel - 1));
	        changeMP(15 * (currentLevel - 1));
	        changeAttack(1 * (currentLevel - 1));
	        changeDefense(1 * (currentLevel - 1));
	        changeSpeed(1 * (currentLevel - 1));

	        System.out.println("You leveled up to level " + this.currentLevel + "!");
	  }
	  //******************************************************************************************************************
	  
	  //Getters
	  public int getExperience() {
	    return experience;
	  }

	  public int getCurrentLevel() {
	    return currentLevel;
	  }
	  
	  
	  //close the Scanner object
	  //scanner.close();
	  
	  // Override toString method to print all character information
	  @Override
	  public String toString() {
	    return super.toString() + "{Level = " + currentLevel + ", Experience Points = " + experience +"}";
	  }
	  
}
	    