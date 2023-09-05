package main;

public class Shifumi {
    private final String actualPick;

    public Shifumi(Special pick){
        this.actualPick = pick.getName();
    }

    private String randompick(){
        int randomInt;
        String computerPick;

        randomInt =  (int)(Math.random()*3);
        if (randomInt==0){
            computerPick = "Rock";
        }
        else if(randomInt==1){
            computerPick = "Paper";
        }
        else{
            computerPick = "Scissors";
        }
        return computerPick;
    }

    public boolean fight(){
        String computerPick = randompick();
        if(computerPick.equals("Rock") && actualPick.equals("Paper")){
            return true;
        }
        else if(computerPick.equals("Paper") && actualPick.equals("Scissors")){
            return true;
        }
        else if(computerPick.equals("Scissors") && actualPick.equals("Rock")){
            return true;
        }
        else{
            return false;
        }
    }
}
