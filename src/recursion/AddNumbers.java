package recursion;

public class AddNumbers {
    public static void main(String[] args) {
        int n = 5;
        System.out.println( add(n));
    }
    public static int add(int n){
        System.out.print(n + " ");
        if(n == 1){
            return  1;
        }
        return n + add(n-1);
    }
}
