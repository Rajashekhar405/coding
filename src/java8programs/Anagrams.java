package java8programs;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Anagrams {

	public static void main(String[] args) {
		//12) Java 8 program to check if two strings are anagrams or not?
		String s1 = "RaceCarr";
		String s2 = "CarRace";
		if(s1.length() == s2.length()) {
			s1 = Arrays.stream(s1.split("")).sorted().map(String::toUpperCase).collect(Collectors.joining());
			s2 = Arrays.stream(s2.split("")).sorted().map(String::toUpperCase).collect(Collectors.joining());
			if(s1.equals(s2)) {
				System.out.println("Anagrams");
			}else {
				System.out.println("Not Anagrams");
			}
		}
		else {
			System.out.println("Not Anagrams");
		}
	}
}
