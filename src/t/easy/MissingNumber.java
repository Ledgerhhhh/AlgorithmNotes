package t.easy;

import java.util.Arrays;

public class MissingNumber {

    public static void main(String[] args) {
//        int[] ints = {9,6,4,2,3,5,7,0,1};
//        int[] ints = {0};
        int[] ints = {0,1};
        int i = missingNumber(ints);
        System.out.println(i);

    }

    public static int missingNumber(int[] nums) {
        return getRes(nums);
    }

    static int getRes(int[] nums) {
        Arrays.sort(nums);
        if (nums[0] != 0) return 0;
        if (nums[nums.length - 1] == nums.length - 1) return nums.length;
        int i = 0;
        int j = nums.length - 1;
        while (true) {
            if(i>=j) return j;
            int m = (i + j) >>> 1;
            if (m != nums[m] && m - 1 == nums[m - 1]) {
                return m;
            }
            if (m == nums[m]) {
                i = m + 1;
            } else {
                j = m - 1;
            }
        }
    }

}
