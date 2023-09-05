package main;

public class Item {
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
}
