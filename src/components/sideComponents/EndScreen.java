package components.sideComponents;

import javax.swing.*;

public class EndScreen extends JFrame {
    public EndScreen() {
        super("Koniec gry");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel label = new JLabel("Gratulacje! Wygrałeś grę!");
//        label.setHorizontalAlignment(SwingConstants.CENTER);
//        label.setVerticalAlignment(SwingConstants.CENTER);

        getContentPane().add(label);
        pack();
        setLocationRelativeTo(null);
        setSize(200, 100);
        setVisible(true);
    }
}
