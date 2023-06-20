package components;

import javax.swing.*;
import java.awt.*;

public class BoardPanel extends JPanel {


    public BoardPanel() {
        this.setSize(400,600);
        this.setBackground(Color.GREEN);
        TestButton zero = new TestButton(0);
        this.add(zero);
        TestButton jeden = new TestButton(1);
        this.add(jeden);
        TestButton dwa = new TestButton(2);
        this.add(dwa);
        this.setVisible(true);
    }

}
