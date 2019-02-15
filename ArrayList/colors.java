package ArrayList;

import java.util.ArrayList;

public class colors {

	public static void main(String[] args) {
		ArrayList<String> colors = new ArrayList<String>(5);
		colors.add("blue");
		colors.add("orange");
		colors.add("green");
		colors.add("grey");
		colors.add("black");
		colors.add("light");
		System.out.println(colors.size());
		System.out.println(colors);
	}

}
