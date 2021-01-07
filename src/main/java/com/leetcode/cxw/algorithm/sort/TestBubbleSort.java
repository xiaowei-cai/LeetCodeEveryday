package com.leetcode.cxw.algorithm.sort;

import java.util.Arrays;

/**
 * 冒泡排序【时间复杂度O(n²),稳定排序】
 *
 * @author caixiaowei
 * @date 2020/11/16 17:22
 */

public class TestBubbleSort {
    /**
     * 原始冒泡方法
     */
    public static void sort1(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                int tmp = 0;
                if (array[j] > array[j + 1]) {
                    tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
        }
    }

    /**
     * 第一次优化
     */
    public static void sort2(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            //有序标记
            boolean isSorted = true;
            for (int j = 0; j < array.length - i - 1; j++) {
                int tmp = 0;
                if (array[j] > array[j + 1]) {
                    tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                    //因为元素有进行交换所以不是有序的，标记变为false
                    isSorted = false;
                }
            }
            if (isSorted) {
                break;
            }
        }
    }

    /**
     * 第二次优化
     */
    public static void sort3(int[] array) {
        //记录最后一次交换的位置
        int lastExchangeIndex = 0;
        //无序数列的边界，每次比较只需比到这里位置
        int sortBorder = array.length - 1;
        for (int i = 0; i < array.length - 1; i++) {
            //有序标记
            boolean isSorted = true;
            for (int j = 0; j < sortBorder; j++) {
                int tmp = 0;
                if (array[j] > array[j + 1]) {
                    tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                    //因为元素有进行交换所以不是有序的，标记变为false
                    isSorted = false;
                    lastExchangeIndex = j;
                }
            }
            sortBorder = lastExchangeIndex;
            if (isSorted) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{
                //5, 8, 6, 3, 9, 2, 1, 7
                //3, 4, 2, 1, 5, 6, 7, 8
                2, 3, 4, 5, 6, 7, 8, 1
        };
        sort4(array);
        System.out.println(Arrays.toString(array));
    }


    /**
     * 鸡尾酒排序
     * 思路：排序过程像钟摆一样，第一轮从左到右，第二轮从右到左，第三轮再从左到右...
     */
    public static void sort4(int[] array) {
        int tmp = 0;
        for (int i = 0; i < array.length / 2; i++) {
            //有序标记
            boolean isSorted = true;
            //奇数轮，从左向右比较和交换
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                    //有元素交换标记变为false
                    isSorted = false;
                }
            }
            if (isSorted) {
                break;
            }
            //在偶数轮之前，将isSorted重新标记为true
            isSorted = true;
            //偶数轮，从右向左比较和交换
            for (int j = array.length - i - 1; j > i; j--) {
                if (array[j] < array[j - 1]) {
                    tmp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = tmp;
                    //有元素交换标记变为false
                    isSorted = false;
                }
            }
            if (isSorted) {
                break;
            }
        }
    }
}
