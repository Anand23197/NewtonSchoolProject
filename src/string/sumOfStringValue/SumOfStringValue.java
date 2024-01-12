package string.sumOfStringValue;

import java.util.HashMap;

public class SumOfStringValue {
    public static void main(String[] args) {
        char[] arr = {'a','b','c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p','q','r','s', 't',
        'u','v', 'w','x','y', 'z'
        };
        HashMap<Character, Integer> characterMap = new HashMap<>();

        for(int i = 0;i<arr.length; i++){
            characterMap.put(arr[i], i+1);
        }

        String  s = "suraj";
        int sum = 0;
//        for(int i = 0;i<s.length();i++){

            sum += characterMap.get('s');
            sum += characterMap.get('u');
//        }

        System.out.println(sum);
    }
}
