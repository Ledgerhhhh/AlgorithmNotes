package t.easy;


public class RemoveDuplicates {
    public static void main(String[] args) {

        removeDuplicates(new int[]{1, 1, 2});
    }

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != nums[j]) {
                j++;
                nums[j] = nums[i];
            }
        }
        return j + 1;
    }
}