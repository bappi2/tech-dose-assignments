package BLINDxx75xxProblems.LinkedListProblems;

import java.util.HashMap;
import java.util.Map;

public class CopyListwithRandomPointer {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return head;
        }
        Node newHead = new Node (head.val);
        Map<Node, Node> map = new HashMap<>();
        map.put(head, newHead);

        Node p = head.next;
        Node newP = newHead;
        while (p != null) {
            Node copy = new Node(p.val);
            newP.next = copy;
            map.put(p, copy);

            p = p.next;
            newP = newP.next;
        }

        p = head;
        while (p != null) {
            Node randP = p.random;
            Node copyOfP = map.get(p);

            if (randP != null) {
                copyOfP.random = map.get(randP);
            }
            p = p.next;
        }
        return newHead;
    }
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
