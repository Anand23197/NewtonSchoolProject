package Queue;

public class QueueImplementation {
    int front;
    int rear;
    int capacity;
    int size;
    int queue[];
    QueueImplementation(int capacity){
        this.capacity = capacity;
        queue = new int[capacity];

        front = -1;
        rear = -1;
    }
    //insertion in the queue
    private void enqueue(int data){
        if(isFull()){
            System.out.println("queue is full");
        }else{
            //first element of queue is to be inserted
            if(isEmpty()){
                front = 0;
            }
            //subsequent elements to be inserted

                rear = rear + 1;
                queue[rear] = data;

        }
    }
    //deletion in queue
    private  void dequeue(){
        if(isEmpty()){
            System.out.println("queue is empty: underflow");
        }else{
            front = front + 1;
        }
    }
    private void traverse(){
        if(isEmpty()){
            System.out.println("queue is empty");
        }else {
            for(int i = front; i<=rear ; i++){
                System.out.print(queue[i] + " ");
            }
            System.out.println();
        }
    }
    //isFull
    private boolean isFull(){
        if(rear == (capacity-1)){
            return true;
        }
        return false;
    }
    //isEmpty
    private boolean isEmpty(){
        if(rear == -1 || front>rear){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        QueueImplementation queueImplementation = new QueueImplementation(6);
        queueImplementation.enqueue(10);
        queueImplementation.enqueue(20);
        queueImplementation.enqueue(30);
        queueImplementation.traverse();


        queueImplementation.dequeue();
        queueImplementation.dequeue();
        queueImplementation.traverse();

        queueImplementation.enqueue(40);
        queueImplementation.enqueue(50);
        queueImplementation.enqueue(60);
        queueImplementation.enqueue(70);
        queueImplementation.traverse();
    }
}
