package hw4;

import java.util.ArrayList;
import java.util.LinkedList;

public abstract class MazeSolver {

	protected Maze maze = new Maze();
	private String path = "Found the Escape!";
	boolean gameOver = false; // when stop our game
	boolean foundExit = false; // exit has been found

	abstract void makeEmpty(); // make worklist empty

	abstract boolean isEmpty(); // if (worklist.size == 0) return true;

	abstract void add(Square sq); // add Square to worklist

	abstract Square next(); // Return next item from the worklist

	MazeSolver(Maze maze2) {
		maze = maze2;
	}

	public Maze getMaze() {
		return maze;
	}

	// Add start location to worklist
	public void addStartToWorklist() {
		add(maze.getStart());
	}

	/**
	 * repeatedly call step() until you get to the exit square or the worklist
	 * is empty.
	 */
	public void solve() {
		while (!foundExit()) {
			step();
			if (isEmpty()) {
				break;
			}
		}
	}

	/**
	 * To see if the square explored can reach the exit.
	 * 
	 * @return the square that is just explored
	 */
	public Square step() {
		Square square = null;

		if (isEmpty()) // if the worklist is empty
		{
			makeEmpty();
			addStartToWorklist();
			return null;
		} else {
			square = next();
			if (square.isFinish()) {
				setFoundExit();
			} else {
				ArrayList<Square> list = maze.getNeighbors(square);
				square.setVisited();
				for (int i = 0; i < list.size(); i++) {
					if (list.get(i).getPrevious() == null) {
						list.get(i).setPrevious(square);
						add(list.get(i));
					}
				}
			}
		}
		return square;
	}

	/**
	 * To see if it's a exit.
	 * 
	 * @return true if foundExit is true, else false
	 */
	public boolean foundExit() {
		if (foundExit) {
			foundExit = true;
			return true;
		}
		return false;
	}

	/**
	 * To see if the game will be over
	 * 
	 * @return true if foundExit or isEmpty is true, else false
	 */
	public boolean gameOver() {
		if (foundExit() || isEmpty()) {
			gameOver = true;
			return true;
		}
		return false;
	}

	/**
	 * Set foundExit to be true
	 */
	public void setFoundExit() {
		foundExit = true;
	}

	/**
	 * Set gameOver to be true
	 */
	public void setGameOver() {
		gameOver = true;
	}

	/**
	 * Add all the previous squares to the list from the exit if they exist.
	 * 
	 * @return Path from S to E as a list of coordinates [i,j] If not solvable,
	 *         print message
	 */
	public String getPath() {
		if (foundExit()) {
			LinkedList<Square> list = new LinkedList<Square>();
			Square square = maze.getFinish();
			list.add(square);
			while (true) {
				square = square.getPrevious();
				list.add(0, square);
				square.setOnFinalPath();
				if (square.isStart()) {
					break;
				}
			}
			path = path.concat("\n" + "Path from Start to Exit : ");
			for (int i = 0; i < list.size() - 1; i++) {
				path = path.concat("[" + list.get(i).getRow() + 
						"," + list.get(i).getCol() + "] ");
			}
			return path;
		} else {
			path = "Uh Oh!! There's no escape!!";
			return path;
		}
	}
}
