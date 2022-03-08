package Queue;

import java.util.PriorityQueue;
import java.util.Scanner;

public class MinumumCostRope {
    public static void main (String[] args) {
        // Your code here
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for(int i = 0; i<t; i++){

            int ropes = sc.nextInt();
            int[] arr = new int[ropes];
            // taking user input
            for(int j = 0; j<ropes; j++){
                arr[j] = sc.nextInt();
            }
            // make PriorityQueue
            PriorityQueue<Integer> pq = new PriorityQueue<>();

            //add all element in PriorityQueue
            for(int j = 0; j<ropes; j++){
                pq.add(arr[j]);
            }

            int ans = 0;
            //do the operation
            //run till at least two element will remain in PriorityQueue
            while(pq.size() > 1){
                int first = pq.poll();
                int second = pq.poll();
                int sum = first + second;
                ans += sum;
                pq.add(sum);
            }
            System.out.println(ans);
        }

    }
}
