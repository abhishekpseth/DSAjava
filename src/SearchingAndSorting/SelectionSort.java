package SearchingAndSorting;


// Algorithm here is, for each iteration i of array get the minimum of the array (from index i-1 to n-1) and swap it with the (i-1) index (e.g.
// for first iteration minimum should be placed at 0th index then for second iteration, 1st index and so on).

// Ex: [3,6,4,2,1,5]

// Iteration 1: minimum = 1, replace 1 with 3 -> [1,6,4,2,3,5]
// Iteration 2: minimum = 2, replace 2 with 6 -> [1,2,4,6,3,5]
// Iteration 3: minimum = 3, replace 3 with 4 -> [1,2,3,6,4,5]
// Iteration 4: minimum = 4, replace 4 with 6 -> [1,2,3,4,6,5]
// Iteration 5: minimum = 5, replace 5 with 6 -> [1,2,3,4,5,6]

// here, if the length of array is N, number of iteration = N-1. for each iteration we have to find the minimum of the array from index i-1 to n-1.
// so again, tc = O(N^2)
// it requires less number of swaps compared to other algorithms.
// Selection sort has a time complexity of O(n^2) makes it slower compared to algorithms like Quick Sort or Merge Sort.
// Heap Sort algorithm is based on Selection Sort.

public class SelectionSort {
    static void selectionSortFunction(int[] arr){
        int n = arr.length;

        for(int i=0; i<n-1; i++){
            int mini = i;

            for(int j=i+1; j<n; j++){
                if(arr[j] < arr[mini]){
                    mini = j;
                }
            }

            int temp = arr[mini];
            arr[mini] = arr[i];
            arr[i] = temp;
        }

        for(int it: arr){
            System.out.println(it);
        }
    }
    public static void main(String[] args) {
        int[] arr = {1,3,6,4,2,5};

        selectionSortFunction(arr);
    }
}
