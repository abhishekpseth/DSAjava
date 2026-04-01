package Array;

import java.util.Arrays;

// Here, the question ask us to increase or decrease the height of each tower by k such that there's minimum diff b/w smallest
// and largest towers and return the diff.

// Now for this, we can see, from example:
// [3, 9, 12, 16, 20]
// if we sort the array, and then see, that current range is (3, 20)
// in order to make the diff smaller, we have to make the range shorter,
// so we will add the height from left side and decrease from right side.
// now, there should be a pivot till which we increase and after that we decrease
// let's say it is on ith index, then the minimum will be min(smallest, arr[i+1] - k), why arr[i+1] - k, since, smallest will have the smallest of left side of pivot, but arr[i+1] - k will have smallest of right side of the pivot.
// similarly maximum will be max(largest, arr[i] + k), since largest will have largest of the right side, but arr[i] + k will represent largest of the right side
// res is being initialized with (arr[n-1] - arr[0]) instead of (largest - smallest) since, there are chance, when largest i.e. arr[n-1] - k turns out to be negative, so just to be on safer side we do this.
// if(mi < 0)continue; is used since problem has asked us that no height after change can be negative.

public class Ques10_MinimizeTheHeight2 {
    public static int getMinDiff(int[] arr, int k) {
        // code here
        int n = arr.length;

        Arrays.sort(arr);

        int res = arr[n-1] - arr[0];

        int smallest = arr[0] + k;
        int largest = arr[n-1] - k;

        for(int i=1; i<n-1; i++){
            int mi = Integer.min(smallest, arr[i+1] - k);
            int ma = Integer.max(largest, arr[i] + k);

            if(mi < 0)continue;

            res = Integer.min(res, (ma - mi));
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1, 8, 10, 6, 4, 6, 9, 1}; int k = 7;

        int x = getMinDiff(arr, k);

        System.out.println("ans : " + x);
    }
}
