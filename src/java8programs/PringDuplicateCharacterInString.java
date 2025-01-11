package java8programs;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PringDuplicateCharacterInString {

	public static void main(String[] args) {
		//26) Print duplicate characters in a string?
		Set<Character> uniqueChar = new HashSet<>();
		String inputString = "Java Concept Of The Day";
		String input = inputString.replaceAll("\\s+", "").toLowerCase();
		System.out.println(input);
		Set<Character> collect = input.chars().mapToObj(c->(char)c).filter(a-> !uniqueChar.add(a)).collect(Collectors.toSet());
		System.out.println(collect);
		
		
		//27) Find first repeated character in a string?
		
		Set<Entry<Character, Long>> collect2 = input.chars().mapToObj(c->(char)c).collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new,  Collectors.counting())).entrySet();
		Entry<Character, Long> first = collect2.stream().filter(map-> map.getValue()>1).findFirst().get();
		System.out.println(first.getKey());
		
		
		//28) Find first non-repeated character in a string?
		input="javaconceptoftheday";
		Map<String, Long> entrySet = Arrays.stream(input.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		String string = entrySet.entrySet().stream().filter(z-> z.getValue() ==1).map(z->z.getKey()).findFirst().get();
		//String entry = entrySet.stream().filter(map->map.getValue()==1).map(a-> a.getKey()).findFirst().get();
		System.out.println(string);		
		
		String inputString1 = "Java Concept Of The Day".replaceAll("\\s+", "").toLowerCase();
        
        Map<String, Long> charCountMap = 
                            Arrays.stream(inputString1.split(""))
                                    .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));
         
        String firstNonRepeatedChar = charCountMap.entrySet()
                                                .stream()
                                                .filter(entry1 -> entry1.getValue() == 1)
                                                .map(entry1 -> entry1.getKey())
                                                .findFirst()
                                                .get();
         
        System.out.println(firstNonRepeatedChar);
        
        //	29) Fibonacci series
        
        
        //30) First 10 odd numbers
        IntStream.rangeClosed(1, 20).filter(d-> d%2!=0).forEach(System.out::println);
        
        
        //31) How do you get last element of an array?
        List<String> listOfStrings = Arrays.asList("One", "Two", "Three", "Four", "Five", "Six");
        String string2 = listOfStrings.stream().skip(listOfStrings.size()-1).findFirst().get();
        System.out.println(string2);
        
        
        
        
        
        
        
        
        
	}
}
