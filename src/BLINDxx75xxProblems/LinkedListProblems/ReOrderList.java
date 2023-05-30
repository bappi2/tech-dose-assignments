package BLINDxx75xxProblems.LinkedListProblems;

public class ReOrderList {
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode secondHalf = slow.next;
        slow.next = null;

        secondHalf = reverse(secondHalf);

        ListNode p1 = head;
        ListNode p2 = secondHalf;
        // merge
        ListNode dummyHead = new ListNode(0);
        ListNode p = dummyHead;

        while (p1 != null && p2 != null) {
            ListNode save = p1.next;
            p.next = p1;
            p1 = save;
            p = p.next;
            save = p2.next;
            p.next = p2;
            p2 = save;
            p = p.next;
        }
        if (p1 != null)
        {
            p.next = p1;
        }
        head =  dummyHead.next;

    }

    ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    ListNode reverse (ListNode head) {
        ListNode result = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode save = curr.next;

            curr.next = result;
            result = curr;

            curr = save;
        }
        return result;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        ReOrderList rol = new ReOrderList();
        rol.reorderList(head);
        System.out.println(head.val +" "  + head.next.val);
    }
}
