package java8programs;

import java.util.Arrays;

public class FindSumAvgOfIntArray {

	public static void main(String[] args) {
		//16) Given an integer array, find sum and average of all elements?
		int[] a = new int[] {45, 12, 56, 15, 24, 75, 31, 89};
		int sum = Arrays.stream(a).sum()
				;
		System.out.println(sum);
		double asDouble = Arrays.stream(a).average().getAsDouble();
		System.out.println(asDouble);
	}
}
