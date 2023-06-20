package Test;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TESTgameMain extends JFrame {
    private static final int SIZE = 3;
    private static final char EMPTY = ' ';
    private static final char PLAYER_X = 'X';
    private static final char PLAYER_O = 'O';

    private JButton[][] buttons;
    private char[][] board;
    private char currentPlayer;

    public TESTgameMain() {
        setTitle("Kółko i krzyżyk");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);
        setLayout(new GridLayout(SIZE, SIZE));

        buttons = new JButton[SIZE][SIZE];
        board = new char[SIZE][SIZE];
        currentPlayer = PLAYER_X;

        initializeBoard();
        initializeButtons();

        setVisible(true);
    }

    private void initializeBoard() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = EMPTY;
            }
        }
    }

    private void initializeButtons() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                JButton button = new JButton();
                button.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 60));
                button.addActionListener(new ButtonClickListener(i, j));
                buttons[i][j] = button;
                add(button);
            }
        }
    }

    private class ButtonClickListener implements ActionListener {
        private int row;
        private int col;

        public ButtonClickListener(int row, int col) {
            this.row = row;
            this.col = col;
        }

        public void actionPerformed(ActionEvent e) {
            JButton button = (JButton) e.getSource();
            button.setEnabled(false);
            button.setText(String.valueOf(currentPlayer));
            button.setForeground(currentPlayer == PLAYER_X ? Color.RED : Color.BLUE);

            board[row][col] = currentPlayer;

            if (isWinner(row, col)) {
                JOptionPane.showMessageDialog(TESTgameMain.this, "Gracz " + currentPlayer + " wygrał!");
                resetGame();
            } else if (isBoardFull()) {
                JOptionPane.showMessageDialog(TESTgameMain.this, "Remis!");
                resetGame();
            } else {
                currentPlayer = (currentPlayer == PLAYER_X) ? PLAYER_O : PLAYER_X;
            }
        }
    }
    private boolean isWinner(int lastRow, int lastCol) {


        // PION
        boolean colWin = true;
        for (int i = 0; i < SIZE; i++) {
            if (board[i][lastCol] != currentPlayer) {
                colWin = false;
                break;
            }
        }
        // POZIOM
        boolean rowWin = true;
        for (int i = 0; i < SIZE; i++) {
            if (board[lastRow][i] != currentPlayer) {
                rowWin = false;
                break;
            }
        }


        // DIAGONAL
        boolean diagonalWin = true;
        boolean antiDiagonalWin = true;
        for (int i = 0; i < SIZE; i++) {
            if (board[i][i] != currentPlayer) {
                diagonalWin = false;
            }
            if (board[i][SIZE - i - 1] != currentPlayer) {
                antiDiagonalWin = false;
            }
        }

        return rowWin || colWin || diagonalWin || antiDiagonalWin;
    }

    private boolean isBoardFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j] == EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    private void resetGame() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                buttons[i][j].setEnabled(true);
                buttons[i][j].setText("");
            }
        }
        initializeBoard();
        currentPlayer = PLAYER_X;
    }
//    >>>>>>>>>>>>>>>>>>MAIN<<<<<<<<<<<<<<<<<<
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Thread(new GameThread()).start();
            }
        });
    }

    private static class GameThread implements Runnable {
        public void run() {
            new TESTgameMain();
        }
    }
}