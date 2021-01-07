package com.leetcode.cxw.algorithm.sort;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 快速排序【时间复杂度O(nlogN),不稳定排序】
 * 白话文思路：
 * 1、将第一个元组作为基准元素pivot
 * 2、两个指针left和right
 * 3、先是right指针从右向左扫描，
 * 如果arr[right]>=pivot,则right指针左移一位,新的right指针的值继续和pivot比较
 * 当arr[right]<pivot,则arr[right]去填补pivot的空缺位（或者说交换left和right的值），right指针停止移动，切换到left指针
 * 4、此时left指针和pivot比较，
 * 如果arr[left]<=pivot，则left指针右移一位，新的left指针的值继续和pivot比较
 * 当arr[left]>pivot时，交换left和right的值
 *
 * @author caixiaowei
 * @date 2020/11/16 17:44
 */

public class TestQuickSort {
    public static void quickSort(int[] arr, int startIndex, int endIndex) {
        //递归结束条件:startIndex大于等于endIndex时
        if (startIndex >= endIndex) {
            return;
        }
        //得到基准元素位置
        //双边循环
        //int pivotIndex = partition(arr, startIndex, endIndex);
        //单边循环
        int pivotIndex = partition1(arr, startIndex, endIndex);
        //根据基准元素分成两部分进行递归排序
        quickSort(arr, startIndex, pivotIndex - 1);
        quickSort(arr, pivotIndex + 1, endIndex);
    }

    /**
     * 分而治之(双边循环法)
     *
     * @param arr        待交换的数组
     * @param startIndex 起始下标
     * @param endIndex   结束下标
     */
    private static int partition(int[] arr, int startIndex, int endIndex) {
        //取第一个位置的元素作为基准元素(也可以选择随机位置)
        int pivot = arr[startIndex];
        int left = startIndex;
        int right = endIndex;

        while (left != right) {
            //控制right指针比较并左移
            while (left < right && arr[right] > pivot) {
                right--;
            }
            //控制left指针比较并右移
            while (left < right && arr[left] <= pivot) {
                left++;
            }

            //交换left和right指针所指向的元素
            if (left < right) {
                int tmp = arr[left];
                arr[left] = arr[right];
                arr[right] = tmp;
            }
        }
        //pivot和左右指针重合点的值位置
        arr[startIndex] = arr[left];
        arr[left] = pivot;
        return left;
    }


    /**
     * 分而治之(单边循环法)
     * 思路：
     * (1)首先选定基准元素pivot，设置一个mark指针指向数列起始位置，这个mark指针代表小于基准元素的边界
     * (2)从基准元素的下一个位置开始遍历数组，如果遍历的元素大于基准元素就继续往后遍历；如果遍历的元素小于基准元素则需要做两件事：
     * 第一、把mark指针右移1位，因为小于pivot的区域边界增大了1；
     * 第二、让最新遍历的元素和mark指针所在位置的元素交换位置
     */
    private static int partition1(int[] arr, int startIndex, int endIndex) {
        //取第一个位置的元素作为基准元素(也可以选择随机位置)
        int pivot = arr[startIndex];
        int mark = startIndex;

        for (int i = startIndex + 1; i < endIndex; i++) {
            if (arr[i] < pivot) {
                mark++;
                int tmp = arr[mark];
                arr[mark] = arr[i];
                arr[i] = tmp;
            }
        }
        arr[startIndex] = arr[mark];
        arr[mark] = pivot;
        return mark;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{
                4, 4, 6, 5, 3, 2, 8, 1
        };
//        quickSort(arr, 0, arr.length - 1);
        quickSort1(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }


    /**
     * 非递归实现则利用栈的思想，因为绝大多数递归逻辑都可以用栈的方式来代替
     */
    public static void quickSort1(int[] arr, int startIndex, int endIndex) {
        //用一个集合栈来代替递归的函数栈
        Stack<Map<String, Integer>> quickSortStack = new Stack<>();
        //这个数列的起止下标以哈希的形式入栈
        Map<String, Integer> rootParam = new HashMap<>();
        rootParam.put("startIndex", startIndex);
        rootParam.put("endIndex", endIndex);
        quickSortStack.push(rootParam);

        //循环结束时，栈为空时
        while (!quickSortStack.isEmpty()) {
            //栈顶元素出栈得到起止下标
            Map<String, Integer> param = quickSortStack.pop();
            //得到基准元素位置
            int pivotIndex = partition1(arr, param.get("startIndex"), param.get("endIndex"));
            //根据基准元素分成两部分，把每一部分的起止下标入栈
            if (param.get("startIndex") < pivotIndex - 1) {
                Map<String, Integer> leftParam = new HashMap<>();
                leftParam.put("startIndex", param.get("startIndex"));
                leftParam.put("endIndex", pivotIndex - 1);
                quickSortStack.push(leftParam);
            }
            if (pivotIndex + 1 < param.get("endIndex")) {
                Map<String, Integer> rightParam = new HashMap<>();
                rightParam.put("startIndex", pivotIndex + 1);
                rightParam.put("endIndex", param.get("endIndex"));
                quickSortStack.push(rightParam);
            }
        }
    }
}
