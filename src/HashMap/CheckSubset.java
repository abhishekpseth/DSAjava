package HashMap;

import java.util.*;

class CheckSubset {
    public Map<Integer, Integer> getMap(int arr[]) {
        Map<Integer, Integer> mp = new HashMap<>();

        for(int it : arr) {
            mp.put(it, mp.getOrDefault(it, 0) + 1);
        }

        return mp;
    }

    public boolean isSubset(int a[], int b[]) {
        // Your code here

        Map<Integer, Integer> mp1 = getMap(a);
        Map<Integer, Integer> mp2 = getMap(b);

        for(Map.Entry<Integer, Integer> entry : mp2.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();

            if(!mp1.containsKey(key) || mp1.get(key) < value) return false;
        }

        return true;
    }
}
