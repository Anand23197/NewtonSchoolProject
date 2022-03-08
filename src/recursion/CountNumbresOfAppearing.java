package recursion;

public class CountNumbresOfAppearing {
    public static void main(String[] args) {
        int[] arr = {1 , 2 , 11};
        System.out.println(array(arr,0));
    }

    public static int array(int[] arr, int index){
        if(index == arr.length){
            return 0;
        }
        if(arr[index] == 11)
            return array(arr, index+ 1)+1;
        else
            return array(arr, index + 1);
    }
}

