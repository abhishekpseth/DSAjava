package HashMap;

import java.util.*;

public class SetBP2_SmallestSubarrayWithSumK {
    public static int smallestSubarrayLengthWithSumK(int[] arr, int k) {
        // the last problem we solved was subarray with sum k. it was asking for number of such subarrays. this question is little changed,
        // and it is asking for the length of subarray which is minimum among all of them
        // for that we should along with the sum know the position too at which they occurred
        // so in map we will store all the positions for which a sum has been seen, for an item, we will see if the value (currSum - k) has already been seen, if yes
        // then we will try to find the minimum distance, and we will appy Math.min over the answer.

        Map<Integer, List<Integer>> mp = new HashMap<>();

        // base case
        List<Integer> list = new ArrayList<>();
        list.add(-1);
        mp.put(0, list);

        int sum = 0; int ans = Integer.MAX_VALUE;

        for(int i=0; i<arr.length; i++) {
            sum += arr[i];
            if(mp.containsKey(sum - k)) {
                List<Integer> pos = mp.get(sum - k);
                int miniPos = Collections.max(pos); // just to get Last element of the array
                ans = Math.min(ans, i - miniPos);
            }

            List<Integer> pos;
            if(mp.containsKey(sum)) {
                pos = mp.get(sum);
            } else {
                pos = new ArrayList<>();
            }

            pos.add(i);
            mp.put(sum, pos);
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public static int smallestSubarrayLengthWithSumK2(int[] arr, int k) {
        Map<Integer, Integer> mp = new HashMap<>();

        int sum = 0; int ans = Integer.MAX_VALUE;

        mp.put(0, -1);

        for(int i=0; i<arr.length; i++) {
            sum += arr[i];

            if(mp.containsKey(sum - k)) {
                ans = Math.min(ans, i - mp.get(sum - k));
            }

            mp.put(sum, i);
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 6, 10, 2, 1}; int k = 12;

        int ans = smallestSubarrayLengthWithSumK2(arr, k);

        System.out.println(ans);
    }
}
