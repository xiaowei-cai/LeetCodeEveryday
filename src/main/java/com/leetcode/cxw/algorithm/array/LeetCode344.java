package com.leetcode.cxw.algorithm.array;

/**
 * 【反转字符串】
 * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
 *
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 *
 * 你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class LeetCode344 {
    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;
        char temp;
        while (left < right) {
            temp = s[left];
            s[left++] = s[right];
            s[right--] = temp;
        }
    }

    public String reverseString1(String s) {
        int right = s.length() - 1;
        StringBuilder sb = new StringBuilder();
        for (int i = right; i >= 0; i--) {
            sb.append(s.charAt(right));
            right--;
        }
        return sb.toString();
    }

    public String reverseString2(String s) {
        StringBuilder sb = new StringBuilder(s);
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            char tmp = sb.charAt(left);
            sb.setCharAt(left++, sb.charAt(right));
            sb.setCharAt(right--, tmp);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode344().reverseString2("cxw"));
    }
}
