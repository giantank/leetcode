package com.giantank.leetcode.string.compress_string_lcci_615;

public class Solution {
    public String compressString(String S) {
        if (S == null || S.length() < 2) {
            return S;
        }
        char pre = S.charAt(0);
        //char next = S.charAt(1);
        int count = 1;
        StringBuffer sb = new StringBuffer();
        for (int i = 1; i < S.length(); i++) {
            char next = S.charAt(i);
            if (next == pre) {
                count++;
            } else {
                sb.append(pre).append(count);
                pre = next;
                count = 1;
            }
        }
        sb.append(pre).append(count);
        if (sb.length() >= S.length()) {
            return S;
        } else {
            return sb.toString();
        }
    }
    public static void main(String[] args) {
        String s = "aa";
        System.out.println(new Solution().compressString(s));
    }
}
