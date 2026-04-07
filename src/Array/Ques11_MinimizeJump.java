package Array;

public class Ques11_MinimizeJump {
    public static int minJumps(int[] arr) {
        // code here
        int n = arr.length;

        int lastJumpPos = 0; int jump = 0; int reach = 0;

        // going till second last only since our target is last element
        for(int i = 0; i < n - 1; i++) {
            reach = Math.max(reach, i + arr[i]);

            // it can't go any further
            if(reach == i) {
                return -1;
            }

            // it has reached to end of its current reach
            if(i == lastJumpPos){
                lastJumpPos = reach;
                jump++;
            }

            // if the last jump pos crosses the limit then break
            if(lastJumpPos >= n-1)break;
        }

        return jump;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 0, 0, 0};

        int x = minJumps(arr);

        System.out.println("ans : " + x);
    }
}
