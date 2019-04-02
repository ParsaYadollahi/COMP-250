package quiz;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Arrays;

public class SimilaritiesHash {
    public static void main(String[] args) {
        String[] arr1 = new String[]{"Apple", "Orange", "Grape", "Banana", "Watermelon", "Peach"};
        String[] arr2 = new String[]{"Watermelon", "Pear", "Banana", "Peach", "Kiwi", "Melon"};
        HashMap<String, String> map = new HashMap<>();
        ArrayList<String> list = new ArrayList<>();

        for (String anArr1 : arr1) {
            if (!map.containsKey(anArr1)) {
                map.put(anArr1, anArr1);
            }
        }
        for (String anArr2 : arr2) {
            if (map.containsKey(anArr2)) {
                list.add(anArr2);
            }
        }
        for (String aList : list) {
            System.out.println(aList);
        }
    }
}
