package karomi.dictionary;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Dictionary {
    public static void main(String[] args) throws IOException {
        FileWriter fileWriter = new FileWriter("C:\\Users\\ANAND VISHWAKARMA\\Desktop\\NewtonSchoolProject\\src\\karomi\\dictionary\\myNewFile.txt");
        StringBuffer sb = new StringBuffer();
        for(int i = 'A'; i<='z'; i++){
            char ch = (char)i;
            if(ch != '[' && ch != '\\' && ch != ']' && ch != '^' && ch != '_' && ch != '`'){
                sb.append((char)i);
                sb.append("\n");
            }
        }
        fileWriter.write(String.valueOf(sb));
        fileWriter.close();


        // Read text from file
        FileReader fileReader = new FileReader("C:\\Users\\ANAND VISHWAKARMA\\Desktop\\NewtonSchoolProject\\src\\karomi\\dictionary\\myNewFile.txt");
        BufferedReader br = new BufferedReader(fileReader);
        HashMap<Integer, String> dictionary = new HashMap<>();
        Integer i = 0;
        String s;
        while ((s = br.readLine()) != null){
                dictionary.put(++i, s);
        }
        fileReader.close();


        //push the value alone from dictionary to string array
        String[] arr = new String[dictionary.size()];

        for(int j = 1; j<=dictionary.size(); j++){
            arr[j-1] = dictionary.get(j);
        }
        for(String st : arr){
            System.out.print(st + " ");
        }
    }
}
