package com.techlabs.tictactoe;

import java.util.Scanner;

public class TicTacToeGame {
	
	 	private TicTacToeBoard board;
	    private PlayerType currentPlayer;
	    private boolean gameWon;
	    private int count;

	    public TicTacToeGame() {
	        board = new TicTacToeBoard();
	        currentPlayer = PlayerType.X;
	        gameWon = false;
	        count = 0;
	    }

	    public void playGame() {
	        Scanner scanner = new Scanner(System.in);

	        while (!gameWon && count < 9) {
	            board.printBoard();

	            System.out.println("Player " + currentPlayer + ", enter row (0-2) and column (0-2):");
	            int row = scanner.nextInt();
	            int col = scanner.nextInt();

	            if (board.isValidMove(row, col)) {
	                board.makeMove(row, col, currentPlayer);

	                if (board.checkWin(currentPlayer)) {
	                    board.printBoard();
	                    System.out.println("Player " + currentPlayer + " wins!");
	                    gameWon = true;
	                }

	                currentPlayer = (currentPlayer == PlayerType.X) ? PlayerType.O : PlayerType.X;
	            } else {
	                System.out.println("Invalid move. Try again.");
	            }
	            count++;
	        }

	        if (count == 9 && !gameWon) {
	            System.out.println("Match is draw.");
	        }
	    }
}
