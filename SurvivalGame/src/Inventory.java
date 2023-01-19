public class Inventory {

    private boolean food;
    private boolean firewood;
    private boolean water;
    private int damage;
    private int armor;
    private String weaponName;
    private String armorName;

    Inventory() {
        this.food = false;
        this.firewood = false;
        this.water = false;
        this.damage = 0;
        this.armor = 0;
        this.weaponName = null;
        this.armorName = null;
    }

    public boolean isFood() {
        return food;
    }
    public void setFood(boolean food) {
        this.food = food;
    }

    public boolean isFirewood() {
        return firewood;
    }
    public void setFirewood(boolean firewood) {
        this.firewood = firewood;
    }

    public boolean isWater() {
        return water;
    }
    public void setWater(boolean water) {
        this.water = water;
    }

    public int getDamage() {
        return damage;
    }
    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getArmor() {
        return armor;
    }
    public void setArmor(int armor) {
        this.armor = armor;
    }

    public String getWeaponName() {
        return weaponName;
    }
    public void setWeaponName(String weaponName) {
        this.weaponName = weaponName;
    }

    public String getArmorName() {
        return armorName;
    }
    public void setArmorName(String armorName) {
        this.armorName = armorName;
    }

}
