package adancedDSA.Graphs.minimumDIstancceHospitol;

import java.util.ArrayList;

public class MinimumHospitolDistance {
    public static void main(String[] args) {
        // make all nodes
     Node node0 = new Node(0,2);
     Node node1 = new Node(1,3);
     Node node2 = new Node(2,3);
     Node node3 = new Node(3,3);
     Node node4 = new Node(4,3);
     Node node5 = new Node(5,3);
     Node node6 = new Node(6,1);
     Node node7 = new Node(7,2);
     Node node8 = new Node(8,3);
     Node node9 = new Node(9,2);
     Node node10 = new Node(10,3);
     Node node11 = new Node(11,3);

     //connect nodes
     ArrayList<ArrayList<Node>> adjlist = new ArrayList<>();

     ArrayList<Node> list0 = new ArrayList<>();

     ArrayList<Node> list1 = new ArrayList<>();
     list1.add(node4);


    }
}
class Node{
    int vertex;
    int value;
    Node(int vertex, int value){
        this.vertex = vertex;
        this.value = value;
    }
}

