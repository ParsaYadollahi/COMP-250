package Iterators;

import java.util.*;
public class basic {

	public static void main(String[] args) {
		ArrayList<String> names = new ArrayList<>();
		names.add("Parsa");
		names.add("Marcel");
		names.add("Jad");
		names.add("Someone");
		
		Iterator<String> iterating = names.iterator();
		
		while(iterating.hasNext())
		{
			String list =  iterating.next();
			System.out.println(list);
		}
	}

}
