package HashMap;

import java.util.*;

public class TwoSum {
    static boolean twoSum(int arr[], int target) {
        // code here

        Map<Integer, Integer> mp = new HashMap<>();

        for(int it : arr) {
            int rem = target - it;

            if(mp.containsKey(rem)) return true;

            mp.put(it, mp.getOrDefault(it, 0) + 1);
        }

        return false;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,4,5}; int target = 6;
        boolean res = twoSum(arr, target);
    }
}


