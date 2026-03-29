public class Test {
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

        for(int it : arr){
            System.out.println(it);
        }

        return i;
    }

    public static int quickSort(int[] arr, int l, int r, int k) {
        if(l >= r)return -1;

        int pivot = partition(arr, l, r);

        if(pivot == k)return arr[pivot];
        else if (pivot > k) return quickSort(arr, l, pivot - 1, k);
        else return quickSort(arr, pivot + 1, r, k);
    }

    public static void main(String[] args) {
        int[] arr = {7, 10, 4, 3, 20, 15}; int k = 3;

        int x = quickSort(arr, 0, arr.length - 1, k);

        System.out.println("x : "+x);
    }
}


