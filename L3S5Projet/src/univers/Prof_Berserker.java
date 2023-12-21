package univers;

public class Prof_Berserker implements Profession {
	  // @Override
	  // public void skillAction() {
	  //   System.out.println("Berserker performs a skill action!");
	  // };
  @Override
  public int modifyHp(int baseHp) {
      return baseHp + 300; // 
  }

  @Override
  public int modifyAttack(int baseAttack) {
      return baseAttack + 50; // 
  }
  
  @Override
  public int modifyMp(int baseMp) {
  	return baseMp + 50;
  }
  
  //技能
  public void sacrificeAttack(PlayerCharacter player, Enemy enemy) {
  	int skillCost = 250;
  	int damage = 350;
  	
      if (player.hp >= 150) {
      	  player.setHp(player.getHp() - skillCost);
      	  System.out.println(player.name + " cost " + skillCost + "HP to use the skill, you have now " + player.getHp() + "HP.");
          enemy.setHp(enemy.getHp() - damage);
          System.out.println(player.name + " uses Sacrifice Attack  and deals " + damage + " damage to " + enemy.getName());
      } else {
          System.out.println("Not enough Hp to use Sacrifice Attack.");
      }
  }
  
  public void rampage(PlayerCharacter player) {
      int skillCost = 100; 
      int attackIncreasing = 100; //增加攻击力
      int hpIncreasing = 200;

      if (player.getMp() >= skillCost) {
      	player.setMp(player.getMp() - skillCost); // 减少MP
      	System.out.println(player.name + " cost " + skillCost + "MP to use the skill, you have now " + player.getMp() + "MP.");
      	player.setAttack(player.getAttack() + attackIncreasing); // 恢复HP
      	player.setHp(player.getHp() + hpIncreasing);
          System.out.println("使用暴走，增加了 " + attackIncreasing + " 点攻击力！");
          System.out.println("增加了 " + hpIncreasing + " 点HP！");
      } else {
          System.out.println("MP不足，无法使用技能！");
      }
  }
  
  //技能列表与使用
  @Override
  public void displaySkills() {
  	System.out.println("1.Sacrifice Attack (Cost 250 HP)");
  	System.out.println("2.Rampage (Cost 100 MP)");
  };
  
  @Override
  public void useSkill(int skillChoice, PlayerCharacter player, Enemy enemy) {
  	if(skillChoice == 1) {
  		sacrificeAttack(player,enemy);
  	};
  	if(skillChoice == 2) {
  		rampage(player);
  	}
  }
}