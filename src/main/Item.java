package main;

public class Item {
    String name;
    Type type;
    int damage;
    int critical_rate;
    int accuracy;

    public Item(String nom, Type type, int damage, int critical_rate, int accuracy) {
        this.name = nom;
        this.type = type;
        this.damage = damage;
        this.critical_rate = critical_rate;
        this.accuracy = accuracy;
    }

    public String toString(){
        return this.name;
    }
}
