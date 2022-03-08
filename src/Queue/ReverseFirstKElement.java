package Queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseFirstKElement {
    static Queue<Integer> queue;
    static void reverseFirstKElement(int k){
        if(queue.isEmpty() == true || k>queue.size()){
            return;
        }
        if(k<=0){
            return;
        }
        Stack<Integer> stack = new Stack<Integer>();
        //push the first k element into a stack
        for(int i = 0; i<k; i++){
            stack.push(queue.peek());
            queue.remove();
        }
        while(!stack.empty()){
            queue.add(stack.peek());
            stack.pop();
        }
        //remove remaining elements and enque them at the end
        for(int i = 0; i<queue.size(); i++){
            queue.add(queue.peek());
            queue.remove();
        }

        }
    static void print(){
        while (!queue.isEmpty()){
            System.out.print(queue.peek() + " ");
            queue.remove();
        }
    }

    public static void main(String[] args) {
        queue = new LinkedList<Integer>();
        queue.add(10);
        queue.add(20);
        queue.add(30);
        queue.add(40);
        queue.add(50);

        int k = 5;
        reverseFirstKElement(k);
        print();
    }
}
