package faangProject;

public class IthBitOfNumber {
    static int findIthbit(int ithbit){
        return ithbit &(1<<(ithbit-1));
    }
    public static void main(String[] args) {
        int ithbit = 5;
       System.out.println(findIthbit(ithbit));
    }
}
