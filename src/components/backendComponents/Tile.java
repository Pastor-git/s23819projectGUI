package components.backendComponents;

import components.eventComponents.GameControler;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Tile implements ActionListener {
    boolean pressed;
    boolean active;
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
        this.active = true;
        button.addActionListener(this);
        button.setBorder(null);
        this.button = button;
        this.x = x;
        this.y = y;
    }

//REAL ACTION CODE
    @Override
    public void actionPerformed(ActionEvent e) {
//        INITIALIZATION CONDIDION
        if(gameControler.isEndGame()==true) {
            System.out.println("gra już zakończona");
        } else if (this.pressed==true) {
            System.out.println("przycisk już został wciśnięty:"+this.x+this.y);
        } else { if(this.active==false) {
            System.out.println("przycisk już jest niekatywny:"+this.x+this.y);
        } else {
//        TEST BLOCK
        this.testTile();
//        GAME BLOCK
//            !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
            this.gameControler.move(this.x, this.y, this.bigX, this.bigY);
            System.out.println("Tile says: moved");
        }
        }
    }
//    END OF ACTION LISTINER

    public void returnGameControlerECHO(GameControler gameControler) {
        gameControler.testPrint(this.x, this.y, this.bigX, this.bigY);
    }
    public void testTile() {
        System.out.println("Tile speaks: "+"x:"+this.x + "y:" + this.y);
        System.out.println("Tile speaks: "+"bigX:"+this.bigX + "bigY:" + this.bigY);
        this.gameControler.testPrint(this.x, this.y, this.bigX, this.bigY);
    }

//BOILERPLATE
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

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
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

}