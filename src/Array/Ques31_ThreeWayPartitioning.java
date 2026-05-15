package Array;

public class Ques31_ThreeWayPartitioning {
    public static void swap(int[] arr, int i, int j){
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }

    public static void threeWayPartition(int arr[], int a, int b) {
        // code here
        int n = arr.length;

        int lo=0; int hi=n-1; int mid = 0;

        while(mid <= hi) {
            if(arr[mid] < a) {
                swap(arr, lo, mid);
                lo++; mid++;
            } else if(arr[mid] <= b) {
                mid++;
            } else {
                swap(arr, mid, hi);
                hi--;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 4, 3, 6, 2, 1}; int a = 1; int b = 3;

        threeWayPartition(arr, a, b);
    }
}
