public abstract class BattleLocation extends Location {

    protected Enemy enemy;
    protected String award;

    BattleLocation(Player player, String name, Enemy enemy, String award) {
        super(player);
        this.name = name;
        this.enemy = enemy;
        this.award = award;
    }

    public boolean getLocation() {
        int enemyCount = enemy.count();
        System.out.println("\nYou are in " + this.getName() + " now.");
        System.out.println("Be careful! There are " + enemyCount + " " + enemy.getName() + " here.");
        System.out.println("<B>attle or <R>un");
        String selectCase = input.next();
        selectCase = selectCase.toUpperCase();
        if (selectCase.equals("B")) {
            if (combat(enemyCount)) {
                System.out.println("\nYou DEFEATED all the enemies in the " + this.getName() + "!");
                if (this.award.equals("Food") && !player.getInventory().isFood()) {
                    System.out.println("You get the " + this.award + "!");
                    player.getInventory().setFood(true);
                } else if (this.award.equals("Firewood") && !player.getInventory().isFirewood()) {
                    System.out.println("You get the " + this.award + "!");
                    player.getInventory().setFirewood(true);
                } else if (this.award.equals("Water") && !player.getInventory().isWater()) {
                    System.out.println("You get the " + this.award + "!");
                    player.getInventory().setWater(true);
                }
                return true;
            } else if (player.getHealth() <= 0){
                System.out.println("\nYou died...");
                return false;
            }
        } else if (selectCase.equals("R")) {
            return true;
        } else {
            System.out.println("\nPlease enter a valid letter");
            getLocation();
        }
        return true;
    }

    public boolean combat(int enemyCount) {
        int round = 1;
        for (int i = 0; i < enemyCount; i++) {
            int defaultEnemyHealth = enemy.getHealth();
            System.out.println("\nRound " + round + "\n-------------");
            playerStats();
            enemyStats();
            round++;

            while (player.getHealth() > 0 && enemy.getHealth() > 0) {
                System.out.println("<H>it or <R>un");
                String selectedCase = input.next();
                selectedCase = selectedCase.toUpperCase();
                if (selectedCase.equals("H")) {
                    System.out.println("You hit!");
                    enemy.setHealth(enemy.getHealth() - player.getTotalDamage());
                    afterHit();
                    if (enemy.getHealth() > 0) {
                        System.out.println("\nMonster hit you!");
                        player.setHealth(player.getHealth() - (enemy.getDamage() - player.getInventory().getArmor()));
                        afterHit();
                    }
                } else if (selectedCase.equals("R")) {
                    return false;
                } else {
                    System.out.println("Please enter a valid letter");
                }
            }

            if (enemy.getHealth() <= 0 && player.getHealth() > 0) {
                System.out.println("\nYou killed a " + enemy.getName() + "!");
                player.setMoney(player.getMoney() + enemy.getAward());
                System.out.println("Current money: " + player.getMoney());
                enemy.setHealth(defaultEnemyHealth);
            } else {
                return false;
            }
        }
        return true;
    }

    private void playerStats() {
        System.out.println("<Player stats>");
        System.out.println("Damage: " + player.getTotalDamage());
        System.out.println("Health: " + player.getHealth());
        System.out.println("Money: " + player.getMoney());
        if (player.getInventory().getDamage() > 0) {
            System.out.println("Weapon: " + player.getInventory().getWeaponName());
        }
        if (player.getInventory().getArmor() > 0) {
            System.out.println("Armor: " + player.getInventory().getArmorName());
        }
    }

    private void enemyStats() {
        System.out.println("\n<" + enemy.getName() + " stats>");
        System.out.println("Damage: " + enemy.getDamage());
        System.out.println("Health: " + enemy.getHealth());
        System.out.println("Award: " + enemy.getAward());
    }

    public void afterHit() {
        System.out.println("Player health: " + player.getHealth());
        System.out.println(enemy.getName() + " health is: " + enemy.getHealth());
    }

}
