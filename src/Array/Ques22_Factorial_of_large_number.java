package Array;

import java.util.*;

public class Ques22_Factorial_of_large_number {
    public static ArrayList<Integer> factorial(int n) {
        // Initialize with 0s instead of nulls
        ArrayList<Integer> res = new ArrayList<>();

        res.add(1);

        for(int num=2; num <=n; num++) {
            int carry = 0;
            for(int ind=0; ind<res.size(); ind++) {
                int total = (res.get(ind))*num + carry;

                int updatedVal = total%10;
                res.set(ind, updatedVal);
                carry = total/10;
            }

            while(carry > 0) {
                res.add(carry % 10);
                carry /= 10;
            }
        }

        Collections.reverse(res);

        return res;
    }

    public static void main(String[] args) {
        ArrayList<Integer> res = factorial(5);

        for(int it : res) {
            System.out.println(it);
        }
    }
}