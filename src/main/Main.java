package main;

import components.gameComponents.MainFrame;

import javax.swing.*;


public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {MainFrame mainFrame = new MainFrame();}
        }
        );
    }
}