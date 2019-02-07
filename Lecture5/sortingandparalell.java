package Lecture5;

import java.util.Arrays;

public class sortingandparalell {

	public static void main(String[] args) {
		int[] arr1 = {1,2,3};
		int[] arr2 = {4,2,3,5,1};
		System.out.println("The two arrays share " + sortingParallelPointers(arr1, arr2) + " elements in common");
	}
	public static int sortingParallelPointers(int[] arr1, int[] arr2){
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		int i = 0;
		int j = 0;
		int sum = 0;
		while (i < arr1.length && j < arr2.length) {
			if (arr1[i] == arr2 [j]) {
				sum++;
				i++;
				j++;
			} else if (arr1[i] < arr2[j]) {
				i++;
			} else {
				j++;
			}
		}
		return sum;
	}
}
