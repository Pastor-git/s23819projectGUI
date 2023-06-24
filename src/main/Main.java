package main;

import components.gameComponents.MainFrame;
import components.sideComponents.WelcomeMenu;

import javax.swing.*;
import java.io.IOException;


public class Main {
    public static void main(String[] args) {
        String label = "basicState";

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    WelcomeMenu welcomeMenu = new WelcomeMenu(label);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        );
        System.out.println("jestem Main: " + label);
    }
}