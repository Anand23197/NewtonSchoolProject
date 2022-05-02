package adancedDSA.heaps;

public class HeapSortImplementation {
    public static void main(String[] args) {
        int[] arr = {6,3,2,5,2,7,3,4};
        heapSort(arr, arr.length);
        printArray(arr, 0, arr.length);
    }
    static void printArray(int[] arr, int x, int y){
        for(int i = x ;i<y; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    static void heapSort(int[] arr, int n){
        //i = last valid root from where i have to heapify.
        //this loop make max heap
        for(int i = n/2-1; i>=0; i--){
            heapify(arr, n, i);
        }
        //this is for removing the top element from the array because top will be greatest
        //and adding last of the array
        for(int i = n-1;i>=0; i--){
            swap(arr, i, 0);
            heapify(arr, i, 0);
        }
    }
    static void swap(int[] arr, int x, int y){
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
    // i = root of the tree
    static void heapify(int[] arr, int n, int i){
        int left = 2*i + 1;
        int right = 2*i + 2;
        int largest = i;

        if(left < n && arr[left] > arr[largest]){
            largest = left;
        }
        if(right < n && arr[right]> arr[largest]){
            largest = right;
        }
        //i will only swap when largest not equal to i. means largest can be left or right then only we swap
       if(largest != i) {
           swap(arr, i, largest);
           //after swapping again call heapify
           heapify(arr, n, largest);
       }
    }
}
