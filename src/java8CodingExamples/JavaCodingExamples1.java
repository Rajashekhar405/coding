package java8CodingExamples;

import java.time.Duration;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class duplicateElements {

	public static void main(String[] args) {


		//25) How do you extract duplicate elements from an array?

		List<Integer> listOfIntegers = Arrays.asList(111, 222, 333, 111, 555, 333, 777, 222);

		Set<Integer> uniqueElements = new HashSet<>();
		Set<Integer> uniqueElement = new HashSet<>();

		Set<String> uniqueCharacter = new HashSet<String>();

		Set<Integer> duplicateElements = listOfIntegers.stream().filter(i -> ! uniqueElements.add(i)).collect(Collectors.toSet());

		System.out.println(duplicateElements);

		Set<Integer> duplicateEle = listOfIntegers.stream().filter(y-> !uniqueElement.add(y)).collect(Collectors.toSet());
		System.out.println(duplicateEle);

		String inputString = "Java Concept Of The Day".replaceAll("\\s+", "").toLowerCase();
		Set<String> uniquecharEle = Stream.of(inputString.split("")).filter(d-> !uniqueCharacter.add(d)).collect(Collectors.toSet());
		System.out.println("uniquecharEle== "+ uniquecharEle);

		//27) Find first repeated character in a string?

		String str = "Java Concept Of The Day".replaceAll("\\s+", "").toLowerCase();
		System.out.println(str);
		LinkedHashMap<String, Long> findFirstNonRepeatedChar = Arrays.stream(str.split("")).collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new , Collectors.counting()));
		Optional<String> entry2 = findFirstNonRepeatedChar.entrySet().stream().filter(entry-> entry.getValue() > 1).map(map->map.getKey()).findFirst();
		System.out.println(entry2.get());

		Entry<String, Long> entry = findFirstNonRepeatedChar.entrySet().stream().filter(nm -> nm.getValue() == 1).findFirst().get();
		System.out.println(entry.getKey());


		//29) Fibonacci series
		Stream.iterate(new int[] {0, 1}, f-> new int[] {f[1], f[0]+f[1]}).map(f-> f[0]).limit(10).forEach(rt-> System.out.print(rt +" "));

		//30) First 10 odd numbers
		Stream.iterate(new int[] {1, 3}, v-> new int[] {v[1], v[1]+v[1]+2}).forEach(vv -> System.out.print(vv + " "));

		//31) How do you get last element of an array?
		List<String> listOfStrings = Arrays.asList("One", "Two", "Three", "Four", "Five", "Six");
		String string = listOfStrings.stream().skip(listOfStrings.size()-1).findFirst().get();
		System.out.println(string);


		List<Integer> listOfIntegerss = Arrays.asList(1,2,3,4,5,6,7,8,9);
		Integer lastNumberEvenOrOdd = listOfIntegerss.stream().skip(listOfIntegerss.size()-1).findFirst().get();
		System.out.println(lastNumberEvenOrOdd);
		if(lastNumberEvenOrOdd%2 == 0) {
			System.out.println("even Number");
		}else {
			System.out.println("Odd Number");
		}

//32) Find the age of a person in years if the birthday has given?
		LocalDate birthDay = LocalDate.of(1985, 01, 23);
        LocalDate today = LocalDate.now();
        long between2 = ChronoUnit.YEARS.between(birthDay, today);
        System.out.println(between2);
























	}
}
