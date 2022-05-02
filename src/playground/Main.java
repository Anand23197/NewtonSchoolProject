package playground;
import java.util.*;

public class Main {
    public static void main (String[] args) {
        // Your code here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        System.out.println(getPermuatation(n,k));
    }
    static String getPermuatation(int n, int k){
        long fact = 1;
        List<Long> numbers = new ArrayList<>();
        for(long i = 1; i<n; i++){
            fact = fact * i;
            numbers.add(i);
        }
        numbers.add((long) n);
        String ans = "";
        k = k - 1;
        while(true){
            ans = ans + numbers.get((int) (k/fact));
            numbers.remove(k/fact);
            if(numbers.size() == 0){
                break;
            }

            k = (int) (k%fact);
            fact = fact/ numbers.size();
        }
        return ans;
    }
}