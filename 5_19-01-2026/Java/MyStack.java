// Problem link: https://leetcode.com/problems/implement-stack-using-queues/

// You can send pull request of your solution (only 1st correct pr will get merged)

// Java code

import java.util.*;

class MyStack {

    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();

    public MyStack() {
        
    }
    
    public void push(int x) { // O(N)
        if(q1.isEmpty()) {
            q1.add(x);
            while(!q2.isEmpty()) {
                q1.add(q2.remove());
            }
        } else {
            q2.add(x);
            while(!q1.isEmpty()) {
                q2.add(q1.remove());
            }
        }
    }
    
    public int pop() { // O(1)
        if(empty()) {
            return -1;
        }

        int top = -1;

        if(!q1.isEmpty()) {
            top = q1.remove();
        } else {
            top = q2.remove();
        }

        return top;
    }
    
    public int top() { // O(1)
        if(empty()) {
            return -1;
        }

        int top = -1;

        if(!q1.isEmpty()) {
            top = q1.peek();
        } else {
            top = q2.peek();
        }

        return top;
    }
    
    public boolean empty() {
        return q1.isEmpty() && q2.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
