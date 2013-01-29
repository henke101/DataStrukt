package Lab1;

public class TestProgram2 {

	public static void main (String [] args) {
		System.out.println("*" + Uppg2.binarySqrt(10000, 100));
		System.out.println("Den riktiga roten till ovan: " + 
				Math.sqrt(10000) + "\n");
		System.out.println("*" + Uppg2.binarySqrt(-25, 0.00001));
		System.out.println("Den riktiga roten till ovan skall inte finnas\n");
		System.out.println("*" + Uppg2.binarySqrt(-25, 454651));
		System.out.println("Den riktiga roten till ovan skall inte finnas\n");
		System.out.println("*" + Uppg2.binarySqrt(25, 26));
		System.out.println("Den riktiga roten till ovan: " + 
				Math.sqrt(25) + "\n");
		System.out.println("*" + Uppg2.binarySqrt(125, 0.00001));
		System.out.println("Den riktiga roten till ovan: " + 
				Math.sqrt(125) + "\n");
		System.out.println("*" + Uppg2.binarySqrt(10000, 0.00001));
		System.out.println("Den riktiga roten till ovan: " + 
				Math.sqrt(10000) + "\n");
		System.out.println("*" + Uppg2.binarySqrt(10000, 10));
		System.out.println("Den riktiga roten till ovan: " + 
				Math.sqrt(10000) + "\n");
		System.out.println("*" + Uppg2.binarySqrt(1787569, 0.00001));
		System.out.println("Den riktiga roten till ovan: " + 
				Math.sqrt(1787569) + "\n");
		
	}

}
