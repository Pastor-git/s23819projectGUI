package Test;

import components.backendComponents.Board;
import components.gameComponents.BoardPanel;

import javax.swing.*;
import java.awt.*;

public class TestClass {

    public static void main(String[] args) {

        JFrame frame = new JFrame();
        frame.getContentPane().setBackground(Color.DARK_GRAY);
        frame.setSize(600,600);
        frame.setLocation(400,400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        BoardPanel panel = new BoardPanel();
//        Board board = new Board();
//        panel.setBoard(board);
//        panel.buildTileTab(board);
        frame.add(panel);
        frame.setVisible(true);
    }
}
