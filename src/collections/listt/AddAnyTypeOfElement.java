package collections.listt;

import jdk.dynalink.linker.LinkerServices;

import java.util.ArrayList;
import java.util.List;

public class AddAnyTypeOfElement {
    public static void main(String[] args) {
        List<Object> list = new ArrayList<>();
        list.add(19);
        list.add(3.14f);
        list.add("java");

        System.out.println(list);

        for(int i = 0; i<list.size(); i++){
            Object value = list.get(i);
            System.out.print(value + " ");
        }
        System.out.println();
    }
}
