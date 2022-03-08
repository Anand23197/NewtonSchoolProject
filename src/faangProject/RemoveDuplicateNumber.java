package faangProject;

public class RemoveDuplicateNumber {
        static void removeDuplicate(int arr[]){
            int unique = 0;
            for(int n : arr){
                unique ^= n;
            }
            System.out.println((unique));
    }
    public static void main(String[] args) {
        int[] arr = {25, 36, 65, 12, 25, 65, 36, 12, 15, 13, 13};
        removeDuplicate(arr);
    }
}
