package t.easy;

public class ClimbStairs {

    public static void main(String[] args) {
        System.out.println(climbStairs(1));
    }

    public static int climbStairs(int n) {
        int[] ints = new int[n];
        ints[0] = 1;
        if (ints.length > 1) {
            ints[1] = 2;
        }

        return recursion(n, ints);
    }

    public static int recursion(int n, int[] arr) {
        if (n <= 2) return arr[n - 1];
        if (arr[n - 2] == 0) {
            arr[n - 2] = recursion(n - 1, arr);
        }
        if (arr[n - 3] == 0) {
            arr[n - 3] = recursion(n - 2, arr);
        }

        return arr[n - 2] + arr[n - 3];
    }


    public static int dp(int n) {
        int[] ints = new int[n];
        ints[0] = 1;
        if (ints.length>1){
            ints[1] = 2;
        }
        for (int i = 0; i < n - 2; i++) {
            ints[i + 2] = ints[i] + ints[i + 1];
        }
        return ints[n - 1];
    }
}
