package Lab2;

import testSortCol.CollectionWithGet;
import datastructures.BinarySearchTree;

public class SplayTree<E extends Comparable<? super E>> extends
		BinarySearchTree<E> implements CollectionWithGet<E> {

	@Override
	public E get(E e) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * Rotera 1 steg i h�gervarv, dvs x' y' / \ / \ y' C --> A x' / \ / \ A B B
	 * C
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
	} // rotateRight

	/*
	 * Rotera 1 steg i v�nstervarv, dvs x' y' / \ / \ A y' --> x' C / \ / \ B C
	 * A B
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

	/*
	 * Rotera 2 steg i h�gervarv, dvs x' z' / \ / \ y' D --> y' x' / \ / \ / \ A
	 * z' A B C D / \ B C
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

	/*
	 * Rotera 2 steg i v�nstervarv, dvs x' z' / \ / \ A y' --> x' y' / \ / \ / \
	 * z D A B C D / \ B C
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

	private void zigZig(Entry x) {
		Entry q = x.parent.parent;
		Entry p = x.parent;
		Entry oldQParent = q.parent;
		if (q == root) {
			root = x;
			x.parent = null;
		} else {
			x.parent = oldQParent;
			if (oldQParent.left == q) {
				oldQParent.left = x;
			} else {
				oldQParent.right = x;
			}
		}
		q.left = p.right;
		q.parent = p;
		p.left = x.right;
		p.right = q;
		p.parent = x;
		x.right = p;
	}
}
