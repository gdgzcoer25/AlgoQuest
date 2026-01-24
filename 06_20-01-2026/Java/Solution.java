// Problem link: https://leetcode.com/problems/bitwise-and-of-numbers-range/

// You can send pull request of your solution (only 1st correct pr will get merged)

// Java code

class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        int cnt = 0;

        while(left != right) {
            left >>= 1; // shift both to right by 1 
            right >>= 1; // until we find its common prefix
            cnt++; // counts shifted bits
        } // finds common prefix which will never change

        return (left << cnt); // replace all non common prefix part by 0
    }
}

// TC: O(32)
