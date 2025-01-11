package java8programs;

import java.util.Arrays;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

public class EvenOdd {

	public static void main(String[] args) {
		//1) Given a list of integers, separate odd and even numbers?
		List<Integer> listOfIntegers = Arrays.asList(71, 18, 42, 21, 67, 32, 95, 14, 56, 87);
		Set<Entry<Boolean, List<Integer>>> evenOddNumbers = listOfIntegers.stream().collect(Collectors.partitioningBy(x-> x%2 ==0)).entrySet();
		//Set<Entry<Boolean, List<Integer>>> entrySet = evenOddNumbers.entrySet();
		for(Entry<Boolean, List<Integer>> entry : evenOddNumbers) {
			if(entry.getKey()) {
				System.out.println("even Numbers");
				//entry.getValue().stream().forEach(System.out::println);
			}else {
				System.out.println("odd numbers");
				//entry.getValue().stream().forEach(System.out::println);
			}
			for(int i: entry.getValue()) {
				System.out.println(i);
			}
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
