package main;

import java.util.ArrayList;
import java.util.Scanner;

public class Inventory {
    ArrayList<Item> inventory;

    public Inventory(ArrayList<Item> inventory){
        this.inventory = inventory;
    }

    public void openInventory(Player player){

        boolean curseur[] = {true,false,false,false};
        Scanner sc = new Scanner(System.in);
        
        int tmp = 0;
        int inventorySize = player.getInventory.size();
        boolean finish = false;

        while (!finish){
            afficherChoix(player);
            
            System.out.println("q et d pour défiler les armes, e pour valider, a pour annuler (Seul le premier charactère est pris en compte)");
            String read = sc.nextLine();
            char c = read.charAt(1);
            if (c == 'q'){

            }
            if (c == 'd'){

            }
            if (c == 'e'){

            }
            if (c == 'a'){

            }



        }


    }

    public void afficherChoix(Player player, boolean[] Curseur){

        System.out.println("┌────────────────────┬────────────────────┬────────────────────┬────────────────────┐");
    }
}
