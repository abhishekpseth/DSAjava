package Array;

public class Ques15_NextPermutation {
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void reverse(int[] arr, int start, int end) {
        while(start<end){
            swap(arr, start, end);
            start++; end--;
        }
    }

    public static void nextPermutation(int[] nums) {
        // 1 2 3 4 5
        // 1 2 3 5 4
        // 1 3 2 4 5
        // 1 3 2 5 4
        // 1 3 4 2 5
        // 1 3 4 5 2
        // 1 3 5 2 4
        // 1 3 5 4 2
        // 1 4 2 3 5

        // GET TO THE POINT JISKE RIGHT ME CONTINOUSLY DECREASING TREND HAI
        // IF THAT POINT IS NOT THE SECOND ELEMENT THEN EXCHANGE THE ITS IMMEDIATE LEFT ITEM WITH THE ITEM JUST GREATER THAN IT (THE LEFT ONE).
        // NOW SORT THE RIGHT PART

        // OR SWAP THE LEFT WITH THE JUST IMMEDIATE ONE AND ROTATE WHOLE RIGHT PART

        int n = nums.length;

        int i = n-1;

        while(i>0 && nums[i] <= nums[i-1])i--;

        if(i == 0){
            reverse(nums, 0, n-1);
            return;
        } else {
            int left = nums[i-1];
            int justBig = -1;

            for(int j=i; j<n; j++){
                if(nums[j] > left){
                    justBig = j;
                }
            }

            swap(nums, i-1, justBig);

            reverse(nums, i, n-1);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,3,5,4,2};

        nextPermutation(arr);
    }
}
