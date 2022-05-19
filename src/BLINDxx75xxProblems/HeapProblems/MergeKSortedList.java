package BLINDxx75xxProblems.HeapProblems;

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
}
