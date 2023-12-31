package univers;

/**
 * The Berserker profession class that implements the {@link Profession} interface.
 * This class provides methods for modifying health points (HP), attack power, and mana points (MP) for a Berserker character,
 * as well as defining and using specific skills unique to this profession.
 */
public class Prof_Berserker implements Profession {
	 /**
      * Modifies the base HP of a Berserker character.
      *
      * @param baseHp The base HP value before modification.
      * @return The modified HP value after adding a bonus.
      */
	  @Override
	  public int modifyHp(int baseHp) {
	      return baseHp + 300; // 
	  }
	  
	 /**
	  * Modifies the base attack power of a Berserker character.
	  *
	  * @param baseAttack The base attack power value before modification.
	  * @return The modified attack power value after adding a bonus.
	  */
	  @Override
	  public int modifyAttack(int baseAttack) {
	      return baseAttack + 50; // 
	  }
	  
	 /**
	  * Modifies the base MP of a Berserker character.
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
	  * Performs the Sacrifice Attack skill action, reducing HP and dealing damage to an enemy.
	  *
	  * @param player The player character using the skill.
	  * @param enemy  The enemy character being attacked.
	  * @throws InsufficientHpException If there are not enough HP to use skill.
	  */
	  public void sacrificeAttack(PlayerCharacter player, Enemy enemy) {
		  int skillCost = 250;
		  int damage = 350;
	  	
	      try {if (player.getHp() >= skillCost) {
	      	  player.setHp(player.getHp() - skillCost); // HP reduction
	      	  System.out.println(player.name + " cost " + skillCost + "HP to use the skill, you have now " + player.getHp() + "HP.");
	          enemy.setHp(enemy.getHp() - damage);
	          System.out.println(player.name + " uses Sacrifice Attack and deals " + damage + " damage to " + enemy.getName() + ", and his remaining HP:" + enemy.getHp());
	      } else {
			  throw new InsufficientHpException("Not enough HP to use Sacrifice Attack.");
		  }
		  }catch (InsufficientHpException e) {
		        System.out.println("Exception: " + e.getMessage());
		  }
	  }
	  
	 /**
	  * Performs the Rampage skill action, reducing MP and increasing the character's attack power and HP.
	  *
	  * @param player The player character using the skill.
	  * @throws InsufficientMpException If there are not enough MP to use skill.
	  */
	  public void rampage(PlayerCharacter player) {
	      int skillCost = 100; 
	      int attackIncreasing = 100; //attack power increase
	      int hpIncreasing = 200; //HP increase
	
	      try {if (player.getMp() >= skillCost) {
	      	player.setMp(player.getMp() - skillCost); // MP reduction
	      	System.out.println(player.name + " cost " + skillCost + "MP to use the skill, you have now " + player.getMp() + "MP.");
	      	player.setAttack(player.getAttack() + attackIncreasing); // Attack Increase
	      	player.setHp(player.getHp() + hpIncreasing);// Restore HP
	        System.out.println("Using Rampage, increases" + attackIncreasing + " Points of Attack!");
	        System.out.println("Using Rampage, increases" + hpIncreasing + " Points of HP!");
	      } else {
			  throw new InsufficientMpException("Not enough MP to use Rampage.");
		  }
		  }catch (InsufficientMpException e) {
		        System.out.println("Exception: " + e.getMessage());
		  }
	  }
	  
	  //Skills list and utilization
	 /**
	  * Displays the list of available skills for the Berserker profession.
	  */
	  @Override
	  public void displaySkills() {
		  System.out.println("1.Sacrifice Attack (Cost 250 HP, damage: 350)");
		  System.out.println("2.Rampage (Cost 100 MP, increase: 100 attack and 200 HP)");
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
			  sacrificeAttack(player,enemy);
	  	  }
	  	  if(skillChoice == 2) {
	  		  rampage(player);
	  	  }
	  }
}