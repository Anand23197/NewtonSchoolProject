package adancedDSA.Graphs.dijkstra;

import java.util.LinkedList;
import java.util.Queue;

class ShortPathPair{
    int dist;
    int x;
    int y;
    ShortPathPair(int dist, int x, int y){
        this.dist = dist;
        this.x = x;
        this.y = y;
    }
}
public class ShortestDistanceInBinaryTree {

    static boolean valid(int newc,int newr,int[][] dist,int[][] grid, int row, int col, int dis){
        return (newr >= 0 && newr < row && newc >= 0 && newc <= col && grid[newr][newc] == 1 && dis + 1 < dist[newr][newc]);
    }

    static int shortestPath(int[][] grid, int[] source, int[] destination) {

        //if source index and destination index both are same than there is no path
        if(source[0] == destination[0] && source[1] == destination[1]){
            return 0;
        }

        Queue<ShortPathPair> queue = new LinkedList<>();

        int row = grid.length;
        int col = grid[0].length;

        int[][] dist = new int[row][col];

        //mark all the dist node that contains infinity distance
        for(int i = 0;i<row;i++){
            for(int j = 0;j<col;j++){
                dist[i][j] = (int)1e9;
            }
        }

        //mark source node as 0 distance

        dist[source[0]][source[1]] = 0;
        queue.add(new ShortPathPair(0, source[0], source[1]));

        //coordinates
        int[] dx = {1,0,-1,0};
        int[] dy = {0,1,0,-1};

        while(!queue.isEmpty()){
            int dis = queue.peek().dist;
            int disRow = queue.peek().x;
            int disCol = queue.peek().y;
            queue.remove();
            //we will check in all the four direction
            for(int i = 0;i<4;i++){
              int newr = dx[i]+ disRow;
              int newc = dy[i] + disCol;

              if(valid(newc, newr, dist, grid, row, col, dis)){
               dist[newr][newc] = 1 + dis;

                //return the point until the point we found is destination cell
               if(destination[0] == newr && destination[1] == newc) return dis + 1;
               queue.add(new ShortPathPair(1+dis, newr, newc));
              }

            }
        }

        //if no path is found return -1
        return -1;
    }
    public static void main(String[] args) {

        int[] source={0,1};
        int[] destination={2,2};

        int[][] grid={{1, 1, 1, 1},
                {1, 1, 0, 1},
                {1, 1, 1, 1},
                {1, 1, 0, 0},
                {1, 0, 0, 1}};

       int res = shortestPath(grid, source, destination);
        System.out.println(res);
    }
}
