package java8programs;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindFrequencyOfEachCharacter {

	public static void main(String[] args) {
		//3) How do you find frequency of each character in a string using Java 8 streams?
		String str = "Umadevi";
		Map<Character, Long> collect = str.chars().mapToObj(c->(char)c).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println(collect);
		
	}
}
