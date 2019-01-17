package Lecture5;

public class recursive {
	public static void main(String[] args) {
		
	}
	public static int power(int base, int power)
	{
		if (power == 0)
		{
			return 1;
		}
		else
		{
			return base*power(base, power-1);
		}
	}
}