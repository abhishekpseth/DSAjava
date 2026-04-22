package Array;

public class Ques16_CountInversions {
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int count = 0;
    public static void merge(int[] arr, int start, int end, int mid) {
        int[] temp = new int[end - start + 1];

        int i=start; int j = mid + 1; int k = 0;

        while(i<=mid && j<=end){
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                count += (mid-i+1);
                temp[k++] = arr[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        while (j <= end) {
            temp[k++] = arr[j++];
        }

        for (int x = 0; x < temp.length; x++) {
            arr[start + x] = temp[x];
        }
    }

    public static void mergeSort(int[] arr, int start, int end) {
        if(start >= end)return;

        int mid = (start + end) >> 1;

        mergeSort(arr, start, mid);
        mergeSort(arr, mid+1, end);
        merge(arr, start, end, mid);
    }

    public static int inversionCount(int[] arr) {
        // Code Here
        count = 0;
        int n = arr.length;
        mergeSort(arr, 0, n-1);
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 1, 3, 5};

        int res = inversionCount(arr);

        System.out.println(res);
    }
}
