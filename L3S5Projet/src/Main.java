import java.util.Scanner;
import representation.*;
import univers.PlayerCharacter;
import univers.Race;
import univers.Boss;
import univers.Enemy;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // 角色创建
        PlayerCharacter player = createCharacter();

        // 初始化游戏所需的角色和节点
        Node startNode = initializeGame(player);

        // 开始游戏
        startGame(startNode);
    }

    private static PlayerCharacter createCharacter() {
        System.out.println("Please enter your character's name：");
        String name = scanner.nextLine();
        Race race = chooseRace();

        PlayerCharacter player = new PlayerCharacter(name, race);
        System.out.println("Character created : \n" + player.toString());

        // 模拟角色升级到至少10级
        System.out.println("The character is being upgraded...");
        player.gainExperience(5400); // 假设给予足够的经验让角色至少升到10级

        return player;
    }

    private static Race chooseRace() {
        Race race = null;
        int choiceOfRace;

        do {
            System.out.println("Please enter your character's race (1：ORC，2：HUMAN，3：ELF)：");
            choiceOfRace = scanner.nextInt();
            scanner.nextLine(); // 清除换行符

            switch (choiceOfRace) {
                case 1:
                    race = Race.ORC;
                    break;
                case 2:
                    race = Race.HUMAN;
                    break;
                case 3:
                    race = Race.ELF;
                    break;
                default:
                    System.out.println("An invalid choice was entered, please try again.");
                    break;
            }
        } while (race == null); // 继续循环直到有效选择

        return race;
    }

    private static Node initializeGame(PlayerCharacter player) {
        // 创建敌人
        Enemy boss = new Boss("大Boss", 1000, 200);

        // 创建游戏节点
        Node startNode = new InnerNode("你是一个勇者，现在你在村子里。");
        DecisionNode decisionNode = new DecisionNode("你要去森林探险吗？\n1. 是的，我要去森林。\n2. 不，我还没准备好。");
        TerminalNode endNodeFailure = new TerminalNode("你决定留在村子里，成为一个普通的村民。");
        ChanceNode chanceNode = new ChanceNode("你勇敢地进入了森林。哦！前面有一个神秘的洞穴。");
        DecisionNode caveDecisionNode = new DecisionNode("你要进入洞穴吗？\n1. 是的，我要进去。\n2. 不，我要回村子去。");
        BattleNode battleNode = new BattleNode("一场激烈的战斗开始了！", boss, player);
        TerminalNode endNodeBossFightWin = new TerminalNode("你在洞穴里遇到了Boss！经过一番激战，你战胜了Boss，回到村子成为了英雄。");
        TerminalNode endNodeBossFightLose = new TerminalNode("你在洞穴里遇到了Boss！经过一番激战，你没能战胜Boss，但村民都会记得你的勇敢。");
        TerminalNode endNodeReturn = new TerminalNode("你没有进入洞穴，直接回到了村子。");

        // 设置节点之间的连接
        ((InnerNode) startNode).setNextNode(0, decisionNode);
        decisionNode.setNextNode(0, chanceNode);
        decisionNode.setNextNode(1, endNodeFailure);
        chanceNode.setNextNode(0, caveDecisionNode);
        chanceNode.setNextNode(1, endNodeReturn);
        caveDecisionNode.setNextNode(0, battleNode);
        caveDecisionNode.setNextNode(1, endNodeReturn);
        battleNode.setNextNode(0, endNodeBossFightWin);
        battleNode.setNextNode(1, endNodeBossFightLose);

        return startNode; // 返回起始节点
    }


    private static void startGame(Node startNode) {
        Node currentNode = startNode;
        currentNode.display(); // 显示起始节点信息

        while (!(currentNode instanceof TerminalNode)) {
            currentNode = currentNode.chooseNext();
        }
        // 游戏结束，显示终结节点信息
        System.out.print("游戏结束：" );
        currentNode.display();
    }
}
