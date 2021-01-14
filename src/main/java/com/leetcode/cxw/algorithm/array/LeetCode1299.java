package com.leetcode.cxw.algorithm.array;

/**
 * 【将每个元素替换为右侧最大元素】
 * 给你一个数组 arr ，请你将每个元素用它右边最大的元素替换，如果是最后一个元素，用 -1 替换。
 * 完成所有替换操作后，请你返回这个数组。
 *
 * 示例 1：
 * 输入：arr = [17,18,5,4,6,1]
 * 输出：[18,6,6,6,1,-1]
 * 解释：
 * - 下标 0 的元素 --> 右侧最大元素是下标 1 的元素 (18)
 * - 下标 1 的元素 --> 右侧最大元素是下标 4 的元素 (6)
 * - 下标 2 的元素 --> 右侧最大元素是下标 4 的元素 (6)
 * - 下标 3 的元素 --> 右侧最大元素是下标 4 的元素 (6)
 * - 下标 4 的元素 --> 右侧最大元素是下标 5 的元素 (1)
 * - 下标 5 的元素 --> 右侧没有其他元素，替换为 -1
 *
 * 示例 2：
 * 输入：arr = [400]
 * 输出：[-1]
 * 解释：下标 0 的元素右侧没有其他元素。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/replace-elements-with-greatest-element-on-right-side
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class LeetCode1299 {
    public int[] replaceElements(int[] arr) {
        int rightMax = arr[arr.length - 1];
        arr[arr.length - 1] = -1;
        for(int i = arr.length - 2; i >= 0; i--){
            int t = arr[i];
            arr[i] = rightMax;
            if(t > rightMax){
                rightMax = t;
            }
        }
        return arr;
    }
}
