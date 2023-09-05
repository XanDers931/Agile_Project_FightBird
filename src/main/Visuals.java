package main;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Visuals {
    private static final String HUD_PATH = "res/combat_hud.txt";
    private static final String RULES_PATH = "res/Rules.txt";
    private static final String MENU_PATH = "res/fight_bird.txt";
    
    private static String printTextFile(String filePath){
        String res = "";
        try (Scanner sc = new Scanner(new File(filePath))) {
            while(sc.hasNextLine()){
                res += sc.nextLine()+ "\n";
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return res;
    }

    public static void printMenu(){
        System.out.println(printTextFile(MENU_PATH));
    }

    public static void printRules(){
        System.out.println(printTextFile(RULES_PATH));
    }

    public static void printFight(){
        System.out.println(printTextFile(HUD_PATH));
    }
}
