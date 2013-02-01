package Lab1;


/**
 * Class that calculates the square root of a positive number
 * @author Henrik Andersson
 * @author Mike Phoohad
 * group 21
 */

public class Uppg2 {
	/**
	 * Calculates the square root of a positive number greater than or equal to
	 * 1 using the binary search method, within the accuracy of the specified
	 * parameter. Will always consider the accuracy to be the interval between
	 * the parameter and 0 (1 is the same as -1; the absolute value).
	 * 
	 * @param sqr
	 *            The number it finds the root of, must be greater than or equal
	 *            to 1
	 * @param eps
	 *            Defines the accuracy of the result
	 * @return The principal square root of the parameter. Returns -1 if
	 *         parameter is an invalid number (i.e. less than 1)
	 */
	public static double binarySqrt(double sqr, double eps) {
		if (sqr < 1) {
			return -1;
		}
		return help(sqr, Math.abs(eps), 1, sqr);
	}

	private static double help(double sqr, double eps, double low, double high) {
		double centerPoint = (((high - low) / 2) + low);
		double centerPointSquared = centerPoint * centerPoint;

		if (Math.abs(centerPointSquared - sqr) < eps) {
			return centerPoint;
		}
		if (centerPointSquared > sqr) {
			return help(sqr, eps, low, centerPoint);
		} else {

			return help(sqr, eps, centerPoint, high);
		}
	}

}
