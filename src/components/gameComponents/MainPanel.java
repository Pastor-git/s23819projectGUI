package components.gameComponents;

import components.backendComponents.Board;
import components.backendComponents.MainBoard;
import components.eventComponents.GameControler;
import components.eventComponents.State;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPanel extends JPanel implements ActionListener {
//    TU SIE DZIEJE MAGIA: KOSTRUKTR gameControler BĘDIZA MIAŁ WSTRZYKNIĄTEĄ mainBoard z MainPanel
    MainBoard mainBoard;
    GameControler gameControler;
   public MainPanel(String label, GameControler gameControler) {
//        BUILD-UP
        this.setSize(400,800);
        this.setBackground(Color.CYAN);
        this.setLayout(new GridLayout(3, 3));
//        BOARD IMPLEMENTATION
        this.mainBoard = new MainBoard();
        Board[][] mainBoardTab = new Board[3][3];
        mainBoard.setMainBoardTab(mainBoardTab);
//        BORD OF THE BORDS
       this.buildMainIntBoard(this.mainBoard);
//        BUILD-UP
       this.setVisible(true);
       this.gameControler = gameControler;
       gameControler.setMainBoard(mainBoard);
       gameControler.setState(new State(label));
//       trzeba znaleźć dobre miejsce na state.gameLunch()
//         this.gameControler = new GameControler(new State(label), this.mainBoard);
        for(int i = 3-1; i >=0 ; i--) {
           for(int j = 0; j < 3; j++) {
               BoardPanel panel = new BoardPanel();
//                POPRAWNE WSPÓŁRZĘDNE X I Y DLA CZŁOWIEKA i->j
               mainBoard.getMainBoardTab()[j][i] = panel.getBoard();


//          ACTIONLISTENER GAMECONTORLER ADITION
               for (int k = panel.getBoard().getTileBoard().length-1; k >=0 ; k--) {
                   for (int l = 0; l < panel.getBoard().getTileBoard().length; l++) {
//                 TU SIE DZIEJE MAGIA: PODBPINAMY KOMUNIKACJE MIEDZY GRACZEM A GAMECOTROLER
                       panel.getBoard().getTileBoard()[l][k].setGameControler(this.gameControler);
//               bigX and bigY
//                POPRAWNE WSPÓŁRZĘDNE X I Y DLA CZŁOWIEKA i->j i k->l
                       panel.getBoard().getTileBoard()[l][k].setBigX(j);
                       panel.getBoard().getTileBoard()[l][k].setBigY(i);
                   }
               }
               this.add(panel);
           }
        }
//        end of loop

       System.out.println("MainPanel speaks: " + label);
       gameControler.stateGameLoad();
    }
//    END OF CONTRUCTOR

//    JAKAŚ ANIMACJA???
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("clicked");
    }
//    public void bulidMainBoardTab(MainBoard mainBoard) {
//       this.mainBoard = mainBoard;
//
//   }

    //    DOCELOWO DRUGI ARGUMENT TO ENUM LOAD/SAVE
    public void buildMainIntBoard(MainBoard mainBoard){
        this.mainBoard = mainBoard;
        int[][] tab = new int[3][3];
        for (int[] element : tab) {
            for (int k = 0; k < element.length; k++) {
                element[k] = 0;
            }
        }
        mainBoard.setMainIntBoard(tab);

    }

//    BOILERPLATE CODE
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


}
