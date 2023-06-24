package main;

import components.gameComponents.MainFrame;
import components.sideComponents.WelcomeMenu;

import javax.swing.*;


public class Main {
    public static void main(String[] args) {
        String label = "basicState";

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                WelcomeMenu welcomeMenu = new WelcomeMenu(label);
            }
        }
        );
        System.out.println("jestem Main: " + label);
//        OKNO POBIERAJĄCE GRACZA WYCIEZCE
    }
}