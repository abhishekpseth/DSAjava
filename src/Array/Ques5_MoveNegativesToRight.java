package Array;

import java.util.Stack;

public class Ques5_MoveNegativesToRight {
    // Method 1: If order of resultant parts doesn't matter (using 2 pointers also called Hoare's Paritition)
    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void segregateElements(int[] arr) {
        // Your code goes here
        int i=0; int j=arr.length - 1;

        while(i <= j){
            while(i <= j && arr[i] >= 0) i++;
            while(i <= j && arr[j] < 0) j--;

            if(i <= j){
                swap(arr, i, j);
                i++; j--;
            }
        }
    }

    // Method 2: When order has to be same
    public static void segregateElements2(int[] arr) {
        // Your code goes here
        Stack<Integer> st1 = new Stack<>();
        Stack <Integer> st2 = new Stack<>();


        for(int it : arr){
            if(it >= 0) st1.push(it);
            else st2.push(it);
        }

         for(int i=arr.length - 1; i>=0; i--){
             if(!st2.isEmpty()){
                 arr[i] = st2.peek();
                 st2.pop();
             } else {
                 arr[i] = st1.peek();
                 st1.pop();
             }
         }
    }

    // Method 2: If or
    public static void main(String[] args) {
        int[] arr = {1, -1, 3, 2, -7, -5, 11, 6};
        segregateElements2(arr);

        for(int it : arr){
            System.out.println(it);
        }
    }
}
