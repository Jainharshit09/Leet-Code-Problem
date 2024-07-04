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
    public ListNode mergeNodes(ListNode head) {
        ListNode curr=head.next;
        ListNode prev=new ListNode(-1);
        ListNode temp=prev;
        while(curr!=null){
            int ans=0;
            while(curr!=null&&curr.val!=0){
                ans+=curr.val;
                curr=curr.next;
            }
            temp.next=new ListNode(ans);
            temp=temp.next;
             if (curr != null) {
                curr = curr.next;  // skip the 0 node
            }
        }
        return prev.next;
    }
}