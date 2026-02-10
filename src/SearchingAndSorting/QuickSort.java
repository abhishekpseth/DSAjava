package SearchingAndSorting;

public class QuickSort {
    static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    static int partition(int[] arr, int l, int r){
        int pivot = arr[l];

        int i = l+1;
        int j = r;

        while(i<j){
            while(i <= r  && arr[i]<=pivot)i++;
            while(arr[j]>pivot)j--;
            if(i<j){
                swap(arr, i, j);
            }
        }
        swap(arr, j, l);
        return j;
    }

    static void quickSort(int[] arr, int l, int r) {
        if(l >= r)return;
        int pivot = partition(arr, l, r);
        quickSort(arr, l, pivot-1);
        quickSort(arr,pivot+1, r);
    }
    public static void main(String[] args) {
        int[] arr = {1,3,6,4,2,5};
        quickSort(arr, 0, arr.length-1);

        for(int it: arr){
            System.out.println(it);
        }
    }
}
