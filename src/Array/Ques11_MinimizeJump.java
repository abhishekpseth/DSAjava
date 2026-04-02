package Array;

public class Ques11_MinimizeJump {
    public static int minJumps(int[] arr) {
        // code here
        int n = arr.length;

        int i=0; int lastJumpPos = 0; int jump = 0; int reach = 0;

        while(lastJumpPos < (n-1)){
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

            i++;
        }

        return lastJumpPos >= n-1 ? jump : -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 0, 0, 0};

        int x = minJumps(arr);

        System.out.println("ans : " + x);
    }
}
