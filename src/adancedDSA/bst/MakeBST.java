package adancedDSA.bst;
class Node{
         Node left;
         Node right;
         int data;
         Node(int data){
                 this.data = data;
         }
    }
public class MakeBST {
        public static void main(String[] args) {
                Node root = null;
                root = insert(root, 20);
                root = insert(root, 10);
                root = insert(root, 30);
                root = insert(root, 15);
                root = insert(root, 5);
                root = insert(root, 18);
                root = insert(root, 4);
                root = insert(root, 13);
                root = insert(root, 50);

                System.out.println("Inorder of the bst is");
                inOrder(root);
                System.out.println();
                search(root, 25);
                search(root, 17);
                search(root, 100);
                delete(root, 50);
                System.out.println("Inorder of the bst is");
                inOrder(root);
                System.out.println();
                 delete(root, 5);
                System.out.println("Inorder of the bst is");
                inOrder(root);
                System.out.println();

        }
        private static Node insert(Node root, int data){
                Node newNode = new Node(data);
               return insert(root, newNode);
        }
        private static Node insert(Node root, Node newNode){
                if(root == null){
                        return newNode;
                }
                if(root.data < newNode.data){
                        root.right = insert(root.right, newNode);
                }else{
                        root.left = insert(root.left, newNode);
                }
                return root;
        }
        private static void inOrder(Node root){
                if(root == null){
                        return;
                }
                inOrder(root.left);
                System.out.print(root.data + " ");
                inOrder(root.right);
        }
        private static void search(Node root, int data){
                if(root == null){
                        System.out.println(data + ": is not present");
                        return;
                }
                if(root.data == data){
                        System.out.println(data + ": is present in bst");
                        return;
                }
                if(root.data <data){
                        search(root.right, data);
                }else{
                        search(root.left, data);
                }
        }
        public static Node delete(Node root, int data){
                if(root == null){
                        System.out.println(data + ": data is not present in the tree");
                        return root;
                }
                //searching the data
                if(root.data < data){
                        root.right = delete(root.right, data);
                        return root;
                }else if(root.data > data){
                        root.left = delete(root.left, data);
                        return root;
                }
                //check if node is leaf node
                if(root.left == null && root.right == null){
                        root = null;
                        return null;
                }else if(root.left == null){ //if root left is null then data present in right
                        root = root.right;
                        return root;
                }else if(root.right == null){ //if root right is null then data present in left;
                        root = root.left;
                        return root;
                }else{
                        //neither left null nor right null
                        Node replaceingNode = findMax(root.left);
                        //after founding the deleting node we replace the data
                        root.data = replaceingNode.data;
                        root.left = delete(root.left, replaceingNode.data);
                }
                return root;
        }
        private static Node findMax(Node root){
                while(root.right != null){
                        root = root.right;
                }
                return root;
        }
}
