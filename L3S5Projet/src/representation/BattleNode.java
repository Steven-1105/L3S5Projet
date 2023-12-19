package representation;

import univers.PlayerCharacter;
import univers.Enemy;

public class BattleNode extends InnerNode{
	protected Enemy enemy;
	protected PlayerCharacter player;

	public BattleNode(String description, Enemy enemy, PlayerCharacter player){
		super(description);
		this.enemy = enemy;
		this.player = player;
	}
	
	@Override
	public void display() {
		System.out.println(description);
	}
	
	@Override
	// 玩家和Boss轮流攻击
	public Node chooseNext() {
        while (player.getHp() > 0 && enemy.getHp() > 0) {
            // 玩家攻击敌人
            enemy.setHp(enemy.getHp() - player.getAttack());
            System.out.println("你攻击了敌人，他的剩余血量：" + enemy.getHp());
            if (enemy.getHp() <= 0) break;
            // 敌人反击玩家
            player.setHp(player.getHp() - enemy.getAttack());
            System.out.println("敌人Boss攻击了你，你的剩余血量：" + player.getHp());
        }
        return player.getHp() > 0 ? nextNodes[0] : nextNodes[1];  // 假设索引 0 是胜利节点，1 是失败节点。

	}
}