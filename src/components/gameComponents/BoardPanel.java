package components.gameComponents;

import components.eventComponents.Board;
import components.gameComponents.TestButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BoardPanel extends JPanel implements ActionListener {
//    Board board;
    public BoardPanel() {
        this.setSize(400,600);
        this.setBackground(Color.GREEN);
        TestButton zero = new TestButton(0);
        zero.addActionListener(this);
        this.add(zero);
        TestButton jeden = new TestButton(1);
        jeden.addActionListener(this);
        this.add(jeden);
        TestButton dwa = new TestButton(2);
        dwa.addActionListener(this);
        this.add(dwa);
        this.setVisible(true);
        ///////////////////
//        this.board = board;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("clicked");
    }
}
