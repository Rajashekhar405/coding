package java8programs;

import java.util.stream.IntStream;

public class FindSumOfNaturalNumbers {

	public static void main(String[] args) {
		//19) How do you find sum of first 10 natural numbers?
		int sum = IntStream.rangeClosed(1, 10).sum();
		System.out.println(sum);
	}
}
