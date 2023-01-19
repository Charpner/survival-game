public class Store extends NormalLocation {

    Store(Player player) {
        super(player, "Store");
    }

    public boolean getLocation() {
        System.out.println("1- Weapons");
        System.out.println("2- Armors");
        System.out.println("3- Exit");
        System.out.print("Your choice: ");
        int selectedItem = input.nextInt();
        int selectedItemID;
        switch (selectedItem) {
            case 1:
                selectedItemID = weaponMenu();
                buyWeapon(selectedItemID);
                //buyWeapon(weaponMenu());
                break;
            case 2:
                selectedItemID = armorMenu();
                buyArmor(selectedItemID);
                break;
            default:
                break;
        }
        return true;
    }

    public int weaponMenu() {
        System.out.println("\nMoney: " + player.getMoney());
        System.out.println("\n1- Pistol\t <Damage: +2\t Money: 25>");
        System.out.println("2- Sword\t <Damage: +4\t Money: 35>");
        System.out.println("3- Rifle\t <Damage: +7\t Damage: 45>");
        System.out.println("4- Exit");
        System.out.print("Buy a weapon or exit: ");
        int selectedWeaponID = input.nextInt();
        return selectedWeaponID;
    }

    public void buyWeapon(int itemID) {
        int damage = 0;
        int price = 0;
        String weaponName = null;

        switch (itemID) {
            case 1:
                damage = 2;
                weaponName = "Pistol";
                price = 25;
                break;
            case 2:
                damage = 4;
                weaponName = "Sword";
                price = 35;
                break;
            case 3:
                damage = 7;
                weaponName = "Rifle";
                price = 45;
                break;
            case 4:
                break;
            default:
                System.out.println("\nInvalid transaction!");
                buyWeapon(weaponMenu());
                break;
        }
        if (price > 0) {
            if (player.getMoney() >= price) {
                player.getInventory().setDamage(damage);
                player.getInventory().setWeaponName(weaponName);
                player.setMoney(player.getMoney() - price);
                System.out.println("\nYou buy the " + weaponName + ", new damage is: " + (player.getTotalDamage()));
                System.out.println("Remaining money: " + player.getMoney());
            } else {
                System.out.println("\nYou need more credit!");
            }
        }
    }

    public int armorMenu() {
        System.out.println("\nMoney: " + player.getMoney());
        System.out.println("\n1- Light\t <Damage Blocking: -1\t Money: 15>");
        System.out.println("2- Medium\t <Damage Blocking: -3\t Money: 25>");
        System.out.println("3- Heavy\t <Damage Blocking: -6\t Damage: 40>");
        System.out.println("4- Exit");
        System.out.print("Buy a armor or exit: ");
        int selectedArmorID = input.nextInt();
        return selectedArmorID;
    }

    public void buyArmor(int itemID) {
        int block = 0;
        int price = 0;
        String armorName = null;

        switch (itemID) {
            case 1:
                block = 1;
                armorName = "Light Armor";
                price = 15;
                break;
            case 2:
                block = 4;
                armorName = "Medium Armor";
                price = 25;
                break;
            case 3:
                block = 7;
                armorName = "Heavy Armor";
                price = 40;
                break;
            case 4:
                break;
            default:
                System.out.println("\nInvalid transaction!");
                buyArmor(armorMenu());
                break;
        }
        if (price > 0) {
            if (player.getMoney() >= price) {
                player.getInventory().setArmor(block);
                player.getInventory().setArmorName(armorName);
                player.setMoney(player.getMoney() - price);
                System.out.println("\nYou buy the " + armorName + ", damage blocking is: " + (player.getInventory().getArmor()));
                System.out.println("Remaining money: " + player.getMoney());
            } else {
                System.out.println("\nYou need more credit!");
            }
        }
    }


}
