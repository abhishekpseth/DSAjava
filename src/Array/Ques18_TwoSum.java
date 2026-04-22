package Array;

import java.util.*;

public class Ques18_TwoSum {
    public static ArrayList<ArrayList<Integer>> getPairs(int[] arr) {
        // code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        Map<Integer, Integer> mp = new HashMap<>();

        for (int num : arr) {
            mp.put(num, mp.getOrDefault(num, 0) + 1);
        }

        for(Map.Entry<Integer, Integer> entry : mp.entrySet()){
            int key = entry.getKey();
            int val = entry.getValue();

            if(key == 0 && val > 1){
                // res.add(Arrays.asList(0, 0)); The list returned by Arrays.asList() is fixed-size.
                res.add(new ArrayList<>(Arrays.asList(0, 0))); // dynamic size, you can update later
            } else if(key < 0){
                Integer pos = (-1)*key;
                Integer neg = key;

                if(mp.containsKey(pos)) {
                    ArrayList<Integer> pair = new ArrayList<>();
                    pair.add(neg);
                    pair.add(pos);

                    res.add(pair);
                }
            }
        }

        Collections.sort(res, (list1, list2) -> list1.get(0).compareTo(list2.get(0)));

        return res;
    }

    public static void main(String[] args) {
        int[] arr = {-1, 0, 1, 2, -1, -4};
        ArrayList<ArrayList<Integer>> res = getPairs(arr);

        System.out.println(res);
    }
}
