package interfaces;

import java.awt.geom.Point2D;
import java.util.List;

import model.Cell;

public interface IGame {

	public List<Point2D> getAvailableMoves();

	public Cell[][] getBoard();

	public String getPlayerOneName();

	public String getPlayerTwoName();

	public void playGame();

	public boolean isGameOver();

	public boolean playMove(IPlayer player, Point2D move);

	public IPlayer getWinner();

}
