package Array;

public class Ques30_MinimumSizeSubarrayWithTargetSum {
    // Sliding Window
    public static int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;

        int l = 0; int sum = 0; int ans = Integer.MAX_VALUE;
        for(int r=0; r<n; r++) {
            sum += nums[r];

            while(sum >= target){
                ans = Math.min(ans, r-l+1);
                sum -= nums[l];
                l++;
            }
        }

        return (ans == Integer.MAX_VALUE) ? 0 : ans;
    }

    public static void main(String[] args) {
        int[] arr = {2,3,1,2,4,3};

        int ans = minSubArrayLen(7, arr);

        System.out.println(ans);
    }
}
