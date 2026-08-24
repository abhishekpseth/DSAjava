package HashMap;

// the logic here is basically the observation that, a + b = a ^ b only when both the numbers don't share any set bit in common
// so lets say if 2 numbers don't follow this propery, then in any way adding another number to the set won't make it follow the property.
// so what we do is basically, from each number we start checking the max window till which it can get.

public class setBp6_countSubarraWithSumEqualToXor {
    public static int countSubarray(int[] arr) {
        int N = arr.length;

        int value = 0; int ans = 0;

        int right=0;

        for(int left=0; left<N; left++) {
            while(right < N && ((value ^ arr[right]) == (value + arr[right]))) {
                value += arr[right];
                right++;
            }

            ans += right - left;

            if (left == right) right ++;
            else value -= arr[left];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};

        int count = countSubarray(arr);

        System.out.println(count);
    }
}
