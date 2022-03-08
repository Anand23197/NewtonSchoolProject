package collections.map;

import java.util.HashMap;
import java.util.Map;

public class TwoSumExample {
    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                result[0] = i;
                result[1] = map.get(target - nums[i]);
                return result;
            }
            map.put(nums[i], i);
        }
        return result;
    }
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5};
        int target = 9;
        int[] arr1 = twoSum(arr, target);
        System.out.println(arr1[0]+" " + arr1[1]);
    }
}
