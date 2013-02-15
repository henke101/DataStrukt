package Lab2;

import testSortCol.CollectionWithGet;
import datastructures.LinkedCollection;

/**
 * A linked collection that is constantly sorted using the Comparable interface
 * of the elements. Elements have to be a subclass to comparable. This linked
 * collection implements CollectionWithGet<E> which means it has a get() method.
 * 
 * @author Mike Phoohad
 * @author Henrik Andersson
 * @group 21
 */
public class SortedLinkedCollection<E extends Comparable<? super E>> extends
		LinkedCollection<E> implements CollectionWithGet<E> {

	private Entry last;

	@Override
	/**
	 * Adds an element to the collection.
	 * The element added will be added in a sorted way according to the 
	 * compareTo method in the Comparable interface.
	 * 
	 * @param element the object to add into the list
	 * @return true if the object has been added to the list.
	 * @throws NullPointerException if parameter <tt>element<tt> is null. 
	 */
	public boolean add(E e) throws NullPointerException {
		if (e == null) {
			throw new NullPointerException();
		} else if (head == null) { // Collection is empty, put it first
			head = new Entry(e, null);
			last = head;
			return true;
		} else if (e.compareTo(head.element) < 1) { // Smaller than first, put
													// it first
			super.add(e);
			return true;
		} else if (e.compareTo(last.element) >= 0) { // Greater or equal to
														// last, put it last
			last.next = new Entry(e, null);
			last = last.next;
			return true;
		} else { // Greater than first and smaller than last so we look for the
					// proper spot to put it
			Entry current = head.next;
			Entry previous = head;
			Entry insert = new Entry(e, null);
			while (current != null && current.element.compareTo(e) < 0) {
				previous = current;
				current = current.next;
			}
			insert.next = current;
			previous.next = insert;
			if (current == null) {
				last = insert;
			}
			return true;
		}
	}

	@Override
	/**
	 * Searches for an identical element to the parameter and 
	 * returns the matching element if it exists in the collection.
	 * If it doesn't exist it returns null.
	 * 
	 * @param element to search for in the collection
	 * @returns a matching element if it exists, null otherwise
	 */
	public E get(E e) {
		if (head == null) {
			return null;
		} else if (e.compareTo(last.element) >= 0) {
			/*
			 * We check if it's at the back of the collection or so big that it
			 * can't be in the collection
			 */
			return e.compareTo(last.element) == 0 ? last.element : null;
		} else {
			Entry forward = head.next;
			Entry previous = head;
			while (forward != null && previous.element.compareTo(e) < 0) {
				previous = forward;
				forward = forward.next;
			}
			return previous.element.compareTo(e) == 0 ? previous.element : null;
		}
	}
}
