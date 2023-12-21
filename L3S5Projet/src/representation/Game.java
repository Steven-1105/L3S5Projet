package representation;

import java.util.Scanner;

import gui.GameFrame;
import univers.Boss;
import univers.Enemy;
import univers.PlayerCharacter;
import univers.Race;

/**
 * The Game class encapsulates all the elements and logic required to run the game.
 */
public class Game {
	// Attributes
	private static Scanner scanner = new Scanner(System.in);
    private GameFrame gameFrame;
    private PlayerCharacter player;
    
    // Constructor
    /**
     * Constructs a Game object with the specified GameFrame.
     * 
     * @param gameFrame The frame where the game will be displayed.
     */
    public Game(GameFrame gameFrame) {
        this.gameFrame = gameFrame;
        this.scanner = new Scanner(System.in);
    }
    
    /**
     * Starts the game by creating a character, initializing the game, and starting the game loop.
     */
    public void start() {
    	// Create a character
        PlayerCharacter player = createCharacter();

        // Initialize the characters and nodes needed for the game
        Node startNode = initializeGame(player, gameFrame);

        // Start the game
        startGame(startNode, gameFrame);
    }
    
    /**
     * Prompts the user to create a character by entering a name and choosing a race.
     * 
     * @return The created PlayerCharacter object.
     */
    private static PlayerCharacter createCharacter() {
        System.out.println("Please enter your character's name：");
        String name = scanner.nextLine();
        Race race = chooseRace();

        PlayerCharacter player = new PlayerCharacter(name, race);
        System.out.println("Character created : \n" + player.toString());

        return player;
    }
    
    /**
     * Prompts the user to choose a race for the character.
     * 
     * @return The chosen Race object.
     */
    private static Race chooseRace() {
        Race race = null;
        int choiceOfRace;

        do {
            System.out.println("Please enter your character's race (1：ORC，2：HUMAN，3：ELF)：");
            choiceOfRace = scanner.nextInt();
            scanner.nextLine(); // Clear line breaks

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
        } while (race == null); // Continue looping until a valid selection is made

        return race;
    }
    
    
    /**
     * Initializes the game by creating nodes and setting up the game structure.
     * 
     * @param player     The PlayerCharacter who will participate in the game.
     * @param gameFrame  The GameFrame where the game will be displayed.
     * @return The starting node of the game.
     */
    private static Node initializeGame(PlayerCharacter player, GameFrame gameFrame) {
    	// Creating enemies
        Enemy boss = new Boss("Boss", 100, 20);
        Enemy dragon = new Boss("Evil Dragon", 400, 75);

        // Create game nodes
        Node startNode = new InnerNode("You're a brave man, and now you're in the village.");
        DecisionNode decisionNode = new DecisionNode("Are you going to explore outside? \n1. yes, I'm going. \n2. No, I'm not ready yet.");
        TerminalNode endNodeFailure = new TerminalNode("You decide to stay in the village and become an ordinary villager.");
        ChanceNode chanceNode = new ChanceNode("You were brave enough to walk out of the village. \n Oh! There's a mysterious canyon ahead.");
        DecisionNode caveDecisionNode = new DecisionNode("Are you going into the canyon? \n1. yes, I'm going in. \n2. no, I'm going back to the village.");
        BattleNode bossBattleNode = new BattleNode("You've encountered a boss raid in the canyon! A fierce battle begins!", boss, player);
        
        // Create a decision node after winning a boss fight
        DecisionNode dragonDecisionNode = new DecisionNode("You have encountered the evil dragon that guards the canyon, are you going to challenge it? \n1. Yes, I'm going to challenge it. \n2. No, I'm going back to the village.");

        // Create a node to fight the dragon
        BattleNode dragonBattleNode = new BattleNode("You face the mighty dragon!", dragon, player);
        
        InnerNode endNodeBossFightWin = new InnerNode("After a fierce battle, you defeat the boss and gain experience."){
            @Override
            public Node chooseNext() {
            	display();
                System.out.println("The character is being upgraded...");
                player.gainExperience(5400); // Upgrade to level 10
                return dragonDecisionNode;
            }
        };
        
        TerminalNode endNodeBossFightLose = new TerminalNode("You've been defeated by the Boss and are permanently sleeping in the canyon.");
        TerminalNode endNodeReturn = new TerminalNode("You didn't enter the canyon, you went straight back to the village.");
        TerminalNode victoryNode = new TerminalNode("You defeated the evil dragon and became a legendary hero!");
        TerminalNode defeatNode = new TerminalNode("Though you were defeated by the evil dragon, your courage will be celebrated by future generations.");
        

        // Setting up connections between nodes 
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
        dragonBattleNode.setNextNode(0, victoryNode);  // Node after victory
        dragonBattleNode.setNextNode(1, defeatNode); // Node after failure
        
        // Decorate the entire structure
        return decorateNode(startNode, gameFrame);
    }
    
    
    /**
     * Decorates a node with an image and connects it with other nodes in the game structure.
     * 
     * @param node       The node to be decorated.
     * @param gameFrame  The GameFrame where the game will be displayed.
     * @return The decorated node.
     */
    private static Node decorateNode(Node node, GameFrame gameFrame) {
        if (node == null) {
            return null; // If the node is null, return null.
        }
        // Iterate over all Nodes, decorating them one by one with a recursive structure.
        if (node instanceof InnerNode) {
            InnerNode innerNode = (InnerNode) node;
            for (int i = 0; i < innerNode.getNextNodes().length; i++) {
                Node nextNode = innerNode.getNextNode(i);
                if (nextNode != null) {
                    innerNode.setNextNode(i, decorateNode(nextNode, gameFrame));
                }
            }
        }
        String imagePath = getImagePathForNode(node);
        return new ImageNode(node, imagePath, gameFrame);
    }
    
    
    /**
     * Retrieves the image path associated with a specific node based on its ID.
     * 
     * @param node The node whose image path is to be retrieved.
     * @return The image path as a String.
     */
    private static String getImagePathForNode(Node node) {
        int nodeId = node.getId();
        switch(nodeId) {
        case 1 :
        	return "image/start_image.png";
        case 2:
        case 3:
        case 11:
        case 12:
        case 13:
        	return "image/village.png";
        case 4:
        case 5:
        case 6:
        case 9:
        case 10:
        	return "image/adventure_start.png";
        case 7:
        case 8:
        	return "image/final_dragon.png";
        default:
        	return "image/start_image.png";
        }
    }

    /**
     * Starts the game loop, displaying nodes and navigating through the game structure based on player choices.
     * 
     * @param startNode  The starting node of the game.
     * @param gameFrame  The GameFrame where the game will be displayed.
     */
    private static void startGame(Node startNode, GameFrame gameFrame) {
        Node currentNode = startNode;
        currentNode.display(); // Display start node information
        if (currentNode instanceof ImageNode) {
            gameFrame.updateBackground(((ImageNode) currentNode).getImage());
        }

        while (!(currentNode instanceof TerminalNode)) {
//        	System.out.println("Current Node: " + currentNode.getDescription());
//        	System.out.println("Node Type: " + currentNode.getClass().getSimpleName());
        	// Perform node selection
            currentNode = currentNode.chooseNext();
//            System.out.println("Switched to Node: " + currentNode.getDescription());
//            System.out.println("Node Type: " + currentNode.getClass().getSimpleName());
            // Update the background image
            if (currentNode instanceof ImageNode) {
                gameFrame.updateBackground(((ImageNode) currentNode).getImage());
            }
        }
        // Game over, display end node information
        System.out.print("The game is over: " );
        currentNode.display();
    }
}
