package model;

import java.awt.Point;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

import interfaces.IGame;
import interfaces.IPlayer;

public class Game implements IGame {

	private IPlayer playerOne; // player is O
	private IPlayer playerTwo; // player is X
	private Cell[][] board;
	private IPlayer winner = null;

	public Game(IPlayer playerOne, IPlayer playerTwo) {
		this.playerOne = playerOne;
		this.playerTwo = playerTwo;

		board = new Cell[3][3];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				board[i][j] = new Cell();
			}
		}

	}

	@Override
	public List<Point2D> getAvailableMoves() {

		List availableMoves = new ArrayList<Point2D>();
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (board[i][j].getState() == -1) {

					Point2D newPoint = new Point();
					newPoint.setLocation(i, j);
					availableMoves.add(newPoint);

				}
			}
		}
		return availableMoves;
	}

	@Override
	public Cell[][] getBoard() {

		return board;
	}

	@Override
	public String getPlayerOneName() {
		return playerOne.getName();
	}

	@Override
	public String getPlayerTwoName() {
		return playerTwo.getName();
	}

	public IPlayer getPlayerTwo() {
		return playerTwo;
	}

	public void setPlayerTwo(IPlayer playerTwo) {
		this.playerTwo = playerTwo;
	}

	public IPlayer getPlayerOne() {
		return playerOne;
	}

	public void setPlayerOne(IPlayer playerOne) {
		this.playerOne = playerOne;
	}

	@Override
	public void playGame() {
		while (!isGameOver()) {

			while (!playMove(playerOne, playerOne.getMove(this))) {

			}
			if (getWinner() != null) {
				break;
			}

			while (!playMove(playerTwo, playerTwo.getMove(this))) {

			}

		}
	}

	@Override
	public boolean playMove(IPlayer player, Point2D move) {

		if (!getAvailableMoves().contains(move)) {

			return false;
		}

		if (player.equals(playerOne)) {
			board[(int) move.getX()][(int) move.getY()].setState(0);
		} else {
			board[(int) move.getX()][(int) move.getY()].setState(1);

		}
		return true;
	}

	@Override
	public IPlayer getWinner() {

		return winner;

	}

	@Override
	public boolean isGameOver() {

		return getAvailableMoves().isEmpty() || !(getWinner() != null);
	}

	private void determineWinner(Point lastMove) {
//TODO
		for (int i = 0; i < 3; i++) {
			if (board[(int) lastMove.getX()][0].getState() == board[(int) lastMove.getX()][1].getState()
					&& board[(int) lastMove.getX()][0].getState() == board[(int) lastMove.getX()][2].getState()) {
				if (board[(int) lastMove.getX()][i].getState() == 0) {
					winner = playerOne;
					return;
				} else {
					winner = playerTwo;
					return;
				}
			}
		}
		
		for (int i = 0; i < 3; i++) {
			if (board[i][0].getState() == board[i][1].getState()
					&& board[i][0].getState() == board[i][2].getState()) {
				if (board[i][i].getState() == 0) {
					winner = playerOne;
					return;
				} else {
					winner = playerTwo;
					return;
				}
			}
		}

	}

}
