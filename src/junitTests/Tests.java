package junitTests;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Point;

import org.junit.jupiter.api.Test;

import interfaces.IGame;
import model.Game;
import players.TestPlayer;

class Tests {

	@Test
	void testBasicBoardFunctionality() {
		// checks board is created and all cells blank and all moves are available
		TestPlayer p1 = new TestPlayer();
		TestPlayer p2 = new TestPlayer();

		IGame game = new Game(p1, p2);
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {

				assert game.getBoard()[i][j].getState() == -1;

				Point p = new Point(i, j);
				assert (game.getAvailableMoves().contains(p));
			}

		}
		assert (game.getAvailableMoves().size() == 9);
		assert (game.getWinner() == null);

		game.playMove(p1, new Point(-1, 0));
		game.playMove(p1, new Point(0, -1));
		game.playMove(p1, new Point(-1, 0));
		game.playMove(p1, new Point(4, 0));
		game.playMove(p1, new Point(0, 4));

		// tests that the board is not affected by impossible moves
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {

				assert game.getBoard()[i][j].getState() == -1;

				Point p = new Point(i, j);
				assert (game.getAvailableMoves().contains(p));
			}

		}
		assert (game.getAvailableMoves().size() == 9);

		// tests creating a valid move
		game.playMove(p1, new Point(0, 0));
		assert (game.getAvailableMoves().size() == 8);
		assert game.getBoard()[0][0].getState() == 0;

		// tests that the 2nd player cannot play onto the first player's move
		assertFalse(game.getAvailableMoves().contains(new Point(0, 0)));
		game.playMove(p2, new Point(0, 0));
		assert (game.getAvailableMoves().size() == 8);
		assert game.getBoard()[0][0].getState() == 0;
		assert game.getBoard()[0][1].getState() == -1;
		assert game.getBoard()[0][2].getState() == -1;
		assert game.getBoard()[1][0].getState() == -1;
		assert game.getBoard()[2][0].getState() == -1;
		assert game.getBoard()[1][1].getState() == -1;
		assert game.getBoard()[1][2].getState() == -1;
		assert game.getBoard()[2][1].getState() == -1;
		assert game.getBoard()[2][2].getState() == -1;

		// tests finishing out the game with a draw
		game.playMove(p2, new Point(1, 0));
		assert (game.getAvailableMoves().size() == 7);
		assert game.getBoard()[0][0].getState() == 0;
		assert game.getBoard()[0][1].getState() == -1;
		assert game.getBoard()[0][2].getState() == -1;
		assert game.getBoard()[1][0].getState() == 1;
		assert game.getBoard()[2][0].getState() == -1;
		assert game.getBoard()[1][1].getState() == -1;
		assert game.getBoard()[1][2].getState() == -1;
		assert game.getBoard()[2][1].getState() == -1;
		assert game.getBoard()[2][2].getState() == -1;

		game.playMove(p1, new Point(2, 0));
		assert (game.getAvailableMoves().size() == 6);
		assert game.getBoard()[0][0].getState() == 0;
		assert game.getBoard()[0][1].getState() == -1;
		assert game.getBoard()[0][2].getState() == -1;
		assert game.getBoard()[1][0].getState() == 1;
		assert game.getBoard()[2][0].getState() == 0;
		assert game.getBoard()[1][1].getState() == -1;
		assert game.getBoard()[1][2].getState() == -1;
		assert game.getBoard()[2][1].getState() == -1;
		assert game.getBoard()[2][2].getState() == -1;

		game.playMove(p2, new Point(0, 1));
		assert (game.getAvailableMoves().size() == 5);
		assert game.getBoard()[0][0].getState() == 0;
		assert game.getBoard()[0][1].getState() == 1;
		assert game.getBoard()[0][2].getState() == -1;
		assert game.getBoard()[1][0].getState() == 1;
		assert game.getBoard()[2][0].getState() == 0;
		assert game.getBoard()[1][1].getState() == -1;
		assert game.getBoard()[1][2].getState() == -1;
		assert game.getBoard()[2][1].getState() == -1;
		assert game.getBoard()[2][2].getState() == -1;

		game.playMove(p1, new Point(0, 2));
		assert (game.getAvailableMoves().size() == 4);
		assert game.getBoard()[0][0].getState() == 0;
		assert game.getBoard()[0][1].getState() == 1;
		assert game.getBoard()[0][2].getState() == 0;
		assert game.getBoard()[1][0].getState() == 1;
		assert game.getBoard()[2][0].getState() == 0;
		assert game.getBoard()[1][1].getState() == -1;
		assert game.getBoard()[1][2].getState() == -1;
		assert game.getBoard()[2][1].getState() == -1;
		assert game.getBoard()[2][2].getState() == -1;

		game.playMove(p2, new Point(1, 1));
		assert (game.getAvailableMoves().size() == 3);
		assert game.getBoard()[0][0].getState() == 0;
		assert game.getBoard()[0][1].getState() == 1;
		assert game.getBoard()[0][2].getState() == 0;
		assert game.getBoard()[1][0].getState() == 1;
		assert game.getBoard()[2][0].getState() == 0;
		assert game.getBoard()[1][1].getState() == 1;
		assert game.getBoard()[1][2].getState() == -1;
		assert game.getBoard()[2][1].getState() == -1;
		assert game.getBoard()[2][2].getState() == -1;

		game.playMove(p1, new Point(1, 2));
		assert (game.getAvailableMoves().size() == 2);
		assert game.getBoard()[0][0].getState() == 0;
		assert game.getBoard()[0][1].getState() == 1;
		assert game.getBoard()[0][2].getState() == 0;
		assert game.getBoard()[1][0].getState() == 1;
		assert game.getBoard()[2][0].getState() == 0;
		assert game.getBoard()[1][1].getState() == 1;
		assert game.getBoard()[1][2].getState() == 0;
		assert game.getBoard()[2][1].getState() == -1;
		assert game.getBoard()[2][2].getState() == -1;

		game.playMove(p2, new Point(2, 2));
		assert (game.getAvailableMoves().size() == 1);
		assert game.getBoard()[0][0].getState() == 0;
		assert game.getBoard()[0][1].getState() == 1;
		assert game.getBoard()[0][2].getState() == 0;
		assert game.getBoard()[1][0].getState() == 1;
		assert game.getBoard()[2][0].getState() == 0;
		assert game.getBoard()[1][1].getState() == 1;
		assert game.getBoard()[1][2].getState() == 0;
		assert game.getBoard()[2][1].getState() == -1;
		assert game.getBoard()[2][2].getState() == 1;

		game.playMove(p1, new Point(2, 1));
		assert (game.getAvailableMoves().size() == 0);
		assert game.getBoard()[0][0].getState() == 0;
		assert game.getBoard()[0][1].getState() == 1;
		assert game.getBoard()[0][2].getState() == 0;
		assert game.getBoard()[1][0].getState() == 1;
		assert game.getBoard()[2][0].getState() == 0;
		assert game.getBoard()[1][1].getState() == 1;
		assert game.getBoard()[1][2].getState() == 0;
		assert game.getBoard()[2][1].getState() == 0;
		assert game.getBoard()[2][2].getState() == 1;

		assert (game.isGameOver());
		assert (game.getWinner() == null);

	}

}
