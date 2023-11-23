package LeetCode.Contest_All.双周赛.双周赛92.题1;

class Solution {
    public int numberOfCuts(int n) {
        if (n == 1) return 0;
        if (n % 2 != 0) return n;
        else return n / 2;
    }
}