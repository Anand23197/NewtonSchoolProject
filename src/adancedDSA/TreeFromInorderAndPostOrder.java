package adancedDSA;

import java.util.HashMap;
import java.util.Scanner;

class Node1{
    Node1 left;
    Node1 right;
    int data;
    Node1(int data){
        this.data = data;
    }
}
class TreeFromInorderAndPostOrder{
    public static void main (String[] args) {
        // Your code here
        int n = 7;

        int[] inorder = {4,8,2,5,1,6,3,7};
        int[] postorder = {8,4,5,2,6,7,3,1};
        Node1 root = buildtree(inorder, postorder, n);
        preorder(root);
    }
    static void preorder(Node1 root){
        if(root == null){
            return;
        }
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }


    static Node1 buildtree(int[] inorder, int[] postorder, int n){
        //if there is no array
        if(n == 0){
            return null;
        }
        return buildtree(inorder, 0, n-1, postorder, 0, n-1);
   }
    //build tree from inorder and postorder
    static Node1 buildtree(int[] inorder, int is, int ie, int postorder[], int ps, int pe){
        if(is>ie){
            return null;
        }
        //root node prom postorder will always be last element
        Node1 node = new Node1(postorder[pe]);
        int currentIndexInInorder = search(inorder, is, ie, postorder[pe]);

        //go to left of constructing tree
        node.left = buildtree(inorder, is, currentIndexInInorder-1, postorder, ps, ps-is+currentIndexInInorder-1);
        node.right = buildtree(inorder,currentIndexInInorder+1, ie, postorder, pe-ie+currentIndexInInorder, pe-1);

        return node;
    }
    static int search(int[] inorder, int is, int ie, int data){
        for(int i = is; i<=ie;i++){
            if(inorder[i] == data){
                return i;
            }
        }
        return -1;
    }
}