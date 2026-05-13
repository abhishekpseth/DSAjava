package Array;

import java.util.Arrays;

public class Ques24_LongestConsecutiveSubsequence {
    public static int longestConsecutive(int[] arr) {
        int n = arr.length;

        Arrays.sort(arr);

        int len = 0; int ans = 0;

        for(int i=0; i<n; i++) {
            if(i == 0 || arr[i] == arr[i-1] + 1) {
                len++;
                while(i<n-1 && arr[i] == arr[i+1])i++;
            } else {
                len = 1;
            }

            ans = Math.max(ans, len);
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {100,4,200,1,3,2};

        int ans = longestConsecutive(arr);

        System.out.println(ans);
    }
}
