package Array;

import java.util.Arrays;

public class Ques13_MergeArrayWithoutExtraSpace {
    // if using extra space is allowed
    public static void mergeArrays(int[] a, int[] b) {
        // code here
        int n1 = a.length; int n2 = b.length;

        int[] ans = new int[n1+n2];

        int i=0; int j=0; int k=0;

        while(i<n1 && j<n2){
            if(a[i]<=b[j]){
                ans[k] = a[i];
                i++; k++;
            } else {
                ans[k] = b[j];
                j++; k++;
            }
        }

        while(i<n1){
            ans[k] = a[i];
            i++; k++;
        }

        while(j<n2){
            ans[k] = b[j];
            j++; k++;
        }

        i=0; j=0; k=0;

        while(i<n1){
            a[i] = ans[k];
            i++; k++;
        }

        while(j<n2){
            b[j] = ans[k];
            j++; k++;
        }
    }


    // Method 2: Start from last index of first and first index of second array, if the element of first > element of second then swap them
    // (meaning, then second element should be in the first array), else, break the loop as the array are sorted, all the next items belongs to the correct array
    // after that sort the arrays individually

    public static void swap(int[] a, int i, int[] b, int j){
        int temp = a[i];
        a[i] = b[j];
        b[j] = temp;
    }

    public static void mergeArrays2(int[] a, int[] b) {
        // code here
        int n1 = a.length; int n2 = b.length;

        int i = n1-1; int j = 0;

        while(i>=0 && j<n2){
            if(a[i] <= b[j])break;

            swap(a, i, b, j);

            i--;j++;
        }

        Arrays.sort(a);
        Arrays.sort(b);
    }

    // Method 3: Using shell sort technique (find gap using Ceil of avg of array lengths then keep on doing it every time)
    public static void mergeArrays3(int[] a, int[] b) {
        // code here
        int n1 = a.length; int n2 = b.length;

        int gap = (int) Math.ceil((n1 + n2) / 2.0);

        while(gap > 0){
            int i=0;
            int j = (i + gap);

            while(j < (n1 + n2)){
                if(i<n1 && j<n1){ // both in first array
                    if(a[i] > a[j]){
                        swap(a, i, a, j);
                    }
                } else if(i<n1 && j >= n1){ // i in first array and j in second array
                    int k = j-n1;
                    if(a[i] > b[k]){
                        swap(a, i, b, k);
                    }
                } else { // both in second array
                    int k1 = i-n1;
                    int k2 = j-n1;

                    if(b[k1] > b[k2]){
                        swap(b, k1, b, k2);
                    }
                }
                i++; j++;
            }

            if(gap == 1)break;

            gap = (int) Math.ceil(gap/2.0);
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 3, 5, 7};
        int[] b = {2, 4, 6};

        mergeArrays(a, b);
    }
}
