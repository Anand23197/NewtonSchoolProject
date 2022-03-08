package maths;

public class Divisors {
    private static void getDivisiorsByImprovedVersion(int n){
        for(int i = 1; i*i<=n; i++){
            if(n%i == 0){
                if(n/i == i){
                    System.out.print(i + " ");
                }else{
                    System.out.print(i + " " + (n/i) + " ");
                }
            }
        }
    }

    public static void main(String[] args) {
        getDivisiorsByImprovedVersion(16);
    }

}
