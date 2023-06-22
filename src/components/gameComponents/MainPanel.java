package components.gameComponents;

import components.backendComponents.Board;
import components.backendComponents.MainBoard;
import components.eventComponents.GameControler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPanel extends JPanel implements ActionListener {
//    TU SIE DZIEJE MAGIA - KOSTRUKTR gameControler BĘDIZA MIAŁWSTRZYKNIĄTEĄ mainBoard z MainPanel
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
        mainBoard.setMainBoardTab(mainBoardTab);
//        BUILD-UP
        for(int i = 0; i < 3; i++) {
           for(int j = 0; j < 3; j++) {
               BoardPanel panel = new BoardPanel();
               mainBoard.getMainBoardTab()[i][j] = panel.getBoard();
               this.add(panel);
           }
        }
//        end of loop
       for(int i = 0; i < 3; i++) {
           for (int j = 0; j < 3; j++) {
//               System.out.println(this.getMainBoard()[i][j]);
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


    public MainBoard getMainBoard() {
        return mainBoard;
    }

    public void setMainBoard(MainBoard mainBoard) {
        this.mainBoard = mainBoard;
    }

    public GameControler getGameControler() {
        return gameControler;
    }

    public void setGameControler(GameControler gameControler) {
        this.gameControler = gameControler;
    }

//    public void bulidMainBoardTab(MainBoard mainBoard) {
//       this.mainBoard = mainBoard;
//
//   }

   public void buildMainIntBoard(MainBoard mainBoard){
       this.mainBoard = mainBoard;
       int[][] tab = new int[3][3];
       for (int[] element : tab) {
           for (int k = 0; k < element.length; k++) {
               element[k] = 1;
           }
       }
       mainBoard.setMainIntBoard(tab);

   }
}
