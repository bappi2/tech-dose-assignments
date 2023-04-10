package BLINDxx75xxProblems.StackQueueProblems;

import StackQueue.Stack;

public class MinStack {

        private Stack<Integer> stack;
        private Stack<Integer> minStack;

        /** initialize your data structure here. */
        public MinStack() {
            stack = new Stack<>();
            minStack = new Stack<>();
        }

        public void push(int x) {
            stack.push(x);
            if (minStack.isEmpty() || x <= minStack.peek()) {
                minStack.push(x);
            }
        }

        public void pop() {
            if (stack.pop().equals(minStack.peek())) {
                minStack.pop();
            }

        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }

        ///////////////////

    class MinStack2 {
        Stack<Pair> stack;

        public MinStack() {
            stack = new Stack<>();



        }

        public void push(int val) {
            if (stack.isEmpty()) {
                Pair pair = new Pair(val, val);
                stack.push(pair);
            }
            else {
                Pair top = stack.peek();
                if (top.val > val) {
                    Pair pair = new Pair(val, val);
                    stack.push(pair);
                }
                else {
                    stack.push(new Pair(val, top.val));
                }
            }
        }

        public void pop() {
            stack.pop();

        }

        public int top() {
            return stack.peek().key;
        }

        public int getMin() {
            return stack.peek().val;
        }
        class Pair {
            int key;
            int val;
            Pair (int key, int val) {
                this.key = key;
                this.val = val;
            }
        }
    }
}

