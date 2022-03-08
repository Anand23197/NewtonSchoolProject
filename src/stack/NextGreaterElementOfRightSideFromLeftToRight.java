package stack;

import java.util.Stack;

public class NextGreaterElementOfRightSideFromLeftToRight {
    public static void main(String[] args) {
        int[] arr = {2, 6, 8, 26, 1, 56, 89, 21};
        int[] nge = new int[arr.length];

        Stack<Integer> stack = new Stack<>();

        stack.push(0);//push position of the array

        for (int i = 1; i<arr.length ; i++) {
            while (stack.size() > 0 && arr[i] > arr[stack.peek()]) {
                int pos = stack.peek();
                nge[pos] = arr[i];
                stack.pop();
            }
            stack.push(i);
         }
        while(stack.size() > 0){
            int pos = stack.peek();
            nge[pos] = -1;
            stack.pop();
        }
        for(int i : nge){
            System.out.print(i+ " ");
        }
    }
}
