package main;

import java.util.ArrayList;
import java.util.Scanner;

import javax.print.attribute.Size2DSyntax;

public class Map {
    private final String BORDER = "\u2588";
    private final String BIRD = "\u2022";
    private final int SIZE = 10;


    public int[][] generateMap(){
        int[][] map;
        //border generation
        for(int x=0; x<SIZE; x++){
            for(int y=0; y<SIZE; y++){
                if(x==0||y==0){
                    map[x][y] = 1;
                }
                else{
                    map[x][y] = 0;
                }
            }
        }
        //entry and exit generation
        int yEntry = (int)(Math.random()*(SIZE-2))+1;
        int yExit = (int)(Math.random()*SIZE-2)+1;

        map[0][yEntry]=0;
        map[SIZE-1][yExit]=0;

        //Bird positionnement
        map[1][yEntry]=-1;

        return map;
    }

    public void afficherMap(int[][] map){
        for(int ligne=0; ligne<SIZE; ligne++){
            for(int colonne=0; colonne<SIZE)
        }
    }

    public void movement(){
        Scanner sc = new Scanner(System.in);
        String input;
        boolean isFinished = false;

        while(!isFinished){
            input = sc.nextLine();
            if(input.equals("z")){
                y++;
                x++;
                System.out.println("You go up");
                isFinished = true;
            }
            else if(input.equals("s")){
                y--;
                x++;
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
