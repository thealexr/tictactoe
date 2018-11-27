package model;

public class Cell {

	private int state= -1; // -1 = blank, 0 = O, 1 = X



	public void setState(int newState) {

		if (newState > 1 || newState < -1) {
			System.out.println("newState is not a valid state for the cell, must be -1 for blank, 0 for 0 or 1 for X");
		} else {
			this.state = newState;
		}

	}

	public int getState() {
		return state;
	}

}
