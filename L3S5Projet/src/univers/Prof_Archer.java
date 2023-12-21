package univers;

public class Prof_Archer implements Profession{
	  // @Override
	  // public void skillAction() {
	  //   System.out.println("Archer performs a skill action!");
	  // };

	  // @Override
	  // public void attackFromDistance() {
	  //   System.out.println("Archer performs a distance attack!");
	  // };
  @Override
  public int modifyHp(int baseHp) {
      return baseHp + 100;
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
  public void arrowStorm(PlayerCharacter player, Enemy enemy) {
  	int skillCost = 50;
  	int damage = 150;
  	
      if (player.mp >= 50) {
    	  player.setMp(player.getMp() - skillCost);
    	  System.out.println(player.name + " cost " + skillCost + "MP to use the skill, you have now " + player.getMp() + "MP.");
          enemy.setHp(enemy.getHp() - damage);
          System.out.println(player.name + " uses Arrow Storm and deals " + damage + " damage to " + enemy.getName());
      } else {
          System.out.println("Not enough MP to use Arrow Storm.");
      }
  }
  
  public void penetrateWeakness(PlayerCharacter player) {
      int skillCost = 100; 
      int attackIncreasing = 150; //增加攻击力

      if (player.getMp() >= skillCost) {
      	player.setMp(player.getMp() - skillCost); // 减少MP
      	System.out.println(player.name + " cost " + skillCost + "MP to use the skill, you have now " + player.getMp() + "MP.");
      	player.setAttack(player.getAttack() + attackIncreasing); // 增加攻击力
          System.out.println("使用弱点识破，增加了 " + attackIncreasing + " 点攻击力！");
      } else {
          System.out.println("MP不足，无法使用技能！");
      }
  }
  
  //技能列表与使用
  @Override
  public void displaySkills() {
  	System.out.println("1.arrowStorm (Cost 50 MP)");
  	System.out.println("2.penetrateWeakness (Cost 100 MP)");
  };
  
  @Override
  public void useSkill(int skillChoice, PlayerCharacter player, Enemy enemy) {
  	if(skillChoice == 1) {
  		arrowStorm(player,enemy);
  	};
  	if(skillChoice == 2) {
  		penetrateWeakness(player);
  	}
  };
  
  
}