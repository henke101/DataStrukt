package Lab2;

public class SLCTest {
	public static void main (String[] args) {
		SortedLinkedCollection<Integer> SLC = new SortedLinkedCollection<Integer>();
		int[] array = {5,5,4,3,2,1,9,10,1,123,1240,12,0};
		for (int i = 0; i < array.length; i++) {
			SLC.add(array[i]);
		}
		StringBuilder sb = new StringBuilder();
		sb.append(SLC);
		System.out.println(sb);
	}
}
