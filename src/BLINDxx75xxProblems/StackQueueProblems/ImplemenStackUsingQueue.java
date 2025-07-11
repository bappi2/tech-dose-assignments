package BLINDxx75xxProblems.StackQueueProblems;

import java.util.LinkedList;
import java.util.Queue;
public class ImplemenStackUsingQueue {
        private Queue<Integer> q1 = new LinkedList<>();
        private Queue<Integer> q2 = new LinkedList<>();
        private int currSize = 0;

        public void push(int x) {
            currSize++;
            q2.add(x);

            while (!q1.isEmpty()) {
                q2.add(q1.poll());
            }

            Queue<Integer> temp = q1;
            q1 = q2;
            q2 = temp;
        }

        public void pop() {
            if (q1.isEmpty()) {
                return;
            }
            q1.poll();
            currSize--;
        }

        public int top() {
            if (q1.isEmpty()) {
                return -1;
            }
            return q1.peek();
        }

        public int size() {
            return currSize;
        }

    public class Main {
        public static void main(String[] args) {
            ImplemenStackUsingQueue s = new ImplemenStackUsingQueue();
            s.push(1);
            s.push(2);
            s.push(3);

            System.out.println("current size: " + s.size());
            System.out.println(s.top());
            s.pop();
            System.out.println(s.top());
            s.pop();
            System.out.println(s.top());

            System.out.println("current size: " + s.size());
        }
    }
}