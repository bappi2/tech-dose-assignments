package BLINDxx75xxProblems.LinkedListProblems;

public class ReverseLinkedListBetween {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode prev = dummyHead;
        for (int i = 1; i < left; i++) {
            prev = prev.next;
        }
        ListNode end = prev;
        for (int i = left; i <= right; i++) {
            end = end.next;
        }
        prev = reverseRange(prev, end.next);
        return dummyHead.next;
    }

    ListNode reverseRange(ListNode prev, ListNode next) {
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
