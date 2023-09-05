package main;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class RecordManager {
    private static final String RECORD_PATH = "res/record.txt";

    private static void editBestScore(String name, int score){
        try (PrintWriter pw = new PrintWriter(new File(RECORD_PATH))) {
            if(score > 2){
                pw.println(name + " : " + score + "points");
            }else{
                pw.println(name + " : " + score + "point");
            }
            pw.flush();
            pw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static int getBestScore(){
        int res = 0;
        try (Scanner sc = new Scanner(new File(RECORD_PATH)).useDelimiter(" ")) {
            sc.next();
            sc.next();
            res = Integer.parseInt(sc.next());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return res;
    }

    public static void changeScore(String name, int score){
        if(score > RecordManager.getBestScore()){
            RecordManager.editBestScore(name, score);
        }
    }
}
