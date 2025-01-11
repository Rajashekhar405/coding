package java8programs;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ThreeMaxAndThreeMin {

	public static void main(String[] args) {
		//11) How do you get three maximum numbers and three minimum numbers from the given list of integers?
		List<Integer> listOfIntegers = Arrays.asList(45, 12, 56, 15, 24, 75, 31, 89);
		listOfIntegers.stream().sorted().limit(3).forEach(System.out::println);
		listOfIntegers.stream().sorted(Comparator.reverseOrder()).limit(3).forEach(System.out::println);
	}
}
