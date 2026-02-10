package SearchingAndSorting;

// ------------------ Insertion Sort -------------------

// Here, we iterate through the array only once, and for each element we see it greater than all the items on its left.
// if not we make it correct by inserting that element on its correct position.
// How to do insertion: keep the element swapping with the item on its immediate left until u reach correct position.

// For example: [1,3,6,4,2,5]

// we start from 3, since for 1, nothing is present on the left

// element = 3: it is greater than 1, so we move on
// [1,3,6,4,2,5]

// element = 6, it is greater than 1 & 3, so we move on
// [1,3,6,4,2,5]

// element = 4, it is greater than 1,3 but lesser than 6. so swap 4 with 6. Now 1,3,4,6 is sorted
// [1,3,4,6,2,5]

// element = 2,

// 2 is lesser than its immediate left, i.e. 6, so swap 2 with 6

// [1,3,4,2,6,5]
// it is still lesser than its 4, so swap 2 with 4

// [1,3,2,4,6,5]
// it is still lesser than its 3, so swap 2 with 3

// [1,2,3,4,6,5]
// it is still lesser than its 3, so swap 2 with 3, 2 is greater than 1 so no more iteration

// element = 5,

// 5 is lesser than 6, so swapping 5 & 6
// [1,2,3,4,5,6], now 5 is at correct place so no more iterations


// Time complexity: If the length of array is N, For every element (at index i), at max i swaps can be done. and this is for n-1 times at max since we start from second element.
// so total number of swaps in worst case: 1+2+3...n-1 = (n-1)((n-1)-1)/2 (using sum of natural numbers formula).
// the order is o(N^2).

// Auxiliary Space: O(1), Insertion sort requires O(1) additional space, making it a space-efficient sorting algorithm.

public class InsertionSort {
    static void insertionSortFunction(int[] arr){
        int n = arr.length;

        if(n == 1){
            System.out.println(arr[0]);
            return;
        }

        for(int i=1; i<n; i++){
            int j = i;
            while(arr[j] < arr[j-1]){
                int temp = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = temp;
                j--;
            }
        }

        for(int it: arr){
            System.out.println(it);
        }
    }
    public static void main(String[] args) {
        int[] arr = {1,3,6,4,2,5};

        insertionSortFunction(arr);
    }
}
