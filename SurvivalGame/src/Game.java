import java.util.InputMismatchException;
import java.util.Scanner;

public class Game {

    Player player;
    Location location;
    Scanner input = new Scanner(System.in);

    public void login() {
        System.out.println("Welcome to Survival Game!");
        System.out.print("Enter your nick before start the game: ");
        Scanner input = new Scanner(System.in);
        String playerName = input.nextLine();
        player = new Player(playerName);
        player.selectChar();
    }

    public void start() {
        while (true) {
            System.out.println("\n=================================================\n");
            System.out.println("Choose a location you want to go: ");
            System.out.println("1- Safe House --> A safe place for you, no enemy!");
            System.out.println("2- Cave --> You may encounter zombies!");
            System.out.println("3- Forest --> You may encounter vampires!");
            System.out.println("4- River --> You may encounter alligators!");
            System.out.println("5- Store --> You can buy weapons or armor!");
            System.out.print("Your choice: ");
            int selectLocation = input.nextInt();

            while (selectLocation < 0 || selectLocation > 5) {
                System.out.println("Please choose a valid location: ");
                selectLocation = input.nextInt();
            }

            switch (selectLocation) {
                case 2:
                    location = new Cave(player);
                    break;
                case 3:
                    location = new Forest(player);
                    break;
                case 4:
                    location = new River(player);
                    break;
                case 5:
                    location = new Store(player);
                    break;
                case 1:
                default:
                    location = new SafeHouse(player);
                    break;
            }

            if (location.getClass().getName().equals("SafeHouse")) {
                if (player.getInventory().isFood() && player.getInventory().isFirewood() && player.getInventory().isWater()) {
                    System.out.println("Congratulations! You have completed the game!");
                    break;
                }
            }

            if (!location.getLocation()) {
                System.out.println("Game over!");
                break;
            }

        }
    }
}
