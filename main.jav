import java.util.Scanner;

public class RPGGame {
    
    private static int playerHealth = 100;
    private static int enemyHealth = 50;
    private static boolean playerTurn = true;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Welcome to the RPG game!");
        System.out.println("You are facing an enemy with " + enemyHealth + " health.");
        while (playerHealth > 0 && enemyHealth > 0) {
            if (playerTurn) {
                System.out.println("It's your turn.");
                System.out.println("1. Attack");
                System.out.println("2. Heal");
                int choice = sc.nextInt();
                if (choice == 1) {
                    int damage = (int) (Math.random() * 20);
                    System.out.println("You attack the enemy and deal " + damage + " damage!");
                    enemyHealth -= damage;
                } else if (choice == 2) {
                    int healAmount = (int) (Math.random() * 20);
                    System.out.println("You heal yourself for " + healAmount + " health.");
                    playerHealth += healAmount;
                } else {
                    System.out.println("Invalid choice. Please try again.");
                }
                playerTurn = false;
            } else {
                System.out.println("It's the enemy's turn.");
                int damage = (int) (Math.random() * 10);
                System.out.println("The enemy attacks you and deals " + damage + " damage!");
                playerHealth -= damage;
                playerTurn = true;
            }
            System.out.println("Your health: " + playerHealth);
            System.out.println("Enemy health: " + enemyHealth);
            System.out.println();
        }
        
        if (playerHealth > 0) {
            System.out.println("Congratulations! You have defeated the enemy!");
        } else {
            System.out.println("You have been defeated. Better luck next time!");
        }
        
        sc.close();
    }

}
