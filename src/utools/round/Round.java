package utools.round;

/**
 * Round floating point number.
 *
 * @version 1.0
 */
public class Round {

	/**
	 * Round floating point number.
	 *
	 * @param value  target value
	 * @param placed numbers after point for round. Value must be positive or zero
	 * @return rounded value
	 * @throws IllegalArgumentException if {@code placed} parameter less than zero
	 */
	public static double round(double value, int placed) throws IllegalArgumentException {
		if (placed < 0) {
			throw new IllegalArgumentException("\'Placed\' value less than 0");
		}
		long factor = (long) Math.pow(10, placed);
		value = value * factor;
		long tmp = Math.round(value);
		return (double) tmp / factor;
	}

	/**
	 * Round floating point number.
	 *
	 * @param value  target value
	 * @param placed numbers after point for round. Value must be positive or zero
	 * @return rounded value
	 * @throws IllegalArgumentException if {@code placed} parameter less than zero
	 */
	public static double roundFloat(float value, int placed) throws IllegalArgumentException {
		if (placed < 0) {
			throw new IllegalArgumentException("\'Placed\' value less than 0");
		}
		long factor = (long) Math.pow(10, placed);
		value = value * factor;
		long tmp = Math.round(value);
		return (float) tmp / factor;
	}
}