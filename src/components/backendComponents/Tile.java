package components.backendComponents;

import components.eventComponents.GameControler;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLOutput;

public class Tile implements ActionListener {
    boolean pressed;
    JButton button;
    int x;
    int y;
    int bigX;
    int bigY;

    GameControler gameControler;
    public Tile() {
        super();
    }

    public Tile(JButton button, int x, int y) {
        this.pressed = false;
        button.addActionListener(this);
        this.button = button;
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }


    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getBigX() {
        return bigX;
    }

    public void setBigX(int bigX) {
        this.bigX = bigX;
    }

    public int getBigY() {
        return bigY;
    }

    public void setBigY(int bigY) {
        this.bigY = bigY;
    }

    public boolean isPressed() {
        return pressed;
    }

    public void setPressed(boolean pressed) {
        this.pressed = pressed;
    }

    public JButton getButton() {
        return button;
    }

    public void setButton(JButton button) {
        this.button = button;
    }

    public GameControler getGameControler() {
        return gameControler;
    }

    public void setGameControler(GameControler gameControler) {
        this.gameControler = gameControler;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("x:"+this.x + "y:" + this.y);
        System.out.println("bigX:"+this.bigX + "bigY:" + this.bigY);
        this.gameControler.testPrint(this.x, this.y, this.bigX, this.bigY);
    }
    public void returnGameControler(GameControler gameControler) {
        gameControler.testPrint(this.x, this.y, this.bigX, this.bigY);
    }
}
