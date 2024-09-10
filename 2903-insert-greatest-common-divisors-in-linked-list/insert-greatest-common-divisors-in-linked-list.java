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
    public int gcd(int a,int b){
        if(b==0){
            return a;
        }
        return gcd(b,a%b);
    }
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        if(head==null){
            return null;
        }
        if(head.next==null){
            int temp=head.val;
            return head.next=new ListNode(temp);
        }
        ListNode curr=head;
        ListNode next=curr.next;
        while(curr!=null && next!=null){
           ListNode prev=null;
           int val= gcd(curr.val,next.val);
           prev=new ListNode(val);
           prev.next=next;
           curr.next=prev;
           curr=next;
           next=next.next;
        }
        return head;
    }
}