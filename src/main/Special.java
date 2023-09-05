package main;

public class Special extends Item{
    private static final int SPECIAL_MULTIPLIER = 100;
    private static final int NO_DAMAGE = 0;
    private final TypeGame TYPE_GAME;
    public Special(String nom, Type type, int damage, int rarity, TypeGame game) {
        super(nom, type, damage, 0, 100, rarity);
        TYPE_GAME = game;
    }

    @Override
    public int damageTotal(int attack_multiplier) {
        if (this.TYPE_GAME == TypeGame.DICE){
            if(Dice.fight()) return attack_multiplier * SPECIAL_MULTIPLIER;
        }else if (this.TYPE_GAME == TypeGame.SHIFUMI){
            Shifumi shifumi = new Shifumi(this);
            if(shifumi.fight()){
                return attack_multiplier * SPECIAL_MULTIPLIER;
            }
        }
        return NO_DAMAGE;
    }
}
