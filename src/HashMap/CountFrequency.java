package HashMap;

import java.util.*;

public class CountFrequency {
    public static ArrayList<ArrayList<Integer>> countFreq(int[] arr) {
        // code here
        Map<Integer, Integer> mp = new HashMap<>();

        for(int it : arr) {
            mp.put(it, mp.getOrDefault(it, 0) + 1);
        }

        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        for(Map.Entry<Integer, Integer> entry : mp.entrySet()) {
            ArrayList<Integer> internal = new ArrayList<>();

            internal.add(entry.getKey());
            internal.add(entry.getValue());

            res.add(internal);
        }

        return res;
    }

    // another way using mp.forEach
    public static ArrayList<ArrayList<Integer>> countFreq2(int[] arr) {
        // code here
        Map<Integer, Integer> mp = new HashMap<>();

        for(int it : arr) {
            mp.put(it, mp.getOrDefault(it, 0) + 1);
        }

        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        mp.forEach((key, value) -> {
            ArrayList<Integer> entry = new ArrayList<>();
            entry.add(key);
            entry.add(value);
            res.add(entry);
        });

        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 3, 5};

        countFreq(arr);
    }
}
