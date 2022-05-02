package adancedDSA.comparator;

import java.util.Comparator;
import java.util.PriorityQueue;

public class ComparatorExample2 {
    public static void main(String[] args) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(getComparator());
        heap.add(5);
        heap.add(2);
        heap.add(19);
        heap.add(34);
        heap.add(11);
        heap.add(25);
        heap.add(12);
        heap.add(20);
        heap.add(7);

        while (!heap.isEmpty()){
            System.out.print(heap.poll() + " ");
        }
    }
    /*
    -1 => order is already correct, a should lie before b
    0 => both are equal, let the order be same
    1 => a should lie befor b
     */
    private static Comparator<Integer> getComparator(){
     return new Comparator<Integer>() {
         @Override
         public int compare(Integer c, Integer d) {
             if(c%2 == d%2){
                 if(c%2 == 1){
                     if(c>d){
                         return -1;
                     }else{
                         return 1;
                     }
                 }else{
                     if(c>d){
                         return 1;
                     }else {
                         return -1;
                     }
                 }
             }else{
                 if(c%2 == 0){
                     return -1;
                 }else{
                     return 1;
                 }
             }
         }
     };
    }

}



