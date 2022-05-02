package adancedDSA.comparator;

import java.util.ArrayList;
import java.util.Collections;

public class ComparatorExample3 {
   static class Car implements Comparable<Car>{
        String type;
        int price;
        Car(String type, int price){
            this.type = type;
            this.price = price;
        }

        @Override
        public int compareTo(Car o) {
            if(this.price > o.price){
                return -1;
            }else if(this.price < o.price){
                return 1;
            } else if(this.price == o.price){
                return o.type.compareTo(this.type);
            }
            return 0;
        }
    }
    public static void main(String[] args) {
        Car one = new Car("suv", 2000);
        Car two = new Car("sedan", 2000);
        Car three = new Car("sedan", 2000);
        Car four = new Car("suv", 2000);
        Car five = new Car("hatchback", 2000);

        ArrayList<Car> list = new ArrayList<>();
        list.add(one);
        list.add(two);
        list.add(three);
        list.add(four);
        list.add(five);

        Collections.sort(list);

        for (Car car : list){
            System.out.println(car.type + " " + car.price);
        }
    }
}
