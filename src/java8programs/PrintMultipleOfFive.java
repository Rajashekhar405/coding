package java8programs;

import java.util.Arrays;
import java.util.List;

public class PrintMultipleOfFive {

	public static void main(String[] args) {
		//7) From the given list of integers, print the numbers which are multiples of 5?
		List<Integer> listOfIntegers = Arrays.asList(45, 12, 56, 15, 24, 75, 31, 89);
		listOfIntegers.stream().filter(i->i%5==0).forEach(System.out::println);
	}
}
