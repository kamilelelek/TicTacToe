package org.example.lesson9;

import java.util.Scanner;

public class TicTacToe {


    /*
    -------------
    |   |   |   |
    -------------
    |   |   |   |
    -------------
    |   |   |   |
    -------------
     */

    // Przerobić diagram sekwencyjny z draw.io na Mermaid

    static char[][] board = {
            {' ', ' ', ' '},
            {' ', ' ', ' '},
            {' ', ' ', ' '}
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char currentPlayer = 'X';
        boolean gameEnded = false;

        System.out.println("=== TIC TAC TOE ===");
        printBoard(board);


        while (!gameEnded) {
            int row = scanner.nextInt();
            int col = scanner.nextInt();

            // waliadacja czy w zakresie
            if (row > 3 || col > 3 && row < 0 || col < 0) {
                System.out.println("Invalid move!");
                continue;
            }
            if (board[row][col] != ' ') {
                System.out.println("Invalid move!");
            }
            // waliadacja czy nie jest zajęte


            board[row][col] = currentPlayer;
            printBoard(board);

            if (hasWon(currentPlayer)){
                gameEnded = true;
                System.out.println("Congratulations!");
            } else {
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            }
            // move(currentPlayer, scanner, gameEnded);
            if (isDraw(currentPlayer)){
                gameEnded = true;
                System.out.println("draw");
            }

        }

        scanner.close();
    }

    // Print the current board
    public static void printBoard(char[][] board) {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }

    }

    // Check if a player has won
    public static boolean hasWon(char currentPlayer) {

        // 1 któryś z rzędów ma taki sam znak w 3 polach
        // 2 któraś z kulm ma taki sam znak w 3 polach
        for (int i = 0; i < 3; i++) {
            if ((board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer) || (board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer)
            ) {
                return true;
            }
        }
        // 3 któraś z 2 przekątnych ma taki sam znak w 3 polach
        if ((board[0][2]== currentPlayer && board[1][1]== currentPlayer && board[2][0]== currentPlayer)||(board[0][0]== currentPlayer && board[1][1]== currentPlayer && board[2][2]== currentPlayer)){
            return true;
        }
        return false;
    }

    // Check if the board is full
    public static boolean isDraw(char currentPlayer) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    //move
    public static boolean move(char currentPlayer, Scanner scanner, boolean gameEnded) {
        while (true) {
            char lastMove = currentPlayer;
            System.out.println(currentPlayer + " Your move!");
            int row = scanner.nextInt();
            int col = scanner.nextInt();
            if (row > 3 || col > 3 && row < 0 || col < 0) {
                System.out.println("Invalid move!");
            }
            board[row][col] = currentPlayer;
            System.out.println("Your move is " + board[row][col]);
            printBoard(board);
            hasWon(currentPlayer);
            isDraw(currentPlayer);
            if (lastMove == 'X') {
                currentPlayer = 'O';
            }
            if (lastMove == 'O') {
                currentPlayer = 'X';
            }
        }
    }

}

