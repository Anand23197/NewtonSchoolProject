package Queue;

public class DoubleEndedQueue {
    int deque[];
    int front;
    int rear;
    int size;

    DoubleEndedQueue(int size) {
        deque = new int[size];
        this.size = size;
        front = -1;
        rear = -1;
    }

    //check for full
    private boolean isFull() {
        //if front is at start and rear at end
        //if front is equal to rear plus one _ r f _ _ _
        return (
                (front == 0 && rear == (size - 1)) ||
                        (front == rear + 1)
        );
    }

    //check for empty
    private boolean isEmpty() {
        return (front == -1);
    }

    //insert at front
    private void insertAtFront(int data) {
        if (isFull()) {
            System.out.println("Deque is full");
        } else {
            //first element of the dequeue
            if (front == -1) {
                front = 0;
                rear = 0;
                deque[front] = data;
            }
            //if front is at 0 index
            else if (front == 0) {
                front = size - 1;
                deque[front] = data;
            } else {
                //if not all above condition than do this
                front--;
            }
            deque[front] = data;
        }
    }

    //insert at rear
    private void insertAtRear(int data) {
        if (isFull()) {
            System.out.println("Deque is full");
        } else {
            //first element of the dequeue
            if (front == -1) {
                front = 0;
                rear = 0;
            } else if (rear == (size - 1)) {
                rear = 0;
            } else {
                rear++;
            }
            deque[rear] = data;
        }
    }

    //delete from front
    private void deleteFromFront() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
        } else {
            //if deque has only one element
            if (front == rear) {
                front = -1;
                rear = -1;
            } else if (front == (size - 1)) {
                front = 0;
            } else {
                front++;
            }
        }
    }

    //delete from rear
    private void deleteFromRear(){
        if (isEmpty()) {
            System.out.println("Queue is empty");
        }else{
            //if deque has only one element
            if(front == rear){
                front = -1;
                rear = -1;
            }else if(rear == 0){
                rear = size - 1;
            }
            else{
                rear--;
            }
        }
    }
    //traverse
    private void traverse(){
        if(front == -1){
            System.out.println("queue is empty");
        }
        //if front is less than or equal to rear e.g. f _ _ _ r
        else if(front <= rear){
            for(int i = front; i<= rear; i++){
                System.out.print("current deque: " + deque[i] + " ");
            }
            System.out.println();
        }
        //if e.g. _ r _ _ f
        else{
            System.out.print("current deque: ");
            for(int i = front; i<size ;i++){
                System.out.print(deque[i] + " ");
            }
            for(int i = 0; i<= rear; i++){
                System.out.print(deque[i] + " ");
            }
            System.out.println();
        }
    }
    private void printArray(){
        System.out.print("current array: ");
        for(int i = 0; i<size; i++){
            System.out.print(deque[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        DoubleEndedQueue doubleEndedQueue = new DoubleEndedQueue(6);

        doubleEndedQueue.insertAtFront(1);
        doubleEndedQueue.insertAtFront(2);
        doubleEndedQueue.insertAtFront(5);
        doubleEndedQueue.traverse();
        doubleEndedQueue.printArray();

        doubleEndedQueue.insertAtRear(3);
        doubleEndedQueue.insertAtRear(4);
        doubleEndedQueue.traverse();
        doubleEndedQueue.printArray();

        doubleEndedQueue.deleteFromFront();
        doubleEndedQueue.deleteFromRear();
        doubleEndedQueue.traverse();

    }
}
