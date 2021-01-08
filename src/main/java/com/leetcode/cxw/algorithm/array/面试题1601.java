package com.leetcode.cxw.algorithm.array;

/**
 * 【交换数字】
 * 编写一个函数，不用临时变量，直接交换numbers = [a, b]中a与b的值。
 * 示例：
 * 输入: numbers = [1,2]
 * 输出: [2,1]
 */

public class 面试题1601 {
    //加法
    public int[] swapNumbers(int[] numbers) {
        numbers[0] = numbers[0] + numbers[1];
        numbers[1] = numbers[0] - numbers[1];
        numbers[0] = numbers[0] - numbers[1];
        return numbers;
    }

    //减法
    public int[] swapNumbers1(int[] numbers) {
        numbers[0] = numbers[0] - numbers[1];
        numbers[1] = numbers[0] + numbers[1];
        numbers[0] = numbers[1] - numbers[0];
        return numbers;
    }

    //异或
    public int[] swapNumbers2(int[] numbers) {
        numbers[0] ^= numbers[1];
        numbers[1] ^= numbers[0];
        numbers[0] ^= numbers[1];
        return numbers;
    }
}
