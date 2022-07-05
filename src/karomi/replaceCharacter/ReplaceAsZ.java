package karomi.replaceCharacter;

import java.util.HashMap;
import java.util.Map;

public class ReplaceAsZ {
    public static void main(String[] args) {
        StringBuilder st = new StringBuilder("ALPHABETS");
        HashMap<Character, Integer> map = new HashMap<>();

        for(int i = 0; i<st.length();i++){
            char ch = st.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for(Map.Entry<Character, Integer> entry: map.entrySet()){
            if(entry.getKey() == 'B'){
               map.remove(entry.getKey());
               map.put('Z', entry.getValue());
               break;
            }
        }

        System.out.println(map);

    }
}
