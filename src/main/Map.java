package main;

import java.util.Scanner;

public class Map {
    private final String BORDER = "\u2588";
    private final String BIRD = "\u2022";

    public void movement(){
        Scanner sc = new Scanner(System.in);
        String input;
        boolean isFinished = false;

        while(!isFinished){
            input = sc.nextLine();
            if(input.equals("z")){
                y++;
                System.out.println("You go up");
                isFinished = true;
            }
            else if(input.equals("q")){
                x--;
                System.out.println("You go left");
                isFinished = true;
            }
            else if(input.equals("s")){
                y--;
                System.out.println("You go down");
                isFinished = true;
            }
            else if(input.equals("d")){
                x++;
                System.out.println("You go right");
                isFinished = true;
            }
            else{
                System.out.println("Please enter a valid displacement (z,q,s,d)");
            }
        }
    }
}
