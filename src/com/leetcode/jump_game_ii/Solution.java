package com.leetcode.jump_game_ii;

public class Solution {

    // https://leetcode.com/problems/jump-game-ii/description/
    public static void main(String[] args) {
        System.out.println(
                new Solution().jump(new int[] {2, 1}) // 1
//                new Main11().jump(new int[] {1, 1, 1, 1}) // 3
//                new Main11().jump(new int[] {3,4,3,2,5,4,3}) // 3
        );
    }

    public int jump(int[] nums) {
        if (nums.length <= 1) return 0;

        int steps = 0;
        int maxJump = 0;
        int currentEnd = Math.min(nums[0], nums.length - 1);

        for (int i = 0; i < nums.length; i++) {
            maxJump = Math.max(maxJump, i + nums[i]);

            if (i == currentEnd) {
                steps++;
                currentEnd = Math.min(maxJump, nums.length - 1);
            }
        }

        return steps;
    }

}
