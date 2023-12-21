package univers;

public interface Profession {
	// The special skill of this profession
	// void skillAction();
	int modifyHp(int baseHp);
	int modifyAttack(int baseAttack);
	int modifyMp(int baseMp);
	
	void displaySkills();
	
	void useSkill(int skillChoice, PlayerCharacter character, Enemy enemy);
}
