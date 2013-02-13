package Lab2;

/**
 * Tests class SplayTree.
 * @author Mike Phoohad
 * @author Henrik Andersson
 * @group 21
 */
public class SplayTest {
	public static void main(String[] args) {
		SplayTree<Integer> splay = new SplayTree<Integer>();
		int[] array = {1,1,2,4,2123,2122,32,123,235,3256,4367,2134,453,72,1,453123,786,743,123,7867,7543,4531,23485,6 };
		for (int i = 0; i < array.length; i++) {
			splay.add(array[i]);
		}
		StringBuilder sb = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();
		sb.append(splay);
		System.out.println(sb);
		
		SplayTree<String> splay2 = new SplayTree<String>();
		
		String[] array2 = {"f", "h", "z", "d", "e", "f"};
		for (int i = 0; i < array2.length; i++) {
			splay2.add(array2[i]);
		}
		sb2.append(splay2);
		System.out.println(sb2);
	}
}
