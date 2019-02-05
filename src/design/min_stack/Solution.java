package design.min_stack;

import java.util.Deque;
import java.util.LinkedList;

// min stack
// https://leetcode.com/explore/interview/card/top-interview-questions-easy/98/design/562/
class MinStack {

    private Deque<Item> stack;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new LinkedList<>();
    }

    public void push(int x) {
        if (stack.size() == 0) stack.addFirst(new Item(x, x));
        else stack.addFirst(new Item(x, Math.min(x, stack.getFirst().min)));
    }

    public void pop() {
        stack.removeFirst();
    }

    public int top() {
        return stack.getFirst().value;
    }

    public int getMin() {
        return stack.getFirst().min;
    }

    class Item {
        int value;
        int min;

        Item(int value, int min) {
            this.value = value;
            this.min = min;
        }
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */