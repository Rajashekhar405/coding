package java8programs;

import java.util.Arrays;
import java.util.List;

public class ReverseWords {

	public static void main(String[] args) {
		String input =  "Java Concept Of The Day";
		String reversed = reverseWords(input);
		System.out.println(reversed);  // Output: yaD ehT fO tpecnoC avaJ
	}

	public static String reverseWords(String input) {
		List<String> words = Arrays.asList(input.split(" "));
		return words.stream().map((word) -> new StringBuilder(word).reverse().toString())
				.reduce((word1, word2) -> word2 + " " + word1)
				.orElse(" ");
	}
}
