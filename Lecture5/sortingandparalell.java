package Lecture5;

import java.util.Arrays;

public class sortingandparalell {

	public static void main(String[] args) {
		int[] arr1 = {1,2,3};
		int[] arr2 = {4,2,6};
		System.out.println(sortingParallelPointers(arr1, arr2));
	}
	public static boolean sortingParallelPointers(int[] arr1, int[] arr2){
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		for(int i = 0; i < arr1.length-1; i++) {
// need to reset second array's index
			int j = 0;
// loop through elements in second array
			while (j < arr2.length) {
				if( arr1[i] == arr2[j]) {
					return true;	
				} else {
					j++;
				}
			}
		}
		return false;
	}
}
