package n;

/**
 * 二维数组
 */
public class CatchLine {


    public static void main(String[] args) {

    }

    public static int ij(int[][] arr, int row, int columns) {
        int sum = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < columns; j++) {
                sum+=arr[i][j];
            }
        }
        return sum;
    }
    public static int ji(int[][] arr, int row, int columns) {
        int sum = 0;
        for (int i = 0; i < columns; i++) {
            for (int j = 0; j < row; j++) {
                sum+=arr[j][i];
            }
        }
        return sum;
    }
}
