package java8programs;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Find2NDLargestNumberInArray {

	public static void main(String[] args) {
		//14) Find second largest number in an integer array?
		List<Integer> listOfIntegers = Arrays.asList(45, 12, 56, 15, 24, 75, 31, 89);
		Integer secondLargestNuber = listOfIntegers.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst().get();
		System.out.println(secondLargestNuber);
	}
}
