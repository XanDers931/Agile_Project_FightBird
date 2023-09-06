package main;

import java.util.Scanner;

public class Main {

    private static void menu(){
        Visuals.clear();
        Visuals.printMenu();
    }

    private static void fight(Player player, Ennemy ennemy){
        Fight fight = new Fight(player, ennemy);
        
        Scanner sc = new Scanner(System.in);
        String select = "";
        player.getInventory().openInventory();
        while(!fight.isFinished()){
            Visuals.clear();
            if(ennemy.getClass() == Boss.class){
                Visuals.printBoss();
            }
            else {
                Visuals.printFight();
            }
            System.out.println(" \n Player status :");
            System.out.println(player);
            System.out.println(" \n Ennemy status:");
            System.out.println(ennemy);
            System.out.println("Select weapon : 1 melee 2 range 3 magic 4 special");
            select = sc.nextLine();
            switch (select) {
                case "1":
                    fight.fight(player.getInventory().getChoice()[0]);
                    break;
                case "2":
                    fight.fight(player.getInventory().getChoice()[1]);
                    break;
                case "3":
                    fight.fight(player.getInventory().getChoice()[2]);
                    break;
                case "4":
                    fight.fight(player.getInventory().getChoice()[3]);
                    break;
                default:
                    break;
            }
            Visuals.wait(sc);
        }
    }
    public static void main(String[] args) {
        Player user = new Player();
        Ennemy ennemy = new Ennemy();
        Scanner sc = new Scanner(System.in);
        String select = "";
        int level = 0;
        boolean end = false;
        int rarity = 1;
        while (!end) {
            menu();
            System.out.println(" Votre Choix : ");
            select = sc.nextLine();
            switch (select) {
                case "1":
                    while(user.getHealth_point()>0){
                        if (level%5 == 0) {
                            ennemy = new Boss(level);
                        } else {
                            ennemy = new Ennemy(level);
                            
                        }
                        fight(user, ennemy);
                        System.out.flush();
                        if(ennemy.getPv()<=0){
                            Visuals.clear();
                            level+=1;
                            user.scaleUp();
                            user.heal();
                            System.out.println(ImportWeapons.drop(rarity, user)); 
                            Visuals.wait(sc);
                            if(level%10==0){
                                rarity++;
                                System.out.println(ImportWeapons.dropSpecial(user));
                            }
                        }
                    }
                    RecordManager.changeScore(level);
                    end =true;
                    break;
                case "2":
                    System.out.println("Le meilleur score c'est "+RecordManager.getBestScore());
                    Visuals.wait(sc);
                    break;
                case "3":
                    rules();
                    break;
                case "0":
                    end =true;
                    break;
                default:
                    break;
                }
            Visuals.clear();
            
        }
        
    }

    public static void rules(){
        Visuals.printRules();
        Scanner sc = new Scanner(System.in);
        Visuals.wait(sc);
    }
}
