package Array;

import java.util.*;

public class ReverseArray {
    // Method 1: keep swapping elements ith element from start with i'th element from end till mid
    public static void reverseString1(char[] s) {
        for(int i=0; i<s.length/2; i++){
            char temp = s[i];
            s[i] = s[s.length - 1- i];
            s[s.length - 1 - i] = temp;
        }
    }

    // Method 2: easier version of above, maintain 2 variable i,j swap their element at each step till i<j and do i++ and j-- at each step
    public static void reverseString2(char[] s) {
        int i=0; int j= s.length - 1;

        while(i<j){
            char temp = s[i];
            s[i] = s[s.length - 1- i];
            s[s.length - 1 - i] = temp;
            i++; j--;
        }
    }

    // Method 3: Use recursion instead of while loop. use i, j in parameters
    public static void fn(int i, int j, char[] s){
        if(i >= j)return;

        char temp = s[i];
        s[i] = s[s.length - 1- i];
        s[s.length - 1 - i] = temp;
        fn(i+1, j-1, s);
    }

    public static void reverseString3(char[] s) {
        int i=0; int j= s.length - 1;

        fn(0, s.length - 1, s);
    }

    // Method 4: Reverse using stack
    public static void reverseString4(char[] s) {
        Stack<Character> st = new Stack<>();

        for(char ch : s){
            st.push(ch);
        }

        int i=0;
        while(!st.empty()){
            s[i] = st.pop();
            i++;
        }
    }

    public static void main(String[] args) {
        char [] s1 = {'a', 'b', 'c', 'd'};
//        char [] s2 = "pqrs";

        reverseString1(s1);

        System.out.println(s1);
    }
}
