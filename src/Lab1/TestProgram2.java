package Lab1;

public class TestProgram2 {

	public static void main(String[] args) {
		System.out.println("*" + Uppg2.binarySqrt(10000, 100)
				+ " # sqrt 10000 eps 100");
		System.out.println("Den riktiga roten till ovan: " + Math.sqrt(10000)
				+ "\n");
		System.out.println("*" + Uppg2.binarySqrt(-25, 0.00001)
				+ " # sqrt -25 eps 0.00001");
		System.out.println("Den riktiga roten till ovan skall inte finnas\n");
		System.out.println("*" + Uppg2.binarySqrt(-25, 454651)
				+ " # sqrt -25 eps 454651");
		System.out.println("Den riktiga roten till ovan skall inte finnas\n");
		System.out.println("*" + Uppg2.binarySqrt(25, 26)
				+ " # sqrt -25 eps 454651");
		System.out.println("Den riktiga roten till ovan: " + Math.sqrt(25)
				+ "\n");
		System.out.println("*" + Uppg2.binarySqrt(125, 0.00001)
				+ " # sqrt 125 eps 0.00001");
		System.out.println("Den riktiga roten till ovan: " + Math.sqrt(125)
				+ "\n");
		System.out.println("*" + Uppg2.binarySqrt(10000, 0.00001)
				+ " # sqrt 10000 eps 0.00001");
		System.out.println("Den riktiga roten till ovan: " + Math.sqrt(10000)
				+ "\n");
		System.out.println("*" + Uppg2.binarySqrt(10000, 10)
				+ " # sqrt 10000 eps 10");
		System.out.println("Den riktiga roten till ovan: " + Math.sqrt(10000)
				+ "\n");
		System.out.println("*" + Uppg2.binarySqrt(1787569, 0.00001)
				+ " # sqrt 1787569 eps 0.00001");
		System.out.println("Den riktiga roten till ovan: " + Math.sqrt(1787569)
				+ "\n");

		/*
		 * How do you test if the method returns the right value without using
		 * Math.sqrt()? Firstly you can implement some other kind of method to
		 * calculate the square root. But this is unnecessary since all you
		 * really have to do is know the answer beforehand.
		 * 
		 * E.g. if you want to find the root of b*b, just use binarySqrt(b*b,
		 * eps) and compare the result to b. Below is the test implementing the
		 * aforementioned method.
		 */
		double a[] = new double[20];
		double eps = 10;
		boolean failed = false;
		for (int i = 0; i < a.length; i++) {
			a[i] = Math.pow(2, i);
			double b = Uppg2.binarySqrt(a[i] * a[i], eps);
			if (Math.abs((b - a[i])) > eps) {
				System.out.println("Broke on: " + a[i]);
				failed = true;
				break;
			}
		}
		if (!failed) {
			System.out.println("Cleared all the non Math.sqrt() tests!");
		}

	}

}
