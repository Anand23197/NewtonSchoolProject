package faangProject;

public class GretestElementOfRightSide {
    public static void main(String[] args) {
        int[] arr = {16, 17, 4, 3, 5, 2};
        int length = arr.length;
        //initialize the next greatest element
        int max_from_right = arr[length-1];
        //next greatest element from right side will always -1;
        arr[length-1] = -1;

        // replace all the elements with the next greatest
        for(int i = length-2; i>=0 ; i--){
            //store the current element needed later for updating the next greatest element
            int temp = arr[i];

            //replace current element with the next greatest
            arr[i] = max_from_right;

            //update the greatest element if needed
            if(max_from_right<temp){
                max_from_right = temp;
            }
        }
        for(int i = 0; i<length;i++){
            System.out.print(arr[i] + " ");
        }
    }
}
