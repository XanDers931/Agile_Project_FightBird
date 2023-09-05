package main;

public class Dice {
    public Dice(){}

    public boolean fight(){
        int playerRoll, computerRoll;
        playerRoll = (int)(Math.random()*6);
        computerRoll = (int)(Math.random()*6);

        return (playerRoll>computerRoll);
    }
}
