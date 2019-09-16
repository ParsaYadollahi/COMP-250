import javax.sound.midi.SysexMessage;

public class HeapSort {
    public static void heapSort(int arr[]) {
        Max_Heapify max_heap = new Max_Heapify();
        int n = arr.length;
        for (int i = n/2 -1; i >= 0; i--){
            max_heap.max_heapify(arr, n ,i);
        }
        for(int i = n-1; i>=0; i--) {
            max_heap.swap(arr, 0, i);
            max_heap.max_heapify(arr, i, 0);
        }
    }
    public static void printArr(int arr[]){
        int n = arr.length;
        for(int i = 0; i < n; i++){
            System.out.println(arr[i] + " ");
        }
    }
    public static void main(String args[]){
        int arr[] = {26,24,20,18,17,13};
        HeapSort hp = new HeapSort();
        hp.heapSort(arr);
        printArr(arr);
    }
}
