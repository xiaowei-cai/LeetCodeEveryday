package com.leetcode.cxw.algorithm.sort;

import java.util.Arrays;

/**
 * 堆排序【时间复杂度O(nlogN),不稳定排序】
 * 思路：
 * 把无序数组构建成二叉堆。
 * 需要从小到大排序则构建成最大堆
 * 需要从大到小排序则构建成最小堆
 * 循环删除堆顶元素替换到二叉堆的末尾，调整堆产生新的堆顶
 *
 * @author caixiaowei
 * @date 2020/11/16 17:44
 */

public class TestHeapSort {
    /**
     * @param array  待调整的堆
     * @param index  要下沉的父节点索引
     * @param length 堆的有效大小
     */
    //最大堆下沉操作
    public static void downAdjust(int[] array, int index, int length) {
        // 先记录父节点及左子节点的下标
        int parentIndex = index;
        int childrenIndex = 2 * parentIndex + 1;
        // 记录父节点的值，用于最后赋值
        int temp = array[parentIndex];
        // 若有左子节点则继续
        while (childrenIndex < length) {
            // 若有右子节点，且右子节点比左子节点大，则将 childrenIndex 记录为右子节点的下标
            if (childrenIndex + 1 < length && array[childrenIndex + 1] > array[childrenIndex]) {
                childrenIndex++;
            }
            // 如果父节点大于左右节点中较大的数，则无需下沉，直接返回
            if (temp >= array[childrenIndex]) {
                break;
            }
            // 直接单向赋值，无需做交替操作
            array[parentIndex] = array[childrenIndex];
            // 更新父子节点下标的值，下面两句代码顺序不可相反
            parentIndex = childrenIndex;
            childrenIndex = 2 * childrenIndex + 1;
        }
        // 最后赋值
        array[parentIndex] = temp;
    }

    public static void heapSort(int[] array) {
        //把无序数组构建成最大堆
        for (int i = (array.length / 2) - 1; i >= 0; i--) {
            downAdjust(array, i, array.length);
        }
        System.out.println(Arrays.toString(array));
        //循环删除堆顶元素，移到集合尾部，调整堆产生新的堆顶
        for (int i = array.length - 1; i > 0; i--) {
            //最后一个元素和第一个元素交换
            int temp = array[i];
            array[i] = array[0];
            array[0] = temp;
            //下沉调整最大堆
            downAdjust(array, 0, i);
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{
                1, 3, 2, 6, 5, 7, 8, 9, 10, 0
        };
        heapSort(array);
        System.out.println(Arrays.toString(array));
    }
}
