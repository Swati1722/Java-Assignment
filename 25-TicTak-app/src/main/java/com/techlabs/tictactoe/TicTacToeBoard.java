package com.techlabs.tictactoe;

public class TicTacToeBoard {


	private char[][] board;

    public TicTacToeBoard() {
        board = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
       // board[0][0]='X';
    }

    public void printBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j]);
                if (j < 2) {
                    System.out.print(" | ");
                }
            }
            System.out.println();
            if (i < 2) {
                System.out.println("---------");
            }
        }
    }

    public char[][] getBoard() {
        return board;
    }  
    
    public boolean isValidMove(int row, int col) {
        return row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == ' ';
    }

    public void makeMove(int row, int col, PlayerType playerType) {
        board[row][col] = (playerType == PlayerType.X) ? 'X' : 'O';
    }

    public boolean checkHorizontalWin(char symbol) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == symbol && board[i][1] == symbol && board[i][2] == symbol) {
                return true;
            }
        }
        return false;
    }

    public boolean checkVerticalWin(char symbol) {
        for (int i = 0; i < 3; i++) {
            if (board[0][i] == symbol && board[1][i] == symbol && board[2][i] == symbol) {
                return true;
            }
        }
        return false;
    }

    public boolean checkDiagonalWin(char symbol) {
        if (board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol) {
            return true;
        }
        if (board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol) {
            return true;
        }
        return false;
    }

    public boolean checkWin(PlayerType playerType) {
        char symbol = (playerType == PlayerType.X) ? 'X' : 'O';
        
        return checkHorizontalWin(symbol) || checkVerticalWin(symbol) || checkDiagonalWin(symbol);
    }

}
