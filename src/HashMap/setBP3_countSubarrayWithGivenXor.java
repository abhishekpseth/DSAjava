package HashMap;

import java.util.*;

public class setBP3_countSubarrayWithGivenXor {
    public static long subarrayXor(int arr[], int k) {
        // whats the basic property of a xor ???

        Map<Integer, Integer> mp = new HashMap<>();

        int ans = 0;
        int xor = 0;

        mp.put(0, 1);

        for(int it : arr) {
            xor ^= it;

            if(mp.containsKey(xor^k)) {
                ans += mp.get(xor^k);
            }

            mp.put(xor, mp.getOrDefault(xor, 0) + 1);
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {4, 2, 2, 6, 4};
        int k = 6;

        subarrayXor(arr, k);
    }
}
