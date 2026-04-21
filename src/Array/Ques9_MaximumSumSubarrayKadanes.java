package Array;

public class Ques9_MaximumSumSubarrayKadanes {
    // Concept is to, we will create an array which will be used to get summation upto ith index.
    // Now we will traverse summation, and store the value of minimum till now starting with 0
    // we will look for the maximum value we can get for element - (minimum till that point)

    public static int maxSubarraySum(int[] arr) {
        // Code here
        int n = arr.length;

        int[] summation = new int[n];

        int sum = 0;
        for(int i=0; i<n; i++){
            sum += arr[i];
            summation[i] = sum;
        }

        int mini = 0;

        int res = Integer.MIN_VALUE;
        for(int it : summation){
            res = Integer.max(res, it - mini);
            mini = Integer.min(mini, it);
        }

        return res;
    }

    // Method 2: If you observe, you don't actually need the summation array
    public static int maxSubarraySum2(int[] arr) {
        // Code here
        int n = arr.length;

        int sum = 0;
        int mini = 0;
        int ans = Integer.MIN_VALUE;

        for (int it : arr) {
            sum = sum + it;
            ans = Math.max(ans, sum - mini);
            mini = Math.min(mini, sum);
        }

        return ans;
    }

    // Method 3: Iterate through the array, for each element, if the sum is negative, then make it zero, then add the current element to it.
    // now answer should be max of ans and sum.

    public static int maxSubarraySum3(int[] arr) {
        // Code here
        int n = arr.length;

        int sum = 0;
        int ans = Integer.MIN_VALUE;

        for(int i=0; i<n; i++){
            if(sum < 0) sum = 0;
            sum += arr[i];
            ans = Math.max(ans, sum);
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {5, -3, 7, 6, 5};

        int res = maxSubarraySum(arr);

        System.out.println(res);
    }
}
