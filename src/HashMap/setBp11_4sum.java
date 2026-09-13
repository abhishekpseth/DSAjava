package HashMap;

import java.util.*;

class setBp11_4sum {
    public int countSum1(int arr[], int target) {
        // code here
        int n = arr.length;

        int ans = 0;

        for(int i=0; i<n; i++) {
            for(int j=i+1; j<n; j++) {
                Map<Integer, Integer> mp = new HashMap<>();

                for(int k=j+1; k<n; k++) {
                    int val = target - (arr[i] + arr[j] + arr[k]);

                    ans += mp.getOrDefault(val, 0);

                    mp.put(arr[k], mp.getOrDefault(arr[k], 0) + 1);
                }
            }
        }

        return ans;
    }

    // More efficient solution, based on storing sum of pairs

    public int countSum2(int arr[], int target) {
        // code here
        int n = arr.length;

        int ans = 0;

        Map<Integer, Integer> mp = new HashMap<>();

        for(int i=0; i<n; i++) {
            for(int j=i+1; j<n; j++) {
                int val = arr[i] + arr[j];
                ans = ans + mp.getOrDefault(target - val, 0);
            }

            for(int j=0; j<i; j++) {
                int val = arr[i] + arr[j];
                mp.put(val, mp.getOrDefault(val, 0) + 1);
            }
        }

        return ans;
    }
}