package stack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class pipeline {
    static void putIntoMax(HashMap<Integer, Integer> frq, HashMap<Integer, Integer> max ){
        int maxkey = 0;
        int maxval = 0;
        for (Map.Entry<Integer, Integer> entry : frq.entrySet()) {
            if (entry.getValue() > maxval) {
                maxkey = entry.getKey();
                maxval = entry.getValue();
            }
        }

        max.put(maxkey, maxval);
    }
    public static void main(String[] args) {
        int q = 6;
        int[][] arr = {{1, 2}, {1, 4}, {1, 3}, {1, 2}, {2, -1}, {2, -1}};
        Stack<Integer> pipeline = new Stack<>();
        HashMap<Integer, Integer> frq = new HashMap<>();
        HashMap<Integer, Integer> max = new HashMap<>();

        ArrayList<Integer> res = new ArrayList<>();

        for (int i = 0; i < q; i++) {
            int x = arr[i][0];
            int n = arr[i][1];

            if (x == 1) {
                pipeline.push(n);
                frq.put(n, frq.getOrDefault(n, 0) + 1);

                //call this function for putting into the max
                putIntoMax(frq, max);


                Map.Entry<Integer, Integer> firstEntry = max.entrySet().iterator().next();
                Integer firstKey = firstEntry.getKey();
                Integer firstValue = firstEntry.getValue();
                if (frq.get(n) > firstValue) {
                    max.remove(firstKey);
                    max.put(n, frq.get(n));
                }



            } else {
                Map.Entry<Integer, Integer> firstEntry = max.entrySet().iterator().next();
                Integer firstKey = firstEntry.getKey();

                int pipilineLastVal = pipeline.peek();
                if (firstKey == pipilineLastVal) {
                    res.add(firstKey);
                    pipeline.pop();
                    frq.put(firstKey, frq.getOrDefault(firstKey, 0) - 1);
                    if (frq.get(firstKey) == 0) {
                        frq.remove(firstKey);
                    }

                    putIntoMax(frq, max);

                } else {
                    int val = pipeline.pop();
                    res.add(val);
                    frq.put(val, frq.getOrDefault(val, 0) - 1);
                    if (frq.get(val) == 0) {
                        frq.remove(val);
                    }

                    putIntoMax(frq, max);
                }
            }

        }

        System.out.println(res);
    }
}
