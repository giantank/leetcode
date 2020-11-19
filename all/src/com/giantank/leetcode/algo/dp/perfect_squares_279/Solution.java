package com.giantank.leetcode.algo.dp.perfect_squares_279;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int numSquares(int n) {
        if (n < 1) {
            return 0;
        }
        List<Integer> squals = new ArrayList<Integer>();
        for (int i = 1; i <= Math.sqrt(n); i++) {
            squals.add(i * i);
        }
        return minNum(n, squals);
    }

    private int minNum(int reside, List<Integer> squals) {
        for ( Integer squal : squals) {
            if (reside == squal) {
                return 1;
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < squals.size(); i++) {
            if (reside < squals.get(i)) {
                break;
            }
            int newMin = minNum(reside - squals.get(i), squals) + 1;
            min = Math.min(newMin, min);
        }
        return min;
    }

    public static void main(String[] args) {
        int n = 555;
        int res = new Solution().numSquares(n);
        System.out.println(res);
    }
}
