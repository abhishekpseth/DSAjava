public class Test {
    public static void main(String[] args) {
        int[] arr = {5, -3, 7, 6, 5};

        int n = arr.length;

        int[] summation = new int[n];

        int sum = 0;
        for(int i=0; i<n; i++){
            sum += arr[i];
            summation[i] = sum;
        }

        int mini = 0;

        int res = Integer.MIN_VALUE;
        for(int it : summation){
            res = Integer.max(res, it - mini);
            mini = Integer.min(mini, it);
        }
    }
}