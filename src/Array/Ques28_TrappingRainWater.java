package Array;

public class Ques28_TrappingRainWater {
    public static int maxWater(int arr[]) {
        // code here
        //  3 0 1 0 4 0 2 -> arr
        // -1 3 3 3 3 4 4 -> left
        //  4 4 4 4 2 2 -1 -> right

        int n = arr.length;

        int[] left = new int[n];
        int[] right = new int[n];

        left[0] = -1;
        right[n-1] = -1;

        for(int i=1; i<n; i++) {
            left[i] = Math.max(arr[i-1], left[i-1]);
        }

        for(int i=n-2; i>=0; i--) {
            right[i] = Math.max(arr[i+1], right[i+1]);
        }

        int sum = 0;
        for(int i=0; i<n; i++) {
            if(left[i] == -1 || right[i] == -1) continue;

            sum += Math.max(Math.min(left[i], right[i]) - arr[i],0);

//            System.out.println("left : "+left[i]+" right[i] "+right[i]+" arr[i] "+arr[i]+" sum : "+ sum);
        }

        return sum;
    }

    public static void main(String[] args) {
        int[] arr = {3, 0, 1, 0, 4, 0, 2};

        int sum = maxWater(arr);

        System.out.println(sum);
    }
}
