package Array;

import java.util.*;

public class Ques21_Subarray_with_zero_sum {
    public static boolean findsum(int[] arr) {
        // Your code here
        Set<Integer> s = new HashSet<>();

        int sum = 0;

        s.add(0);

        for(int it : arr){
            sum += it;

            if(s.contains(sum)){
                return true;
            }

            s.add(sum);
        }

        return false;
    }

    public static void main(String[] args) {
        int[] arr = {4, 2, -3, 1, 6};
        boolean ans = findsum(arr);
    }
}
