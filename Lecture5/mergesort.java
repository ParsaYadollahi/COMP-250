package Lecture5;

import java.util.Arrays;

public class mergesort {

	public static void main(String[] args) {
		int[] a = {1,2,3};
		int[] b = {4,5,6,7};
		int pkey = 4;
		System.out.println((mergeSorted(a,b, pkey)));
	}
	public static boolean mergeSorted(int[] a, int[] b, int pkey) {
		int mergedlength = a.length + b.length;
		int[] merged = new int[mergedlength];
		for( int i = 0; i < a.length; i++) {
			merged[i] = a[i];
		}
		for(int j = 0; j < b.length; j++) {
					merged[a.length + j] = b[j];
		}
		Arrays.sort(merged);
		for(int k = 0; k < merged.length; k++) {
			if(merged[k] == pkey) {
				return true;
			}
		}
		return false;
	}

}
