package representation;

import univers.Boss;
import univers.PlayerCharacter;
import univers.Race;

public class Game {
	public static void main(String[] args) {
		// 假设的玩家和Boss初始化
        PlayerCharacter player = new PlayerCharacter("勇者", Race.HUMAN);
        Boss boss = new Boss("大Boss", 1000, 20);
		
		Node startNode = new InnerNode("你是一个勇者，现在你在村子里。");
		
		DecisionNode decisionNode = new DecisionNode("你要去森林探险吗？\n1. 是的，我要去森林。\n2. 不，我还没准备好。");
		TerminalNode endNodeFailure = new TerminalNode("你决定留在村子里，成为一个普通的村民。");
		ChanceNode chanceNode = new ChanceNode("你勇敢地进入了森林。哦！前面有一个神秘的洞穴。");
		
		DecisionNode caveDecisionNode = new DecisionNode("你要进入洞穴吗？\n1. 是的，我要进去。\n2. 不，我要回村子去。");
		
		BattleNode battleNode = new BattleNode("一场激烈的战斗开始了！", boss, player);
		
		TerminalNode endNodeBossFightWin = new TerminalNode("你在洞穴里遇到了Boss！经过一番激战，你战胜了Boss，回到村子成为了英雄。");
		TerminalNode endNodeBossFightLose = new TerminalNode("你在洞穴里遇到了Boss！经过一番激战，你没能战胜Boss，但村民都会记得你的勇敢。");
		TerminalNode endNodeReturn = new TerminalNode("你没有进入洞穴，直接回到了村子。");
		
		// 设置节点的连接
		((InnerNode) startNode).setNextNode(0, decisionNode);
		decisionNode.setNextNode(0, chanceNode);
		decisionNode.setNextNode(1, endNodeFailure);
		chanceNode.setNextNode(0, caveDecisionNode);
		chanceNode.setNextNode(1, endNodeReturn);
		caveDecisionNode.setNextNode(0, battleNode);
		caveDecisionNode.setNextNode(1, endNodeReturn);
		battleNode.setNextNode(0, endNodeBossFightWin);  // 索引 0 为战斗胜利后的节点
		battleNode.setNextNode(1, endNodeBossFightLose);   // 索引 1 为战斗失败后的节点
		
		// 游戏的起始点
		Node currentNode = startNode;
		currentNode.display();
		while (!(currentNode instanceof TerminalNode)) {
		    currentNode = currentNode.chooseNext();
		}
		currentNode.display(); // 显示最终结果
	}
}