package main;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class RecordManager {
    private static final String RECORD_PATH = "res/record.txt";

    private static void editBestScore(int score){
        String res = score+"";
        try (PrintWriter pw = new PrintWriter(new File(RECORD_PATH))) {
            pw.println(res);
            pw.flush();
            pw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static int getBestScore(){
        int res = 0;
        try (Scanner sc = new Scanner(new File(RECORD_PATH))) {
            res = Integer.parseInt(sc.next());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return res;
    }

    public static void changeScore(int score){
        if(score > RecordManager.getBestScore()){
            RecordManager.editBestScore(score);
        }
    }
}
