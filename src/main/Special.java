package main;

public class Special extends Item{
    private static final int SPECIAL_MULTIPLIER = 100;
    private static final int NO_DAMAGE = 0;

    public Special(String nom, Type type, int damage, int critical_rate, int accuracy, int rarity) {
        super(nom, type, damage, 0, 100, rarity);
    }

    @Override
    public int damageTotal(int attack_multiplier) {
        if (this.getName().equals("Dice")){
            if(Dice.fight()) return attack_multiplier * SPECIAL_MULTIPLIER;
        }else if (this.getName().equals("Rock") || this.getName().equals("Paper") || this.getName().equals("Scissors")){
            Shifumi shifumi = new Shifumi(this);
            if(shifumi.fight()){
                return attack_multiplier * SPECIAL_MULTIPLIER;
            }
        }
        return NO_DAMAGE;
    }
}
