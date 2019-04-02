package quiz;
import java.util.Map.Entry;
import java.util.Arrays;
import java.util.HashMap;

public class AppearMostOften {

    public static void main(String[] args){
        int[] arr = new int[] {5, 4, 7, 5, 9, 10, 5, 6, 8, 7, 7, 5, 5, 5, 1, 4, 5, 9, 4, 3, 4, 1, 9, 9, 7, 6, 4, 1, 1, 4, 1, 2, 1, 7, 2, 1, 10, 1, 1, 4, 6, 4, 3, 4, 10, 10, 7, 7, 4, 9, 4, 7, 6, 1, 7, 7, 8, 5, 1, 9, 10, 7, 6, 3, 3, 8, 5, 4, 6, 9, 5, 10, 4, 8, 8, 6, 1, 7, 2, 7, 1, 9, 1, 10, 5, 8, 2, 5, 9, 5, 3, 8, 6, 4, 3, 4, 9, 5, 3, 2};
        HashMap<Integer, Integer> brown = new HashMap<>();

        for(int i = 0 ; i < arr.length; i++){
            if (!brown.containsKey(arr[i])){
                brown.put(arr[i], 1);
            } else {
                brown.put(arr[i], brown.get(arr[i])+1);
            }
        }
        int n = track(brown);
        System.out.println("The value that appears the most often in this list is: " + n);
    }
    public static int track(HashMap<Integer, Integer> map){
        int n = map.size();
        int maxKey = 0;
        int maxValue = 0;
        for (int i = 1; i < n; i++){
            if (map.get(i) > maxValue){
                maxValue = map.get(i);
                maxKey = i;
            }
        }
        return maxKey;
    }
}
