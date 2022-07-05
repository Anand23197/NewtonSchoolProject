package karomi.countOfWord;

import java.util.*;

public class CountSameWord {
    public static void main(String[] args) {
        String[] st1 = {"apple", "fruit", "text", "world"};
        String[] st2 = {"text", "sam", "try", "apple", "world"};

        //create two hash map data structure
        HashMap<String, Integer> tm1 = new HashMap<>();
        HashMap<String, Integer> tm2 = new HashMap<>();

        //count the frequency of word in each string array
        for(int i = 0; i< st1.length; i++){
            String str = st1[i];
            tm1.put(str, tm1.getOrDefault(str, 0)+1);
        }

        for(int i = 0; i< st2.length; i++){
            String str = st2[i];
            tm2.put(str, tm2.getOrDefault(str, 0)+1);
        }

        //we will iterate through any of the two hash map and check the
        //key in another hash map. If key is present add the value of key
        // and add in result;
        int res = 0;
        for(Map.Entry<String, Integer> entry : tm1.entrySet()){
            if(tm2.containsKey(entry.getKey())){
                res = res + entry.getValue() + tm2.get(entry.getKey());
            }
        }
        System.out.println(res);
    }
}
