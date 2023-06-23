package components.eventComponents;

import java.io.*;
import java.util.Scanner;

public class SaveGame {
    String action_title;
    int player_turn;
    int bigX;
    int bigY;
    int[][] tab;
    FileReader file;

    final String startPath = ("./src/save/start.txt");
    final String loadPath = ("./src/save/save.txt");
    final String testPath = ("./src/save/test.txt");
    final String savePath = ("./src/save/save.txt");
    final FileWriter saveGame = new FileWriter(savePath);

    public SaveGame(String action_title) throws IOException {
        this.action_title = action_title;

        switch (action_title) {
            case "START":
                this.file = new FileReader(startPath);
                break;
            case "LOAD":
                this.file = new FileReader(loadPath);
                break;
            case "TEST":
                this.file = new FileReader(testPath);
                break;
            case "SAVE":
                break;
            default:


                System.out.println("SAVEGAME nie działa poprawnie");



        }
    }
//    METHODS
    public void printGameFile(){
//        Scanner sc = new Scanner();

    }




//    BOILERPLATE


    public String getAction_title() {
        return action_title;
    }

    public void setAction_title(String action_title) {
        this.action_title = action_title;
    }

    public int getPlayer_turn() {
        return player_turn;
    }

    public void setPlayer_turn(int player_turn) {
        this.player_turn = player_turn;
    }

    public int getBigX() {
        return bigX;
    }

    public void setBigX(int bigX) {
        this.bigX = bigX;
    }

    public int getBigY() {
        return bigY;
    }

    public void setBigY(int bigY) {
        this.bigY = bigY;
    }

    public int[][] getTab() {
        return tab;
    }

    public void setTab(int[][] tab) {
        this.tab = tab;
    }

    public String getStartPath() {
        return startPath;
    }

    public String getLoadPath() {
        return loadPath;
    }

    public String getTestPath() {
        return testPath;
    }

    public FileReader getFile() {
        return file;
    }

    public void setFile(FileReader file) {
        this.file = file;
    }

    public String getSavePath() {
        return savePath;
    }

    public FileWriter getSaveGame() {
        return saveGame;
    }
}
