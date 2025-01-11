package java8programs;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AddPreFixAndSuFix {

	public static void main(String[] args) {
		//6) Given a list of strings, join the strings with ‘[‘ as prefix, ‘]’ as suffix and ‘,’ as delimiter?
		List<String> stationeryList = Arrays.asList("Pen", "Eraser", "Note Book", "Pen", "Pencil", "Stapler", "Note Book", "Pencil");
		String collect = stationeryList.stream().collect(Collectors.joining(",", "[", "]"));
		System.out.println(collect);
		
	}
}
