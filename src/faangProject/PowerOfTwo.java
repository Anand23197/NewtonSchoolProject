package faangProject;

public class PowerOfTwo {
    public static void main(String[] args) {
        int num = 8;
        //method one
       /* int count = 0;
        while(num>0){
            if((num & 1) == 1){
                count++;
            }
            num = num>>1;
        }
        if(count == 1){
            System.out.println("Number is power of two");
        }else {
            System.out.println("number is not power of two");
        }  */
        //method second
        boolean ans = (num & (num-1)) == 0;
        System.out.println(ans);
    }
}
