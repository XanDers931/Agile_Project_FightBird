package main;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Player user = new Player();
        Ennemy ennemy = new Ennemy();
        System.out.println(" \nVotre statut :");
            System.out.println(user);
            Scanner sc = new Scanner(System.in);
        Fight fight = new Fight(user, ennemy);
        Melee melee = new Melee("batte", Type.MELEE, 10, 15, 95, 2);
        Magic magic = new Magic("magie", Type.MAGIC, 5, 10, 95, 2, 12);
        Range range = new Range("bateau", Type.RANGE, 80, 15, 55, 2,3);
        String select = "";
        while(!fight.isFinished()){
            System.out.println("Select weapon : 1 melee 2 magic 3 range");
            select = sc.nextLine();
            switch (select) {
                case "1":
                    fight.fight(melee);
                    break;
                case "2":
                    fight.fight(magic);
                    break;
                case "3":
                    fight.fight(range);
                    break;
            
                default:
                    break;
            }
            System.out.flush();
        }
    }
}
