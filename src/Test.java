import java.util.Arrays;

public class Test {
    public static int getMinDiff(int[] arr, int k) {
        // code here
        int n = arr.length;

        Arrays.sort(arr);

        for(int it : arr) {
            System.out.print(it + " ");
        }
        System.out.println("\n");
        System.out.println("--------------");

        int smallest = arr[0] + k;
        int largest = arr[n-1] - k;

        int res = Math.abs(largest - smallest);

        System.out.println(" initial res : " + res);

        for(int i=1; i<n-1; i++){
            int mi = Integer.min(smallest, arr[i+1] - k);
            int ma = Integer.max(largest, arr[i] + k);

            System.out.println("mi : "+ mi + " ma : "+ ma);

            if(mi < 0)continue;

            res = Integer.min(res, (ma - mi));
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = {  1}; int k = 7;

        int x = getMinDiff(arr, k);

        System.out.println("ans : " + x);
    }
}