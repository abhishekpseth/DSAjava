package HashMap;

import java.util.*;

class setBp12_2SumDesc {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> mp = new HashMap<>();

        int n = nums.length;

        for(int i=0; i<n; i++) {
            int rem = target - nums[i];

            if(mp.containsKey(rem)) return new int[]{i, mp.get(rem)};

            mp.put(nums[i], i);
        }

        return new int[]{-1, -1};
    }
}