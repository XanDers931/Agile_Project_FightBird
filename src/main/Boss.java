package main;

public class Boss extends Ennemy{
    public Boss(String name, int pVMAX, int attack) {
        super(name, pVMAX*10, attack*3);
    }

    public Boss(int score){
        super(score * 3);
    }
    

}
