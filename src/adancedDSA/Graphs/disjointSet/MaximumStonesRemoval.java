package adancedDSA.Graphs.disjointSet;

import java.util.HashMap;
import java.util.Map;


class Solution {
    int maxRemove(int[][] stones, int n) {
        // Code here
        int maxRow = 0;
        int maxCol = 0;
        for(int i = 0;i<n;i++){
            maxRow = Math.max(maxRow, stones[i][0]);
            maxCol = Math.max(maxCol, stones[i][1]);
        }

        DisjointSet ds = new DisjointSet(maxRow+maxCol+1);
        HashMap<Integer, Integer> stoneNodes = new HashMap<>();

        for(int i = 0;i<n;i++){
            int nodeRow = stones[i][0];
            int nodeCol = stones[i][1]+maxRow+1;
            ds.unionBySize(nodeRow, nodeCol);

            stoneNodes.put(nodeRow, 1);
            stoneNodes.put(nodeCol, 1);
        }

        int cnt = 0;

        for(Map.Entry<Integer, Integer> entry : stoneNodes.entrySet()){
            if(ds.findUltiParent(entry.getKey()) == entry.getKey()){
                cnt++;
            }
        }

        return  n - cnt;


    }
};
public class MaximumStonesRemoval {
    public static void main(String[] args) {
        int n = 6;
        int[][] stones = {
                {0, 0}, {0, 1},
                {1, 0}, {1, 2},
                {2, 1}, {2, 2}
        };

        Solution obj = new Solution();
        int ans = obj.maxRemove(stones, n);
        System.out.println(ans);
    }
}
