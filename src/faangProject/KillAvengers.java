package faangProject;

import java.util.Scanner;

public class KillAvengers {
    public static void main(String[] args) {
        // Your code here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str = sc.next().toUpperCase();

        int[] arr = new int[26];
        for (int i = 0; i < n; i++) {
            arr[str.charAt(i) - 'A']++;
        }
        int count = 0;
        for (int i = 0; i < 26; i++) {
            if (arr[i] > n / 4) {
            count += arr[i] - (n/4);
            }
        }
        System.out.println(count);
    }
}
