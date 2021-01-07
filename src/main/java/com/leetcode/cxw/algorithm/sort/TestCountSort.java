package com.leetcode.cxw.algorithm.sort;

import java.util.Arrays;

/**
 * 计数排序【时间复杂度O(n+m),稳定排序】
 *
 * @author caixiaowei
 * @date 2020/11/16 17:45
 */

public class TestCountSort {
    public static int[] countSort(int[] array) {
        //得到数列的最大值
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        //根据数列最大值确定统计数组的长度
        int[] countArray = new int[max + 1];
        //遍历数列，填充统计数组
        for (int value : array) {
            countArray[value]++;
        }
        //遍历统计数组，输出结果
        int index = 0;
        int[] sortedArray = new int[array.length];
        for (int i = 0; i < countArray.length; i++) {
            for (int j = 0; j < countArray[i]; j++) {
                sortedArray[index++] = i;
            }
        }
        return sortedArray;
    }


    /**
     * 优化
     */
    public static int[] countSort1(int[] array) {
        //得到数列的最大值和最小值并算出差值d
        int max = array[0];
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
            if (array[i] < min) {
                min = array[i];
            }
        }
        int d = max - min;
        //创建统计数组countArray并统计对应元素的个数
        int[] countArray = new int[d + 1];
        for (int value : array) {
            countArray[value - min]++;
        }
        //统计数组countArray做变形，后面的元素等于前面的元素之和
        for (int i = 1; i < countArray.length; i++) {
            countArray[i] += countArray[i - 1];
        }
        //倒序遍历原始数组，从统计数组找到正确位置，输出到结果数组
        int[] sortedArray = new int[array.length];
        for (int i = array.length - 1; i >= 0; i--) {
            sortedArray[countArray[array[i] - min] - 1] = array[i];
            countArray[array[i] - min]--;
        }
        return sortedArray;
    }

    public static void main(String[] args) {
        int[] array = new int[]{4, 4, 6, 5, 3, 2, 8, 1, 7, 5, 6, 0, 10};
        int[] sortArray = countSort(array);

        int[] array1 = new int[]{95, 94, 91, 98, 99, 90, 99, 93, 91, 92};
        int[] sortArray1 = countSort1(array1);

        System.out.println(Arrays.toString(sortArray));
        System.out.println(Arrays.toString(sortArray1));
    }
}
