package Array;

import java.util.*;

public class Ques20_RearrangeToAlternatePositiveNegative {
    // Using 2 stacks
    public static void rearrange(ArrayList<Integer> arr) {
        int n = arr.size();

        Queue<Integer> q1 = new LinkedList<>(); // 0 and Positive
        Queue<Integer> q2 = new LinkedList<>(); // Negative

        for(Integer it : arr) {
            if(it >= 0)q1.add(it);
            else q2.add(it);
        }

        int i = 0;

        while(i < n && !q1.isEmpty()) {
            int x = q1.remove();
            arr.set(i, x);

            i+= 2;
        }

        i = 1;

        while(i < n && !q2.isEmpty()) {
            int x = q2.remove();
            arr.set(i, x);

            i+= 2;
        }
    }

    // Using 2 lists
    public static void rearrange2(ArrayList<Integer> nums) {
        List<Integer> p = new ArrayList<>();
        List<Integer> n = new ArrayList<>();

        // Separate positives (including 0) and negatives
        for (int it : nums) {
            if (it >= 0) {
                p.add(it);
            } else {
                n.add(it);
            }
        }

        int px = 0, nx = 0;
        int i = 0;

        // Alternate placement
        while (px < p.size() && nx < n.size()) {
            if (i % 2 == 0) {
                nums.set(i, p.get(px));
                px++;
            } else {
                nums.set(i, n.get(nx));
                nx++;
            }
            i++;
        }

        // Remaining positives
        while (px < p.size()) {
            nums.set(i++, p.get(px++));
        }

        // Remaining negatives
        while (nx < n.size()) {
            nums.set(i++, n.get(nx++));
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(9, 4, -2, -1, 5, 0, -5, -3, 2));

        rearrange(arr);
    }
}
