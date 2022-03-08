package collections.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CloneAMap {
    public static void main(String[] args) {


        Map<String, Integer> map = new HashMap<>();
        map.put("anand", 200);
        map.put("raja", 250);
        map.put("anjali", 350);
        map.put("tiranga", 600);
        map.put("atul", 600);

        System.out.println("original map" + map);

           Map<String, Integer> cloneMap = new HashMap<>(map);
        System.out.println(cloneMap);
    }
}
