package HashMap;

import java.util.*;

public class setBP5_subarraySumDivByK {
    public int subarraysDivByK(int[] nums, int k) {
        // basic idea is when divisible it will have same modulo

        Map<Integer, Integer> mp = new HashMap<>();

        int ans =0; int sum = 0;

        mp.put(0, 1);

        for(int it : nums) {
            sum += it;

            int absMod = (sum%k + k)%k; // For modulation of negative numbers

            if(mp.containsKey(absMod)) {
                ans += mp.get(absMod);
            }


            mp.put(absMod, mp.getOrDefault(absMod, 0) + 1);
        }

        return ans;
    }
}
