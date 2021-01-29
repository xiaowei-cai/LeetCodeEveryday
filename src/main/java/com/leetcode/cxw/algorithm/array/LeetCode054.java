package com.leetcode.cxw.algorithm.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 【螺旋矩阵】
 * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 * 示例 1:
 * 输入:
 * [
 * [ 1, 2, 3 ],
 * [ 4, 5, 6 ],
 * [ 7, 8, 9 ]
 * ]
 * 输出: [1,2,3,6,9,8,7,4,5]
 *
 * 示例 2:
 * 输入:
 * [
 * [1, 2, 3, 4],
 * [5, 6, 7, 8],
 * [9,10,11,12]
 * ]
 * 输出: [1,2,3,4,8,12,11,10,9,5,6,7]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/spiral-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class LeetCode054 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return ans;
        }
        //从左到右有m个元素
        int m = matrix[0].length;
        //从上到下有n个元素
        int n = matrix.length;
        //l:left -- r:right -- t:top -- b:bottom
        int l = 0, r = m - 1, t = 0, b = n - 1;
        while (l <= r && t <= b) {
            //left to right
            for (int i = l; i <= r; i++) {
                ans.add(matrix[t][i]);
            }

            //top to bottom
            for (int i = t + 1; i <= b; i++) {
                ans.add(matrix[i][r]);
            }

            if (l < r && t < b) {
                //right to left
                for (int i = r - 1; i > l; i--) {
                    ans.add(matrix[b][i]);
                }

                //bottom to top
                for (int i = b; i > t; i--) {
                    ans.add(matrix[i][l]);
                }
            }
            l++;
            r--;
            t++;
            b--;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] matrix = {
//                {1, 2, 3, 4},
//                {5, 6, 7, 8},
//                {9, 10, 11, 12}
//                {2, 5},
//                {8, 4},
//                {0, -1}
        };

        System.out.println(new LeetCode054().spiralOrder(matrix));
    }
}
