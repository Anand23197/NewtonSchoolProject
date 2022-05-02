package adancedDSA.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Node{
    int data;
    Node left;
    Node right;

    Node(int data){
        this.data = data;
    }
}
public class TreeExample {
    static void preOrder(Node root){
        //NLR

        if(root == null){
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }
    static void preOrderIterative(Node root){
        if(root == null){
            return;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()){
            Node node = stack.pop();
            System.out.print(node.data + " ");

            if(node.right != null){
                stack.push(node.right);
            }

            if(node.left != null){
                stack.push(node.left);
            }

        }
    }
    static void inOrder(Node root){
        //LNR
        if(root == null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }
    static void inOrderIterative(Node root){
        //LNR
        if(root == null){
            return;
        }
        Stack<Node> stack = new Stack<>();
        Node curr = root;

        //trverse upto left of tree not null
        while(curr != null || stack.size() > 0) {
           while(curr != null) {
               stack.push(curr);
               curr = curr.left;
           }
            //current will be null
            curr = stack.pop();
            System.out.print(curr.data + " ");

            //now visit right sub tree
            curr = curr.right;
        }
    }
    static void postOrder(Node root){
        //
        if(root == null){
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }
    static void laveOrderUsingQueue(Node root){

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);

        while (!queue.isEmpty()){
            Node node = queue.remove();

            //for printing in lavel order
            if(node == null){
                System.out.println();
                if(!queue.isEmpty()){
                    queue.add(null);
                }
                continue;
            }
            //
            System.out.print(node.data + " ");

            if(node.left != null){
                queue.add(node.left);
            }
            if(node.right != null){
                queue.add(node.right);
            }
        }
    }
    private static int getHieght(Node root){
        if(root == null){
            return 0;
        }
        int leftHeight = getHieght(root.left);
        int rightHeight = getHieght(root.right);
        return Math.max(leftHeight ,rightHeight) + 1;
    }

    static Node getTree(){
        Node root = new Node(1);
        Node node1 = new Node(2);
        Node node2 = new Node(3);
        Node node3 = new Node(4);
        Node node4 = new Node(5);
        Node node5 = new Node(6);
        Node node6 = new Node(7);
        Node node7 = new Node(8);
        Node node8 = new Node(9);

        root.left = node1;
        root.right = node2;

        node1.left = node3;
        node1.right = node4;

        node2.left = node5;
        node2.right = node6;

        node3.left = node7;
        node3.right = node8;

        return root;
    }
    public static void main(String[] args) {

        Node root = getTree();
        System.out.println("printing preOrder using recursion");
        preOrder(root);
        System.out.println();
        System.out.println("preorder using iterative");
        preOrderIterative(root);
        System.out.println();
        System.out.println("printing in inOrder ");
        inOrder(root);
        System.out.println();
        System.out.println("inorder iterative");
        inOrderIterative(root);
        System.out.println();
        System.out.println("printing in postOrder");
        postOrder(root);
        System.out.println();
        System.out.println("printing in lavel order");
        laveOrderUsingQueue(root);
        System.out.println();
        System.out.println("Height of the tree : " + getHieght(root));
        System.out.println();
    }
}
