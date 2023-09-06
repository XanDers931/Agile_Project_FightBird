package main;

import java.util.Random;

public class Melee extends Item{
    private static final int CRIT_MULTIPLIER = 2;
    private static final int MISSED_HIT_DAMAGE = 0;


    public Melee(String nom, Type type, int damage, int critical_rate, int accuracy, int rarity) {
        super(nom, type, damage, critical_rate, accuracy, rarity);
    }

    private boolean hitSucess(){
        Random rand = new Random();
        return rand.nextInt(100) < this.accuracy;
    }
    
    private boolean hitCritical(){
        Random rand = new Random();
        return rand.nextInt(100) < this.critical_rate;
    }

    public int damageTotal(int attack_multiplier, Ennemy ennemy){
        int damage_value = this.damage * attack_multiplier;
        if (!this.hitSucess()){
            
            return MISSED_HIT_DAMAGE;
        }else{
            if(this.hitCritical()){
                damage_value *= CRIT_MULTIPLIER;
            }
            return damage_value;
        }
    }

    
}
