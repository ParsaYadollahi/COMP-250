package l5;

import java.util.Arrays;

public class mergesort {

	public static void main(String[] args) {
		int[] a = {1,2,3};
		int[] b = {4,2,6,3};
		System.out.println("There are/is " + (mergeSorted(a,b) + " element(s) in common in the two arrays"));
	}
	public static int mergeSorted(int[] a, int[] b) {
		int mergedlength = a.length + b.length;
		int[] merged = new int[mergedlength];
		for( int i = 0; i < a.length; i++) {
			merged[i] = a[i];
		}
		for(int j = 0; j < b.length; j++) {
					merged[a.length + j] = b[j];
		}
		Arrays.sort(merged);
		int sum = 0;
		int pointer = 0;
		while( pointer < merged.length-1) {
			if (merged[pointer] == merged[pointer+1]) {
				sum++;
				pointer += 2;
			} else {
				pointer++;
			}
		}
		return sum;
	}

}
