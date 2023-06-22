package components.backendComponents;

import javax.swing.*;

public class Tile {
    boolean pressed;
    JButton button;
    int x;
    int y;
    int bigX;
    int bigY;
    public Tile() {
        super();
    }

    public Tile(JButton button, int x, int y) {
        this.pressed = false;
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
}
