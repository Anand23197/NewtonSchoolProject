package stack;

import java.util.Stack;

public class LaxicographicallyMinimumSubsequences {
    static int[] minimumSubsequences(int[] arr, int k){
        Stack<Integer> st = new Stack<>();
        int len = arr.length;

        for(int i = 0; i<len; i++){
            int val = arr[i];
            //array element should be less than stack peek element
            //valid: (len - i - 1)remaining element should be smaller than requirement
            //requirement: k - st.size
            while(st.size()> 0 && arr[i]< st.peek() && len - i - 1 >= k-st.size() ){
                st.pop();
            }
            if(st.size() < k){
                st.push(val);
            }
        }
        // store in the array from back of stack
        int ans[] = new int[k];
        int i = k - 1;
        while (i>=0){
            ans[i--] = st.pop();
        }
        return  ans;
    }
    public static void main(String[] args) {
        int[] arr = {5,4,5,1,4,3,6,9,5};
        int k = 3;

        int[] ar = minimumSubsequences(arr, k);

        for (int i : ar){
            System.out.print(i + " ");
        }
    }
}
