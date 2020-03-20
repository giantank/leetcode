package com.giantank.leetcode.algo.greedy.assign_cookies_455;

import java.util.Arrays;

public class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int count = 0;
        int gLen = g.length;
        int sLen = s.length;
        Arrays.sort(g);
        Arrays.sort(s);
        int gIndex = 0;
        int sIndex = 0;
        while (gIndex < gLen &&  sIndex < sLen) {
            if (s[sIndex] >= g[gIndex]) {
                count++;
                gIndex++;
            }
            sIndex++;
        }
        return count;
    }
    public static void main(String[] args) {
        int[] g = new int[]{10, 9, 8, 7};
        int[] s = new int[]{5, 6, 7, 8};
        int result = new Solution().findContentChildren(g, s);
        System.out.println("result:" + result);
    }
}
