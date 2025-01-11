package java8programs;

import java.util.Arrays;

public class CheckPalindrome {

	public static void main(String[] args) {
		//23) Palindrome program using Java 8 streams
		String str = "ROTATORS";
		String reduce = Arrays.stream(str.split("")).reduce("", (a,b)-> b+a);
		System.out.println("reduce="+reduce);
		String collect = Arrays.stream(str.split("")).map(d-> new StringBuilder(d).reverse().toString()).reduce("", (m,n)-> n+m);
		System.out.println("collect="+collect);
		
		String reverse = "";
		for(char c: str.toCharArray()) {
			reverse=c+reverse;
		}
		System.out.println(reverse);
		if(str.equals(reduce)) {
			System.out.println("Palindrome");
		}else {
			System.out.println("Not a Palindrome");
		}
	}
}
