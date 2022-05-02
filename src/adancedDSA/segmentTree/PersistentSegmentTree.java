package adancedDSA.segmentTree;

import java.util.ArrayList;

public class PersistentSegmentTree {
    static class Node {
        int sum;
        Node left;
        Node right;

        Node(int data) {
            sum = data;
        }

        Node(Node l, Node r) {
            sum = l.sum;
            left = l;
            right = r;
        }
    }

    static Node build(int start, int end) {
        if (start == end) {
            return new Node(0);
        } else {
            int mid = (start + end) / 2;
            return new Node(
                    build(start, mid), build(mid + 1, end)
            );
        }
    }

    static Node update(Node node, int start, int end, int pos, int val) {
        if (start == end) {
            return new Node(val);
        } else {
            int mid = (start + end) / 2;
            if (start <= pos && pos <= mid) {
                new Node(update(node, start, mid, pos, val), node.right);
            } else {
                return new Node(node.left, update(node, mid + 1, end, pos, val));
            }
        }
        return node;
    }


    public static void main(String[] args) {
        int n = 10, k = 4, val = 10;
        ArrayList<Node> states = new ArrayList<>();
        states.add(build(0, n - 1));

        states.add(update(states.get(states.size() - 1), 0, n - 1, k, val));

    }
}
