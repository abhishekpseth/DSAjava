package Array;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;

class Ques3_KthSmallestElement {
    public static int kthSmallest1(int[] arr, int k){
        Arrays.sort(arr);

        return arr[k-1];
    }

    // Method 2: Using priority Queue
    public static int kthSmallest2(int[] arr, int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int it : arr){
            pq.add(it);

            if(pq.size() > k)pq.poll();
        }

        return pq.peek();
    }

    public static void swap(int[] arr, int i, int j){
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }

    public static int partition(int[] arr, int l, int r){
        int pivot = (l + r) >> 1;

        swap(arr, pivot, r);
        pivot = r;

        // Now here, write an algorithm which finds the correct position for an element in an array
        int i = l; int j = r-1;

        while(i <= j){
            while(i <= j && arr[i] <= arr[pivot])i++;
            while(i <= j && arr[j] >= arr[pivot])j--;

            if(i <= j){
                swap(arr, i, j);
            }
        }

        // so here i will be at correct position

        swap(arr, i, pivot);

        return i;
    }

    public static int quickSort(int[] arr, int l, int r, int k) {
        if(l > r)return -1;

        int pivot = partition(arr, l, r);

        if(pivot == k)return arr[pivot];
        else if (pivot > k) return quickSort(arr, l, pivot - 1, k);
        else return quickSort(arr, pivot + 1, r, k);
    }

    // Method 3: Using quick select algorithm
    public static int kthSmallest3(int[] arr, int k) {
        // Code here
        return quickSort(arr, 0, arr.length - 1, k-1);
    }

    // Method 4: Using Counting sort: when range of elements is small, we can make an array from 0 to max element,
    // and fill the array with frequency of each element and then using it to find out value at index k-1
    public static int kthSmallest4(int[] arr, int k){
        int maxi = Integer.MIN_VALUE;

        for(int it: arr){
            maxi = Integer.max(maxi , it);
        }

        int[] freq = new int[maxi+1];

        for(int it: arr){
            freq[it]++;
        }

        int sum = 0;
        for(int i=0; i<freq.length; i++){
            sum += freq[i];
            if(sum >= k)return i;
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {7, 10, 4, 3, 20, 15}; int k = 3;

        int x = kthSmallest4(arr, k);

        System.out.println("x : "+x);
    }
}
