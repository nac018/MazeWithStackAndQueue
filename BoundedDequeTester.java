/*
 * Name: Nang Chen
 * Login: cs12saw
 * PID: A14205066
 * Date: 04/28/2017
 * File: BoundedDequeTester.java
 * 
 * This is a JUnit test for Deque12 which implements BoundedDeque. 
 */
package hw4;

import java.util.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

public class BoundedDequeTester {
	private Deque12<Integer> empty;
	private Deque12<Integer> one;
	private Deque12<Integer> many;
	private int CAP = 15;

	@Before
	public void setUp() {
		empty = new Deque12<Integer>(CAP);
		one = new Deque12<Integer>(CAP);
		one.addFront(new Integer(15));
		many = new Deque12<Integer>(CAP);
		for (int i = 0; i < 10; i++) {
			many.addFront(new Integer(i));
		}
	}

	@Test
	public void testCtor() {
		Deque12<Integer> deque = new Deque12<Integer>(30);
		assertTrue(deque.capacity() == 30);
		try {
			deque = new Deque12<Integer>(-5);
			fail("Should have thrown an exception.");
		} catch (NegativeArraySizeException e) {
		}

		try {
			deque = new Deque12<Integer>(0);
		} catch (IllegalArgumentException e) {
		}
	}

	@Test
	public void testSize() {
		assertEquals(empty.size(), 0);
		assertEquals(one.size(), 1);
		assertEquals(many.size(), 10);
	}

	@Test
	public void testAddFront() {
		many.addFront(new Integer(5));
		assertEquals(many.size(), 11);
		assertEquals(new Integer(5), many.peekFront());
	}

	@Test
	public void testAddFrontException() {
		try {
			one.addFront(null);
			fail("Should have thrown an exception.");
		} catch (NullPointerException e) {
		}
	}
	
	@Test
	public void testAddBack() {
		many.addBack(new Integer(5));
		assertEquals(many.size(), 11);
		assertEquals(new Integer(5), many.peekBack());
	}

	@Test
	public void testAddBackException() {
		try {
			one.addBack(null);
			fail("Should have thrown an exception.");
		} catch (NullPointerException e) {
		}
	}
	
	@Test
	public void testRemoveFront() {
		many.removeFront();
		assertEquals(many.size(), 9);
		assertEquals(new Integer(8), many.peekFront());
	}

	@Test
	public void testRemoveBack() {
		many.removeBack();
		assertEquals(many.size(), 9);
		assertEquals(new Integer(1), many.peekBack());
	}

	@Test
	public void testPeekFront() {
		assertEquals(new Integer(9), many.peekFront());
	}

	@Test
	public void testPeekBack() {
		assertEquals(new Integer(0), many.peekBack());
	}
}
