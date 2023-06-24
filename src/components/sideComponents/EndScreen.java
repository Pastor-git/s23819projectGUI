package components.sideComponents;

import components.Const;

import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EndScreen extends JFrame {
    private JButton button;
    String winner;
    public EndScreen(String winner) {
        super("Koniec!");
        this.winner=winner;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel label = new JLabel("Gratulacje! A kto wygrał grę?");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setVerticalAlignment(SwingConstants.CENTER);
        getContentPane().add(label);

        button = new JButton();
        button.addActionListener(new ButtonClickListener());
        button.setText("A kto wygrał?");
        button.setForeground(Color.BLACK);
        getContentPane().add(button);

        pack();
        setLocationRelativeTo(null);
        setSize(150, 150);
        setVisible(true);
    }

    private class ButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            button.setEnabled(false);
            button.setFont(new Font(button.getFont().getName(), Font.BOLD, 36));

            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        for (int i = 0; i < 40; i++) {
                            if (i % 2 == 0) {
                                button.setText("X");
                            } else {
                                button.setText("O");
                            }
                            Thread.sleep(50);
                        }
                        button.setEnabled(true);
                        button.setText("");
                        if (winner.equals("X")) {
                            button.setIcon(Const.GRACZ1);
                        } else {
                            button.setIcon(Const.GRACZ2);
                        }

                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
            });

            thread.start();
        }

    }

}
