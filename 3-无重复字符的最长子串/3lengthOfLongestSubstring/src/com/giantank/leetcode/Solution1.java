package com.giantank.leetcode;

import java.util.HashSet;
import java.util.Set;

public class Solution1 {
    public int lengthOfLongestSubstring(String s) {
        int maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length() + 1; j++) {
                String substr = s.substring(i,j);
                if (isAllUniue(substr) && (substr.length() > maxLen)) {
                    maxLen = substr.length();
                }
            }
        }
        return maxLen;
    }

    public boolean isAllUniue(String s) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (set.contains(s.charAt(i))) {
                return false;
            } else {
                set.add(s.charAt(i));
            }
        }
        return true;
    }
    public static void main (String[] args) {
        System.out.println(new Solution1().lengthOfLongestSubstring("abcabcbb"));
    }
}
