package components.gameComponents;

import components.eventComponents.GameControler;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    MainPanel mainPanel;
    public MainFrame(String action_title, GameControler gameControler) {

        this.getContentPane().setBackground(Color.DARK_GRAY);
        this.setSize(600,600);
        this.setLocation(800,320);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MainPanel mainPanel = new MainPanel(action_title, gameControler);
        this.add(mainPanel);
        this.setVisible(true);
    }

    public MainPanel getMainPanel() {
        return mainPanel;
    }

    public void setMainPanel(MainPanel mainPanel) {
        this.mainPanel = mainPanel;
    }
}
