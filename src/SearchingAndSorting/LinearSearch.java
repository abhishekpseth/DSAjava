package SearchingAndSorting;

public class LinearSearch {
    static void linearSearchFunction(int[] arr, int k){
        int n = arr.length;

        boolean found = false;

        for(int i=0; i<n; i++){
            if(arr[i] == k) {
                found = true;
                break;
            }
        }

        if(found){
            System.out.println("Found");
        } else {
            System.out.println("Not found");
        }
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        int k = 9;
        linearSearchFunction(arr, k);
    }
}
