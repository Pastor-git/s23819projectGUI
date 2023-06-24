package components.sideComponents;

import components.backendComponents.MainBoard;
import components.eventComponents.GameControler;
import components.eventComponents.State;
import components.gameComponents.MainFrame;
import enums.MenuButtonPressed;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WelcomeMenu extends JFrame implements ActionListener {
    GameControler gameControler;
    public WelcomeMenu(String label) {
//      PARAMETERS
        this.getContentPane().setBackground(Color.DARK_GRAY);
        this.setSize(80,260);
        this.setLocation(680,320);
        this.setLayout(new GridLayout(5, 1));
//        BUTTONS
        JButton start = new JButton(MenuButtonPressed.START.name());
        start.setFocusPainted(false);
        start.addActionListener(this);
        JButton load = new JButton(MenuButtonPressed.LOAD.name());
        load.setFocusPainted(false);
        load.addActionListener(this);
        JButton test = new JButton(MenuButtonPressed.TEST.name());
        test.setFocusPainted(false);
        test.addActionListener(this);
        JButton save = new JButton(MenuButtonPressed.SAVE.name());
        save.setFocusPainted(false);
        save.addActionListener(this);
        JButton close = new JButton(MenuButtonPressed.CLOSE.name());
        close.setFocusPainted(false);
        close.addActionListener(this);
//        BUILD-UP
        this.add(start);
        this.add(load);
        this.add(test);
        this.add(save);
        this.add(close);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
//        GAME CONTROL
        GameControler gameControler = new GameControler(new State(label),new MainBoard());
        this.gameControler = gameControler;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton clickedButton = (JButton) e.getSource();
        String action_title = clickedButton.getText();
        System.out.println("Menu speaks: "+ action_title);
        switch (action_title) {
            case "START":
                this.startGame(action_title);
                break;
            case "LOAD":
                this.loadGame(action_title);
                break;
            case "TEST":
                this.testGame(action_title);
                break;
            case "SAVE":
                this.saveGame(action_title);
                break;
            case "CLOSE":
                this.closeGame(action_title);
                break;
            default:
                System.out.println("Menu nie działa poprawnie");
        }

    }
    public void startGame(String action_title) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                MainFrame mainFrame = new MainFrame(action_title, gameControler);}
        });
    }

    public void loadGame(String action_title){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                MainFrame mainFrame = new MainFrame(action_title, gameControler);}
        });
    }

    public void testGame(String action_title){

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                MainFrame mainFrame = new MainFrame(action_title,gameControler);
                }
        });
    }
    public void saveGame(String action_title){
        System.out.println("SAVE game clicked" + " player start: " + gameControler.getPlayer_number());
    }
    public void closeGame(String action_title){

        System.out.println("CLOSE game clicked");
    }

}
