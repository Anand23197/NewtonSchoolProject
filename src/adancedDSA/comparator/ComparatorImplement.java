package adancedDSA.comparator;
import java.util.*;
public class ComparatorImplement {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(9);
        list.add(1);
        list.add(8);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(7);
        list.add(6);
        Collections.sort(list, getComparator());
        for(int i : list){
            System.out.print(i + " ");
        }
    }

    private static Comparator<Integer> getComparator(){
        return new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                 //if both value is equal means either even or odd
                if(a%2 == b%2) {
                    if (a % 2 == 1) {    //means if one value is odd then second value will also be odd
                        if (a > b) {     //and if value is odd short in descending order.
                            return -1;
                        } else {
                            return 1;
                        }
                    } else {  //means both are even
                        if (a > b) {
                            return 1;
                        } else {
                            return -1;
                        }
                    }
                }else{      //if both value is not same means one is even and another is odd
                        if(a%2 == 0){         // means one is even
                            return -1;
                         }else {                 //another is odd
                            return 1;
                        }
                }
            }
        };
    }
}


