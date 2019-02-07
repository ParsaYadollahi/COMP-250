// Program that reverses a String by its words
public class reverseString {

	public static void main(String[] args) {
		String sentence = "This is a test to find ifthe reverse works";
		reverse(sentence);
	}
	public static void reverse(String s) {
		if (s == "") {
			System.out.println("No String");
		} else {
			String[] arrString = s.split(" ");
			for(int i = arrString.length-1 ; i >= 0 ; i--) {
				System.out.print((arrString[i]) + " ");
			}
			System.out.println();
		}
	}
}
