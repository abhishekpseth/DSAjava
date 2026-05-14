package Array;

import java.util.Arrays;

public class Ques29_ChocolateDistributionProblem {
    public static int findMinDiff(int arr[], int m) {
        // code here
        int n= arr.length;

        Arrays.sort(arr);
        int mini= Integer.MAX_VALUE;

        for(int i=0;i+m-1<n;i++){
            mini= Math.min(mini, (arr[i+m-1]-arr[i]));
        }

        return mini;
    }

    public static void main(String[] args) {
        int[] arr = {3, 4, 1, 9, 56, 7, 9, 12}; int m = 5;

        int ans = findMinDiff(arr, m);

        System.out.println(ans);
    }
}
