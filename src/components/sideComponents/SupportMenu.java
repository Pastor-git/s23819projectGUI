package components.sideComponents;

import components.Const;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SupportMenu extends JFrame{
    private JButton button;
    public SupportMenu() {
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocation(635,770);

        JLabel label = new JLabel("Gratulacje! A kto wygrał grę?");
        getContentPane().add(label);

        button = new JButton();
        button.addActionListener(new SupportMenu.ButtonClickListener());
        button.setText("(nie)Twoja szansa!");
        button.setForeground(Color.BLACK);
        getContentPane().add(button);

//        pack();
        setSize(180, 150);
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
                                String s = Integer.toString(i);
                                button.setText(s);
                            Thread.sleep(50);
                        }
                        button.setEnabled(true);
                        button.setText("");

                            button.setIcon(Const.BASIC2);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
            });
            thread.start();
        }
    }
}
