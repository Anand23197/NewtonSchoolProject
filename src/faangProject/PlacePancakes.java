package faangProject;

import java.util.Scanner;

public class PlacePancakes {
    public static void main (String[] args) {
        // Your code here
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        int z = sc.nextInt();

        int sum = y + 2*z;
        int count = 1;
        while(x>sum){
            sum = y+z;
            count++;
        }

        System.out.println(count);
    }
}
