package HashMap;

import java.util.*;

class setBp13_3SumDesc {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;

        Set<List<Integer>> s = new HashSet<>();

        for(int i=0; i<n-2; i++) {
            Map<Integer, Integer> mp = new HashMap<>();

            for(int j=i+1; j<n; j++) {
                int val = 0 - nums[i] - nums[j];

                if(mp.containsKey(val)) {
                    int k = mp.get(val);

                    List<Integer> list = Arrays.asList(nums[i], nums[j], nums[k]); // Fixed-size but mutable elements
                    Collections.sort(list); // Works perfectly in-place

                    s.add(list);
                }

                mp.put(nums[j], j);
            }
        }

        List<List<Integer>> ans = new ArrayList<>(s);

        return ans;
    }
}
