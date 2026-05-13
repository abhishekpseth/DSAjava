package Array;

import java.util.*;

public class Ques27_ThreeSum {
    // Method: Keeping one fix and 2 pointer for rest of the two
    public static boolean hasTripletSum(int arr[], int target) {
        // code Here
        int n = arr.length;

        Arrays.sort(arr);

        for(int i=0; i<n; i++) {
            int l = i+1; int r = n-1;

            while(l < r) {
                int sum = arr[i] + arr[l] + arr[r];
                if(sum == target)return true;
                else if (sum > target)r--;
                else l++;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] arr = {1, 4, 45, 6, 10, 8}; int k = 13;

        boolean res = hasTripletSum(arr, k);

        System.out.println(res);
    }
}
