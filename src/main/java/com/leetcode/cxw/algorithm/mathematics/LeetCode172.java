package com.leetcode.cxw.algorithm.mathematics;

import java.math.BigInteger;

/**
 * 【阶乘后的零】
 * 给定一个整数 n，返回 n! 结果尾数中零的数量。
 * 示例 1:
 * 输入: 3
 * 输出: 0
 * 解释: 3! = 6, 尾数中没有零。
 *
 * 示例 2:
 * 输入: 5
 * 输出: 1
 * 解释: 5! = 120, 尾数中有 1 个零.
 * 说明: 你算法的时间复杂度应为 O(log n) 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/factorial-trailing-zeroes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class LeetCode172 {
    public static int trailingZeroes(int n) {
        //定义临时变量1
        BigInteger cur = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            //计算阶乘
            cur = cur.multiply(BigInteger.valueOf(i));
        }

        System.out.println(n + "的阶乘为:" + cur);

        int zeroCount = 0;
        //mod求模
        while (cur.mod(BigInteger.TEN).equals(BigInteger.ZERO)) {
            zeroCount++;
            cur = cur.divide(BigInteger.TEN);
        }
        return zeroCount;
    }

    public static void main(String[] args) {
        int n = 18;
        System.out.println(trailingZeroes(n));

        //2的31次方减1
        System.out.println(Integer.MAX_VALUE);
        //2的63次方减1
        System.out.println(Long.MAX_VALUE);
    }
}
