package faangProject;
import java.util.Scanner;
public class MinSwaps {
    public static void main(String[] args) {
        // Your code here
        int[] arr = {3, 1, 2, 1, 3, 3};
        int[] arr1 = {1, 2, 3};

        int winSize = arr.length - arr1.length;

        int count = 0;
        for(int i = 0; i<winSize+1 ; i++){
            int mincount = 0;
            for(int j = 0; j<arr1.length ; j++){
                if((arr[i+j] - arr1[j]) == 0){
                    mincount++;
                    count = Math.max(mincount, count);
                }
            }
        }

        System.out.println(arr1.length- count);
        }

}
