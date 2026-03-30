package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class Ques8_RotateArrayByOne {
    // Method 1: Copy last k (here 1) elements in another array, shift rest of element to 1 step and paste this copied part in front
    public static void rotate1(int[] arr) {
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

    // Method 2: run a loop with index i, and keep swapping ith index with last index element, after completion, it will rotate by one
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void rotate2(int[] arr) {
        int k = 1;

        while(k > 0){
            for(int i=0; i<arr.length; i++) {
                swap(arr, i, arr.length - 1);
            }
            k--;
        }
    }

    // Method 3: Reverse all element, then reverse first n-k element then reverse remaining element
    public static void reverse(int[] arr, int i, int j){
        while(i < j){
            swap(arr, i, j);
            i++; j--;
        }
    }

    public static void rotate3(int[] arr) {
        int k = 2;
        int n = arr.length;

        k = k % n; // handle k > n

        // Step 1: reverse whole array
        reverse(arr, 0, n - 1);

        // Step 2: reverse first k elements
        reverse(arr, 0, k - 1);

        // Step 3: reverse remaining elements
        reverse(arr, k, n - 1);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};

        rotate3(arr);

        for(int it : arr){
            System.out.println(it);
        }
    }
}
