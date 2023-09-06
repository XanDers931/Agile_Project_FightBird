package main;

public class Boss extends Ennemy{
    public Boss(String name, int pVMAX, int attack) {
        super(name, pVMAX*10, attack*5);
    }

    public Boss(int score){
        super(score * 5);
    }
    

}
