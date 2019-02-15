package ArrayList;

import java.util.List;
import java.util.ArrayList;

public class join {
	

	public static void main(String[] args) {
		List<Integer> integers = new ArrayList<Integer>(10);
		ArrayList<String> strings = new ArrayList<>(5);
		ArrayList<String> merged = new ArrayList<>();
		for ( int i = 0; i < 10; i++) {
			integers.add(i);
		}
		strings.add("first");
		strings.add("second");
		strings.add("third");
		strings.add("and so on");
		strings.trimToSize();
		for (int i = 0; i < strings.size(); i++)
		{
			merged.add(i,strings.get(i));
		}
		int x = merged.size();
		for (int i = 0; i < integers.size(); i++)
		{
			merged.add(i+x, integers.get(i).toString());
		}
		merged.trimToSize();
		System.out.println(merged);
	}
}
