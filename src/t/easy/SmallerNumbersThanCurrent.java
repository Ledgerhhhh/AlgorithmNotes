package t.easy;

import java.util.Arrays;

public class SmallerNumbersThanCurrent {

    public static void main(String[] args) {
        int[] ints = {8, 1, 2, 2, 3};
        int[] ints1 = smallerNumbersThanCurrent(ints);
        System.out.println(Arrays.toString(ints1));


    }

    public static int[] smallerNumbersThanCurrent(int[] nums) {
        int[] ints = new int[nums.length];
        int[] sort = Arrays.copyOf(nums, nums.length);
        Arrays.sort(sort);
        for (int i = 0; i < nums.length; i++) {
            int c = nums[i];
            for (int j = 0; j < sort.length; j++) {
                if (c == sort[j]) {
                    ints[i] = j;
                    break;
                }
            }
        }
        return ints;
    }
    // TODO 大佬的0ms解法
    public static int[] smallerNumbersThanCurrent2(int[] nums) {
        int[] arrays = new int[101];
        for (int num : nums) {
            arrays[num] += 1;
        }
        for (int i = 1; i < arrays.length; i++) {
            arrays[i] += arrays[i - 1];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] != 0 ? arrays[nums[i] - 1] : 0;
        }
        return nums;
    }

}
