package sorting;

import java.util.*;
public class InsertionSort {

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 10; i >= 0; i--) {
			list.add(i);
		}
		list.add(5);
		list.add(200);
		list.add(9);
		list.add(6);
		list.add(2);
		list.add(14);
		list.add(7);
		int n = list.size();
		for (int i = 1; i < n; i++) {
			int element = list.get(i);
			int j = i-1;
			while ( j >= 0) {
				if (element < list.get(0)) {
					list.remove(i);
					list.add(0, element);
					break;
				}
				if (element >= list.get(j)) {
					list.remove(i);
					list.add(j+1, element);
					break;
				}
				if (element < list.get(j)) {
					j--;
				}
			}
		}
		System.out.println(list);
	}

}
