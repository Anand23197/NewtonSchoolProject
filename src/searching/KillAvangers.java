package searching;

import java.util.HashMap;
import java.util.Map;

public class KillAvangers {
    public static void main(String[] args) {
        int n = 8;
        String s = "GAAATAAA";
        char[] arr = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();

        for(char c: arr){
            if(map.containsKey(c)){
                map.put(c,map.get(c) + 1);
            }else{
                //if character is not present in map
                map.put(c,1);
            }
        }
        for(Map.Entry entry: map.entrySet()){
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
