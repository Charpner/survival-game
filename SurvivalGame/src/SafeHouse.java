public class SafeHouse extends NormalLocation {

    SafeHouse(Player player) {
        super(player, "Safe House");
    }

    public boolean getLocation() {
        player.setHealth(player.getRealHealth());
        System.out.println("\nYou are in the safe house now");
        System.out.println("You are healed...");
        return true;
    }

}
