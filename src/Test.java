import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Test {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 2, 1};
        int[] b = {3, 2, 2, 3, 3, 2};

        Set<Integer> s = new HashSet<>();

        for(int it : a){
            s.add(it);
        }

        for(int it : b){
            s.add(it);
        }

        ArrayList<Integer> res = new ArrayList<>(s);



    }
}