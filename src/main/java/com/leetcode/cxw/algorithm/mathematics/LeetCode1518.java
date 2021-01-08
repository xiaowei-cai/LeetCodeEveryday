package com.leetcode.cxw.algorithm.mathematics;

/**
 * 【换酒问题】
 * 小区便利店正在促销，用 numExchange 个空酒瓶可以兑换一瓶新酒。你购入了 numBottles 瓶酒。
 *
 * 如果喝掉了酒瓶中的酒，那么酒瓶就会变成空的。
 *
 * 请你计算最多能喝到多少瓶酒。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/water-bottles
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class LeetCode1518 {
    public int numWaterBottles(int numBottles, int numExchange) {
        int emptyBottles = numBottles;
        int sumDrink = numBottles;
        while (emptyBottles >= numExchange) {
            emptyBottles -= numExchange;
            emptyBottles++;
            sumDrink++;
        }
        return sumDrink;
    }
}
