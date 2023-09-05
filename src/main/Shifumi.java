package main;

public class Shifumi {
    private final Special actualPick;

    public Shifumi(Special pick){
        this.actualPick = pick;
    }

    private Special randompick(){
        int randomInt;
        Special computerPick;

        randomInt =  (int)(Math.random()*3);
        if (randomInt==0){
            computerPick = Special(Rock);
        }
        else if(randomInt==1){
            computerPick = Special(Paper);
        }
        else if(randomInt==2){
            computerPick = Special(Scissor);
        }
    }

    public boolean fight(){
        Special computerPick = randompick();
        if(computerPick = Rock && actualPick = Paper){
            return true;
        }
        else if(computerPick = Paper && actualPick = Scissor){
            return true;
        }
        else if(computerPick = Scissor && actualPick = Rock){
            return true;
        }
        else{
            return false;
        }
    }
}
