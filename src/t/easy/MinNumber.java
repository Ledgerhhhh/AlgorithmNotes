package t.easy;

import java.util.Arrays;

public class MinNumber {

    public int minNumber(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        for (int c : nums1) {
            for (int k : nums2) {
                if (c == k) {
                    return c;
                }
            }
        }
        return Math.min(nums1[0] * 10 + nums2[0],nums2[0] * 10 + nums1[0]);


    }


}
