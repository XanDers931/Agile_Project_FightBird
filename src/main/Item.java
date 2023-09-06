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

    public abstract int damageTotal(int attack_multiplier, Ennemy ennemy);

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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((type == null) ? 0 : type.hashCode());
        result = prime * result + damage;
        result = prime * result + critical_rate;
        result = prime * result + accuracy;
        result = prime * result + rarity;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Item other = (Item) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (type != other.type)
            return false;
        if (damage != other.damage)
            return false;
        if (critical_rate != other.critical_rate)
            return false;
        if (accuracy != other.accuracy)
            return false;
        if (rarity != other.rarity)
            return false;
        return true;
    }

    
}
