/*
 * Name: Nang Chen
 * Login: cs12saw
 * PID: A14205066
 * Date: 04/28/2017
 * File: Maze.java
 * 
 * This is a class that designs the movement and characteristics of the maze.
 */
package hw4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Maze {
	public Square[][] maze; // a 2D Maze
	protected int numRows; // No of rows
	protected int numCols; // No of cols

	public Maze() {
		numRows = 0;
		numCols = 0;
	}

	/**
	 * Load the input maze.
	 * 
	 * @param fname
	 */
	public boolean loadMaze(String fname) {

		String line;
		BufferedReader inputStrem;
		StringTokenizer st;

		try {
			int currentRow = 0;

			inputStrem = new BufferedReader(new FileReader(fname));
			line = inputStrem.readLine();
			if (line != null) {
				st = new StringTokenizer(line);
				numRows = Integer.parseInt(st.nextToken());
				numCols = Integer.parseInt(st.nextToken());
				maze = new Square[numRows][numCols];
			} else {
				return false;
			}

			while ((line = inputStrem.readLine()) != null) {
				if (numRows == 0) { // true if reading first line in file,
									// containing numRows numColums
					st = new StringTokenizer(line);
					numRows = Integer.parseInt(st.nextToken());
					numCols = Integer.parseInt(st.nextToken());
					maze = new Square[numRows][numCols];
				} else if (line.length() == 1)
					break;
				else {
					int col = 0;
					for (int c = 0; c < line.length(); c++) {

						if (line.charAt(c) == ' ')
							continue;
						maze[currentRow][col] = 
								new Square(currentRow, col
							, Character.getNumericValue(line.charAt(c)));
						col++;
					}
					currentRow++;
				}
			}
		} catch (IOException e) {
			System.out.println(e.toString());
			System.out.println("Could not find file " + fname);
		}

		return true;
	}

	/**
	 * Get neighbors in north,east,south,west directions in order.
	 * 
	 * @param sq
	 * @return neighbors added to the arraylist
	 */
	public ArrayList<Square> getNeighbors(Square sq) {
		ArrayList<Square> arraylist = new ArrayList<Square>();
		if (sq.getRow() > 0) {
			if (maze[sq.getRow() - 1][sq.getCol()].isValid()) {
				arraylist.add(maze[sq.getRow() - 1][sq.getCol()]);
			}
		}
		if (sq.getCol() < numCols - 1) {
			if (maze[sq.getRow()][sq.getCol() + 1].isValid()) {
				arraylist.add(maze[sq.getRow()][sq.getCol() + 1]);
			}
		}
		if (sq.getRow() < numRows - 1) {
			if (maze[sq.getRow() + 1][sq.getCol()].isValid()) {
				arraylist.add(maze[sq.getRow() + 1][sq.getCol()]);
			}
		}
		if (sq.getCol() > 0) {
			if (maze[sq.getRow()][sq.getCol() - 1].isValid()) {
				arraylist.add(maze[sq.getRow()][sq.getCol() - 1]);
			}
		}
		return arraylist;
	}

	/**
	 * Loop through the whole maze and get start.
	 * 
	 * @return starting square, else return null
	 */
	public Square getStart() {
		for (int row = 0; row < numRows; row++) {
			for (int col = 0; col < numCols; col++) {
				if (maze[row][col].isStart()) {
					return maze[row][col];
				}
			}
		}
		return null;
	}

	/**
	 * Loop through the whole maze and get exit.
	 * 
	 * @return finishing square, else return null
	 */
	public Square getFinish() {
		for (int row = 0; row < numRows; row++) {
			for (int col = 0; col < numCols; col++) {
				if (maze[row][col].isFinish()) {
					return maze[row][col];
				}
			}
		}
		return null;
	}

	/**
	 * Set specific square to be visited.
	 * 
	 * @param row
	 * @param col
	 */
	public void setVisit(int row, int col) {
		maze[row][col].setVisited();
	}

	/**
	 * Loop through the whole maze and clear all the squares.
	 */
	public void clearMaze() {
		for (int row = 0; row < numRows; row++) {
			for (int col = 0; col < numCols; col++) {
				maze[row][col].clearVisited();
			}
		}
	}

	/**
	 * Get maze.
	 * 
	 * @return maze
	 */
	public Square[][] getMaze() {
		return maze;
	}

	/**
	 * @return the toString of the whole maze
	 */
	@Override
	public String toString() {
		String s = "";
		for (int r = 0; r < numRows; r++) {
			for (int c = 0; c < numCols; c++)
				s = s + maze[r][c].toString();
			s = s + "\n";
		}
		return s;
	}

}
