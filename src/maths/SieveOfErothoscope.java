package maths;

public class SieveOfErothoscope {
    static void primeNumbers(int n){
        boolean prime[] = new boolean[n+1];
        for(int i = 2; i<=n ;i++){
            prime[i] = true;
        }

        for(int p = 2; p*p<=n ;p++){
             if(prime[p]){
                 for(int i = p * p; i<=n ;i+=p){
                     prime[i] = false;
                 }
             }
        }
        for(int i = 0; i<=n ;i++){
            System.out.println(i + ": " + prime[i]);
        }
    }
    public static void main(String[] args) {
        primeNumbers(20);
    }
}
