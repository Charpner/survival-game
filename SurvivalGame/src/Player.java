import java.util.InputMismatchException;
import java.util.Scanner;

public class Player {

    private int damage;
    private int health;
    private int realHealth;
    private int money;
    private String name;
    private String charName;
    private Inventory inventory;
    Scanner input = new Scanner(System.in);

    public Player(String name) {
        this.name = name;
        this.inventory = new Inventory();
    }

    public void selectChar() {
        switch (charMenu()) {
            case 2:
                initPlayer("Archer", 7, 18, 20);
                break;
            case 3:
                initPlayer("Knight", 8, 24, 5);
                break;
            case 1:
            default:
                initPlayer("Samurai", 5, 21, 15); //for prevent possible bugs
                break;
        }
        System.out.println("\nCharacter: " + getCharName() + "\tDamage: " + getDamage() + "\tHealth: " + getHealth() + "\tMoney: " + getMoney());
    }

    public int charMenu() {
        System.out.println("Select a character " + name + ": ");
        System.out.println("1-Samurai\t Damage: 5\t Health: 21\t Money: 15");
        System.out.println("2-Archer\t Damage: 7\t Health: 18\t Money: 20");
        System.out.println("3-Knight\t Damage: 8\t Health: 24\t Money: 5");
        System.out.print("Your choice: ");
        int charID = input.nextInt();

        while (charID < 1 || charID > 3) {
            System.out.print("Please choose a valid character: ");
            charID = input.nextInt();
        }

        return charID;
    }

    public int getTotalDamage() {
        return this.getDamage() + this.getInventory().getDamage();
    }

    public void initPlayer(String charName, int damage, int health, int money) {
        setCharName(charName);
        setDamage(damage);
        setHealth(health);
        setRealHealth(health);
        setMoney(money);
    }

    public int getDamage() {
        return damage;
    }
    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }
    public void setHealth(int health) {
        this.health = health;
    }

    public int getRealHealth() {
        return realHealth;
    }
    public void setRealHealth(int realHealth) {
        this.realHealth = realHealth;
    }

    public int getMoney() {
        return money;
    }
    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getCharName() {
        return charName;
    }
    public void setCharName(String charName) {
        this.charName = charName;
    }

    public Inventory getInventory() {
        return inventory;
    }
    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }


}
