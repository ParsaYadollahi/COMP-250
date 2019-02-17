package arrays;

public class SumOfDigits {

	public static void main(String[] args) {
		int x = 54;
		System.out.println(cleanerSum(x));

	}
	public static int sumOfDigits(int n) {
		int sum = 0;
		if(n < 10) {
			return n;
		} else {
			String s = Integer.toString(n);
			String[] single = s.split("");
			for(int i = 0; i < single.length; i++) {
				sum += Integer.parseInt(single[i]);
			}
			return sum;
		}
	}
	public static int cleanerSum(int n) {
		int sum = 0;
		while(n > 0) {
			sum += n%10;
			n = n/10;
		}
		return sum;
	}
}
