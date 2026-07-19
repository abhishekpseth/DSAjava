package HashMap;

import java.util.HashMap;
import java.util.Map;

public class SetBP1_SubarrayWithSumK {
    public static int cntSubarrays(int[] arr, int k) {
        // code here
        Map<Integer, Integer> mp = new HashMap<>();

        int sum = 0;
        int count = 0;

        mp.put(0, 1);

        for(int it : arr) {
            sum += it;
            count += mp.getOrDefault(sum - k, 0);
            mp.put(sum, mp.getOrDefault(sum, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        int[] arr = {10, 2, -2, -20, 10}; int k = -10;
        cntSubarrays(arr, k);
    }
}
