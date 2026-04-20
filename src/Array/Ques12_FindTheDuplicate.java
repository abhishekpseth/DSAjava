package Array;

//Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
//There is only one repeated number in nums, return this repeated number.
//You must solve the problem without modifying the array nums and using only constant extra space.
//

//Example 1:
//Input: nums = [1,3,4,2,2]
//Output: 2

//Example 2:
//Input: nums = [3,1,3,4,2]
//Output: 3

//Example 3:
//Input: nums = [3,3,3,3,3]
//Output: 3

import java.util.*;

public class Ques12_FindTheDuplicate {
    // Method 1: brute force
    public static int findDuplicate1(int[] nums) {
        int n = nums.length;

        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                if(nums[i] == nums[j])return nums[i];
            }
        }

        return -1;
    }

    // Method 2: sort and check alternate
    public static int findDuplicate2(int[] nums) {
        int n = nums.length;

        Arrays.sort(nums);

        for(int i=0; i<n-1; i++){
            if(nums[i] == nums[i+1])return nums[i];
        }

        return -1;
    }

    // Method 3: sum of all items - sum of 1...n-1
    public static int findDuplicate3(int[] nums) {
        int n = nums.length;

        int sx = (n-1)*((n-1)+1)/2;

        int sy = 0;

        for(int it : nums) {
            sy += it;
        }

        return sy - sx;
    }

    // Method 4: Using Map
    public static int findDuplicate4(int[] nums) {
        Map<Integer, Integer> mp = new HashMap<>();

        for (int num : nums) {
            mp.put(num, mp.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : mp.entrySet()) {
            if(entry.getValue() >= 2){
                return entry.getKey();
            }
        }

        return -1;
    }


    // Method 5: Hare and tortoise (or Slow and Fast pointer)
    // in this if we keep on going through nums[element] it will get in a loop
    // for that loop we will find the common point

    public int findDuplicate5(int[] nums) {
        int n = nums.length;

        int slow = nums[0];
        int fast = nums[0];

        do{
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        fast = nums[0];
        while(slow != fast){
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }

    // Method 6: Use binary search, for any element, count the total number of element with value less than it, if it is less thant
    public static int findDuplicate6(int[] nums) {
        int n = nums.length;

        int lo = 0;
        int hi = n - 1;

        while(lo <= hi){
            int mid = (lo + hi) >> 1;

            int count = 0;

            for(int i=0; i<n; i++){
                if(nums[i] <= mid){
                    count++;
                }
            }

            if(count > mid){
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return lo;
    }

    // Method 7: Use set to check if it contains the element if yes return it else add it to set.
    public static int findDuplicate7(int[] nums) {
        Set<Integer> s = new HashSet<>();

        for(int it : nums){
            if(s.contains(it))return it;
            s.add(it);
        }

        return -1;
    }

    // Method 8: Building the answer bit by bit
    public int findDuplicate(int[] nums) {
        int n = nums.length;

        int ans = 0;

        for(int bit=0; bit<32; bit++){
            int mask = 1 << bit;
            int countInNums = 0; int countInRange = 0;

            for(int num : nums) {
                if((num & mask) != 0){
                    countInNums++;
                }
            }

            for(int i=1; i<n; i++){
                if((i & mask) != 0){
                    countInRange++;
                }
            }

            if(countInNums > countInRange) {
                ans = ans | mask;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr= {1,3,4,2,2};

        int x = findDuplicate1(arr);

        System.out.println(x);
    }
}
