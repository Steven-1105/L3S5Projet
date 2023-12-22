package univers;

/**
 * The Magic Shooter profession class that implements the {@link Profession} interface.
 * This class provides methods for modifying health points (HP), attack power, and mana points (MP) for a Magic Shooter character,
 * as well as defining and using specific skills unique to this profession.
 */
public class Prof_MagicShooter implements Profession{
	 /**
      * Modifies the base HP of a Magic Shooter character.
      *
      * @param baseHp The base HP value before modification.
      * @return The modified HP value after adding a bonus.
      */
	  @Override
	  public int modifyHp(int baseHp) {
	      return baseHp + 100; 
	  }
	 /**
	  * Modifies the base attack power of a Magic Shooter character.
	  *
	  * @param baseAttack The base attack power value before modification.
	  * @return The modified attack power value after adding a bonus.
	  */
	  @Override
	  public int modifyAttack(int baseAttack) {
	      return baseAttack + 30; 
	  }
	 /**
	  * Modifies the base MP of a Magic Shooter character.
	  *
	  * @param baseMp The base MP value before modification.
	  * @return The modified MP value after adding a bonus.
	  */
	  @Override
	  public int modifyMp(int baseMp) {
	  	return baseMp + 200;
	  }
	  
	  //Skills
	 /**
	  * Performs the Fireball skill action, reducing MP and dealing damage to an enemy.
	  *
	  * @param player The player character using the skill.
	  * @param enemy  The enemy character being attacked.
	  * @throws InsufficientMpException If there are not enough MP to use skill.
	  */
	  public void fireball(PlayerCharacter player, Enemy enemy) {
		  int skillCost = 100;
		  int damage = 250;
	  	
	      try {if (player.getMp() >= skillCost) {
	    	  player.setMp(player.getMp() - skillCost); // MP reduction
	    	  System.out.println(player.name + " cost " + skillCost + "MP to use the skill, you have now " + player.getMp() + "MP.");
	          enemy.setHp(enemy.getHp() - damage);
	          System.out.println(player.name + " uses Fireball and deals " + damage + " damage to " + enemy.getName() + ", and his remaining HP:" + enemy.getHp());
	      } else {
			  throw new InsufficientMpException("Not enough MP to use Fireball.");
		  }
		  }catch (InsufficientMpException e) {
		        System.out.println("Exception: " + e.getMessage());
		  }
	  }
	  
	 /**
	  * Performs the ThunderStorm skill action, reducing MP and dealing damage to an enemy.
	  *
	  * @param player The player character using the skill.
	  * @param enemy  The enemy character being attacked.
	  * @throws InsufficientMpException If there are not enough MP to use skill.
	  */
	  public void thunderStorm(PlayerCharacter player, Enemy enemy) {
	      int skillCost = 200; 
	      int damage = 600;
	
	      try {if (player.getMp() >= skillCost) {
	    	  player.setMp(player.getMp() - skillCost); // MP reduction
	    	  System.out.println(player.name + " cost " + skillCost + "MP to use the skill, you have now " + player.getMp() + "MP.");
	    	  enemy.setHp(enemy.getHp() - damage);
	    	  System.out.println(player.name + " uses ThunderStorm and deals " + damage + " damage to " + enemy.getName() + ", and his remaining HP:" + enemy.getHp());
	      } else {
			  throw new InsufficientMpException("Not enough MP to use ThunderStorm.");
		  }
		  }catch (InsufficientMpException e) {
		        System.out.println("Exception: " + e.getMessage());
		  }
	  }
	  
	  //Skills list and utilization
	 /**
	  * Displays the list of available skills for the Magic Shooter profession.
	  */
	  @Override
	  public void displaySkills() {
		  System.out.println("1.Fireball (Cost 100 MP, damage: 250)");
		  System.out.println("2.ThunderStorm (Cost 200 MP, damage: 600)");
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
			  fireball(player,enemy);
		  }
		  if(skillChoice == 2) {
			  thunderStorm(player,enemy);
		  }
	  }
}