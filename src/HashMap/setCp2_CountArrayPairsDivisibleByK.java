package HashMap;

import java.util.*;

class setCp2_CountArrayPairsDivisibleByK {
    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public long countPairs(int[] nums, int k) {
        Map<Integer, Integer> mp = new HashMap<>();

        long ans = 0;

        for(int it : nums) {
            int p = gcd(it, k);

            int need = k/p;

            for(Map.Entry<Integer, Integer> entry : mp.entrySet()) {
                if(entry.getKey()%need == 0) ans += entry.getValue();
            }

            mp.put(p, mp.getOrDefault(p, 0) + 1);
        }

        return ans;
    }
}