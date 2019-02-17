package sorting;

import java.util.*;
public class BubbleSort {

	public static void swap(ArrayList<Integer> list, int i, int j) {
		int temp = list.get(j);
		list.remove(j);
		list.add(i, temp);
	}
	
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 10; i >= 0; i--) {
			list.add(i);
		}
		int n = list.size();
		for ( int i = 0; i < n-1; i++) {
			for (int j = 0; j < n-i-1; j++) {
				if (list.get(j) > list.get(j+1)) {
					swap(list, j, j+1);
				}
			}
		}
		System.out.println(list);
	}
}
