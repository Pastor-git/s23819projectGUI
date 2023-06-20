package main;

import components.MainFrame;
import components.MainPanel;
import java.awt.*;
import java.awt.event.*;
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