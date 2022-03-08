package Queue;

import java.awt.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class SlidingWIndowUsingDeque {
     public static void printMaximumOfArray(int[] arr, int k){
         int len = arr.length;
         int[] r = new int[len - k + 1];
         int ri = 0;
         //store index
         Deque<Integer> q = new ArrayDeque<>();
         for(int i = 0; i<len; i++){
             //remove numbers out of range k
             if(!q.isEmpty() && q.peek() == i-k){
                    q.poll();
             }
             //remove smaller numbers in k range as they are useless
             while(!q.isEmpty() && arr[q.peek()] < arr[i]){
                q.pollLast();
             }
             q.offer(i);
             if(i>=k -1){
                 r[ri++] = arr[q.peek()];
             }
         }
         for (int j = 0 ; j <len - k +1; j++){
             System.out.print(r[j] + " ");
         }
     }
    public static void main(String[] args) {
        int[] arr = {5, 6, 7, 9, 52, 36, 2, 5, 87, -1};
        int k = 3;
         printMaximumOfArray(arr,k);
    }
}
