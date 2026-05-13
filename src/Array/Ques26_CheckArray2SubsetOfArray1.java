package Array;

import java.util.*;

public class Ques26_CheckArray2SubsetOfArray1 {
    // Method 1: Here we can't use set as we can have identical elements in each arrays, so going with HashMaps
    public static boolean fn1(int[] a, int[] b) {
        Map<Integer, Integer> mp = new HashMap<>();

        for(int it : a) {
            mp.put(it, mp.getOrDefault(it, 0) + 1);
        }

        for(int it : b) {
            if(!mp.containsKey(it))return false;

            mp.put(it, mp.get(it) - 1);
            if(mp.get(it) == 0)mp.remove(it);
        }

        return true;
    }
    public static void main(String[] args) {
        int[] a = {11, 7, 1, 13, 21, 3, 7, 3};
        int[] b = {11, 3, 7, 1, 7};

        boolean ans = fn1(a, b);
        System.out.println(ans);
    }
}
