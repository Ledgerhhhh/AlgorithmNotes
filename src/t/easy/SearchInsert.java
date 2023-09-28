package t.easy;

public class SearchInsert {
    //    给定一个排序的整数数组 nums 和一个整数目标值 target ，请在数组中找到 target ，并返回其下标。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
//
//    请必须使用时间复杂度为 O(log n) 的算法。
    public int searchInsert(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;
        while (i <= j) {
            int m = (i + j) >>> 1;
            if (target < nums[m]) {
                j = m - 1;
            } else if (target > nums[m]) {
                i = m + 1;
            } else {
                return m;
            }
        }
        return i;
    }
    public int searchInsert2(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;
        while (i <= j) {
            int m = (i + j) >>> 1;
            if (target <= nums[m]) {
                j = m - 1;
            } else {
                i = m + 1;
            }
        }
        return i;
    }
}
