package hw4;

public class Square {
	private int row;
	private int col;
	private int type;
	private int EMPTY_SPACE = 0;
	private int WALL = 1;
	private int START = 2;
	private int EXIT = 3;
	private boolean VISITED;
	private Square previous;
	private boolean onFinalPath;

	public Square(int row, int col, int type) {
		this.row = row;
		this.col = col;
		this.type = type;
		this.VISITED = false;
		this.previous = null;
		onFinalPath = false;
	}

	public String toString() {
		if (type == EMPTY_SPACE) {
			if (previous != null && isOnFinalPath()) {
				return "x";
			}
			if (previous != null && !isVisited()) {
				return "o";
			}
			if (previous != null && isVisited()) {
				return ".";
			}
			return "_";
		}
		if (type == WALL) {
			return "#";
		}
		if (type == START) {
			return "S";
		}
		if (type == EXIT) {
			return "E";
		}

		return null;
	}

	/**
	 * Gets row number.
	 * 
	 * @return row number
	 */
	public int getRow() {
		return row;
	}

	/**
	 * Gets column number.
	 * 
	 * @return column number
	 */
	public int getCol() {
		return col;
	}

	/**
	 * Gets column number.
	 * 
	 * @return column number
	 */
	public int getType() {
		return type;
	}

	/**
	 * Check if the square type is exit.
	 * 
	 * @return true if toString equals to exit
	 */
	public boolean isFinish() {
		if (toString().equals("E")) {
			return true;
		}
		return false;
	}

	/**
	 * Check if the square type is start.
	 * 
	 * @return true if toString equals to start, else return false
	 */
	public boolean isStart() {
		if (type == START) {
			return true;
		}
		return false;
	}

	/**
	 * Check if the square type is valid.
	 * 
	 * @return true if toString is not wall or start, else return false
	 */
	public boolean isValid() {
		if (!toString().equals("#") && !toString().equals("S")) {
			return true;
		}
		return false;
	}

	/**
	 * Check if it's visited.
	 * 
	 * @return true if visited is true, else return false
	 */
	public boolean isVisited() {
		if (VISITED) {
			return true;
		}
		return false;
	}

	/**
	 * Check if it's on the final path.
	 * 
	 * @return true if onFinalPath is true, else return false
	 */
	public boolean isOnFinalPath() {
		if (onFinalPath) {
			return true;
		}
		return false;
	}

	/**
	 * Set visited to true.
	 */
	public void setVisited() {
		VISITED = true;
	}

	/**
	 * Set visited to false.
	 */
	public void clearVisited() {
		VISITED = false;
	}

	/**
	 * Set visited to false.
	 */
	public Square getPrevious() {
		return previous;
	}

	/**
	 * Set previous to prev.
	 * 
	 * @param prev
	 */
	public void setPrevious(Square prev) {
		this.previous = prev;
	}

	/**
	 * Set onFinalPath to true.
	 */
	public void setOnFinalPath() {
		onFinalPath = true;
	}
}
