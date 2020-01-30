package com.giantank.leetcode;

import java.util.HashSet;
import java.util.Set;

public class Solution2 {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int i = 0;
        int j = 0;
        int ans = 0;
        int n = s.length();
        Set<Character> set = new HashSet<>();
        while (i < n && j < n) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(new Solution2().lengthOfLongestSubstring("pwwkew"));
    }
}
