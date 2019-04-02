package quiz;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class UniqueValues {

    public static void main(String[] args){
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> newList;
        for (int i = 0; i < 100; i++) {
            int x = (i * 3) % 84 + i;
            list.add(x);
        }
        sort(list);
        newList = removeDuplicates(list);
        displayList(newList);
        System.out.println("There are " + newList.size() + " distinct elements in this list.");
    }

    public static void sort(ArrayList<Integer> list){
        int n = list.size();
        for ( int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-i-1; j++) {
                if (list.get(j) > list.get(j+1)) {
                    swap(list, j, j+1);
                }
            }
        }
    }
    public static void swap(ArrayList<Integer> list, int i, int j) {
        int temp = list.get(j);
        list.remove(j);
        list.add(i, temp);
    }
    public static void displayList(ArrayList<Integer> list){
        int n = list.size();
        for (int i = 0 ; i < n; i++){
            System.out.println(list.get(i));
        }
    }
    public static ArrayList<Integer> removeDuplicates(ArrayList<Integer> list){
        int n = list.size();
        ArrayList<Integer> newList = new ArrayList<>();
        for (int i = 0; i < n-1 ; i++){
            if (!list.get(i).equals(list.get(i+1))) {
                newList.add(list.get(i));
            }
        }
        return newList;
    }
}
