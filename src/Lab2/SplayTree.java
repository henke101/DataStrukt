package Lab2;

import testSortCol.CollectionWithGet;
import datastructures.BinarySearchTree;

/**
 * An implementation of a Splay tree.
 * A collection that is selfbalancing and always puts the last accessed
 * 
 * 
 * @author Mike Phoohad
 * @author Henrik Andersson
 * @group 21
 */
public class SplayTree<E extends Comparable<? super E>> extends
		BinarySearchTree<E> implements CollectionWithGet<E> {

	/**
	 * Returns an element after it has splayed the element to the top.
	 * If no element is found it splays the element 
	 * closest to the value of the parameter to the top,
	 * enabling for faster access to similar elements.
	 * 
	 * @return The element it is asked to retrieve
	 */
	@Override
	public E get(E e) {
		
		if (e == null) {
			throw new NullPointerException("Element is null");
		} else if (root == null) {
			return null;
		}
		
		Entry target = findEntry(e, root);
		if (target != null) {
			splay(target);
			return root.element;
		} else {
			return null;
		}
	}
	
	/*
	 * If it finds the element it returns the Entry 
	 * that contains the element.
	 * This method will splay the tree on the previous compared
	 * Entry if it can't find the element in the tree. 
	 */
	private Entry findEntry(E e, Entry t) {
		
		Entry current = t;
		Entry previous = current;
		while (current != null) {
			int cmp = e.compareTo(current.element);
			if (cmp < 0) {
				previous = current;
				current = current.left;
			} else if (cmp > 0) {
				previous = current;
				current = current.right;
			} else {
				return current;
			}
		}
		splay(previous);
		return null;
	}
	
	private void splay(Entry target) {
		/*
		 * Now we move the target "node" up to the root position.
		 */
		Entry targetParent, targetGrandParent;
		while (target.parent != null) {
			targetParent = target.parent;
			targetGrandParent = targetParent.parent;
			if (targetGrandParent == null) {
				if (targetParent.left == target) {
					target = targetParent; 
					zig(target);  
				} else {
					target = targetParent;
					zag(target);
				}
			} else {
				if (targetParent.left == target) {
					if (targetGrandParent.left == targetParent) {
						target = targetGrandParent;
						zigZig(target);
					} else {
						target = targetGrandParent;
						zagZig(target);
					}
				} else {
					if (targetGrandParent.left == targetParent) {
						target = targetGrandParent;
						zigZag(target);
					} else {
						target = targetGrandParent;
						zagZag(target);
					}
				}
			}
		}
	}

	/*
	 * Rotate the subtree clockwise
	 *       x'			        y'
	 *      / \                / \
	 *     y'  C     ->       A   x'
	 *    / \                    / \
	 *   A   B                  B   C
	 */
	private void zig(Entry x) {
		Entry y = x.left;
		E temp = x.element;
		x.element = y.element;
		y.element = temp;
		x.left = y.left;
		if (x.left != null)
			x.left.parent = x;
		y.left = y.right;
		y.right = x.right;
		if (y.right != null)
			y.right.parent = y;
		x.right = y;
	}

	/*
	 * Rotate the subtree counter-clockwise
	 */
	private void zag(Entry x) {
		Entry y = x.right;
		E temp = x.element;
		x.element = y.element;
		y.element = temp;
		x.right = y.right;
		if (x.right != null)
			x.right.parent = x;
		y.right = y.left;
		y.left = x.left;
		if (y.left != null)
			y.left.parent = y;
		x.left = y;
	} // rotateLeft

	/* Rotate the subtree twice clockwise
		    x'                  z'
		   / \                /   \
		  y'  D   -->        y'    x'
		 / \                / \   / \
		A   z'             A   B C   D
		   / \  
		  B   C  
		*/
	private void zigZag(Entry x) {
		Entry y = x.left, z = x.left.right;
		E e = x.element;
		x.element = z.element;
		z.element = e;
		y.right = z.left;
		if (y.right != null)
			y.right.parent = y;
		z.left = z.right;
		z.right = x.right;
		if (z.right != null)
			z.right.parent = z;
		x.right = z;
		z.parent = x;
	} // doubleRotateRight

	/* Rotate the subtree twice counter-clockwise
    		x'                  z'
		   / \                /   \
		  A   y'   -->       x'    y'
		     / \            / \   / \
		    z   D          A   B C   D
		   / \  
		  B   C  
	*/
	private void zagZig(Entry x) {
		Entry y = x.right, z = x.right.left;
		E e = x.element;
		x.element = z.element;
		z.element = e;
		y.left = z.right;
		if (y.left != null)
			y.left.parent = y;
		z.right = z.left;
		z.left = x.left;
		if (z.left != null)
			z.left.parent = z;
		x.left = z;
		z.parent = x;
	} // doubleRotateLeft

	
	/* Executes two zig operations to the tree
			x'                  z'
		   / \                 /  \
		  y'  D     -->       A    y'
		 / \           		      / \
		z'  C            		 B   x'
	   / \  						/ \
	  A   B  					   C   D
	*/
	private void zigZig(Entry x) {
		Entry y = x.left, z = x.left.left;
		E e = x.element;
		x.element = z.element;
		z.element = e;
		Entry temp = z.left;
		y.left = z.right;
		if (y.left != null)
			y.left.parent = y;
		z.right = x.right;
		if (z.right != null)
			z.right.parent = z;
		z.left = y.right;
		if (z.left != null)
			z.left.parent = z;
		x.left = temp;
		if (x.left != null)
			x.left.parent = x;
		y.right = z;
		x.right = y;
	}
	
	/* Inverted zigzig
			z'                  x'
		   / \                 /  \
		  y'  D     <--       A    y'
		 / \           		      / \
		x'  C            		 B   z'
	   / \  						/ \
	  A   B  					   C   D
	*/
	private void zagZag(Entry x) {
		Entry y = x.right, z = x.right.right;
		E e = x.element;
		x.element = z.element;
		z.element = e;
		Entry temp = z.right;
		y.right = z.left;
		if (y.right != null)
			y.right.parent = y;
		z.left = x.left;
		if (z.left != null)
			z.left.parent = z;
		z.right = y.left;
		if (z.right != null)
			z.right.parent = z;
		x.right = temp;
		if (x.right != null)
			x.right.parent = x;
		y.left = z;
		x.left = y;
	}
}
