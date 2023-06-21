package components.gameComponents;

import Test.TestButton;
import components.backendComponents.Board;
import components.backendComponents.Tile;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BoardPanel extends JPanel implements ActionListener {
    Board board;
    public BoardPanel() {
//        BOARD IMPLEMENTATION
        this.board = new Board();
        int[][] tab = new int[3][3];
//        for(int i = 0; i < 3; i++) {
//           for(inr j = 0; j < 3; j++) {
//
//           }
//        }
        for(int[] element : tab){
            for(int i : element) {
                i = 1;
            }
        }
        board.setIntBoard(tab);
        Tile[][]tab2 = new Tile[3][3];

        for(Tile[] element : tab2){
            for(Tile tile : element) {
                tile = new Tile();
                tile.setText("1");
                tile.addActionListener(this);
                tile.setBackground(Color.BLACK);
                this.add(tile);
            }
        }
        board.setTileBoard(tab2);
//        PANEL BUILDU-UP
        this.setSize(400,600);
        this.setBackground(Color.GREEN);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("clicked");
    }
}
