package SearchingAndSorting;

// ------------------ Bubble Sort -------------------

// Here the algorithm is we keep on comparing the alternate indexes and swap them if they are left one < right one.
// and keep on continuing thing iteration by iteration.

// For example length or array is 6, then for each iteration 5 comparisons will be done.

// iteration 1 :

// [1,3,6,4,2,5] -> checking 1,3
// [1,3,6,4,2,5] -> no swap, checking 3,6
// [1,3,6,4,2,5] -> no swap, checking 6,4
// [1,3,4,6,2,5] -> swap 4 & 6, checking 6,2
// [1,3,4,2,6,5] -> swap 2 & 6, checking 6,5

// iteration 2:

// [1,3,4,2,5,6] -> swap 5 & 6, checking 1,3
// [1,3,4,2,5,6] -> no swap, checking 3,4
// [1,3,4,2,5,6] -> no swap, checking 4,2
// [1,3,2,4,5,6] -> swap 2 & 4, checking 4,5
// [1,3,2,4,5,6] -> no swap, checking 5,6

// iteration 3:
// [1,3,2,4,5,6] -> no swap, checking 1,3
// [1,3,2,4,5,6] -> no swap, checking 3,2
// [1,2,3,4,5,6] -> swap 2 & 3, checking 3,4
// [1,2,3,4,5,6] -> no swap, checking 4,5
// [1,2,3,4,5,6] -> no swap, checking 5,6

// in the worst case, it will take 5 iterations for sorting the whole array. which will bring time complexity to O(N^2).
// One observation is here, that first iteration places the largest number at then end (i.e. its correct position).
// Similarly second iteration corrects the second last index. so for each iteration we can do one comparison less.

// calculation final time complexity:

//    At pass 1:
//    Number of comparisons = (N-1)
//    Number of swaps = (N-1)

//    At pass 2:
//    Number of comparisons = (N-2)
//    Number of swaps = (N-2)

//    At pass 3:
//    Number of comparisons = (N-3)
//    Number of swaps = (N-3)

//    At pass N-1:
//    Number of comparisons = 1
//    Number of swaps = 1

//    Now, calculating total number of comparison required to sort the array
//            = (N-1) + (N-2) +  (N-3) + . . . 2 + 1
//            = (N-1)*(N-1+1)/2  { by using sum of N natural Number formula }
//            = (N * (N-1)) / 2
//
//    In worst case, Total number of swaps = Total number of comparison
//    Total number of comparison (Worst case) = N(N-1)/2
//    Total number of swaps (Worst case) = N(N-1)/2
//
//    So worst case time complexity is O(N2) as N2 is the highest order term.

public class BubbleSort {
    static void bubbleSortFunction(int[] arr){
        int n = arr.length;

        for(int i=0; i<n-1; i++){
            boolean isAnySwapped = false;
            for(int j=0;j<n-i-1;j++){
                if(arr[j] <= arr[j+1])continue;

                int temp = arr[j];
                arr[j] = arr[j+1];
                arr[j+1] = temp;
                isAnySwapped = true;
            }
            if(!isAnySwapped)break; // for early return, since we now know that array is not sorted
        }

        for(int it:arr){
            System.out.println(it);
        }
    }
    public static void main(String[] args) {
        int[] arr = {1,3,6,4,2,5};

        bubbleSortFunction(arr);
    }
}
