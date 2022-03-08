package collections.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GetValueWithKey {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        map.put("anand", 200);
        map.put("raja", 250);
        map.put("anjali", 350);
        map.put("tiranga", 600);
        map.put("atul", 600);

        //entry set
        System.out.println(map.entrySet());
        //map
        System.out.println(map);

        //enhanced for loop eg. like for(int a: arr){ };

        for(Map.Entry<String, Integer> eachEntry : map.entrySet()){
            if(eachEntry.getValue() == 600){
                list.add(eachEntry.getKey());
            }
        }
        System.out.println(list);

        //remove
        map.remove("anand");
        System.out.println(map);

        //size of map
        System.out.println(map.size());

    }
}
