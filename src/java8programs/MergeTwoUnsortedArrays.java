package java8programs;

import java.util.Arrays;
import java.util.stream.IntStream;

public class MergeTwoUnsortedArrays {

	public static void main(String[] args) {
		//9) How do you merge two unsorted arrays into single sorted array using Java 8 streams?
		int[] a = new int[] {4, 2, 7, 1, 1};
        int[] b = new int[] {8, 3, 9, 5, 2, 7};
        int[] c = IntStream.concat(Arrays.stream(a), Arrays.stream(b)).toArray();
        System.out.println(Arrays.toString(c));
        int[] d = IntStream.concat(Arrays.stream(a), Arrays.stream(b)).sorted().toArray();
        System.out.println(Arrays.toString(d));
        
        int[] e = IntStream.concat(Arrays.stream(a), Arrays.stream(b)).distinct().sorted().toArray();
        System.out.println(Arrays.toString(e));
	}
}
