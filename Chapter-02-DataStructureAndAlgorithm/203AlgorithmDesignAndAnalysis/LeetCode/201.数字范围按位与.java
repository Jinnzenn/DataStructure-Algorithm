/*
 * @lc app=leetcode.cn id=201 lang=java
 *
 * [201] 数字范围按位与
 */

// @lc code=start
class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        /**
         * 
         * 当left和right的二进制位数不同时,直接返回0即可 
         * 当left和right的二进制位数相同时，找出最高位的1
         * 
         */
        // return solutionA(left, right);
        return solutionB(left, right);
    }

    /**
     * 常规解法
     */
    private int solutionA(int leftNum, int rightNum) {

        while (rightNum > leftNum) {
            rightNum = rightNum & (rightNum - 1);
        }
        return rightNum;
    }

    private int solutionB(int leftNum, int rightNum) {
        int zeros = 0;
        while (rightNum > leftNum) {
            zeros++;
            rightNum >>>= 1;
            leftNum >>>= 1;
        } // 将 0 的个数空出来
        return leftNum << zeros;

    }
}
// @lc code=end

