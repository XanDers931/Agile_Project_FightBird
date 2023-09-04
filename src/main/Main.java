package main;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Player user = new Player();
        Ennemy ennemy = new Ennemy();
        System.out.println(" \nVotre statut :");
            System.out.println(user);
        while(user.getHealth_point()>0 && ennemy.getPv()>0){
            user.takeDamage(ennemy.getAttack());
            ennemy.takeDamage(user.getAttack_value());
            System.out.println("\nVous avez mis "+user.getAttack_value()+" dégats");
            System.out.println("\nVous avez subis " +ennemy.getAttack()+" dégats");
            System.out.println(" \nVotre statut :");
            System.out.println(user);
            System.out.println(" \nstatut Ennemy:");
            System.out.println(ennemy);
            System.out.println("Votre attaque a augmenté de 1");
            user.increaseAttack(1);
            Scanner sc = new Scanner(System.in);
            System.out.println("pressez entrée");
            sc.nextLine();

            System.out.flush();
        }
    }
}
