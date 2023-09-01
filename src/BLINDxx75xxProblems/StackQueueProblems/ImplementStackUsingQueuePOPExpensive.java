package BLINDxx75xxProblems.StackQueueProblems;
import java.util.LinkedList;
import java.util.Queue;

class ImplementStackUsingQueuePOPExpensive {
        private Queue<Integer> q1 = new LinkedList<>();
        private Queue<Integer> q2 = new LinkedList<>();
        private int currSize;

        public ImplementStackUsingQueuePOPExpensive() {
            currSize = 0;
        }

        public void pop() {
            if (q1.isEmpty()) {
                return;
            }

            while (q1.size() != 1) {
                q2.add(q1.poll());
            }

            q1.poll();
            currSize--;

            Queue<Integer> temp = q1;
            q1 = q2;
            q2 = temp;
        }

        public void push(int x) {
            q1.add(x);
            currSize++;
        }

        public int top() {
            if (q1.isEmpty()) {
                return -1;
            }

            while (q1.size() != 1) {
                q2.add(q1.poll());
            }

            int temp = q1.peek();
            q1.poll();
            q2.add(temp);

            Queue<Integer> tempQueue = q1;
            q1 = q2;
            q2 = tempQueue;

            return temp;
        }

        public int size() {
            return currSize;
        }
    }

     /*class Main {
        public static void main(String[] args) {
            ImplementStackUsingQueuePOPExpensive s = new ImplementStackUsingQueuePOPExpensive();
            s.push(1);
            s.push(2);
            s.push(3);
            s.push(4);

            System.out.println("current size: " + s.size());
            System.out.println(s.top());
            s.pop();
            System.out.println(s.top());
            s.pop();
            System.out.println(s.top());
            System.out.println("current size: " + s.size());
        }
    }*/
