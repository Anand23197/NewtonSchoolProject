package stack;

import java.util.Scanner;
import java.util.Stack;

public class SubArrayMinima {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        long arr[] = new long[n];

        for(int i = 0; i<n ; i++){
            arr[i] = sc.nextLong();
        }

        Stack<Integer> stack = new Stack<>();

        long left[] = new long[n];
        long right[] = new long[n];

        //initial value of left and right array
        for(int i = 0; i<n ;i++){
            left[i] = i+1;
            right[i] = n-i;
        }

        //previous less element
        for(int i = 0 ; i<n; i++) {
            while (!stack.empty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }
            if (!stack.empty()) {
                left[i] = i - stack.peek();
            }
            stack.push(i);
        }
        stack.clear();

        //next less element

        for(int i = 0; i<n; i++){
            while (!stack.empty() && arr[stack.peek()] > arr[i]){
                right[stack.peek()] = i - stack.peek();
                stack.pop();
            }
            stack.push(i);
        }

        long result = 0;
        for(int i= 0; i<n; i++){
            result = result + (arr[i] * left[i] * right[i] );
        }
        System.out.println(result);
    }
}
