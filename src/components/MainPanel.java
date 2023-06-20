package components;

import javax.accessibility.Accessible;
import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {

   public MainPanel()
    {
        this.setSize(400,800);
        this.setBackground(Color.CYAN);
        this.setVisible(true);
        BoardPanel panel1 = new BoardPanel();
        panel1.setBackground(Color.GREEN);
        this.add(panel1);
        BoardPanel panel2 = new BoardPanel();
        panel2.setBackground(Color.RED);
        this.add(panel2);
        BoardPanel panel3 = new BoardPanel();
        panel3.setBackground(Color.BLUE);
        this.add(panel3);
    }

}
