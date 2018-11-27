package players;

import java.awt.geom.Point2D;
import java.util.Random;

import interfaces.IGame;
import interfaces.IPlayer;

public class RandomPlayer implements IPlayer {

	@Override
	public String getName() {

		return "Random Player";
	}

	@Override
	public Point2D getMove(IGame game) {
		Random rand = new Random();

		return game.getAvailableMoves().get(rand.nextInt(game.getAvailableMoves().size()));
	}

}
