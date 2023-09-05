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
            // return player.getMana_point()> (Magic) usedItem.get
            return true;
        }
        return true;
    }

    public void playerAttack(Item usedItem){
        if(this.canAttack(usedItem)){
            ennemy.takeDamage(usedItem.damageTotal(player.getAttack_value()));
            System.out.println("you hit "+ usedItem.damageTotal(player.getAttack_value()));
        }
    }

    public void ennemyAttack(){
        player.takeDamage(ennemy.getAttack());
        System.out.println("you get hit "+ ennemy.getAttack());
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
