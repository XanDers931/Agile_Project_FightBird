package main;

public class Boss extends Ennemy{

    private final int MINPVMAX = 100;
    private final int MINATTACK = 10;

    public Boss(String name, int pVMAX, int attack) {
        super(name, pVMAX, attack);
    }

    public Boss(int score){
        super(score * 5);
    }
    

}
