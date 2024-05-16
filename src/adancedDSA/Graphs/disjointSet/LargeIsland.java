package adancedDSA.Graphs.disjointSet;

import java.util.ArrayList;
import java.util.HashSet;

class DisjointSet{

    ArrayList<Integer> rank = new ArrayList<>();
    ArrayList<Integer> parent = new ArrayList<>();
    ArrayList<Integer> size = new ArrayList<>();

    DisjointSet(int n){
        for(int i = 0;i<=n;i++){
            rank.add(0);
            parent.add(i);
            size.add(1);
        }
    }

    int findUltiParent(int node){
        if(node == parent.get(node)){
            return node;
        }

        int ulp = findUltiParent(parent.get(node));
        parent.set(node, ulp);
        return parent.get(node);
    }

    void rankByUnion(int u, int v){
        int ulp_u = findUltiParent(u);
        int ulp_v = findUltiParent(v);

        if(ulp_u == ulp_v) return;
        if(rank.get(ulp_u) < rank.get(ulp_v)){
            parent.set(ulp_u, ulp_v);
        }else if(rank.get(ulp_v) < rank.get(ulp_u)){
            parent.set(ulp_v, rank.get(ulp_u));
        }else{
            parent.set(ulp_v, ulp_u);
            rank.set(ulp_u, rank.get(ulp_u)+1);
        }
    }

    void unionBySize(int u, int v){
        int ulp_u = findUltiParent(u);
        int ulp_v = findUltiParent(v);

        if(ulp_u == ulp_v) return;

        if(size.get(ulp_u) < size.get(ulp_v)){
            parent.set(ulp_u, ulp_v);
            size.set(ulp_v, size.get(ulp_u) + size.get(ulp_v));
        }else{
            parent.set(ulp_v, ulp_u);
            size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
        }
    }
}
public class LargeIsland {
   static boolean  checkSafe(int row, int col, int n, int[][] grid){
        return (row >= 0 && col >= 0 && row < n && col < n && (grid[row][col] == 1));
    }
    public static int largestIsland(int N,int[][] grid)
    {

        DisjointSet ds = new DisjointSet(N*N);
        for(int row = 0;row < N;row++){
            for(int col = 0;col < N;col++){
                if(grid[row][col] == 0) continue;

                int[] drow = {-1,0,1,0};
                int[] dcol = {0,1,0,-1};

                for(int i = 0;i<4;i++){
                    int nrow = drow[i]+row;
                    int ncol = dcol[i]+col;

                    if(checkSafe(nrow, ncol, N, grid)){
                        int nodeNo = row * N + col;
                        int adjNodeNo = nrow * N + ncol;

                        ds.unionBySize(nodeNo, adjNodeNo);
                    }
                }
            }
        }

        int mx = 0;

        for(int row = 0;row < N;row++){
            for(int col = 0;col < N;col++){
                if(grid[row][col] == 1) continue;
                int[] drow = {-1,0,1,0};
                int[] dcol = {0,1,0,-1};

                HashSet<Integer> components = new HashSet<>();
                for(int i = 0;i < 4;i++){
                    int nrow = drow[i]+row;
                    int ncol = dcol[i]+col;

                    if(checkSafe(nrow, ncol, N, grid)){
                        components.add(ds.findUltiParent(nrow * N+ncol));
                    }
                }

                int sizeTotal = 0;
                for(Integer parents : components){
                    sizeTotal += ds.size.get(parents);
                }
                mx = Math.max(sizeTotal+1, mx);
            }
        }

        for(int cellno = 0;cellno<N*N;cellno++){
            mx = Math.max(mx, ds.size.get(ds.findUltiParent(cellno)));
        }
        return mx;
    }
    public static void main(String[] args) {
        int[][] grid = {{1,0},{0,1}};
        int n = grid.length;
       int res = largestIsland(n, grid);
        System.out.println(res);
    }
}
