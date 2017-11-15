/*
 * Name: Nang Chen
 * Login: cs12saw
 * PID: A14205066
 * Date: 04/28/2017
 * File: MyQueue.java
 * 
 * This is a generic class that implements BoundedQueue class. 
 * It includes all the dequeue, enqueue and peek methods. 
 */

package hw4;

public class MyQueue<E> implements BoundedQueue<E> {

	private Deque12<E> deque;
	
	public MyQueue(int n){
		deque = new Deque12<E>(n);
	}
	/**
	 * Returns the capacity of this BoundedQueue,that is,the maximum number of
	 * elements it can hold. <br>
	 * PRECONDITION: none <br>
	 * POSTCONDITION: the BoundedQueue is unchanged.
	 * 
	 * @return the capacity of this BoundedQueue
	 */
	public int capacity() {
		return deque.capacity();
	}

	/**
	 * Returns the number of elements in this BoundedQueue. <br>
	 * PRECONDITION: none <br>
	 * POSTCONDITION: the BoundedQueue is unchanged.
	 * 
	 * @return the number of elements in this BoundedQueue
	 */
	public int size() {
		return deque.size();
	}

	/**
	 * Adds the specified element to the tail of this BoundedQueue.Returns true
	 * if the operation succeeded, else false. <br>
	 * PRECONDITION: the BoundedQueue's size is less than its capacity. <br>
	 * POSTCONDITION: the element is now the tail element in this BoundedQueue,
	 * none of the other elements have been changed, and the size is increased
	 * by 1.
	 * 
	 * @param e
	 *            the element to add to the queue
	 * @return <tt>true</tt> if the element was added, else <tt>false</tt>.
	 * @throws NullPointerException
	 *             if the specified element is null, and size is less than
	 *             capacity
	 */
	public boolean enqueue(E e) {
		return deque.addBack(e);
	}

	/**
	 * Removes the element at the head of this BoundedQueue.Returns the element
	 * removed, or <tt>null</tt> if there was no such element. <br>
	 * PRECONDITION: the BoundedQueue's size is greater than zero. <br>
	 * POSTCONDITION: the head element in this BoundedQueue has been removed,
	 * none of the other elements have been changed, and the size is decreased
	 * by 1.
	 * 
	 * @return the element removed, or <tt>null</tt> if the size was zero.
	 */
	public E dequeue() {
		return deque.removeFront();
	}

	/**
	 * Returns the element at the head of this BoundedQueue,or <tt>null</tt> if
	 * there was no such element. <br>
	 * PRECONDITION: the BoundedQueue's size is greater than zero. <br>
	 * POSTCONDITION: The BoundedQueue is unchanged.
	 * 
	 * @return the element at the head, or <tt>null</tt> if the size was zero.
	 */
	public E peek() {
		return deque.peekFront();
	}
}
