package n;

import java.util.Arrays;

/**
 * 二分查找
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] sortedArray = {1, 3, 5, 7, 9, 11, 13, 15};
        int i = Arrays.binarySearch(sortedArray, 100);

        // 找到目标值的测试用例
        System.out.println(binarySearch(sortedArray, 7));  // 应该返回 3
        System.out.println(binarySearch(sortedArray, 1));  // 应该返回 0
        System.out.println(binarySearch(sortedArray, 15)); // 应该返回 7

        // 未找到目标值的测试用例
        System.out.println(binarySearch(sortedArray, 6));  // 应该返回 -1
        System.out.println(binarySearch(sortedArray, 0));  // 应该返回 -1
        System.out.println(binarySearch(sortedArray, 16)); // 应该返回 -1

        // 空数组的测试用例
        int[] emptyArray = {};
        System.out.println(binarySearch(emptyArray, 7));   // 应该返回 -1
        insert();
    }

    public static int binarySearch(int[] a, int target) {
        // 标准的二分查找算法
        int i = 0;
        int j = a.length - 1;
        while (i <= j) {
            int m = (i + j) / 2;
            int num = a[m];
            if (num > target) {
                j = m - 1;
            } else if (num < target) {
                i = m + 1;
            } else {
                return m;
            }
        }
        return -1;
    }

    public static int binarySearch2(int[] a, int target) {
        // 最标准的二分查找算法(防止下标溢出)
        int i = 0;
        int j = a.length - 1;
        while (i <= j) {
            int m = (i + j) >>> 1;
            int num = a[m];
            if (num > target) {
                j = m - 1;
            } else if (num < target) {
                i = m + 1;
            } else {
                return m;
            }
        }
        return -1;
    }

    public static int binarySearch3(int[] a, int target) {
        // 平衡左边和右边的查找,但是上限变低了,不会一次就查询到
        int i = 0;
        int j = a.length;
        while (1 < j - i) {
            int m = (i + j) >>> 1;
            int num = a[m];
            if (num < target) {
                j = m;
            } else {
                i = m;
            }
        }
        if (a[i] == target) {
            return i;
        }
        return -1;
    }

    public static int binarySearchMostLeft(int[] a, int target) {
        // 查询最左的或者最右的
        int i = 0;
        int j = a.length - 1;
        int candidate = -1;
        while (i <= j) {
            int m = (i + j) >>> 1;
            int num = a[m];
            if (num > target) {
                j = m - 1;
            } else if (num < target) {
                i = m + 1;
            } else {
                // 记录候选者位置
                candidate = m;
                //最左
                j = m - 1;
                //最右
                //i=i+1
            }
        }
        return candidate;
    }

    public static int binarySearchMostLeftWithoutNegative(int[] a, int target) {
        // 不返回-1
        int i = 0;
        int j = a.length - 1;
        while (i <= j) {
            int m = (i + j) >>> 1;
            if (target <= a[m]) {
                j = m - 1;
            } else {
                i = m + 1;
            }
        }
        //返回本身所在索引或者比目标小的最靠左的位置
        return i;
    }

    public static int binarySearchMostRightWithoutNegative(int[] a, int target) {
        // 不返回-1
        int i = 0;
        int j = a.length - 1;
        while (i <= j) {
            int m = (i + j) >>> 1;
            if (target < a[m]) {
                j = m - 1;
            } else {
                i = m + 1;
            }
        }
        //返回本身所在索引或者比目标大的最靠右的位置
        return i - 1;
    }

    public static int[] insert() {
        int[] arr = {1, 2, 3};
        int target = 10;
        int i = Arrays.binarySearch(arr, target);
        int[] arr2 = new int[arr.length + 1];
        if (i < 0) {
            int insertIndex = Math.abs(i + 1);
            // 从源数组的索引 0 处开始复制，复制 insertIndex 个元素到目标数组的索引 0 处
            System.arraycopy(arr, 0, arr2, 0, insertIndex);
            arr2[insertIndex] = target;
            System.arraycopy(arr, insertIndex, arr2, insertIndex + 1, arr.length - insertIndex);
        }
        return arr2;
    }

}














































