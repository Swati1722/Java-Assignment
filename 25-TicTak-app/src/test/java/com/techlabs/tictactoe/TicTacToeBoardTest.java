package com.techlabs.tictactoe;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TicTacToeBoardTest {
	
	TicTacToeBoard ticTacToeBoard;
	
	@BeforeEach
	void init()
	{
		ticTacToeBoard = new TicTacToeBoard();
	}

	@Test
	void testIsValidMove() {
		ticTacToeBoard.makeMove(0, 0,PlayerType.O);
	    ticTacToeBoard.makeMove(1, 1, PlayerType.O);
		assertFalse(ticTacToeBoard.isValidMove(0, 0));
        assertFalse(ticTacToeBoard.isValidMove(1, 1));
		assertFalse(ticTacToeBoard.isValidMove(3, 2)); 
		
	}

	@Test
	void testMakeMove() {
		ticTacToeBoard.makeMove(0, 0, PlayerType.X);
		char[][] boardState = ticTacToeBoard.getBoard();
		assertEquals('X', boardState[0][0]);
	}

	@Test
	void testCheckHorizontalWin() {
		 ticTacToeBoard.makeMove(0, 0, PlayerType.X);
	     ticTacToeBoard.makeMove(0, 1, PlayerType.X);
	     ticTacToeBoard.makeMove(0, 2, PlayerType.X);

	     assertTrue(ticTacToeBoard.checkHorizontalWin('X'));
	     assertFalse(ticTacToeBoard.checkHorizontalWin('O'));
	}

	@Test
	void testCheckVerticalWin() {
		 ticTacToeBoard.makeMove(0, 0, PlayerType.X);
	     ticTacToeBoard.makeMove(1, 0, PlayerType.X);
	     ticTacToeBoard.makeMove(2, 0, PlayerType.X);

	     assertTrue(ticTacToeBoard.checkVerticalWin('X'));
	     assertFalse(ticTacToeBoard.checkVerticalWin('O'));
	}

	@Test
	void testCheckDiagonalWin() {
		ticTacToeBoard.makeMove(0, 0, PlayerType.X);
	    ticTacToeBoard.makeMove(1, 1, PlayerType.X);
	    ticTacToeBoard.makeMove(2, 2, PlayerType.X);

	    assertTrue(ticTacToeBoard.checkDiagonalWin('X'));
	    assertFalse(ticTacToeBoard.checkDiagonalWin('O'));
	    
	    
	    ticTacToeBoard.makeMove(0, 2, PlayerType.X);
	    ticTacToeBoard.makeMove(1, 1, PlayerType.X);
	    ticTacToeBoard.makeMove(2, 0, PlayerType.X);

	    assertTrue(ticTacToeBoard.checkDiagonalWin('X'));
	    assertFalse(ticTacToeBoard.checkDiagonalWin('O'));
	}

	@Test
	void testCheckWin() {
		ticTacToeBoard = new TicTacToeBoard(); 
        ticTacToeBoard.makeMove(0, 0,PlayerType.O);
        ticTacToeBoard.makeMove(1, 0, PlayerType.O);
        ticTacToeBoard.makeMove(2, 0, PlayerType.O);
        assertTrue(ticTacToeBoard.checkWin(PlayerType.O));
	}

}
