package com.leetcode.cxw.algorithm.array;

/**
 * 【有效的山脉数组】
 * 给定一个整数数组 A，如果它是有效的山脉数组就返回 true，否则返回 false。
 * 让我们回顾一下，如果 A 满足下述条件，那么它是一个山脉数组（即先升序后降序）：
 * A.length >= 3
 * 在 0 < i < A.length - 1 条件下，存在 i 使得：
 * A[0] < A[1] < ... A[i-1] < A[i]
 * A[i] > A[i+1] > ... > A[A.length - 1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-mountain-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class LeetCode941 {
    public boolean validMountainArray(int[] arr) {
        int n = arr.length - 1;
        int i = 0;
        while (i < n && arr[i] < arr[i + 1]) {
            i++;
        }

        if (i == 0 || i == n) {
            return false;
        }

        while (i < n && arr[i] > arr[i + 1]) {
            i++;
        }

        return i == n;
    }
}
