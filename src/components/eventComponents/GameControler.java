package components.eventComponents;

import Interface.MoveInterface;
import components.Const;
import components.backendComponents.Board;
import components.backendComponents.MainBoard;
import components.backendComponents.Tile;
import components.gameComponents.MainFrame;
import components.sideComponents.EndScreen;
import components.sideComponents.WelcomeMenu;
import enums.GameColors;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class GameControler implements MoveInterface {
    //    GABINET CIENI ROZGRYWKI - BACKEND ODPOWADAJACY ZA SPRAWDZANIE WSZSYKICH CZYNNIKÓW GRY NA PODSTAWIE STATE I INNYCH KOMPONENTÓ
    State state;
    MainBoard mainBoard;
    int player_number = 1;
    boolean endGame = false;

    public static int x =0;
    public static int y =0;
    public static int bigX =0;
    public static int bigY =0;
    int gameResult = 0;
    public GameControler() {
    }
    public GameControler(State state, MainBoard mainBoard) throws IOException {
        this.state = state;
        this.mainBoard = mainBoard;
        stateGameLoad(state.gameLabel);
    }

//    SAVE GAME
    public void saveGame() throws IOException {
        SaveGame saveGame = new SaveGame(this.mainBoard,this.bigX,this.bigY,this.player_number);
        System.out.println("gameControler Speaks: save game pressed");
        saveGame.saveGameToTXT();
    }
//    GAME START
    public void stateGameLoad(String label) throws IOException {
        state.gameLunch();
        System.out.println("inizalizacja gry z poziomu gameControler" + label);
        if(label.equals("LOAD")) {
            System.out.println("!Będę wczytywć grę z saveGame!");
            this.player_number = state.player_turn;
            this.bigX = state.bigX;
            this.bigY = state.bigY;
            this.mainBoard.setMainIntBoard(state.shadowMainBoard.getMainIntBoard());
            for (int i =0;i<3;i++) {
                for(int j =0; j<3;j++) {
                    mainBoard.getMainBoardTab()[i][j].setIntBoard(state.shadowMainBoard.getMainBoardTab()[i][j].getIntBoard());
                }
            }
            resetTiles();
        }
    }
    public void resetTiles() {

        for (int i =0;i<3;i++) {
            for(int j =0; j<3;j++) {
                if(mainBoard.getMainIntBoard()[i][j]==3) {
                    for (int a =0;a<3;a++) {
                        for(int b =0; b<3;b++) {
                            setColorBorder(mainBoard.getMainBoardTab()[i][j].getTileBoard()[a][b].getButton(), GameColors.GRAY);
                            mainBoard.getMainBoardTab()[i][j].getTileBoard()[a][b].getButton().setIcon(Const.BASIC);
                            mainBoard.getMainBoardTab()[i][j].getTileBoard()[a][b].setActive(false);
                            mainBoard.getMainBoardTab()[i][j].getTileBoard()[a][b].setPressed(true);
                        }
                    }
                }  else if (mainBoard.getMainIntBoard()[i][j]==2) {
                    for (int a =0;a<3;a++) {
                        for(int b =0; b<3;b++) {
                            setColorBorder(mainBoard.getMainBoardTab()[i][j].getTileBoard()[a][b].getButton(), GameColors.RED);
                            mainBoard.getMainBoardTab()[i][j].getTileBoard()[a][b].getButton().setIcon(Const.GRACZ2);
                            mainBoard.getMainBoardTab()[i][j].getTileBoard()[a][b].setActive(false);
                            mainBoard.getMainBoardTab()[i][j].getTileBoard()[a][b].setPressed(true);
                        }
                    }

                }  else if (mainBoard.getMainIntBoard()[i][j]==1) {
                    for (int a =0;a<3;a++) {
                        for(int b =0; b<3;b++) {
                            setColorBorder(mainBoard.getMainBoardTab()[i][j].getTileBoard()[a][b].getButton(), GameColors.BLUE);
                            mainBoard.getMainBoardTab()[i][j].getTileBoard()[a][b].getButton().setIcon(Const.GRACZ1);
                            mainBoard.getMainBoardTab()[i][j].getTileBoard()[a][b].setActive(false);
                            mainBoard.getMainBoardTab()[i][j].getTileBoard()[a][b].setPressed(true);
                        }
                    }

                } else if (mainBoard.getMainIntBoard()[i][j]==0){
                    for (int a =0;a<3;a++) {
                        for(int b =0; b<3;b++) {
                            if (mainBoard.getMainBoardTab()[i][j].getIntBoard()[a][b]==2) {
                                mainBoard.getMainBoardTab()[i][j].getTileBoard()[a][b].getButton().setIcon(Const.GRACZ2);
                                mainBoard.getMainBoardTab()[i][j].getTileBoard()[a][b].setActive(false);
                                mainBoard.getMainBoardTab()[i][j].getTileBoard()[a][b].setPressed(true);
                            } else if (mainBoard.getMainBoardTab()[i][j].getIntBoard()[a][b]==1) {
                                mainBoard.getMainBoardTab()[i][j].getTileBoard()[a][b].getButton().setIcon(Const.GRACZ1);
                                mainBoard.getMainBoardTab()[i][j].getTileBoard()[a][b].setActive(false);
                                mainBoard.getMainBoardTab()[i][j].getTileBoard()[a][b].setPressed(true);
                            } else {

                            }
                    }
                }
            }
        }
    }
        TicTacToaStyleMove();
    }


    //    METHODS GAMEPLAY
//TICTACTOE STYLE
    public void TicTacToaStyleMove() {
        MainBoard boardTTT = getMainBoard();
        if(boardTTT.getMainIntBoard()[this.bigX][this.bigY]!=0){
            resetMainBoard();
            System.out.println("plansza (X,Y): (" + this.bigX + "," + this.bigY + ") ma wartość: " + boardTTT.getMainIntBoard()[this.bigX][this.bigY]);
        } else {
            Board temBoard = getDobraBoardTablica(this.bigX, this.bigY);
            resetMainBoardToFalse();
            if(endGame==false) {
                setColorInTileBoarder(temBoard.getTileBoard(), temBoard.getIntBoard(), GameColors.YELLOW);
            }
        }
    }
    public Board getDobraBoardTablica(int bigX, int bigY) {
        Board board = mainBoard.getMainBoardTab()[bigX][bigY];
        return board;
    }
    public void resetMainBoard() {
        for (int i = 2; i>= 0;i--) {
            for (int j = 0; j< 3; j++) {
                resetBorderTileBoard(getDobraBoardTablica(j,i).getTileBoard(),getDobraBoardTablica(j,i).getIntBoard());
            }
        }
    }
    public void resetMainBoardToFalse() {
        for (int i = 2; i>= 0;i--) {
            for (int j = 0; j< 3; j++) {
                setAllFalse(getDobraBoardTablica(j,i).getTileBoard(),getDobraBoardTablica(j,i).getIntBoard());
            }
        }
    }
    public void setAllFalse(Tile[][] tab, int[][]intTab) {
        for (int i = 2; i>= 0;i--) {
            for (int j = 0; j< 3; j++) {
                if(intTab[j][i]==0) {
                    tab[j][i].setActive(false);
                    resetColorBorder(tab[j][i].getButton());
                }
            }
        }
    }
    public void resetBorderTileBoard(Tile[][] tab, int[][]intTab) {
        for (int i = 2; i>= 0;i--) {
            for (int j = 0; j< 3; j++) {
                if(intTab[j][i]==0) {
                    resetColorBorder(tab[j][i].getButton());
                    tab[j][i].setActive(true);
                }
            }
        }
    }


    public void setColorInTileBoarder(Tile[][] tileTab,int[][]intTab, GameColors vale) {
        for (int i = 2; i>= 0;i--) {
            for (int j = 0; j< 3; j++) {
                if(intTab[j][i]==0) {
                    setColorBorder(tileTab[j][i].getButton(), vale);
                    tileTab[j][i].setActive(true);
                }
            }
        }
    }


    public void nextStep(int x, int y){
        setX(this.bigX);
        setY(this.bigY);
        setBigX(x);
        setBigY(y);
        System.out.println("last move (x,y): (" + this.x + "," + this.y + ")");
        System.out.println("next move (x,y): (" + this.bigX + "," + this.bigY + ")");
    }
//TICTACTOE STYLE

//HERE IS MAIN ACTION!IT'S FINE WITH THAT BUT... ARE YOU GONA MOVE!?
    public void move(int x, int y, int bigX, int bigY) {
        switch (player_number) {
            case 1:
                getDobryPrzycisk(x, y, bigX, bigY).setIcon(Const.GRACZ1);
                setButtonPressed(getDobryTile(x, y, bigX, bigY));
                resetColorBorder(getDobryPrzycisk(x, y, bigX, bigY));
//                  int[][] section
                setSmallIntTabCell(x,y,bigX,bigY,player_number);
                printIntTab(getSmallIntTab(bigX,bigY));
                int end1 = state.resultIntTab(getSmallIntTab(bigX,bigY));
                System.out.println("move result: " + end1);
                if (end1!=0) {
                    setTileBord(getGoodTileTab(bigX,bigY),end1);
                    setIntTab(getDobraBoardTablica(bigX,bigY).getIntBoard(),end1);
                    setBigIntTabCell(bigX,bigY,end1);
                    printIntTab(getBigIntTab());
                }
                endGame(end1);
//                NEXT MOVE
                player_number = 2;
                nextStep(x,y);
                TicTacToaStyleMove();
                break;
            case 2:
                getDobryPrzycisk(x, y, bigX, bigY).setIcon(Const.GRACZ2);
                setButtonPressed(getDobryTile(x, y, bigX, bigY));
                resetColorBorder(getDobryPrzycisk(x, y, bigX, bigY));
//                int[][] section
                setSmallIntTabCell(x,y,bigX,bigY,player_number);
                printIntTab(getSmallIntTab(bigX,bigY));
                int end2 = state.resultIntTab(getSmallIntTab(bigX,bigY));
                System.out.println("result: " + end2);
                if (end2!=0) {
                    setTileBord(getGoodTileTab(bigX,bigY),end2);
                    setIntTab(getDobraBoardTablica(bigX,bigY).getIntBoard(),end2);
                    setBigIntTabCell(bigX,bigY,end2);
                    printIntTab(getBigIntTab());
                }
                endGame(end2);
//                NEXT MOVE
                player_number = 1;
                nextStep(x,y);
                TicTacToaStyleMove();
                break;
        }

        System.out.println("gameContorler says: moved");
    }

    //SUPPORT METHODS

    public void setIntTab(int[][] tab, int value) {
        for (int i = 2; i>= 0;i--) {
            for (int j = 0; j < 3; j++) {
                if (tab[j][i] == 0) {
                    tab[j][i]=value;
                }
            }
        }
    }
    public void endGame(int winner){
        if(finalResult()!=0) {
            endGame=true;
            gameResult = finalResult();
            String win;
            if(winner==1) {
                win="X";
            }
            else {
                win="O";
            }
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    EndScreen endScreen = new EndScreen(win);}
            });
        }
    }
    public int finalResult() {
        int result = 0;
        if((state.resultIntTab(getBigIntTab())==1)) {
            result = 1;
        } else if((state.resultIntTab(getBigIntTab())==2)) {
            result = 2;
        } else if((state.resultIntTab(getBigIntTab())==3)) {
            result = 3;
        } else {
            result =0;
        }
        System.out.println("final resault: " + result);
        return result;
    }
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
    int delay = 20;
    Timer timer = new Timer(delay, null);
    timer.addActionListener(new ActionListener() {
        int k = tab.length - 1;
        int l = 0;
        @Override
        public void actionPerformed(ActionEvent e) {
            if (k >= 0) {
                setButtonPressed(tab[l][k]);
                if (player_number == 1) {
                    setColorBorder(tab[l][k].getButton(), GameColors.BLUE);
                    tab[l][k].getButton().setIcon(Const.GRACZ1);
                } else if (player_number == 2) {
                    setColorBorder(tab[l][k].getButton(), GameColors.RED);
                    tab[l][k].getButton().setIcon(Const.GRACZ2);
                } else {
                    setColorBorder(tab[l][k].getButton(), GameColors.GRAY);
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
            timer.setInitialDelay(40);
            timer.start();
        }
    });
//        timer.setInitialDelay(100);
//        timer.start();
}
public void setColorBorder (JButton button, GameColors value) {
    Color borderColor;

    switch (value) {
        case RED:
            borderColor = Color.RED;
            break;
        case BLUE:
            borderColor = Color.BLUE;
            break;
        case GREEN:
            borderColor = Color.GREEN;
            break;
        case GRAY:
            borderColor = Color.GRAY;
            break;
        case YELLOW:
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
//        button.setBorder(BorderFactory.createEtchedBorder());
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

    public boolean isEndGame() {
        return endGame;
    }

    public void setEndGame(boolean endGame) {
        this.endGame = endGame;
    }

    public int getGameResult() {
        return gameResult;
    }

    public void setGameResult(int gameResult) {
        this.gameResult = gameResult;
    }

    public static int getBigX() {
        return bigX;
    }

    public static void setBigX(int bigX) {
        GameControler.bigX = bigX;
    }

    public static int getBigY() {
        return bigY;
    }

    public static void setBigY(int bigY) {
        GameControler.bigY = bigY;
    }

    public static int getX() {
        return x;
    }

    public static void setX(int x) {
        GameControler.x = x;
    }

    public static int getY() {
        return y;
    }

    public static void setY(int y) {
        GameControler.y = y;
    }
}
