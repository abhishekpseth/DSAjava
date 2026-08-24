package HashMap;

import java.util.*;

public class setBp8_countPairWithKDifference {
    public static int countKDifference1(int[] nums, int k) {
        Map<Integer, Integer> mp = new HashMap<>();

        Arrays.sort(nums);

        int ans = 0;

        for(int it : nums) {
            int neg = it - k;

            if(mp.containsKey(neg)) {
                ans+= mp.get(neg);
            }

            mp.put(it, mp.getOrDefault(it, 0) + 1);
        }

        return ans;
    }

    public static int countKDifference2(int[] nums, int k) {
        Map<Integer, Integer> mp = new HashMap<>();

        int count = 0;

        for(int it : nums) {
            count += mp.getOrDefault(it - k, 0);
            count += mp.getOrDefault(it + k, 0);

            mp.put(it, mp.getOrDefault(it, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        int[] arr = {3,2,1,5,4}; int k = 2;

        int ans1 = countKDifference1(arr, k);

        int ans2 = countKDifference2(arr, k);

        System.out.println(ans2);
    }
}
