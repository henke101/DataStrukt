package Lab1;

public class TestProgram {
	
	public static void main (String [] args){
		Uppg1 test = new Uppg1();
		System.out.println("*" + test +" # det ska inte st� n�got innan");
		for (int i = 0; i < 12; i++) {
			test.addFirst("" + i);
		}
		System.out.println("*" + test + " # det ska vara fyllt " +
				"med 12 element 11->0");
		test.addAfterP(4, "hejhej");
		System.out.println("*" + test +  " # b�r inneh�lla " +
				"'hejhej' p� index 4");
		System.out.println("*" + (test.existP("hejhej")) + " # b�r " +
				"svara sann om hejhej finns");
		for (int i = 0; i < 13; i++) {
			test.removeFirst();
		}
		System.out.println("*" + test +" # det ska inte st� n�got" +
				", allts� den skall �terigen vara tom");
		
		try {
			test.setP(2);
		} catch (IndexOutOfBoundsException e) {
			System.out.println("*" + e + " # det ska st� ett error " +
					"message fr�n exception");
		}
		
		System.out.println("*" + (test.empty()) + " # det ska st� true d� den �r tom");
		
		for (int i = 0; i < 5; i++) {
			test.addFirst("" + i);
		}
		
		System.out.println("*" + test.hasNext(2) + " # ska vara true");
		System.out.println("*" + test.hasNext(5) + " # ska vara false");
		
		test.addAfterP(2, "test");
		System.out.println("*" + test + " # skall inneh�lla test p� index 2");
		
		System.out.println("*" + test.get(2) + " # det skall st� test");
		test.moveP(-2);  // ta bort eller testa
		
		System.out.println("*" + (test.setPToIndexOf("test")) + " # ska vara true");
		System.out.println("*" + (test.setPToIndexOf("326")) + " # ska vara false");
		
	}

}
