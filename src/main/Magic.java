package main;

import java.util.Random;

public class Magic extends Item{
    private static final int CRIT_MULTIPLIER = 2;
    private static final int MISSED_HIT_DAMAGE = 0;
    private int use_mana;
    
    public int getUse_mana() {
        return use_mana;
    }

    public Magic(String nom, Type type, int damage, int critical_rate, int accuracy, int rarity, int use_mana) {
        super(nom, type, damage, critical_rate, accuracy, rarity);
        this.use_mana = use_mana;
    }

    private boolean hitSuccess(){
        Random rand = new Random();
        return rand.nextInt(100) < this.accuracy;
    }
    
    private boolean hitCritical(){
        Random rand = new Random();
        return rand.nextInt(100) < this.critical_rate;
    }

    public int damageTotal(int attack_multiplier, Ennemy ennemy){
        int damage_value = this.damage * attack_multiplier;
        if (!this.hitSuccess()){
            return MISSED_HIT_DAMAGE;
        }else{
            if(this.hitCritical()){
                System.out.println("You make a crit");
                damage_value *= CRIT_MULTIPLIER;
            }
            return damage_value;
        }
    }
}
