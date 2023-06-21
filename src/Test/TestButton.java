package Test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.JOptionPane.showMessageDialog;

public class TestButton extends JButton {

    int number;


    public TestButton(int number) {
        this.number = number;
        String s = String.valueOf(this.number);
        this.setText(s);
        this.setForeground(Color.WHITE);
        this.setBackground(Color.BLACK);
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }


}
