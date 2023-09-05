package main;

import java.util.ArrayList;

public class Player {

    private static final int BASE_HEALTH = 100;
    private static final int BASE_ATTACK = 1;
    private static final int BASE_MANA = 100;
    private static final String BASE_USERNAME = "Flap-Flap";
    private static final int BASE_AMMO = 3;
    private static final Inventory BASE_INVENTORY = new Inventory(new ArrayList<Item>());

    private static final int INCREASE_MANA_HP = 5;
    private static final int INCREASE_ATTACK_AMMO = 1;

    private String username;
    private int health_point;
    private int attack_value;
    private int mana_point;
    private int ammo;
    private Inventory inventory;

    
    public Player(int health_point, int attack_value, int mana_point, String username, int ammo, Inventory inventory) {
        this.health_point = health_point;
        this.attack_value = attack_value;
        this.mana_point = mana_point;
        this.username = username;
        this.ammo = ammo;
        this.inventory = inventory;
    }

    public Player() {
        this(BASE_HEALTH, BASE_ATTACK, BASE_MANA, BASE_USERNAME, BASE_AMMO, BASE_INVENTORY);
    }

    @Override
    public String toString() {
        return this.username + " : \nHealth : " + this.health_point + "\nAttack : " + this.attack_value + "\nMana : " + this.mana_point;
    }

    public String getUsername() {
        return username;
    }

    public int getHealth_point() {
        return health_point;
    }

    public int getAttack_value() {
        return attack_value;
    }

    public int getMana_point() {
        return mana_point;
    }
    
    public int getAmmo() {
        return ammo;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void increaseHp(int multiplier){
        this.health_point += INCREASE_MANA_HP * multiplier;
    }

    public void increaseAttack(int multiplier){
        this.attack_value += INCREASE_ATTACK_AMMO * multiplier;
    }

    public void increaseMana(int multiplier){
        this.mana_point += INCREASE_MANA_HP * multiplier;
    }

    public void increaseAmmo(int multiplier){
        this.ammo += INCREASE_ATTACK_AMMO * multiplier;
    }

    public void attackEnnemy(Ennemy otherEnnemy){
        otherEnnemy.takeDamage(this.attack_value);
    }

    public void takeDamage(int damage){
        if(this.health_point-damage<0){
            this.health_point=0;
        }
        else {
            this.health_point-=damage;
        }
    }
}
