package java8programs;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReverseEachWordOfStrin {

	public static void main(String[] args) {
		//18) Reverse each word of a string using Java 8 streams?
		String str = "Java";
		String[] words = str.split(" ");
		List<String> collect = Arrays.stream(str.split(" ")).map(word -> new StringBuilder(word).reverse().toString()).collect(Collectors.toList());
		System.out.println("collect="+collect);//[avaJ, tpecnoC, fO, ehT, yaD]
		
		
		// 2nd way
		String reverse = Stream.of(str.split(" ")).reduce(" ", (word1, word2)-> word2+" "+word1);
		System.out.println("reverse="+reverse);
		List<String> rev = Arrays.stream(reverse.split(" ")).map(test -> new StringBuilder(test).reverse().toString()).collect(Collectors.toList());
		System.out.println("rev="+rev);
		
		//3rd way
		String stream = Arrays.stream(str.split(" ")).map(word -> new StringBuilder(word+ " ").reverse().toString())
		.reduce("", (a,b)-> b+a);
		System.out.println("stream="+stream);
	}
}
