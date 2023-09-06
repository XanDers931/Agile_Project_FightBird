package main;

public abstract class Item implements Comparable<Item>{
    String name;
    Type type;
    int damage;
    int critical_rate;
    int accuracy;
    int rarity;

    public Item(String nom, Type type, int damage, int critical_rate, int accuracy, int rarity) {
        this.name = nom;
        this.type = type;
        this.damage = damage;
        this.critical_rate = critical_rate;
        this.accuracy = accuracy;
        this.rarity = rarity;
    }

    public String toString(){
        return this.name;
    }

    public abstract int damageTotal(int attack_multiplier);

    public String getName() {
        return name;
    }

    public Type getType() {
        return type;
    }

    public int getDamage() {
        return damage;
    }

    public int getCritical_rate() {
        return critical_rate;
    }

    public int getAccuracy() {
        return accuracy;
    }

    public int getRarity() {
        return rarity;
    }

    public int compareTo(Item item){
        return this.type.compareTo(item.type);
    }
}
