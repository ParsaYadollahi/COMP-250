package quiz;
import java.util.Arrays;
public class LinearProbing {

    private int[] arr = new int[10];

    public LinearProbing(){
        for (int i = 0; i < 10; i++){
            arr[i] = 0;
        }
    }

    public int hash(int n){
        return n%10; // Return the key of the hash
    }
    public void insert(int key, int value){
        int index = hash(key);
        while (arr[index] != 0){
            index++;
            if (index == arr.length){
                index = 0;
            }
        }
        arr[index] = value;
    }

    public int getValue(int index){
        return arr[index];
    }
}
