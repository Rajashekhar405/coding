package java8CodingExamples;

import java.util.Arrays;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class JavaCodingExample {

	private static List<Double> collect3;

	public static void main(String[] args) {
		//1) Given a list of integers, separate odd and even numbers?
		List<Integer> listOfIntegers = Arrays.asList(71, 18, 42, 21, 67, 32, 95, 14, 56, 87, 87);
		Set<Entry<Boolean, List<Integer>>> partionExample = listOfIntegers.stream().collect(Collectors.partitioningBy(i-> i%2 ==0)).entrySet();
		for(Map.Entry<Boolean, List<Integer>> entry: partionExample) {
			System.out.println("--------");
			if(entry.getKey()) {
				System.out.println("===even===");
				//entry.getValue().forEach(System.out::println);
			}else {
				System.out.println("====odd======");
				//entry.getValue().forEach(System.out::println);
			}
		}
		System.out.println("remove duplicates.");
		//2) How do you remove duplicate elements from a list using Java 8 streams?
		List<String> listOfStrings = Arrays.asList("Java", "Python", "C#", "Java", "Kotlin", "Python");
		listOfStrings.stream().distinct().forEach(System.out::println);
		listOfIntegers.stream().distinct().forEach(System.out::println);
		
		//3) How do you find frequency of each character in a string using Java 8 streams?
		Map<Character, Long> collect = "Rajashekhar".chars().mapToObj(c ->(char)c).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		//System.out.println(collect);
		
		//4) How do you find frequency of each element in an array or a list?
		List<String> stationeryList = Arrays.asList("Pen", "Eraser", "Note Book", "Pen", "Pencil", "Stapler", "Note Book", "Pencil");
		Map<String,Long> collect2 = stationeryList.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		//System.out.println(collect2);
		
		//5) How do you sort the given list of decimals in reverse order?
		List<Double> decimalList = Arrays.asList(12.45, 23.58, 17.13, 42.89, 33.78, 71.85, 56.98, 21.12);
		collect3 = decimalList.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
		//System.out.println(collect3);
		
		//6) Given a list of strings, join the strings with ‘[‘ as prefix, ‘]’ as suffix and ‘,’ as delimiter?
		String collect4 = stationeryList.stream().collect(Collectors.joining(",", "[", "]"));
		//System.out.println(collect4);
		
		//7) From the given list of integers, print the numbers which are multiples of 5?
		System.out.println("--------");
		listOfIntegers.stream().filter(x-> x%5 == 0).forEach(System.out::println);
		
		//8) Given a list of integers, find maximum and minimum of those numbers?
		DoubleSummaryStatistics collect5 = listOfIntegers.stream().collect(Collectors.summarizingDouble(Integer::intValue));
		System.out.println(collect5.getMax());
		System.out.println(collect5.getMin());
		
		//9) How do you merge two unsorted arrays into single sorted array using Java 8 streams?
		int[] a = new int[] {4, 2, 7, 1, 1};
        int[] b = new int[] {8, 3, 9, 5, 5};
        int[] c = IntStream.concat(Arrays.stream(a), Arrays.stream(b)).toArray();
        //System.out.println(Arrays.toString(c));
        int[] d = IntStream.concat(Arrays.stream(a), Arrays.stream(b)).sorted().toArray();
        //System.out.println(Arrays.toString(d));
        int[] e = IntStream.concat(Arrays.stream(a), Arrays.stream(b)).distinct().sorted().toArray();
        //System.out.println(Arrays.toString(e));
		
		//11) How do you get three maximum numbers and three minimum numbers from the given list of integers?
        System.out.println("----MIN---");
        listOfIntegers.stream().sorted(Comparator.naturalOrder()).limit(3).forEach(System.out::println);
        System.out.println("----MAX---");
        listOfIntegers.stream().sorted(Comparator.reverseOrder()).limit(3).forEach(System.out::println);
		
		//12) Java 8 program to check if two strings are anagrams or not?

        String s1 = "RaceCar";
        String s2 = "CarRace";
        s1 = Arrays.stream(s1.split("")).sorted().map(String::toLowerCase).collect(Collectors.joining(""));
        s2 = Arrays.stream(s2.split("")).sorted().map(String::toLowerCase).collect(Collectors.joining(""));
		if(s1.equals(s2)) {
			System.out.println("Anagram");
		}else {
			System.out.println("Not a Anagram");
		}
		String s11 = Stream.of(s1.split("")).sorted().map(String::toLowerCase).collect(Collectors.joining(""));
		String s12 = Stream.of(s2.split("")).sorted().map(String::toLowerCase).collect(Collectors.joining(""));
		if(s11.equals(s12)) {
			System.out.println("Anagrammm");
		}
		
//		13) Find sum of all digits of a number in Java 8?
		int n = 15623;
		Integer collect6 = Stream.of(String.valueOf(n).split("")).collect(Collectors.summingInt(Integer::parseInt));
		System.out.println(collect6);
		Stream.of(String.valueOf(n).split("")).collect(Collectors.summingInt(Integer::parseInt));
		
		//14) Find second largest number in an integer array?
		Integer sorted = listOfIntegers.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst().get();
		//System.out.println(sorted);
		
		//15) Given a list of strings, sort them according to increasing order of their length?
		stationeryList.stream().distinct().sorted(Comparator.comparing(String::length)).forEach(System.out::println);
		
		//16) Given an integer array, find sum and average of all elements?
		int[] f = new int[] {45, 12, 56, 15, 24, 75, 31, 89};
		int sum = IntStream.of(f).sum();
		System.out.println(sum);
		double avg = IntStream.of(f).average().getAsDouble();
		System.out.println(avg);
		
		//17) How do you find common elements between two arrays?
		List<Integer> list1 = Arrays.asList(71, 21, 34, 89, 56, 28);
        List<Integer> list2 = Arrays.asList(12, 56, 17, 21, 94, 34);
        list1.stream().filter(list2::contains).forEach(System.out::println);
		
		//18) Reverse each word of a string using Java 8 streams?
        String str = "Java Concept Of The Day";
        String collect7 = Stream.of(String.valueOf(str).split(" ")).map(i -> new StringBuilder(i).reverse()).collect(Collectors.joining(" "));
        System.out.println(collect7);
		String collect8 = Arrays.stream(str.split(" ")).map(z-> new StringBuilder(z).reverse()).collect(Collectors.joining(" "));
		System.out.println(collect8);
		
		//19) How do you find sum of first 10 natural numbers?
		int sum2 = IntStream.rangeClosed(1, 10).sum();
		System.out.println(sum2);
		
		//20) Reverse an integer array
		int[] array = new int[] {5, 1, 7, 3, 9, 6};
		int[] array2 = IntStream.rangeClosed(1, array.length).map(g-> array[array.length - g]).toArray();
		System.out.println(Arrays.toString(array2));
		
		//21) Print first 10 even numbers
		IntStream.rangeClosed(1, 10).map(r-> r*2).forEach(System.out::println);
		
		//22) How do you find the most repeated element in an array?
		Map<String, Long> mostFreqEle = stationeryList.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		Entry<String, Long> entry = mostFreqEle.entrySet().stream().max(Map.Entry.comparingByValue()).get();
		System.out.println(entry.getKey() +", " + entry.getValue());
		List<String> listOfStringss = Arrays.asList("Pen", "Eraser", "Note Book", "Pen", "Pencil", "Pen", "Note Book", "Pencil");
        
        //23) Palindrome program using Java 8 streams
		String strr = "anna";
		String reverse = Stream.of(strr.split(" ")).map(st -> new StringBuilder(st).reverse()).collect(Collectors.joining(" "));
		if(strr.equalsIgnoreCase(strr)) {
			System.out.println("palindrome");
		}else {
			System.out.println("Not a Palindrome");
		}
		boolean isPalindrome = IntStream.range(0, strr.length()/2).noneMatch(t-> strr.charAt(t) != strr.charAt(strr.length()-t-1));
		if(isPalindrome) {
			System.out.println(strr + "isPalindrome");
		}
		else {
			System.out.println(strr + "Not isPalindrome");
		}
		
		//24) Given a list of strings, find out those strings which start with a number?
		List<String> listOfString = Arrays.asList("One", "2wo", "3hree", "Four", "5ive", "Six");
		listOfString.stream().filter(sr -> Character.isDigit(sr.charAt(0))).forEach(System.out::println);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
