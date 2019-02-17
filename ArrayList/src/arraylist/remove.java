package arraylist;

import java.util.*;
public class remove {

	public static void main(String[] args) {
		ArrayList<Integer> arr = new ArrayList<>(5);
		for (int i = 0; i < 6; i++)
		{
			arr.add(i);
		}
		for (int i = 0; i < arr.size(); i++)
		{
			if (arr.get(i) == 3 || arr.get(i) == 2)
			{
				arr.remove(i);
				i--;
			}
		}
		System.out.println(arr);
	}

}
