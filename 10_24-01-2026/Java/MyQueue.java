// Problem link: https://leetcode.com/problems/implement-queue-using-stacks/description/

// You can send pull request of your solution (only 1st correct pr will get merged)

// java code

import java.util.*;

class MyQueue {

    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    public MyQueue() {

    }
    
    public void push(int x) { // O(N)
        while(!s1.empty()) {
            s2.push(s1.pop());
        }
        s2.push(x);
        while(!s2.empty()) {
            s1.push(s2.pop());
        }
    }
    
    public int pop() { // O(1)
        if(empty()) return -1;
        
        return s1.pop();
    }
    
    public int peek() { // O(1)
        if(empty()) return -1;

        return s1.peek();
    }
    
    public boolean empty() { // O(1)
        return s1.empty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
