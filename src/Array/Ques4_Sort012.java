package Array;

public class Ques4_Sort012 {
    public static void swap(int[] arr, int i, int j){
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }

    // Method 1: Using 2 pointer, first treat 0 and 1 as 0 and segregate (0 + 1) and 2. then similarly segregate 0 and 1.
    public static void sort012_1(int[] arr) {
        int i=0; int j=arr.length - 1;

        while(i <= j){
            while(i<=j && (arr[i] == 0 || arr[i] == 1))i++;
            while(i<=j && arr[j] == 2)j--;

            if(i<=j){
                swap(arr, i, j);
                i++; j--;
            }
        }

        int k=0;

        while(k < arr.length - 1 && (arr[k] == 0 || arr[k] == 1) && (arr[k+1] == 0 || arr[k+1] == 1)){
            k++;
        }

        i=0;

        while(i <= k){
            while(i<=k && (arr[i] == 0))i++;
            while(i<=k && arr[k] == 1)k--;

            if(i<=k){
                swap(arr, i, k);
                i++; k--;
            }
        }
    }


    // Method 2: Using binary search like flow
    public void sort012_2(int[] arr) {
        int lo = 0;
        int mid = 0;
        int hi = arr.length - 1;

        while(mid <= hi){
            if(arr[mid] == 0) {
                swap(arr, lo, mid);
                lo++; mid++;
            } else if(arr[mid] == 1){
                mid++;
            } else {
                swap(arr, mid, hi);
                hi--;
            }
        }
    }

    // Method 3: Using Counting Sort
    public static void sort012_3(int[] arr) {
        int[] freq = new int[3];

        for(int it : arr){
            freq[it]++;
        }

        int k=0;
        for(int i=0; i<arr.length; i++){
            while(freq[k] == 0)k++;

            arr[i] = k;
            freq[k]--;
        }
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 0, 1, 2};

        sort012_3(arr);

        for(int it : arr){
            System.out.println(it);
        }
    }
}
