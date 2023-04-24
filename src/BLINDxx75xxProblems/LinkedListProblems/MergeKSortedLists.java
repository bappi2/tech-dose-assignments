package BLINDxx75xxProblems.LinkedListProblems;

import util.ListNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MergeKSortedLists {
    // https://leetcode.com/problems/merge-k-sorted-lists/
    // brute force
    public ListNode mergeKLists(ListNode[] lists) {
        List<Integer> mergedArray = new ArrayList<>();
        for (ListNode list : lists) {
            ListNode p1 = list;
            while (p1 != null) {
                mergedArray.add(p1.val);
                p1 = p1.next;
            }
        }
        Collections.sort(mergedArray);
        ListNode newHead = new ListNode(0);
        ListNode p = newHead;
        for (int n: mergedArray) {
            ListNode node = new ListNode(n);
            p.next = node;
            p = p.next;
        }
        return newHead.next;
    }

    // merge one node at a time
    public ListNode mergeKLists2(ListNode[] lists) {
        ListNode newHead = new ListNode(0);

        for (ListNode l: lists) {
            ListNode p = newHead.next;
            newHead.next = mergeTwoSortedList(p, l);
        }
        return newHead.next;
    }
    ListNode mergeTwoSortedList(ListNode l1, ListNode l2) {
        ListNode newhead = new ListNode(0);
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode p = newhead;
        while (p1 != null && p2 != null) {
            if (p1.val <= p2.val) {
                p.next = p1;
                p1 = p1.next;
            }
            else {
                p.next = p2;
                p2 = p2.next;
            }
            p = p.next;
        }
        if (p1 != null) {
            p.next = p1;
        }
        else {
            p.next = p2;
        }
        return newhead.next;
    }
    // devide and concur
    public ListNode mergeKLists3(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        int begin = 0;
        int end = lists.length -1;
        while (end > 0) {
            begin = 0;
            while (begin < end) {
                lists[begin] = mergeTwoSortedList(lists[begin], lists[end]);
                begin++;
                end--;
            }
        }
        return lists[0];

    }

}
