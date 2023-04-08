package BLINDxx75xxProblems.HeapProblems;

import util.ListNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MergeKSortedList {
    //TC: O(nlogn)
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists==null || lists.length==0) return null;

        ListNode head=new ListNode(0);
        ListNode temp=head;
        List<Integer> l=new ArrayList<>();
        for(ListNode list:lists){
            while(list!=null){
                l.add(list.val);
                list=list.next;
            }
        }
        Collections.sort(l);
        for(int val:l){
            temp.next=new ListNode(val);
            temp=temp.next;
        }
        return head.next;
    }

    // https://www.techiedelight.com/efficiently-merge-k-sorted-linked-lists/
}
