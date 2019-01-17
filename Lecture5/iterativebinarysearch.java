package Lecture5;

public class iterativebinarysearch {

	public static void main(String[] args) {
		int[] arr = {1,2,3,4,8};
		int pkey = 3;
		System.out.println(binarySearch(arr, pkey));

	}
	public static boolean binarySearch(int[] arr, int pkey) {
		int left = 0;
		int right = arr.length;
		while(right > left+1) {
// splitting arr in 2
			int middle = (int) Math.ceil((right+left)/2);
// determining if in first or second half
			if(arr[middle]> pkey) {
				right = middle;
			} else {
				left = middle;
			}
		}
// finding if it is in the array
		if (arr[left] == pkey) {
			return true;
		} else {
			return false;
		}
	}

}
