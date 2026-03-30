package Array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Ques6_UnionAndIntersectionOfArrays {
    public static ArrayList<Integer> findUnion(int[] a, int[] b) {
        // code here
        Set<Integer> s = new HashSet<>();

        for(int it : a){
            s.add(it);
        }

        for(int it : b){
            s.add(it);
        }

        return new ArrayList<>(s);
    }
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 2, 1};
        int[] b = {3, 2, 2, 3, 3, 2};
        ArrayList<Integer> res = findUnion(a, b);

        for(int it : res) {
            System.out.print(it+" ");
        }
    }
}
