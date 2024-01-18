package adancedDSA.Graphs.floodFillAlgorithm;

public class FloodFill {
    public static void main(String[] args) {
        int[][] arr = {{2, 3, 2, 1, 2},
                      {3, 3, 3, 3, 1 },
                      {3, 1, 1, 1, 2 },
                      {1, 2, 2, 1, 3 },
                      {1, 2, 3, 3,1 },
                      {2, 1, 2, 2, 2},
                      {1, 2, 2,1, 1},
                      {3, 1, 1, 1,2}};
       int X = 4, Y = 0, Col = 1;

       int s = arr[X][Y];
        if(arr[X][Y] != Col){
            solve(arr, Col, X, Y,s);
        }


        for(int i = 0;i<arr.length;i++){
            for(int j = 0;j<arr[i].length;j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

    }
    static void solve(int[][] arr,int col,int x, int y, int s){
                bfs(arr,x,y,s, col );
    }

    static void bfs(int[][] arr, int i, int j, int s, int c){

        if(i < 0 || i >= arr.length || j < 0 || j >= arr[i].length){
            return;
        }

        if(arr[i][j] != s){
            return;
        }

        arr[i][j] = c;

        bfs(arr, i+1, j, s, c);
        bfs(arr, i, j+1, s,c);
        bfs(arr, i-1, j, s,c);
        bfs(arr, i, j-1, s, c);

    }
}
