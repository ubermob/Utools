package utools.printer;

import java.util.Arrays;

/**
 * Implements static methods {@code print()} for output to console.
 *
 * @version 1.0
 */
public class Printer {

	public static void print(Object o) {
		System.out.println(o);
	}

	public static void print(Object[] o) {
		System.out.println(Arrays.toString(o));
	}

	public static void print(byte[] array) {
		System.out.println(Arrays.toString(array));
	}

	public static void print(short[] array) {
		System.out.println(Arrays.toString(array));
	}

	public static void print(int[] array) {
		System.out.println(Arrays.toString(array));
	}

	public static void print(long[] array) {
		System.out.println(Arrays.toString(array));
	}

	public static void print(float[] array) {
		System.out.println(Arrays.toString(array));
	}

	public static void print(double[] array) {
		System.out.println(Arrays.toString(array));
	}

	public static void print(boolean[] array) {
		System.out.println(Arrays.toString(array));
	}

	public static void print(char[] array) {
		System.out.println(Arrays.toString(array));
	}
}