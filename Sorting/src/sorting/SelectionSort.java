package sorting;

import java.util.*;

public class SelectionSort {

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();

		for (int i = 10; i >= 0; i--) {
			list.add(i);
		}
		int n = list.size();
		for (int i = 0; i < n-1; i++) {
			int min = i;
			for(int j = i; j < n; j++) {
				if ( list.get(j) < list.get(min)) {
					min = j;
				}
			}
			swap(list, i, min);
		}
		System.out.println(list);
	}
		
	public static void swap(ArrayList<Integer> list, int first, int second) {
		int temp = list.get(first);
		list.add(first, list.get(second));
		list.remove(first+1);
		list.add(second,temp);
		list.remove(second+1);
	}

}
