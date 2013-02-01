package Lab1;
/**
 * 
 * @author HenrikAndersson
 * @author Mike Phoohad
 * group 21
 *
 */
public class TestProgram {
	
	public static void main (String [] args){
		Uppg1 test = new Uppg1();
		System.out.println("*" + test +" # det ska inte stå något innan");
		for (int i = 0; i < 12; i++) {
			test.addFirst("" + i);
		}
		
		
		System.out.println("*" + test + " # det ska vara fyllt " +
				"med 12 element 11->0");
		try {
			test.setP(4);
		} catch (IndexOutOfBoundsException e) {
			System.out.println("*" + e + " # det här ska inte synas");
		}
		test.addAfterP("hejhej");
		System.out.println("*" + test +  " # bör innehålla " +
				"'hejhej' på index 4");
		System.out.println("*" + (test.existP("hejhej")) + " # bör " +
				"svara sann om hejhej finns");
		for (int i = 0; i < 13; i++) {
			test.removeFirst();
		}
		System.out.println("*" + test +" # det ska inte stå något" +
				", alltså den skall återigen vara tom");
		
		try {
			test.setP(2);
		} catch (IndexOutOfBoundsException e) {
			System.out.println("*" + e + " # det ska stå ett error " +
					"message från exception");
		}
		
		System.out.println("*" + (test.empty()) + " # det ska stå true då den är tom");
		
		for (int i = 0; i < 5; i++) {
			test.addFirst("" + i);
		}
		
		//System.out.println("*" + test.hasNext(2) + " # ska vara true");
		//System.out.println("*" + test.hasNext(5) + " # ska vara false");
		try {
			test.setP(2);
		} catch (IndexOutOfBoundsException e) {
			System.out.println("*" + e + " # det ska stå ett error " +
					"message från exception");
		}
		test.addAfterP("test");
		System.out.println("*" + test + " # skall innehålla test på index 2");
		
		System.out.println("*" + test.get() + " # det skall stå test");
		test.moveP(-2);  // ta bort eller testa
		
		System.out.println("*" + (test.setPToIndexOf("test")) + " # ska vara true");
		System.out.println("*" + (test.setPToIndexOf("326")) + " # ska vara false");
		try {
			test.addFirst(null);
		} catch (IllegalArgumentException e) {
			System.out.println("*" + e + " # det ska vara illegal argument med felmeddelande");
		}
		System.out.println("*" + test + " # null skall inte finnas med i utskriften");
		System.out.println("*" +test.existP(null) + " # ska skriva ut false");
		
	}

}
