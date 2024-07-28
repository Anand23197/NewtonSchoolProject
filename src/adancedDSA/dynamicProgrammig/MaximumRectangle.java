package adancedDSA.dynamicProgrammig;

import java.util.Stack;

public class MaximumRectangle {
   static int largestRectangelInHistogram(int[] height){
        int n = height.length;
        int[] left = new int[n];
        int[] right = new int[n];

        Stack<Integer> stack = new Stack<>();
        for(int i = 0;i<n;i++){

            while(!stack.isEmpty() && height[stack.peek()] >= height[i]){
                stack.pop();
            }

            if(stack.isEmpty()){
                left[i] = 0;
            }else{
                left[i] = stack.peek()+1;
            }

            stack.push(i);
        }

        while(!stack.isEmpty()) stack.pop();

        for(int i = n-1;i>=0;i--){
            while(!stack.isEmpty() && height[stack.peek()] >= height[i]){
                stack.pop();
            }

            if(stack.isEmpty()){
                right[i] = n-1;
            }else{
                right[i] = stack.peek()-1;
            }

            stack.push(i);
        }

        int max = Integer.MIN_VALUE;

        for(int i = 0;i<n;i++){
            max = Math.max(max, (right[i] - left[i] + 1)* height[i]);
        }
        return max;
    }

    public static int maximalRectangle(char[][] matrix) {

        int maxArea = 0;
        int row = matrix.length;
        int col = matrix[0].length;
        int[] height = new int[col];
        for(int i = 0;i<row;i++){
            for(int j = 0;j<col;j++){
                if(matrix[i][j] == '1'){
                    height[j]++;
                }else{
                    height[j] = 0;
                }
            }
            maxArea = Math.max(maxArea, largestRectangelInHistogram(height));

        }

        return maxArea;
    }
    public static void main(String[] args) {
        char[][] matrix = {{'1','0','1','0','0'},
                            {'1','0','1','1','1'},
                            {'1','1','1','1','1'},
                            {'1','0','0','1','0'}};
        int ans = maximalRectangle(matrix);
        System.out.println(ans);
    }
}
