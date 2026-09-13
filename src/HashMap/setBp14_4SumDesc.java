package HashMap;

import java.util.*;

class setBp14_4SumDesc {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;

        if(n == 0)return new ArrayList<>();

        Arrays.sort(nums);

        Set<List<Integer>> s = new HashSet<>();

        for(int i=0; i<n-3; i++) {
            if(i>0 && nums[i] == nums[i-1])continue;
            for(int j=i+1; j<n-2; j++) {
                if(j > i+1 && nums[j] == nums[j-1])continue;

                int left = j+1;
                int right = n-1;

                while(left < right) {
                    long currSum = (long) nums[i] + (long) nums[j] + (long) nums[left] + (long) nums[right];

                    if(currSum > target) right--;
                    else if (currSum < target) left++;
                    else {
                        List<Integer> l = new ArrayList<>();

                        l.add(nums[i]);
                        l.add(nums[j]);
                        l.add(nums[left]);
                        l.add(nums[right]);

                        s.add(l);

                        left++; right--;

                        while(left < right && nums[left] == nums[left - 1])left++;
                        while(left < right && nums[right] == nums[right + 1])right--;
                    }
                }
            }
        }

        List<List<Integer>> ans = new ArrayList(s);

        return ans;
    }
}