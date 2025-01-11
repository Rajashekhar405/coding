package java8programs;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RemoveDUplicates {

	public static void main(String[] args) {
		//2) How do you remove duplicate elements from a list using Java 8 streams?
		List<String> listOfStrings = Arrays.asList("Java", "Python", "C#", "Java", "Kotlin", "Python");
		listOfStrings.stream().distinct().forEach(System.out::println);
		List<String> collect = listOfStrings.stream().distinct().collect(Collectors.toList());
		System.out.println(collect);
	}
}
