package adancedDSA.Graphs.alienDictionary;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class AlienDictionary {
    public static String findOrder(String [] dict, int N, int K)
    {
        // Write your code here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i = 0;i<K;i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0;i<dict.length-1;i++){
            String s1 = dict[i];
            String s2 = dict[i+1];
            int sm = Math.min(s1.length(), s2.length());
            for(int j = 0;j<sm;j++){
                if(s1.charAt(j) != s2.charAt(j)){
                    adj.get(s1.charAt(j) - 'a').add(s2.charAt(j) - 'a');
                    break;
                }
            }
        }

        int[] ind = new int[K];

        for(int i = 0;i<K;i++){
            for(int node : adj.get(i)){
                ind[node]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();

        for(int i = 0;i<K;i++){
            if(ind[i] == 0){
                queue.add(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!queue.isEmpty()){
            int node = queue.remove();
            sb.append((char)(node + 'a'));

            for(int adNode : adj.get(node)){
                ind[adNode]--;
                if(ind[adNode] == 0){
                    queue.add(adNode);
                }
            }
        }

        return sb.toString();
    }
    public static void main(String[] args) {
        int N = 5, K = 4;
        String[] dict = {"baa","abcd","abca","cab","cad"};
        String res = findOrder(dict, N, K);
        System.out.println(res);
    }
}
