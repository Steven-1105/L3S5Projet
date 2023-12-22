package representation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Save.GameSave;
import Save.GameSaveState;
import gui.GameFrame;
import univers.Boss;
import univers.Enemy;
import univers.PlayerCharacter;
import univers.Race;

/**
 * The Game class encapsulates all the elements and logic required to run the text-based adventure game.
 * It manages game initialization, character creation, and the main game loop.
 */
public class Game {
	// Attributes
	transient static Scanner scanner = new Scanner(System.in);
    private transient GameFrame gameFrame;
    private transient PlayerCharacter player;
    // Constructor
    /**
     * Constructs a Game object with the specified GameFrame.
     * 
     * @param gameFrame The frame where the game will be displayed.
     */
    public Game(GameFrame gameFrame) {
        this.gameFrame = gameFrame;
        Game.scanner = new Scanner(System.in);
    }
    
    /**
     * Starts the game by creating a character, initializing the game, and starting the game loop.
     */
    public void start() {
    	// Create a character
        this.player = createCharacter();

        // Initialize the characters and nodes needed for the game
        Node startNode = initializeGame(this.player, gameFrame);

        // Start the game
        startGame(startNode, gameFrame);
    }
    
    /**
     * Prompts the user to create a character by entering a name and choosing a race.
     * 
     * @return The created PlayerCharacter object.
     */
    private static PlayerCharacter createCharacter() {
        System.out.println("Please enter your character's name: ");
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
            System.out.println("Please enter your character's race (1: ORC, 2: HUMAN, 3: ELF): ");
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
     * It creates enemies, game nodes, and connects them to form the game narrative.
     * 
     * @param player     The PlayerCharacter who will participate in the game.
     * @param gameFrame  The GameFrame where the game will be displayed.
     * @return The starting node of the game.
     */
    private static Node initializeGame(PlayerCharacter player, GameFrame gameFrame) {
    	// Creating enemies
        Enemy boss = new Boss("Boss", 100, 20);
        Enemy dragon = new Boss("Evil Dragon", 1000, 175);

        // Create game nodes
        Node startNode = new InnerNode("You're a brave man, and now you're in the village.");
        DecisionNode decisionNode = new DecisionNode("Are you going to explore outside? \n1. yes, I'm going. \n2. No, I'm not ready yet.");
        TerminalNode endNodeFailure = new TerminalNode("You decide to stay in the village and become an ordinary villager.");
        ChanceNode chanceNode = new ChanceNode("You were brave enough to walk out of the village. \nOh! There's a mysterious canyon ahead.");
        DecisionNode canyonDecisionNode = new DecisionNode("Are you going into the canyon? \n1. yes, I'm going in. \n2. no, I'm going back to the village.");
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
        ((InnerNode) startNode).addNextNode(decisionNode);
        decisionNode.addNextNode(chanceNode);
        decisionNode.addNextNode(endNodeFailure);
        chanceNode.addNextNode(canyonDecisionNode);
        chanceNode.addNextNode(dragonDecisionNode);
        canyonDecisionNode.addNextNode(bossBattleNode);
        canyonDecisionNode.addNextNode(endNodeReturn);
        bossBattleNode.addNextNode(endNodeBossFightWin);
        bossBattleNode.addNextNode(endNodeBossFightLose);
        dragonDecisionNode.addNextNode(dragonBattleNode);
        dragonDecisionNode.addNextNode(endNodeReturn);
        dragonBattleNode.addNextNode(victoryNode);  // Node after victory
        dragonBattleNode.addNextNode(defeatNode); // Node after failure
        
        
        // Decorate the entire structure
        return decorateNode(startNode, gameFrame);
    }
    
    
    /**
     * Decorates a node with images and music and connects it with other nodes in the game structure.
     * 
     * @param node       The node to be decorated.
     * @param gameFrame  The GameFrame where the game will be displayed.
     * @return The decorated node, enhanced with visual and audio features.
     */
    private static Node decorateNode(Node node, GameFrame gameFrame) {
        if (node == null) {
            return null; // If the node is null, return null.
        }
        
        String imagePath = getImagePathForNode(node); // Get the path to the image corresponding to the node
        Node decoratedNode = new ImageNode(node, imagePath, gameFrame); // Decorate nodes with images
        
        // Add music for TerminalNode only
        if (node instanceof TerminalNode) {
            String soundPath = getSoundPathForNode(node); // Get the music path corresponding to the node
            decoratedNode = new SoundNode(decoratedNode, soundPath); // Decorate nodes with music
            // System.out.println("SoundNode Decorated: " + node.getDescription() + " with sound " + soundPath); // Debugging information
        }
        
        // If the node is an InnerNode, recursively decorate all its nextNodes.
        if (node instanceof InnerNode) {
            InnerNode innerNode = (InnerNode) node;
            List<Node> decoratedNextNodes = new ArrayList<>();
            for (Node nextNode : innerNode.getNextNodes()) {
                decoratedNextNodes.add(decorateNode(nextNode, gameFrame)); // Recursive decoration
            }
            innerNode.setNextNodes(decoratedNextNodes); // Update the list of decorated nextNodes.
        }
        return decoratedNode; // Return decorated nodes
    }
    
    
    /**
     * Retrieves the image path associated with a specific node based on its type or identifier.
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
        	return "image/village.png";
        case 12:
        	return "image/Hero.png";
        case 13:	
        	return "image/dragon_Lose.png";
        case 4:
        case 5:
        	return "image/Canyon.png";
        case 9:
        	return "image/Boss_Win.png";
        case 10:
        	return "image/adventure_start.png";
        case 7:
        case 8:
        	return "image/final_dragon.png";
        case 6:
        	return "image/Boss.png";
        default:
        	return "image/start_image.png";
        }
    }
    
    /**
     * Retrieves the sound path associated with a specific TerminalNode based on its type or identifier.
     * 
     * @param node The node whose sound path is to be retrieved.
     * @return The sound path as a String.
     */
    private static String getSoundPathForNode(Node node) {
        int nodeId = node.getId();
        switch(nodeId) {
        	// return different music file paths based on different node IDs
            case 9:
            case 12:
                return "music/Victory_music.mp3"; // Music for Victory
            case 13:
                return "music/Defeat_music.mp3"; // Music for Failure
            default:
                return "music/bgm.mp3"; // Default Music
        }
    }

    /**
     * Starts the game loop, displaying nodes and navigating through the game structure based on player choices.
     * It updates the game frame with images and handles the progression between different nodes.
     * 
     * @param startNode  The starting node of the game.
     * @param gameFrame  The GameFrame where the game will be displayed.
     */
    private void startGame(Node startNode, GameFrame gameFrame) {
    	if (gameFrame == null) {
            throw new IllegalStateException("GameFrame is null in startGame.");
        }
        Node currentNode = startNode;
        currentNode.display(); // Display start node information
        if (currentNode instanceof ImageNode) {
            gameFrame.updateBackground(((ImageNode) currentNode).getImage());
        }

        while (!(currentNode instanceof TerminalNode)) {
//        	System.out.println("Current Node: " + currentNode.getDescription());
//        	System.out.println("Node Type: " + currentNode.getClass().getSimpleName());
        	// pause option when boss fight win
        	if (currentNode.getId() == 7) {
        		if (checkForPause()) {
                    showPauseMenu(currentNode);
        		}
            }
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
    
    /**
     * Saves the current game state to a file, including the player's character and current node.
     * 
     * @param currentNode The current node in the game from which the player will continue when the game is loaded.
     */
    private void saveGame(Node currentNode) {
        if (player != null) {
            GameSaveState gameState = new GameSaveState(player, currentNode);
            GameSave.saveGame("savegame.ser", gameState);
        } else {
            System.out.println("No game data to save. Start a new game first.");
        } 
    }
    
    /**
     * Checks whether the player wants to pause the game.
     * 
     * @return true if the player chooses to pause, false otherwise.
     */
    private boolean checkForPause() {
        System.out.println("Press 'P' to pause. Press any other key to continue. (You can save the game in the pause menu)");
        String input = scanner.nextLine();
        return input.equalsIgnoreCase("P");
    }
    
    /**
     * Displays a pause menu allowing the player to save the game or continue playing.
     * 
     * @param currentNode The current node in the game, used for saving the game state.
     * @return true if the player chooses to quit, false otherwise.
     */
    private boolean showPauseMenu(Node currentNode) {
        System.out.println("Press 'S' to save game. Press any other key to continue.");
        String input = scanner.nextLine();
        if (input.equalsIgnoreCase("P")) {
            return true;
        } else if (input.equalsIgnoreCase("S")) {
            saveGame(currentNode);
            System.out.println("Press 'P' to quit. Press any other key to continue.");
            input = scanner.nextLine();
            if (input.equalsIgnoreCase("P")) {
            	System.out.println("Game quit automatically.");
            	System.exit(0);
            return true;
            }
        }
        return false;
    }
    
    /**
     * Loads a previously saved game state from a file, including the player's character and last node.
     * It then continues the game from the saved state.
     */
    public void loadGame() {
    	if (Game.scanner == null) {
            Game.scanner = new Scanner(System.in);
        }
    	// Load saved game state from file
    	GameSaveState gameState = GameSave.loadGame("savegame.ser");
        if (gameState != null) {
        	// Restore player information
            player = gameState.getPlayer();
            System.out.println("Welcome back, " + player.getName() + "!");
            System.out.println("You are a " + player.getRace() + " with " + player.getHp() + " health.");
            // If there are other player attributes that need to be restored, do them here as well
        } else {
        	System.out.println("No player information found in save file. Starting a new game.");
            start();
            return;
        }
        
        	// Restore the current node
        	Node ancientNode = gameState.getCurrentNode();
        	if (ancientNode != null) {
        		// Make sure the gameFrame is set correctly
        		if (gameFrame == null) {
        			gameFrame = new GameFrame();
        			gameFrame.launch();
        		}
        		// Creating enemies
                Enemy boss = new Boss("Boss", 100, 20);
                Enemy dragon = new Boss("Evil Dragon", 1000, 175);

                // Create game nodes
                Node startNode = new InnerNode("You're a brave man, and now you're in the village.");
                DecisionNode decisionNode = new DecisionNode("Are you going to explore outside? \n1. yes, I'm going. \n2. No, I'm not ready yet.");
                TerminalNode endNodeFailure = new TerminalNode("You decide to stay in the village and become an ordinary villager.");
                ChanceNode chanceNode = new ChanceNode("You were brave enough to walk out of the village. \nOh! There's a mysterious canyon ahead.");
                DecisionNode canyonDecisionNode = new DecisionNode("Are you going into the canyon? \n1. yes, I'm going in. \n2. no, I'm going back to the village.");
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
                ((InnerNode) startNode).addNextNode(decisionNode);
                decisionNode.addNextNode(chanceNode);
                decisionNode.addNextNode(endNodeFailure);
                chanceNode.addNextNode(canyonDecisionNode);
                chanceNode.addNextNode(dragonDecisionNode);
                canyonDecisionNode.addNextNode(bossBattleNode);
                canyonDecisionNode.addNextNode(endNodeReturn);
                bossBattleNode.addNextNode(endNodeBossFightWin);
                bossBattleNode.addNextNode(endNodeBossFightLose);
                dragonDecisionNode.addNextNode(dragonBattleNode);
                dragonDecisionNode.addNextNode(endNodeReturn);
                dragonBattleNode.addNextNode(victoryNode);  // Node after victory
                dragonBattleNode.addNextNode(defeatNode); // Node after failure
        		
        		
                // Ensure that all nodes have the correct gameFrame reference
        		ancientNode = decorateNode(dragonDecisionNode, gameFrame);
        		// Update the background image
        		if (ancientNode instanceof ImageNode) {
//        			System.out.println("ancientNode est bien un ImageNode");
        			gameFrame.updateBackground(((ImageNode) ancientNode).getImage());
        		}
        		// Continue the game
        		startGame(ancientNode, gameFrame);
        	} else {
        		System.out.println("No game position found in save file. Starting a new game.");
        		start();
        	}
    }
}
