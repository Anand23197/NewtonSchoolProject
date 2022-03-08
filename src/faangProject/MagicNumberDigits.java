package faangProject;

public class MagicNumberDigits {
    public static void main(String[] args) {
        //representing the number
        int n = 10;
        //in which we want to count the digit
        int base = 2;//it will represent the binary of number 10 = (1010) and digit = 4
        int base1 = 10; //it will represent the decimal of number 10 = (10) and digit = 2
        //log a base b = log a base n/ log b base n
        int ans = (int)(Math.log(n)/Math.log(base)) + 1;
        int ans1 = (int)(Math.log(n)/Math.log(base1)) + 1;
    }
}
