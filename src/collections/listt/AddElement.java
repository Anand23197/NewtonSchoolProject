package collections.listt;

import java.util.ArrayList;
import java.util.List;

public class AddElement {
    public static void main(String[] args) {
        List<Integer> numberList = new ArrayList<>();

        for(int i = 0 ; i< 5 ;i++){
            int input = (int)(Math.random() * 100);
            numberList.add(input);

            System.out.println("size: " + numberList.size());
            System.out.println("numberList: " + numberList);
        }

        numberList.add(3, 300);
        System.out.println("size : " + numberList.size());
        System.out.println("numberList: " + numberList);

        numberList.add(6, 300);
        System.out.println("size : " + numberList.size());
        System.out.println("numberList: " + numberList);

    }
}
