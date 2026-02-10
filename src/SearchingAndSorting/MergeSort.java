package SearchingAndSorting;


import java.util.Arrays;


// The algorithm here is to keep on breaking the array from mid and then merge them so the order becomes correct.
// Recurrence relation:
// if n==1 : O(1)
// if n>1  :

public class MergeSort {
    static int[] merged(int[] arr1, int[] arr2){
        int n1 = arr1.length;
        int n2 = arr2.length;

        int[] res = new int[n1+n2];

        int i=0; int j=0; int k=0;
        while(i<n1 && j<n2){
            if(arr1[i] < arr2[j]){
                res[k] = arr1[i];
                i++;
            } else {
                res[k] = arr2[j];
                j++;
            }
            k++;
        }

        while(i<n1){
            res[k] = arr1[i];
            i++;
            k++;
        }

        while(j<n2){
            res[k] = arr2[j];
            j++;
            k++;
        }

        return res;
    }

    static int[] mergeSortFunction(int[] arr){
        int n = arr.length;

        // if array length is less than 1, return it
        if(n <= 1)return arr;

        // else divide the array into two halves and sort them and then merge them

        int[] sortedFirstHalf = mergeSortFunction(Arrays.copyOfRange(arr, 0, n/2));
        int[] sortedSecondHalf = mergeSortFunction(Arrays.copyOfRange(arr, n/2, n));


        return merged(sortedFirstHalf, sortedSecondHalf);
    }
    public static void main(String[] args) {
        int[] arr = {1,3,6,4,2,5};

        int[] res = mergeSortFunction(arr);

        for(int it: res){
            System.out.println(it);
        }
    }
}
