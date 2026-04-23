package Array;

import java.util.*;

public class Ques19_CommonInThreeSortedArray {
    // Method 1: traverse each list, for each list mark the number to it only if it is seen in the previous list
    public static ArrayList<Integer> commonElements(int[] a, int[] b, int[] c) {
        // code here
        Map<Integer, Integer> mp = new HashMap<>();

        for(int num : a) {
            mp.put(num, 1);
        }

        for(int num : b) {
            if(mp.containsKey(num) && mp.get(num) == 1) {
                mp.put(num, 2);
            }
        }

        for(int num : c) {
            if(mp.containsKey(num) && mp.get(num) == 2) {
                mp.put(num, 3);
            }
        }


        ArrayList<Integer> ans = new ArrayList<>();

        for(Map.Entry<Integer, Integer> entry : mp.entrySet()){
            int key = entry.getKey();
            int val = entry.getValue();

            if(val == 3) {
                ans.add(key);
            }
        }

        Collections.sort(ans, (x, y) -> Integer.compare(x, y));

        return ans;
    }

    // Method 2: check the flow in code
    public ArrayList<Integer> commonElements2(int[] a, int[] b, int[] c) {
        // code here
        int n1 = a.length; int n2 = b.length; int n3 = c.length;

        ArrayList<Integer> ans = new ArrayList<>();

        int i=0; int j = 0; int k = 0;

        while(i<n1 && j<n2 && k<n3) {
            if(a[i] == b[j] && b[j] == c[k]) {
                ans.add(a[i]);

                i++; j++; k++;

                while(i < n1 && a[i] == a[i-1])i++;
                while(j < n2 && b[j] == b[j-1])j++;
                while(k < n3 && c[k] == c[k-1])k++;
            } else if(a[i] < b[j]) {
                i++;
            } else if(b[j] < c[k]) {
                j++;
            } else if(c[k] < a[i]) {
                k++;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] a = {1, 5, 10, 20, 40, 80};
        int[] b = {6, 7, 20, 80, 100};
        int[] c = {3, 4, 15, 20, 30, 70, 80, 120};

        ArrayList<Integer> ans = commonElements(a, b, c);
    }
}
