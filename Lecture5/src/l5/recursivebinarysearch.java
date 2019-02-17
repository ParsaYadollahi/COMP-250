package l5;

import java.util.Arrays;

public class recursivebinarysearch {

	public static void main(String[] args) {
		int[] arr = {1,2,3,4,6};
		int pkey = 6;
		System.out.println(binarySearch(arr, pkey));

	}
	public static boolean binarySearch(int[] arr, int pkey) {
// Base case
		if (arr.length <= 1) {
			return arr[0] == pkey;
		} else {
			int left = 0;
			int right = arr.length;
			int middle = (left+right)/2;
			
// Cut the array in half using its own method
			if (pkey > arr[middle-1]) {
				return binarySearch(Arrays.copyOfRange(arr, middle, arr.length), pkey);
			} else {
				return binarySearch(Arrays.copyOfRange(arr, 0, middle), pkey);
			}
		}
	}

}
