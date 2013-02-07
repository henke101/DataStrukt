package Lab2;

/**
 * Tests class SortedLinkedCollection.
 * @author Mike Phoohad
 * @author Henrik Andersson
 * @group 21
 */
public class SLCTest {
	public static void main(String[] args) {
		SortedLinkedCollection<Integer> SLC = new SortedLinkedCollection<Integer>();
		int[] array = {1,1,2,4,2123,2122,32,123,235,3256,4367,2134,453,72,453123,786,743,123,7867,7543,4531,23485,6 };
		for (int i = 0; i < array.length; i++) {
			SLC.add(array[i]);
		}
		StringBuilder sb = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();
		sb.append(SLC);
		System.out.println(sb);
		
		SortedLinkedCollection<String> SLC2 = new SortedLinkedCollection<String>();
		
		String[] array2 = {"f", "h", "z", "d", "e", "f"};
		for (int i = 0; i < array2.length; i++) {
			SLC2.add(array2[i]);
		}
		sb2.append(SLC2);
		System.out.println(sb2);
	}
}
