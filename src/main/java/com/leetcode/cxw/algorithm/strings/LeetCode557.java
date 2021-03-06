package com.leetcode.cxw.algorithm.strings;

/**
 * 【反转字符串中的单词III】
 * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 * 示例：
 * 输入："Let's take LeetCode contest"
 * 输出："s'teL ekat edoCteeL tsetnoc"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-words-in-a-string-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class LeetCode557 {
    public String reverseWords(String s) {
        int n = s.length();
        int start = 0;
        int end = 0;
        StringBuilder sb = new StringBuilder(s);
        while (start < n) {
            while (end < n && s.charAt(end) != ' ') {
                end++;
            }
            reverse(sb, start, end - 1);
            start = end + 1;
            ++end;
        }
        return sb.toString();
    }

    //翻转字符串
    private void reverse(StringBuilder sb, int left, int right) {
        while (left < right) {
            char tmp = sb.charAt(left);
            sb.setCharAt(left++, sb.charAt(right));
            sb.setCharAt(right--, tmp);
        }
    }
}
