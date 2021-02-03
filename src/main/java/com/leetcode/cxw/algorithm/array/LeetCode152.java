package com.leetcode.cxw.algorithm.array;

/**
 * 【乘积最大子数组】
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 * 示例 1:
 * 输入: [2,3,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 *
 * 示例 2:
 * 输入: [-2,0,-1]
 * 输出: 0
 * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-product-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class LeetCode152 {
    public static int maxProduct(int[] nums) {
        int ans = Integer.MIN_VALUE;
        int imax = 1;
        int imin = 1;
        for (int num : nums) {
            if (num < 0) {
                int tmp = imax;
                imax = imin;
                imin = tmp;
            }
            imax = Math.max(imax * num, num);
            imin = Math.min(imin * num, num);
            ans = Math.max(ans, imax);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 5, -5, 1, 2, 3, -2, 4};
        System.out.println(maxProduct(nums));
    }
}
