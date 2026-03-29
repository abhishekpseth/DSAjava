public class Test {
    public static void swap(int[] arr, int i, int j){
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 0, 1, 2};

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

        for(int it : arr){
            System.out.print(it+" ");
        }
    }
}


