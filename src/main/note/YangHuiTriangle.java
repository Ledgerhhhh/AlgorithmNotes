package main.note;

import java.util.Arrays;

public class YangHuiTriangle {

    public static void main(String[] args) {
//        get(9);
        get2(5);
    }


    static int getYH(int i, int j, int[][] arr) {
        if (arr[i][j] != 0) {
            return arr[i][j];
        }
        if (j == 0 || i == j) {
            return 1;
        }
        int yh = getYH(i - 1, j - 1, arr);
        int yh1 = getYH(i - 1, j, arr);
        arr[i][j] = yh + yh1;
        return arr[i][j];
    }

    static int getYH2(int i, int j, int[] arr) {
        if (arr[i] != 0) {
            return arr[i];
        }
        if (j == 0 || i == j) {
            return 1;
        }
        int yh = getYH2(i - 1, j - 1, arr);
        int yh1 = getYH2(i - 1, j, arr);
        int res = arr[j + 1];
        arr[j] = yh + yh1;
        return res;
    }


    static void get(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            print(i, n);
            for (int j = 0; j <= i; j++) {
                System.out.printf("%-4d", getYH2(i, j, arr));
            }
            System.out.println();
        }

    }

    static void print(int i, int n) {
        int num = (n - 1 - i) * 2;
        for (int j = 0; j < num; j++) {
            System.out.print(" ");
        }
    }

    static void get2(int n) {
        int[] ints = new int[n];
        ints[0] = 1;
        getYB(ints, n);
    }

    static void getYB(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = i; j > 0; j--) {
                arr[j] = arr[j] + arr[j - 1];
            }
            System.out.println(Arrays.toString(arr));
        }
    }
}
