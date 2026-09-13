package HashMap;

import java.util.*;

class setBp14_4SumDesc2 {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int n = nums1.length;

        int ans = 0;

        Map<Integer, Integer> mp = new HashMap<>();

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                int val = nums1[i] + nums2[j];
                mp.put(val, mp.getOrDefault(val, 0) + 1);
            }
        }

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                int val = -(nums3[i] + nums4[j]);

                ans += mp.getOrDefault(val, 0);
            }
        }

        return ans;
    }
}

