package components.eventComponents;

import Interface.MoveInterface;
import components.Const;
import components.backendComponents.Board;
import components.backendComponents.MainBoard;
import components.backendComponents.Tile;
import components.sideComponents.WelcomeMenu;
import enums.GameColors;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameControler implements MoveInterface {
    //    GABINET CIENI ROZGRYFKI - BACKEND ODPOWADAJACY ZA SPRAWDZANIE WSZSYKICH CZYNNIKÓW GRY NA PODSTAWIE STATE I INNYCH KOMPONENTÓ
    State state;
    MainBoard mainBoard;
    int player_number = state.getPlayer_turn();
    boolean endGame = false;
    int gameResult = 0;

    public GameControler(State state, MainBoard mainBoard) {
        this.state = state;
        this.mainBoard = mainBoard;
//        LOADSAVEGAME CLASS
//        STATE SET-UP
//        BOARDS UP-DATE
    }

    //    METHODS GAMEPLAY
//HERE IS MAIN ACTION!IT'S FINE WITH THAT BUT... ARE YOU GONA MOVE!?
    public void move(int x, int y, int bigX, int bigY) {
        switch (player_number) {
            case 1:
                getDobryPrzycisk(x, y, bigX, bigY).setIcon(Const.GRACZ1);
                setButtonPressed(getDobryTile(x, y, bigX, bigY));
                setColorBorder(getDobryPrzycisk(x, y, bigX, bigY), GameColors.BLUE.name());
//                  int[][]
                setSmallIntTabCell(x,y,bigX,bigY,player_number);
                printIntTab(getSmallIntTab(bigX,bigY));
                int end1 = state.resultIntTab(getSmallIntTab(bigX,bigY));
                System.out.println("result: " + end1);
                if (end1!=0) {
                    setTileBord(getGoodTileTab(bigX,bigY),end1);
                    setBigIntTabCell(bigX,bigY,end1);
                    printIntTab(getBigIntTab());
                }
                player_number = 2;
                break;
            case 2:
                getDobryPrzycisk(x, y, bigX, bigY).setIcon(Const.GRACZ2);
                setButtonPressed(getDobryTile(x, y, bigX, bigY));
                setColorBorder(getDobryPrzycisk(x, y, bigX, bigY), GameColors.RED.name());
//                int[][]
                setSmallIntTabCell(x,y,bigX,bigY,player_number);
                printIntTab(getSmallIntTab(bigX,bigY));
                int end2 = state.resultIntTab(getSmallIntTab(bigX,bigY));
                System.out.println("result: " + end2);
                if (end2!=0) {
                    setTileBord(getGoodTileTab(bigX,bigY),end2);
                    setBigIntTabCell(bigX,bigY,end2);
                    printIntTab(getBigIntTab());
                }
                player_number = 1;
                break;
        }

        System.out.println("gameContorler says: moved");
    }

    //SUPPORT METHODS


    public Tile[][] getGoodTileTab(int bigX, int bigY){
        return this.mainBoard.getMainBoardTab()[bigX][bigY].getTileBoard();
    }
    public JButton getDobryPrzycisk(int x, int y, int bigX, int bigY) {
        return this.mainBoard.getMainBoardTab()[bigX][bigY].getTileBoard()[x][y].getButton();
    }

    public Tile getDobryTile(int x, int y, int bigX, int bigY) {
        return this.mainBoard.getMainBoardTab()[bigX][bigY].getTileBoard()[x][y];
    }

    public void setButtonPressed(Tile tile) {
        tile.setPressed(true);
    }

    public void setBasicIcon(JButton button) {
        button.setIcon(Const.BASIC2);
    }

    public void setIntCell(int xX, int yY, int[][] tab, int value) {
        tab[xX][yY] = value;
    }

    public int returnIntCell() {
        return 0;
    }
    public int[][] getBigIntTab() {
        return this.mainBoard.getMainIntBoard();
    }

    public int[][] getSmallIntTab(int bigX, int bigY) {
        return this.mainBoard.getMainBoardTab()[bigX][bigY].getIntBoard();
    }

    public void setBigIntTabCell(int bigX, int bigY, int value) {
        this.mainBoard.getMainIntBoard()[bigX][bigY]=value;
    }
    public void setSmallIntTabCell(int x, int y, int bigX, int bigY, int value) {
        this.mainBoard.getMainBoardTab()[bigX][bigY].getIntBoard()[x][y] = value;
    }

//    switchActiveButton()
//    WINLOSECONDIDONS METHODS
public void setTileBord(Tile[][] tab, int player_number) {
//        ANIMACJA!!!!!
    int delay = 500;
    Timer timer = new Timer(delay, null);
    timer.addActionListener(new ActionListener() {
        int k = tab.length - 1;
        int l = 0;
        @Override
        public void actionPerformed(ActionEvent e) {
            if (k >= 0) {
                setButtonPressed(tab[l][k]);
                if (player_number == 1) {
                    setColorBorder(tab[l][k].getButton(), GameColors.BLUE.name());
                    tab[l][k].getButton().setIcon(Const.GRACZ1);
                } else if (player_number == 2) {
                    setColorBorder(tab[l][k].getButton(), GameColors.RED.name());
                    tab[l][k].getButton().setIcon(Const.GRACZ2);
                } else {
                    setColorBorder(tab[l][k].getButton(), GameColors.GRAY.name());
                    tab[l][k].getButton().setIcon(Const.BASIC2);
                }
                l++;
                if (l >= tab[k].length) {
                    l = 0;
                    k--;
                }
                if (k < 0) {
                    timer.stop();
                }
            }
        }
    });
//        TU CISNIEMY Z WĄTKIEM DLA INSTANCJI TIMERA
    SwingUtilities.invokeLater(new Runnable() {
        @Override
        public void run() {
            timer.setInitialDelay(100);
            timer.start();
        }
    });
//        timer.setInitialDelay(100);
//        timer.start();
}
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
//KASOWANIE RAMKI
    public static void resetColorBorder(JButton button) {
        button.setBorder(null);
    }

    public void resetBorder(){

    }
//    TEST METHODS
public void testPrint(int x, int y, int bigX, int bigY) {
    System.out.println("GameControlerSpeaks:");
    System.out.println("x:"+x + "y:" + y);
    System.out.println("bigX:"+bigX + "bigY:" + bigY);
}

public void printIntTab(int[][] tab){
    System.out.println("wywyłana tablica: ");
        for(int i = tab.length-1;i >=0; i--) {
            for (int j = 0; j<tab.length;j++) {
                System.out.print(tab[j][i]);
            }
            System.out.println();
        }
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
