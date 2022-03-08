package searching;

public class CielOfANumber {
    public static void main(String[] args) {
            int arr[] = {2, 3 ,5, 9, 14, 16, 18};
            int target = 15;
            int start = 0;
            int end = arr.length - 1;
            int index = -1;
            int flag = 1;
            while(start<=end){
                int mid = start + (end - start)/2;

                if(arr[mid] < target){
                    start = mid + 1;
                }else if(arr[mid] > target){
                    end = mid - 1;
                }else{
                    index = mid;
                    flag = 0;
                    break;
                }
            }
            if(flag == 0){
                System.out.println("ciel of a number is " + arr[index]);
            }else {
                System.out.println("ciel of a number is: " + arr[start]);
            }

        }

    }


