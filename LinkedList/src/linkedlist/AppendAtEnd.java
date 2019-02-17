package linkedlist;
import java.util.*;

public class AppendAtEnd {
	
	public static void main(String[] args) {
		LinkedList<String> food = new LinkedList<>();
		food.add("Eggs");
		food.add("Bread");
		food.add("Rice");
		Iterator<String> iterate = food.iterator();
		
		while(iterate.hasNext()) {
			String foods = iterate.next();
			System.out.println(foods);
		}
	}

}
