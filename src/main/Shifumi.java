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

    private void printPick(String computerPick){
        //own pick
        if(actualPick.equals("Paper")){
            System.out.println("You pick Paper :\n \"\"\"\n" + //
                    "     _______\n" + //
                    "---'    ____)____\n" + //
                    "           ______)\n" + //
                    "          _______)\n" + //
                    "         _______)\n" + //
                    "---.__________)\n" + //
                    "\"\"\"");
        }
        else if(actualPick.equals("Rock")){
            System.out.println("You pick Rock :");
            System.out.println("""
                _______
            ---'   ____)
                  (_____)
                  (_____)
                  (____)
            ---.__(___)
            """);
        }
        else if(actualPick.equals("Scissors")){
            System.out.println("You pick Scissors :\n \"\"\"\n" + //
                    "    _______\n" + //
                    "---'   ____)____\n" + //
                    "          ______)\n" + //
                    "       __________)\n" + //
                    "      (____)\n" + //
                    "---.__(___)\n" + //
                    "\"\"\")");
        }
        //Ennemi pick
        if(computerPick.equals("Paper")){
            System.out.println("Your ennemi pick Paper :\n \"\"\"\n" + //
                    "     _______\n" + //
                    "---'    ____)____\n" + //
                    "           ______)\n" + //
                    "          _______)\n" + //
                    "         _______)\n" + //
                    "---.__________)\n" + //
                    "\"\"\"");
        }
        else if(computerPick.equals("Rock")){
            System.out.println("Your ennemi pick Rock :");
            System.out.println("""
                _______
            ---'   ____)
                  (_____)
                  (_____)
                  (____)
            ---.__(___)
            """);
        }
        else if(computerPick.equals("Scissors")){
            System.out.println("Your ennemi pick Scissors :\n \"\"\"\n" + //
                    "    _______\n" + //
                    "---'   ____)____\n" + //
                    "          ______)\n" + //
                    "       __________)\n" + //
                    "      (____)\n" + //
                    "---.__(___)\n" + //
                    "\"\"\")");
        }
    }

    public boolean fight(){
        String computerPick = randompick();
        printPick(computerPick);
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
