package A4;
import java.util.*;
import java.io.*;

public class Multiply{

    private static int randomInt(int size) {
        Random rand = new Random();
        int maxval = (1 << size) - 1;
        return rand.nextInt(maxval + 1);
    }

    public static int[] naive(int size, int x, int y) {
        int[] result = new int[2];
        int m, a, b, c, d, e, f, g, h = 0;
        // YOUR CODE GOES HERE  (Note: Change return statement)
        if (size == 1) { // Base case
            result[0] = x * y;
            result[1] = 1;
            return result;
        } else {
            m = (int) Math.ceil((size / 2.0)); // cut size by half
            int power_2 = (int) (Math.pow(2, m)); // move bits by m/2
            int power_2m =   (int) (Math.pow(2, 2*m)); // move bits by m
            a = (int) Math.floor(x/power_2);
            c = (int) Math.floor(y/power_2);
            b = x % power_2;
            d = y % power_2;
            // Grade school math
            int temp1[] = naive(m, a, c); // ac
            int temp2[] = naive(m, b ,d); // bd
            int temp3[] = naive(m, b, c); // bc
            int temp4[] = naive(m, a, d); // ad

            // Store results
            e = temp1[0];
            f = temp2[0];
            g = temp3[0];
            h = temp4[0];

            result[0] = power_2m*e + power_2*(g+h)+f;
            result[1] = 3*m + temp1[1] + temp2[1] + temp2[1] + temp3[1] + temp4[1];

        }
        return result;
    }

    public static int[] karatsuba(int size, int x, int y) {

        // YOUR CODE GOES HERE  (Note: Change return statement)
        int m, a, b, c, d, e, f, g = 0;
        int result[] = new int[2];

        if (size == 1){ // Base case
            result[0] = x*y;
            result[1] = 1;
            return result;
        } else {
            m = (int) Math.floor(size / 2.0); // cut size by half

            int power_2 = (int) (Math.pow(2, m)); // move bits by m/2
            int power_2m =   (int) (Math.pow(2, 2*m)); // move bits by m

            a = (int) Math.floor(x / power_2);
            c = (int) Math.floor(y / power_2);
            b = x % power_2;
            d = y % power_2;

            int[] temp1 = karatsuba(m, a, c); // ac
            int[] temp2 = karatsuba(m, b,d); // bd
            int[] temp3 = karatsuba(m, (a-b), (c-d)); // +(a-b) + (c-d)

            // store results
            e = temp1[0];
            f = temp2[0];
            g = temp3[0];

            result[0] = power_2m * e + (power_2 * (e + f - qg) + f);
            result[1] = 6*m+temp1[1] + temp2[1] + temp3[1];


        }
        return result;
    }
    
    public static void main(String[] args){

        try{
            int maxRound = 20;
            int maxIntBitSize = 16;
            for (int size=1; size<=maxIntBitSize; size++) {
                int sumOpNaive = 0;
                int sumOpKaratsuba = 0;
                for (int round=0; round<maxRound; round++) {
                    int x = randomInt(size);
                    int y = randomInt(size);
                    int[] resNaive = naive(size,x,y);
                    int[] resKaratsuba = karatsuba(size,x,y);
            
                    if (resNaive[0] != resKaratsuba[0]) {
                        throw new Exception("Return values do not match! (x=" + x + "; y=" + y + "; Naive=" + resNaive[0] + "; Karatsuba=" + resKaratsuba[0] + ")");
                    }
                    
                    if (resNaive[0] != (x*y)) {
                        int myproduct = x*y;
                        throw new Exception("Evaluation is wrong! (x=" + x + "; y=" + y + "; Your result=" + resNaive[0] + "; True value=" + myproduct + ")");
                    }
                    
                    sumOpNaive += resNaive[1];
                    sumOpKaratsuba += resKaratsuba[1];
                }
                int avgOpNaive = sumOpNaive / maxRound;
                int avgOpKaratsuba = sumOpKaratsuba / maxRound;
                System.out.println(size + "," + avgOpNaive + "," + avgOpKaratsuba);
            }
        }
        catch (Exception e){
            System.out.println(e);
        }

   } 
}
