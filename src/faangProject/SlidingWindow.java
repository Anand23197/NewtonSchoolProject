package faangProject;

public class SlidingWindow {
    static void printKMax(int[] arr, int k){
        int max,j;
        for(int i = 0;i<=arr.length-k;i++){
            max = arr[i];
            for(j = 1; j<k;j++){
                if(arr[i+j]>max){
                    max = arr[i+j];
                }
            }
            System.out.print(max + " ");
        }
    }
    public static void main(String[] args) {
        int[] arr = {5, 7, 6, 9, 3, 2, 5, 4, 5, 6, 9};
        int k = 3;
        printKMax(arr, k);
    }
}
