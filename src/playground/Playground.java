package playground;

import java.util.Arrays;
import java.util.HashMap;

public class Playground {
    public static void main(String[] args) {
        int[] arr = {4,5,1,3,2};
        HashMap<Integer, Integer> hm = new HashMap<>();

        //put number and index in hash map;
        for(int i = 0;i<arr.length;i++){
            hm.put(arr[i], i);
        }

        Arrays.sort(arr);

        for(int i = 0;i<arr.length;i++){
            System.out.print(hm.get(arr[i]) + " ");
        }

    }
}
