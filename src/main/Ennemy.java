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
}
