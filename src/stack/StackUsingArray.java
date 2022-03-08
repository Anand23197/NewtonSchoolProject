package stack;

public class StackUsingArray {
    int stack[];
    int maxCapacity;
    int top;
    StackUsingArray(int maxCapacity){
        this.maxCapacity = maxCapacity;
        stack = new int[maxCapacity];
        top = -1;
    }
    //ifEmpty
        private boolean isEmpty(){
        return (top == -1);
        }
    //isFull
        private boolean isFull(){
        return (top == (maxCapacity - 1));
        }
    //push
        private void push(int element){
          if(isFull()){
              System.out.println("stack is full");
          }else {
//              top = top + 1;
//              stack[top] = element;
              stack[++top] = element;
          }
        }
    //pop
        private void pop(){
            if(isEmpty()){
                System.out.println("stack is empty");
            }else{
                System.out.println("popped element is: " + stack[top]);
                top--;
            }
        }
        //peak
        private void peak(){
            if(isEmpty()){
                System.out.println("stack is empty");
            }else{
                System.out.println("Element at top: " + stack[top]);
            }
        }
    //traverse
    private void traverse(){
        if(isEmpty()){
            System.out.println("stack is empty");
        }else{
            for(int i = top; i>=0; i--) {
                System.out.println(stack[i] + " ");
            }
        }
    }

    public static void main(String[] args) {
        StackUsingArray s = new StackUsingArray(5);
        s.push(5);
        s.push(10);
        s.push(50);
        s.push(-5);
        s.push(20);
        s.traverse();
        s.pop();
        s.peak();
        s.push(30);
        s.traverse();
        s.peak();
    }
}
