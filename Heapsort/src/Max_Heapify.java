public class Max_Heapify {
    public void max_heapify(int arr[], int n, int i) { //Size of arr = n, root node = i
        int left = 2*i;
        int right = 2*i+1;
        int largest;
        if (left < n && arr[left] > arr[right]) {
                largest = left;
        }
        else {
            largest = i;
        }
        if (right < n && arr[right] > arr[largest]){
            largest = right;
        }
        if (largest != i){
            swap(arr, i , largest);
            max_heapify(arr, n, largest);
        }
    }
    public void swap(int[] heap, int first_pos, int second_pos){
        int temp = heap[first_pos];
        heap[first_pos] = heap[second_pos];
        heap[second_pos] = temp;
    }
}
