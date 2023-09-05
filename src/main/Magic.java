package main;

import java.util.Random;

public class Magic extends Item{
    private int crit_multipler;
    private int missed_hit_damage;
    private int use_mana;
    
    public Magic(String nom, Type type, int damage, int critical_rate, int accuracy, int rarity, int crit_multipler,
            int missed_hit_damage, int use_mana) {
        super(nom, type, damage, critical_rate, accuracy, rarity);
        this.crit_multipler = crit_multipler;
        this.missed_hit_damage = missed_hit_damage;
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

    public int damageTotal(int attack_multiplier){
        int damage_value = this.damage * attack_multiplier;
        if (!this.hitSuccess()){
            return missed_hit_damage;
        }else{
            if(this.hitCritical()){
                damage_value *= crit_multipler;
            }
            return damage_value;
        }
    }
}
