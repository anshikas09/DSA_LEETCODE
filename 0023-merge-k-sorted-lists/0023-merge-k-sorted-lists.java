/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode merge(ListNode list1, ListNode list2) {
        ListNode t1= list1;
        ListNode t2= list2;
        ListNode h= new ListNode(100);
        ListNode t= h;
        while(t1!= null && t2!=null){
            if(t1.val<t2.val){
                t.next=t1;
                t=t1;
                t1=t1.next;
            }else{
                t.next=t2;
                t=t2;
                t2=t2.next;
            }
        }
        if(t1==null){
            t.next=t2;
        }else{
            t.next=t1;
        }
        return h.next;
    }
    public ListNode mergesort(ListNode[]lists, int s, int e){
        // if(s>e) return null;
        if(s==e) return lists[s];
        if(s+1==e) return merge(lists[s],lists[e]);
        int m=s+(e-s)/2;
        ListNode l= mergesort(lists,s,m);
        ListNode r= mergesort(lists,m+1,e);
        return merge(l,r);
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null||lists.length==0) return null;
        return mergesort(lists,0,lists.length-1);
    }
}