package players;

import java.awt.geom.Point2D;

import interfaces.IGame;
import interfaces.IPlayer;

public class TestPlayer implements IPlayer {

	@Override
	public String getName() {
		return "Test Player";
	}

	@Override
	public Point2D getMove(IGame game) {
		return game.getAvailableMoves().get(0);
	}

}
