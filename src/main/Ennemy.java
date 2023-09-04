package main;

public class Ennemy {
    private String name;
    private int pv;
    final private int PVMAX;
    
    private int attack;
    
    
    public Ennemy(String name, int pVMAX, int attack) {
        this.name = name;
        this.pv = pVMAX;
        PVMAX = pVMAX;
        this.attack = attack;
    }

    public Ennemy(){
        this("Piaf-piaf",20,1);
    }

    public int getPVMAX() {
        return PVMAX;
    }
    public String getName() {
        return name;
    }
    
    public int getPv() {
        return pv;
    }
    
    public int getAttack() {
        return attack;
    }
        
    public void takeDamage(int damage){
        if(pv-damage<0){
            pv=0;
        }
        else {
            pv-=damage;
        }
    }

    @Override
    public String toString() {
        return "Ennemy [name=" + name + ", pv=" + pv + ", PVMAX=" + PVMAX + ", attack=" + attack + "]";
    }
    
}
