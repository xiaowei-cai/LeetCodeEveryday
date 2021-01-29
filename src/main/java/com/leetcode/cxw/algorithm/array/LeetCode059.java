package com.leetcode.cxw.algorithm.array;

/**
 * 【螺旋矩阵II】
 * 给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
 * 示例:
 * 输入: 3
 * 输出:
 * [
 * [ 1, 2, 3 ],
 * [ 8, 9, 4 ],
 * [ 7, 6, 5 ]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/spiral-matrix-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class LeetCode059 {
    public int[][] generateMatrix(int n) {
        int l = 0;
        int r = n - 1;
        int t = 0;
        int b = n - 1;
        int[][] mat = new int[n][n];
        int num = 1;
        while (num <= n * n) {
            //left to right
            for (int i = l; i <= r; i++) {
                mat[t][i] = num++;
            }
            t++;

            //top to bottom
            for (int i = t; i <= b; i++) {
                mat[i][r] = num++;
            }
            r--;

            //right to left
            for (int i = r; i >= l; i--) {
                mat[b][i] = num++;
            }
            b--;

            //bottom to top
            for (int i = b; i >= t; i--) {
                mat[i][l] = num++;
            }
            l++;
        }
        return mat;
    }
}
