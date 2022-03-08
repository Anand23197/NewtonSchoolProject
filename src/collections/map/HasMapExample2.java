package collections.map;

import java.util.HashMap;
import java.util.Map;
/*
Let a map has key roll number and values as data(name, father name, address and contact number)
and then a student has dropped the school. then, how to remove his data so that
sequence of roll number changes itself?
 */
public class HasMapExample2 {
    public static void main(String[] args) {
        Map<Integer, String> studentMap = new HashMap<>();
        studentMap.put(1, "anand");
        studentMap.put(2, "raja");
        studentMap.put(3, "rahul");
        studentMap.put(4, "akshay");
        studentMap.put(5, "rohit");
        studentMap.put(6, "ankit");
        studentMap.put(7, "asutosh");

        Map<Integer, String> newStudentMap = new HashMap<>();

        for (Map.Entry<Integer, String> eachStudent : studentMap.entrySet()) {
            Integer rollnumber = eachStudent.getKey();
            String name = eachStudent.getValue();

            if (rollnumber < 4) {
                newStudentMap.put(rollnumber, name);
            } else if (rollnumber > 4) {
                newStudentMap.put(rollnumber - 1, name);
            } else {

                continue;
            }
        }
        System.out.println("Student Map: " + studentMap);
        System.out.println("new Student Map: " + newStudentMap);
    }
}