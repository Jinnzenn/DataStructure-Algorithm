//LeetCode 357 Count Numbers with Unique Digits 
/*
考虑一位数的情况，有10个，分别是0-9。
考虑两位数的情况，十位上只能从1-9中选择，个位上是从0-9中不同于十位数的剩下9个数中选择：9×9=81
考虑三位数的情况，百位上有9种选择，十位有9种（除去百位上的数），个位有8种（除去百位跟十位的数）：9×9×8=648
如此类推：对于n位的数，第n位有9种选择，第n-i位有9-i种选择。
*/

class Solution {
    public int countNumbersWithUniqueDigits(int n)
    {
        int unique = 10;
        int multi = 9;

        for (int i = 1; i < n; i++) {
            multi *= (10-i);
            unique += multi;
        }

        return !n ? 1: unique;
    }
};
