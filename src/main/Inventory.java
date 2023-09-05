package main;

import java.util.ArrayList;
import java.util.Scanner;

public class Inventory {
    ArrayList<Item> inventory;
    ArrayList<Item> cloneInventory;

    private Item choice[] = new Item[]{null,null,null,null};

    private final int BOXSIZE = 20;

    public Inventory(ArrayList<Item> inventory){
        this.inventory = inventory;
    }

    public void openInventory(Player player){

        boolean curseur[] = {true,false,false,false};
        Scanner sc = new Scanner(System.in);
        String read;
        char c;
        
        int itemSelection = 0;
        int progress = 0;

        int inventorySize = player.getInventory().inventory.size();
        boolean finish = false;

        cloneInventory = (ArrayList<Item>) inventory.clone();

        while (!finish){
            afficherChoix(player, curseur, itemSelection);
            
            System.out.println("q and d to scroll weapon,e to confirm, a to cancel (Only first charactere is take in count)");
            read = sc.nextLine();
            c = read.charAt(0);

            if (c == 'q'){
                if (itemSelection != 0){
                  itemSelection = itemSelection - 1;  
                }   
            }
            if (c == 'd'){
                if (itemSelection <= inventorySize-2){
                  itemSelection = itemSelection + 1;  
                }   
            }
            if (c == 'e'){
                choice[progress] = inventory.get(itemSelection);
                moveCursorDown(curseur);
                progress = progress + 1;
                inventory.remove(itemSelection);
                itemSelection = 0;
            }
            if (c == 'a'){
                choice[progress] = null;
                moveCursorUp(curseur);
                progress = progress - 1;
                
            }
            if (progress == 4){
                finish = true;
                inventory = (ArrayList<Item>) cloneInventory.clone();
            }            
        }
        
        System.out.println("End of selection phase. Battle starting soon. (Press Enter)");
        sc.nextLine();



    }

    void moveCursorDown(boolean[] curseur){

        if (!curseur[3]){
            //find true
        int i=-1;
        boolean trouve = false;
        while (!trouve){
            i = i + 1 ;
            if (curseur[i]){
                trouve = true;
            }
        }

        // décaller
        curseur[i] = false;
        curseur[i+1] = true;
        }        
    }

    void moveCursorUp(boolean[] curseur){

        if (!curseur[0]){
            //find true
        int i=-1;
        boolean trouve = false;
        while (!trouve){
            i = i + 1 ;
            if (curseur[i]){
                trouve = true;
            }
        }

        // décaller
        curseur[i] = false;
        curseur[i-1] = true;
        }        
    }

    public void addItem(Player player, Item item){
        player.getInventory().inventory.add(item);
    }

    public void emptySpace(Player player,int tmp){
        int y = BOXSIZE - player.getInventory().inventory.get(tmp).toString().length();
        for (int i = 0; i < y; i++){
            System.out.print(" ");
        }
    }

    public void afficherChoix(Player player, boolean[] curseur,int tmp){

        //l1
        System.out.println("┌───┬────────────────────┐");

        //l2
        System.out.print("│");
        if (curseur[0]){System.out.print(" ⬤ ");}
        else {System.out.print("   ");}
        System.out.print("│");
        if (curseur[0] == true){
            System.out.print(player.getInventory().inventory.get(tmp).toString());
            emptySpace(player,tmp);
        } else if (choice[0] == null){
            System.out.print(" ------------------ ");
        } else {
            System.out.print(choice[0].toString());
            emptySpace(player,0);
        }
        System.out.println("│");

        //l3
        System.out.println("├───┼────────────────────┤");

        //l4
        System.out.print("│");
        if (curseur[1]){System.out.print(" ⬤ ");}
        else {System.out.print("   ");}
        System.out.print("│");
        if (curseur[1] == true){
            System.out.print(player.getInventory().inventory.get(tmp).toString());
            emptySpace(player,tmp);
        } else if (choice[1] == null){
            System.out.print(" ------------------ ");
        } else {
            System.out.print(choice[1].toString());
            emptySpace(player,1);
        }
        System.out.println("│");

        //l5
        System.out.println("├───┼────────────────────┤");

        //l6
        System.out.print("│");
        if (curseur[2]){System.out.print(" ⬤ ");}
        else {System.out.print("   ");}
        System.out.print("│");
        if (curseur[2] == true){
            System.out.print(player.getInventory().inventory.get(tmp).toString());
            emptySpace(player,tmp);
        } else if (choice[2] == null){
            System.out.print(" ------------------ ");
        } else {
            System.out.print(choice[2].toString());
            emptySpace(player,2);
        }
        System.out.println("│");

        //l7
        System.out.println("├───┼────────────────────┤");

        //l8
        System.out.print("│");
        if (curseur[3]){System.out.print(" ⬤ ");}
        else {System.out.print("   ");}
        System.out.print("│");
        if (curseur[3] == true){
            System.out.print(player.getInventory().inventory.get(tmp).toString());
            emptySpace(player,tmp);
        } else if (choice[3] == null){
            System.out.print(" ------------------ ");
        } else {
            System.out.print(choice[3].toString());
            emptySpace(player,3);
        }
        System.out.println("│");


        //l9
        System.out.println("└───┴────────────────────┘");

        

    }

    public static void main(String[] args) {
        Player player = new Player();
        player.getInventory().addItem(player,new Melee("sword of death", Type.MELEE, 100, 100, 100, 1));
        player.getInventory().addItem(player,new Melee("sword of life", Type.MELEE, 100, 100, 100, 1));
        player.getInventory().addItem(player,new Range("bow", Type.RANGE, 0, 0, 0, 0, 0));
        player.getInventory().addItem(player,new Range("bow of life", Type.RANGE, 100, 100, 100, 1, 0));
        player.getInventory().addItem(player,new Magic("staff of staff", Type.MAGIC, 100, 100, 100, 1, 0));
        player.getInventory().openInventory(player);
    }
}
