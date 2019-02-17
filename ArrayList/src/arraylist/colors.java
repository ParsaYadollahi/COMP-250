package arraylist;

import java.util.ArrayList;
import java.util.Iterator;

public class colors {

	public static void main(String[] args) {
		ArrayList<String> colors = new ArrayList<String>(5);
		colors.add("blue");
		colors.add("orange");
		colors.add("green");
		colors.add("grey");
		colors.add("black");
		colors.add("light");
		
		Iterator<String> iterating = colors.iterator();
		while(iterating.hasNext())
		{
			String color = iterating.next();
			System.out.print(color + " ");
		}
	}

}
