package Lecture2;
import java.util.Arrays;

public class longAddition {

	public static void main(String[] args) {
		int[] arr1 = {1,2,1};
		int[] arr2 = {2,9,9};
		System.out.println(Arrays.toString(sum(arr1, arr2)));
		
	}
	
	
	public static int[] sum(int[] arr1, int[] arr2) {
		
		int[] carry = new int[arr1.length+1];
		int[] sum = new int[arr1.length+1];
		
		for(int i = 0; i < arr1.length; i++) {
			carry[i+1] = (arr1[i] + arr2[i])/10;
			
			if(carry[i+1] >= 1) {
				sum[i+1] += carry[i+1];
				sum[i] += (arr1[i] + arr2[i])%10;
			} else {
				sum[i] += (arr1[i] + arr2[i])%10;
				if(sum[i] >= 10) {
					System.out.println("in");
					carry[i+1] += sum[i]/10;
					sum[i] = (arr1[i] + arr2[i] + carry[i])%10;
					sum[i+1] += carry[i+1];
				}
			}
		}
		
//	Printing out the integer addition
		System.out.println("The additioned arrays in interger are:");
		for(int k = arr1.length-1; k >= 0 ; k--) {
			if(arr1[arr1.length-1] == 0 && arr1[k] == 0) {
			System.out.print("");
			} else {
				System.out.print(arr1[k]);
			}
		}
		System.out.print(" + ");
		
		for(int m = arr2.length-1; m >= 0 ; m--) {
			if(arr2[arr2.length-1] == 0 && arr2[m] == 0) {
			System.out.print("");
			} else {
				System.out.print(arr2[m]);
			}
		}
		System.out.print(" = ");
		
		for(int j = sum.length-1; j >= 0 ; j--) {
			if(sum[sum.length-1] == 0 && sum[j] == 0) {
			System.out.print("");
			} else {
				System.out.print(sum[j]);
			}
		}
		System.out.println();
		System.out.println("the associated array to that integer is:");
		return sum;
	}
}
