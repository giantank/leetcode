package com.giantank.leetcode.algo.greedy.lemonade_change_860;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean lemonadeChange(int[] bills) {
        if (bills == null || bills.length < 1) {
            return false;
        }
        if (bills[0] != 5) {
            return false;
        }
        Map<Integer, Integer> map = new HashMap<>();
        map.put(5, 0);
        map.put(10, 0);
        map.put(20, 0);
        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                Integer fiveNum = map.get(5);
                map.put(5, fiveNum + 1);
            } else if (bills[i] == 10) {
                Integer fiveNum = map.get(5);
                if (fiveNum == 0) {
                    return false;
                }
                map.put(5, fiveNum - 1);
                Integer tenNum = map.get(10);
                map.put(10, tenNum + 1);
            } else if (bills[i] == 20) {
                Integer tenNum = map.get(10);
                if (tenNum < 1) {
                    Integer fiveNum = map.get(5);
                    if (fiveNum < 3) {
                        return false;
                    }
                    map.put(5, fiveNum - 3);
                } else {
                    Integer fiveNum = map.get(5);
                    if (fiveNum < 1) {
                        return false;
                    }
                    map.put(5, fiveNum - 1);
                    map.put(10, tenNum - 1);
                }
            }
        }
        return true;
    }
}
