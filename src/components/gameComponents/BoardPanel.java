package components.gameComponents;

import Test.TestButton;
import components.Const;
import components.backendComponents.Board;
import components.backendComponents.Tile;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BoardPanel extends JPanel{
    Board board;
    public BoardPanel() {
//        BUILD-UP
        this.setVisible(true);
        this.setSize(400,600);
        this.setBackground(Color.GREEN);
        this.setLayout(new GridLayout(3, 3));
        setBoard(new Board());
//        INTY ZAWSZE PIERWSZE
        this.buildIntTab(this.board);
//        OBIEKTY ZAWSZE DRUGIE
        this.buildTileTab(this.board);
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }
//    BUILD-UP
    public void buildTileTab(Board board) {
        this.board = board;
//        INICJALIZACJA TABLICY TILE
        Tile[][] tab = new Tile[3][3];
        for (int k = tab.length-1; k >= 0; k--) {
            for (int l = 0; l < tab[k].length; l++) {
//                POPRAWNE WSPÓŁRZĘDNE X I Y DLA CZŁOWIEKA k->l
                Tile tile = new Tile(new JButton(),l,k);
//                tile.getButton().setText("1");
                tile.getButton().setBackground(Color.BLACK);
//                TUTAJ DODAĆ INSTRUKCJĘ UZALEŻNIAJACĄ POCZĄTKOWEY RODZAJ POLA ID TABLICY INTÓW
                tile.getButton().setIcon(Const.BASIC);
//                POPRAWNE WSPÓŁRZĘDNE X I Y DLA CZŁOWIEKA k->l
                tab[l][k] = tile;
                tile.getButton().setVisible(true);
                this.add(tile.getButton());
            }
        }
//        WSTAWIENIE TABLICY TILE
        board.setTileBoard(tab);
    }

//    DOCELOWO DRUGI ARGUMENT TO ENUM LOAD/SAVE
    public void buildIntTab(Board board) {
        this.board = board;
        int[][] tab = new int[3][3];
        for (int[] element : tab) {
            for (int k = 0; k < element.length; k++) {
                element[k] = 0;
            }
        }
        board.setIntBoard(tab);
    }

}
