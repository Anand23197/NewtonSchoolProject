package Queue;

import java.util.Deque;
import java.util.LinkedList;

public class MaxAndMinSum {
    static int sumOfKSubArray(int[] arr, int k){
        //initialize result with zero
        int sum = 0;

        //the queue will store indexes of useful elements in ivery window
        //in deque 'G' we maintain decreasing order of values from front to rear
        //in deque 'S' we maintain increasing order of values from front to rear

        Deque<Integer> S = new LinkedList<>(), G = new LinkedList<>();

        //process first window of size k
        int i = 0;
        for(i = 0; i< k; i++){
            //remove all previous greater elements that are useless
            while(!S.isEmpty() && arr[S.peekLast()] >= arr[i]){
                S.removeLast(); //remove from rear
            }

            //remove all previous smaller elements that are useless
            while(!G.isEmpty() && arr[G.peekLast()] <= arr[i]){
                G.removeLast();
            }
                //add current element at rear of both deque
                G.addLast(i);
                S.addLast(i);
        }

        //process rest of the array elements
        for(; i<arr.length; i++){
            //Elements at the front of the deque 'G' & 'S' is the
            //largest and smallest element of previous window respectively

            sum += arr[S.peekFirst()] + arr[G.peekFirst()];

            //remove all element which are out of this window
            while(!S.isEmpty() && S.peekFirst() <= i-k){
                S.removeFirst();
            }
            while(!G.isEmpty() && G.peekFirst() <= i-k){
                G.removeFirst();
            }

            //remove all previous greater element that are useless
            while(!S.isEmpty() && arr[S.peekLast()] >= arr[i]){
                S.removeLast(); //remove from rear
            }
            //remove all previous smaller that are elements are useless
            while(!G.isEmpty() && arr[G.peekLast()] <= arr[i]){
                G.removeLast();
            }
            //add current element at rear of both deque

            G.addLast(i);
            S.addLast(i);
        }

        // sum of minimum and maximum element of last window
        sum += arr[S.peekFirst()] + arr[G.peekFirst()];

        return sum;

    }
    public static void main(String[] args) {
        int[] arr = {2, 5, -1, 7, -3, -1, -2};
        int k = 3;
        System.out.println(sumOfKSubArray(arr,k));
    }

}
