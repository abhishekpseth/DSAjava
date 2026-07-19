package HashMap;

import java.util.*;

public class p6_checkDuplicatesWithinKDistance {
    public boolean checkDuplicatesWithinK(int[] arr, int k) {
        // your code
        Map<Integer, Integer> mp = new HashMap<>();

        for(int i=0; i<arr.length; i++) {
            if(mp.containsKey(arr[i])) {
                if(i - mp.get(arr[i]) <= k) return true;
            }
            mp.put(arr[i], i);
        }

        return false;
    }
}
