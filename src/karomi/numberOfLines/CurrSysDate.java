package karomi.numberOfLines;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CurrSysDate {
    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader("C:\\Users\\ANAND VISHWAKARMA\\Desktop\\NewtonSchoolProject\\src\\karomi\\numberOfLines\\TenLines.txt");
        BufferedReader br = new BufferedReader(fileReader);
        StringBuffer sb = new StringBuffer();
        String s;
        int count = 0;
        while ((s = br.readLine()) != null){
            count++;
            if(count%2 != 0){
                sb.append(s);
                sb.append("\n");
            }
        }

        //print how many number of line text in file
        System.out.println("total no. of line in text file: " + count);


        // get the current system date
        DateTimeFormatter df = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        LocalDateTime now = LocalDateTime.now();
         String fn = df.format(now) + ".txt";

         // write in new file and make name as current system date

        FileWriter fr = new FileWriter("C:\\Users\\ANAND VISHWAKARMA\\Desktop\\NewtonSchoolProject\\src\\karomi\\numberOfLines\\" + fn );
        fr.write(String.valueOf(sb));
        fr.close();
    }
}
