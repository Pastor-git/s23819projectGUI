package components.gameComponents;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    public MainFrame() {

        this.getContentPane().setBackground(Color.DARK_GRAY);
        this.setSize(600,600);
        this.setLocation(400,400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        this.setLayout(new GridLayout(2, 6));
        this.add(new MainPanel());
        this.setVisible(true);

    }

}
