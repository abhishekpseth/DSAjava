package Array;

import java.util.*;

public class MajorityElement2 {
    public static List<Integer> majorityElement(int[] nums) {
        int n = nums.length;

        int num1 = -1; int num2 = -1; int count1 = 0; int count2 = 0;

        for(int num : nums) {
            if(num == num1) {
                count1++;
            } else if(num == num2) {
                count2++;
            } else if (count1 == 0) {
                num1 = num;
                count1 = 1;
            } else if (count2 == 0) {
                num2 = num;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }

        count1 = 0; count2 = 0;
        for(int it : nums) {
            if(it == num1)count1++;
            else if(it == num2)count2++;
        }

        List<Integer> res = new ArrayList<>();

        if(count1 > n/3)res.add(num1);
        if(count2 > n/3)res.add(num2);

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {0,3,4,1,0};

        List<Integer> res  = majorityElement(nums);

        System.out.println(res);
    }
}
