/*
 * Name: Nang Chen
 * Login: cs12saw
 * PID: A14205066
 * Date: 04/28/2017
 * File: MazeTest.java
 * 
 * This is a class that tests the Maze class.
 */
package hw4;

import java.io.File;
import java.util.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

public class MazeTester {
	private Maze sample;
	
	@Before
	public void setUp(){
		sample = new Maze();
		sample.loadMaze("maze-4.txt");
	}
	
	@Before
	public void print(){
		String mazeInSymbols = sample.toString();
		System.out.print(mazeInSymbols);
	}
	
	@Test
	public void testGetNeighbors(){
		//test numbers of neighbors of start
		assertEquals(2,sample.getNeighbors(sample.getStart()).size());
		//test indexes of the east neighbor of start
		assertEquals(0,sample.getNeighbors(sample.getStart()).get(0).getRow());
		assertEquals(2,sample.getNeighbors(sample.getStart()).get(0).getCol());
		//test indexes of the west neighbor of start
		assertEquals(0,sample.getNeighbors(sample.getStart()).get(1).getRow());
		assertEquals(0,sample.getNeighbors(sample.getStart()).get(1).getCol());
		//test numbers of neighbors of finish
		assertEquals(1,sample.getNeighbors(sample.getFinish()).size());
		//test indexes of the north neighbor of finish
		assertEquals(4,sample.getNeighbors(sample.getFinish()).get(0).getRow());
		assertEquals(4,sample.getNeighbors(sample.getFinish()).get(0).getCol());
		//test other squares like corners and borders in the same way
		//corner case
		assertEquals(2,sample.getNeighbors(sample.maze[9][0]).size());
		assertEquals(8,sample.getNeighbors(sample.maze[9][0]).get(0).getRow());
		assertEquals(0,sample.getNeighbors(sample.maze[9][0]).get(0).getCol());
		assertEquals(9,sample.getNeighbors(sample.maze[9][0]).get(1).getRow());
		assertEquals(1,sample.getNeighbors(sample.maze[9][0]).get(1).getCol());
		//border case
		assertEquals(2,sample.getNeighbors(sample.maze[0][7]).size());
		assertEquals(0,sample.getNeighbors(sample.maze[0][7]).get(0).getRow());
		assertEquals(8,sample.getNeighbors(sample.maze[0][7]).get(0).getCol());
		assertEquals(0,sample.getNeighbors(sample.maze[0][7]).get(1).getRow());
		assertEquals(6,sample.getNeighbors(sample.maze[0][7]).get(1).getCol());
	}
	
	@Test
	public void testGetStart(){
		assertEquals("S",sample.getStart().toString());
	}
	
	@Test
	public void testGetFinish(){
		assertEquals("E",sample.getFinish().toString());
	}
	
	@Test
	public void testSetVisit(){
		sample.setVisit(2,2);
		assertTrue(sample.maze[2][2].isVisited());
	}
	
	@Test
	public void testClearMaze(){
		sample.setVisit(2,2);
		sample.setVisit(3,3);
		sample.clearMaze();
		assertFalse(sample.maze[2][2].isVisited());
		assertFalse(sample.maze[3][3].isVisited());
	}
	
	@Test
	public void testGetMaze(){
		Square[][] s = sample.getMaze();
		assertEquals("#",s[3][1].toString());
		assertEquals("S",s[0][1].toString());
	}
	
	@Test
	public void testToString(){
		assertEquals("S",sample.maze[0][1].toString());
		assertEquals("E",sample.maze[5][4].toString());
	}
}