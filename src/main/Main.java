package main;

import java.util.Scanner;

public class Main {

    private static void menu(){
        Visuals.printMenu();
    }

    private static void fight(Player player, Ennemy ennemy){
        Fight fight = new Fight(player, ennemy);
        Melee melee = new Melee("batte", Type.MELEE, 10, 15, 95, 2);
        Magic magic = new Magic("magie", Type.MAGIC, 5, 10, 95, 2, 12);
        Range range = new Range("bateau", Type.RANGE, 80, 15, 55, 2,3);
        Special dice = new Special("Dice", Type.SPECIAL, 20, 0, 0, 0, TypeGame.DICE);
        Scanner sc = new Scanner(System.in);
        String select = "";
        while(!fight.isFinished()){
            System.out.println(" \n Player status :");
            System.out.println(player);
            System.out.println(" \n Ennemy status:");
            System.out.println(ennemy);
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
                case "4":
                    fight.fight(dice);
                    break;
                default:
                    break;
            }
            System.out.flush();
        }
    }
    public static void main(String[] args) {
        Player user = new Player();
        Ennemy ennemy = new Ennemy();
        menu();
        System.out.println(" Votre Choix : ");
        Scanner sc = new Scanner(System.in);
        String select = "";
        select = sc.nextLine();
        switch (select) {
            case "1":
                fight(user, ennemy);
                System.out.flush();
                    break;
            case "2":
                System.out.println("WIP");
                break;
            case "3":
                rules();
                break;
            case "0":
                
                    break;
            default:
                break;
            }
        
    }

    public static void rules(){
        Visuals.printRules();
        System.out.println("Press Enter");
        Scanner sc = new Scanner(System.in);
        String select = "";
    }
}
