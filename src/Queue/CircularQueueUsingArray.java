package Queue;

public class CircularQueueUsingArray {
    int front;
    int rear;
    int size;
    int circularQueue[];
    CircularQueueUsingArray(int size){
        this.size = size;
        circularQueue = new int[size];
        front = -1;
        rear = -1;
    }
    //enque
    private void enqueue(int data){
        //check if queue is full
        if((front == 0 && (rear ==size -1)) || (rear == front -1)){
            System.out.println("Queue if full.");
        }
        //check if queue is empty
        else if(front == -1){
            front = 0;
            rear = 0;
            circularQueue[rear] = data;
        }
        //empty place at the start of the queue eg. _ f _ _ r
        else if(rear == size - 1 && front != 0){
            rear = 0;
            circularQueue[rear] = data;
        }
        //empty place at the end of the queue eg. f _ r _ _
        else {
            rear = rear + 1;
            circularQueue[rear] = data;
        }
    }

    //deque
    private void dequeue(){
        //check for empty
        if(front == -1){
            System.out.println("Queue is empty");
        }
        // if queue contains only one element
        else if(front == rear){
            front = -1;
            rear = -1;
        }
        //if front is equal to size e.g. _ r _ _ f
        else if(front == size -1){
            front = 0;
        }
        // if front is at the start e.g. f _ r _ _
        else{
            front = front + 1;
        }
    }

    //traverse
    private void traverse(){
        if(front == -1){
            System.out.println("queue is empty");
        }
        //if front is less than and equal to rear e.g. f _ _ _ r
        else if(front <= rear){
            for(int i = front; i<= rear; i++){
                System.out.print(circularQueue[i] + " ");
            }
            System.out.println();
        }
        //if e.g. _ r _ _ f
        else{
            for(int i = front; i<size ;i++){
                System.out.print(circularQueue[i] + " ");
            }
            for(int i = 0; i<= rear; i++){
                System.out.print(circularQueue[i] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        CircularQueueUsingArray circularQueueUsingArray = new CircularQueueUsingArray(6);
        circularQueueUsingArray.enqueue(1);
        circularQueueUsingArray.enqueue(2);
        circularQueueUsingArray.enqueue(3);
        circularQueueUsingArray.enqueue(4);
        circularQueueUsingArray.traverse();

        circularQueueUsingArray.dequeue();
        circularQueueUsingArray.dequeue();
        circularQueueUsingArray.traverse();

        circularQueueUsingArray.enqueue(5);
        circularQueueUsingArray.enqueue(6);
        circularQueueUsingArray.enqueue(7);
        circularQueueUsingArray.traverse();

        circularQueueUsingArray.enqueue(8);
        circularQueueUsingArray.enqueue(9);
        circularQueueUsingArray.traverse();
    }
}
