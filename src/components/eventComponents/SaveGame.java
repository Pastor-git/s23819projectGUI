package components.eventComponents;

import components.backendComponents.Board;
import components.backendComponents.MainBoard;

import java.io.*;

public class SaveGame {
    int player_turn;
    int bigX;
    int bigY;
    int[] intTab;
    MainBoard shadowMainBoard;
    String savePath = ("./src/save/save.txt");
    FileWriter fileWriter;
    public SaveGame(){

    }

    public SaveGame(MainBoard shadowMainBoard, int bigX, int bigY, int player_turn) throws IOException {
        this.shadowMainBoard = shadowMainBoard;
        this.bigX = bigX;
        this.bigY = bigY;
        this.player_turn = player_turn;
    }

//    METHODS
    public void saveGameToTXT() throws IOException {
        FileWriter fileWriter = new FileWriter(savePath);
        String s = "";
//        BaseState
        s = s+this.player_turn+this.bigX+this.bigY;
//        MainInt[][]
        for (int i =0;i<3;i++) {
            for(int j =0; j<3;j++) {
                s=s+shadowMainBoard.getMainIntBoard()[i][j];
            }
        }
//        BasicInt[][]
        for (int i =0;i<3;i++) {
            for(int j =0; j<3;j++) {
                int[][] tab = shadowMainBoard.getMainBoardTab()[i][j].getIntBoard();
                for (int a =0;a<3;a++) {
                    for(int b =0; b<3;b++) {
                        s=s+tab[a][b];
                    }
                }
            }
        }
        System.out.println("save game: " + s);
        fileWriter.write(s);
        fileWriter.close();
    }

    public void loadGameFromInt() throws IOException {
        this.shadowMainBoard = new MainBoard();
        loadTXTSaveGametoInt();
        player_turn = intTab[0];
        bigX = intTab[1];
        bigY = intTab[2];
        int number = 3;
        this.shadowMainBoard.setMainIntBoard(new int[3][3]);
        for (int i =0;i<3;i++) {
            for(int j =0; j<3;j++) {
                shadowMainBoard.getMainIntBoard()[i][j]=intTab[number];
                number++;
            }
        }

        this.shadowMainBoard.setMainBoardTab(new Board[3][3]);
        for (int i =0;i<3;i++) {
            for(int j =0; j<3;j++) {
                shadowMainBoard.getMainBoardTab()[i][j]=new Board();
            }
        }
        System.out.println();
        for (int i =0;i<3;i++) {
            for(int j =0; j<3;j++) {
                shadowMainBoard.getMainBoardTab()[i][j].setIntBoard(new int[3][3]);
                for (int a =0;a<3;a++) {
                    for(int b =0; b<3;b++) {
                        shadowMainBoard.getMainBoardTab()[i][j].getIntBoard()[a][b]=intTab[number];
                        System.out.print(intTab[number]);
                        number++;
                    }
                }
            }
        }
        System.out.println("numebr: " + number);
        System.out.println("save game nasze pole: " + shadowMainBoard.getMainBoardTab()[1][1].getIntBoard()[1][1]);

    }
    public void loadTXTSaveGametoInt() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(savePath));
        String s = bufferedReader.readLine();
        System.out.println(s);
        char[] charTab = s.toCharArray();
        this.intTab  = new int[charTab.length];
        for (int i = 0; i < charTab.length; i++) {
            intTab[i] = Character.getNumericValue(charTab[i]);
        }
//        TEST
        for (int i : this.intTab) {
            System.out.print(i);
        }
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

    public int[] getIntTab() {
        return intTab;
    }

    public void setIntTab(int[] intTab) {
        this.intTab = intTab;
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
