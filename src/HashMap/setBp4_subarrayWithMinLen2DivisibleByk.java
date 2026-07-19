package HashMap;

import java.util.*;

public class setBp4_subarrayWithMinLen2DivisibleByk {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> mp = new HashMap<>();

        int sum = 0;
        int count = 0;

        mp.put(0, -1);

        for(int i=0; i<nums.length; i++) {
            sum += nums[i];

            int val = (sum%k + k)%k;

            if(mp.containsKey(val)) {
                if(i - mp.get(val) >= 2) return true;
            }else {
                mp.put(val, i);
            }
        }

        return false;
    }
}
