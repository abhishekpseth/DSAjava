import java.util.*;

public class Test {
    public static ArrayList<ArrayList<Integer>> countFreq(int[] arr) {
        // code here
        Map<Integer, Integer> mp = new HashMap<>();

        for(int it : arr) {
            mp.put(it, mp.getOrDefault(it, 0) + 1);
        }

        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        // another way using mp.forEach
        mp.forEach((key, value) -> {
            ArrayList<Integer> entry = new ArrayList<>();
            entry.add(key);
            entry.add(value);
            res.add(entry);
        });

        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 0, 0, 0};

        countFreq(arr);
    }
}