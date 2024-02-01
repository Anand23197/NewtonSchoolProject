package playground;
import com.sun.tools.jconsole.JConsoleContext;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main (String[] args) throws IOException {
       int row = 3;
       int col = 5;

        // 3 5
        //1 2 3 4 5
        //6 7 8 9 10
        //11 12 13 14 15
        //13
       int[][] matrix =  {{1,2,3,4,5},
                          {6,7,8,9,10},
                          {11,12,13,14,15}};
        int k = 13;
        solve(row, col, matrix, k);
    }

    static void solve(int r, int c, int[][] matrix, int k){

        int row = 0, col = 0;
        for(int i = 0;i<r;i++){
            for(int j = 0;j<c;j++){
                if(matrix[i][j] == k){
                    row = i;
                    col = j;
                    break;
                }
            }
        }

        int i = row, j = col;
        //going to top left i--, j--;
        ArrayList<Integer> al  = new ArrayList<>();
       while(row >= 0 && col >= 0){
           al.add(matrix[row--][col--]);
       }

       Collections.reverse(al);
       // reverse string
        for(int l : al){
            System.out.print(l + " ");
        }

       row = i;
       col = j;

        ++row;
        ++col;
       while(row < r && col < c){
           System.out.print(matrix[row++][col++] + " ");
       }
        System.out.println();

       row = i;
       col = j;


        ArrayList<Integer> al2  = new ArrayList<>();
        while(row < r && col < c){
           al2.add(matrix[row--][col++]);
        }

        Collections.reverse(al2);
        for(int l : al2){
            System.out.print(l + " ");
        }

        row = i;
        col = j;

        ++row;
        --col;
        while(row < r && col >= 0){
            System.out.print(matrix[row++][col--] + " ");
        }

    }
}