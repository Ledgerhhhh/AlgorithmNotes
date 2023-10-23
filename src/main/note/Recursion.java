package main.note;

import java.util.Arrays;

public class Recursion {
    public static void main(String[] args) {
//        System.out.println(first(13));
        System.out.println(getSum(15000));
    }


    public static int first(int n) {
        n = n - 1;
        int[] arr = new int[n];
        Arrays.fill(arr, -1);
        return f(n, arr);
    }


    public static int f(int n, int[] arr) {
        if (n == 0) return 1;
        if (n == 1) return 1;
        int f;
        if (arr[n - 1] != -1) {
            f = arr[n - 1];
        } else {
            f = f(n - 1, arr);
            arr[n - 1] = f;
        }
        int f1;
        if (arr[n - 2] != -1) {
            f1 = arr[n - 2];
        } else {
            f1 = f(n - 2, arr);
            arr[n - 2] = f1;
        }
        return f + f1;
    }

    public static int getSum(int n) {
        if (n == 1) return 1;
        return getSum(n - 1) + n;
    }


}
