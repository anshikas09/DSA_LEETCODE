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
    public ListNode reverseKGroup(ListNode head, int k) {
        int rev=k;
        ListNode temp=head;
        Stack<ListNode> st= new Stack<>();
        ListNode nw=new ListNode(0);
        ListNode ans=nw;
        while(temp!=null){
            ListNode prev=temp;
            while(rev-->0 && temp!=null){
                st.push(temp);
                temp=temp.next;
            }
            if(st.size()!=k){
                nw.next=prev;
                return ans.next;
            }
            rev=k;
            while(!st.isEmpty()){
                nw.next=st.pop();
                nw=nw.next;
            }
            nw.next=temp;
        }
        return ans.next;
    }
}