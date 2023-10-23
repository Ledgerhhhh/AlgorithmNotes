package t.middle;

import java.util.Arrays;

@SuppressWarnings("all")
public class LongestArithSeqLength {


    class Solution {
        public int longestArithSeqLength(int[] nums) {

            // TODO 学习一下动态规划
            return 0;


        }
    }

    //官方题解(动态规划)
    class Solution2 {
        public int longestArithSeqLength(int[] nums) {
            // 获取最小
            int minv = Arrays.stream(nums).min().getAsInt();
            //获取最大
            int maxv = Arrays.stream(nums).max().getAsInt();
            //数组跨度
            int diff = maxv - minv;
            //
            int ans = 1;
            for (int d = -diff; d <= diff; ++d) {
                int[] f = new int[maxv + 1];
                Arrays.fill(f, -1);
                for (int num : nums) {
                    int prev = num - d;
                    if (prev >= minv && prev <= maxv && f[prev] != -1) {
                        f[num] = Math.max(f[num], f[prev] + 1);
                        ans = Math.max(ans, f[num]);
                    }
                    f[num] = Math.max(f[num], 1);
                }
            }
            return ans;
        }
    }



}
