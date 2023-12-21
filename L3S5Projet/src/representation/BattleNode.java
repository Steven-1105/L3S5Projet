package representation;

import univers.PlayerCharacter;

import java.util.Scanner;

import univers.Enemy;

public class BattleNode extends InnerNode{
	protected Enemy enemy;
	protected PlayerCharacter player;

	protected int playerInitialHp;
	protected int playerInitialMp;
	private Scanner scanner;
	protected boolean player_result = true;

	public BattleNode(String description, Enemy enemy, PlayerCharacter player){
	    //描述
		super(description);
		//添加玩家和敌人
	    this.enemy = enemy;
	    this.player = player;
	    // 存储初始HP和MP
	    this.playerInitialHp = player.getHp();
	    this.playerInitialMp = player.getMp();
	    //检测键盘输入
	    this.scanner = new Scanner(System.in);
	}

	  @Override
	  public void display() {
	    System.out.println(description);
	  }

	  @Override
	  // 玩家和Boss轮流攻击
	  public Node chooseNext() {
		  display();
		  System.out.println("战斗开始！");

	      // 战斗循环
	      while (enemy.getHp() > 0) {
	          // 玩家回合
	          System.out.println("你的回合");
	          System.out.println("选择你的行动：1.攻击 2.技能");
	          int choice = scanner.nextInt();

	          if (choice == 1) {
	              // 执行攻击
	              enemy.setHp(enemy.getHp() - player.getAttack());
	              System.out.println("你攻击了敌人，他的剩余血量：" + enemy.getHp());
	          } else if (choice == 2) {
	              // 执行技能
	              if (player.getProfession() != null) {
	                  // 显示并执行技能
	                  player.getProfession().displaySkills();
	                  System.out.println("选择一个技能:");
	                  int skillChoice = scanner.nextInt();
	                  player.getProfession().useSkill(skillChoice, player, enemy);
	              } else {
	                  System.out.println("您还没有职业，默认使用攻击");
	                  enemy.setHp(enemy.getHp() - player.getAttack());
		              System.out.println("你攻击了敌人，他的剩余血量：" + enemy.getHp());
	              }
	          }
	          // 检查敌人是否被击败
	          if (enemy.getHp() <= 0) {
	              break;
	          }
	          // 敌人回合
	          System.out.println("敌人的回合");
	          // 假设敌人执行某种攻击
	          player.setHp(player.getHp() - enemy.getAttack());
	          System.out.println("敌人Boss攻击了你，你的剩余血量：" + player.getHp());
	          
	          // 检查玩家是否被击败 (可选)
	          if (player.getHp() <= 0) {
	              System.out.println("你被击败了！");
	              player_result = false;
	              break;
	          }
	      }
	      System.out.println("战斗结束！");
	      //恢复玩家的初始数值
	      player.setHp(playerInitialHp);
          player.setMp(playerInitialMp);
          
	      return (player_result = true) ? nextNodes[0] : nextNodes[1];  // 假设索引 0 是胜利节点，1 是失败节点。
	  }
}