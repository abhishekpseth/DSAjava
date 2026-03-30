package Array;

import java.util.Arrays;

public class Ques8_RotateArrayByOne {
    public static void rotate(int[] arr) {
        // code here
        int k = 1;

        int[] subArray = Arrays.copyOfRange(arr, arr.length - k, arr.length);

        for(int i=arr.length - 1; i>= k; i--){
            arr[i] = arr[i-k];
        }

        for(int i=0; i<k; i++){
            arr[i] = subArray[i];
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};

        rotate(arr);

        for(int it : arr){
            System.out.println(it);
        }
    }
}
