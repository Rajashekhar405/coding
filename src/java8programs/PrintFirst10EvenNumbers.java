package java8programs;

import java.util.stream.IntStream;

public class PrintFirst10EvenNumbers {

	public static void main(String[] args) {
		//21) Print first 10 even numbers
		IntStream.rangeClosed(1, 10).map(i-> i * 2).forEach(System.out::println);
	}
}
