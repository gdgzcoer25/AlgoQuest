// Problem link: https://leetcode.com/problems/evaluate-reverse-polish-notation/description/

// You can create pull request of your solution (only 1st correct pr will get merged)

// Java code
import java.util.Stack;

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            if (token.equals("+") || token.equals("-") 
                || token.equals("*") || token.equals("/")) {

                int y = stack.pop();  
                int x = stack.pop();  

                int result = 0;
                switch (token) {
                    case "+":result = x + y;break;
                    case "-":result = x - y;break;
                    case "*":result = x * y;break;
                    case "/":result = x / y;break; 
                    // "/" -> int 5.2 ->5 truncates toward zero
                }
                stack.push(result);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
}
// By komal Mhaske
