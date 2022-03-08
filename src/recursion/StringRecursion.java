package recursion;

public class StringRecursion {
    public static void main(String[] args) {
        String sr = "anandk";
        System.out.println(countCharacter(sr));
    }
    static int countCharacter(String str){
        if(str.isEmpty()){
            return 0;
        }
        if(str.charAt(0) == 'k')
        return countCharacter(str.substring(1)) + 1;
        else
            return countCharacter(str.substring(1));
    }
}
