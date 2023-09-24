package t;

public class SearchRange {

    public static void main(String[] args) {
        int[] ints = searchRange(new int[]{2, 2}, 3);
    }

//    给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
//
//    如果数组中不存在目标值 target，返回 [-1, -1]。
//
//    你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。

    public static int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }
        int i = 0;
        int i1 = 0;
        int j = nums.length - 1;
        int j1 = nums.length - 1;
        while (i <= j) {
            int m = (i + j) >>> 1;
            //找最左边
            if (target <= nums[m]) {
                j = m - 1;
            } else {
                i = m + 1;
            }
        }
        if (i > nums.length || nums[i] != target) {
            return new int[]{-1, -1};
        }
        while (i1 <= j1) {
            int m = (i1 + j1) >>> 1;
            //找最右边
            if (target < nums[m]) {
                j1 = m - 1;
            } else {
                i1 = m + 1;
            }
        }
        return new int[]{i, i1 - 1};
    }

    public  int[] searchRange2(int[] nums, int target) {
        int left = left(nums, target);
        if(left!=-1){
            return new int[]{left,right(nums, target)};
        }else {
            return new int[]{-1,-1};
        }

    }

    int left(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;
        int candidate = -1;
        while (i <= j) {
            int m = (i + j) >>> 1;
            //找最左边
            if (target < nums[m]) {
                j = m - 1;
            } else if(target > nums[m]){
                i = m + 1;
            }else {
                candidate=m;
                j = m - 1;
            }
        }
        return candidate;
    }
    int right(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;
        int candidate = -1;
        while (i <= j) {
            int m = (i + j) >>> 1;
            //找最左边
            if (target < nums[m]) {
                j = m - 1;
            } else if(target > nums[m]){
                i = m + 1;
            }else {
                candidate=m;
                i = m + 1;
            }
        }
        return candidate;
    }
}
