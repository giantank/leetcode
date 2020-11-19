package com.giantank.leetcode.algo.divdeConquer.find_k_closest_elements_658;

import java.math.BigDecimal;
import java.util.*;

/**
 * 给定一个排序好的数组，两个整数 k 和 x，从数组中找到最靠近 x（两数之差最小）的 k 个数。返回的结果必须要是按升序排好的。如果有两个数与 x 的差值一样，优先选择数值较小的那个数。
 *
 * 示例 1:
 *
 * 输入: [1,2,3,4,5], k=4, x=3
 * 输出: [1,2,3,4]
 *  
 *
 * 示例 2:
 *
 * 输入: [1,2,3,4,5], k=4, x=-1
 * 输出: [1,2,3,4]
 *  
 *
 * 说明:
 *
 * k 的值为正数，且总是小于给定排序数组的长度。
 * 数组不为空，且长度不超过 104
 * 数组里的每个元素与 x 的绝对值不超过 104
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-k-closest-elements
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res = new ArrayList<>();
        if (arr == null || arr.length < 1) {
            return res;
        }
        List<Tuple> abs = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            double val = Math.abs(arr[i] - x);
            Tuple t = new Tuple(i, val);
            abs.add(t);
        }
        Collections.sort(abs, new Comparator<Tuple>() {
            @Override
            public int compare(Tuple o1, Tuple o2) {
                BigDecimal b1 = new BigDecimal(o1.getVal());
                BigDecimal b2 = new BigDecimal(o2.getVal());
                if (b1.compareTo(b2) > 0) {
                    return 1;
                } else if (b1.compareTo(b2) < 0) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
        for (int i = 0; i < k; i++) {
            Tuple t = abs.get(i);
            res.add(arr[t.getIndex()]);
        }
        Collections.sort(res);
        return res;
    }
    public static void main(String[] args) {
        int[] arr = {};
        int k = 4;
        int x = 3;
        System.out.println(new Solution().findClosestElements(arr,k,x));
    }
}
class Tuple {
    private  int index;
    private double val;

    public Tuple(int index, double val) {
        this.index = index;
        this.val = val;
    }
    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public double getVal() {
        return val;
    }

    public void setVal(double val) {
        this.val = val;
    }
}
