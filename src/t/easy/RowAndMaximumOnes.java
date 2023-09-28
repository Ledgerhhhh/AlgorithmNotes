package t.easy;

import java.util.Arrays;

public class RowAndMaximumOnes {
    public static void main(String[] args) {
        int[][] ints = new int[2][2];

        ints[0]=new int[]{0,1};
        ints[0]=new int[]{0,1};

        int[] ints1 = rowAndMaximumOnes(ints);


        System.out.println(Arrays.toString(ints1));
    }


    public static int[] rowAndMaximumOnes(int[][] mat) {
        int x = 0;
        int y = 0;
        for (int i = 0; i < mat.length; i++) {
            int c = countOne(mat[i]);
            if (c > y) {
                x = i;
                y = c;
            }

        }
        return new int[]{x, y};
    }

    private static int countOne(int[] ints) {
        int c = 0;
        for (int anInt : ints) {
            if (anInt == 1) {
                c++;
            }
        }
        return c;
    }

}
