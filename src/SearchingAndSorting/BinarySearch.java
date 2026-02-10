package SearchingAndSorting;


public class BinarySearch {
    static void binarySearchFunction(int[] arr, int k){
        int n = arr.length;

        int lo = 0; int hi = n-1;

        boolean found = false;

        while(lo<=hi){
            int mid = (lo + hi) >> 1;

            if(arr[mid] > k){
                hi = mid-1;
            } else if (arr[mid] < k){
                lo = mid+1;
            } else {
                found = true;
                break;
            }
        }

        if(found){
            System.out.println("Found");
        } else {
            System.out.println("Not Found");
        }
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        int k = 4;
        binarySearchFunction(arr, k);
    }
}
