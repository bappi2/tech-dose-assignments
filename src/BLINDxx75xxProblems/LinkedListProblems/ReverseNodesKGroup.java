package BLINDxx75xxProblems.LinkedListProblems;

public class ReverseNodesKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k == 1) {
            return head;
        }
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        ListNode prev = dummyHead;
        ListNode curr = head;
        int counter = 0;

        while (curr != null) {
            counter++;
            if (counter % k == 0) {
                prev = reverseRange(prev, curr.next);
                curr = prev.next;
            }
            else {
                curr = curr.next;
            }
        }
        return dummyHead.next;
    }
    private ListNode reverseRange(ListNode prev, ListNode next) {
        ListNode last = prev.next;
        ListNode curr = last.next;
        while (curr != next) {
            last.next = curr.next;
            curr.next = prev.next;
            prev.next = curr;
            curr = last.next;
        }
        return last;
    }
}
