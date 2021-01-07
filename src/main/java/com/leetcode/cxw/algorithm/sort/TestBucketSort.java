package com.leetcode.cxw.algorithm.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

/**
 * 桶排序【时间复杂度O(n),稳定排序】
 * 具体建立多少个桶以及如何确定桶的区间范围：
 * （1）创建的桶的数量等于原始数列的元素数量
 * （2）除最后一个桶只包含数列最大值外，前面各个桶的区间按照比例来确定
 * 区间跨度 = （最大值-最小值）/(桶的数量-1)
 *
 * @author caixiaowei
 * @date 2020/11/16 17:45
 */

public class TestBucketSort {
    public static double[] bucketSort(double[] array) {
        //得到数列的最大值和最小值并算出差值d
        double max = array[0];
        double min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
            if (array[i] < min) {
                min = array[i];
            }
        }
        double d = max - min;
        //初始化桶
        int bucketNum = array.length;
        ArrayList<LinkedList<Double>> bucketList = new ArrayList<>();
        for (int i = 0; i < bucketNum; i++) {
            bucketList.add(new LinkedList<>());
        }
        //遍历原始数组,将每个元素放入桶中
        for (double v : array) {
            //区间跨度为 d/(bucketNum - 1), 所以(array[i] - min)/区间跨度=array[i]落在第几个桶
            int num = (int) ((v - min) / (d / (bucketNum - 1)));
            bucketList.get(num).add(v);
        }
        //对每个桶内部进行排序
        for (LinkedList<Double> doubles : bucketList) {
            Collections.sort(doubles);
        }
        //输出全部元素
        double[] sortedArray = new double[array.length];
        int index = 0;
        for (LinkedList<Double> list : bucketList) {
            for (double element : list) {
                sortedArray[index] = element;
                index++;
            }
        }
        return sortedArray;
    }

    public static void main(String[] args) {
        double[] array = new double[]{
                4.12, 6.421, 0.0023, 3.0, 2.123, 8.122, 4.12, 1
        };
        double[] sortedArray = bucketSort(array);
        System.out.println(Arrays.toString(sortedArray));
    }
}
