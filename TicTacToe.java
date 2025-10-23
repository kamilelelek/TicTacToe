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

        }

        scanner.close();
    }

    // Print the current board
    public static void printBoard(char[][] board) {
        System.out.println("-------------");
        for (int i=0; i<3; i++){
            System.out.print("| ");
            for (int j=0; j<3; j++){
                System.out.print(board[i][j] +" | ");
            }
            System.out.println();
            System.out.println("-------------");
        }

    }

    // Check if a player has won
    public static boolean hasWon(char player) {
        //jezeli ten sam znak gracza jest 3 pola z zrzedu obok siebie
        //musimy odczytywac pola
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++){

        }
    }








        return true;
    }

    // Check if the board is full
    public static boolean isDraw() {
       return true;
    }
}

