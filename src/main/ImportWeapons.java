package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ImportWeapons {
    private static final String PATH_MELEE = "res/melee_weapon.csv";
    private static final String PATH_RANGE = "res/range_weapon.csv";
    private static final String PATH_MAGIC = "res/magic_weapon.csv";


    private static Melee importMelee(String line){
        try (Scanner sc = new Scanner(line).useDelimiter(";")) {
            String name = sc.next();
            Type type = Type.valueOf(sc.next());
            int damage = Integer.parseInt(sc.next());
            int critical = Integer.parseInt(sc.next());
            int accuracy = Integer.parseInt(sc.next());
            int rarity = Integer.parseInt(sc.next());


            return new Melee(name,type, damage, critical, accuracy, rarity);
        }
    }

    public static ArrayList<Item> listMelees(){
        ArrayList<Item> list = new ArrayList<Item>();
        try (Scanner sc = new Scanner(new File(PATH_MELEE))) {
            sc.nextLine();
            while(sc.hasNextLine()){
                list.add(ImportWeapons.importMelee(sc.nextLine()));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return list;
    }

    private static Range importRange(String line){
        try (Scanner sc = new Scanner(line).useDelimiter(";")) {
            String name = sc.next();
            Type type = Type.valueOf(sc.next());
            int damage = Integer.parseInt(sc.next());
            int critical = Integer.parseInt(sc.next());
            int accuracy = Integer.parseInt(sc.next());
            int rarity = Integer.parseInt(sc.next());
            int useAmmo = Integer.parseInt(sc.next());


            return new Range(name,type, damage, critical, accuracy, rarity, useAmmo);
        }
    }

    public static ArrayList<Item> listRange(){
        ArrayList<Item> list = new ArrayList<Item>();
        try (Scanner sc = new Scanner(new File(PATH_RANGE))) {
            sc.nextLine();
            while(sc.hasNextLine()){
                list.add(ImportWeapons.importRange(sc.nextLine()));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return list;
    }
        private static Magic importMagic(String line){
        try (Scanner sc = new Scanner(line).useDelimiter(";")) {
            String name = sc.next();
            Type type = Type.valueOf(sc.next());
            int damage = Integer.parseInt(sc.next());
            int critical = Integer.parseInt(sc.next());
            int accuracy = Integer.parseInt(sc.next());
            int rarity = Integer.parseInt(sc.next());
            int mana = Integer.parseInt(sc.next());


            return new Magic(name,type, damage, critical, accuracy, rarity, mana);
        }
    }

    public static ArrayList<Item> listMagic(){
        ArrayList<Item> list = new ArrayList<Item>();
        try (Scanner sc = new Scanner(new File(PATH_MAGIC))) {
            sc.nextLine();
            while(sc.hasNextLine()){
                list.add(ImportWeapons.importMagic(sc.nextLine()));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return list;
    }
}
