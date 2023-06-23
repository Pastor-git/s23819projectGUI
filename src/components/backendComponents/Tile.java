package components.backendComponents;

import components.Const;
import components.eventComponents.GameControler;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLOutput;

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
        this.button = button;
        this.x = x;
        this.y = y;
    }

//REAL ACTION CODE
    @Override
    public void actionPerformed(ActionEvent e) {
//        INITIALIZATION CONDIDION
        if (this.pressed==true) {
            System.out.println("przycisk już został wciśnięty:"+this.x+this.y);
        } else { if(this.active==false) {
            System.out.println("przycisk już jest niekatywny:"+this.x+this.y);
        } else {
            //        TEST BLOCK
            System.out.println("Tile speaks: "+"x:"+this.x + "y:" + this.y);
            System.out.println("Tile speaks: "+"bigX:"+this.bigX + "bigY:" + this.bigY);
            this.gameControler.testPrint(this.x, this.y, this.bigX, this.bigY);
//        GAME BLOCK
//            !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
            this.gameControler.move(this.x, this.y, this.bigX, this.bigY);
            this.getButton().setIcon(Const.BASIC2);
//            MACHANIZM KOLOROWANIA RAMKI PRZYCISKU
            Color borderColor = Color.RED;
            int borderWidth = 5;
            Border lineBorder = BorderFactory.createLineBorder(borderColor, borderWidth);
            this.getButton().setBorder(lineBorder);
        }
        }
    }
//    END OF ACTION LISTINER

    public void returnGameControler(GameControler gameControler) {
        gameControler.testPrint(this.x, this.y, this.bigX, this.bigY);
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