package playground.graphtraversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Bfs {
    public static void main(String[] args) {
        String str1 = "anand$%raj!*^$rahul ";
        String str = str1.trim().replaceAll("[^A-Za-z]", " ");
        String[] arr = new String[1];
        arr[0] = "";
        StringBuilder sb = new StringBuilder("");
        for(int i = 0; i<str.length(); i++){
            if(str.charAt(i) != ' '){
             sb.append(str.charAt(i));
            }else{
                if(arr[0].length() < sb.length()){
                    arr[0] = String.valueOf(sb);
                }
                sb = new StringBuilder("");
            }
       }
        System.out.println(arr[0]);
    }
}
