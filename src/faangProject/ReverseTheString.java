package faangProject;

public class ReverseTheString {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        printSubArray(arr, 0, 0);
    }
    static  void printSubArray(int[] arr, int start, int end){
        if(end == arr.length){
            return;
        }else if (start>end){
            printSubArray(arr, 0, end + 1);
        }else
            if (start == end){
                for (int i = start;i<=end; i++){
                    System.out.println(arr[i] + " ");
                    printSubArray(arr, start + 1, end);
                }
            }else {
                for (int i = start; i < end; i++) {
                    System.out.print(arr[i] + " ");
                }
                printSubArray(arr, start + 1, end);
            }

    }
}
