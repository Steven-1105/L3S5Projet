package univers;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;

/**
 * Represents a player character in the game.
 * This class extends the base character class to include attributes and methods specific to player characters,
 * such as experience and profession.
 */
public class PlayerCharacter extends PersonnageDeBase {
	  //Attributs
	  protected int experience;
	  protected int currentLevel; //currentlevel
	  protected Profession profession = null; // No profession at the beginning
	  protected static Scanner scanner = new Scanner(System.in); // create a Scanner object for input

	  //Constructeurs
	  /**
	   * Constructs a new player character with the given name and race.
	   * The character's health points (HP), mana points (MP), and attack are initialized based on the race.
	   *
	   * @param name The name of the character.
	   * @param race The race of the character.
	   */
	  public PlayerCharacter (String name, Race race) {
	      super(name, 100, 100, 20, race);
	      this.hp += race.getHpBonus();
	      this.mp += race.getMpBonus();
	      this.attack += race.getAttackBonus();
	      this.experience = 0;
	      this.currentLevel = 1;
	  }
	  
	  //***************** methods about character's experience and selection of profession after level 10 *****************
	  //experience needed to level up

	 /**
	  * Returns the experience needed to level up.
	  *
	  * @return The experience required to level up, based on the current level.
	  */
	  public int getExperienceNeededToLevelUp(){
		  // Assuming it takes 100 experience points multiplied by the current level to level up
		  return 100 * currentLevel;
	  }
	  
	  
	  //Method of experience gain and leveling up
	  /**
	   * Increases the character's experience points and handles leveling up.
	   * When the experience exceeds the threshold required to level up, the character's level increases.
	   *
	   * @param exp The total experience gained.
	   */
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
	  /**
	   * Allows the player to choose a profession upon reaching level 10.
	   * This method presents the player with a choice of professions and applies the selected profession to the character.
	   */
	  private void selectProfession() {
	   try {System.out.println("------------------------------------------------------------------------");
	        System.out.println("|Congratulations on reaching level 10! You can now choose a profession.|");
	        System.out.println("------------------------------------------------------------------------");

	        int choice = 0;
	        while (choice < 1 || choice > 3) {
	            System.out.println("Please select a profession:");
	            System.out.println("1. Archer");
	            System.out.println("2. Berserker");
	            System.out.println("3. Magic Shooter");
	            System.out.print("Please enter choices (1-3):");

	            choice = scanner.nextInt();
	            scanner.nextLine(); // Read newline characters

	            switch (choice) {
	            	case 1:
	            		this.profession = new Prof_Archer();
	            		this.hp = profession.modifyHp(this.hp);
	            		this.attack = profession.modifyAttack(this.attack);
	            		this.mp = profession.modifyMp(this.mp);
	            		System.out.println("You are now an Archer!");
	            		break;
	            	case 2:
	            		this.profession = new Prof_Berserker();
	            		this.hp = profession.modifyHp(this.hp);
	            		this.attack = profession.modifyAttack(this.attack);
	            		this.mp = profession.modifyMp(this.mp);
	            		System.out.println("You are now a Berserker!");
	            		break;
	            	case 3:
	            		this.profession = new Prof_MagicShooter();
	            		this.hp = profession.modifyHp(this.hp);
	            		this.attack = profession.modifyAttack(this.attack);
	            		this.mp = profession.modifyMp(this.mp);
	            		System.out.println("You are now a Magic Shooter!");
	            		break;
	                default:
	                    System.out.println("Invalid entry, please re-enter.");
	                    choice = 0; // Reset the selection so that the loop continues
	                    break;
	            }
	        }
	        } catch (InputMismatchException e) {
	            System.err.println("Invalid input. Please enter a numeric value.");
	            scanner.next(); // Clear the invalid input
	            selectProfession(); // Retry the profession selection
	        } catch (NoSuchElementException e) {
	            System.err.println("Input operation was cancelled unexpectedly.");
	        }
	  }
	  
	  /**
	   * Handles the leveling up process for the character.
	   * This method updates the character's stats such as HP, MP, and attack based on the new level.
	   */
	  private void levelUp() {
	        this.currentLevel++;
	        this.experience -= getExperienceNeededToLevelUp(); // Subtract the threshold
	        
	        //Increase stats upon leveling up
	        //LEVEL UP change of HP/MP/ATTACK
	        changeHP(30 * (currentLevel - 1)+0.1*this.hp);
	        changeMP(50 * (currentLevel - 1)+0.1*this.mp);
	        changeAttack(10 * (currentLevel - 1)+0.1*this.attack);
	        System.out.println("Your level up to level " + this.currentLevel + "!");
	  }
	  
	  
	  
	  //******************************************************************************************************************
	  
	  //Getters
	  /**
	   * Gets the character's current experience points.
	   *
	   * @return The character's experience points.
	   */
	  public int getExperience() {
	    return experience;
	  }

	  /**
	   * Gets the character's current level.
	   *
	   * @return The character's level.
	   */
	  public int getCurrentLevel() {
	    return currentLevel;
	  }
	  /**
	   * Gets the character's chosen profession.
	   *
	   * @return The character's profession.
	   */
	  public Profession getProfession() {
			return this.profession;
	  }
	  
	  
	  //close the Scanner object
	  //scanner.close();
	  
	  // Override toString method to print all character information
	  @Override
	  public String toString() {
	    return super.toString() + "{Level = " + currentLevel + ", Experience Points = " + experience +"}";
	  }
}
	    