package java8programs;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FindSumOfDigit {

	public static void main(String[] args) {
		//13) Find sum of all digits of a number in Java 8?
		int i=123456789;
		int sum = Stream.of(String.valueOf(i).split("")).collect(Collectors.summingInt(Integer::parseInt));
		System.out.println(sum);
		
		int summ = IntStream.range(1, 10).sum();
		System.out.println(summ);
		int summm = IntStream.rangeClosed(1, 10).sum();
		System.out.println(summm);
	}
}
