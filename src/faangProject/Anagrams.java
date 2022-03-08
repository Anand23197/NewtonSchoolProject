package faangProject;

import java.util.Scanner;

public class Anagrams {
    public static void main (String[] args) {
        // Your code here
        Scanner sc = new Scanner(System.in);
        String s1 = "abc";
        String s2 = "adefg";
        int[] count1 = new int[26];
        int[] count2 = new int[26];

        for(int i = 0;i<s1.length(); i++){
            count1[s1.charAt(i) - 'a']++;
        }
        for(int j = 0;j<s2.length();j++){
            count2[s2.charAt(j) - 'a']++;
        }
        int result = 0;
        for(int i = 0; i<26;i++){
            result += Math.abs(count1[i] - count2[i]);
        }
        System.out.println(result);
    }
}
