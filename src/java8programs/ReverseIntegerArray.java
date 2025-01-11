package java8programs;

import java.util.Arrays;
import java.util.stream.IntStream;

public class ReverseIntegerArray {

	public static void main(String[] args) {
		//20) Reverse an integer array
		int[] array = new int[] {5, 1, 7, 3, 9, 6};
		int[] reverse = IntStream.rangeClosed(1, array.length).map(x-> array[array.length-x]).toArray();
		System.out.println(Arrays.toString(reverse));
		int[] array2 = IntStream.rangeClosed(1, array.length).map(i-> array[array.length-i]).toArray();
		System.out.println(Arrays.toString(array2));
	}
}
