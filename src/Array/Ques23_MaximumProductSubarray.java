package Array;

public class Ques23_MaximumProductSubarray {
    public static int fn(int[] arr) {
        int n = arr.length;

        int prefix = 1; int suffix = 1; int ans = Integer.MIN_VALUE;

        for(int i=0; i<n; i++) {
            if(prefix == 0)prefix = 1;

            prefix = prefix*arr[i];
            ans = Math.max(ans, prefix);
        }

        for(int i=0; i<n; i++) {
            if(suffix == 0)suffix = 1;

            suffix = suffix*arr[n-i-1];
            ans = Math.max(ans, suffix);
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {-2, 6, -3, -10, 0, 2};

        int ans = fn(arr);

        System.out.println(ans);
    }
}
