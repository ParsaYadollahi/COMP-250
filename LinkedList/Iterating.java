package LinkedList;

import java.util.*;

public class Iterating {

	public static void main(String[] args) {
		LinkedList<Integer> iterate = new LinkedList<>();
		int end = 0;
		for (int i = 0; i < 10; i++) {
			iterate.add(i);
			end++;
		}
		iterate.add(end, 10);
		swap(iterate, 1, 3);
		for (int i = 0; i < iterate.size(); i++) {
			System.out.println("Position " + i + "\t" + iterate.get(i));
		}
	}
	public static void swap(LinkedList<Integer> list, int i, int j) {
		int temp = list.get(i);
		list.add(i,list.get(j));
		list.remove(i+1);
		list.add(j, temp);
		list.remove(j+1);
	}

}
