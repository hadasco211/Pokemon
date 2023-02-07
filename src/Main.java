import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

            Pokemon currentPlayer;
            Pokemon enemy;
            Random random = new Random();
            int bonusLifePoints = random.nextInt(0, 4);
            int bonusAttackPoints = random.nextInt(0, 4);
            Pokemon player1 = null;
            System.out.println("player 1:");
            player1 = player1.randomPokemon();
            player1.setTurn(true);

            Pokemon player2 = null;
            System.out.println("player 2:");
            player2 = player2.randomPokemon();

            Pokemon winner = null;

            do {
                if (player1.isTurn()) {
                    currentPlayer = player1;
                    enemy = player2;
                    System.out.println("is turn of: player1");
                } else {
                    currentPlayer = player2;
                    enemy = player1;
                    System.out.println("is turn of: player2");

                }
                player1.setTurn(!player1.isTurn());
                player2.setTurn(!player2.isTurn());
                System.out.println();
                System.out.println(currentPlayer.toString());
                Scanner scanner = new Scanner(System.in);
                System.out.print("what do you chose?" + "\n" +
                        "1. making an attack" + "\n" +
                        "2. waiting" + "\n" +
                        "3. development" + "\n" +
                        "4. special action");
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        System.out.println("chose one of the attacks");
                        for (int i = 0; i < currentPlayer.getAttacks().length; i++) {
                            System.out.println(currentPlayer.getAttacks()[i].toString() + "");
                        }
                        String chosenAttack = scanner.next();

                        currentPlayer.attackCost(currentPlayer.getAttackCost());
                        enemy.setCurrentLifePoints(enemy.getCurrentLifePoints() - currentPlayer.getDamage());
                        System.out.println("the enemy current life points:" + enemy.getCurrentLifePoints());
                        if (enemy.getCurrentLifePoints() <= 0) {
                            winner = currentPlayer;
                            System.out.println("the winner is:" + currentPlayer);
                        }
                        break;
                    case 2:
                        currentPlayer.waitingTurn();
                        break;
                    case 3:
                        currentPlayer.upgrade();
                        break;
                    case 4:
                        if (currentPlayer.getKind().equals("electric")) {
                            currentPlayer.special();
                        } else
                            currentPlayer.special();
                        break;
                }
                if (currentPlayer.getKind().equals("electric")) {
                    currentPlayer.charge();
                }
                currentPlayer.setCurrentLifePoints(bonusLifePoints);
                currentPlayer.setCurrentAttackPoints(bonusAttackPoints);
            } while (winner == null);
        }

        //o(n)
        public static boolean checkAttack (String choice, Attack[]attacks){
            boolean isAvailable = false;
            for (int i = 0; i < attacks.length; i++) {
                if (attacks[i].equals(choice)) {
                    isAvailable = true;
                }
            }
            return isAvailable;
        }

        public static boolean availableToAttack ( int attackCost, int currentAttackPoints){
            boolean available = false;
            if (attackCost <= currentAttackPoints) {
                available = true;
            }
            return available;
        }


    }

