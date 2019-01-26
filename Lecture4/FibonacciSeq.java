package Lecture4;

// A program that calculates fibonacci number
public class FibonacciSeq {

	public static void main(String[] args) {
		System.out.println(fibonacci(8));
	}
public static double fibonacci(int x) {
//	Fibonacci must include 0 to value wanted
		int[] sequence = new int[x+1];
		if(x <= 1) {
			return 1;
		} else {
			sequence[0] = 1;
			sequence[1] = 1;
			for(int i = 2; i <= x; i++) {
				sequence[i] = sequence[i-1] + sequence[i-2]; 	
			}
		}
		return sequence[sequence.length-1];
	}
}
