package HashMap;

import java.util.*;

public class p10_CountPairWithGivenSum {
    int countPairs(int arr[], int target) {
        // code here
        Map<Integer, Integer> mp = new HashMap<>();

        int sum = 0;

        for(int it : arr) {
            int rest = target - it;

            if(mp.containsKey(rest)) {
                sum += mp.get(rest);
            }

            mp.put(it, mp.getOrDefault(it, 0) + 1);
        }

        return sum;
    }
}
