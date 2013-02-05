package Lab2;

import testSortCol.CollectionWithGet;
import datastructures.LinkedCollection;

public class SortedLinkedCollection<E extends Comparable<? super E>> extends
		LinkedCollection<E> implements CollectionWithGet<E> {
	
	public SortedLinkedCollection() {
		super();
	}

	@Override
	public boolean add(E e) {
		if (e == null) {
			throw new NullPointerException();
		} 
		else if (head == null) {
			head = new Entry(e, null);
			return true;
		}
		else if (e.compareTo(head.element) < 1) {
			super.add(e);
			return true;
		} 
		else {
			return place(head, e);
		}
	}

	@Override
	public E get(E e) {
		Entry entry = find(e, head);
		return entry == null ? null : entry.element;
	}
	
	private Entry find(E e, Entry current) {
		if (current == null)
			return null;
		else {
			if (e.compareTo(current.element) != 0)
				return find(e, current.next);
			else
				return current;
		}
	}

	private boolean place(Entry current, E e) {
		if (current.next == null) {
			current.next = new Entry(e, null);
			return true;
		}
		else if (e.compareTo(current.element) < 1) {
			current = new Entry(e, current);
			return true;
		} 
		else {
			return place(current.next, e);
		}
	}
}
