package faangProject;

import java.util.Scanner;

public class NumberIsEvenOrOdd {
    static void numberIsEven(int n){
        //in and operation any number that is and(&) with 1 gives 1 and if last digit in binary is 1 that means number is odd else number is even
        if( (n & 1) == 1){
            System.out.println("number is odd");
        }else
        System.out.println("Number is even");

         ;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        numberIsEven(n);
    }
}
