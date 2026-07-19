package HashMap;

import java.util.*;

public class MaxDistanceBetweenSameElement {
    public int maxDistance(int[] arr) {
        // Code here
        Map<Integer, Integer> mp = new HashMap<>();

        int res = 0;

        for(int i=0; i<arr.length; i++) {
            if(mp.containsKey(arr[i])) {
                res = Math.max(res, i - mp.get(arr[i]));
            } else {
                mp.put(arr[i], i);
            }
        }

        return res;
    }
}