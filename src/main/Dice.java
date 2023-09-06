package main;

public class Dice {
    public Dice(){}

    public static boolean fight(){
        int playerRoll, computerRoll;
        playerRoll = (int)(Math.random()*20)+1;
        System.out.println("You start rolling the dice");
        System.out.println("----------");
        System.out.println("You roll a "+playerRoll+" !");
        computerRoll = (int)(Math.random()*20)+1;
        System.out.println("Your ennemi start rolling the dice");
        System.out.println("----------");
        System.out.println("He roll a "+computerRoll+" !");

        return (playerRoll>computerRoll);
    }
}
