package main;

public class Fight {
    private Player player;
    private Ennemy ennemy;
    private boolean isFinished;

    public boolean isFinished() {
        return isFinished;
    }

    public Fight(Player player, Ennemy ennemy) {
        this.player = player;
        this.ennemy = ennemy;
        this.isFinished = false;
    }

    public boolean canAttack(Item usedItem){
        if(usedItem.getType() == Type.MAGIC){
            Magic magicItem = (Magic) usedItem;
            return player.getMana_point()> magicItem.getUse_mana();
        }
        if(usedItem.getType()== Type.RANGE){
            Range rangeItem = (Range) usedItem;
            return player.getAmmo() > rangeItem.getUse_ammo();
        }
        return true;
    }

    public void playerAttack(Item usedItem){
        if(this.canAttack(usedItem)){
            if(usedItem.getType() == Type.MAGIC){
            Magic magicItem = (Magic) usedItem;
            player.decreaseMana(magicItem.getUse_mana());
        }
        if(usedItem.getType()== Type.RANGE){
            Range rangeItem = (Range) usedItem;
            player.decreaseAmmo(rangeItem.getUse_ammo());
        }
            int damage = usedItem.damageTotal(player.getAttack_value());
            ennemy.takeDamage(damage);
            System.out.println(damage);
        }
    }

    public void ennemyAttack(){
        int damage = ennemy.getAttack();
        player.takeDamage(damage);
        System.out.println("you get hit "+ damage);
    }

    public void fight(Item usedItem){
        this.playerAttack(usedItem);
        if(ennemy.getPv()>0){
            this.ennemyAttack();
        }
        if(ennemy.getPv()<=0 || player.getHealth_point()<=0){
            isFinished=true;
        }
    }
    
    
    
}
