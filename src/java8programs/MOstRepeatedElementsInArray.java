package java8programs;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MOstRepeatedElementsInArray {

	public static void main(String[] args) {
		////22) How do you find the most repeated element in an array?
		
		List<String> listOfStrings = Arrays.asList("Pen", "Eraser", "Note Book", "Pen", "Pencil","Pencil", "Pen", "Note Book", "Pencil");
		Map<String,Long> collect = listOfStrings.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		Optional<Entry<String, Long>> max = collect.entrySet().stream().max(Map.Entry.comparingByValue());
		System.out.println(max.get());
		
		Set<Entry<String, Long>> entrySet = listOfStrings.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet();
		Entry<String, Long> entry = entrySet.stream().max(Map.Entry.comparingByValue()).get();
		System.out.println(entry.getKey() +"= "+ entry.getValue());
		
		IntStream.rangeClosed(1, 10).map(c-> c*2).forEach(System.out::println);
		
		int[] array = new int[] {5, 1, 7, 3, 9, 6};
		int[] reversedArray = IntStream.rangeClosed(1, array.length).map(i-> array[array.length - i]).toArray();
		System.out.println(Arrays.toString(reversedArray));
	}
}
