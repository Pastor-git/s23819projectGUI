package components.gameComponents;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
//enum load/newGame;
    public MainFrame(String action_title) {

        this.getContentPane().setBackground(Color.DARK_GRAY);
        this.setSize(600,600);
        this.setLocation(400,400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        getenum => give enum to Main Panel
        this.add(new MainPanel(action_title));
        this.setVisible(true);

    }

}
