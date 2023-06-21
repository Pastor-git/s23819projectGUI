package components.gameComponents;

import Test.TestButton;
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
        Tile[][] tab = new Tile[3][3];
        for (int k = 0; k < tab.length; k++) {
            for (int l = 0; l < tab[k].length; l++) {
                Tile tile = new Tile();
                tile.setText("1");
                tile.setBackground(Color.BLACK);
                tab[k][l] = tile;
                tile.setVisible(true);
                this.add(tile);
            }
        }
        board.setTileBoard(tab);
    }
    public void buildIntTab(Board board) {
        this.board = board;
        int[][] tab = new int[3][3];
        for (int[] element : tab) {
            for (int k = 0; k < element.length; k++) {
                element[k] = 1;
            }
        }
        board.setIntBoard(tab);
    }

}
