package Arrays;
public class InterestRate {

	public static void main(String[] args) {
		System.out.println("Years	" + "FutureValue");
		interest(1000, 10, 5);

	}
	public static void interest(int investment, int rate, int years) {
		double sum = investment;
		for(int i = 1; i <= years; i++) {
			sum = sum + sum*(rate*0.01);
			System.out.println(i + "	" + sum);
		}
	}

}
