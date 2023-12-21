package representation;

import univers.PlayerCharacter;
import univers.Enemy;
import java.util.Scanner;

/**
 * Represents a battle scenario node where the player character engages in combat with an enemy.
 */
public class BattleNode extends InnerNode {
    protected Enemy enemy;
    protected PlayerCharacter player;

    protected int playerInitialHp;
    protected int playerInitialMp;
    protected int playerInitialAttack;
    private Scanner scanner;
    protected boolean player_result = true;

    /**
     * Constructs a BattleNode with a given description, enemy, and player.
     *
     * @param description The narrative description of the battle.
     * @param enemy       The enemy character the player will fight.
     * @param player      The player character engaged in the battle.
     */
    public BattleNode(String description, Enemy enemy, PlayerCharacter player) {
        super(description);
        this.enemy = enemy;
        this.player = player;
        this.playerInitialHp = player.getHp();  // Store initial HP
        this.playerInitialMp = player.getMp();  // Store initial MP
        this.playerInitialAttack = player.getAttack();  // Store initial Attack
        this.scanner = new Scanner(System.in);  // For user input
    }

    @Override
    public void display() {
        System.out.println(description);
    }

    /**
     * Engages the player in a turn-based battle with the enemy.
     * Players can choose to attack or use skills if available.
     * The battle continues until either the player or enemy's health drops to zero or below.
     *
     * @return The next node in the story, based on the outcome of the battle (victory or defeat).
     */
    @Override
    public Node chooseNext() {
        display();
        System.out.println("The battle begins!");

        // Battle loop
        while (enemy.getHp() > 0) {
            // Player's turn
            System.out.println("Your turn.");
            System.out.println("Choose your action: 1. Attack 2. Skill");
            int choice = scanner.nextInt();

            if (choice == 1) {
                // Perform attack
                enemy.setHp(enemy.getHp() - player.getAttack());
                System.out.println("You attacked an enemy, his remaining HP:" + enemy.getHp());
            } else if (choice == 2) {
                // Perform skill
                if (player.getProfession() != null) {
                    // Display and execute skills
                    player.getProfession().displaySkills();
                    System.out.println("Select a skill :");
                    int skillChoice = scanner.nextInt();
                    player.getProfession().useSkill(skillChoice, player, enemy);
                } else {
                    // Default attack if no profession
                    System.out.println("You don't have a profession yet. Default is Attack.");
                    enemy.setHp(enemy.getHp() - player.getAttack());
                    System.out.println("You attacked an enemy, his remaining HP:" + enemy.getHp());
                }
            }

            // Check if enemy is defeated
            if (enemy.getHp() <= 0) {
                break;
            }

            // Enemy's turn
            System.out.println("Enemy's turn");
            // Assume enemy performs some kind of attack
            player.setHp(player.getHp() - enemy.getAttack());
            System.out.println("Enemy has attacked you, your remaining blood:" + player.getHp());

            // Check if player is defeated (optional)
            if (player.getHp() <= 0) {
                System.out.println("You are defeated!");
                player_result = false;
                break;
            }
        }

        System.out.println("The battle is over!");
        // Restore player's initial HP, MP and Attack
        player.setHp(playerInitialHp);
        player.setMp(playerInitialMp);
        player.setAttack(playerInitialAttack);
        // Determine next node based on battle outcome
        return (player_result = true) ? nextNodes[0] : nextNodes[1];  // Assume index 0 is victory node, 1 is defeat node.
    }
}
