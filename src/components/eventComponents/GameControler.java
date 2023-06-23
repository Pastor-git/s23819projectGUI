package components.eventComponents;

import Interface.MoveInterface;
import components.Const;
import components.backendComponents.MainBoard;
import components.backendComponents.Tile;
import enums.GameColors;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class GameControler implements MoveInterface {
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
                setButtonPressed(getDobryTile(x, y, bigX, bigY));
//                IntTAB INTRUKCJA
                setColorBorder(getDobryPrzycisk(x, y, bigX, bigY), GameColors.BLUE.name());
                player_number = 2;
                break;
            case 2:
                getDobryPrzycisk(x, y, bigX, bigY).setIcon(Const.GRACZ2);
                setColorBorder(getDobryPrzycisk(x, y, bigX, bigY), GameColors.RED.name());
                setButtonPressed(getDobryTile(x, y, bigX, bigY));
//                INTAB INTRUKCJA
                player_number = 1;
                break;
        }
//        this.mainBoard.getMainBoardTab()[bigX][bigY].getTileBoard()[x][y].getButton().setIcon(Const.BASIC2);


        System.out.println("moved");
    }

//SUPPORT METHODS
    public JButton getDobryPrzycisk(int x, int y, int bigX, int bigY){
        return this.mainBoard.getMainBoardTab()[bigX][bigY].getTileBoard()[x][y].getButton();
    }
    public Tile getDobryTile(int x, int y, int bigX, int bigY){
        return this.mainBoard.getMainBoardTab()[bigX][bigY].getTileBoard()[x][y];
    }
    public void setButtonPressed(Tile tile){
        tile.setPressed(true);
    }
    public void setBasicIcon(JButton button) {
        button.setIcon(Const.BASIC2);
    }

    public void setIntCell(int xX, int yY, int[][] tab, int value){
        tab[xX][yY] = value;
    }
    public int returnIntCell(){
        return 0;
    }
//    getBigIntTab()
//    getSmallIntTab()

//    switchActiveButton()
//    WINLOSECONDIDONS METHODS
public void setColorBorder (JButton button, String COLOR) {
    Color borderColor;

    switch (COLOR) {
        case "RED":
            borderColor = Color.RED;
            break;
        case "BLUE":
            borderColor = Color.BLUE;
            break;
        case "GREEN":
            borderColor = Color.GREEN;
            break;
        case "GRAY":
            borderColor = Color.GRAY;
            break;
        case "YELLOW":
            borderColor = Color.YELLOW;
            break;
        default:
            borderColor = Color.BLACK;
            break;
    }
    int borderWidth = 4;
    Border lineBorder = BorderFactory.createLineBorder(borderColor, borderWidth);
    button.setBorder(lineBorder);
}
//    TEST METHODS
public void testPrint(int x, int y, int bigX, int bigY) {
    System.out.println("GameControlerSpeaks:");
    System.out.println("x:"+x + "y:" + y);
    System.out.println("bigX:"+bigX + "bigY:" + bigY);
}

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
