package org.example.lesson9;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class GUI {


    public static class TicTacToeGUI extends JFrame {
        private final JButton[][] buttons = new JButton[3][3];
        private char currentPlayer = 'X';
        private boolean gameEnded = false;

        public TicTacToeGUI() {
            setTitle("Tic Tac Toe");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setSize(380, 420);
            setLocationRelativeTo(null);
            setLayout(new BorderLayout());

            JLabel status = new JLabel("Player X turn", SwingConstants.CENTER);
            status.setFont(status.getFont().deriveFont(Font.BOLD, 18f));
            add(status, BorderLayout.NORTH);

            JPanel grid = new JPanel(new GridLayout(3, 3));
            Font f = new Font("Arial", Font.BOLD, 64);

            for (int r = 0; r < 3; r++) {
                for (int c = 0; c < 3; c++) {
                    JButton b = new JButton("");
                    b.setFont(f);
                    b.setFocusPainted(false);
                    final int row = r, col = c;
                    b.addActionListener((ActionEvent e) -> {
                        if (gameEnded || !b.getText().isEmpty()) return;

                        b.setText(String.valueOf(currentPlayer));
                        if (hasWon(currentPlayer)) {
                            status.setText("Player " + currentPlayer + " wins!");
                            gameEnded = true;
                            lockBoard();
                        } else if (isDraw()) {
                            status.setText("Draw!");
                            gameEnded = true;
                        } else {
                            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
                            status.setText("Player " + currentPlayer + " turn");
                        }
                    });
                    buttons[r][c] = b;
                    grid.add(b);
                }
            }

            add(grid, BorderLayout.CENTER);

            JButton reset = new JButton("Reset");
            reset.addActionListener(e -> resetGame(status));
            JPanel south = new JPanel(new FlowLayout(FlowLayout.CENTER));
            south.add(reset);
            add(south, BorderLayout.SOUTH);
        }

        private void resetGame(JLabel status) {
            for (JButton[] row : buttons) {
                for (JButton b : row) {
                    b.setText("");
                    b.setEnabled(true);
                }
            }
            currentPlayer = 'X';
            gameEnded = false;
            status.setText("Player X turn");
        }

        private void lockBoard() {
            for (JButton[] row : buttons)
                for (JButton b : row)
                    b.setEnabled(false);
        }

        private boolean isDraw() {
            for (JButton[] row : buttons)
                for (JButton b : row)
                    if (b.getText().isEmpty()) return false;
            return true;
        }

        private boolean hasWon(char p) {
            String s = String.valueOf(p);
            // rows
            for (int r = 0; r < 3; r++) {
                if (buttons[r][0].getText().equals(s) &&
                        buttons[r][1].getText().equals(s) &&
                        buttons[r][2].getText().equals(s)) return true;
            }
            // cols
            for (int c = 0; c < 3; c++) {
                if (buttons[0][c].getText().equals(s) &&
                        buttons[1][c].getText().equals(s) &&
                        buttons[2][c].getText().equals(s)) return true;
            }
            // diagonals
            return (buttons[0][0].getText().equals(s) &&
                    buttons[1][1].getText().equals(s) &&
                    buttons[2][2].getText().equals(s)) ||
                    (buttons[0][2].getText().equals(s) &&
                            buttons[1][1].getText().equals(s) &&
                            buttons[2][0].getText().equals(s));
        }

        public static void main(String[] args) {
            SwingUtilities.invokeLater(() -> new TicTacToeGUI().setVisible(true));
        }
    }

}
