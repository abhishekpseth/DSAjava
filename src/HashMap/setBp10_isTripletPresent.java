package HashMap;

import java.util.*;

class setBp10_isTripletPresent {
    public boolean hasTripletSum(int arr[], int target) {
        // code Here

        int n = arr.length;

        for(int i=0; i<n; i++) {
            Map<Integer, Integer> mp = new HashMap<>();

            for(int j=i+1; j<n; j++) {
                int val = target - (arr[i] + arr[j]);

                if(mp.containsKey(val)) return true;

                mp.put(arr[j], mp.getOrDefault(arr[j], 0) + 1);
            }
        }

        return false;
    }
}