package collections.map;

import java.util.HashMap;
import java.util.Map;
//put(), contains(), get(), remove(), size()
public class HashMapExample {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("anand", 200);
        map.put("raja", 250);
        map.put("anjali", 350);
        map.put("tiranga", 600);

        //update value of key
        map.put("anand", 400);

        System.out.println("Hash map: " + map);

        //checking for if key is present in the map or not
        boolean isPresent = map.containsKey("anand");
        System.out.println(isPresent);

        //get method print value of key
        System.out.println(map.get("anand"));
    }
}
