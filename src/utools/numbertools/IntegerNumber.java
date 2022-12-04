package utools.numbertools;

/**
 * @author Andrey Korneychuk on 20-Sep-21
 * @version 1.0
 */
public class IntegerNumber {

	/**
	 * @param number checked number
	 * @return true - if floating number is integer (example: 2.0).
	 * false - if floating number is not integer (example: 2.25).
	 */
	public static boolean isIntegerNumber(double number) {
		return number - Math.round(number) == 0;
	}

	/**
	 * @param number checked number
	 * @return true - if floating number is integer (example: 2.0).
	 * false - if floating number is not integer (example: 2.25).
	 */
	public static boolean isIntegerNumber(float number) {
		return number - Math.round(number) == 0;
	}
}