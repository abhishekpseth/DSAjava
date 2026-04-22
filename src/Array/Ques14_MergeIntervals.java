package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ques14_MergeIntervals {
    // Method: sort the list, then add the first interval, from the second interval if its starting time is less than end time then merge them
    // (update end time with max of current end time and the elements end time), if not then add it directly

    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> ans = new ArrayList<>();

        for (int[] curr : intervals) {
            if (ans.isEmpty() || ans.get(ans.size() - 1)[1] < curr[0]) {
                ans.add(curr);
            } else {
                ans.get(ans.size() - 1)[1] = Math.max(
                        ans.get(ans.size() - 1)[1],
                        curr[1]
                );
            }
        }

        return ans.toArray(new int[ans.size()][]);
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};

        merge(arr);
    }
}
