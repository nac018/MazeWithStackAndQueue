package hw4;

import java.util.*;

public class Deque12<E> implements BoundedDeque<E> {

	private int front;
	private int rear;
	private int cap;
	private int nelems;
	private ArrayList<E> arrayList;

	// constructor
	public Deque12(int n) {
		front = 0;
		rear = 0;
		// set capacity to input number
		cap = n;
		// set number of elements to 0
		nelems = 0;
		arrayList = new ArrayList<E>();
		if(n < 0){
			throw new IllegalArgumentException();
		}
		for(int i = 0;i < cap; i++){
			arrayList.add(null);
		}
	}

	/**
	 * Returns the capacity of this BoundedDeque,that is,the maximum number of
	 * elements it can hold. <br>
	 * PRECONDITION: none <br>
	 * POSTCONDITION: the BoundedDeque is unchanged.
	 * 
	 * @return the capacity of this BoundedDeque
	 */
	@Override
	public int capacity() {
		return cap;
	}

	/**
	 * Returns the number of elements in this BoundedDeque. <br>
	 * PRECONDITION: none <br>
	 * POSTCONDITION: the BoundedDeque is unchanged.
	 * 
	 * @return the number of elements in this BoundedDeque
	 */
	@Override
	public int size() {
		return nelems;
	}

	/**
	 * Adds the specified element to the front of this BoundedDeque. Returns
	 * true if the operation succeeded, else false. <br>
	 * PRECONDITION:the BoundedDeque's size is less than its capacity. <br>
	 * POSTCONDITION:the element is now the front element in this BoundedDeque,
	 * none of the other elements have been changed, and the size is increased
	 * by 1.
	 * 
	 * @param e
	 *            the element to add to the front of the list
	 * @return <tt>true</tt> if the element was added, else <tt>false</tt>.
	 * @throws NullPointerException
	 *             if the specified element is null, and size is less than
	 *             capacity
	 */
	@Override
	public boolean addFront(E e) {
		if (e == null && size() < capacity()) {
			throw new NullPointerException();
		} 
		int temp = front - 1;
		if (capacity() == 0 || size() == capacity()) {
			return false;
		} 
		if (temp < 0) {
			temp = capacity() - 1;
		}
		front = temp;
		arrayList.set(front, e);
		nelems++;
		return true;
	}

	/**
	 * Adds the specified element to the back of this BoundedDeque.Returns true
	 * if the operation succeeded, else false. <br>
	 * PRECONDITION: the BoundedDeque's size is less than its capacity. <br>
	 * POSTCONDITION: the element is now the back element in this BoundedDeque,
	 * none of the other elements have been changed, and the size is increased
	 * by 1.
	 * 
	 * @param e
	 *            the element to add to the back of the list
	 * @return <tt>true</tt> if the element was added, else <tt>false</tt>.
	 * @throws NullPointerException
	 *             if the specified element is null, and size is less than
	 *             capacity
	 */
	@Override
	public boolean addBack(E e) {
		if (e == null && size() < capacity()) {
			throw new NullPointerException();
		}
		if (capacity() == 0 || size() == capacity()) {
			return false;
		} 
		arrayList.set(rear,e);
		rear = (rear + 1) % capacity();
		nelems++;
		return true;
	}

	/**
	 * Removes the element at the front of this BoundedDeque. Returns the
	 * element removed, or <tt>null</tt> if there was no such element. <br>
	 * PRECONDITION: the BoundedDeque's size is greater than zero. <br>
	 * POSTCONDITION: the front element in this BoundedDeque has been removed,
	 * none of the other elements have been changed, and the size is decreased
	 * by 1.
	 * 
	 * @return the element removed, or <tt>null</tt> if the size was zero.
	 */
	@Override
	public E removeFront() {
		if (size() == 0) {
			return null;
		} else {
			E deque = arrayList.get(front);
			front = (front + 1) % capacity();
			nelems--;
			return deque;
		}
	}

	/**
	 * Removes the element at the back of this BoundedDeque. Returns the element
	 * removed, or <tt>null</tt> if there was no such element. <br>
	 * PRECONDITION: the BoundedDeque's size is greater than zero. <br>
	 * POSTCONDITION: the back element in this BoundedDeque has been removed,
	 * none of the other elements have been changed, and the size is decreased
	 * by 1.
	 * 
	 * @return the element removed, or <tt>null</tt> if the size was zero.
	 */
	@Override
	public E removeBack() {
		if (nelems == 0) {
			return null;
		} 
		rear--;
		if(rear < 0){
			rear = capacity() - 1;
		}
		nelems--;
		return arrayList.get(rear);
	}

	/**
	 * Returns the element at the front of this BoundedDeque, or <tt>null</tt>
	 * if there was no such element. <br>
	 * PRECONDITION: the BoundedDeque's size is greater than zero. <br>
	 * POSTCONDITION: The BoundedDeque is unchanged.
	 * 
	 * @return the element at the front, or <tt>null</tt> if the size was zero.
	 */
	@Override
	public E peekFront() {
		if(size() == 0){
			return null;
		}
		else{
			return arrayList.get(front);
		}
	}

	/**
	 * Returns the element at the back of this BoundedDeque, or <tt>null</tt>if
	 * there was no such element. <br>
	 * PRECONDITION: the BoundedDeque's size is greater than zero. <br>
	 * POSTCONDITION: The BoundedDeque is unchanged.
	 * 
	 * @return the element at the back, or <tt>null</tt> if the size was zero.
	 */
	@Override
	public E peekBack() {
		if (size() == 0) {
			return null;
		} 
		int newRear = rear - 1;
		if(newRear < 0){
			newRear = capacity() - 1;
		}
		return arrayList.get(newRear);
	}

}
