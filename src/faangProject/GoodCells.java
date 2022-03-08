package faangProject;

import java.util.Scanner;

public class GoodCells {
    public static void main (String[] args) {
        // Your code here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[n][m];
        int count = 0;
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m;j++){
                arr[i][j] = sc.nextInt();
            }
        }
        for(int i = 1;i<n-1;i++){
            for(int j = 1; j<m-1;j++){
                if(arr[i][j-1]==1 && arr[i-1][j]==1 && arr[i][j+1]==1 && arr[i+1][j]==1 ){
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
