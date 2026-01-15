// You can send pull request of your solution (Only correct and 1st pull request will be accepted)

// Java Code

// This method uses monotonic Stack
class Solution { // O(N)
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;

        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < n; i++) {
            while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int prev = stack.pop();
                ans[prev] = i - prev;
            }
            stack.push(i);
        }
        
        return ans;
    }
}


// for better understanding of problem see brute force
// Brute Force: Gives Time Limit Exceeded error 
// class Solution {
//     public int[] dailyTemperatures(int[] temperatures) {
//         int n = temperatures.length;

//         int[] ans = new int[n];
        
//         for(int i = 0; i < n - 1; i++) {
//             int days = 0;
//             int j = i + 1;
//             while(j < n && temperatures[i] >= temperatures[j]) {
//                 j++;
//             }

//             if(j != n) {
//                 days = j - i;
//             }

//             ans[i] = days;
//         }

//         return ans;
//     }
// }
