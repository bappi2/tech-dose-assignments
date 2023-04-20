package BLINDxx75xxProblems.StackQueueProblems;

public class MinStackPair {
    Stack<Pair> stack;

    public MinStackPair() {
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
        public int key;
        public int val;
        Pair (int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
}
