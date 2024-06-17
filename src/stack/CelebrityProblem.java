package stack;

import java.util.Stack;

public class CelebrityProblem {
    static int celebrity(int[][] M , int N){

        Stack<Integer> st = new Stack<>();

        for(int i = 0;i<N;i++){
            st.push(i);
        }

        while(st.size() >= 2){
            int first = st.pop();
            int second = st.pop();

            //if first doesn't know second means its a celebrity else second is celebrity
            if(M[first][second] != 1){
                st.push(first);
            }else{
                st.push(second);
            }
        }

        //because at the end only one index will remain in the stack
        // that index may or may not be celebrity;
        int loc = st.pop();


        for(int i = 0;i<N;i++){
            if(loc != i && M[i][loc] == 0 || M[loc][i] == 1){
                return -1;
            }
        }
        return loc;

    }
    public static void main(String[] args) {
        int N = 3;
        int[][] M= {{0, 1, 0},
            {0, 0, 0},
            {0, 1, 0}};

        int res = celebrity(M, N);
        System.out.println(res);

    }
}
