package main;

import java.util.Scanner;

import javax.print.attribute.Size2DSyntax;
import javax.print.attribute.standard.Sides;

public class Map {
    private final String BORDER = "\u2588";
    private final String BIRD = "\u2022";
    private final String MIDMAP = "\u2800";
    private final int SIZE = 10;
    private int xBird;
    private int xBackBird;
    private int yBird;
    private int yBackBird;
    private int yEnd;
    private int[][] map;

    public Map(){
        this.map = new int[SIZE][SIZE];
    }


    public void generateMap(){
        //border generation
        for(int x=0; x<SIZE; x++){
            for(int y=0; y<SIZE; y++){
                if(x==0||x==9){
                    this.map[x][y] = 1;
                }
                else if(y==0||y==9){
                    this.map[x][y] = 1;
                }
                else{
                    this.map[x][y] = 0;
                }
            }
        }
        //entry and exit generation
        int yEntry = (int)(Math.random()*(SIZE-2))+1;
        int yExit = (int)(Math.random()*(SIZE-2))+1;
        yEnd = yExit;

        this.map[0][yEntry]=0;
        this.map[SIZE-1][yExit]=0;

        //Bird positionnement
        xBird = 1;
        yBird = yEntry;
        this.map[xBird][yBird]=-1;
    }

    public void afficherMap(){
        for(int colonne=0; colonne<SIZE; colonne++){
            for(int ligne=0; ligne<SIZE; ligne++){
                if(this.map[ligne][colonne]==1){
                    System.out.print(BORDER);
                }
                else if(this.map[ligne][colonne]==0){
                    System.out.print(MIDMAP);
                }
                else if(this.map[ligne][colonne]==-1){
                    System.out.print(BIRD);
                }
            }
            System.out.println("");
        }
    }

    public void birdPosition(){
        this.map[xBackBird][yBackBird]=0;
        this.map[xBird][yBird]=-1;
    }

    public void movement(){
        Scanner sc = new Scanner(System.in);
        String input;
        boolean isFinished = false;

        while(!isFinished){
            input = sc.nextLine();
            if(input.equals("z")){
                yBackBird = yBird;
                yBird--;
                xBackBird = xBird;
                xBird++;
                System.out.println("You go up");
                isFinished = true;
            }
            else if(input.equals("s")){
                yBackBird = yBird;
                yBird++;
                xBackBird = xBird;
                xBird++;
                System.out.println("You go down");
                isFinished = true;
            }
            else if(input.equals("d")){
                xBackBird = xBird;
                xBird++;
                yBackBird = yBird;
                System.out.println("You go right");
                isFinished = true;
            }
            else{
                System.out.println("Please enter a valid displacement (z,q,s,d)");
            }
        }
        birdPosition();
    }

    public boolean checkPosDeath(){
        if(yBird==0||yBird==SIZE-1||xBird==SIZE-1){
            return true;
        }
        return false;
    }

    public boolean checkPosWin(){
        if(yBird==yEnd&&xBird==SIZE-1){
            return true;
        }
        return false;
    }

    public boolean flappy(){
        boolean isFinished = false;
        generateMap();
        while(!isFinished){
            afficherMap();
            movement();
            if(checkPosWin()){
                return true;
            }
            if(checkPosDeath()){
                return false;
            }
            birdPosition();
        }
        return false;
    }

    public static void main(String[] args) {
        Map map = new Map();
        System.out.println(map.flappy());
    }
}
