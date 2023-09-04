package main;

import java.util.ArrayList;
import java.util.Scanner;

public class Inventory {
    ArrayList<Item> inventory;

    public Inventory(ArrayList<Item> inventory){
        this.inventory = inventory;
    }

    public void openInventory(){
        
        Scanner sc = new Scanner(System.in);
        String read = sc.nextLine();


        char c = read.charAt(1);

        if (c == 'z');

        System.out.println("┌────────────────────┬────────────────────┬────────────────────┬────────────────────┐");
        

        //Faire affichage + curseur
    }
}
