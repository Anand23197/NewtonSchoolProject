package hashing;

import java.util.HashSet;

public class ThreeSome {

    public static boolean find3Numbers(int[] A, int arr_size, int sum)
    {
     for(int i = 0;i<arr_size-2;i++){
         HashSet<Integer> hs = new HashSet<>();
         int curSum = sum - A[i];

         for(int j = i+1;j<arr_size;j++){
               int prSum = curSum - A[j];

               if(hs.contains(prSum)){
                   System.out.println("number is" + A[i] + " " + A[j] + " " + prSum);
                   return true;
               }
               hs.add(A[j]);
         }
     }
     return false;
    }

    public static void main(String[] args) {
        int[] A = { 1, 4, 45, 6, 10, 8 };
        int sum = 22;
        int arr_size = A.length;

        // Call the find3Numbers function to find and print
        // the triplet, if it exists
        if (!find3Numbers(A, arr_size, sum)) {
            System.out.println(
                    "No triplet found with the given sum.");
        }

    }
}
