package sorting;

public class SelectionSort {
    static  void selection(int[] arr){
        for(int i = 0;i<arr.length-1; i++){
            //assume minimum value is at first index
            int minIndex = i;
            for(int j = i+1; j<arr.length;j++){
                if(arr[j]<arr[i]){
                    minIndex = j;
                }
            }
            //if minimum value found swap with current index
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }
    public static void main(String[] args) {
        int[] arr = {5,4,3,2,1};
        selection(arr);
        for(int i = 0; i<arr.length; i++){
            System.out.println(arr[i]);
        }
    }
}
