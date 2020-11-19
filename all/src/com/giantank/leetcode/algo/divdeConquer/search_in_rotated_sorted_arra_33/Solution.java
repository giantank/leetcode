package com.giantank.leetcode.algo.divdeConquer.search_in_rotated_sorted_arra_33;

/**
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * <p>
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * <p>
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 * <p>
 * 你可以假设数组中不存在重复的元素。
 * <p>
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 * 示例 2:
 * <p>
 * 输入: nums = [4,5,6,7,0,1,2], target = 3
 * 输出: -1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length < 1) {
            return -1;
        }
        if (nums.length == 1 && nums[0] == target) {
            return 0;
        }
        if (nums.length == 1 && nums[0] != target) {
            return -1;
        }
        int len = nums.length;
        int index = 0;
        for (int i = len - 2; i >= 0 && (nums[len - 1] < nums[0]); i--) {
            if (nums[i] >= nums[0]) {
                index = i + 1;
                break;
            }
        }
        int left = 0;
        int right = len - 1;
        if (index != 0) {
            if (nums[0] < target) {
                right = index - 1;
            } else if (nums[0] > target) {
                left = index;
            } else {
                return 0;
            }
        }
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target ) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return - 1;
    }
    public static void main(String[] args) {
        int[] nums = {3,1};
        int target = 1;
        System.out.println(new Solution().search(nums,target));
    }
}
