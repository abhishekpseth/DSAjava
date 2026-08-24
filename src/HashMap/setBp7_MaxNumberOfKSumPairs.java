package HashMap;

import java.util.*;

public class setBp7_MaxNumberOfKSumPairs {
    public static int maxOperations1(int[] nums, int k) {
        Map<Integer, Integer> mp = new HashMap<>();

        Arrays.sort(nums);

        int ans = 0;

        for(int it : nums) {
            int rem = k - it;

            if(rem == 0) continue ;

            if(mp.containsKey(rem)) {
                ans += 1;
                if(mp.get(rem) > 1) {
                    mp.put(rem, mp.get(rem) - 1);
                } else {
                    mp.remove(rem);
                }
            } else {
                mp.put(it, mp.getOrDefault(it, 0) + 1);
            }
        }

        return ans;
    }

    public static int maxOperations2(int[] nums, int k) {
        Arrays.sort(nums);

        int left = 0; int right  = nums.length - 1;

        int ans = 0;

        while(left < right) {
            if(nums[left] + nums[right] == k) {
                ans += 1;
                left++;
                right--;
            } else if (nums[left] + nums[right] > k) right--;
            else left++;
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {3,1,5,1,1,1,1,1,2,2,3,2,2}; int k = 1;
        int[] arr2 = {3,1,3,4,3}; int k2 = 6;

        int ans1 = maxOperations1(arr, k);
        int ans2 = maxOperations2(arr2, k2);

        System.out.println(ans2);
    }
}
