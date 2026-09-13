package HashMap;

import java.util.*;

class setBp15_MaximumSumOfDistinctSubarraysWithLengthK {
    public long maximumSubarraySum(int[] nums, int k) {
        int n = nums.length;

        Map<Integer, Integer> mp = new HashMap<>();

        int left=0; int right=0; long sum = 0; long maxi = 0;

        while(right - left < k) {
            sum += nums[right];
            mp.put(nums[right], mp.getOrDefault(nums[right], 0) + 1);
            right++;
        }

        if(mp.size() == k) maxi = Math.max(maxi, sum);

        while(right < n) {
            sum += nums[right] - nums[left];

            if(mp.get(nums[left]) == 1) {
                mp.remove(nums[left]);
            } else {
                mp.put(nums[left], mp.getOrDefault(nums[left], 0) - 1);
            }

            mp.put(nums[right], mp.getOrDefault(nums[right], 0) + 1);

            if(mp.size() == k) maxi = Math.max(maxi, sum);

            left++; right++;
        }

        return maxi;
    }
}