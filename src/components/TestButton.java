package components;

import javax.swing.*;
import java.awt.*;

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
