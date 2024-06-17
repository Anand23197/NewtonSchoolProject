package string;

public class LongestPelindromicSubstring {
    public static String longestPalindrome(String s) {
        int n = s.length();
        String ans = "";
        for(int i = 0; i < n; i++) {
            int low = i;
            int high = i + 1;

            while(low >= 0 && high < n && s.charAt(low) == s.charAt(high)) {
                low--;
                high++;
            }

            String newStr = s.substring(low + 1, high);
            if(ans.length() < newStr.length())
                ans = newStr;

            low = i;
            high = i;

            while(low >= 0 && high < n && s.charAt(low) == s.charAt(high)) {
                low--;
                high++;
            }

            newStr = s.substring(low + 1, high);
            if(ans.length() < newStr.length())
                ans = newStr;

        }

        return ans;
}
    public static void main(String[] args) {
        String res = longestPalindrome("babad");
        System.out.println(res);
    }
}
