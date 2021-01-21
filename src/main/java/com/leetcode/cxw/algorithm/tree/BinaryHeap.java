package com.leetcode.cxw.algorithm.tree;

import java.util.Arrays;

/**
 * 二叉堆：本质上是一个完全二叉树，它分为两个类型：
 * 1、最大堆：任何一个父节点的值，都大于或等于它左、右孩子节点的值
 * 2、最小堆：任何一个父节点的值，都小于或等于它左、右孩子节点的值
 * 二叉堆的根节点叫做：堆顶
 * 最大堆的堆顶是整个堆中的最大元素
 * 最小堆的堆顶是整个堆中的最小元素
 * 关于二叉堆，有如下几种操作：
 * 1、插入节点
 * 2、删除节点
 * 3、构建二叉堆
 * ps：二叉堆虽然是一个完全二叉树，但它的存储方式并不是链式存储，而是顺序存储。换句话说，二叉堆的所有节点都存储在数组中
 *
 * @author caixiaowei
 * @date 2020/11/14 11:58
 */

/**
 * 以最大堆为例
 */

public class BinaryHeap {
    /**
     * 上浮节点 时间复杂度O(logN)
     * 插入新节点时，插入位置是完全二叉树的最后一个位置，与父节点比较，大于父节点则上浮
     *
     * @param array 数据数组
     */
    public static void upAdjust(int[] array) {
        // 先求出父子节点的下标
        int childrenIndex = array.length - 1;
        int parentIndex = (childrenIndex - 1) / 2;
        // 记录子节点数据，用于最后赋值
        int temp = array[childrenIndex];
        // 开始上浮
        while (childrenIndex > 0 && temp > array[parentIndex]) {
            // 直接单向赋值，无需做交换操作
            array[childrenIndex] = array[parentIndex];
            // 更新父子节点下标的值，下面两句代码顺序不可相反
            childrenIndex = parentIndex;
            parentIndex = (parentIndex - 1) / 2;
        }
        // 最后赋值
        array[childrenIndex] = temp;
    }

    /**
     * 下沉节点 时间复杂度O(logN)
     * 删除节点时，所删除的是处于堆顶的节点，这时为了继续维持完全二叉树的结构，我们把堆的最后一个节点临时补到原本堆顶的位置，
     * 接下来让暂处堆顶位置的节点和他的左右孩子进行比较，如果左右孩子节点中最小的一个比堆顶位置的值小，那么让堆顶位置的值下沉。
     *
     * @param index 要下沉的节点的下标
     * @param array 数据数组
     */
    public static void downAdjust(int index, int[] array) {
        // 先记录父节点及左子节点的下标
        int parentIndex = index;
        int childrenIndex = 2 * parentIndex + 1;
        // 记录父节点的值，用于最后赋值
        int temp = array[parentIndex];
        // 若有左子节点则继续
        while (childrenIndex <= array.length - 1) {
            // 若有右子节点，且右子节点比左子节点大，则将 childrenIndex 记录为右子节点的下标
            if (childrenIndex + 1 <= array.length - 1 && array[childrenIndex + 1] > array[childrenIndex]) {
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

    /**
     * 构建二叉堆
     *
     * @param array 数据数组
     */
    public static void buildBinaryHeap(int[] array) {
        for (int i = (array.length / 2) - 1; i >= 0; i--) {
            downAdjust(i, array);
        }
    }

    public static void main(String[] args) {
        // 构建二叉堆
        int[] arr01 = {5, 3, 6, 9, 8, 6, 7, 2, 4, 6, 3};
        buildBinaryHeap(arr01);
        System.out.println(Arrays.toString(arr01));
        // 添加一个数据，测试上浮操作
        int[] arr02 = {9, 8, 7, 4, 6, 6, 6, 2, 3, 5, 3, 20};
        upAdjust(arr02);
        System.out.println(Arrays.toString(arr02));
        // 删除一个数据，测试下沉操作
        int[] arr03 = {3, 8, 7, 4, 6, 6, 6, 2, 3, 5};
        downAdjust(0, arr03);
        System.out.println(Arrays.toString(arr03));
    }
}
