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
        move(currentPlayer,scanner, gameEnded);

        while (!gameEnded) {
            hasWon(currentPlayer);
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
    public static boolean hasWon(char currentPlayer) {
        int count = 0;
        for (int i=0; i<3; i++){
            for (int j=0; j<3; j++){
                if (board[i][j] == currentPlayer){
                    count++;
                    if (count == 3){
                        System.out.println("The winner is " + currentPlayer);
                    }
                }
            }
        }
        return true;
    }

    // Check if the board is full
    public static boolean isDraw(char currentPlayer) {
        int count = 0;
        for (int i=0; i<3; i++){
            for (int j=0; j<3; j++){
                if (board[i][j] == currentPlayer){
                    count++;
                    if (count == 9){
                        System.out.println("It's a draw! ");
                    }
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
            if (row>3 || col>3 && row<0 || col<0){
                System.out.println("Invalid move!");
            }
            board[row][col] = currentPlayer;
            System.out.println("Your move is " + board[row][col]);
            printBoard(board);
            hasWon(currentPlayer);
            isDraw(currentPlayer);
            if(lastMove == 'X'){
                currentPlayer = 'O';
            }
            if (lastMove == 'O'){
                currentPlayer = 'X';
            }
        }
    }

}

