package com.leetcode.cxw.algorithm.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 【子集】
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *
 * 说明：解集不能包含重复的子集。
 *
 * 示例:
 *
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 * [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subsets
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class LeetCode078 {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        for (int num : nums) {
            int size = res.size();
            for (int i = 0; i < size; i++) {
                List<Integer> tmp = new ArrayList<>(res.get(i));
                tmp.add(num);
                res.add(tmp);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {
                1, 2, 3
        };
        System.out.println(subsets(nums));
    }
}
