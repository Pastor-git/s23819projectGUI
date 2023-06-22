package components.gameComponents;

import components.backendComponents.Board;
import components.backendComponents.MainBoard;
import components.backendComponents.Tile;
import components.eventComponents.GameControler;
import components.gameComponents.BoardPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPanel extends JPanel implements ActionListener {
    MainBoard mainBoard;
    GameControler gameControler;
   public MainPanel() {
//        BUILD-UP
        this.setSize(400,800);
        this.setBackground(Color.CYAN);
        this.setLayout(new GridLayout(3, 3));

//        BOARD IMPLEMENTATION
        this.mainBoard = new MainBoard();
        Board[][] mainBoardTab = new Board[3][3];
        mainBoard.setMainBoard(mainBoardTab);
//        BUILD-UP
        for(int i = 0; i < 3; i++) {
           for(int j = 0; j < 3; j++) {
               BoardPanel panel = new BoardPanel();
//               Board board = new Board();
//               panel.setBoard(board);
               // INTTAB
//               panel.buildIntTab(board);
               // TILES
//               panel.buildTileTab(board);
//               ACTION LISTENER
               for (int k = 0; k < panel.getBoard().getTileBoard().length; k++) {
                   for (int l = 0; l < panel.getBoard().getTileBoard().length; l++) {
                       panel.getBoard().getTileBoard()[k][l].getButton().addActionListener(this);
                   }
               }
               this.add(panel);
           }
        }
//        end of loop
       this.setVisible(true);
    }
//    END OF CONTRUCTOR
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("clicked");
    }
}
