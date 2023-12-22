package univers;

/**
 * The Profession interface defines the abilities and skills of different professions in the game.
 * It provides methods to modify character stats and use skills unique to each profession.
 */
public interface Profession {
	/**
     * Modifies the base health points (HP) based on the profession.
     * 
     * @param baseHp The base HP of the character.
     * @return The modified HP.
     */
	int modifyHp(int baseHp);
	
	/**
     * Modifies the base attack value based on the profession.
     * 
     * @param baseAttack The base attack value of the character.
     * @return The modified attack value.
     */
	int modifyAttack(int baseAttack);
	
	/**
     * Modifies the base magic points (MP) based on the profession.
     * 
     * @param baseMp The base MP of the character.
     * @return The modified MP.
     */
	int modifyMp(int baseMp);
	
	/**
     * Displays the skills available to this profession.
     */
	void displaySkills();
	
	/**
     * Uses a skill based on the given choice, applying effects to the specified player and enemy.
     * 
     * @param skillChoice The specific skill to use.
     * @param character The player character using the skill.
     * @param enemy The enemy targeted by the skill.
     */
	void useSkill(int skillChoice, PlayerCharacter character, Enemy enemy);
}
