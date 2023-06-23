package components.eventComponents;

import components.Const;
import components.backendComponents.MainBoard;

import javax.swing.*;
import java.awt.*;

public class GameControler {
//    GABINET CIENI ROZGRYFKI - BACKEND ODPOWADAJACY ZA SPRAWDZANIE WSZSYKICH CZYNNIKÓW GRY NA PODSTAWIE STATE I INNYCH KOMPONENTÓ
    State state;
    MainBoard mainBoard;
    int player_number = 1;

    public GameControler(State state, MainBoard mainBoard) {
        this.state = state;
        this.mainBoard = mainBoard;
//        LOADSAVEGAME CLASS
//        STATE SET-UP
//        BOARDS UP-DATE
    }

    //    METHODS GAMEPLAY
//HERE IS MAIN ACTION!IT'S FINE WITH THAT BUT... ARE YOU GONA MOVE!?
    public void move(int x, int y, int bigX, int bigY){
        switch (player_number) {
            case 1:
                getDobryPrzycisk(x, y, bigX, bigY).setIcon(Const.GRACZ1);
//                IntTAB INTRUKCJA
                player_number = 2;
                break;
            case 2:
                getDobryPrzycisk(x, y, bigX, bigY).setIcon(Const.GRACZ2);
//                INTAB INTRUKCJA
                player_number = 1;
                break;
        }
//        this.mainBoard.getMainBoardTab()[bigX][bigY].getTileBoard()[x][y].getButton().setIcon(Const.BASIC2);
//            MACHANIZM KOLOROWANIA RAMKI PRZYCISKU
//        Color borderColor = Color.RED;
//        int borderWidth = 5;
//        Border lineBorder = BorderFactory.createLineBorder(borderColor, borderWidth);
//        this.getButton().setBorder(lineBorder);
        System.out.println("moved");
    }





//    TEST METHODS
    public void testPrint(int x, int y, int bigX, int bigY) {
        System.out.println("GameControlerSpeaks:");
        System.out.println("x:"+x + "y:" + y);
        System.out.println("bigX:"+bigX + "bigY:" + bigY);
    }
//SUPPORT METHODS
    public JButton getDobryPrzycisk(int x, int y, int bigX, int bigY){
        return this.mainBoard.getMainBoardTab()[bigX][bigY].getTileBoard()[x][y].getButton();
    }

    public void setBasicIcon(JButton button) {
        button.setIcon(Const.BASIC2);
    }
    public void setColorBorder (JButton button) {

    }
    public void setIntCell(int xX, int yY, int[][] tab, int value){
        tab[xX][yY] = value;
    }
    public int returnIntCell(){
        return 0;
    }
//    getBigIntTab()
//    getSmallIntTab()

//    WINLOSECONDIDONS METHODS


//BOILER PLATE

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public MainBoard getMainBoard() {
        return mainBoard;
    }

    public void setMainBoard(MainBoard mainBoard) {
        this.mainBoard = mainBoard;
    }

    public int getPlayer_number() {
        return player_number;
    }

    public void setPlayer_number(int player_number) {
        this.player_number = player_number;
    }
}
