
public class NumberOfWords {

	public static void main(String[] args) {
		String sentence = "This is a test for the number of words";
		wordCount(sentence);
	}
	public static void wordCount(String sentence) {
		String[] words = sentence.split(" ");
		System.out.println("The number of words in this String is " + words.length);
	}

}
