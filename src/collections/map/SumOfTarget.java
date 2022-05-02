package collections.map;

import java.util.HashMap;
import java.util.Map;

public class SumOfTarget {
    public static void main(String[] args) {
        int[] arr = {12, 3, 4, 1, 6, 9};
        int target = 24;
        int sum = 0;
        for(int i = 0; i<arr.length; i++){
           sum +=arr[i];
            for(int j = i+1; j < arr.length ; j++){
                    sum += arr[j];
                    if(sum == target) {
                        System.out.println();
                        break;
                    }
            }
        }
    }
}
