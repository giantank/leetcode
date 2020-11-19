package com.giantank.leetcode.algo.dp.longest_substring_with_at_least_k_repeating_characters_395;

public class Solution {
    public int longestSubstring(String s, int k) {
        if (s == null || s.length() < k) {
            return 0;
        }
        char[] chars = s.toCharArray();
        int p1 = 0;
        int p2 = chars.length - 1;
        int res = count(chars, k, p1, p2);
        return res;

    }
    private int count(char[] chars, int k, int p1, int p2) {
        if (p2 - p1 + 1 < k) {
            return 0;
        }
        int[] times = new int[26];
        for (int i = p1; i <= p2; i++) {
            times[chars[i] -'a'] += 1;
        }
        while ( p1 <= p2 && times[chars[p1] - 'a'] < k) {
            p1++;
        }
        while ( p2 >= p1 && times[chars[p2] - 'a'] < k) {
            p2--;
        }
        for (int i = p1; i <= p2; i++) {
            if (times[chars[i] - 'a'] < k) {
                return Math.max(count(chars, k, p1, i - 1),count(chars, k, i + 1, p2));
            }
        }
        return p2 - p1 + 1;
    }
    public static void main(String[] args) {
        String s = "ababacb";
        int k = 3;
        int res = new Solution().longestSubstring(s, k);
        System.out.println(res);
    }
}
