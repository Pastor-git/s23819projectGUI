package components.eventComponents;

import components.backendComponents.MainBoard;

import java.io.*;

public class SaveGame {
    int player_turn;
    int bigX;
    int bigY;
    int[][] tab;
    MainBoard shadowMainBoard;
    String savePath = ("./src/save/save.txt");
    FileWriter fileWriter;
    public SaveGame() {
        loadGameFromTXT();
    }
    public SaveGame(MainBoard shadowMainBoard, int bigX, int bigY, int player_turn) throws IOException {
        this.shadowMainBoard = shadowMainBoard;
        this.bigX = bigX;
        this.bigY = bigY;
        this.player_turn = player_turn;
    }

//    METHODS
    public void saveGameToTXT() throws IOException {
        FileWriter fileWriter = new FileWriter("./src/save/save.txt");
        String s = "";
        s = s+this.player_turn+this.bigX+this.bigY;
//        opcjonalnie
//        for (int i =0;i<3;i++) {
//            for(int j =0; j<3;j++) {
//                s=s+shadowMainBoard.getMainIntBoard()[i][j];
//            }
//        }
        for (int i =0;i<3;i++) {
            for(int j =0; j<3;j++) {
                int[][] tab = shadowMainBoard.getMainBoardTab()[i][j].getIntBoard();
                for (int a =0;a<3;a++) {
                    for(int b =0; b<3;b++) {
                        s=s+tab[i][j];
                    }
                }
            }
        }
        System.out.println("save game: " + s);
        fileWriter.write(s);
        fileWriter.close();
    }

    public void loadGameFromTXT(){

    }


//    BOILERPLATE

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

    public String getSavePath() {
        return savePath;
    }

    public MainBoard getShadowMainBoard() {
        return shadowMainBoard;
    }

    public void setShadowMainBoard(MainBoard shadowMainBoard) {
        this.shadowMainBoard = shadowMainBoard;
    }

    public FileWriter getFileWriter() {
        return fileWriter;
    }
}
