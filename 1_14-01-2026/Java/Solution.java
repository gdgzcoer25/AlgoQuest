// Problem Link: https://leetcode.com/problems/powx-n/

// You can send pull request of your solution (Only correct and 1st pull request will be accepted)

class Solution {
    public double helper(double x, long n) {
        if(n == 0) {
            return 1.0;
        }
        double half = helper(x, n/2);
        if(n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }

    public double myPow(double x, int n) {
        long N = n;
        if(n < 0) {
            x = 1 / x;
            N = -N;
        }
        return helper(x, N);
    }
}
