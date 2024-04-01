package string;

import java.util.HashMap;

public class LongestSubstringDistinctCharacter {
    static int longestSubstrDistinctChars(String S){
        // code here
        HashMap<Character, Integer> hm = new HashMap<>();
        hm.put(S.charAt(0), 1);
        int i = 0;
        int len = 0;
        for(int j = 1;j<S.length();j++){
            char ch = S.charAt(j);
            if(hm.containsKey(ch)){
                while(S.charAt(i) != ch){
                    hm.put(ch, hm.getOrDefault(ch, 0)-1);
                    if(hm.get(ch) == 0){
                        hm.remove(ch);
                    }
                    i++;
                }
            }else{
                hm.put(ch, hm.getOrDefault(ch, 0)+1);
                len = Math.max(len, hm.size());
            }
        }
        return len;
    }
    public static void main(String[] args) {
        String s = "aldshflasghdfasgfkhgasdfasdgvfyweofyewyrtyefgv";
        int res = longestSubstrDistinctChars(s);
        System.out.println(res);
    }
}
