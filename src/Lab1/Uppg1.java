
package Lab1;

import java.util.NoSuchElementException;
/**
 * This class represents an array of String elements.
 * @author Mike Phoohad
 * @author Henrik Andersson
 */
public class Uppg1 {

	private String[] strings;
	private int logicSize;
	private int p;
	/**
	 * Constructs an object with a default capacity of 10 String elements.
	 */
	public Uppg1() {
		strings = new String[10];
	}
	/**
	 * Constructs an object with a set capacity.
	 * @param size The capacity size of the array
	 */
	public Uppg1(int size) {
		strings = new String[size];
	}
	/**
	 * Adds an String element at the first index.
	 * Can not add a null element.
	 * @param element The String to be added
	 */
	public void addFirst(String element) throws IllegalArgumentException{
		addElement(0, element);
	}
	/**
	 * @return True if array contains no elements, false otherwise
	 */
	public boolean empty() {

		return logicSize == 0;
	}
	/**
	 * @return The first element of the array
	 * @throws NoSuchElementException
	 */
	public String getFirst() throws NoSuchElementException {
		if (this.empty()) {
			throw new NoSuchElementException("Array is empty");
		}
		return strings[0];

	}
	/**
	 * Removes the first element of the array.
	 * If the array contains no elements it does nothing.
	 */
	public void removeFirst() {
		if (this.empty()) {
			return;
		}
		int i = 1;
		do {
			strings[i - 1] = strings[i];
			i++;
		} while (i < logicSize);

		strings[i] = null;
		logicSize--;
	}
	/**
	 * @param elem The String element to find
	 * @return True if the array contains the element, false otherwise
	 */
	public boolean existP(String elem) {
		if (elem == null){
			return false;
		}
		return (find(elem) >= 0);
	}

	@Override
	/**
	 * Returns a String representation of the object in the format
	 * [ a, b, c ] if the array contains the elements a, b and c.
	 * If the array is empty this returns an empty string.
	 */
	public String toString() {
		if (empty()) {
			return "";
		} else {
			StringBuilder stringBuilder = new StringBuilder();
			stringBuilder.append("[ " + strings[0]);
			for (int i = 1; i < logicSize; i++) {
				stringBuilder.append(", " + strings[i]);
			}
			stringBuilder.append(" ]");
			return "" + stringBuilder;
		}
	}
	/**
	 * Sets the position index to a specific value.
	 * If it is not possible it throws an IndexOufOfBoundsException.
	 * @param p The desired position index
	 * @throws IndexOutOfBoundsException
	 */
	public void setP(int p) throws IndexOutOfBoundsException {
		if (empty()) {
			throw new IndexOutOfBoundsException("Array has no elements");
		}

		if (p < 0) {
			throw new IndexOutOfBoundsException(
					"p must be a positive integer");
		}

		if (!hasNext(p)) {
			throw new IndexOutOfBoundsException("Destination of p must be " +
					"within the size of the array: " + logicSize);
		}
		this.p = p;
	}
	/*
	 * Returns true if the current p index contains an element.
	 * (Note: This method is private since it is mainly used for 
	 * setP to not ever be outside the logical list. Also it isn't among the 
	 * private methods to make it easier to read for the graders.)
	 * @return True if there is something on the position index, false otherwise
	 */
	private boolean hasNext(int index) {
		return (index < logicSize);
	}
	/**
	 * Adds an element to the array at a specific position.
	 * Can not add a null parameter.
	 * @param element The element to be placed in the array
	 * @throws IllegalArgumentException
	 */
	public void addAfterP(String element)
			throws IllegalArgumentException {
		
		addElement(p, element);	
	}
	/**
	 * Returns the element at the position of p
	 * @return The String at the specific index
	 */
	public String get(){
		
		return strings[p];
	}
	/**
	 * Moves the position index
	 * @param val The amount of steps the position index is to be moved
	 * @throws IndexOutOfBoundsException
	 */
	public void moveP(int val) throws IndexOutOfBoundsException{
		setP(this.p+val);
	}
	/**
	 * Searches for a String and sets the position index to the index of 
	 * the first instance of that String in the list if found
	 * @param element The String to be searched for
	 * @return True if the String is found, false otherwise
	 */
	public boolean setPToIndexOf(String element){
		if (find(element) >= 0) {
			p = find(element);
			return true;
		} else {
			return false;
		}


	}

	private boolean isFull() {
		return (strings.length == logicSize);
	}

	private void doubleCapacity() {
		String[] stringsTmp = new String[strings.length * 2];
		System.arraycopy(strings, 0, stringsTmp, 0, logicSize);
		strings = stringsTmp;
	}
	
	
	//we don't check valid index because the 
	//method is private and it's done elsewhere
	private void addElement(int index, String element){
		if (element == null) {
			throw new IllegalArgumentException("Argument can not be null");
		}
		if (isFull()) {
			doubleCapacity();
		}
		for (int i = logicSize - 1; i >= index; i--) {
			strings[i + 1] = strings[i];
		}
		strings[index] = element;
		logicSize++;
	}

	private int find(String element) {
		for (int i = 0; i < logicSize; i++) {
			if (element.equals(strings[i])) {
				return i;
			}
		}
		return -1;
	}
}
