package java8programs;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class PrintMIN_MAX_AVG_numbers {

	public static void main(String[] args) {
		//8) Given a list of integers, find maximum and minimum of those numbers?
		List<Integer> listOfIntegers = Arrays.asList(45, 12, 56, 15, 24, 75, 31, 89);
		Integer max = listOfIntegers.stream().max(Comparator.naturalOrder()).get();
		Integer min = listOfIntegers.stream().min(Comparator.naturalOrder()).get();
		System.out.println(max +"," + min);
	}
}
