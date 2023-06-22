package main;

import components.gameComponents.MainFrame;
import components.sideComponents.WelcomeMenu;

import javax.swing.*;


public class Main {
    public static void main(String[] args) {
        String label = "label";
        System.out.println("Hello world!");
//        ZMIENNA STRING NAZWA GARCZA KTÓRY WYGRAŁ
//        OKNO POWITALNE:
//        1: MAIN FRAME Z ARGUMENTEM STARTGAME
//        2: MAIN FRAME Z ARGUMENTEM LOADGAME
//        nuem NAZYW PRZYCISKÓW MENU przekazuje nazwę przyciusku do
//        Main Frame => Main Panel który wybiera metodę budowy tablicy int => LOADGAME lub SAVEGMAE

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                WelcomeMenu welcomeMenu = new WelcomeMenu(label);
//                MainFrame mainFrame = new MainFrame(label);
            }
        }
        );
        System.out.println("jestem Main: " + label);
//        OKNO POBIERAJĄCE GRACZA WYCIEZCE
    }
}