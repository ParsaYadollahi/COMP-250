package Arrays;

public class middleChar {

	public static void main(String[] args) {
		String word = "rere got beat";
		System.out.println(middle(word));

	}
	public static String middle(String word) {
		if(word.length() == 0) {
			System.out.println("There is no word");
		}
		String[] seperated = word.split("");
		int length = seperated.length;
		System.out.println("The word contains " + word.length() + " chars");
		if (length%2 == 0) {
			return seperated[length/2 +1];
		} else {
			return seperated[length/2];
		}
	}
}
