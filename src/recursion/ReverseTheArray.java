package recursion;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ReverseTheArray {
    public static void main(String[] args) {
        int[] arr = {11, 2, 10};
        int[] newArr = new int[arr.length];
        System.out.println(Arrays.toString(reverseArray(newArr,arr, 0)));
    }
    static int[] reverseArray(int[] newArr,int[] arr,int index){
        if(index == arr.length){
            return newArr;
        }
        newArr[arr.length - index - 1] = arr[index];
        return reverseArray(newArr, arr,index+1);
    }
}
