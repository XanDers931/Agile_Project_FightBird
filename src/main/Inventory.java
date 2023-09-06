package main;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Inventory{
    private ArrayList<Item> inventory;
    private ArrayList<Item> cloneInventory;


    private Item choice[] = new Item[]{null,null,null,null};

    private final int BOXSIZE = 20;

    public Inventory(ArrayList<Item> inventory){
        this.inventory = inventory;
    }

    public Inventory() {
        this.inventory = new ArrayList<Item>();
    }

    public ArrayList<Item> getInventory() {
        return inventory;
    }

    public Item[] getChoice() {
        return choice;
    }

    public void openInventory(){

        boolean curseur[] = {true,false,false,false};
        Scanner sc = new Scanner(System.in);
        String read;
        char c;
        
        int itemSelection = 0;
        int progress = 0;

        int inventorySize = inventory.size();
        boolean finish = false;

        Collections.sort(inventory);
        
        cloneInventory = (ArrayList<Item>) inventory.clone();
        ArrayList<Item> typeInventory = new ArrayList<Item>();
        int scroll = 0;

        while (!finish){
            Visuals.clear();
            typeInventory.clear();
            typeInventory.addAll(inventory);
            inventorySize = inventory.size();
   
                if (progress == 0){
                    while (scroll < inventorySize){
                        if (inventory.get(scroll).getType() != Type.MELEE){
                            typeInventory.remove(inventory.get(scroll));
                        }
                        scroll = scroll + 1;
                    }
                }
                    
                if (progress == 1){
                    while (scroll < inventorySize){
                        if (inventory.get(scroll).getType() != Type.RANGE){
                            typeInventory.remove(inventory.get(scroll));
                        }
                        scroll = scroll + 1;
                    }
                }

            
                if (progress == 2){
                    while (scroll < inventorySize){
                        if (inventory.get(scroll).getType() != Type.MAGIC){
                            typeInventory.remove(inventory.get(scroll));
                        }
                        scroll = scroll + 1;
                    }
                }
               
                if (progress == 3){
                    while (scroll < inventorySize){
                        if (inventory.get(scroll).getType() != Type.SPECIAL){
                            typeInventory.remove(inventory.get(scroll));
                        }
                        scroll = scroll + 1;
                    }
                }

            inventorySize = typeInventory.size();

            System.out.println("┌────────────────────────────────────────────────────────────────────────────────────────────┐");
            System.out.println(" Choose your weapon for the next battle ");
            System.out.println(" One Melee for slot 1, one Range for slot 2, one Magic for slot 3 and one special for slot 4");
            afficherChoix(curseur, itemSelection,typeInventory);
            if(typeInventory.size()!=0){
                itemDescription(typeInventory.get(itemSelection));
            }
            System.out.println("└────────────────────────────────────────────────────────────────────────────────────────────┘");
            
            System.out.println("                                   Control :");
            System.out.println("                            q and d to scroll weapon");
            System.out.println("                                e to confirm");
            System.out.println("                           a to cancel last action");
            System.out.println();
            System.out.println("          Current usable item for this type : " + typeInventory.toString());

            read = sc.nextLine();

            if (read.equals("q")){
                if (itemSelection != 0){
                  itemSelection = itemSelection - 1;  
                }   
            }
            if (read.equals("d")){
                if (itemSelection <= inventorySize - 2){
                  itemSelection = itemSelection + 1;  
                }   
            }
            if (read.equals("e")){
                if (progress == 0 && typeInventory.get(itemSelection).getType() == Type.MELEE){
                    choice[progress] = typeInventory.get(itemSelection);
                    moveCursorDown(curseur);
                    progress = progress + 1;
                    typeInventory.remove(itemSelection);
                    itemSelection = 0;    
                } else if (progress == 0) {
                    System.out.println("Bad category of Item : you need MELEE item in slot 1");
                    Visuals.wait(sc);
                }
                else if (progress == 1 && typeInventory.get(itemSelection).getType() == Type.RANGE){
                    choice[progress] = typeInventory.get(itemSelection);
                    moveCursorDown(curseur);
                    progress = progress + 1;
                    typeInventory.remove(itemSelection);
                    itemSelection = 0;    
                }
                else if (progress == 1) {
                    System.out.println("Bad category of Item : you need RANGE item in slot 2");
                    Visuals.wait(sc);
                }
                else if (progress == 2 && typeInventory.get(itemSelection).getType() == Type.MAGIC){
                    choice[progress] = typeInventory.get(itemSelection);
                    moveCursorDown(curseur);
                    progress = progress + 1;
                    typeInventory.remove(itemSelection);
                    itemSelection = 0;    
                }
                else if (progress == 2) {
                    System.out.println("Bad category of Item : you need MAGIC item in slot 3");
                    Visuals.wait(sc);
                }
                else if(progress == 3 && !noSpecial()){
                    System.out.println("No special Item for slot 4...");
                    choice[progress] = new Special("Thinks",Type.SPECIAL,0,0,TypeGame.THINKING);
                    moveCursorDown(curseur);
                    progress = progress + 1;
                }
                else if (progress == 3 && typeInventory.get(itemSelection).getType() == Type.SPECIAL){
                    choice[progress] = typeInventory.get(itemSelection);
                    moveCursorDown(curseur);
                    progress = progress + 1;
                    typeInventory.remove(itemSelection);
                    itemSelection = 0;    
                }
                else if (progress == 3) {
                    System.out.println("Bad category of Item : you need SPECIAL item in slot 4");
                }
                
            }
            if (read.equals("a")){
                if (progress != 0){
                    choice[progress] = null;
                    moveCursorUp(curseur);
                    progress = progress - 1;
                } 
            }
            if (progress == 4){
                finish = true;
                inventory = (ArrayList<Item>) cloneInventory.clone();
            } 

            scroll = 0;
            typeInventory.clear();
            
             
        }
        
        System.out.println("End of selection phase. Battle starting soon. (Press Enter)");
        sc.nextLine();



    }

    void itemDescription(Item item){
        System.out.println("┌─────────────────────────────────┐");
        System.out.print("│   Name    : " + item.name); emptySpace(item.name);  System.out.println("│");
        System.out.println("├─────────────────────────────────┤");
        System.out.print("│ Type      : " + item.type);  emptySpace((item.type.name())); System.out.println("│"); ;
        System.out.print("│ Damage    : " + item.damage); emptySpace(String.valueOf(item.damage));  System.out.println("│");
        System.out.print("│ Crit_rate : " + item.critical_rate); emptySpace(String.valueOf(item.critical_rate));  System.out.println("│");
        System.out.print("│ Accuracy  : " + item.accuracy); emptySpace(String.valueOf(item.accuracy));  System.out.println("│");
        System.out.print("│ Rarity    : " + item.rarity); emptySpace(String.valueOf(item.rarity));  System.out.println("│");
        System.out.println("└─────────────────────────────────┘");
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

    public void addItem(Item item){
        inventory.add(item);
    }

    public void emptySpace(String tmp){
        int y = BOXSIZE - tmp.length();
        for (int i = 0; i < y; i++){
            System.out.print(" ");
        }
    }

    public boolean noSpecial(){
        boolean res = false;
        int i = 0;
        while (!res && i < inventory.size()){
            if (inventory.get(i).getType() == Type.SPECIAL){
                res = true;
            }
            i = i + 1;
        }
        return res;
    }

    public void afficherChoix(boolean[] curseur,int tmp, ArrayList<Item> typeInventory){

        String rep = "";

        //l1
        System.out.println("┌───┬────────────────────┐");

        //l2
        System.out.print("│");
        if (curseur[0]){System.out.print(" ⬤ ");}
        else {System.out.print("   ");}
        System.out.print("│");
        if (curseur[0] == true){
            System.out.print(typeInventory.get(tmp).toString());
            rep = typeInventory.get(tmp).toString();
            emptySpace(rep);
        } else if (choice[0] == null){
            System.out.print(" ------------------ ");
        } else {
            System.out.print(choice[0].toString());
            rep = choice[0].toString();
            emptySpace(rep);
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
            System.out.print(typeInventory.get(tmp).toString());
            rep = typeInventory.get(tmp).toString();
            emptySpace(rep);
        } else if (choice[1] == null){
            System.out.print(" ------------------ ");
        } else {
            System.out.print(choice[1].toString());
            rep = choice[1].toString();
            emptySpace(rep);
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
            System.out.print(typeInventory.get(tmp).toString());
            rep = typeInventory.get(tmp).toString();
            emptySpace(rep);
        } else if (choice[2] == null){
            System.out.print(" ------------------ ");
        } else {
            System.out.print(choice[2].toString());
            rep = choice[2].toString();
            emptySpace(rep);
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
            if(typeInventory.size()!=0){
                System.out.print(typeInventory.get(tmp).toString());
                rep = typeInventory.get(tmp).toString();
                emptySpace(rep);
            }
            else {
                System.out.print(" ------------------ ");
            }
        } else if (choice[3] == null){
            System.out.print(" ------------------ ");
        } else {
            System.out.print(choice[3].toString());
            rep = choice[3].toString();
            emptySpace(rep);
        }
        System.out.println("│");


        //l9
        System.out.println("└───┴────────────────────┘");        

    }

    public static void main(String[] args) {
            Inventory inventory = new Inventory();
            inventory.addItem(new Melee("sword of life", Type.MELEE, 100, 100, 100, 1));
            inventory.addItem(new Melee("sword of death", Type.MELEE, 100, 100, 100, 1));
            inventory.addItem(new Range("bow fofofofo", Type.RANGE, 0, 0, 0, 0, 0));
            inventory.addItem(new Range("bow of life", Type.RANGE, 100, 100, 100, 1, 0));
            inventory.addItem(new Magic("staff of staff", Type.MAGIC, 100, 100, 100, 1, 0));
            inventory.openInventory();
    }

}
