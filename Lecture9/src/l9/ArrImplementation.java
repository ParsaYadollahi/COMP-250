package l9;

public class ArrImplementation {

	public int length;
	public int[] elements;
	
	public ArrImplementation() {
		length = 0;
		elements = new int[1000];
	}
	public static int length(ArrImplementation list) {
		assert list != null;
		return list.length;
	}
	public static int get(ArrImplementation list, int position) {
		assert list != null;
		assert position < list.length;
		return list.elements[position];
	}
	public static void add(ArrImplementation list, int position, int element) {
		assert list != null && position < list.length;
		assert list.length != list.elements.length;
		
// Can add element like follows
//		Needa shift the elements up
		for (int i = list.length-1; i >= position; i++) {
			list.elements[i+1] = list.elements[i];
		}
//		append length
		list.length++;
//		Insert element at position
		list.elements[position] = element;
	}
	public static void main(String[] args) {
		ArrImplementation elements = new ArrImplementation();
		System.out.println(ArrImplementation.get(elements, 0));
	}
}
