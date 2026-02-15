package Array;

import java.util.*;

public class GetMinMax {
    // Method 1: Sort the array and get the first and last elements. Time: O(nLog(n)) Space: O(n)
    public static ArrayList<Integer> getMinMax1(int[] arr) {
        // code Here
        ArrayList<Integer> sortedArr = new ArrayList<>();

        for(int it : arr){
            sortedArr.add(it);
        }

        Collections.sort(sortedArr);

        ArrayList<Integer> res = new ArrayList<>();

        int mini = sortedArr.get(0);
        int maxi = sortedArr.get(arr.length - 1);

        res.add(mini);
        res.add(maxi);

        return res;
    }

    // Method 2: Run a loop with constant comparison. Time: O(n) Space: O(1)
    public static ArrayList<Integer> getMinMax2(int[] arr) {
        // code Here
        ArrayList<Integer> res = new ArrayList<>();

        int mini = Integer.MAX_VALUE;
        int maxi = Integer.MIN_VALUE;

        for(int it : arr){
            mini = Integer.min(mini, it);
            maxi = Integer.max(maxi, it);
        }

        res.add(mini);
        res.add(maxi);

        return res;
    }

    // Method 3: keep dividing the array in halves and compare their min and max value. Time: O(n) Space: O(log(n))

    // This method recursively divides the array until it can no longer be split. If a segment contains only one element, that element is both the minimum and maximum. If it contains two elements, they are compared directly. For larger segments, the method finds the min and max in each half, then combines the results by taking the smaller of the two minimums and the larger of the two maximums.
    public static ArrayList<Integer> fn(int[] arr, int i, int j) {
        // when length of segment is 1
        if(i == j){
            return new ArrayList<>(Arrays.asList(arr[i], arr[i]));
        }

        int mid = (i + j) >> 1;

        ArrayList<Integer> r1 = fn(arr, i, mid);
        ArrayList<Integer> r2 = fn(arr, mid+1, j);

        ArrayList<Integer> res = new ArrayList<>();

        res.add(Integer.min(r1.get(0), r2.get(0)));
        res.add(Integer.max(r1.get(1), r2.get(1)));

        return res;
    }

    public ArrayList<Integer> getMinMax3(int[] arr) {
        // code Here
        return fn(arr, 0, arr.length - 1);
    }

    // Method 4: First check if length of array is odd or even, If odd then mini and maxi both will initially be arr[0] and pair wise comparison start from index 1, else we compare arr[0] and arr[1] and index starts from 2
    public static ArrayList<Integer> getMinMax4(int[] arr) {
        // code Here
        if(arr.length == 1)return new ArrayList<>(Arrays.asList(arr[0], arr[0]));

        int mini; int maxi; int startIndex;

        if(arr.length % 2 == 1){
            mini = arr[0];
            maxi = arr[0];
            startIndex = 1;
        } else {
            mini = Math.min(arr[0], arr[1]);
            maxi = Math.max(arr[0], arr[1]);
            startIndex = 2;
        }

        for(int i=1; i<arr.length-1; i++){
            mini = Math.min(mini, Math.min(arr[i], arr[i+1]));
            maxi = Math.max(maxi, Math.max(arr[i], arr[i+1]));
        }

        ArrayList<Integer> res = new ArrayList<>();

        res.add(mini);
        res.add(maxi);

        return res;
    }

    public static void main(String[] args) {
        int[] arr = {12, 3, 15, 7, 9};

        ArrayList<Integer> res = getMinMax4(arr);

        System.out.println(res.toString());
    }
}
