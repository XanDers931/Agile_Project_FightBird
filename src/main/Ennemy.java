package main;


public class Ennemy {
    private String name;
    private int pv;
    final private int PVMAX;
    private int attack;

    private final int NUMBEROFNAMES = 10;
    private final int MINPVMAX = 10;
    private final int MINATTACK = 10;

    private int randomStat;

    private final String[] names = {"Piaf-Piaf","Pirou-Pirou","Pac-Man","Pouf-Pouf","Pif-Pif","Pouet-Pouet","Abracadabra","Lorem ipsum","Gandalf","Hello World"};
    
    public Ennemy(String name, int pVMAX, int attack) {
        this.name = name;
        this.pv = pVMAX;
        PVMAX = pVMAX;
        this.attack = attack;
    }

    public Ennemy(int score){
        this.name = names[(int) (Math.random()*NUMBEROFNAMES)];
        randomStat = (int) (Math.random()*(score+1));
        this.pv = MINPVMAX+(score*score) + (randomStat*2) * (int) ((score/100)+1);
        this.PVMAX = this.pv;
        this.attack = MINATTACK + (score - randomStat) * (int) ((score/100)+1); 

    }

    public Ennemy(){
        this("Piaf-piaf",20,1);
    }

    public int getPVMAX() {
        return PVMAX;
    }
    public String getName() {
        return name;
    }
    
    public int getPv() {
        return pv;
    }
    
    public int getAttack() {
        return attack;
    }
        
    public void takeDamage(int damage){
        if(pv-damage<0){
            pv=0;
        }
        else {
            pv-=damage;
        }
    }

    @Override
    public String toString() {
        return "Name :" + name + "\npv : " + pv + "/" + PVMAX + "\nattack : " + attack ;
    }

    /*
    public static void main(String[] args) {
        Ennemy ennemy0 = new Ennemy(0);
        Ennemy ennemy1 = new Ennemy(1);
        Ennemy ennemy2 = new Ennemy(2);
        Ennemy ennemy3 = new Ennemy(3);
        Ennemy ennemy4 = new Ennemy(4);
        Ennemy ennemy5 = new Ennemy(5);
        Ennemy ennemy6 = new Ennemy(20);
        Ennemy ennemy7 = new Ennemy(30);
        Ennemy ennemy8 = new Ennemy(60);
        Ennemy ennemy9 = new Ennemy(100);
        System.out.println(ennemy0.toString());
        System.out.println(ennemy1.toString());
        System.out.println(ennemy2.toString());
        System.out.println(ennemy3.toString());
        System.out.println(ennemy4.toString());
        System.out.println(ennemy5.toString());
        System.out.println(ennemy6.toString());
        System.out.println(ennemy7.toString());
        System.out.println(ennemy8.toString());
        System.out.println(ennemy9.toString());
    }
    */
    
}
