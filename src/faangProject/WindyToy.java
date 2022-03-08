package faangProject;

import java.util.Scanner;

import static java.lang.Math.*;

public class WindyToy {
    public static void main (String[] args) {
        // Your code here
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long M = sc.nextLong();
        long a[] = new long[N];

        for(int i = 0;i<N; i++){
            a[i] = sc.nextInt();
        }
        long ans=M;

        for(int i=1;i<N;i++){

            ans+= min(a[i]-a[i-1],M);

        }

        System.out.println(ans);
    }
}
