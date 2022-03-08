package stack;

import java.util.Stack;

public class LongestValidParenthesis {
    public static void main(String[] args) {
        String s = ")()())()";
        int max = 0;
        Stack<Character> ch = new Stack<>();
        Stack<Integer> in = new Stack<>();
        in.add(-1);

        for(int i = 0; i<s.length();i++){
            //either openinng bracket '('
            if(s.charAt(i) == '('){
                ch.add('(');
                in.add(i);
            } //if closing bracket ')' occur
            else{
                if(!ch.isEmpty() &&ch.peek() == '('){
                    ch.pop();
                    in.pop();
                    max = Math.max(max, i - in.peek());
                }else{
                    in.add(i);
                }
            }
        }
        System.out.println(max);
    }
}
