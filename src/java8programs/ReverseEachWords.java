package java8programs;

import java.util.Arrays;

public class ReverseEachWords {

	public static void main(String[] args) {
		String input = "Java Concept Of The Day";

		// Split the string into words, reverse each word, and join them back into a single string
		String result = Arrays.stream(input.split(" "))
				.map(word -> new StringBuilder(word).reverse().toString())
				.reduce((word1, word2) -> word1 + " " + word2)
				.orElse("");

		System.out.println(result);  // Output: avaJ tpecnoC fO ehT yaD
	}

}
