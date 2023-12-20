import java.util.Scanner;
import representation.*;
import univers.PlayerCharacter;
import univers.Race;
import univers.Boss;
import univers.Enemy;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
    	//创建游戏窗口
        GameFrame gameFrame = new GameFrame();
        gameFrame.launch();
        
        // 角色创建
        PlayerCharacter player = createCharacter();

        // 初始化游戏所需的角色和节点
        Node startNode = initializeGame(player);

        // 开始游戏
        startGame(startNode, gameFrame);
    }

    private static PlayerCharacter createCharacter() {
        System.out.println("Please enter your character's name：");
        String name = scanner.nextLine();
        Race race = chooseRace();

        PlayerCharacter player = new PlayerCharacter(name, race);
        System.out.println("Character created : \n" + player.toString());

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
        Enemy boss = new Boss("大Boss", 100, 20);
        Enemy dragon = new Boss("恶龙", 400, 75);

        // 创建游戏节点
        Node startNode = new InnerNode("你是一个勇者，现在你在村子里。", "image/start_image.png");
        DecisionNode decisionNode = new DecisionNode("你要去森林探险吗？\n1. 是的，我要去森林。\n2. 不，我还没准备好。", "image/village.png");
        TerminalNode endNodeFailure = new TerminalNode("你决定留在村子里，成为一个普通的村民。", "image/village.png");
        ChanceNode chanceNode = new ChanceNode("你勇敢地进入了森林。\n哦！前面有一个神秘的洞穴。", "image/adventure_start.png");
        DecisionNode caveDecisionNode = new DecisionNode("你要进入洞穴吗？\n1. 是的，我要进去。\n2. 不，我要回村子去。", "image/adventure_start.png");
        BattleNode bossBattleNode = new BattleNode("你在洞穴里遇到了Boss的突袭！一场激烈的战斗开始了！", boss, player, "image/adventure_start.png");
        
        // 创建Boss战斗胜利后的决策节点
        DecisionNode dragonDecisionNode = new DecisionNode("你遇到了守护洞穴的恶龙，你是否要挑战它？\n1. 是的，我要挑战恶龙。\n2. 不，我要回村子去。", "image/final_dragon.png");

        // 创建与恶龙战斗的节点
        BattleNode dragonBattleNode = new BattleNode("你面对着强大的恶龙！", dragon, player, "image/final_dragon.png");
        
        InnerNode endNodeBossFightWin = new InnerNode("经过一番激战，你战胜了Boss，并获得了经验。", "image/adventure_start.png"){
            @Override
            public Node chooseNext() {
            	display();
                System.out.println("The character is being upgraded...");
                player.gainExperience(5400); // 升级到10级
                return dragonDecisionNode;
            }
        };
        
        TerminalNode endNodeBossFightLose = new TerminalNode("你在洞穴里遇到了Boss！你被Boss打败了，永久的沉睡在了洞穴里。", "image/adventure_start.png");
        TerminalNode endNodeReturn = new TerminalNode("你没有进入洞穴，直接回到了村子。", "image/village.png");
        TerminalNode victoryNode = new TerminalNode("你战胜了恶龙，成为了传说中的英雄！", "image/village.png");
        TerminalNode defeatNode = new TerminalNode("虽然你被恶龙击败，但你的勇气将被后人传颂。", "image/village.png");
        

        // 设置节点之间的连接
        ((InnerNode) startNode).setNextNode(0, decisionNode);
        decisionNode.setNextNode(0, chanceNode);
        decisionNode.setNextNode(1, endNodeFailure);
        chanceNode.setNextNode(0, caveDecisionNode);
        chanceNode.setNextNode(1, dragonDecisionNode);
        caveDecisionNode.setNextNode(0, bossBattleNode);
        caveDecisionNode.setNextNode(1, endNodeReturn);
        bossBattleNode.setNextNode(0, endNodeBossFightWin);
        bossBattleNode.setNextNode(1, endNodeBossFightLose);
        dragonDecisionNode.setNextNode(0, dragonBattleNode);
        dragonDecisionNode.setNextNode(1, endNodeReturn);
        dragonBattleNode.setNextNode(0, victoryNode);  // 胜利后的节点
        dragonBattleNode.setNextNode(1, defeatNode);   // 失败后的节点
        

        return startNode; // 返回起始节点
    }


    private static void startGame(Node startNode, GameFrame gameFrame) {
        Node currentNode = startNode;
        currentNode.display(); // 显示起始节点信息
        gameFrame.updateBackground(currentNode.getImage()); // 初始图片

        while (!(currentNode instanceof TerminalNode)) {
            currentNode = currentNode.chooseNext();
            gameFrame.updateBackground(currentNode.getImage()); // 更新图片
        }
        // 游戏结束，显示终结节点信息
        System.out.print("游戏结束：" );
        currentNode.display();
        gameFrame.updateBackground(currentNode.getImage()); // 展示结束图片
    }
}
