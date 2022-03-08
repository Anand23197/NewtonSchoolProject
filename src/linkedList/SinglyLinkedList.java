package linkedList;

public class SinglyLinkedList {
            Node head;
            Node tail;
            int size = 0;
            static class Node{
                int data;
                Node next;
                Node(int data){
                    this.data = data;
                    next = null;
                }
            }
            private void insertAtstart(int data){
                Node newNode = new Node(data);
//                if(head == null){
//                    head = newNode;
//                }else{
//                    newNode.next = head;
//                    //make head to its previous(newNode) Node;
//                    head = newNode;
//                }
                // instead of upper we can also write like this
                if(head != null){
                    newNode.next = head;
                }
                //if head equal to null
                head = newNode;
                size++;
            }
            //insert the new node at the end of the linked list
            private void insertAtEnd(int data){
                Node newNode = new Node(data);
                if(head == null){
                    head = newNode;
                }else {
                    tail.next = newNode;
                }
                tail = newNode;
                size++;
            }
            //insert the new node at the given position
            private void insertAtPosition(int data, int position){
                if(position<1 || position>(size + 1)){
                    System.out.println("invalid position");
                }else{
                    if(position == 1){
                        insertAtstart(data);
                    }else if(position == (size+1)){
                        insertAtEnd(data);
                    }else {
                        Node temp = head;
                        int currentPostion = 1;
                        while(currentPostion != (position -1)){
                            temp = temp.next;
                            currentPostion++;
                        }
                        Node newNode = new Node(data);
                        newNode.next = temp.next;
                        temp = newNode;

                        size++;
                    }
                }
            }
            //traverse the list to find the data
            private void traverse(){
                if(head == null){
                    System.out.println("List is empty");
                }else{
                    Node temp = head;
                    while (temp != null){
                        //printing the data
                        System.out.print(temp.data + " ");
                        //printing address of current node
                      //  System.out.println("current address is: " + temp);
                        //printing the address of next node
                       // System.out.println("address of next node: " + temp.next);
                     //   System.out.println("-------------------");
                        temp = temp.next;
                    }
                    System.out.println();
                }

            }
            private void delete(int position){
                 if (position < 1 || position> size){
                    System.out.println("invalid position");
                }else if(position == 1){
                    Node temp = head;
                    head = head.next;
                    temp.next = null;
                }else{
                     Node temp = head;
                     int currentPosition = 1;
                     while (currentPosition != (position-1)){
                         temp = temp.next;
                         currentPosition++;
                     }
                     //wherever temp will point delete element will be of next element of temp
                     Node delete = temp.next;
                     temp.next = delete.next;
                     //if deleting node is last node
                     if(delete.next == null){
                         tail = temp;

                     }
                     delete.next = null;
                 }
                 size--;
            }


    public static void main(String[] args) {
        SinglyLinkedList sll = new SinglyLinkedList();
        sll.traverse();

        sll.insertAtEnd(8);
        sll.insertAtEnd(-20);
        sll.insertAtEnd(30);
        sll.traverse();

        sll.insertAtstart(31);
        sll.traverse();

        sll.insertAtPosition(25,5);
        sll.insertAtPosition(36, 7);
        sll.traverse();

        sll.delete(5);
        sll.traverse();
    }
}
