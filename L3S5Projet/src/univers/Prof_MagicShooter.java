package univers;

public class Prof_MagicShooter implements Profession{
	  // @Override
	  // public void skillAction() {
	  //   System.out.println("Magic Shooter performs a skill action!");
	  // };

	  // @Override
	  // public void attackFromDistance() {
	  //   System.out.println("Magic Shooter performs a distance attack!");
	  // };
  @Override
  public int modifyHp(int baseHp) {
      return baseHp + 100; 
  }

  @Override
  public int modifyAttack(int baseAttack) {
      return baseAttack + 30; 
  }
  
  @Override
  public int modifyMp(int baseMp) {
  	return baseMp + 200;
  }
  
  //技能
  public void fireball(PlayerCharacter player, Enemy enemy) {
  	int skillCost = 100;
  	int damage = 250;
  	
      if (player.mp >= 50) {
    	  player.setMp(player.getMp() - skillCost);
    	  System.out.println(player.name + " cost " + skillCost + "MP to use the skill, you have now " + player.getMp() + "MP.");
          enemy.setHp(enemy.getHp() - damage);
          System.out.println(player.name + " uses Fireball and deals " + damage + " damage to " + enemy.getName());
      } else {
          System.out.println("Not enough MP to use Arrow Storm.");
      }
  }
  
  public void thunderStorm(PlayerCharacter player) {
      int skillCost = 300; 
      int damage = 600;

      if (player.getMp() >= skillCost) {
    	  player.setMp(player.getMp() - skillCost); // 减少MP
    	  System.out.println(player.name + " cost " + skillCost + "MP to use the skill, you have now " + player.getMp() + "MP.");
          System.out.println("使用雷暴，增加了 " + damage + " 点伤害！");
      } else {
          System.out.println("MP不足，无法使用技能！");
      }
  }
  
  //技能列表与使用
  @Override
  public void displaySkills() {
  	System.out.println("1.arrowStorm (Cost 100 MP)");
  	System.out.println("2.penetrateWeakness (Cost 300 MP)");
  };
  
  @Override
  public void useSkill(int skillChoice, PlayerCharacter player, Enemy enemy) {
  	if(skillChoice == 1) {
  		fireball(player,enemy);
  	};
  	if(skillChoice == 2) {
  		thunderStorm(player);
  	}
  }
}