package HashMap;

import java.util.*;

class setBp9_numberOfPairsOfStringWithConcatenationEqualToTarget {
    public int numOfPairs(String[] nums, String target) {
        Map<String, Integer> mp = new HashMap<>();

        int ans = 0;

        for(String s : nums) {
            if(s.length() > target.length()) continue;

            String sLeft = target.substring(0, s.length());
            String sLeftRemaining = target.substring(s.length(), target.length());

            String sRight = target.substring(target.length() - s.length(), target.length());
            String sRightRemaining = target.substring(0, target.length() - s.length());


            if(s.equals(sLeft)) {
                ans = ans + mp.getOrDefault(sLeftRemaining, 0);
            }

            if(s.equals(sRight)) {
                ans = ans + mp.getOrDefault(sRightRemaining, 0);
            }

            mp.put(s, mp.getOrDefault(s, 0) + 1);
        }

        return ans;
    }
}

// nums = ["777","7","77","77"], target = "7777"

// 0 1
// 1 0
// 2 3
// 3 2

// "777" : 1
// "7" : since "777" is present once and i can use in 2 ways, from front as well as back
// "77" : 1
// "77" : 2 ways

// ===============================================

// nums = ["123","4","12","34"], target = "1234"

// 0 1
// 2 3

// "123" : 1
// "4" : i need "123", and its present so +1
// "12" : i need "34" but its not present
// "34" : i need "12" and its present so +1

// ===============================================

// nums = ["1","1","1"], target = "11"

// 0 1
// 1 0
// 1 2
// 2 1
// 0 2
// 2 0

// "1" : 1
// "1" : i need 1 for both front and back, so +2, and in count by 1
// "1" : i need 1 for both front and back, so +2*2 , so total is 2 + 4 = 6



