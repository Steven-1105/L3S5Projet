package univers;
/**
 * The Archer profession class that implements the {@link Profession} interface.
 * This class provides methods for modifying health points (HP), attack power, and mana points (MP) for an Archer character,
 * as well as defining and using specific skills unique to this profession.
 */
public class Prof_Archer implements Profession{
	 /**
      * Modifies the base HP of an Archer character.
      *
      * @param baseHp The base HP value before modification.
      * @return The modified HP value after adding a bonus.
      */
	  @Override
	  public int modifyHp(int baseHp) {
	      return baseHp + 100;
	  }
	 /**
	  * Modifies the base attack power of an Archer character.
	  *
	  * @param baseAttack The base attack power value before modification.
	  * @return The modified attack power value after adding a bonus.
	  */
	  @Override
	  public int modifyAttack(int baseAttack) {
	      return baseAttack + 50; 
	  }
	 /**
	  * Modifies the base MP of an Archer character.
	  *
	  * @param baseMp The base MP value before modification.
	  * @return The modified MP value after adding a bonus.
	  */
	  @Override
	  public int modifyMp(int baseMp) {
		  return baseMp + 50;
	  }
	  
	  //Skills
	  /**
	   * Performs the Arrow Storm skill action, reducing MP and dealing damage to an enemy.
	   *
	   * @param player The player character using the skill.
	   * @param enemy  The enemy character being attacked.
	   */
	  public void arrowStorm(PlayerCharacter player, Enemy enemy) {
		  int skillCost = 50;
		  int damage = 150;
  	
		  try { if (player.getMp() >= skillCost) {
			  player.setMp(player.getMp() - skillCost);
			  System.out.println(player.name + " cost " + skillCost + "MP to use the skill, you have now " + player.getMp() + "MP.");
			  enemy.setHp(enemy.getHp() - damage);
			  System.out.println(player.name + " uses Arrow Storm and deals " + damage + " damage to " + enemy.getName() + ", and his remaining HP:" + enemy.getHp());
		  } else {
			  throw new InsufficientMpException("Not enough MP to use Arrow Storm.");
		  }
		  }catch (InsufficientMpException e) {
		        System.out.println("Exception: " + e.getMessage());
		  }
	   }
	  /**
	   * Performs the Penetrate Weakness skill action, reducing MP and increasing the character's attack power.
	   *
	   * @param player The player character using the skill.
	   */
	  public void penetrateWeakness(PlayerCharacter player) {
	      int skillCost = 100; 
	      int attackIncreasing = 150; // attack power increase
	     
	      try {if (player.getMp() >= skillCost) {
	    	  player.setMp(player.getMp() - skillCost); // MP reduction
	    	  System.out.println(player.name + " cost " + skillCost + "MP to use the skill, you have now " + player.getMp() + "MP.");
	    	  player.setAttack(player.getAttack() + attackIncreasing); // Increased attack power
	          System.out.println("Using Penetrate Weakness, increases" + attackIncreasing + " Points of Attack!");
	      } else {
	    	  throw new InsufficientMpException("Not enough MP to use Penetrate Weakness.");
	      }
	      } catch (InsufficientMpException e) {
	          System.out.println("Exception: " + e.getMessage());
	      }
	  }
  
	  //Skills list and utilization
	  /**
	   * Displays the list of available skills for the Archer profession.
	   */
	  @Override
	  public void displaySkills() {
		  System.out.println("1.Arrow Storm (Cost 50 MP, demage: 150)");
		  System.out.println("2.Penetrate Weakness (Cost 100 MP, increase: 150 attack)");
	  }
	  
	  /**
	   * Uses the selected skill based on the provided skill choice.
	   *
	   * @param skillChoice The chosen skill's index.
	   * @param player      The player character using the skill.
	   * @param enemy       The enemy character being targeted by the skill (if applicable).
	   */
	  @Override
	  public void useSkill(int skillChoice, PlayerCharacter player, Enemy enemy) {
		  if(skillChoice == 1) {
			  arrowStorm(player,enemy);
	  	  }
	  	  if(skillChoice == 2) {
	  		  penetrateWeakness(player);
	  	  }
	  }
}