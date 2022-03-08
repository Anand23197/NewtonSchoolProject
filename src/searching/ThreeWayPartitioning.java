package searching;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ThreeWayPartitioning {
    public static ArrayList<Integer> threeWayPartition(ArrayList<Integer> A, int lowVal, int highVal)
    {
        // Your code here

        int size = A.size();

        int start = 0, end = size-1;

        for(int i = 0; i<=end ;){
            //if current element is greater than range put it on the next
            //available space
            if(A.get(i)<lowVal){
                Collections.swap(A, i, start);
                start++;
                i++;
            }
            //else if element is smaller than range put it on the next available
            //space
            else if(A.get(i)>highVal){
                Collections.swap(A, i, end);
                end--;
            }else{
                i++;
            }

        }
        return A;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(8);
        list.add(3);
        list.add(3);
        list.add(5);

        threeWayPartition(new ArrayList<>(), 3, 5);
        System.out.println(list);
    }

}
