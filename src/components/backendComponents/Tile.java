package components.backendComponents;

import javax.swing.*;

public class Tile extends JButton {
    int x;
    int y;
    int bigX;
    int bigY;
    public Tile() {

    }
    public Tile(int x, int y, int bigX, int bigY) {
        this.x = x;
        this.y = y;
        this.bigX = bigX;
        this.bigY = bigY;
    }

    @Override
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    @Override
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
}
