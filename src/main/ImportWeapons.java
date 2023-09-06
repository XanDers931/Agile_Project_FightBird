package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class ImportWeapons {
    private static final String PATH_MELEE = "res/melee_weapon.csv";
    private static final String PATH_RANGE = "res/range_weapon.csv";
    private static final String PATH_MAGIC = "res/magic_weapon.csv";
    private static final String PATH_SPECIAL = "res/special_weapon.csv";


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

    private static Special importSpecial(String line){
        try (Scanner sc = new Scanner(line).useDelimiter(";")) {
            String name = sc.next();
            Type type = Type.valueOf(sc.next());
            int damage = Integer.parseInt(sc.next());
            int critical = Integer.parseInt(sc.next());
            TypeGame game = TypeGame.valueOf(sc.next());


            return new Special(name,type, damage, critical, game);
        }
    }

    public static ArrayList<Item> listSpecial(){
        ArrayList<Item> list = new ArrayList<Item>();
        try (Scanner sc = new Scanner(new File(PATH_SPECIAL))) {
            sc.nextLine();
            while(sc.hasNextLine()){
                list.add(ImportWeapons.importSpecial(sc.nextLine()));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static Item drop(int rarity, Player player){
        ArrayList<Item> listItem = new ArrayList<Item>();
        listItem.addAll(listMagic());
        listItem.addAll(listMelees());
        listItem.addAll(listRange());

        Collections.shuffle(listItem);
        int size = listItem.size();
        Item item = listItem.get(0);
        int i = 1;

        while((i<size && item.getRarity() != rarity) || player.getInventory().getInventory().contains(item)){
            item = listItem.get(i);
            i++;
        }
        if(i != size){
            player.getInventory().addItem(item);
            return item;
        }
        return null;
    }

    public static Item dropSpecial(Player player){
        ArrayList<Item> listSpe = listSpecial();
        Collections.shuffle(listSpe);
        Item item = listSpe.get(0);
        player.getInventory().addItem(item);
        return item;
    }

    public static ArrayList<Item> baseItems(){
        ArrayList<Item> res = new ArrayList<Item>();
        res.add(listMagic().get(0));
        res.add(listMelees().get(0));
        res.add(listRange().get(0));
        return res;
    }
    

    public static void main(String[] args) {
        System.out.println(listMelees());
        System.out.println(listMagic());
        System.out.println(listRange());
        System.out.println(listSpecial());

        Player player = new Player();
        System.out.println(player);
        Item d = ImportWeapons.drop(1, player);
        System.out.println(d);
        System.out.println(player.getInventory().getInventory());
        Item dd = ImportWeapons.dropSpecial(player);
        System.out.println(dd);
        System.out.println(player.getInventory().getInventory());
        System.out.println(baseItems());
    }
}
